# Memento Pattern (Behavioral)
> Provides the ability to restore an object to its previous state

## Problem
The need to capture the internal state of an object and providing a way to restore the object to a previous state when needed.

Usually in case of error or failure, we'll need to go back to the previous state before starting the operation that caused the failure in order to start again.

Some known uses for this pattern are *undo and restore operations* in most software or *database transactions*.

## Solution

The original class (*originator*) should be responsible of internal state (*memento*) creation and restoration.  Thus, two new classes are needed:

1. The *Caretaker* class who's responsibility is to keep the memento without the ability to operate on it
2. The *Memento* class holding that any number of state variables and that implements two interfaces:

- One marker interface due to the caretaker which honors encapsulation
- The originator interface which helps the originator to access any state of variables for restoration of the previous state

### Pros

- Avoid encapsulation violations

### Cons

- Can be expensive depending of the total of state information stored inside the memento object
- Additional logic is needed for mementos management

## Related patterns

- *Command pattern* can use mementos to maintain state for undoable operations

## Classes Diagram:

![diagram](http://i.imgur.com/NuTWefu.png)

[![Video Description](http://img.youtube.com/vi/HbuChDbl68g/0.jpg)](http://www.youtube.com/watch?v=HbuChDbl68g)
