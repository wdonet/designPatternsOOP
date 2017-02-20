package net.wdo

class CentCoinHandler extends CoinHandler {


    public static final String CENT = "a cent"

    @Override
    void handleRequest(RequestForMoneyChange request) {
        int totalCoins = Math.abs(request.getAmount() / 0.01)
        printTotalCoins(totalCoins, CENT)
    }

}
