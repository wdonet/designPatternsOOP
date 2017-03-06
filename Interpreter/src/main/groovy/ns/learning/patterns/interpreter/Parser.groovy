package ns.learning.patterns.interpreter

@Singleton
class Parser {
    public static final String PLUS_SYMBOL = "+"
    public static final String MINUS_SYMBOL = "-"
    public static final String MULTIPLY_SYMBOL = "*"
    public static final String ASSIGN_SYMBOL = "="

    Expression buildTree(String s) {
        Stack<Expression> parseTree = new LinkedList<>()
        String[] tokens = s.split(" ", -1)
        Expression expression

        try {
            for (String token : tokens) {
                if (token == PLUS_SYMBOL) {
                    expression = new NonTerminalExpression_Plus()
                    expression.right = parseTree.pop()
                    expression.left = parseTree.pop()
                    parseTree.push(expression)
                } else if (token == MINUS_SYMBOL) {
                    expression = new NonTerminalExpression_Minus()
                    expression.right = parseTree.pop()
                    expression.left = parseTree.pop()
                    parseTree.push(expression)
                } else if (token == MULTIPLY_SYMBOL) {
                    expression = new NonTerminalExpression_Multiply()
                    expression.right = parseTree.pop()
                    expression.left = parseTree.pop()
                    parseTree.push(expression)
                } else if (token == ASSIGN_SYMBOL) {
                    expression = new NonTerminalExpression_Assignment()
                    expression.right = parseTree.pop()
                    expression.left = parseTree.pop()
                    parseTree.push(expression)
                } else if (token.matches("\\d*\\.\\d+")) {
                    parseTree.push(new TerminalExpression_Number(Double.valueOf(token)))
                } else if (token.matches("\\d+")) {
                    parseTree.push(new TerminalExpression_Number(Integer.valueOf(token)))
                } else if (token.matches("[a-zA-Z\\d_]+")) {
                    parseTree.push(new TerminalExpression_Variable(token))
                } else {
                    throw new UnexpectedStringException(token)
                }
            }
        } catch (EmptyStackException ex) {
            throw new MalFormedInputExpression(ex)
        }

        if (parseTree.size() != 1) {
            throw new MalFormedInputExpression()
        }

        return parseTree.pop()
    }
}
