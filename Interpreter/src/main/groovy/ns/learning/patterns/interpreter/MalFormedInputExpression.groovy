package ns.learning.patterns.interpreter

class MalFormedInputExpression extends RuntimeException {

    MalFormedInputExpression() {

    }

    MalFormedInputExpression(Throwable cause) {
        super(cause)
    }

}
