package design.patterns.factory

import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.CheesePizza
import design.patterns.factory.product.concrete.PepperoniPizza
import design.patterns.factory.product.concrete.VeggiePizza

class PizzaStoreV1 {

    Pizza orderPizza(String type) {

        Pizza pizza

        // If the PizzaStore needs to add/remove its pizza
        // offering we have to update this section
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza()
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza()
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza()
        }

        // This is what we expect to stay the same
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }
}
