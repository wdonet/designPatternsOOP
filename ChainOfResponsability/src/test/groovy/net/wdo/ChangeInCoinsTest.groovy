package net.wdo

import spock.lang.Specification

class ChangeInCoinsTest extends Specification{

    def 'Should change 10 dollar bill in coins'() {
        given:
        double bill = 10.0
        RequestForMoneyChange request = new RequestForMoneyChange()
                .with(bill).on(new Date()).forUser("German")
        CoinHandler dollarsHandler = setHandlers()

        when:
        dollarsHandler.handleRequest(request)

        then:
        true
    }

    def 'Should change 5 dollar bill in coins'() {
        given:
        double bill = 5.0
        RequestForMoneyChange request = new RequestForMoneyChange()
                .with(bill).on(new Date()).forUser("Tara")
        CoinHandler dollarsHandler = setHandlers()

        when:
        dollarsHandler.handleRequest(request)

        then:
        true
    }

    def 'Should change 1 dollar bill in coins'() {
        given:
        double bill = 1.0
        RequestForMoneyChange request = new RequestForMoneyChange()
                .with(bill).on(new Date()).forUser("Tara")
        CoinHandler dollarsHandler = setHandlers()

        when:
        dollarsHandler.handleRequest(request)

        then:
        true
    }

    private static CoinHandler setHandlers() {
        CoinHandler centsHandler = new CentCoinHandler()
        CoinHandler quartersHandler = new QuarterOfDollarCoinHandler()
        CoinHandler halfsHandler = new HalfDollarCoinHandler()
        CoinHandler dollarsHandler = new OneDollarCoinHandler()
        dollarsHandler.setSuccessor(halfsHandler)
        halfsHandler.setSuccessor(quartersHandler)
        quartersHandler.setSuccessor(centsHandler)
        dollarsHandler
    }
}
