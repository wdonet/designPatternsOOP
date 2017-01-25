package design.patterns.observer.subject

import design.patterns.observer.observer.Observer

interface Subject {
    void registerObserver(Observer observer)
    void removeObserver(Observer observer)
    void notifyObservers()
    void setNews(String news)
}