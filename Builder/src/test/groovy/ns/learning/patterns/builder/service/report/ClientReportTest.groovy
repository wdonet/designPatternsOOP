package ns.learning.patterns.builder.service.report

import ns.learning.patterns.builder.domain.Client
import ns.learning.patterns.builder.service.ClientService
import ns.learning.patterns.builder.service.report.builders.CsvReportBuilder
import ns.learning.patterns.builder.service.report.builders.HtmlReportBuilder
import spock.lang.Specification

class ClientReportTest extends Specification {

    def clientReport = new ClientReport()


    def "ClientReport constructs report using HtmlBuilder"() {
        given:
        clientReport.clientService = Mock(ClientService)
        clientReport.clientService.clients >> [
                new Client("Miguel González", "CDMX"),
                new Client("Jorge Pérez", "SLP")
        ]

        OutputStream os = new ByteArrayOutputStream()
        def reportBuilder = new HtmlReportBuilder(os)

        when:
        clientReport.createReport(reportBuilder)

        then:
        String output = new String(os.toByteArray())
        output == "<table><tr><td>Miguel González</td><td>CDMX</td></tr><tr><td>Jorge Pérez</td><td>SLP</td></tr></table>"

    }

    def "ClientReport constructs report using CsvBuilder"() {
        given:
        clientReport.clientService = Mock(ClientService)
        clientReport.clientService.clients >> [
                new Client("Miguel González", "CDMX"),
                new Client("Jorge Pérez", "SLP")
        ]

        OutputStream os = new ByteArrayOutputStream()
        def reportBuilder = new CsvReportBuilder(os)

        when:
        clientReport.createReport(reportBuilder)

        then:
        String output = new String(os.toByteArray())
        output == "Miguel González,CDMX\nJorge Pérez,SLP\n"

    }
}
