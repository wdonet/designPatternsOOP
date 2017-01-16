package ns.learning.patterns.adapter.txnsystem.service.prosa

import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult
import ns.learning.patterns.adapter.txnsystem.service.Service

class ProsaService implements Service {

    @Override
    TransactionResult doSale(double amount, CardData cardData) {
        println 'Sale using Prosa'

        txnResult.approvalCode = "444444"
        txnResult.reference = "PROSA123"

        return txnResult
    }

    @Override
    TransactionResult doRefund(double amount, CardData cardData) {
        println 'Refund using Prosa'

        txnResult.approvalCode = "444444"
        txnResult.reference = "PROSA123"

        return txnResult
    }

    @Override
    TransactionResult doAvoid(CardData cardData, String referenceNumber) {
        println 'Avoid using Prosa'

        txnResult.approvalCode = "444444"
        txnResult.reference = "PROSA123"

        return txnResult
    }
}
