package net.wdo.factories

import net.wdo.AbstractPizza
import net.wdo.AbstractSide

abstract class AbstractFoodFactory {

    abstract AbstractPizza preparePizza()
    abstract AbstractSide prepareSide()
}
