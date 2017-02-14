package ns.learning.patterns.state.visa.parser

import ns.learning.patterns.state.visa.domain.VisaMessage
import ns.learning.patterns.state.visa.exception.UnexpectedByteException
import ns.learning.patterns.state.visa.exception.VisaMessageException
import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class StxReaderState implements VisaParserState {

    @Override
    void write(VisaMessage visaMessage, byte data, VisaParser visaParser) throws VisaMessageException {

        println "StxReaderState"

        if (data == VisaUtil.STX) {
            visaParser.currentState = CommandReaderState.instance
            visaParser.buffer = new ByteArrayOutputStream()
        } else {
            throw new UnexpectedByteException(data)
        }

    }
}
