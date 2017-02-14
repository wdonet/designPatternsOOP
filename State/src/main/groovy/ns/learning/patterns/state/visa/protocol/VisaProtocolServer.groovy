package ns.learning.patterns.state.visa.protocol

import ns.learning.patterns.state.visa.domain.VisaMessage
import ns.learning.patterns.state.visa.parser.VisaParser

class VisaProtocolServer implements Runnable {

    InputStream is
    OutputStream os

    VisaProtocolState currentState
    VisaParser visaParser
    VisaMessage visaRequest
    VisaMessage visaResponse

    int nakCounter

    VisaProtocolServer(InputStream is, OutputStream os) {
        this.is = is
        this.os = os

        currentState = VisaProtocolInitialization.instance
        visaParser = new VisaParser()
    }

    @Override
    void run() {
        while (!Thread.currentThread().isInterrupted()) {
            currentState.go(is, os, this)
        }
    }
}
