package ns.learning.patterns.proxy.base.service

import ns.learning.patterns.proxy.base.domain.Question
import ns.learning.patterns.proxy.base.domain.User
import ns.learning.patterns.proxy.base.service.QuestionService

class SimpleQuestionService implements QuestionService {

    @Override
    void addQuestion(Question question, User user) {
        print user.name + ' added a question '
    }

    @Override
    void deleteQuestion(long id, User user) {
        print user.name + ' deleted a question '
    }

    @Override
    Question getQuestion(long id, User user) {
        Question question = new Question()

        print 'Question retrieved to ' + user.name

        return question
    }

    @Override
    List<Question> findMatches(String query, User user) {

        print 'Questions retrieved to ' + user.name + ' for query: ' + query

        return Collections.EMPTY_LIST
    }
}
