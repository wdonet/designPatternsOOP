package net.wdo.pattern

import net.wdo.domain.Traveler

import java.time.LocalDate
import java.time.Month

class DefaultDiscountByMonth implements DiscountStrategy {

    @Override
    DiscountStrategy forTraveler(Traveler traveler) {
        this
    }

    @Override
    double calculateDiscountForPrice(double price) {
        int discount = 0
        switch (getCurrentMonth()) {
            case Month.JANUARY: discount = 5; break
            case Month.FEBRUARY: discount = 3; break
            case Month.MAY: discount = 7; break
            case Month.SEPTEMBER: discount = 10; break
            case Month.NOVEMBER: discount = 15; break
            case Month.DECEMBER: discount = 25; break
        }
        price * discount/100
    }

    protected Month getCurrentMonth() {
        LocalDate.now().getMonth()
    }
}
