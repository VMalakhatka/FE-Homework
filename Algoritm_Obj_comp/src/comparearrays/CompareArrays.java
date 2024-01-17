package comparearrays;

import java.util.HashMap;
import java.util.Map;

public class CompareArrays {
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int num : arr2) {
            if (!frequencyMap.containsKey(num)) {
                return false; // Если элемент не встречается в arr1, массивы не равны
            }
            int i = frequencyMap.get(num) - 1;
            if (i==0) frequencyMap.remove(num); // Если частота стала 0, удаляем элемент из frequencyMap
            else frequencyMap.put(num, i);
        }
        // Если frequencyMap становится пустым, значит, массивы равны
        return frequencyMap.isEmpty();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 4, 0, 0};
        int[] arr2 = {0, 2, 4, 5, 0, 1};

        if (areArraysEqual(arr1, arr2)) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
