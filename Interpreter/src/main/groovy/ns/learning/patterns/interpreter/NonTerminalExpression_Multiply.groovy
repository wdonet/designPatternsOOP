package ns.learning.patterns.interpreter

class NonTerminalExpression_Multiply implements Expression {

    Expression left
    Expression right

    @Override
    Number evaluate(Context context) {
        left.evaluate(context) * right.evaluate(context)
    }
}
