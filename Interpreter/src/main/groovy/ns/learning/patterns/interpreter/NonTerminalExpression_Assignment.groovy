package ns.learning.patterns.interpreter

class NonTerminalExpression_Assignment implements Expression{

    Expression right
    Expression left

    @Override
    Number evaluate(Context context) {
        Number result = right.evaluate(context)

        if(!left instanceof TerminalExpression_Variable)
            throw new LValueRequiredException()

        context.setVariable(((TerminalExpression_Variable)left).getName(), result)

        return result
    }
}
