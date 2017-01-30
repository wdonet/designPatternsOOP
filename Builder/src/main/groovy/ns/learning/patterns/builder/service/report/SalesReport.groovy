package ns.learning.patterns.builder.service.report

import ns.learning.patterns.builder.domain.Sale
import ns.learning.patterns.builder.service.SaleService
import ns.learning.patterns.builder.service.report.builders.ReportTableBuilder

class SalesReport {

    SaleService saleService;

    void createReport(ReportTableBuilder reportTableBuilder) {
        List<Sale> sales = saleService.sales

        reportTableBuilder.startTable()

        sales.each { sale ->
            reportTableBuilder.startRow()

            reportTableBuilder.startColumn()
            reportTableBuilder.cellValue = sale.date
            reportTableBuilder.endColumn()

            reportTableBuilder.startColumn()
            reportTableBuilder.cellValue = sale.amount
            reportTableBuilder.endColumn()

            reportTableBuilder.endRow()
        }

        reportTableBuilder.endTable()

    }

}
