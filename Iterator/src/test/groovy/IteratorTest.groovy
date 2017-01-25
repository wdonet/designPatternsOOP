import net.wdo.domain.iterable.Answer
import net.wdo.domain.iterator.QuestionAggregate
import net.wdo.domain.iterator.QuestionConcreteAggregate
import spock.lang.Specification

class IteratorTest extends Specification {

    def "Should iterate Questions with 2 Answers"() {

        given: "a two-answered question"
        QuestionAggregate question = new QuestionConcreteAggregate(title: "what?")
        question.addAnswer("first answer")
        question.addAnswer("second answer")

        when: "an iterator is created"
        def iterator = question.iterator()

        then: "all elements should be in the iterator"
        while (iterator.hasNext()) {
            Answer answer = iterator.next()
            answer.getDescription().startsWith("first") ||
                    answer.getDescription().startsWith("second")
            println answer
        }

        and: "iterator should have size 2"
        question.iterator().size() == 2
    }

    def "Should iterate when Answer is added to Question"() {

        given: "a two-answered question"
        QuestionAggregate question = new QuestionConcreteAggregate(title: "what?")
        question.addAnswer("first answer")
        question.addAnswer("second answer")

        and: "asserts the iterator is size 2"
        assert question.iterator().size() == 2

        when: "a third answer is added"
        question.addAnswer("third answer")

        then: "the iterator size increases to 3"
        assert question.iterator().size() == 3
        println question
    }

}
