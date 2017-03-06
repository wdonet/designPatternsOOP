# Command Pattern (Behavioral)
> Encapsulate a request as an object so that clients can parametrize them

## It is useful when ...
- You need callback functionality
- You need history of executed commands like in undo/redo operations or wizard processes
- The invoker needs to be decoupled from the object handling the invocation
- The commands need to be invoked at different times or different order

## Solution
- Provide an *interface* for all commands
- Every command should contain a *receiver* which will be used to perform part of or the whole operation
- Set an *invoker* to hold the created commands and later execute them
- The *client* simply creates the concrete commands and sets its receiver

### Pros
- Easy to extends since more operations leads to more command classes
- Decoupled behavior

### Cons
- It leads to possibly maintainence issues for the invoker

## Classes

General Diagram:

![diagram](http://i.imgur.com/61CS24A.png)

Sequence Diagram for a re Remote control that needs to switch lights on :

![diagram](http://i.imgur.com/0xhD3fG.png)

## Tutorial

[![Video Description](http://img.youtube.com/vi/Sdj4S-OTCTU/0.jpg)](http://www.youtube.com/watch?v=Sdj4S-OTCTU)
