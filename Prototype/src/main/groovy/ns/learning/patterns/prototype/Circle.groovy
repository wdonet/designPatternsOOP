package ns.learning.patterns.prototype

class Circle extends Shape{

    Circle(){
        println "Circle constructor"
    }

    @Override
    void draw() {
        println "A Circle"
    }
}
