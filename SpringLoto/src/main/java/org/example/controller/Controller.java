package org.example.controller;

import org.example.common.interfaces.controller.AbstractController;
import org.example.common.interfaces.game.GameModel;
import org.example.common.interfaces.game.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Controller extends AbstractController {


    @Autowired
    public Controller(@Qualifier("modelOfGame") GameModel model) {
        super(model);
    }

    @Override
    public void setClose() {
        super.model.setClose();
    }

    @Override
    public void setClose(int row, int colum){
        super.model.setClose(row,colum);
    }

    @Override
    public void setCloseComputer() {
        super.model.setCloseComputer();
    }

    @Override
    public GameState getState() {

        return super.model.getState();
    }

    @Override
    public int takeKeg() {
        return super.model.takeKeg();
    }

    @Override
    public int showKeg() {
        return super.model.showKeg();
    }

    @Override
    public boolean isEmpty() {
        return super.model.isEmpty();
    }

    @Override
    public void startNewGame() {
        super.model.startNewGame();
    }

}
