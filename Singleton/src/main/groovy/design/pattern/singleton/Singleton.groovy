package design.pattern.singleton

class Singleton {
    private static Singleton singleton

    private Singleton(){}

    static Singleton getSingleton() {
        if(singleton == null) {
            singleton = new Singleton()
        }
        return singleton
    }

    static void clearSingleton() {
        singleton = null
    }
}
