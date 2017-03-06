package ns.learning.patterns.interpreter

@Singleton
class TerminalExpression_Minus implements Expression {

    @Override
    void interpret(Stack<Number> stack) {
        stack.push(-stack.pop() + stack.pop())
    }
}
