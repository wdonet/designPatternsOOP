# Proxy Pattern (Structural)
>Provides a placeholder for another object to control access, reduce cost, and reduce complexity

## Problem 
- You want/need to instantiate some object until it is required by the first time
- You have an object capable to do something but you need to add some validations before call it
- There exists a remote system capable to do something and you need to call it
- You need to add additional actions before or after calling an existing method of any class

## Solution
Creates a class that wraps the main object where you can add any validations or actions before or after 
delegating the call to the desired object.

## Considerations
- Proxy and Subject must be interchangeable
- Consider defining a Factory that can encapsulate the decision of whether a proxy or original object is desirable.

## Related patterns
- Adapter provides a different interface to its subject. Proxy provides the same interface. Decorator provides an enhanced interface. 
    
## Example
[Proxy general diagram](proxy.png)

[Example secured proxy](Sample%201%20-%20proxy.png)

## Known uses
- Java RMI, RPC, CORBA 
- Web Services*

## References
- [Sourcemaking](https://sourcemaking.com/design_patterns/proxy)
- [Tutorialspoint](https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm)
- [Wikipedia](https://es.wikipedia.org/wiki/Proxy_(patr%C3%B3n_de_dise%C3%B1o))
- [oodesign](http://www.oodesign.com/proxy-pattern.html)
