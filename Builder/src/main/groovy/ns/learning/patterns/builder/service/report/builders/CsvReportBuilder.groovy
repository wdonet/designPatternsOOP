package ns.learning.patterns.builder.service.report.builders

class CsvReportBuilder implements ReportTableBuilder {
    OutputStream os
    boolean addComma

    CsvReportBuilder(OutputStream os) {
        this.os = os
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
        addComma = false
    }

    @Override
    void endRow() {
        os.write System.lineSeparator().bytes
    }

    @Override
    void startColumn() {
        if (addComma) {
            os.write ",".bytes
            addComma = false
        }
    }

    @Override
    void endColumn() {
        addComma = true
    }

    @Override
    void setCellValue(String value) {
        os.write value.bytes
    }
}
