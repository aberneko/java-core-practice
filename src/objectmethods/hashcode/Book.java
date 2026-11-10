package objectmethods.hashcode;

import java.util.Objects;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void main() {
        Book book = new Book("Валентайн", "Азырадарит");
        Book book1 = new Book("Валентайн", "Азырадарит");

        boolean isTrueOrFalse = book.equals(book1);
        System.out.println(isTrueOrFalse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author);
    }
}