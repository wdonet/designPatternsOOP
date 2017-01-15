package net.wdo.domain.product

import net.wdo.domain.AbstractPizza

class MexaPizza extends AbstractPizza {

    @Override
    String prepare() {
        "Preparing a Mexa Pizza"
    }

    @Override
    String bake() {
        "Baking a Mexa Pizza"
    }

}
