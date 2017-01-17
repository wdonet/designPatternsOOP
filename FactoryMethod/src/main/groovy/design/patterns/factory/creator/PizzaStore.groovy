package design.patterns.factory.creator

import design.patterns.factory.product.Pizza

//Creator
abstract class PizzaStore {

    Pizza orderPizza(String type) {
        Pizza pizza

        pizza = createPizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    //factoryMethod
    abstract Pizza createPizza(String type);
}