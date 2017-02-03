package ns.learning.patterns.builder.service.report.builders

class HtmlReportBuilder implements ReportTableBuilder {

    OutputStream os

    HtmlReportBuilder(OutputStream os) {
        this.os = os
    }

    @Override
    void newLine() {
        os.write("<br/>".bytes)
    }

    @Override
    void startTable() {
        os.write("<table>".bytes)
    }

    @Override
    void endTable() {
        os.write("</table>".bytes)
    }

    @Override
    void startRow() {
        os.write("<tr>".bytes)
    }

    @Override
    void endRow() {
        os.write("</tr>".bytes)
    }

    @Override
    void startColumn() {
        os.write("<td>".bytes)
    }

    @Override
    void endColumn() {
        os.write("</td>".bytes)
    }

    @Override
    void setCellValue(String value) {
        os.write value.bytes
    }
}