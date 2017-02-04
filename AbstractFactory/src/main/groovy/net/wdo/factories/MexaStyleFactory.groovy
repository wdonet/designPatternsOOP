package net.wdo.factories

import net.wdo.AbstractPizza
import net.wdo.AbstractSide
import net.wdo.product.Fries
import net.wdo.product.MexaPizza

class MexaStyleFactory extends AbstractFoodFactory {

    @Override
    AbstractPizza preparePizza() {
        new MexaPizza()
    }

    @Override
    AbstractSide prepareSide() {
        new Fries()
    }
}
