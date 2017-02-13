import design.pattern.HotSauceToppingDecorator
import design.pattern.MushroomToppingDecorator
import design.pattern.PepperoniPizza
import design.pattern.PizzaComponent
import spock.lang.Specification

class DecoratorTest extends Specification {


    def "Simple pizza"() {
        setup:
        PizzaComponent pizza = new PepperoniPizza()

        when:
        double cost = pizza.cost()
        println "Cost: ${cost}"
        String description = pizza.description()
        println "Description: ${description}"

        then:
        cost == 120
        description == "Pepperoni pizza"
    }

    def "Decorating pizza with Mushroom"() {
        setup:
        PizzaComponent pizza = new PepperoniPizza()
        pizza = new MushroomToppingDecorator(pizza)

        when:
        double cost = pizza.cost()
        println "Cost: ${cost}"
        String description = pizza.description()
        println "Description: ${description}"

        then:
        cost == 135
        description == "Pepperoni pizza, mushroom topping"
    }

    def "Decorating pizza with Mushroom and Hot Sauce"() {
        setup:
        PizzaComponent pizza = new PepperoniPizza()
        pizza = new MushroomToppingDecorator(pizza)
        pizza = new HotSauceToppingDecorator(pizza)

        when:
        double cost = pizza.cost()
        println "Cost: ${cost}"
        String description = pizza.description()
        println "Description: ${description}"

        then:
        cost == 145.5
        description == "Pepperoni pizza, mushroom topping, hot sauce"
    }
}
