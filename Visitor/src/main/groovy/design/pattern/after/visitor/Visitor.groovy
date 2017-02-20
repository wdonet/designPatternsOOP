package design.pattern.after.visitor

interface Visitor {
    void visit(PlainText document)
    void visit(BoldText document)
    void visit(HyperLink document)
}