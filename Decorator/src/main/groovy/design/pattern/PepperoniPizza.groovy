package design.pattern

class PepperoniPizza implements PizzaComponent {

    @Override
    double cost() {
        return 120.00
    }

    @Override
    String description() {
        return "Pepperoni pizza"
    }
}
