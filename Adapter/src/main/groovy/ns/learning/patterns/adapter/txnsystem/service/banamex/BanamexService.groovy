package ns.learning.patterns.adapter.txnsystem.service.banamex

import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult
import ns.learning.patterns.adapter.txnsystem.service.Service

class BanamexService implements Service {

    @Override
    TransactionResult doSale(double amount, CardData cardData) {

        println 'Sale using Banamex'

        TransactionResult txnResult = new TransactionResult()

        txnResult.approvalCode = "222222"
        txnResult.reference = "BANANEX123"

        return txnResult
    }

    @Override
    TransactionResult doRefund(double amount, CardData cardData) {

        println 'Refund using Banamex'

        txnResult.approvalCode = "222222"
        txnResult.reference = "BANANEX123"

        return txnResult
    }

    @Override
    TransactionResult doAvoid(CardData cardData, String referenceNumber) {

        println 'Avoid using Banamex'

        txnResult.approvalCode = "222222"
        txnResult.reference = "BANANEX123"

        return txnResult
    }
}
