package net.wdo.light

class RemoteControlInvoker {

    SwitchOffCommand switchOffCommand
    SwitchOnCommand switchOnCommand

    void switchOff() {
        switchOffCommand.execute()
    }

    void switchOn() {
        switchOnCommand.execute()
    }
}
