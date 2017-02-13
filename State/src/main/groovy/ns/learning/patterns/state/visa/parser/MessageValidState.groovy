package ns.learning.patterns.state.visa.parser

import ns.learning.patterns.state.visa.domain.VisaMessage

@Singleton
class MessageValidState implements VisaParserState {

    @Override
    void write(VisaMessage visaMessage, byte data, VisaParser visaParser) {

        println "MessageValidState"

        throw new IllegalStateException("Message already parsed successfully")
    }
}
