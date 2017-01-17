package design.patterns.factory.creator.concrete

import design.patterns.factory.creator.PizzaStore
import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.ny.NYStyleCheesePizza
import design.patterns.factory.product.concrete.ny.NYStylePepperoniPizza
import design.patterns.factory.product.concrete.ny.NYStyleVeggiePizza

class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new NYStyleCheesePizza()
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new NYStylePepperoniPizza()
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new NYStyleVeggiePizza()
        }
        return pizza
    }
}
