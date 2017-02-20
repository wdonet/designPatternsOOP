package net.wdo

class HalfDollarCoinHandler extends CoinHandler {


    public static final String HALF_DOLLAR = "Half-Dollar"

    @Override
    void handleRequest(RequestForMoneyChange request) {
        if (request.getAmount() > 1.0) {
            calculateTotalCoinsOneDollarMinus(request, 1.0)
        }
        else {
            calculateTotalCoinsOneDollarMinus(request, 0.5)
        }
        next(request)
    }

    private void calculateTotalCoinsOneDollarMinus(RequestForMoneyChange request, double amountLeft) {
        double amountInHalfDollarCoins = request.getAmount() - amountLeft
        int totalCoins = Math.abs(amountInHalfDollarCoins/0.5)
        printTotalCoins(totalCoins, HALF_DOLLAR)
        request.reduce(amountInHalfDollarCoins)
    }

}
