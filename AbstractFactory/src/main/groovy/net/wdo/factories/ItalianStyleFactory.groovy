package net.wdo.factories

import net.wdo.AbstractPizza
import net.wdo.AbstractSide
import net.wdo.product.CheeseSticks
import net.wdo.product.ItalianPizza

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
