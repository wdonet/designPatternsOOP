# Mediator Pattern (Behavioral)
>Defines simplified communication between classes.

## Problem
When you have a system with several objects communicating between them by holding the reference of the other objects, it becomes hard to maintain when the number of object increases.

## Solution
Introduces a middle object between two others or more to decouple communication.
- The middle object is the **mediator**
- When one object communicates to another, there's no direct calls
   - Instead, they call the mediator whose main duty is to route messages to the correct destination

### Pros
- It promotes loose coupling by avoiding manual handling of links (references) between objects

### Cons
- I bit confuse at the beginning

## Realted design patterns
- **Observer Pattern**
  - Similar in decoupling communication
  - _Mediator pattern_ works as the shared hub where other objects of same or different type can communicate between them.  This pattern can also be implemented using Observer pattern.
  - _Observer pattern_ works as in Class A registering zero or more observers of type O. When something in A is changed it notifies all of the observers.

## Classes
![Classes Diagram](http://i.imgur.com/LO6Ad6a.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml
title Mediator Pattern

interface Mediator {
  +List<Colleagues> members 
  +void addColleague(Colleague member)
  +void broadcast(Colleague member)
}

abstract class Colleague {
  -Mediator mediator
  +receive()
  +send(Mediator)
}

class Room implements Mediator {
  +void addColleague(Colleague member)
  +void broadcast(Colleague member)
}

class User extends Colleague {
  +receive()
  +send(Mediator)
}

class SuperUser extends Colleague {
  +receive()
  +send(Mediator)
}

Mediator <|-right- Colleague
SuperUser <|-left- Room
User <|-left- Room

@enduml
```

Sequence Diagram [1 via](http://i.imgur.com/C8XQoZw.png), [2 vias](http://i.imgur.com/cpYuWv9.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml

title "Mediator - Sequence Diagram"

actor User
actor SuperUser as SU
control "Mediator" as M

SU -> M : send(msgA)
M -> M : For each registered user
M -> User : receive(msgA)

User -> M : send(msgB)
M -> M : For each registered user
M -> SU : receive(msgB)

@enduml
```

