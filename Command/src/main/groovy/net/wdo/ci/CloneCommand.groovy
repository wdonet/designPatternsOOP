package net.wdo.ci

import net.wdo.Command

class CloneCommand implements Command {

    private String repoUrl
    private File folder

    CloneCommand(String repositoryUrl, File folderReceiver) {
        repoUrl = repositoryUrl
        folder = folderReceiver
    }

    @Override
    void execute() {
        if (folder != null && folder.exists()) {
            println "Cloned $repoUrl @ ${folder.absolutePath}"
        }
        else {
            throw new NoSuchElementException("Unable to locate target folder!")
        }
    }

}
