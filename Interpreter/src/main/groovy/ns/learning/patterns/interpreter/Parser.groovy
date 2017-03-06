package ns.learning.patterns.interpreter

class Parser {
    public static final String PLUS_SYMBOL = "+"
    public static final String MINUS_SYMBOL = "-"
    public static final String MULTIPLY_SYMBOL = "*"
    private ArrayList<Expression> parseTree = new ArrayList<Expression>()

    Parser(String s) {
        String[] tokens = s.split(" ", -1)

        for (String token : tokens) {
            if (token == PLUS_SYMBOL) {
                parseTree.add(TerminalExpression_Plus.instance)
            } else if (token == MINUS_SYMBOL) {
                parseTree.add(TerminalExpression_Minus.instance)
            } else if (token == MULTIPLY_SYMBOL) {
                parseTree.add(TerminalExpression_Multiply.instance)
            } else if (token.matches("\\d*\\.\\d+")) {
                parseTree.add(new TerminalExpression_Number(Double.valueOf(token)))
            } else if (token.matches("\\d+")) {
                parseTree.add(new TerminalExpression_Number(Integer.valueOf(token)))
            } else {
                throw new UnexpectedStringException(token)
            }
        }
    }

    Number evaluate() {
        Stack<Number> context = new Stack<Integer>()

        for (Expression e : parseTree)
            e.interpret(context)

        return context.pop()
    }
}
