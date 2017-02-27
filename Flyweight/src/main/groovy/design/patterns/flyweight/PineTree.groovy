package design.patterns.flyweight

class PineTree implements Tree {

    //Intrinsic state
    String name = "Pine Tree"

    @Override
    def render(int x, int y, String size) {
        println "Render $size $name at [$x,$y]"
    }
}
