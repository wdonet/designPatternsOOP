package design.pattern.singleton

@groovy.lang.Singleton
class GroovySingleton {

    //The annotation creates a property named instance
        //private static GroovySingleton instance

    //The annotation provides a default private constructor
    //And does not allow more constructors
        //private GroovySingleton() {}

    //The annotation provides an static method to get the instance
        //public static GroovySingleton getInstance() {
        //    if ( instance != null) {
        //        return instance
        //    } else {
        //        return instance = new GroovySingleton()
        //    }
        //}
}

// Singleton class which allows a constructor
@groovy.lang.Singleton(strict = false)
class GroovySingletonConstructor {
    private GroovySingletonConstructor() {
        println "Invoking constructor"
    }
}

// Singleton class which perform a double-checked locking since is lazily created
@groovy.lang.Singleton(lazy = false)
class GroovySingletonLazy {

    //The instance is declared as:
        //private static volatile GroovySingletonLazy instance

    //The getInstance:
        //public static GroovySingletonLazy getInstance() {
        //    if ( instance != null) {
        //        return instance
        //    } else {
        //        synchronized (GroovySingletonLazy) {
        //            if ( instance != null) {
        //                return instance
        //            } else {
        //                return instance = new GroovySingletonLazy()
        //            }
        //        }
        //    }
        //}
}

//Singleton class which change the default 'instance' property
@groovy.lang.Singleton(property = "customProperty")
class GroovySingletonCustomProperty {
    //The instance is declared as:
        //private static GroovySingletonCustomProperty customProperty
}