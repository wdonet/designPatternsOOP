package ns.learning.patterns.state.visa.exception

class BadLrcException extends VisaMessageException {

    BadLrcException(byte expected, byte actual) {
        super("Bad LRC, expected: " + expected + ", actual: " + actual)
    }
}
