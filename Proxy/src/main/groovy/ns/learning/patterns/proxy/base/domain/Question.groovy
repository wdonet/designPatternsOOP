package ns.learning.patterns.proxy.base.domain

import java.time.LocalDateTime

//any dao
class Question {

    long id
    String question
    LocalDateTime addedTime
    User creator

}
