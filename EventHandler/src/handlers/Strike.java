package handlers;

import reflect.EventHandler;

@EventHandler
public class Strike {
    String type;

    public Strike(String type) {
        this.type = type;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Srike " + type;
    }
}
