package ns.learning.patterns.prototype

class Triangle extends Shape {

    Triangle() {
        println "Triangle constructor"
    }

    @Override
    void draw() {
        println "A Triangle"
    }
}
