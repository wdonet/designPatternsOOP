package ns.learning.patterns.proxy.protective

import ns.learning.patterns.proxy.base.domain.Question
import ns.learning.patterns.proxy.base.domain.User
import ns.learning.patterns.proxy.base.exception.QuestionServiceException
import ns.learning.patterns.proxy.base.service.QuestionService
import ns.learning.patterns.proxy.base.service.SimpleQuestionService

class SecuredQuestionService implements QuestionService {

    SimpleQuestionService simpleQuestionService = new SimpleQuestionService()

    @Override
    void addQuestion(Question question, User user) {

        validateAccess(user, QuestionService.OPERATION.CREATE)

        simpleQuestionService.addQuestion(question, user)
    }

    @Override
    void deleteQuestion(long id, User user) {

        validateAccess(user, QuestionService.OPERATION.DELETE)

        simpleQuestionService.deleteQuestion(id, user)
    }

    @Override
    Question getQuestion(long id, User user) {

        validateAccess(user, QuestionService.OPERATION.READ)

        return simpleQuestionService.getQuestion(id, user)
    }

    @Override
    List<Question> findMatches(String query, User user) {
        validateAccess(user, QuestionService.OPERATION.READ)

        return simpleQuestionService.findMatches(query, user)
    }

    static void validateAccess(User user, QuestionService.OPERATION operation) {

        if(user.name.startsWith("A"))
            throw new QuestionServiceException("Access not allowed")

        print 'access for ' + operation + ' allowed to ' + user.email

    }
}

