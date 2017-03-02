package net.wdo.ci

import net.wdo.Command

class ContinuousIntegrationInvoker {
    enum IS {NOT_STARTED, CLONED, BUILT, DEPLOYED}
    IS currentState = IS.NOT_STARTED

    List<Command> orderedCommands = new ArrayList<>()

    void addProcess(Command command) {
        orderedCommands.add(command)
    }

    void processAllCommands() {
        orderedCommands.each {
            it.execute()
            theComplexPartOfKeepingInvokerState(it)
        }
    }

    private void theComplexPartOfKeepingInvokerState(Command oneCommand) {
        if (oneCommand instanceof CloneCommand) {
            currentState = IS.CLONED
        }
        if (oneCommand instanceof BuildCommand) {
            currentState = IS.BUILT
        }
        if (oneCommand instanceof DeployCommand) {
            currentState = IS.DEPLOYED
        }
    }

    boolean hasNotStarted() {
        IS.NOT_STARTED == currentState
    }

    boolean isCloned() {
        IS.CLONED == currentState
    }

    boolean isBuilt() {
        IS.BUILT == currentState
    }

    boolean isDeployed() {
        IS.DEPLOYED == currentState
    }
}
