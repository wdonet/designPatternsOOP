# State Pattern (Behavioural)
>Allows an object to alter its behavior when its internal state changes.

## Problem 
How to make behaviour depend on state. 

Typical state machine problem. For example communication protocol, file parsing.

## Solution

1. Define a context class to present a single interface to the outside world
2. Define state abstract base class
3. Represent the different states of the state machine as derived classes of the State base class
4. Define state-specific behavior in the each State derived classes
5. Maintain a pointer to the current state in the context class
6. Move between the different states by changing the currentState pointer.

## Notes

There is a discussion regarding where to change the pointer to the currentState:
1. In the context class. In this fashion States are not coupled between them but they are to the 
context class and the logic to maintain the state machine is complex.
2. Each individual state knows which is the next state. 

## General structure

![State](https://upload.wikimedia.org/wikipedia/commons/7/7c/State_design_pattern.png)

## References

https://sourcemaking.com/design_patterns/state
