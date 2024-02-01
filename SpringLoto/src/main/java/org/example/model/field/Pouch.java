package org.example.model.field;

import org.example.common.exeption.GameException;
import org.example.common.interfaces.game.PouchInterface;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
@Component
public class Pouch implements PouchInterface {
    private final Queue<Map.Entry<Integer, Integer>> kegs;
    private int currentKeg;

    public Pouch() {
        currentKeg =999;
        this.kegs = new PriorityQueue<>(Map.Entry.comparingByKey());
        for (int i = 0; i <= 89; i++)
            this.kegs.offer(
                    new AbstractMap.SimpleEntry<>(
                            ThreadLocalRandom.current().nextInt(91),i));
//         печать очереди бочонков
//    n
//    System.out.println("Priority: " + entry.getKey() + ", Value: " + entry.getValue()));
    }
    @Override
    public boolean isEmpty(){return kegs.isEmpty();}
@Override
    public int getKeg() {

        if (kegs.isEmpty()) throw new GameException("Бочонки закончились");
    Map.Entry<Integer, Integer> entry=kegs.poll();
    currentKeg =entry.getValue();
        return currentKeg;
    }
    @Override
    public int peekKeg(){
        return currentKeg;
    }
}
