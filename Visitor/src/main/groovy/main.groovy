import design.pattern.after.visitor.BoldText
import design.pattern.after.visitor.Document
import design.pattern.after.visitor.DocumentParser
import design.pattern.after.visitor.HtmlVisitor
import design.pattern.after.visitor.HyperLink
import design.pattern.after.visitor.LatexVisitor
import design.pattern.after.visitor.MarkDownVisitor
import design.pattern.after.visitor.PlainText
import design.pattern.after.visitor.Visitor
import design.pattern.before.visitor.O_BoldText
import design.pattern.before.visitor.O_Document
import design.pattern.before.visitor.O_DocumentParser
import design.pattern.before.visitor.O_HyperLink
import design.pattern.before.visitor.O_PlainText

O_DocumentParser documentPart1 = new O_PlainText()
documentPart1.setText("Welcome to")
O_DocumentParser documentPart2 = new O_BoldText()
documentPart2.setText("Pattern Design")
O_DocumentParser documentPart3 = new O_HyperLink()
documentPart3.setText("click to start")

List<O_DocumentParser> documentParts = new ArrayList<>()
documentParts.add(documentPart1)
documentParts.add(documentPart2)
documentParts.add(documentPart3)

O_Document document = new O_Document()
document.setDocumentParts(documentParts)
String html = document.toHTML()
String latex = document.toLatex()
String md = document.toPlainText()

println "HTML: ${html}"
println "Latex: ${latex}"
println "Mark Down: ${md}"

//=============
println "====="

DocumentParser plainText = new PlainText()
plainText.setText("Welcome to")

DocumentParser boldText = new BoldText()
boldText.setText("Pattern Design")

DocumentParser hyperLinkText = new HyperLink()
hyperLinkText.setText("click to start")

List<DocumentParser> documents = new ArrayList<>()
documents.add(plainText)
documents.add(boldText)
documents.add(hyperLinkText)

Visitor htmlVisitor = new HtmlVisitor()
Visitor latexVisitor = new LatexVisitor()
Visitor markDownVisitor = new MarkDownVisitor()

Document doc = new Document()
doc.setDocumentParts(documents)
doc.accept(htmlVisitor)
doc.accept(latexVisitor)
doc.accept(markDownVisitor)

html = htmlVisitor.getOutput()
latex = latexVisitor.getOutput()
md = markDownVisitor.getOutput()

println "HTML: ${html}"
println "Latex: ${latex}"
println "Mark Down: ${md}"

