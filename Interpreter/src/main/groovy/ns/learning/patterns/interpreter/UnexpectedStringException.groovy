package ns.learning.patterns.interpreter

class UnexpectedStringException extends RuntimeException {

    UnexpectedStringException(String stringFound) {
        super("Unexpected: " + stringFound)
    }

}
