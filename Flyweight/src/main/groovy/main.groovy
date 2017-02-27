import design.patterns.flyweight.Tree
import design.patterns.flyweight.TreeFactory
import design.patterns.flyweight.TreeType

Tree oak1 = TreeFactory.getTree(TreeType.OAK)
Tree oak2 = TreeFactory.getTree(TreeType.OAK)
Tree pine1 = TreeFactory.getTree(TreeType.PINE)

oak1.render(1,2, "medium")
oak2.render(1,2, "small")
pine1.render(1,2, "big")