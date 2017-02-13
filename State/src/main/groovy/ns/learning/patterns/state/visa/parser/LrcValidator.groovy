package ns.learning.patterns.state.visa.parser

import ns.learning.patterns.state.visa.domain.VisaMessage
import ns.learning.patterns.state.visa.exception.BadLrcException
import ns.learning.patterns.state.visa.service.VisaUtil

@Singleton
class LrcValidator implements VisaParserState {

    @Override
    void write(VisaMessage visaMessage, byte data, VisaParser visaParser) {

        println "LrcValidator"

        visaMessage.fullMessage = visaParser.buffer.toByteArray()
        byte lrc = VisaUtil.calculateLrc(visaMessage.fullMessage)

        if (lrc == data) {
            visaMessage.command = new String(visaMessage.fullMessage, 0, 2)

            visaParser.currentState = MessageValidState.instance
        } else {
            throw new BadLrcException(data, lrc)
        }

    }
}
