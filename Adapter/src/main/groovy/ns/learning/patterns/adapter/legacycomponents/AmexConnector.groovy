package ns.learning.patterns.adapter.legacycomponents

class AmexConnector {

    AmexResult doSale(double amount, String account, String fourDBC, String expirationDate) {
        println 'Sale in Amex connector: '

        AmexResult amexResult = new AmexResult()

        amexResult.approvalCode = '123456'
        amexResult.reference = '000987123765'

        return amexResult
    }

    AmexResult doAvoid(double amount, String account, String fourDBC, String expirationDate, String txnReference) {
        println 'Avoid in Amex connector'

        AmexResult amexResult = new AmexResult()

        amexResult.approvalCode = '123456'
        amexResult.reference = txnReference

        return amexResult
    }

    AmexResult doRefund(double amount, String account, String fourDBC, String expirationDate) {
        println 'Refund in Amex connector'

        AmexResult amexResult = new AmexResult()

        amexResult.approvalCode = '123456'
        amexResult.reference = '000987123765'

        return amexResult
    }
}
