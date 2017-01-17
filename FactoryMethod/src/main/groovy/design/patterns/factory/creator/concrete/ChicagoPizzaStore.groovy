package design.patterns.factory.creator.concrete

import design.patterns.factory.creator.PizzaStore
import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.chicago.ChicagoStyleCheesePizza
import design.patterns.factory.product.concrete.chicago.ChicagoStylePepperoniPizza
import design.patterns.factory.product.concrete.chicago.ChicagoStyleVeggiePizza

class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new ChicagoStyleCheesePizza()
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza()
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new ChicagoStyleVeggiePizza()
        }
        return pizza
    }
}
