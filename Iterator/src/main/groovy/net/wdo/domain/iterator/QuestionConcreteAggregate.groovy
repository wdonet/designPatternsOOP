package net.wdo.domain.iterator

import net.wdo.domain.iterable.Answer

class QuestionConcreteAggregate implements QuestionAggregate {

    String title
    private List<Answer> answerList = new ArrayList<>()

    @Override
    MyIterator iterator() {
        return new AnswerConcreteIterator(answerList)
    }

    void addAnswer(String desc) {
        answerList.add(new Answer(description: desc))
    }

    @Override
    public String toString() {

        StringBuffer answers = new StringBuffer()
        def iterator = iterator()
        while(iterator.hasNext()) {
            answers.append("\n").append(iterator.next())
        }

        return "Question :" + title +
                "\nTotal answers : " + (answerList == null ? "zero" : answerList.size()) +
                answers.toString() +
                '\n-'
    }
}
