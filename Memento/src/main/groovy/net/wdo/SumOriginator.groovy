package net.wdo

/**
 * Class with original operations + memento operations
 */
class SumOriginator implements Calculator {

    int firstNumber
    int secondNumber

    @Override
    PreviousCalculationCareTaker backupLastOperationMemento() {
        return new PreviousCalculationMemento(
                firstNumber: firstNumber,
                secondNumber: secondNumber)
    }

    @Override
    void restorePreviousCalculation(PreviousCalculationCareTaker careTaker) {
        firstNumber = ((PreviousCalculationMemento) careTaker).getFirstNumber()
        secondNumber = ((PreviousCalculationMemento) careTaker).getSecondNumber()
    }

    @Override
    int execute() {
        return firstNumber + secondNumber
    }
}
