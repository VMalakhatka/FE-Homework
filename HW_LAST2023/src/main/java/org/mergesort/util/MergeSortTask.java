package org.mergesort.util;

import java.util.concurrent.RecursiveTask;

import static java.util.Arrays.*;

public class MergeSortTask extends RecursiveTask<String[]> {

    private final String[] array;

    public MergeSortTask(String[] array) {
        this.array = array;
    }

    @Override
    protected String[] compute() {
        // System.out.println(array.length);
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        String[] leftResult = ( new MergeSortTask(copyOfRange(array, 0, mid))).compute();
        String[] rightResult = (new MergeSortTask(copyOfRange(array, mid, array.length))).invoke();
        return merge(leftResult, rightResult);
    }

    private String[] merge(String[] left, String[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        String[] merged = new String[leftLength + rightLength];
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex].length() <= right[rightIndex].length()) {
                merged[mergeIndex++] = left[leftIndex++];
            } else {
                merged[mergeIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < leftLength) merged[mergeIndex++] = left[leftIndex++];
        while (rightIndex < rightLength) merged[mergeIndex++] = right[rightIndex++];
        return merged;
    }
}