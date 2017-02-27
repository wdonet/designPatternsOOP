package design.patterns.flyweight

class OakTree implements Tree {

    //Intrinsic state
    private String name = "Oak Tree"

    @Override
    def render(int x, int y, String size) {
        println "Render $size $name at [$x,$y]"
    }
}
