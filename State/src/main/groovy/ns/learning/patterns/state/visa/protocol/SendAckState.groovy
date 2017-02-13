package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class SendAckState implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "SendAckState"

        os.write(VisaUtil.ACK)

        visaProtocolServer.currentState = ProcessCommandState.instance
    }
}
