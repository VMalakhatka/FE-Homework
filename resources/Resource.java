package org.resources;

class Resource {
    private static int idCounter = 0;
    private final int id;

    public Resource() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }
}