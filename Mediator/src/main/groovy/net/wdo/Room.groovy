package net.wdo

// Mediator
interface Room<M extends Member> {
    void addMember(M member)
    void sendMessage(String message, M sender)
}