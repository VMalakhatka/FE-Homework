package connector;

class FastConnection extends Connection implements Cloneable {
    public FastConnection(String host, int port, String protocol) {
        super(host, port, protocol);
    }

    @Override
    protected FastConnection clone() {
        return new FastConnection(getHost(), getPort(), getProtocol());
    }
}
