package design.pattern.before.visitor

abstract class O_DocumentPart {

    protected String text

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }

    abstract String toHTML()
    abstract String toLatex()
    abstract String toMarkDown()

}
