package net.wdo

class SimpleRoom<M extends Member> implements Room<M> {
    List<M> users = new ArrayList<>()
    String roomName

    @Override
    void addMember(M user) {
        users.add(user)
    }

    @Override
    void sendMessage(String message, M sender) {
        getUsers().minus(sender)*.receive(message)
    }

}