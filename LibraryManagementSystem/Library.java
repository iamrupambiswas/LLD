package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added to library: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed from library: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }
}
