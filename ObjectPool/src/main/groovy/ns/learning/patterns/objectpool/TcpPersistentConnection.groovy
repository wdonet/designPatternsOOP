package ns.learning.patterns.objectpool

class TcpPersistentConnection implements ReusableConnection {

    TcpPersistentConnection() {
        println "Connect to server"
    }

    void sendMessage() {
        println "Send message from instance: " + hashCode()
    }

    String getMessage() {
        println "Receive message using instance: " + hashCode()

        return "some message";
    }

}
