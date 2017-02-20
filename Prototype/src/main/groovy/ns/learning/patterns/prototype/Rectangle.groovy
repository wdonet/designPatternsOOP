package ns.learning.patterns.prototype

class Rectangle extends Shape{

    Rectangle(){
        println "Rectangle constructor"
    }

    @Override
    void draw() {
        println "A rectangle"
    }
}
