import net.wdo.domain.iterable.Answer
import net.wdo.domain.iterable.Question
import spock.lang.Specification

class IterableTest extends Specification {

    def "Using Iterable with Java Iterator"() {
        setup:
        Question question = new Question(title: "what?")
        List<String> posibilities = Arrays.asList("one", "two")

        when:
        question.getAnswers().add(new Answer(description: posibilities.get(0)))
        question.getAnswers().add(new Answer(description: posibilities.get(1)))

        then:
        def iterator = question.iterator()
        while (iterator.hasNext()) {
            def next = iterator.next()
            next != null
            posibilities.contains(next.getDescription())
            println next.getDescription()
        }
    }

    def "Using Iterable in Java5 forEach"() {
        setup:
        Question question = new Question(title: "what?")
        List<String> posibilities = Arrays.asList("one", "two")

        when:
        question.getAnswers().add(new Answer(description: posibilities.get(0)))
        question.getAnswers().add(new Answer(description: posibilities.get(1)))

        then:
        for (Answer answer : question) {
            def description = answer.getDescription()
            description != null
            posibilities.contains(description)
            println description
        }
    }

    def "Passing code to the Iterator"() {
        setup:
        Question question = new Question(title: "what?")
        List<String> posibilities = Arrays.asList("one", "two")

        when:
        question.getAnswers().add(new Answer(description: posibilities.get(0)))
        question.getAnswers().add(new Answer(description: posibilities.get(1)))
        //instead of the lambda expressions for forEachRemaining(a -> action(a))
        //we use Groovy closures:
        question.iterator().forEachRemaining { answer ->
            answer.description += ' action'
        }
        question.iterator().forEachRemaining { answer ->
            println answer.getDescription()
        }

        then:
        question.answers != null
        def iterator = question.iterator()
        while (iterator.hasNext()) {
            !posibilities.contains(iterator.next().getDescription())
        }
    }
}
