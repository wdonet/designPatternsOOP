package net.wdo

/**
 * Class with original operations + memento operations
 */
class SumOriginator extends AbstractCalculator {

    @Override
    int execute() {
        return getFirstNumber() + getSecondNumber()
    }
}
