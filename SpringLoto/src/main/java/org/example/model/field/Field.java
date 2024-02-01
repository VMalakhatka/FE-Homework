package org.example.model.field;

import org.example.common.exeption.GameException;
import org.example.common.interfaces.game.FieldModel;
import org.example.common.interfaces.game.FieldState;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Field implements FieldModel {
    String name;
    private final Cell[][] cells;
    private int digitCount;
    private boolean isChanged;
    private boolean win;
    private final boolean isPeople;
    @Override
    public boolean isPeople() {
        return isPeople;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean isWin() {
        return win;
    }

    public Field(boolean isPeople,String name) {
        this.name=name;
        this.win = false;
        cells = new Cell[3][9];
        fillInCells();
        fillDigit();
        digitCount=15;
        this.isPeople=isPeople;
    }

    private void fillDigit() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j <= 4; j++) {
                int row = ThreadLocalRandom.current().nextInt(9);
                while (cells[i][row].isDigit())
                    row = ThreadLocalRandom.current().nextInt(9);
                int newDigit=0;
                boolean isEqual=true;
//                проверка на повторы цыфр
                while (isEqual) {
                    isEqual=false;
                    newDigit=row * 10 + ThreadLocalRandom.current().nextInt(10);
                    for (int k = 0; k <=i-1; k++) {
                        if(cells[k][row].isDigit())
                            if (cells[k][row].digit()== newDigit){
                                isEqual=true;
                                break;
                            }
                    }
                }
                cells[i][row] = new Cell(true, true,newDigit);
            }
        }
    }

    private void fillInCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(false, true, 999);
            }
        }
    }

    @Override
    public String toString() {
        System.out.println(name);
        StringBuffer field = new StringBuffer();
        Arrays.stream(cells).forEach(row -> {
            field.append("|");
            Arrays.stream(row).forEach(e -> {
                assert false;
                field.append(e.isDigit() ?
                        e.isOpened() ? "|_"+String.format("%02d_|", e.digit()) : "|_XX_|"
                        :
                        "|____|");
            });
            assert false;
            field.append("|\n");
        });
        assert false;
        return field.toString();
    }

    private void checkCellAddress(int row, int column) {
        if (row >= cells.length || column >= cells[row].length) {
            throw new GameException("Передан неправильный адрес ячейки");
        }
    }

    private Map.Entry<Integer,Integer> findCell(int keg){
        for (int i = 0; i < cells.length; i++){
            int j=keg/10;
                if(cells[i][j].digit()==keg) {
                    isChanged=true;
                    digitCount--;
//                    System.out.println(name+" isPeople "+ isPeople);
//                    System.out.println("count "+digitCount +" cell "+cells[i][j].digit() +" keg "+ keg);
                    checkWin();
                    int finalI = i;
                    return new Map.Entry<>() {
                        private final Integer key = finalI;
                        private final Integer value = j;

                        @Override
                        public Integer getKey() {
                            return key;
                        }

                        @Override
                        public Integer getValue() {
                            return value;
                        }

                        @Override
                        public Integer setValue(Integer value) {
                            throw new UnsupportedOperationException("setValue is not supported");
                        }
                    };
                }

        }
        return null;
    }

    @Override
    public void setClose(int keg) {
        isChanged=false;
        Map.Entry<Integer, Integer> entry=findCell(keg);
        if(entry==null) return ;
        int row = entry.getKey();
        int column=entry.getValue();
        checkCellAddress(row,column);
        Cell cell=cells[row][column];
        if (!cell.isOpened()) return ;
        cells[row][column]=cell.close();
    }

    @Override
    public void setClose(int row, int colum, int keg) {
        checkCellAddress(row,colum);
//        System.out.println(name+" keg-"+keg+" row-"+row+"column-"+colum);
//        System.out.println(cells[row][colum].digit());
        if(cells[row][colum].digit()==keg) {
            cells[row][colum]=cells[row][colum].close();
        }
    }

    private void checkWin() {
//            если все поле заполнил
        if (digitCount==0) this.win=true;
//        если одна линия
        boolean isWin=false;
        for (int i = 0; i < cells.length; i++) {

        }
    }


    @Override
    public FieldState getState() {
        return FieldMapper.mapField(this,name);
    }

}
