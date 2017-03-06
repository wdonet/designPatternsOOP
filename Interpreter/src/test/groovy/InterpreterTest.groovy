import ns.learning.patterns.interpreter.*
import spock.lang.Specification

class InterpreterTest extends Specification {

    def "Interpret Integer well formed expression"() {
        given:
        String inputString = "10 20 2 1 - - +"
        Context context = new Context()

        when:
        Expression expression = Parser.instance.buildTree(inputString)
        Number result = expression.evaluate(context)

        then:
        result == 29
    }

    def "Interpret Double well formed expression"() {
        given:
        String inputString = "2 10.8 20 2 1 - - + *"
        Context context = new Context()

        when:
        Expression expression = Parser.instance.buildTree(inputString)
        Number result = expression.evaluate(context)

        then:
        result == 59.6
    }

    def "Interpret well formed expression using variables"() {
        given:
        String inputString = "var2 var1 2 1 - + *"
        Expression expression = Parser.instance.buildTree(inputString)

        expect:
        result == expression.evaluate(context)

        where:
        result | context
        20     | new Context().setVariable("var1", 1).setVariable("var2", 10)
        402.0  | new Context().setVariable("var1", 3).setVariable("var2", 100.5)
        0      | new Context().setVariable("var1", 1000).setVariable("var2", 0)
    }


    def "Interpret Double expression with unknown characters"() {
        given:
        String inputString = "2 10.8 20 2 1 - - + /"
        Context context = new Context()

        when:
        Expression expression = Parser.instance.buildTree(inputString)
        expression.evaluate(context)

        then:
        thrown(UnexpectedStringException)

    }

    def "Interpret Double bad formed expression"() {
        given:
        String inputString = "2 10.8 20 * 2 1 - - + * "
        Context context = new Context()

        when:
        Expression expression = Parser.instance.buildTree(inputString)
        expression.evaluate(context)

        then:
        thrown(MalFormedInputExpression)

    }

}
