package net.wdo

class OneDollarCoinHandler extends CoinHandler {


    public static final String DOLLAR = "One Dollar"

    @Override
    void handleRequest(RequestForMoneyChange request) {
        if (request.getAmount() > 5.0) {
            calculateTotalCoinsOneDollarMinus(request, 2.0)
        }
        else {
            calculateTotalCoinsOneDollarMinus(request, 1.0)
        }
        next(request)
    }

    private static void calculateTotalCoinsOneDollarMinus(RequestForMoneyChange request, double amountLeft) {
        double amountIn1DollarCoins = request.getAmount() - amountLeft
        int totalCoins = Math.abs(amountIn1DollarCoins)
        printTotalCoins(totalCoins, DOLLAR)
        request.reduce(amountIn1DollarCoins)
    }

}
