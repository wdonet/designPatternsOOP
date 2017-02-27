package design.patterns.flyweight

class OakTree implements Tree {

    //Intrinsic state
    private String name = "Oak Tree"

    @Override
    render(int x, int y, int size) {
        println "Render $name of size[$size] at [$x,$y]"
    }
}
