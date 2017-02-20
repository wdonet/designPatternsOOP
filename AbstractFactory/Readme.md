# Abstract Factory Pattern (Creational)
> Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

It often is implemented with _Factory Method Pattern_ but it can also be implemented using _Prototype_.  Storing a set of prototypes from which to clone and return product objects.

## Problem
In order to make something portable or with loose coupling, it needs to encapsulate dependencies and frequently you'll find the need of lots of if-else case statements to deal with the dependency options that should be provided.

Also the new operator is considered harmful or costly. To avoid instantiating each time, the AbstractFactory class, or an external class (_StyleFactoryCreator in the code_), could hold an singleton instance of the internal factories.

## Solution
Provide different kind of factories through another Factory. Each factory will create a certain kind of related objects.  We'll need an abstract classes per Factory and per Product, then as many concrete factories and products will be needed. For instance,

- AbstractFactory (AutomobileFactory)
- ConcreteFactroy (FordFactory and ToyotaFactory)
- AbstractProduct (Sedan, Truck)
- ConcreteProduct (FordSedan, FordTruck and ToyotaSedan, ToyotaTruck)

or following the example in the code:

- AbstractFactory (AbstractFoodFactory)
- ConcreteFactroy (MexaStyleFactory and ItalianStyleFactory)
- AbstractProduct (AbstractPizza, AbstractSide)
- ConcreteProduct (MexaPizza, Fries and ItalianPizza, CheeseSticks)

### Pros
- It is good in terms of abstraction and security

### Cons
- It's rare but if the interface provided by Abstract Factory change, all factories need to change too.  It's a problem suffered by all programs designed with the philosophy _"Program to an interface, not an implementation"_.

## Realted design patterns
- **Simple Factory Pattern**. It lets you hide the creation of same-interface-objects with no caring of the concrete classes creation.  All the objects creation are inside the Factory class based on an input.  Internally it's resolved by using a switch case. This makes developers to change the switch case and the internal implementation every time a new concrete classes is added, violating to the Open Close Principle of the [SOLID](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)).  It is not considered in the [Gang of Four (GOF)](https://en.wikipedia.org/wiki/Design_Patterns) book, though.
- [Factory Method Pattern](../FactoryMethod) which defines an interface for creating an object so that subclasses decide which class to instantiate.  Avoids the use of the switch case and an input for the decision.  It leaves the implementation to each factory by concrete class type. Unit Testing also benefits since the code is separated and easier to test.
- The difference between _Simple Factory Pattern_ and _Factory Method Pattern_ is that they provide one kind of objects only while _Abstract Factory_ provides several kinds.

## Classes
![Classes Diagram](http://i.imgur.com/RPXJ9q5.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml

title "Abstract Factory Pattern"
class Client {
}

abstract class AbstractFactory <<F,factory>> {
    abstract operation1()
    abstract operation2()
}

class Product1Factory <<F,factory>> extends AbstractFactory {
    +operation1()
    +operation2()
}

class Product2Factory <<F,factory>> extends AbstractFactory {
    +operation1()
    +operation2()
}

abstract class AbstractProductA {
}
class ProductA1 extends AbstractProductA {
}
class ProductA2 extends AbstractProductA {
}

abstract class AbstractProductB {
}
class ProductB1 extends AbstractProductB {
}
class ProductB2 extends AbstractProductB {
}

AbstractFactory <|--up-- Client
AbstractProductA <|--up-- Client
AbstractProductB <|--up-- Client
ProductA1 <|--down-- Product1Factory
ProductB1 <|--down-- Product1Factory
ProductA2 <|--left-- Product2Factory
ProductB2 <|--left-- Product2Factory

@enduml
```

Diagram for example in code:

![Example in code](http://i.imgur.com/YcvsScf.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml

title "Abstract Factory Pattern"
class Client {
}

abstract class AbstractFoodFactory <<F,factory>> {
    abstract preparePizza()
    abstract prepareSide()
}

class MexaStyleFactory <<F,factory>> extends AbstractFoodFactory {
    +preparePizza()
    +prepareSide()
}

class ItalianStyleFactory <<F,factory>> extends AbstractFoodFactory {
    +preparePizza()
    +prepareSide()
}

abstract class AbstractPizza {
    +String prepare()
    +String bake()
}
class MexaPizza <<Mexa>> extends AbstractPizza {
    +String prepare()
    +String bake()
}
class ItalianPizza <<Italian>> extends AbstractPizza {
    +String prepare()
    +String bake()
}

abstract class AbstractSide {
}
class Fries <<Mexa>> extends AbstractSide {
}
class CheeseSticks <<Italian>> extends AbstractSide {
}

AbstractFoodFactory <|--up-- Client
AbstractPizza <|--up-- Client
AbstractSide <|--up-- Client
MexaPizza <|--down-- MexaStyleFactory
Fries <|--down-- MexaStyleFactory
ItalianPizza <|--left-- ItalianStyleFactory
CheeseSticks <|--left-- ItalianStyleFactory

@enduml
```

[![Video Description](http://img.youtube.com/vi/DgAKEPD9TyY/0.jpg)](http://www.youtube.com/watch?v=DgAKEPD9TyY)
