package LibraryManagementSystem;

public class Librarian extends User {
    
    public Librarian(String userId, String name, String email) {
        super(userId, name, email);
    }

    public void addBook(Book book, Library library) {
        library.addBook(book);
        System.out.println("Book added successfully");
    }

    public void removeBook(Book book, Library library) {
        library.removeBook(book);
        System.out.println("Book removed successfully!");
    }
}
