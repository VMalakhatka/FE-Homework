package groupingword;

import java.util.*;

public class GroupWordsByUniqueCharacters {

    public static String SortChar(String word){
        // Преобразуем символы слова в массив символов, сортируем и объединяем обратно в строку
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static Set<Character> arrayToSet(char[] charArray) {
        Set<Character> charSet = new HashSet<>();
        for (char c : charArray) {
            charSet.add(c);
        }
        return charSet;
    }
    static class KeyComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            char[] charArray = str1.toCharArray();
            Set<Character> charSet1 = arrayToSet(charArray);
            char[] charArray2 = str2.toCharArray();
            Set<Character> charSet2 = arrayToSet(charArray2);
            return charSet2.equals(charSet1)==true ? 0:1;
        }
    }
    public static List<List<String>> groupWords(String[] words) {
        TreeMap<String, List<String>> groupsMap = new TreeMap<>(new KeyComparator());

        for (String word : words) {
            String sortedWord=SortChar(word);
            // Добавляем слово в соответствующую группу
            groupsMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        // Преобразуем значения карты в список списков
        return new ArrayList<>(groupsMap.values());
    }

    public static void printGroups(List<List<String>> groups) {
        for (List<String> group : groups) {
            System.out.println(String.join(", ", group));
        }
    }

    public static void main(String[] args) {
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
        List<List<String>> groups = groupWords(words);
        printGroups(groups);
    }
}