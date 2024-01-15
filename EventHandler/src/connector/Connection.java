package connector;

class Connection {
    private static int uniqueIdCounter = 1;
    private final int id;
    private final String host;
    private final int port;
    private final String protocol;

    public Connection(String host, int port, String protocol) {
        this.id = uniqueIdCounter++;
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }

    public int getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    @Override
    public String toString() {
        return "ID :"+id+" Host "+host+" Port"+port+" Protokol"+protocol;
    }
}