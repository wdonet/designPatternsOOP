package design.patterns.factory.v1

import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.CheesePizza
import design.patterns.factory.product.concrete.PepperoniPizza
import design.patterns.factory.product.concrete.VeggiePizza

/**
 * Created by ahernandez on 1/10/17.
 */
class PizzaStoreV1 {

    Pizza orderPizza(String type) {
        Pizza pizza
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza()
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza()
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza()
        }

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }
}
