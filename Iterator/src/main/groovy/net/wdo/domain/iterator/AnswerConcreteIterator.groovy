package net.wdo.domain.iterator

import net.wdo.domain.iterable.Answer

class AnswerConcreteIterator implements MyIterator<Answer>{
    private int index = 0
    private final List<Answer> answers

    AnswerConcreteIterator(List<Answer> answers) {
        this.answers = answers
    }

    @Override
    boolean hasNext() {
        return answers != null && answers.size() > index
    }

    @Override
    Answer next() {
        if (hasNext()) {
            return answers.get(index++)
        }
        return null
    }

    @Override
    int size() {
        return answers == null ? 0 : answers.size()
    }
}