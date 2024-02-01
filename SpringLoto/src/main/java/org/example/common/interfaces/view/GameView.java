package org.example.common.interfaces.view;

import org.example.common.interfaces.game.GameState;

public interface GameView {
    void show();
    void redraw(GameState gameState);
}