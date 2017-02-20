# Template Method Pattern (Behavioral)
> Defines the skeleton of an algorithm divided in ordered steps that can be redefined by the specificity levels.

## Problem
- Two or more components have similarities and might not reuse a common interface or implementation. If a common change is needed for all components it becomes necessary to multiply effort by the number of components.

## Solution
- It defines an algorithm for different king of flows following same format and splits it into parts that changes between flows and parts that don't.  Those unchangeable parts remains in the abstract class or superclass.
- It should be used to implement the invariant parts of an algorithm and leave the variability to the primitive methods in subclasses.
- A default behavior could exist in the superclass and a redefinition in the subclasses by flow case.

### Pros
- It's using as an inverted controls structure, a.k.a “the Hollywood principle” or “Don't call us, we'll call you”. That means that instead of calling the methods from the superclass in subclasses, the methods from subclasses are called from the template method in the superclass.
- The common behavior in the abstract class leads to DRY.

### Related Patterns
- *Strategy pattern* - The difference consist in the fact that Strategy uses delegation while Template Method inheritance.

## Classes

Diagrams:
![diagram](http://i.imgur.com/M6WQ9k3.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml

title "Template Method Pattern"
class Client {
}

abstract class AbstractClass{
    final +templateMethod()
    .. implemented like { ..
      primitiveA()
      primitiveB()
    .. } ..
    abstract primitiveA()
    abstract primitiveB()
}

class ConcreteClass1 extends AbstractClass {
    +primitiveA()
    +primitiveB()
}

class ConcreteClass2 extends AbstractClass {
    +primitiveA()
    +primitiveB()
}

ConcreteClass1 <|--right-- Client
ConcreteClass2 <|--left-- Client

@enduml
```

[![Video Description](http://img.youtube.com/vi/HbuChDbl68g/0.jpg)](http://www.youtube.com/watch?v=HbuChDbl68g)
