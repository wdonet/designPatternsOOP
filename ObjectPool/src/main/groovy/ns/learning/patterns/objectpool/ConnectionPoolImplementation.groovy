package ns.learning.patterns.objectpool

@Singleton
class ConnectionPoolImplementation {

    public static final MAX_CONNECTIONS = 2

    LinkedList<ReusableConnection> allInstances = new LinkedList<>()
    Deque<ReusableConnection> reusables = new LinkedList<>()

    synchronized ReusableConnection acquireConnection() {

        if (reusables.size() > 0) {
            return reusables.pop()
        }

        if (allInstances.size() < MAX_CONNECTIONS) {
            ReusableConnection reusableConnection = new TcpPersistentConnection()
            allInstances.add(reusableConnection)

            return reusableConnection
        }

        while (reusables.isEmpty()) {
            wait()
        }

        return reusables.pop()
    }

    synchronized void releaseConnection(ReusableConnection reusableConnection) {
        reusables.push(reusableConnection)

        notifyAll()
    }

}
