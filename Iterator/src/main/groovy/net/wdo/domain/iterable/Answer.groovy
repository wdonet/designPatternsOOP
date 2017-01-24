package net.wdo.domain.iterable

class Answer {
    String description

    @Override
    String toString() {
        return "Answer : '" + description + '\'.'
    }
}
