package design.patterns.observer.observer.impl

import design.patterns.observer.observer.Observer
import design.patterns.observer.subject.Subject

class IOsApp implements Observer {

    private String news

    private Subject subject

    IOsApp(Subject subject) {
        this.subject = subject
        subject.registerObserver(this)
    }

    void update(String news) {
        this.news = news
        displayForIOs()
    }

    void displayForIOs() {
        println "IOsApp displays: $news"
    }
}
