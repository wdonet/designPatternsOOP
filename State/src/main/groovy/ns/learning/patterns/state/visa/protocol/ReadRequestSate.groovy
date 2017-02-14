package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.exception.BadLrcException
import ns.learning.patterns.state.visa.exception.VisaMessageException
import ns.learning.patterns.state.visa.parser.MessageValidState

@Singleton
class ReadRequestSate implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "ReadRequestSate"

        int data = is.read()

        try {
            visaProtocolServer.visaParser.write(visaProtocolServer.visaRequest, (byte) data)

            if (visaProtocolServer.visaParser.currentState instanceof MessageValidState) {
                visaProtocolServer.currentState = SendAckState.instance
            }
        } catch (BadLrcException ex) {

            println "**BadLrcException**"

            visaProtocolServer.currentState = SendNakState.instance
        } catch (VisaMessageException ex) {

            println "**VisaMessageException**"

            visaProtocolServer.currentState = VisaProtocolInitialization.instance
        }


    }
}
