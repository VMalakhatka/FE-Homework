package org.mergesort;

import org.mergesort.util.MergeSortTask;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        String[] strings = new String[10_000];
        // Заполняем массив случайными строками
        for (int i = 0; i < strings.length; i++) strings[i] = randomString();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        String[] sortedArray = pool.invoke(new MergeSortTask(strings));
        for (String s:sortedArray) System.out.println(s);
        System.out.println("Размер результирующего массива "+sortedArray.length);
        pool.close();
    }

    private static String randomString() {
        int length = (int) (Math.random() * 100);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}