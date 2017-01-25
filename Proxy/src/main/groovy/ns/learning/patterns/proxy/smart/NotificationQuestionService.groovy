package ns.learning.patterns.proxy.smart

import ns.learning.patterns.proxy.base.domain.Question
import ns.learning.patterns.proxy.base.domain.User
import ns.learning.patterns.proxy.base.service.NotificationService
import ns.learning.patterns.proxy.base.service.QuestionService
import ns.learning.patterns.proxy.base.service.SimpleQuestionService

//proxy
class NotificationQuestionService implements QuestionService {

    SimpleQuestionService simpleQuestionService = new SimpleQuestionService()

    NotificationService notificationService

    @Override
    void addQuestion(Question question, User user) {

        //save statistics

        simpleQuestionService.addQuestion(question, user)

        notificationService.sendNotification("Question added")
    }

    @Override
    void deleteQuestion(long id, User user) {

        //save statistics

        simpleQuestionService.deleteQuestion(id, user)

        notificationService.sendNotification("Question deleted")
    }

    @Override
    Question getQuestion(long id, User user) {

        return simpleQuestionService.getQuestion(id, user)
    }

    @Override
    List<Question> findMatches(String query, User user) {

        return simpleQuestionService.findMatches(query, user)
    }
}

