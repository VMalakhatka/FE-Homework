package connector;

class SlowConnection extends Connection {
    private static SlowConnection instance;

    private SlowConnection(String host, int port, String protocol) {
        super(host, port, protocol);
    }

    public static synchronized SlowConnection getInstance(String host, int port, String protocol) {
        if (instance == null) {
            instance = new SlowConnection(host, port, protocol);
        }
        return instance;
    }
}