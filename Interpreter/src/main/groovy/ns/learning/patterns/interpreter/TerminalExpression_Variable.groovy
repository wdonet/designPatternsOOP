package ns.learning.patterns.interpreter

class TerminalExpression_Variable implements Expression {
    private String name

    TerminalExpression_Variable(String name) {
        this.name = name
    }

    @Override
    Number evaluate(Context context) {
        return context.getVariable(name)
    }
}
