package org.example.common.interfaces.game;

public interface FieldModel {
    void setClose(int keg);

    void setClose(int row, int colum,int keg);

    FieldState getState();

    boolean isPeople();

}
