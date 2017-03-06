import ns.learning.patterns.interpreter.Parser
import ns.learning.patterns.interpreter.UnexpectedStringException
import spock.lang.Specification

class InterpreterTest extends Specification {

    def "Interpret Integer well formed expression"() {
        given:
        String expression = "10 20 2 1 - - +"

        when:
        Parser parser = new Parser(expression)
        Number result = parser.evaluate()

        then:
        result == 29
    }

    def "Interpret Double well formed expression"() {
        given:
        String expression = "10.8 20 2 1 - - +"

        when:
        Parser parser = new Parser(expression)
        Number result = parser.evaluate()

        then:
        result == 29.8
    }

    def "Interpret bad formed expression"() {
        given:
        String expression = "2 10.8 20 2 1 - - + *"

        when:
        Parser parser = new Parser(expression)
        Number result = parser.evaluate()

        then:
        //thrown(UnexpectedStringException)
        result == 59.6
    }

}
