import net.wdo.Room
import net.wdo.SimpleRoom
import net.wdo.SuperUser
import net.wdo.User
import spock.lang.Specification

class MediatorTest extends Specification {

    def "Mediator works"() {

        setup:
        Room room = new SimpleRoom(roomName: "General")
        SuperUser hugo = new SuperUser(nickName: "Hugo")
        room.addMember(hugo)

        when:
        User paco = new User(room: room, nickName: "Paco")
        User luis = new User(room: room, nickName: "Luis")

        then:
        luis.send("Hello Paco (sun), have you heard about Hugo's resignation?")
        paco.send("yeah! so weird!")
        hugo.send(room, "I'm still here, boys :/ ")
    }
}
