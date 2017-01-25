package design.patterns.observer.subject.impl

import design.patterns.observer.observer.Observer
import design.patterns.observer.subject.Subject

class NewsPaper implements Subject {
    private String news
    private List<Observer> observers = new ArrayList<>()

    void registerObserver(Observer observer) {
        observers.add(observer)
    }

    void removeObserver(Observer observer) {
        observers.remove(observer)
    }

    void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(getNews())
        }
    }

    String getNews() {
        return news
    }

    void setNews(String news) {
        println "### Setting news"
        this.news = news
        notifyObservers()
        println "__________"
    }
}
