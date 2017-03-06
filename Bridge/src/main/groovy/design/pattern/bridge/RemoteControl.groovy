package design.pattern.bridge

//Abstraction
abstract class RemoteControl {

    private TV tv

    abstract on()
    abstract off()

    def setChannel() {
        tv.tuneChannel()
    }

    TV getTv() { return tv }
    void setTv(TV tv) { this.tv = tv }
}
