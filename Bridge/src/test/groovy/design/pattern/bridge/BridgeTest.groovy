package design.pattern.bridge

import org.junit.Test

class BridgeTest {

    @Test
    void "TestBridge for Sony"() {
        TV sony = new Sony()
        RemoteControl control = new ConcreteRemote()
        control.setTv(sony)

        control.on()
        control.setChannel()
        control.setChannel()
        control.setChannel()
        control.off()
    }

    @Test
    void "TestBridge for RCA"() {
        TV rca = new RCA()
        RemoteControl control = new ConcreteRemote()
        control.setTv(rca)

        control.on()
        control.setChannel()
        control.setChannel()
        control.setChannel()
        control.off()
    }
}
