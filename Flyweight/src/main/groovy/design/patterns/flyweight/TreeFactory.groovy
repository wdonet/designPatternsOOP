package design.patterns.flyweight

class TreeFactory {

    private static Map<TreeType, Tree> trees = new HashMap<>()

    static Tree getTree(TreeType type) {
        if(!trees.containsKey(type)) {
            switch (type) {
                case TreeType.OAK: trees.put(TreeType.OAK, new OakTree())
                    break
                case TreeType.PINE: trees.put(TreeType.PINE, new PineTree())
                    break
            }
        }
        return trees.get(type)
    }

}
