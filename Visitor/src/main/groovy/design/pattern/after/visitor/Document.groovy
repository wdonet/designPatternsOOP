package design.pattern.after.visitor

class Document {

    private List<DocumentPart> documentParts

    void accept(Visitor visitor) {
        documentParts.forEach({
            documentPart ->
                documentPart.accept(visitor)
        })
    }

    void setDocumentParts(List<DocumentPart> documentParts) {
        this.documentParts = documentParts
    }
}
