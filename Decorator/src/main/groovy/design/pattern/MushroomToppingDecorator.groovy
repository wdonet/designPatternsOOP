package design.pattern

class MushroomToppingDecorator extends ToppingDecorator {

    MushroomToppingDecorator(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent
    }

    @Override
    double cost() {
        return 15 + pizzaComponent.cost()
    }

    @Override
    String description() {
        return pizzaComponent.description() + ", mushroom topping"
    }
}
