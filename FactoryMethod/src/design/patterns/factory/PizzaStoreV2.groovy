package design.patterns.factory

import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.CheesePizza
import design.patterns.factory.product.concrete.PepperoniPizza
import design.patterns.factory.product.concrete.VeggiePizza

/**
 * Encapsulating object creation
 *
 */
class PizzaStoreV2 {
    SimplePizzaFactory factory

    PizzaStoreV2(SimplePizzaFactory factory) {
        this.factory = factory
    }

    Pizza orderPizza(String type) {
        Pizza pizza

        pizza = factory.createPizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

}

/**
 * Class that is only going to be concerned with
 * creating pizzas
 */
class SimplePizzaFactory {

    Pizza createPizza(String type) {
        Pizza pizza

        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza()
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza()
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza()
        }

        return pizza
    }
}