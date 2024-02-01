package org.example.model.field;

import org.example.common.interfaces.game.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ModelOfGame implements GameModel{
    private final FieldModel fieldPeople;
    private final FieldModel fieldComputer;
    private final PouchInterface pouch;

    @Autowired
    public ModelOfGame(@Qualifier("fieldPeople") Field fieldPeople,
                       @Qualifier("fieldComputer") Field fieldComputer,
                       Pouch pouch) {
        this.fieldPeople = fieldPeople;
        this.fieldComputer = fieldComputer;
        this.pouch = pouch;
    }

    @Override
    public void setClose() {
      fieldComputer.setClose(pouch.peekKeg());
      fieldPeople.setClose(pouch.peekKeg());
    }


    @Override
    public void setCloseComputer() {
//        if (!fieldPeople.isPeople())
//            fieldPeople.setClose(pouch.peekKeg());
//        if (!fieldComputer.isPeople())
            fieldComputer.setClose(pouch.peekKeg());
    }
    @Override
    public void setClose(int row, int colum) {
                fieldPeople.setClose(row,colum, pouch.peekKeg());
    }


    @Override
    public GameState getState() {
        return new GameState(fieldComputer.getState(),
                fieldPeople.getState(), pouch.peekKeg());
    }

    @Override
    public int takeKeg() {
        return pouch.getKeg();
    }

    @Override
    public int showKeg() {
        return pouch.peekKeg();
    }

    @Override
    public boolean isEmpty() {
        return pouch.isEmpty();
    }

    @Override
    public void startNewGame() {
//        System.out.println(fieldPeople);
//        System.out.println(fieldComputer);
//        System.out.println("Выпал боченок " + pouch.getKeg());
//        takeKeg();
    }
}
