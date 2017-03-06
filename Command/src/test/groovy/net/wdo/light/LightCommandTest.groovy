package net.wdo.light

import spock.lang.Specification

class LightCommandTest extends Specification {

    def 'switchOnTest'() {
        given:
        LightReceiver receiver = new LightReceiver()
        assert receiver.light == null
        ButtonInRemoteControlInvoker invoker = new ButtonInRemoteControlInvoker()
                .withReceiver(receiver)
                .andCommand(SwitchOnCommand.class)

        when:
        invoker.pressButton()

        then:
        LightReceiver.LIGHT.ON == receiver.light
    }

    def 'switchOffTest'() {
        given:
        LightReceiver receiver = new LightReceiver()
        assert receiver.light == null
        ButtonInRemoteControlInvoker invoker = new ButtonInRemoteControlInvoker()
                .withReceiver(receiver)
                .andCommand(SwitchOffCommand.class)

        when:
        invoker.pressButton()

        then:
        LightReceiver.LIGHT.OFF == receiver.light
    }

    def 'remoteController for light'() {
        setup:
        RemoteControlInvoker invoker = new RemoteControlInvoker()
        LightReceiver receiver = new LightReceiver()
        assert receiver.light == null

        when:
        invoker.setSwitchOffCommand(new SwitchOffCommand(receiver))
        invoker.setSwitchOnCommand(new SwitchOnCommand(receiver))


        then:
        invoker.switchOff()
        LightReceiver.LIGHT.OFF == receiver.light

        invoker.switchOn()
        LightReceiver.LIGHT.ON == receiver.light

        invoker.switchOff()
        LightReceiver.LIGHT.OFF == receiver.light
    }
}
