package ns.learning.patterns.prototype

class CloneableObject implements Cloneable {

    private static Random randomGenerator = new Random()

    int randomState

    List<Integer> stateList

    CloneableObject(){

        println "Calling constructor"

        randomState = randomGenerator.nextInt()
        stateList = new LinkedList<>()

        stateList << randomGenerator.nextInt()
        stateList << randomGenerator.nextInt()
        stateList << randomGenerator.nextInt()
        stateList << randomGenerator.nextInt()
        stateList << randomGenerator.nextInt()
    }

}
