package Algoritm_HW_21_01_24.FindString;

public class StringSearch {

    public static int search(String target, String[] arr) {
        if (arr == null || target == null || target.isEmpty()) {
            return -1;
        }

        return binarySearch(target, arr, 0, arr.length - 1);
    }

    private static int binarySearch(String target, String[] arr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = arr[mid].compareTo(target);

            if (compareResult == 0) {
                return mid; // Совпадение найдено
            }

            if (arr[mid].isEmpty()) {
                // Если текущая строка пустая
                int leftNonEmpty = mid - 1;
                int rightNonEmpty = mid + 1;

                while (true) {
                    if (leftNonEmpty < left && rightNonEmpty > right) {
                        return -1; // Строка не найдена
                    }

                    if (rightNonEmpty <= right && !arr[rightNonEmpty].isEmpty()) {
                        mid = rightNonEmpty;
                        break;
                    }

                    if (leftNonEmpty >= left && !arr[leftNonEmpty].isEmpty()) {
                        mid = leftNonEmpty;
                        break;
                    }

                    leftNonEmpty--;
                    rightNonEmpty++;
                }
            }
            compareResult = arr[mid].compareTo(target);
            if (compareResult < 0) {
                left = mid + 1;
            } else if (compareResult > 0){
                right = mid - 1;
            }else return mid;
        }

        return -1; // Строка не найдена
    }

    public static void main(String[] args) {
        String[] arr = {"at", "", "", "","ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ball";
        int position = search(target, arr);

        if (position != -1) {
            System.out.println("Строка '" + target + "' найдена на позиции " + position);
        } else {
            System.out.println("Строка '" + target + "' не найдена");
        }
    }
}