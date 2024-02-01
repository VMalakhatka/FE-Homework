package org.example.common.interfaces.controller;


import org.example.common.interfaces.game.GameModel;

//public abstract class AbstractController implements GameTimer, GameModel, RecordHolder {
public abstract class AbstractController implements GameModel {
//    protected final GameTimer timer;
    protected final GameModel model;
//    protected final RecordHolder recordHolder;

    public AbstractController(GameModel model) {
//        this.timer = timer;
        this.model = model;
//        this.recordHolder = recordHolder;
    }
}
