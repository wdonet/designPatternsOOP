package design.patterns.factory.product.concrete

import design.patterns.factory.product.Pizza

/**
 * Created by ahernandez on 1/10/17.
 */
class NYStyleCheesePizza implements Pizza {
    @Override
    void prepare() {
        println "Preparing "
    }

    @Override
    void bake() {

    }

    @Override
    void cut() {

    }

    @Override
    void box() {

    }
}
