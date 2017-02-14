package ns.learning.patterns.state.parser

import ns.learning.patterns.state.visa.domain.VisaMessage
import ns.learning.patterns.state.visa.exception.BadLrcException
import ns.learning.patterns.state.visa.exception.UnexpectedByteException
import ns.learning.patterns.state.visa.parser.MessageValidState
import ns.learning.patterns.state.visa.parser.VisaParser
import spock.lang.Specification

class VisaParserTest extends Specification {


    def "Parse a well formed message"() {
        setup:
        VisaParser visaParser = new VisaParser()
        def message = [2, 0x43, 0x30, 3, 0x70] as byte[]
        VisaMessage visaMessage = new VisaMessage()

        when:
        message.each { data -> visaParser.write(visaMessage, data) }

        then:
        println visaMessage.command
        visaParser.currentState instanceof MessageValidState && visaMessage.command == "C0"


    }

    def "Parse starting with no STX, Expects UnexpectedByteException to be thrown"() {
        setup:
        VisaParser visaParser = new VisaParser()
        def message = [3, 0x43, 0x30, 3, 0x70] as byte[]
        VisaMessage visaMessage = new VisaMessage()

        when:
        message.each { data -> visaParser.write(visaMessage, data) }

        then:
        thrown UnexpectedByteException
    }

    def "Parse starting with bad LRC, Expects BadLrcException to be thrown"() {
        setup:
        VisaParser visaParser = new VisaParser()
        def message = [2, 0x43, 0x30, 3, 0x71] as byte[]
        VisaMessage visaMessage = new VisaMessage()

        when:
        message.each { data -> visaParser.write(visaMessage, data) }

        then:
        thrown BadLrcException
    }

    def "Parse message with no ETX"() {
        setup:
        VisaParser visaParser = new VisaParser()
        def message = [2, 0x43, 0x30, 0x70] as byte[]
        VisaMessage visaMessage = new VisaMessage()

        when:
        message.each { data -> visaParser.write(visaMessage, data) }

        then:
        !(visaParser.currentState instanceof MessageValidState)
    }


}
