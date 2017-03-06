package ns.learning.patterns.objectpool

import spock.lang.Ignore
import spock.lang.Specification

class ConnectionPoolImplementationTest extends Specification {

    def "Use a single connection at a time"() {

        given:
        ConnectionPoolImplementation threadPoolImplementation = ConnectionPoolImplementation.instance

        when:
        ReusableConnection reusableConnection1 = threadPoolImplementation.acquireConnection()

        reusableConnection1.sendMessage()

        threadPoolImplementation.releaseConnection(reusableConnection1)

        ReusableConnection reusableConnection2 = threadPoolImplementation.acquireConnection()

        reusableConnection2.sendMessage()

        threadPoolImplementation.releaseConnection(reusableConnection2)

        ReusableConnection reusableConnection3 = threadPoolImplementation.acquireConnection()

        reusableConnection3.sendMessage()

        threadPoolImplementation.releaseConnection(reusableConnection3)


        then:
        reusableConnection1 == reusableConnection2
        reusableConnection2 == reusableConnection3
    }


    def "Use two connections at a time"() {

        given:
        ConnectionPoolImplementation threadPoolImplementation = ConnectionPoolImplementation.instance

        when:
        ReusableConnection reusableConnection1 = threadPoolImplementation.acquireConnection()

        reusableConnection1.sendMessage()

        //threadPoolImplementation.releaseConnection(reusableConnection1)

        ReusableConnection reusableConnection2 = threadPoolImplementation.acquireConnection()

        reusableConnection2.sendMessage()

        threadPoolImplementation.releaseConnection(reusableConnection2)

        ReusableConnection reusableConnection3 = threadPoolImplementation.acquireConnection()

        reusableConnection3.sendMessage()

        threadPoolImplementation.releaseConnection(reusableConnection3)


        then:
        reusableConnection1 != reusableConnection2
        reusableConnection2 == reusableConnection3
    }

    @Ignore
    def "Use three connections at a time"() {

        given:
        ConnectionPoolImplementation threadPoolImplementation = ConnectionPoolImplementation.instance
        final timeToWaitLow = 500
        final timeToWaitHigh = 1000

        when:
        final ReusableConnection reusableConnection1 = threadPoolImplementation.acquireConnection()
        final ReusableConnection reusableConnection2 = threadPoolImplementation.acquireConnection()

        new Thread(new Runnable() {
            @Override
            void run() {
                Thread.sleep(timeToWaitLow)

                threadPoolImplementation.releaseConnection(reusableConnection1)
            }
        }).start()


        new Thread(new Runnable() {
            @Override
            void run() {
                Thread.sleep(timeToWaitHigh)

                threadPoolImplementation.releaseConnection(reusableConnection2)
            }
        }).start()

        long time1 = System.currentTimeMillis()
        ReusableConnection reusableConnection3 = threadPoolImplementation.acquireConnection()
        long time2 = System.currentTimeMillis()

        long timeToAcquireConnection = time2 - time1
        println timeToAcquireConnection + "ms"

        then:
        timeToAcquireConnection >= 400
        timeToAcquireConnection < 600
        reusableConnection1 != reusableConnection2
        reusableConnection1 == reusableConnection3
    }
}
