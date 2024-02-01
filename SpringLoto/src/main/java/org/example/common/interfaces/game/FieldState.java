package org.example.common.interfaces.game;

public record FieldState(CellDto[][] field, boolean win,String name, boolean isPeople) {

}
