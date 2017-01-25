package design.patterns.observer.observer.impl

import design.patterns.observer.observer.Observer
import design.patterns.observer.subject.Subject

class WebApp implements Observer {

    private String news

    private Subject subject

    WebApp(Subject subject) {
        this.subject = subject
        subject.registerObserver(this)
    }

    void update(String news) {
        this.news = news
        displayForWeb()
    }

    void displayForWeb() {
        println "WebApp displays: $news"
    }

    String getStatus() {
        return this.news
    }
}
