package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class WaitForAckState implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "WaitForAckState"

        int data = is.read()

        if ((data == (int) VisaUtil.NAK) && (++visaProtocolServer.nakCounter < 3)) {
            visaProtocolServer.currentState = SendResponseState.instance
        } else {
            visaProtocolServer.currentState = VisaProtocolInitialization.instance

            Thread.currentThread().interrupt()
        }

    }
}
