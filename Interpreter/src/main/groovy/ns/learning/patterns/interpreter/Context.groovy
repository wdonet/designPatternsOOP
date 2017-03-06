package ns.learning.patterns.interpreter

class Context {
    private Map<String, Number> variables = new HashMap<>()

    Context setVariable(String name, Number value){
        variables.put(name, value)

        return this
    }

    Number getVariable(String name){
        if(!variables.containsKey(name))
            throw new UndefinedSymbolException(name)

        return variables.get(name)
    }
}
