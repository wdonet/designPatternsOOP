package ns.learning.patterns.interpreter

class UndefinedSymbolException extends RuntimeException {

    UndefinedSymbolException(String variable) {
        super("Undefined symbol: " + variable)
    }
}
