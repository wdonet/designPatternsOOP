package design.patterns.factory.product

abstract class Pizza {
    String name

    void prepare() {
        println "### Preparing $name"
    }
    void bake() {
        println "\tBaking..."
    }
    void cut() {
        println "\tCutting..."
    }
    void box() {
        println "\tPlace in box"
    }
}