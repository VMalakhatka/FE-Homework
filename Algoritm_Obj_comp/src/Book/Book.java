package Book;

import java.util.Objects;


public class Book implements Comparable<Book> {
    private String name;
    private double price;
    private boolean isPresent;


    public Book(String name, double price, boolean isPresent) {
        this.name = name;
        this.price = price;
        this.isPresent = isPresent;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                isPresent == book.isPresent &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, isPresent);
    }

    @Override
    public int compareTo(Book another) {
        return this.name.compareTo(another.name);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Book A", 19.99, true);
        Book book2 = new Book("Book B", 15.99, false);


        int result = book1.compareTo(book2);
        if (result < 0) {
            System.out.println(book1.getName() + "  меньше " + book2.getName());
        } else if (result > 0) {
            System.out.println(book1.getName() + " больше " + book2.getName());
        } else {
            System.out.println(book1.getName() + " и " + book2.getName() + " одинаковые названия");
        }
    }
}
