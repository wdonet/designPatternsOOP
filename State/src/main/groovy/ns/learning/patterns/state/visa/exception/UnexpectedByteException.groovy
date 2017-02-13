package ns.learning.patterns.state.visa.exception

class UnexpectedByteException extends VisaMessageException {

    UnexpectedByteException(byte data) {
        super("Unexpected byte received: " + data)
    }
}
