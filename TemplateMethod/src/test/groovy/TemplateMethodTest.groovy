import net.wdo.domain.AbstractBookFinder
import net.wdo.domain.ConcreteCloudUnionBookFinder
import net.wdo.domain.ConcreteFolderAllBookFinder
import net.wdo.domain.ConcreteLibraryIntersectionBookFinder
import spock.lang.Specification

class TemplateMethodTest extends Specification {

    def "Find all in a Folder"() {
        given:
        AbstractBookFinder finder = new ConcreteFolderAllBookFinder()

        when:
        List<String> findings = finder.search("The joy of the dream time")

        then:
        findings != null
        findings.size() == 4
    }

    def "Union find in the Cloud"() {
        given:
        AbstractBookFinder finder = new ConcreteCloudUnionBookFinder()

        when:
        List<String> findings = finder.search("ThE cuRiouS worKinG CulTurE")

        then:
        findings != null
        findings.size() == 3
    }

    def "Intersect findings in the Library"() {
        given:
        AbstractBookFinder finder = new ConcreteLibraryIntersectionBookFinder()
        def query = "angular for dummies"

        when:
        List<String> findings = finder.search(query)

        then:
        findings != null
        findings.size() == 1
        println "=== Highlighted ==="
        for (String highlighted : findings) {
            println highlighted
        }
    }

}
