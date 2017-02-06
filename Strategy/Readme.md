# Strategy Pattern (Behavioral)
> Define a family of algorithms, encapsulate each one, and make them interchangeable.

## Problem
Classes differ in behavior only and there's need to choose between them at runtime.

## Solution
Defines a **common interface** for all supported algorithms, the **client holds a reference to the strategy object** (the concrete class) and when an operation is needed, the algorithm is run from the strategy object.  The **client doesn't know about the implementation** used in the strategy object. So the client receives request for execute the algorithm and there's a delegation to the strategy object.

Strategy pattern lets the algorithm vary independently from clients that use it and should be used only when the variation in behavior is relevant.

### Cons
- Usually Strategy object needs data from the caller object (the context) in order to return processed data.
    - One way is to send **encapsulated data** which leads to create additional classes and to take care of the internal fields.  Think in terms of what is implemented now and what is going to be used in the future.
    - The other way is to **send the caller object itself** to the Strategy object which leads to tighter coupling caller-strategy objects.

## Related
- *Template Method* - It is based on inheritance while Strategy on delegation as we saw.
- *Bridge* - Same UML diagram but the intention is different, Bridge is focus in structure and Strategy on the behavior.
- *Composite* - A hierarchy of classes offer to extend and customize the algoritms of an Strategy pattern.

## Classes

Diagrams:
![diagram](http://i.imgur.com/f4xbBlf.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml

title "Strategy Pattern"
class Client {
 -- state --
 -StrategyClass strategy
 -- methods --
 +doIt()
 .. calling {..
    behavior()
 .. } ..
}

interface StrategyClass{
    +behavior()
}

class ConcreteStrategy1 implements StrategyClass {
    +behavior()
}

class ConcreteStrategy2 implements StrategyClass {
    +behavior()
}

class ConcreteStrategy3 implements StrategyClass {
    +behavior()
}
StrategyClass <|--left-- Client

@enduml
```