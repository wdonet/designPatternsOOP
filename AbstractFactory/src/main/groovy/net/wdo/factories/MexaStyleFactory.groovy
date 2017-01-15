package net.wdo.factories

import net.wdo.domain.AbstractPizza
import net.wdo.domain.AbstractSide
import net.wdo.domain.product.Fries
import net.wdo.domain.product.MexaPizza

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
