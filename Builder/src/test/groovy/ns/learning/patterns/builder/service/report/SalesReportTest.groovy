package ns.learning.patterns.builder.service.report

import ns.learning.patterns.builder.domain.Sale
import ns.learning.patterns.builder.service.SaleService
import ns.learning.patterns.builder.service.report.builders.HtmlReportBuilder
import ns.learning.patterns.builder.service.report.builders.PDFReportBuilder
import ns.learning.patterns.builder.service.report.builders.XlsReportBuilder
import spock.lang.Specification

import java.time.LocalDate

class SalesReportTest extends Specification {

    def salesReport = new SalesReport()


    def "SalesReport constructs report using different Builders"() {
        given:
        salesReport.saleService = Mock(SaleService)

        when:
        salesReport.saleService.sales >> [
                new Sale(LocalDate.now().minusDays(3), 123.2),
                new Sale(LocalDate.now().minusDays(2), 512.43)
        ]
        OutputStream os = new ByteArrayOutputStream()
        def htmlReportBuilder = new HtmlReportBuilder(os)
        def pdfReportBuilder = new PDFReportBuilder(os)
        def xlsReportBuilder = new XlsReportBuilder(os)

        then:
        salesReport.createReport(htmlReportBuilder)
        salesReport.createReport(pdfReportBuilder)
        salesReport.createReport(xlsReportBuilder)

    }
}
