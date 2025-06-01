package LibraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        
        Library library = new Library();
        Book book1 = new Book("001", "Sonar Kella", "Satyajit Ray", Category.FICTION);
        Librarian librarian = new Librarian("1", "Biswas", "abc@example.com");
        librarian.addBook(book1, library);
        
        Member member = new Member("2", "Rahul", "z2L2A@example.com");
        member.borrowBook(book1);
        member.borrowBook(book1);   
    }
}
