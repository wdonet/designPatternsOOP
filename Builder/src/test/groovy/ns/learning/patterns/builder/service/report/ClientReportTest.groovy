package ns.learning.patterns.builder.service.report

import ns.learning.patterns.builder.domain.Client
import ns.learning.patterns.builder.service.ClientService
import ns.learning.patterns.builder.service.report.builders.HtmlReportBuilder
import ns.learning.patterns.builder.service.report.builders.PDFReportBuilder
import ns.learning.patterns.builder.service.report.builders.XlsReportBuilder
import spock.lang.Specification

class ClientReportTest extends Specification {

    def clientReport = new ClientReport()


    def "ClientReport constructs report using different Builders"() {
        given:
        clientReport.clientService = Mock(ClientService)

        when:
        clientReport.clientService.clients >> [
                new Client("Miguel González", "CDMX"),
                new Client("Jorge Pérez", "SLP")
        ]
        OutputStream os = new ByteArrayOutputStream()
        def htmlReportBuilder = new HtmlReportBuilder(os)
        def pdfReportBuilder = new PDFReportBuilder(os)
        def xlsReportBuilder = new XlsReportBuilder(os)

        then:
        clientReport.createReport(htmlReportBuilder)
        clientReport.createReport(pdfReportBuilder)
        clientReport.createReport(xlsReportBuilder)

    }
}
