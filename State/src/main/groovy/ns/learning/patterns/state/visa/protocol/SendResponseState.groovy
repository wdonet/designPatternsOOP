package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class SendResponseState implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "SendResponseState"

        os.write(VisaUtil.STX)
        os.write(visaProtocolServer.visaResponse.fullMessage)
        os.write(VisaUtil.ETX)
        os.write(VisaUtil.calculateLrc(visaProtocolServer.visaResponse.fullMessage))

        visaProtocolServer.currentState = WaitForAckState.instance
    }
}
