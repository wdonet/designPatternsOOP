package ns.learning.patterns.prototype

class ShapeFactory {
    private static HashMap<String, Shape> rootInstances

    static {
        rootInstances = new HashMap<>();

        rootInstances.put("RECTANGLE", new Rectangle())
        rootInstances.put("CIRCLE", new Circle())
        rootInstances.put("TRIANGLE", new Triangle())
    }

    static Shape getShape(String id) {
        Shape shape = rootInstances.get(id)

        return shape != null ? shape.clone() : null
    }
}
