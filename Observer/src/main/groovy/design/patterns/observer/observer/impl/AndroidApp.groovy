package design.patterns.observer.observer.impl

import design.patterns.observer.observer.Observer
import design.patterns.observer.subject.Subject


class AndroidApp implements Observer {

    private String news

    private Subject subject

    AndroidApp(Subject subject) {
        this.subject = subject
        subject.registerObserver(this)
    }

    void update(String news) {
        this.news = news
        displayForAndroid()
    }

    void displayForAndroid() {
        println "AndroidApp displays: $news"
    }

    String getStatus() {
        return this.news
    }
}
