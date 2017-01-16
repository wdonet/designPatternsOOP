package ns.learning.patterns.adapter.txnsystem.service

import ns.learning.patterns.adapter.txnsystem.domain.CardData
import ns.learning.patterns.adapter.txnsystem.domain.TransactionResult

interface Service {

    TransactionResult doSale(double amount, CardData cardData)

    TransactionResult doRefund(double amount, CardData cardData)

    TransactionResult doAvoid(CardData cardData, String referenceNumber)
}