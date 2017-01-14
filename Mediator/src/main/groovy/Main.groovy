import net.wdo.domain.Room
import net.wdo.domain.SimpleRoom
import net.wdo.domain.SuperUser
import net.wdo.domain.User

Room room = new SimpleRoom(roomName: "General")
SuperUser hugo = new SuperUser(nickName: "Hugo")
room.addMember(hugo)

User paco = new User(room: room, nickName: "Paco")
User luis = new User(room: room, nickName: "Luis")

luis.send("Hello Paco (sun), have you heard about Hugo's resignation?")
paco.send("yeah! so weird!")
hugo.send(room, "I'm still here, boys :/ ")