package org.example.app;

import org.example.common.interfaces.game.CellDto;
import org.example.common.interfaces.game.GameState;
import org.example.controller.Controller;
import org.example.config.AppConfig;
import org.example.view.View;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Loto {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
//        Controller controller = context.getBean( Controller.class);
        View view=context.getBean(View.class);

//        GameState gameState=controller.getState(false);
//        System.out.println(print(gameState.field1().field()));
//        System.out.println(print(gameState.field2().field()));

//        controller.startNewGame();

        view.show();




//        Field field=new Field(true);
//        Field field1=new Field(false);
//        System.out.println(field);
//        System.out.println(field1);
//        Pouch pouch=new Pouch();
//        System.out.println(pouch);
//        FieldState gameState;
//        FieldState gameState1;
//        boolean win=false;
//        int keg;
//        int iter=0;
//        while (!pouch.isEmpty()){
//            keg=pouch.getKeg();
//            gameState=field.setClose(keg);
//            gameState1=field1.setClose(keg);
//            System.out.println("Шаг "+ iter++ +" Выпал боченок "+keg);
//            if (gameState.isChanged()) {
//                System.out.println("Игрок1 закрыл поле " + keg);
//                System.out.println(field);
//            }
//            if (gameState1.isChanged()){
//                System.out.println("Игрок2 закрыл поле " + keg);
//                System.out.println(field1);
//            }
//            if(field.isWin()) {
//                System.out.println("выиграл игрок 1");
//                win=true;
//            }
//            if (field1.isWin()){
//                System.out.println("выиграл игрок 2");
//                win=true;
//            }
//            if (win) break;
//        }
//        System.out.println("Loop is ended  "+pouch.isEmpty());

        context.close();
    }

    static public String print(CellDto[][] cells) {
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

// 1 уровень сложности: 1 Напишите программу для игры с компьютером по
// правилам классического Лото (без ставок).
//https://ru.wikipedia.org/wiki/%D0%9B%D0%BE%D1%82%D0%BE
//У пользователя и у компьютера есть свои наборы полей.  Выполните
// приложение, используя паттерн MVC. В качестве View реализуйте
// взаимодействие через консоль. По Вашему желанию, попробуйте сделать
// графический интерфейс с помощью библиотеки
// Swing https://java-online.ru/swing-windows.xhtml
