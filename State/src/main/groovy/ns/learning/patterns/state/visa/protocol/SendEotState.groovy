package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class SendEotState implements VisaProtocolState {

    @Override
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer) {

        println "SendEotState"

        os.write(VisaUtil.EOT)

        visaProtocolServer.currentState = VisaProtocolInitialization.instance
    }
}
