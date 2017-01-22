package ns.learning.patterns.proxy.base.service

import ns.learning.patterns.proxy.base.domain.Question
import ns.learning.patterns.proxy.base.domain.User

//subject
interface QuestionService {

    enum OPERATION {
        CREATE, READ, UPDATE, DELETE
    }

    void addQuestion(Question question, User user)

    void deleteQuestion(long id, User user)

    Question getQuestion(long id, User user)

    List<Question> findMatches(String query, User user)

}