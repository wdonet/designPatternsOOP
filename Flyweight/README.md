# Flyweight Pattern (Structural)

> Use sharing to support large number of fine grained objects efficiently

## Problem

Designing objects with a fine granularity provides optimal flexibility, but can be unacceptably 
expensive in terms of performance and memory usage

---
## Solution

Use sharing to support large numbers of fine-grained objects efficiently

---
## Definitions

- The **intrinsic state** is the kind of data that’s not specific to a single instance of an object and 
can be shared across all of them, it is stored in the flyweight
- **Extrinsic state** depends on and varies with the flyweight's context and therefore can't be shared.
It's specific to a single instance

---
## Characteristics

- It is a way to use objects in large numbers when a simple repeated representation would 
use an unacceptable amount of memory
- A flyweight is a shared object that can be used in multiple contexts simultaneously
- Flyweights cannot make assumptions about the extrinsic state in which they operate
- Client objects are responsible for passing extrinsic state to the flyweight when it needs it

---
## Actors

![Flyweight](flyweight-uml.svg)

- Flyweight: Declares an interface through which flyweights can receive and act on extrinsic state
- ConcreteFlyweight: Implements the Flyweight interface and adds intrinsic state
- FlyweightFactory: Creates and manages the flyweight objects
  
---
## Applicability

Apply the Flyweight pattern when all of the following are true:

- An application uses a large number of objects
- Storage costs are high because of the large quantity of objects
- Most object state can be made extrinsic
- Many groups of objects may be replaced by relatively few shared objects once extrinsic state is removed
- The application doesn't depend on object identity

---
## Pros & Cons

### Pros

- Reduces the number of object instances at runtime, saving memory
- Centralizes state for many “virtual” objects into a single location
- Minimizes memory usage by sharing as much data as possible with other similar objects

### Cons

- Once you’ve implemented it, single, logical instances of the class will not be able to behave 
independently from the other instances