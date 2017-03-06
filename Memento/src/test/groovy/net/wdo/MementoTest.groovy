package net.wdo

import spock.lang.Specification

class MementoTest extends Specification {

    def 'Memento pattern test'() {
        given:
        Calculator calculator = new SumOriginator()
        calculator.setFirstNumber(3)
        calculator.setSecondNumber(4)
        println calculator.execute()
        assert calculator.getFirstNumber() == 3
        assert calculator.getSecondNumber() == 4

        PreviousCalculationCareTaker memento = calculator.backupLastOperationMemento()
        assert null != memento

        when:
        calculator.setFirstNumber(10)
        calculator.setSecondNumber(100)
        println calculator.execute()
        assert calculator.getFirstNumber() == 10
        assert calculator.getSecondNumber() == 100

        and:
        calculator.restorePreviousCalculation(memento)

        then:
        calculator.getFirstNumber() == 3
        calculator.getSecondNumber() == 4
        println calculator.execute()
    }

}
