package net.wdo.domain

class User extends Member {
    Room room

    void setRoom(Room room) {
        this.room = room
        room.addMember(this)
    }

    @Override
    void send(Room room, String message) {
        send(message)
    }

    void send(String message) {
        getRoom().sendMessage(message, this)
    }

    @Override
    void receive(String message) {
        println "[$nickName] receives : $message"
    }

}