package org.example.common.interfaces.game;

public interface GameModel {
    void setClose();

    void setClose(int row, int colum);

    void setCloseComputer();
    GameState getState();

    int takeKeg();
    int showKeg();
    boolean isEmpty();

    void startNewGame();
}
