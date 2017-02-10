import design.pattern.singleton.GroovySingleton
import design.pattern.singleton.GroovySingletonConstructor
import design.pattern.singleton.GroovySingletonLazy
import design.pattern.singleton.GroovySingletonCustomProperty
import spock.lang.Specification

class GroovySingletonTest extends Specification {

    def "Verify new cannot be used"() {
        when:
        new GroovySingleton()

        then:
        final RuntimeException exception = thrown()
        println exception

        expect:
        exception.getMessage().startsWith("Can't instantiate singleton")
    }

    def "Verify uniqueness"() {
        when:
        GroovySingleton singleton = GroovySingleton.instance
        GroovySingleton singleton1 = GroovySingleton.instance

        then:
        println singleton
        println singleton1

        expect:
        singleton==singleton1
    }

    def "Verify constructor is invoked"() {
        when:
        GroovySingletonConstructor singleton = GroovySingletonConstructor.instance
        GroovySingletonConstructor singleton1 = GroovySingletonConstructor.instance

        then:
        println singleton
        println singleton1

        expect:
        singleton == singleton1
    }

    def "Verify lazy"() {
        when:
        GroovySingletonLazy singleton = GroovySingletonLazy.instance
        GroovySingletonLazy singleton1 = GroovySingletonLazy.instance

        then:
        println singleton
        println singleton1

        expect:
        singleton == singleton1
    }

    def "Verify changing the default property"() {
        when:
        GroovySingletonCustomProperty singleton = GroovySingletonCustomProperty.customProperty
        GroovySingletonCustomProperty singleton1 = GroovySingletonCustomProperty.customProperty

        then:
        println singleton
        println singleton1

        expect:
        singleton == singleton1
    }
}
