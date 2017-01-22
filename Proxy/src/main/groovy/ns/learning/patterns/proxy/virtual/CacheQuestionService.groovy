package ns.learning.patterns.proxy.virtual

import ns.learning.patterns.proxy.base.domain.Question
import ns.learning.patterns.proxy.base.domain.User
import ns.learning.patterns.proxy.base.service.QuestionService
import ns.learning.patterns.proxy.base.service.SimpleQuestionService

//proxy
class CacheQuestionService implements QuestionService {

    SimpleQuestionService simpleQuestionService = new SimpleQuestionService()

    Map<String, List<Question>> questionsCache = new HashMap<>()

    @Override
    void addQuestion(Question question, User user) {

        simpleQuestionService.addQuestion(question, user)

    }

    @Override
    void deleteQuestion(long id, User user) {

        simpleQuestionService.deleteQuestion(id, user)
    }

    @Override
    Question getQuestion(long id, User user) {

        return simpleQuestionService.getQuestion(id, user)
    }

    @Override
    List<Question> findMatches(String query, User user) {

        List<Question> result

        if (questionsCache.containsKey(query)) {
            result = questionsCache[query]
        } else {
            result = simpleQuestionService.findMatches(query, user)
            questionsCache[query] = result
        }

        return result
    }
}
