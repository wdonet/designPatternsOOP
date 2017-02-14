package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.domain.VisaMessage

@Singleton
class ProcessCommandState implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {
        println "Handling " + visaProtocolServer.visaRequest.command

        visaProtocolServer.visaResponse = new VisaMessage()
        visaProtocolServer.visaResponse.command = "C1"

        visaProtocolServer.visaResponse.fullMessage = [0x43, 0x31] as byte[]

        visaProtocolServer.nakCounter = 0
        visaProtocolServer.currentState = SendResponseState.instance
    }
}
