package ns.learning.patterns.prototype

import spock.lang.Specification

class CloneableObjectTest extends Specification {

    def "clone test"() {

        given:
        CloneableObject f1 = new CloneableObject()

        when:
        CloneableObject f2 = (CloneableObject)f1.clone()

        then:
        f1.getClass() == f2.getClass()
        f1.randomState == f2.randomState
        f1.stateList == f2.stateList

        f1.stateList.remove(0)

        f1.stateList.size() == f2.stateList.size()
    }

    def "test with new"() {

        given:
        CloneableObject f1 = new CloneableObject()

        when:
        CloneableObject f2 = new CloneableObject()

        then:
        f1.getClass() == f2.getClass()
        f1.randomState != f2.randomState
        f1.stateList != f2.stateList

        f1.stateList.remove(0)

        f1.stateList.size() < f2.stateList.size()
    }

    def "test after clone"() {

        given:
        CloneableObject f1 = new CloneableObject()

        when:
        CloneableObject f2 = (CloneableObject)f1.clone()
        f1.randomState = 10
        CloneableObject f3 = (CloneableObject)f1.clone()

        then:
        f1.randomState != f2.randomState
        f1.randomState == f3.randomState
    }

}
