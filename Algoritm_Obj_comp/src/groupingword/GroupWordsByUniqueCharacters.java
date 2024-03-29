package groupingword;

import java.util.*;

public class GroupWordsByUniqueCharacters {

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
            Set<Character> charSet1 = arrayToSet(str1.toCharArray());
            Set<Character> charSet2 = arrayToSet(str2.toCharArray());
            return charSet2.equals(charSet1)==true ? 0:1;
        }
    }
    public static List<List<String>> groupWords(String[] words) {
        TreeMap<String, List<String>> groupsMap = new TreeMap<>(new KeyComparator());

        for (String word : words)
            // Добавляем слово в соответствующую группу
            groupsMap.computeIfAbsent(word, k -> new ArrayList<>()).add(word);

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