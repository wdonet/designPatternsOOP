package net.wdo.ci

import spock.lang.Specification

import java.nio.file.NoSuchFileException

class CI_CommandTest extends Specification {

    def 'Cloning only'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        File repositoryFolderReceiver = new File(".")
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git", repositoryFolderReceiver))

        when:
        invoker.processAllCommands()

        then:
        invoker.isCloned()
    }

    def 'Should not clone when target folder does not exist'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        File repositoryFolderReceiver = new File("./IdoNotExist")
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git", repositoryFolderReceiver))

        when:
        invoker.processAllCommands()

        then:
        thrown NoSuchElementException
        invoker.hasNotStarted()
    }

    def 'Building state'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        File repositoryFolderReceiver = new File(".")
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git", repositoryFolderReceiver))
        invoker.addProcess(new BuildCommand(repositoryFolderReceiver))

        when:
        invoker.processAllCommands()

        then:
        invoker.isBuilt()
    }

    def 'Should clone but not build due to not be a directory'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        File repositoryFolderReceiver = new File("./Readme.md")
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git", repositoryFolderReceiver))
        invoker.addProcess(new BuildCommand(repositoryFolderReceiver))

        when:
        invoker.processAllCommands()

        then:
        thrown NoSuchFileException
        invoker.isCloned()
    }

    def 'Deployment state'() {
        given:
        ContinuousIntegrationInvoker invoker = new ContinuousIntegrationInvoker()
        File repositoryFolderReceiver = new File(".")
        invoker.addProcess(new CloneCommand("https://the.url.com/from.git", repositoryFolderReceiver))
        invoker.addProcess(new BuildCommand(repositoryFolderReceiver))
        invoker.addProcess(new DeployCommand(ServerType.Amazon, repositoryFolderReceiver))

        when:
        invoker.processAllCommands()

        then:
        invoker.isDeployed()
    }

}
