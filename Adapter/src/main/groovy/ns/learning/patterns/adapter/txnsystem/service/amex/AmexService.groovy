package ns.learning.patterns.adapter.txnsystem.service.amex

import ns.learning.patterns.adapter.legacycomponents.AmexConnector
import ns.learning.patterns.adapter.legacycomponents.AmexResult
import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult
import ns.learning.patterns.adapter.txnsystem.service.Service

class AmexService implements Service {

    private AmexConnector amexConnector = new AmexConnector();

    @Override
    TransactionResult doSale(double amount, CardData cardData) {

        println 'Sale using Amex'

        AmexResult amexResult = amexConnector.doSale(amount, cardData.account, cardData.cvv, cardData.expirationDate)

        TransactionResult txnResult = new TransactionResult()

        txnResult.approvalCode = amexResult.approvalCode
        txnResult.reference = amexResult.reference

        return txnResult
    }

    @Override
    TransactionResult doRefund(double amount, CardData cardData) {

        println 'Refund using Amex'

        AmexResult amexResult = amexConnector.doRefund(amount, cardData.account, cardData.cvv, cardData.expirationDate)

        TransactionResult txnResult = new TransactionResult()

        txnResult.approvalCode = amexResult.approvalCode
        txnResult.reference = amexResult.reference

        return txnResult
    }

    @Override
    TransactionResult doAvoid(CardData cardData, String referenceNumber) {

        println 'Avoid using Amex'

        AmexResult amexResult = amexConnector.doAvoid(amount, cardData.account, cardData.cvv, cardData.expirationDate, referenceNumber)

        TransactionResult txnResult = new TransactionResult()

        txnResult.approvalCode = amexResult.approvalCode
        txnResult.reference = amexResult.reference

        return txnResult
    }
}
