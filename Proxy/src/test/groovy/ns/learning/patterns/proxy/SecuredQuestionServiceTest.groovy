package ns.learning.patterns.proxy

import ns.learning.patterns.proxy.base.domain.Question
import ns.learning.patterns.proxy.base.domain.User
import ns.learning.patterns.proxy.base.exception.QuestionServiceException
import ns.learning.patterns.proxy.base.service.QuestionService
import ns.learning.patterns.proxy.base.service.SimpleQuestionService
import ns.learning.patterns.proxy.protective.SecuredQuestionService
import spock.lang.Specification

class SecuredQuestionServiceTest extends Specification {

    def "securedQuestionService allow operations if name doesn't start with 'A'"() {
        setup:
        QuestionService questionService = new SecuredQuestionService()
        Question question = new Question()
        User user = new User()

        user.name = 'Juan'

        when:
        questionService.addQuestion(question, user)

        then:
        true
    }

    def "simpleQuestionService allow operations if name doesn't start with 'A'"() {
        setup:
        QuestionService questionService = new SimpleQuestionService()
        Question question = new Question()
        User user = new User()

        user.name = 'Juan'

        when:
        questionService.addQuestion(question, user)

        then:
        true
    }

    def "securedQuestionService DOESN'T allow operations if name starts with 'A'"() {
        setup:
        QuestionService questionService = new SecuredQuestionService()
        Question question = new Question()
        User user = new User()

        user.name = 'Antonio'

        when:
        questionService.addQuestion(question, user)

        then:
        thrown QuestionServiceException
    }

    def "simpleQuestionService allow operations even if name start with 'A'"() {
        setup:
        QuestionService questionService = new SimpleQuestionService()
        Question question = new Question()
        User user = new User()

        user.name = 'Antonio'

        when:
        questionService.addQuestion(question, user)

        then:
        true
    }
}