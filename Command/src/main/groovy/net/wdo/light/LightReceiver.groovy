package net.wdo.light

class LightReceiver {
    static enum LIGHT {ON, OFF}

    LIGHT light

    void turnLightOn() {
        light = LIGHT.ON
        print()
    }

    void turnLightOff() {
        light = LIGHT.OFF
        print()
    }

    private void print() {
        println "Light is $light"
    }
}
