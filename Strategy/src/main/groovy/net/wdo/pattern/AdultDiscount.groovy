package net.wdo.pattern

import net.wdo.domain.Traveler

class AdultDiscount implements DiscountStrategy {

    Traveler traveler

    @Override
    DiscountStrategy forTraveler(Traveler traveler) {
        setTraveler traveler
        this
    }

    @Override
    double calculateDiscountForPrice(double price) {
        if (traveler.getAge() >= 60)
            price * 0.4
        else
            0
    }
}
