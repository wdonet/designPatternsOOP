package net.wdo.domain

class SuperUser extends Member {

    @Override
    void send(Room room, String message) {
        room.sendMessage(message, this)
    }

    @Override
    void receive(String message) {
        println "[$nickName] receives : $message"
    }

}