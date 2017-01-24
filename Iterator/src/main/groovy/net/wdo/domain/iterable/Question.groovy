package net.wdo.domain.iterable

class Question implements Iterable<Answer>{
    String title
    List<Answer> answers = new ArrayList<>()

    @Override
    Iterator<Answer> iterator() {
        return new Iterator<Answer>() {

            private int nextIndex = 0

            @Override
            boolean hasNext() {
                return answers != null && answers.size() > nextIndex
            }

            @Override
            Answer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No answers")
                }
                return answers.get(nextIndex++)
            }

        }

    }
}
