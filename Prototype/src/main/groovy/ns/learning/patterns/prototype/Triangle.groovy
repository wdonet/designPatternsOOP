package ns.learning.patterns.prototype

class Triangle implements Shape {

    Triangle() {
        println "Triangle constructor"
    }

    @Override
    void draw() {
        println "A Triangle"
    }
}
