package connector;

import java.util.Random;

class Connector {
    private static final Random random = new Random();
    private static int connectionWaitTime = -1;
    private static FastConnection fastConnection;

    public static void setConnectionWaitTime() {
        if (connectionWaitTime == -1) {
            connectionWaitTime = random.nextInt(500); // время ожидания
        }
    }

    public static synchronized Connection getConnection() {
        setConnectionWaitTime();
        if (connectionWaitTime < 300) {
            if (fastConnection==null)
                return fastConnection=new FastConnection("localhost", 8080, "HTTP");
            return fastConnection.clone();
        } else {
            return SlowConnection.getInstance("localhost", 8088, "HTTP");
        }
    }
}