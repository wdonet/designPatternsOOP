package design.pattern.singleton

import groovy.transform.Synchronized

class ThreadSafeSingleton {
    private static ThreadSafeSingleton threadSafeSingleton

    private ThreadSafeSingleton(){}

    @Synchronized
    static ThreadSafeSingleton getThreadSafeSingleton() {
        if(threadSafeSingleton == null) {
            threadSafeSingleton = new ThreadSafeSingleton()
        }
        return threadSafeSingleton
    }

    static void clearThreadSafeSingleton() {
        threadSafeSingleton = null
    }


}
