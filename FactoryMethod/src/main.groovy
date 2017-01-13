import design.patterns.factory.CaliforniaPizzaStore
import design.patterns.factory.ChicagoPizzaStore
import design.patterns.factory.NYPizzaStore
import design.patterns.factory.PizzaStoreV0
import design.patterns.factory.PizzaStoreV2
import design.patterns.factory.PizzaStoreV3
import design.patterns.factory.SimplePizzaFactory
import design.patterns.factory.PizzaStoreV1

// ### Version 0
PizzaStoreV0 pizzaStoreV0 = new PizzaStoreV0()
pizzaStoreV0.orderPizza("NY", "cheese")
println "-------"

// ### Version 1
PizzaStoreV1 pizzaStoreV1 = new PizzaStoreV1()
pizzaStoreV1.orderPizza("cheese")
println "-------"

// ### Version 2
SimplePizzaFactory factory = new SimplePizzaFactory()
PizzaStoreV2 pizzaStoreV2 = new PizzaStoreV2(factory)
pizzaStoreV2.orderPizza("pepperoni")
println "-------"

// ### Version 3
PizzaStoreV3 nyPizzaStore = new NYPizzaStore()
PizzaStoreV3 chicagoPizzaStore = new ChicagoPizzaStore()
PizzaStoreV3 californiaPizzaStore = new CaliforniaPizzaStore()

nyPizzaStore.orderPizza("cheese")
chicagoPizzaStore.orderPizza("pepperoni")
californiaPizzaStore.orderPizza("veggie")