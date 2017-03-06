import spock.lang.Specification

class MementoTest extends Specification {

    def 'test pattern'() {
        given:
        int a = 1

        when:
        a++

        then:
        true
    }

}
