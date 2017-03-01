package net.wdo

import spock.lang.Specification

class CommandTest extends Specification {

    def 'Cloning only'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git"))

        when:
        invoker.processAllCommands()

        then:
        invoker.isCloned()
    }

    def 'Building state'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git"))
        invoker.addProcess(new BuildCommand())

        when:
        invoker.processAllCommands()

        then:
        invoker.isBuilt()
    }

    def 'Deployment state'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git"))
        invoker.addProcess(new BuildCommand())
        invoker.addProcess(new DeployCommand(ServerType.Amazon))

        when:
        invoker.processAllCommands()

        then:
        invoker.isDeployed()
    }

}
