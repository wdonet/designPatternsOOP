package ns.learning.patterns.interpreter

class TerminalExpression_Number implements Expression {

    private Number number

    TerminalExpression_Number(Number number) {
        this.number = number
    }

    @Override
    Number evaluate(Context context) {
        return number
    }
}
