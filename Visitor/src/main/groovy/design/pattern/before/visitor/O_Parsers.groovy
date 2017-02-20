package design.pattern.before.visitor

class O_BoldText extends O_DocumentPart {
    @Override
    String toHTML() {
        return "<bold>${this.text}</bold> "
    }
    @Override
    String toLatex() {
        return "\\textbf{${this.text}} "
    }
    @Override
    String toMarkDown() {
        return "**${this.text}** "
    }
}

class O_PlainText extends O_DocumentPart {
    @Override
    String toHTML() {
        return "${this.text} "
    }
    @Override
    String toLatex() {
        return "${this.text} "
    }
    @Override
    String toMarkDown() {
        return "${this.text} "
    }
}

class O_HyperLink extends O_DocumentPart {
    @Override
    String toHTML() {
        return "<a href='#'>${this.text}</a> "
    }
    @Override
    String toLatex() {
        return "\\href{#}{${this.text}} "
    }
    @Override
    String toMarkDown() {
        return "(${this.text})[#] "
    }
}
