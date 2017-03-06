package net.wdo

interface Calculator {

    //For the memento
       //creation
    PreviousCalculationCareTaker backupLastOperationMemento()
       //restoration
    void restorePreviousCalculation(PreviousCalculationCareTaker careTaker)

    //Original methods
    void setFirstNumber(int number)
    void setSecondNumber(int number)
    int execute()

}