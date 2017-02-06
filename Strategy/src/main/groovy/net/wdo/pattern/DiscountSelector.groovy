package net.wdo.pattern

import net.wdo.domain.Adult
import net.wdo.domain.Child
import net.wdo.domain.InfantInLap
import net.wdo.domain.InfantInSeat
import net.wdo.domain.Traveler

class DiscountSelector {

    static DiscountStrategy getDiscount(Traveler traveler) {
        DiscountStrategy discount
        if (traveler instanceof Adult) {
            discount = new AdultDiscount()
        }
        else if (traveler instanceof Child) {
            discount = new ChildDiscount()
        }
        else if (traveler instanceof InfantInLap || traveler instanceof InfantInSeat) {
            discount = new InfantDiscount()
        }
        else {
            discount = new DefaultDiscountByMonth()
        }
        print("${discount.getClass().getSimpleName()} for ${traveler.getClass().getSimpleName()}")
        discount.forTraveler(traveler)
    }

    static double calculateDiscount(Traveler traveler, double price) {
        def calculatedDiscount = getDiscount(traveler).calculateDiscountForPrice(price)
        println(": - $calculatedDiscount \t\tTotal: ${price - calculatedDiscount}")
        calculatedDiscount
    }
}
