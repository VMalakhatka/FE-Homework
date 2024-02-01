package org.example.model.field;


import org.example.common.interfaces.game.CellDto;
import org.example.common.interfaces.game.FieldState;

public class FieldMapper {
    private FieldMapper() {}

    public static CellDto mapCell(Cell cell) {
        return new CellDto(cell.isDigit(), cell.isOpened(), cell.digit());
    }
    public static CellDto[][] mapAllCells(Cell[][] cells) {
        CellDto[][] cellDtos = new CellDto[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cellDtos[i][j] = mapCell(cells[i][j]);
            }
        }
        return cellDtos;
    }

    public static FieldState mapField(Field field,String name) {
        return new FieldState(mapAllCells(field.getCells()), field.isWin(), field.name, field.isPeople());
    }
}
