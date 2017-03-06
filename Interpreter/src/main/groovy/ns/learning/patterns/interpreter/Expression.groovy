package ns.learning.patterns.interpreter

interface Expression {
    Number evaluate(Context context)
}
