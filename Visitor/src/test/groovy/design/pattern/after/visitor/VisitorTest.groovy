package design.pattern.after.visitor

import spock.lang.Specification

class VisitorTest extends Specification {

    def "Test visitor"() {
        given:
        String plain = "Welcome to"
        String bold = "Pattern Design"
        String hyperLink = "click to start"

        List<DocumentPart> documentStructure = new ArrayList<>()

        DocumentPart plainTextParser = new PlainText()
        DocumentPart boldTextParser = new BoldText()
        DocumentPart hyperLinkTextParser = new HyperLink()

        plainTextParser.setText(plain)
        boldTextParser.setText(bold)
        hyperLinkTextParser.setText(hyperLink)

        documentStructure.add(plainTextParser)
        documentStructure.add(boldTextParser)
        documentStructure.add(hyperLinkTextParser)

        Document doc = new Document()
        doc.setDocumentParts(documentStructure)

        expect:
        doc.accept(visitor)
        println "${visitor.getOutput()}"
        expectedOutput == visitor.getOutput()

        where:
        visitor                 | expectedOutput
        new HtmlVisitor()       | "Welcome to <b>Pattern Design</b> <a href='#'>click to start</a> "
        new LatexVisitor()      | "Welcome to \\textbf{Pattern Design} \\href{#}{click to start} "
        new MarkDownVisitor()   | "Welcome to **Pattern Design** (click to start)[#] "

    }
}
