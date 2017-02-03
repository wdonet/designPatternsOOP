package ns.learning.patterns.builder.service.report

import ns.learning.patterns.builder.domain.Sale
import ns.learning.patterns.builder.service.SaleService
import ns.learning.patterns.builder.service.report.builders.CsvReportBuilder
import ns.learning.patterns.builder.service.report.builders.HtmlReportBuilder
import spock.lang.Specification

import java.time.LocalDate

class SalesReportTest extends Specification {

    def salesReport = new SalesReport()

    def "SalesReport constructs report using HtmlBuilder"() {
        given:
        salesReport.saleService = Mock(SaleService)
        salesReport.saleService.sales >> [
                new Sale(LocalDate.now().minusDays(3), 100),
                new Sale(LocalDate.now().minusDays(2), 321.50)
        ]

        OutputStream os = new ByteArrayOutputStream()
        def reportBuilder = new HtmlReportBuilder(os)

        when:
        salesReport.createReport(reportBuilder)

        then:
        String output = new String(os.toByteArray())
        String date1 = LocalDate.now().minusDays(3).toString()
        String date2 = LocalDate.now().minusDays(2).toString()
        output == "<table><tr><td>" + date1 + "</td><td>100.0</td></tr><tr><td>" + date2 + "</td><td>321.5</td></tr></table>"

    }

    def "SalesReport constructs report using CsvBuilder"() {
        given:
        salesReport.saleService = Mock(SaleService)
        salesReport.saleService.sales >> [
                new Sale(LocalDate.now().minusDays(3), 100),
                new Sale(LocalDate.now().minusDays(2), 321.50)
        ]

        OutputStream os = new ByteArrayOutputStream()
        def reportBuilder = new CsvReportBuilder(os)

        when:
        salesReport.createReport(reportBuilder)

        then:
        String output = new String(os.toByteArray())
        String date1 = LocalDate.now().minusDays(3).toString()
        String date2 = LocalDate.now().minusDays(2).toString()
        output == date1 + ",100.0\n" + date2 + ",321.5\n"

    }
}
