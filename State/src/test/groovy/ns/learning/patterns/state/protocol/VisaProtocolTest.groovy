package ns.learning.patterns.state.protocol

import ns.learning.patterns.state.visa.protocol.VisaProtocolServer
import spock.lang.Specification

class VisaProtocolTest extends Specification {

    def "Receiving a well formed command"() {
        given:
        InputStream is = Mock(InputStream.class)

        is.read() >>> [2, 0x43, 0x30, 3, 0x70, 0x15, 6]

        OutputStream os = new ByteArrayOutputStream()
        VisaProtocolServer visaProtocolServer = new VisaProtocolServer(is, os)
        byte []expectedResponse = [6, 2, 0x43,  0x31, 3, 0x71, 2, 0x43, 0x31, 3, 0x71] as byte[]

        when:
        Thread t = new Thread(visaProtocolServer)

        t.start()

        Thread.currentThread().sleep(500)

        then:
        byte[] result = os.toByteArray()
        boolean success = true

        for (int i = 0 ; i < result.length && expectedResponse.length; i++){
            success &= (result[i] == expectedResponse[i])
        }

        success

    }
}
