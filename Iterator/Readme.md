# Iterator Pattern (Behavioral)
>Provides a way to access the elements of an aggregate object, sequentially and without exposing its underlying representation.

## Problem
Collections are common structures that group objects of the same type or that can be cast to a base type.  They should provide a way to access its elements without exposing internal elements.

## Solution
Provides a way to access the objects of the collection through an iterator object which will maintain the state of the iteration, the tracking of the current item and the next item to be iterated till the end of the collection.

### Pros
- Honors Encapsulation when providing an interface for traversing different collection no matter its internal implementation.

### Cons
- Some problems may appear when collections **are changed** form different threads since a new iterator is returned each time
    - Let's say a new element is added, all iterators should be aware of the new element in order to reach it accordingly in the iteration.
    - If one element is removed, a NullPointerException could be caused if the iterators try to get that element.

## Type of iterators

### External Iterators
The iteration is controlled by the collection object.  We have a classical implementation like this in every almost every langauge. Example:

- Using Java iterators for a String collection
```
    for (Iterator it = options.iterator(); it.hasNext(); ) {
       String name = (String)it.next();
       System.out.println(name);
    }
```
- Using while loop in Groovy
```
    Iterator iterator = options.iterator()
    while (iterator.hasNext())
        doSometingWith(iterator.next());

```

### Internal Iterators
When the iterator controls it. Some languages offer support to this by passing the code to be executed to the collection, the collection will call internally this code on each of the elements.

- For example in Java/Groovy, the Iterator interface provides a default method for passing code and execute it on each member of the collection.
```
public interface Iterator<E> {

    //...

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }

}
```


## Classes

Diagrams:
![diagram](http://i.imgur.com/LuNgtMs.png)
... or generate it with [plantext](https://www.planttext.com/) :
```
@startuml

title "Iterator Pattern"
class Client {
}

interface Aggregate {
    +createIterator()
}

class ConcreteAggregate implements Aggregate {
    +createIterator()
}

interface Iterator {
    +hasNext()
    +next()
}

class ConcreteIterator implements Iterator {
    +hasNext()
    +next()
}

Aggregate <|--up-- Client
Iterator <|--up-- Client
ConcreteIterator <|--up-- Client
ConcreteIterator <|--left-- ConcreteAggregate

@enduml
```