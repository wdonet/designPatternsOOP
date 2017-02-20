package design.pattern.after.visitor

class BoldText extends DocumentPart {
    @Override
    void accept(Visitor visitor) {
        // Own Code
        visitor.visit(this)
    }
}

class PlainText extends DocumentPart {
    @Override
    void accept(Visitor visitor) {
        // Own code
        visitor.visit(this)
    }
}

class HyperLink extends DocumentPart {
    @Override
    void accept(Visitor visitor) {
        // Own code
        visitor.visit(this)
    }
}
