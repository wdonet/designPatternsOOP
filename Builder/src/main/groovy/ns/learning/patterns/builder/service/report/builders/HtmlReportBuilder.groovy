package ns.learning.patterns.builder.service.report.builders

class HtmlReportBuilder implements ReportTableBuilder {

    HtmlReportBuilder(OutputStream os) {

    }

    @Override
    void newLine() {

    }

    @Override
    void startTable() {

    }

    @Override
    void endTable() {

    }

    @Override
    void startRow() {

    }

    @Override
    void endRow() {

    }

    @Override
    void startColumn() {

    }

    @Override
    void endColumn() {

    }

    @Override
    void setCellValue(String value) {
        println "HTML Builder -  addCell: $value"
    }
}