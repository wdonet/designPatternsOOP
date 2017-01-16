package design.patterns.factory.creator.concrete

import design.patterns.factory.PizzaStore
import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.california.CaliforniaStyleCheesePizza
import design.patterns.factory.product.concrete.california.CaliforniaStylePepperoniPizza
import design.patterns.factory.product.concrete.california.CaliforniaStyleVeggiePizza

class CaliforniaPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CaliforniaStyleCheesePizza()
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new CaliforniaStylePepperoniPizza()
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new CaliforniaStyleVeggiePizza()
        }
        return pizza
    }
}
