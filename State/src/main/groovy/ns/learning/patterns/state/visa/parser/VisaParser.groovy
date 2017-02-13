package ns.learning.patterns.state.visa.parser

import ns.learning.patterns.state.visa.domain.VisaMessage

class VisaParser {

    VisaParserState currentState
    ByteArrayOutputStream buffer

    VisaParser() {
        currentState = StxReaderState.instance
    }

    void write(VisaMessage visaMessage, byte data) {
        currentState.write(visaMessage, data, this)
    }
}
