package ns.learning.patterns.builder.service.report.builders

class PDFReportBuilder implements ReportTableBuilder {

    PDFReportBuilder(OutputStream os) {

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
        println "PDF Builder -  addCell: $value"
    }
}
