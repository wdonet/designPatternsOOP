package net.wdo.pattern

import net.wdo.domain.InfantInLap
import net.wdo.domain.Traveler

class InfantDiscount implements DiscountStrategy {

    Traveler traveler

    @Override
    DiscountStrategy forTraveler(Traveler traveler) {
        setTraveler traveler
        this
    }

    @Override
    double calculateDiscountForPrice(double price) {
        if (traveler instanceof InfantInLap && traveler.getAge() == 1) {
            return price * 0.8
        }
        price * 0.7
    }
}
