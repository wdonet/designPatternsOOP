package net.wdo.factories

import net.wdo.domain.AbstractPizza
import net.wdo.domain.AbstractSide

abstract class AbstractFoodFactory {

    abstract AbstractPizza preparePizza()
    abstract AbstractSide prepareSide()
}
