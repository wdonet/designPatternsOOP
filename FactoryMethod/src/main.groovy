import design.patterns.factory.PizzaStore
import design.patterns.factory.creator.concrete.CaliforniaPizzaStore
import design.patterns.factory.creator.concrete.ChicagoPizzaStore
import design.patterns.factory.creator.concrete.NYPizzaStore

PizzaStore nyPizzaStore = new NYPizzaStore()
PizzaStore chicagoPizzaStore = new ChicagoPizzaStore()
PizzaStore californiaPizzaStore = new CaliforniaPizzaStore()

nyPizzaStore.orderPizza("cheese")
chicagoPizzaStore.orderPizza("pepperoni")
californiaPizzaStore.orderPizza("veggie")