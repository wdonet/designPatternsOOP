import design.pattern.before.visitor.O_BoldText
import design.pattern.before.visitor.O_Document
import design.pattern.before.visitor.O_DocumentPart
import design.pattern.before.visitor.O_HyperLink
import design.pattern.before.visitor.O_PlainText

O_DocumentPart plainText = new O_PlainText()
O_DocumentPart boldText = new O_BoldText()
O_DocumentPart hyperLink = new O_HyperLink()

plainText.setText("Welcome to")
boldText.setText("Pattern Design")
hyperLink.setText("click to start")

List<O_DocumentPart> documentParts = new ArrayList<>()
documentParts.add(plainText)
documentParts.add(boldText)
documentParts.add(hyperLink)

O_Document document = new O_Document()
document.setDocumentParts(documentParts)

String html = document.toHTML()
String latex = document.toLatex()
String md = document.toPlainText()

println "HTML: ${html}"
println "Latex: ${latex}"
println "Mark Down: ${md}"
