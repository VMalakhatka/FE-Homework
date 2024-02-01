package org.example.model.field;

public record Cell(boolean isDigit, boolean isOpened, int digit) {
    public Cell (Cell original, boolean isOpened) {
        this(original.isDigit(),isOpened,original.digit());
    }
    public Cell close() {
        return new Cell(this, false);
    }
}
