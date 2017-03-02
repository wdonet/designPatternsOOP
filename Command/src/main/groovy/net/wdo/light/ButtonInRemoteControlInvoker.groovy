package net.wdo.light

import net.wdo.Command

class ButtonInRemoteControlInvoker {

    LightReceiver receiver
    private Command operation

    ButtonInRemoteControlInvoker withReceiver(LightReceiver lightReceiver) {
        receiver = lightReceiver
        this
    }

    ButtonInRemoteControlInvoker andCommand(Class commandClass) {
        operation = (Command) commandClass.newInstance(receiver)
        this
    }

    void pressButton() {
        operation.execute()
    }
}
