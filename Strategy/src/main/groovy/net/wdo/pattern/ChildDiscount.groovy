package net.wdo.pattern

import net.wdo.domain.Traveler

class ChildDiscount implements DiscountStrategy {

    @Override
    DiscountStrategy forTraveler(Traveler traveler) {
        //do Nothing
        this
    }

    @Override
    double calculateDiscountForPrice(double price) {
        price * 0.5
    }
}
