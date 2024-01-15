package handlers;

import reflect.EventHandler;

public class Sleep {
    String type;

    public Sleep(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Srike " + type;

    }
}
