package net.wdo

class DeployCommand implements Command {
    ServerType type

    DeployCommand(ServerType serverType) {
        type = serverType
    }

    @Override
    void execute() {
        println "Deployed at $type server"
    }
}
