package ns.learning.patterns.interpreter

class NonTerminalExpression_Plus implements Expression {

    Expression left
    Expression right

    @Override
    Number evaluate(Context context) {
        return left.evaluate(context) + right.evaluate(context)
    }
}
