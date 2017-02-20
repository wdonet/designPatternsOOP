package net.wdo

class RequestForMoneyChange {

    double amount
    Date date
    String userName

    RequestForMoneyChange with(double amount) {
        this.amount = amount
        this
    }

    RequestForMoneyChange on(Date date) {
        this.date = date
        this
    }

    RequestForMoneyChange forUser(String name) {
        this.userName = name
        this
    }

    RequestForMoneyChange reduce(double amount) {
        this.amount -= amount
        this
    }
}
