package ns.learning.patterns.state.visa.parser

import ns.learning.patterns.state.visa.domain.VisaMessage

interface VisaParserState {

    void write(VisaMessage visaMessage, byte data, VisaParser visaParser)

}