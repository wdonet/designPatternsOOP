# Factory Method Pattern
This pattern belongs to **Creational Patterns**. It defines an interface for creating an object, but
lets subclasses decide which class to instantiate at run time.


## Problem
Instantiating concrete classes makes fragile and less flexible code, i.e.
```java
    CheesePizza cheesePizza = new CheesePizza();
```

It's better to use an interface, i.e.
```java
    Pizza cheesePizza = new CheesePizza();
```
This allows flexible code by using polymorphism.

When having a set of concrete classes we often are forced to code:
```java
    Pizza pizza;
    
    if(type.equals("cheese")) {
        pizza = new CheesePizza();
    } else if(type.equals("pepperoni")) {
        pizza = new PepperoniPizza();
    } else if(type.equals("veggie")) {
        pizza = new VeggiePizza();
    }
```

If we need to change or extend we have to update this code, and if we don't have this centralized
we need to update every where this is present.

We can say this is not closed for modification.

If we need to create different styles we could do something like:

```java
    Pizza pizza;
    
    if(style.equals("NY")) {
        if(type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if(type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if(type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        }
    } else {
        if(type.equals("cheese")) {
            pizza = new DefaultStyleCheesePizza();
        } else if(type.equals("pepperoni")) {
            pizza = new DefaultStylePepperoniPizza();
        } else if(type.equals("veggie")) {
            pizza = new DefaultStyleVeggiePizza();
        }
    }
```


## Applicability

Use the Factory Method Pattern when:

- A class can not anticipate the class of objects it must to create
- To centralize object creation code
- When you don't want the client to have to know every subclass


## Characteristics
- Factories handle the detail of object creation
  - Encapsulates object creation
  - Create objects without exposing the creation logic
- The creation occurs through inheritance
  - Object creation is delegated to subclasses
- Client only need to know the abstract type to use
- Factory returns one of the several possible classes that share a common super class
- Keep application loosely coupled and less dependent


## Actors

![Image of Factory Pattern]
(https://github.com/wdonet/designPatternsOOP/blob/ahernandez/factoryPattern/FactoryMethod/Factory_Method_UML_class_diagram.png)

- **Creator**: Provides a method for creating objects **(Factory Method)** and also all the methods to manipulate products
- **Concrete Creator**: Implements the **Factory Method** to produce concrete objects
- **Product**: Interface shared by all the products
- **Concrete Product**: Must implement the Product interface

## Benefits
- All creation code is centralized
- Avoid duplication of code and provides only one place for maintaining
- Clients depend on interfaces rather than concrete classes
- Helps us to achieve the Dependency Inversion Principle



