package net.wdo.ci

import net.wdo.Command

import java.nio.file.NoSuchFileException

class BuildCommand implements Command {

    private File folder

    BuildCommand(File folderReceiver) {
        folder = folderReceiver
    }

    @Override
    void execute() {
        if (folder != null && folder.exists() && folder.isDirectory()) {
            folder.list().each {
                println it
            }
            println "Build successfully"
        }
        else {
            throw new NoSuchFileException("Not a directory to build")
        }
    }

}
