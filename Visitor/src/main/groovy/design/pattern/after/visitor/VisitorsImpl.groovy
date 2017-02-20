package design.pattern.after.visitor

class HtmlVisitor implements Visitor {

    private String output = ""

    @Override
    void visit(PlainText document) {
        output += "${document.getText()} "
    }

    @Override
    void visit(BoldText document) {
        output += "<b>${document.getText()}</b> "
    }

    @Override
    void visit(HyperLink document) {
        output += "<a href='#'>${document.getText()}</a> "
    }

    String getOutput() {
        return output
    }
}

class LatexVisitor implements Visitor {

    private String output = ""

    @Override
    void visit(PlainText document) {
        output += "${document.getText()} "
    }

    @Override
    void visit(BoldText document) {
        output +=  "\\textbf{${document.getText()}} "
    }

    @Override
    void visit(HyperLink document) {
        output +=  "\\href{#}{${document.getText()}} "
    }

    String getOutput() {
        return output
    }
}

class MarkDownVisitor implements Visitor {

    private String output = ""

    @Override
    void visit(PlainText document) {
        output +=  "${document.getText()} "
    }

    @Override
    void visit(BoldText document) {
        output +=  "**${document.getText()}** "
    }

    @Override
    void visit(HyperLink document) {
        output +=  "(${document.getText()})[#] "
    }

    String getOutput() {
        return output
    }
}
