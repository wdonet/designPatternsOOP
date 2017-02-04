package net.wdo.pattern

import net.wdo.domain.Traveler

interface DiscountStrategy {

    DiscountStrategy forTraveler(Traveler traveler)
    double calculateDiscountForPrice(double price)

}