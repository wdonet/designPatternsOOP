package design.pattern

class HotSauceToppingDecorator extends ToppingDecorator {

    HotSauceToppingDecorator(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent
    }

    @Override
    double cost() {
        return 10.5 + pizzaComponent.cost()
    }

    @Override
    String description() {
        return pizzaComponent.description() + ", hot sauce"
    }
}
