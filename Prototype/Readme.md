# Prototype Pattern (Creational)
>Creates objects by cloning an existing object

## Problem 
Application need to know the class of objects already created to create more using new.

## Solution
Let objects to create others from themselves using a clone method. 

Create a factory object to maintain the initial instances

## Considerations
- Prototype can avoid expensive "creation from scratch" 
- Let client to create objects without know the type
- Rules for method clone in JVM:
  1) x.clone() != x will be true
  2) x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements.
  3) x.clone().equals(x) will be true, this is not an absolute requirement.

## Related patterns
- Singleton avoids the creation of multiple instances. Prototype return a new instance in every call.
- Factory method: creation through inheritance. Prototype: creation through delegation

## References
- https://sourcemaking.com/design_patterns/prototype
- https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
- http://howtodoinjava.com/core-java/cloning/a-guide-to-object-cloning-in-java/

