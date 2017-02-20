package ns.learning.patterns.prototype

abstract class Shape implements Cloneable {
    private String id
    protected String type

    abstract void draw()
}
