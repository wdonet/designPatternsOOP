package design.pattern.after.visitor

import spock.lang.Specification

class VisitorTest extends Specification {

    def "Test visitor"() {
        given:
        String plain = "Welcome to"
        String bold = "Pattern Design"
        String hyperLink = "click to start"

        List<DocumentParser> documentStructure = new ArrayList<>()

        DocumentParser plainTextParser = new PlainText()
        DocumentParser boldTextParser = new BoldText()
        DocumentParser hyperLinkTextParser = new HyperLink()

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
