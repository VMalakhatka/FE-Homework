class CustomLinkedStack<T> {

    private Node<T> top; // Вершина стека
    private int size; // Размер стека

    // Внутренний класс для представления узла связанного списка
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Конструктор
    public CustomLinkedStack() {
        this.top = null;
        this.size = 0;
    }

    // Метод для добавления элемента в стек
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Метод для извлечения и удаления элемента из стека
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Метод для извлечения, не удаляя элемент из стека
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Метод для проверки, пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для получения размера стека
    public int size() {
        return size;
    }

    // Метод для поиска элемента в стеке
    public int search(T element) {
        Node<T> current = top;
        int position = 1;

        while (current != null) {
            if (current.data.equals(element) || (current.data == null && element == null)) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomLinkedStack<String> stack = new CustomLinkedStack<>();

        stack.push("Element1");
        stack.push("Element2");
        stack.push("Element3");

        System.out.println("Peek: " + stack.peek()); // Element3
        System.out.println("Pop: " + stack.pop());   // Element3
        System.out.println("Size: " + stack.size());  // 2
        System.out.println("Search Element1: " + stack.search("Element1")); // 2

        CustomLinkedStack<Integer> intStack = new CustomLinkedStack<>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("Peek: " + intStack.peek()); // 3
        System.out.println("Pop: " + intStack.pop());   // 3
        System.out.println("Size: " + intStack.size());  // 2
        System.out.println("Search 2: " + intStack.search(2)); // 1
    }
}