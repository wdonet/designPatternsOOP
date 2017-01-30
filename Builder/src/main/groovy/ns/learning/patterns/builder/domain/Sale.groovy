package ns.learning.patterns.builder.domain;

import java.time.LocalDate;

class Sale {

    Sale() {

    }

    Sale(LocalDate date, double amount) {
        this.date = date
        this.amount = amount
    }

    LocalDate date
    double amount
}
