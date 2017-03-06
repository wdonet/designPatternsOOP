# Interpreter (Behavioral)
>Implements a specialized language.

## Problem
Interpret a language 

## Solution

## General structure
![Interpreter General Diagram](interpreter.png)

## Actors

- Abstract expression. 
    - Declares a interface for executing an operation
- Terminal expression. 
    - Implements an interpret operation associated with terminal symbols in grammar
    - Interprets expressions containing any of the terminal tokens in the grammar
- Non-terminal expression.
    - Interprets all non-terminal expressions in the grammar
- Context
    - Contains the global information that is part of the parse
- Client
    - Builds the sintax tree from the preceding expression types and invokes the interpret operation
      
## Considerations

- This pattern is not a Parser. It specifically does not address the issue of parsing the input

## Pros

- Easier to change and extend the grammar
- Complex for big grammars 


## References

https://es.slideshare.net/amanicka/interpreter-pattern-final1

https://sourcemaking.com/design_patterns/interpreter

