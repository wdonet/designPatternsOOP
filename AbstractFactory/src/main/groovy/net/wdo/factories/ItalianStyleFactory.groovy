package net.wdo.factories

import net.wdo.domain.AbstractPizza
import net.wdo.domain.AbstractSide
import net.wdo.domain.product.CheeseSticks
import net.wdo.domain.product.ItalianPizza

class ItalianStyleFactory extends AbstractFoodFactory {
    @Override
    AbstractPizza preparePizza() {
        new ItalianPizza()
    }

    @Override
    AbstractSide prepareSide() {
        new CheeseSticks()
    }
}
