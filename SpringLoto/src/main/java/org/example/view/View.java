package org.example.view;

import org.example.common.interfaces.game.CellDto;
import org.example.common.interfaces.game.GameState;
import org.example.common.interfaces.view.GameView;
import org.example.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

@Component
public class View implements GameView {
    Controller controller;
//    private Controller ;

    @Autowired
    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void show() {
        controller.startNewGame();
        System.out.println("Start game in view->show");
        GameState gameState ;
//        = controller.getState();
//        outState(gameState);
        while (!controller.isEmpty()) {
            controller.takeKeg();
            gameState=controller.getState();
            System.out.println("Выпал бочонок " + gameState.keg());
            controller.setCloseComputer();
            gameState = controller.getState();
            outState(gameState);
            Optional<Map.Entry<Integer, Integer>> opModel = answer();
            if (opModel.isPresent()) {
                int row = opModel.get().getKey();
                int column = opModel.get().getValue();
                controller.setClose(row, column);
            }
            gameState = controller.getState();
//            outState(gameState);
            if(gameState.field1().win()) {
                System.out.println(gameState.field1().name() + " WIN!!!!");
                break;
            }
            if(gameState.field2().win()) {
                System.out.println(gameState.field2().name() + " WIN!!!!");
                break;
            }
        }
    }

    private Optional<Map.Entry<Integer,Integer>> answer(){
        String answer;
        Scanner scanner = new Scanner(System.in);
        boolean right=false;
        boolean yes=false;
        while (!right) {
            System.out.println("Если у вас сесть совпадение Y если нет N?");
            answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Вы ввели 'Y'.");
                right=true;
                yes=true;
            } else if (answer.equalsIgnoreCase("N")) {
                right=true;
                System.out.println("Вы ввели 'N'.");
            } else {
                System.out.println("Неверный ввод. Введите только 'Y' или 'N'.");
            }
        }
        if (!yes)
            return Optional.empty();
        System.out.print("Введите строку число: ");
        int row = scanner.nextInt();
        System.out.print("Введите столбец число: ");
        int  column = scanner.nextInt();
        return Optional.of(new Map.Entry<>() {
            private final Integer key = row;
            private final Integer value = column;

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
        });
}

private void outState(GameState gameState){
    System.out.println(gameState.field1().name()+" isPeople "+gameState.field1().isPeople());
    System.out.println(print(gameState.field1().field()));
    System.out.println(gameState.field2().name()+" isPeople "+gameState.field2().isPeople());
    System.out.println(print(gameState.field2().field()));
}
    @Override
    public void redraw(GameState gameState) {

    }

    public String print(CellDto[][] cells) {
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

}