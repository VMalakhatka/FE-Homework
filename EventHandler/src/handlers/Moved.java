package handlers;

import reflect.EventHandler;

@EventHandler
public class Moved {
    String type;

    public Moved(String type) {
        this.type = type;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Srike " + type;

    }
}
