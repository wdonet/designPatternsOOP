package design.pattern.after.visitor

class BoldText extends DocumentParser {
    @Override
    void accept(Visitor visitor) {
        // Own Code
        visitor.visit(this)
    }
}

class PlainText extends DocumentParser {
    @Override
    void accept(Visitor visitor) {
        // Own code
        visitor.visit(this)
    }
}

class HyperLink extends DocumentParser {
    @Override
    void accept(Visitor visitor) {
        // Own code
        visitor.visit(this)
    }
}
