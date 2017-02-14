package ns.learning.patterns.state.visa.parser

import ns.learning.patterns.state.visa.domain.VisaMessage
import ns.learning.patterns.state.visa.exception.UnexpectedByteException
import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class CommandReaderState implements VisaParserState {


    @Override
    void write(VisaMessage visaMessage, byte data, VisaParser visaParser) {

        println "CommandReaderState"

        if (data >= 0x20 && data < 0x7F) {
            visaParser.buffer.write(data)
        } else if (data == VisaUtil.ETX) {
            visaParser.currentState = LrcValidator.instance
        } else {
            throw new UnexpectedByteException(data)
        }
    }
}
