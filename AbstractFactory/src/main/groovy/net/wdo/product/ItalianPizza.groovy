package net.wdo.product

import net.wdo.AbstractPizza

class ItalianPizza extends AbstractPizza {

    @Override
    String prepare() {
        "Preparing an Italian Pizza"
    }

    @Override
    String bake() {
        "Baking an Italian Pizza"
    }

}
