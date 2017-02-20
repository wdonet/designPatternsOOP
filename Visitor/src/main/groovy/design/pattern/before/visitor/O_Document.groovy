package design.pattern.before.visitor

class O_Document {

    private List<O_DocumentParser> documentParts

    String toHTML() {
        String output = ""
        documentParts.forEach({ documentPart -> output += documentPart.toHTML() })
        return output
    }

    String toPlainText() {
        String output = ""
        documentParts.forEach({ documentPart -> output += documentPart.toMarkDown() })
        return output
    }

    String toLatex() {
        String output = ""
        documentParts.forEach({ documentPart -> output += documentPart.toLatex() })
        return output
    }

    void setDocumentParts(List<O_DocumentParser> documentParts) {
        this.documentParts = documentParts
    }
}
