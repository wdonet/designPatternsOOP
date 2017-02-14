package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.domain.VisaMessage
import ns.learning.patterns.state.visa.parser.VisaParser

@Singleton
class VisaProtocolInitialization implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "VisaProtocolInitialization"

        visaProtocolServer.visaParser = new VisaParser()
        visaProtocolServer.visaRequest = new VisaMessage()

        visaProtocolServer.nakCounter = 0

        visaProtocolServer.currentState = ReadRequestSate.instance
    }
}
