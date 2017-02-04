import net.wdo.product.CheeseSticks
import net.wdo.product.Fries
import net.wdo.factories.AbstractFoodFactory
import net.wdo.factories.ItalianStyleFactory
import net.wdo.factories.MexaStyleFactory
import net.wdo.factories.StyleFactoryCreator
import spock.lang.Specification

import static net.wdo.factories.StyleFactoryCreator.Style.ITALIAN
import static net.wdo.factories.StyleFactoryCreator.Style.MEXA

class AbstractFactoryTest extends Specification{

    def creator = new StyleFactoryCreator()

    def "should create Pizza Factory"() {
        when:
        AbstractFoodFactory mexaFactory = creator.create(MEXA)
        AbstractFoodFactory italianFactory = creator.create(ITALIAN)

        then:
        mexaFactory instanceof MexaStyleFactory
        italianFactory instanceof ItalianStyleFactory
    }

    def "should prepare correct style of pizza"() {
        expect:
        creator.create(style).preparePizza().prepare() == "Preparing $text Pizza".toString()
        creator.create(style).preparePizza().bake() == "Baking $text Pizza".toString()
        //just for reference
        println creator.create(style).preparePizza().prepare()
        println creator.create(style).preparePizza().bake()

        where:
        style   | text
        MEXA    | "a Mexa"
        ITALIAN | "an Italian"
    }

    def "should prepare correct side"() {
        expect:
        creator.create(style).prepareSide().getClass() == sideClass

        where:
        style   | sideClass
        MEXA    | Fries
        ITALIAN | CheeseSticks
    }

}
