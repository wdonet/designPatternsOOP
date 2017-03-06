package design.pattern.bridge

//RefinedAbstraction
class ConcreteRemote extends RemoteControl {

    @Override
    on() {
        println "Sends signal to ${tv.getBrand()} tv for turning on"
        tv.on()
    }

    @Override
    off() {
        println "Sends signal to ${tv.getBrand()} tv for turning off"
        tv.off()
    }
}
