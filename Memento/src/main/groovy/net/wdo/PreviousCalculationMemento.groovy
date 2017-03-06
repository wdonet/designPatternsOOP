package net.wdo

class PreviousCalculationMemento
        implements PreviousCalculationCareTaker,
                PreviousCalculationToOriginator {

    private int firstNumber
    private int secondNumber

    @Override
    int getFirstNumber() {
        return firstNumber
    }

    @Override
    int getSecondNumber() {
        return secondNumber
    }
}
