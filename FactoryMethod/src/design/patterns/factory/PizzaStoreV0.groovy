package design.patterns.factory

import design.patterns.factory.product.Pizza
import design.patterns.factory.product.concrete.style.california.CaliforniaStyleCheesePizza
import design.patterns.factory.product.concrete.style.california.CaliforniaStylePepperoniPizza
import design.patterns.factory.product.concrete.style.california.CaliforniaStyleVeggiePizza
import design.patterns.factory.product.concrete.style.chicago.ChicagoStyleCheesePizza
import design.patterns.factory.product.concrete.style.chicago.ChicagoStylePepperoniPizza
import design.patterns.factory.product.concrete.style.chicago.ChicagoStyleVeggiePizza
import design.patterns.factory.product.concrete.style.ny.NYStyleCheesePizza
import design.patterns.factory.product.concrete.style.ny.NYStylePepperoniPizza
import design.patterns.factory.product.concrete.style.ny.NYStyleVeggiePizza

/**
 * Created by ahernandez on 1/10/17.
 */
class PizzaStoreV0 {

    Pizza orderPizza(String style, String type) {
        Pizza pizza = null;
        if(style.equalsIgnoreCase("NY")) {
            if(type.equalsIgnoreCase("cheese")) {
                pizza = new NYStyleCheesePizza()
            } else if(type.equalsIgnoreCase("pepperoni")) {
                pizza = new NYStylePepperoniPizza()
            } else if(type.equalsIgnoreCase("veggie")) {
                pizza = new NYStyleVeggiePizza()
            }
        } else if (style.equalsIgnoreCase("Chicago")) {
            if(type.equalsIgnoreCase("cheese")) {
                pizza = new ChicagoStyleCheesePizza()
            } else if(type.equalsIgnoreCase("pepperoni")) {
                pizza = new ChicagoStylePepperoniPizza()
            } else if(type.equalsIgnoreCase("veggie")) {
                pizza = new ChicagoStyleVeggiePizza()
            }
        } else if(style.equalsIgnoreCase("California")) {
            if(type.equalsIgnoreCase("cheese")) {
                pizza = new CaliforniaStyleCheesePizza()
            } else if(type.equalsIgnoreCase("pepperoni")) {
                pizza = new CaliforniaStylePepperoniPizza()
            } else if(type.equalsIgnoreCase("veggie")) {
                pizza = new CaliforniaStyleVeggiePizza()
            }
        }

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }
}
