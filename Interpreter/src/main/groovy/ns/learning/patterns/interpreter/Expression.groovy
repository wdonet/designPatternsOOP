package ns.learning.patterns.interpreter

interface Expression {
    void interpret(Stack<Number> stack)
}
