package ns.learning.patterns.adapter.txnsystem.service.bancomer

import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult
import ns.learning.patterns.adapter.txnsystem.service.Service

class BancomerService implements Service {

    @Override
    TransactionResult doSale(double amount, CardData cardData) {

        println 'Sale using Bancomer'

        txnResult.approvalCode = "333333"
        txnResult.reference = "BANCOMER123"

        return txnResult
    }

    @Override
    TransactionResult doRefund(double amount, CardData cardData) {

        println 'Refund using Bancomer'

        txnResult.approvalCode = "333333"
        txnResult.reference = "BANCOMER123"

        return txnResult
    }

    @Override
    TransactionResult doAvoid(CardData cardData, String referenceNumber) {

        println 'Avoid using Bancomer'

        txnResult.approvalCode = "333333"
        txnResult.reference = "BANCOMER123"

        return txnResult
    }
}
