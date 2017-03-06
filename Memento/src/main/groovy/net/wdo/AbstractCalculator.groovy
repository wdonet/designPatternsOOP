package net.wdo;

abstract class AbstractCalculator implements Calculator {

    int firstNumber
    int secondNumber

    @Override
    PreviousCalculationCareTaker backupLastOperationMemento() {
        new PreviousCalculationMemento(
                firstNumber: firstNumber,
                secondNumber: secondNumber)
    }

    @Override
    void restorePreviousCalculation(PreviousCalculationCareTaker careTaker) {
        firstNumber = ((PreviousCalculationMemento) careTaker).getFirstNumber()
        secondNumber = ((PreviousCalculationMemento) careTaker).getSecondNumber()
    }

}
