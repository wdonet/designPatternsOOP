package ns.learning.patterns.adapter

import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult
import ns.learning.patterns.adapter.txnsystem.service.Service
import ns.learning.patterns.adapter.txnsystem.service.banamex.BanamexService
import spock.lang.Specification

class BanamexTest extends Specification {

    def "doSale in Banamex Service"() {

        setup:
        Service service = new BanamexService()
        CardData cardData = new CardData()
        double someAmount = 1000

        cardData.setAccount('4152312917927078')
        cardData.setExpirationDate('0320')
        cardData.setCvv('123')

        when:
        TransactionResult transactionResult = service.doSale(someAmount, cardData)

        then:
        !(transactionResult.approvalCode.isEmpty() || transactionResult.reference.isEmpty())
    }
}