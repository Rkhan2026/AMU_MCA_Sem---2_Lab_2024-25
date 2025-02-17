package week_5;
import java.util.ArrayList;

class User {
    String userId, name;
    ArrayList<String> borrowedBooks = new ArrayList<>();

    User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    void borrowBook(Catalog catalog, String bookId) {
        if (catalog.borrowBook(bookId)) {
            borrowedBooks.add(bookId);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    void returnBook(Catalog catalog, String bookId) {
        if (!borrowedBooks.contains(bookId)) {
            System.out.println("You can only return books that you have borrowed.");
            return;
        }
        if (catalog.returnBook(bookId)) {
            borrowedBooks.remove(bookId);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Error returning the book in the catalog.");
        }
    }
}