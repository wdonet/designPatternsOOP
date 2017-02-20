package design.pattern.after.visitor

abstract  class DocumentParser {
    protected String text

    abstract void accept(Visitor visitor)

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }
}
