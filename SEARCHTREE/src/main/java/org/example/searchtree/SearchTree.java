package org.example.searchtree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {

    private Node root;

    private static class Node {
        String key;
        Integer value;

        //        List<Node> children;
        Node left;
        Node right;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Integer get(String key) { // O(log n) if tree is balanced, O(n) if tree is not balanced
        Node current = root;

        while (current != null) {
            int result = key.compareTo(current.key);
            if (result == 0) return  current.value;
            else if (result < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public void add(String key, Integer value) {
        root = add(root, key, value);
    }

    private Node add(Node current, String key, Integer value) { // O(log n) if tree is balanced, O(n) if tree is not balanced
        if (current == null) {
            current = new Node(key, value);
        } else {
            int result = key.compareTo(current.key);
            if (result == 0) current.value = value;
            else if (result < 0) current.left = add(current.left, key, value);
            else current.right = add(current.right, key, value);
        }
        return current;
    }

    public Iterable<String> getAllKeys(){ // O(n)
        Queue<String> queue = new LinkedList<>();
        inorder(queue, root);
        return queue;
    }

    private void inorder(Queue<String> queue, Node current) {
        if (current.left != null) inorder(queue, current.left);
        queue.add(current.key);
        if (current.right != null) inorder(queue, current.right);
    }

    // O(n log(n)) time complexity
    // O(n) space complexity
    public static String[] sortWithTree(String[] data) {
        SearchTree tree = new SearchTree(); // O(1)
        for (String s : data) { // O(n log(n))
            tree.add(s, 0); // O(log n)
        }
        Iterable<String> keys = tree.getAllKeys(); // O(n)
        String[] sortedData = new String[data.length];
        int i = 0;
        for (String s : keys) { // O(n)
            sortedData[i++] = s;
        }
        return sortedData;
    }

    public String getMaxKey(){ // O(log n) if tree is balanced, O(n) if tree is not balanced
        Node current = root;
        while (current != null) {
            if (current.right == null) return current.key;
            current = current.right;
        }
        return null;
    }

    public String searchByValueBFS(Integer value) { // O(n)
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.value.equals(value)) return current.key;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return null;
    }

//    public String searchByValueDFS(Integer value) { // O(n) TODO
//        return null;
//    }

    public String searchByValueDFS(Integer value) {
        return searchByValueDFS(root, value);
    }

    private String searchByValueDFS(Node current, Integer value) {
        if (current == null) {
            return null;
        }

        if (current.value.equals(value)) {
            return current.key;
        }

        // Рекурсивный поиск в левом поддереве
        String resultLeft = searchByValueDFS(current.left, value);
        if (resultLeft != null) {
            return resultLeft;
        }

        // Рекурсивный поиск в правом поддереве
        return searchByValueDFS(current.right, value);
    }
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }

        return false;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = getHeight(current.left);
        int rightHeight = getHeight(current.right);

        // Высота текущего узла равна максимуму из высот левого и правого поддеревьев плюс один
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.add("C", 10);
        tree.add("A", 20);
        tree.add("B", 30);
        tree.add("D", 40);
        tree.add("G", 90);

        // Если добавлять ключи последовательно, несбалансированное дерево поиска выродится в связный список
        // A -> B -> C -> D -> E

        System.out.println(tree.get("A"));
        System.out.println(tree.get("B"));
        System.out.println(tree.get("C"));
        System.out.println(tree.get("D"));
        System.out.println(tree.get("G"));
        System.out.println(tree.get("X"));

        System.out.println(tree.getAllKeys());

        String[] sorted = sortWithTree(new String[]{"Hello", "World", "C", "D", "A"});
        System.out.println(Arrays.toString(sorted));

        System.out.println("Max key = " + tree.getMaxKey());

        System.out.println("searchByValueBFS: " + tree.searchByValueBFS(90));
        System.out.println("searchByValueDFS: " + tree.searchByValueDFS(40));
        System.out.println("height oh tree is  "+tree.getHeight());
        System.out.println("isBalanced " + tree.isBalanced());
    }

}