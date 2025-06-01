package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private List<Book> borrowedBooks;

    public Member(String userId, String name, String email) {
        super(userId, name, email);
        this.borrowedBooks = new ArrayList<>();
    }
    
    public void borrowBook(Book book) {
        if(borrowedBooks.size() >= 5) {
            System.out.println("You can't borrow more than 5 books");
            return;
        }
        if(book.isIssued()) {
            System.out.println("Book is already issued");
            return;
        }
        borrowedBooks.add(book);
        System.out.println("You have borrowed " + book.getTitle());
        book.setIsIssued(true);
    }

    public void returnBook(Book book) {
        if(!borrowedBooks.contains(book)) {
            System.out.println("You haven't borrowed this book");
            return;
        }
        borrowedBooks.remove(book);
        System.out.println("You have returned " + book.getTitle());
        book.setIsIssued(false);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
