package ns.learning.patterns.interpreter

@Singleton
class TerminalExpression_Multiply implements Expression{
    @Override
    void interpret(Stack<Number> stack) {
        stack.push(stack.pop() * stack.pop())
    }
}
