import design.patterns.factory.CaliforniaPizzaStore
import design.patterns.factory.ChicagoPizzaStore
import design.patterns.factory.NYPizzaStore
import design.patterns.factory.PizzaStore

PizzaStore nyPizzaStore = new NYPizzaStore()
PizzaStore chicagoPizzaStore = new ChicagoPizzaStore()
PizzaStore californiaPizzaStore = new CaliforniaPizzaStore()

nyPizzaStore.orderPizza("cheese")
chicagoPizzaStore.orderPizza("pepperoni")
californiaPizzaStore.orderPizza("veggie")