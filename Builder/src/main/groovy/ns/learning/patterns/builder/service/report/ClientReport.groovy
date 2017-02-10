package ns.learning.patterns.builder.service.report

import ns.learning.patterns.builder.domain.Client
import ns.learning.patterns.builder.service.ClientService
import ns.learning.patterns.builder.service.report.builders.ReportTableBuilder

class ClientReport {

    ClientService clientService

    void createReport(ReportTableBuilder reportTableBuilder) {
        List<Client> clients = clientService.clients

        reportTableBuilder.startTable()

        clients.each { client ->
            reportTableBuilder.startRow()

            reportTableBuilder.startColumn()
            reportTableBuilder.cellValue = client.name
            reportTableBuilder.endColumn()

            reportTableBuilder.startColumn()
            reportTableBuilder.cellValue = client.city
            reportTableBuilder.endColumn()

            reportTableBuilder.endRow()
        }

        reportTableBuilder.endTable()
    }

}
