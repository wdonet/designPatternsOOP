package net.wdo

abstract class CoinHandler {

    CoinHandler successor

    abstract void handleRequest(RequestForMoneyChange request)

    void next(RequestForMoneyChange request) {
        if (null != successor) {
            successor.handleRequest(request)
        }
    }

    static void printTotalCoins(int totalCoins, String label) {
        println " - $totalCoins coins of $label"
    }

}
