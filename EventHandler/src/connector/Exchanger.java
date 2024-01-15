package connector;

class Exchanger implements Runnable {
    private final String name;
    private final Connection connection;

    public Exchanger(String name) {
        this.name = name;
        this.connection = Connector.getConnection();
    }

    @Override
    public void run() {
        System.out.println(name + " Соединение с : " + connection+"  "+connection.getClass());
    }
}

