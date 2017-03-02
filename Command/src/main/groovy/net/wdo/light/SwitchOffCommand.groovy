package net.wdo.light

import net.wdo.Command

class SwitchOffCommand implements Command {
    LightReceiver receiver

    SwitchOffCommand(LightReceiver receiver) {
        this.receiver = receiver
    }

    @Override
    void execute() {
        receiver.turnLightOff()
    }
}
