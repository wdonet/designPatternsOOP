package design.patterns.flyweight

class PineTree implements Tree {

    //Intrinsic state
    String name = "Pine Tree"

    @Override
    render(int x, int y, int size) {
        println "Render $name of size[$size] at [$x,$y]"
    }
}
