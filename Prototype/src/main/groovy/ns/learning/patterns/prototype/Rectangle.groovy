package ns.learning.patterns.prototype

class Rectangle implements Shape{

    Rectangle(){
        println "Rectangle constructor"
    }

    @Override
    void draw() {
        println "A rectangle"
    }
}
