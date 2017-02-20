package design.pattern.after.visitor

abstract  class DocumentPart {
    protected String text

    abstract void accept(Visitor visitor)

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }
}
