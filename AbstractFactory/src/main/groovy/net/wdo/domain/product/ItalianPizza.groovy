package net.wdo.domain.product

import net.wdo.domain.AbstractPizza

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
