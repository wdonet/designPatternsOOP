package net.wdo.light

import net.wdo.Command

class SwitchOnCommand implements Command {
    LightReceiver receiver

    SwitchOnCommand(LightReceiver receiver) {
        this.receiver = receiver
    }

    @Override
    void execute() {
        receiver.turnLightOn()
    }
}
