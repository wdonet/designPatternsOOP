import design.pattern.singleton.Singleton

import design.pattern.singleton.ThreadSafeSingleton
import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class SingletonTest extends Specification {

    def "Verify singleton uniqueness"() {
        setup:
        Singleton singleton1 = Singleton.getSingleton()
        Singleton singleton2 = Singleton.getSingleton()
        println singleton1
        println singleton2

        expect:
        singleton1==singleton2
    }

    def "Verify singleton is not unique in threads"() {
        setup:
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Singleton> singletonCallable = new Callable<Singleton>() {
            @Override
            Singleton call() throws Exception {
                return Singleton.getSingleton()
            }
        }

        boolean isUnique = true
        while(true) {
            Future<Singleton> f1 = executorService.submit(singletonCallable)
            Future<Singleton> f2 = executorService.submit(singletonCallable)
            if (f1.get() != f2.get()) {
                isUnique = false
                break
            }
            Singleton.clearSingleton()
        }

        expect:
        isUnique==false
    }

    def "Verify singleton uniqueness in threads"() {
        setup:
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<ThreadSafeSingleton> threadSafeSingletonCallable = new Callable<ThreadSafeSingleton>() {
            @Override
            ThreadSafeSingleton call() throws Exception {
                return ThreadSafeSingleton.getThreadSafeSingleton()
            }
        }

        boolean isUnique = true
        for(int i=0; i<10000; i++) {
            Future<ThreadSafeSingleton> f1 = executorService.submit(threadSafeSingletonCallable)
            Future<ThreadSafeSingleton> f2 = executorService.submit(threadSafeSingletonCallable)
            if (f1.get() != f2.get()) {
                isUnique = false
                break
            }
            ThreadSafeSingleton.clearThreadSafeSingleton()
        }

        expect:
        isUnique==true
    }

}
