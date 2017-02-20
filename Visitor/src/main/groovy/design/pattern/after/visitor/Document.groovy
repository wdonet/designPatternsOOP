package design.pattern.after.visitor

class Document {

    private List<DocumentParser> documentParts

    void accept(Visitor visitor) {
        documentParts.forEach({
            documentPart ->
                documentPart.accept(visitor)
        })
    }

    void setDocumentParts(List<DocumentParser> documentParts) {
        this.documentParts = documentParts
    }
}
