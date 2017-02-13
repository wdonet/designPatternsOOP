package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class SendNakState implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "SendNakState"

        os.write(VisaUtil.NAK)

        visaProtocolServer.nakCounter++

        if (visaProtocolServer.nakCounter == 3) {
            visaProtocolServer.currentState = SendEotState.instance
        }
    }
}
