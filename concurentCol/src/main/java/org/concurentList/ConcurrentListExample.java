package org.concurentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ConcurrentListExample {
    public static void main(String[] args) {
        List<Integer> numbers = genArray(1000000);

        // Однопоточный режим
        long startTime = System.currentTimeMillis();
        remNegNumbersSingl(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("Однопоточный : " + (endTime - startTime) + " ms");

        // Многопоточный режим
        startTime = System.currentTimeMillis();
        remNegNumbersMult(numbers);
        endTime = System.currentTimeMillis();
        System.out.println("Многопоточный " + (endTime - startTime) + " ms");
    }

    private static List<Integer> genArray(int size) {
        List<Integer> numbers = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt());
        }
        return numbers;
    }

    private static void remNegNumbersSingl(List<Integer> numbers) {
        List<Integer> positiveNumbers = Collections.synchronizedList(new ArrayList<>());

        numbers.stream().forEach(number -> { if (number >= 0) positiveNumbers.add(number); });

        numbers.clear();
        numbers.addAll(positiveNumbers);
    }

    private static void remNegNumbersMult(List<Integer> numbers) {
        List<Integer> positiveNumbers = Collections.synchronizedList(new ArrayList<>());

        // нашел что обработку стрима тоже може запустить в паралельном потоке
        numbers.parallelStream().forEach(number -> { if (number >= 0)  positiveNumbers.add(number);});

        numbers.clear();
        numbers.addAll(positiveNumbers);
    }
}