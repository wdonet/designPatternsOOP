import design.patterns.observer.observer.impl.AndoridApp
import design.patterns.observer.observer.impl.IOsApp
import design.patterns.observer.subject.impl.NewsPaper
import design.patterns.observer.observer.Observer
import design.patterns.observer.subject.Subject
import design.patterns.observer.observer.impl.WebApp


Subject newsPaper = new NewsPaper()

Observer webApp = new WebApp(newsPaper)
Observer androidApp = new AndoridApp(newsPaper)
Observer iosApp = new IOsApp(newsPaper)

newsPaper.setNews("News at day 1")

newsPaper.removeObserver(iosApp)
newsPaper.setNews("News at day 2")

newsPaper.removeObserver(androidApp)
newsPaper.setNews("News at day 3")

newsPaper.removeObserver(webApp)
newsPaper.setNews("News at day 4")


