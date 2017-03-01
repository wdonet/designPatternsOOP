package net.wdo

class CloneCommand implements Command {

    String url

    CloneCommand(String url) {
        this.url = url
    }

    @Override
    void execute() {
        println "Cloned from $url"
    }

}
