import design.patterns.flyweight.Tree
import design.patterns.flyweight.TreeFactory
import design.patterns.flyweight.TreeType
import spock.lang.Specification

class FlyweightTest extends Specification{

    def "verify Flyweight"() {
        when:
        Tree oak1 = TreeFactory.getTree(TreeType.OAK)
        Tree oak2 = TreeFactory.getTree(TreeType.OAK)
        Tree pine1 = TreeFactory.getTree(TreeType.PINE)

        List<Tree> trees = new ArrayList<>()
        trees << oak1
        trees << oak2
        trees << pine1

        trees.each {
            Random random = new Random()
            int x = random.nextInt(10) + 1
            int y = random.nextInt(10) + 1
            int size = random.nextInt(10) + 1

            it.render(x, y, size)
        }

        then:
        2 == TreeFactory.treesNumber()

    }

}