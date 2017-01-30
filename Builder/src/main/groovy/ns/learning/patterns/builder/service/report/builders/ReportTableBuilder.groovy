package ns.learning.patterns.builder.service.report.builders

interface ReportTableBuilder {

    void newLine()

    void startTable()
    void endTable()

    void startRow()
    void endRow()

    void startColumn()
    void endColumn()

    void setCellValue(String value)

}