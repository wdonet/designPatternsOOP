import design.patterns.observer.observer.Observer
import design.patterns.observer.observer.impl.AndroidApp
import design.patterns.observer.observer.impl.IOsApp
import design.patterns.observer.observer.impl.WebApp
import design.patterns.observer.subject.Subject
import design.patterns.observer.subject.impl.NewsPaper
import spock.lang.Specification

class ObserverTest extends Specification {

    def "Verify observers are receiving the new status"() {
        setup:
            Subject newsPaper = new NewsPaper()
            Observer webApp = new WebApp(newsPaper)
            Observer androidApp = new AndroidApp(newsPaper)
            Observer iosApp = new IOsApp(newsPaper)

        when:
            newsPaper.setNews("Test")

        then:
            webApp.getStatus() == "Test"
            androidApp.getStatus() == "Test"
            iosApp.getStatus() == "Test"
    }

    def "Verify observers are not receiving the new status after removed"() {
        setup:
            Subject newsPaper = new NewsPaper()
            Observer webApp = new WebApp(newsPaper)
            Observer androidApp = new AndroidApp(newsPaper)
            Observer iosApp = new IOsApp(newsPaper)

        when:
            newsPaper.setNews("Test")
            newsPaper.removeObserver(androidApp)
            newsPaper.removeObserver(iosApp)

            newsPaper.setNews("Test 2")

        then:
            webApp.getStatus() == "Test 2"
            androidApp.getStatus() == "Test"
            iosApp.getStatus() == "Test"
    }
}
