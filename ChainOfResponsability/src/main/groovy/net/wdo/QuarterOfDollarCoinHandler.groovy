package net.wdo

class QuarterOfDollarCoinHandler extends CoinHandler {


    public static final String QUARTER_OF_DOLLAR = "Quarter-of-Dollar"

    @Override
    void handleRequest(RequestForMoneyChange request) {
        if (request.getAmount() > 0.5) {
            calculateTotalCoinsOneDollarMinus(request, 0.5)
        }
        else {
            calculateTotalCoinsOneDollarMinus(request, 0.25)
        }
        next(request)
    }

    private void calculateTotalCoinsOneDollarMinus(RequestForMoneyChange request, double amountLeft) {
        double amountInQuarterOfDollarCoins = request.getAmount() - amountLeft
        int totalCoins = Math.abs(amountInQuarterOfDollarCoins/0.25)
        printTotalCoins(totalCoins, QUARTER_OF_DOLLAR)
        request.reduce(amountInQuarterOfDollarCoins)
    }

}
