package ns.learning.patterns.prototype

import spock.lang.Specification

class ShapeTest extends Specification {

    def "Clone rectangle"() {
        given:
        Shape shape1 = ShapeFactory.getShape("RECTANGLE")
        Shape shape2 = ShapeFactory.getShape("RECTANGLE")
        Shape shape3 = ShapeFactory.getShape("RECTANGLE")

        expect:
        shape1 != shape2 && shape1 != shape3 && shape1 != shape3 &&
        shape1 instanceof Rectangle &&
        shape2 instanceof Rectangle &&
        shape3 instanceof Rectangle
    }

    def "Clone circle"() {
        given:
        Shape shape1 = ShapeFactory.getShape("CIRCLE")
        Shape shape2 = ShapeFactory.getShape("CIRCLE")
        Shape shape3 = ShapeFactory.getShape("CIRCLE")

        expect:
        shape1 != shape2 && shape1 != shape3 && shape1 != shape3 &&
                shape1 instanceof Circle &&
                shape2 instanceof Circle &&
                shape3 instanceof Circle
    }

    def "Clone triangle"() {
        given:
        Shape shape1 = ShapeFactory.getShape("TRIANGLE")
        Shape shape2 = ShapeFactory.getShape("TRIANGLE")
        Shape shape3 = ShapeFactory.getShape("TRIANGLE")

        expect:
        shape1 != shape2 && shape1 != shape3 && shape1 != shape3 &&
                shape1 instanceof Triangle &&
                shape2 instanceof Triangle &&
                shape3 instanceof Triangle
    }

}
