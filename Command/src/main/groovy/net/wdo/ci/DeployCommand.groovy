package net.wdo.ci

import net.wdo.Command

class DeployCommand implements Command {
    private ServerType type
    private File folder

    DeployCommand(ServerType serverType, File folder) {
        type = serverType
        this.folder = folder
    }

    @Override
    void execute() {
        if (folder != null && folder.exists()) {
            println "Deployed repository ${folder.canonicalPath} at $type server"
        }
    }
}
