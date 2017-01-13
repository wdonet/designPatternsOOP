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

//Creator
abstract class PizzaStoreV3 {

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

//Concrete creator
class NYPizzaStore extends PizzaStoreV3 {
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

class ChicagoPizzaStore extends PizzaStoreV3 {
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

class CaliforniaPizzaStore extends PizzaStoreV3 {
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