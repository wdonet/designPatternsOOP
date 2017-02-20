package ns.learning.patterns.prototype

class Circle implements Shape{

    Circle(){
        println "Circle constructor"
    }

    @Override
    void draw() {
        println "A Circle"
    }
}
