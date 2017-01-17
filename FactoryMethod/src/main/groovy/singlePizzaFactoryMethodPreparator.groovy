

abstract class Pizza {
    abstract void prepare()
}
class MexaPizza extends Pizza {
    void prepare() {
        println("con queso o sin queso?")
    }
}
class ItalianPizza extends Pizza {
    void prepare() {
        println("preparare il migliore della tua vita")
    }
}
abstract class PizzaPreparator {
    abstract Pizza createPizza() //Factory method
}
class MexaStylePizzaPreparator extends PizzaPreparator {
    Pizza createPizza() {
        return new MexaPizza();
    }
}
class ItalianPizzaPreparator extends PizzaPreparator {
    Pizza createPizza() {
        return new ItalianPizza()
    }
}

// main program
PizzaPreparator factory

//using one factory
factory = new MexaStylePizzaPreparator()
factory.createPizza().prepare()

//using another factory (same way, different implementation)
factory = new ItalianPizzaPreparator()
factory.createPizza().prepare()

