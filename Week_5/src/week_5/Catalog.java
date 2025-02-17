package week_5;

import java.util.ArrayList;

class Catalog {
     ArrayList<Book> books = new ArrayList<>();

     void addBook(Book book) {
        Book existingBook = getBook(book.getBookId());
        if (existingBook != null) {
            existingBook.setCopies(existingBook.getCopies() + book.getCopies());
            updateBookAvailability(book.getBookId()); 
            System.out.println("Updated copies of '" + existingBook.getTitle() + "'.");
        } else {
            books.add(book);
            updateBookAvailability(book.getBookId());
            System.out.println("New book added: " + book.getTitle());
        }
    }

   void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.isAvailable()) book.displayDetails();
        }
    }

    Book getBook(String bookId) {
        for (Book book : books) if (book.getBookId().equals(bookId)) return book;
        return null;
    }

     boolean borrowBook(String bookId) {
        Book book = getBook(bookId);
        if (book != null && book.isAvailable()) {
            
            System.out.println("Before borrowing, copies: " + book.getCopies());
            book.setCopies(book.getCopies() - 1);  
            System.out.println("After borrowing, copies: " + book.getCopies());
                       
            updateBookAvailability(bookId); 
            return true;
        }
        return false;
    }

     boolean returnBook(String bookId) {
        Book book = getBook(bookId);
        if (book != null) {
            
            System.out.println("Before returning, copies: " + book.getCopies());
            book.setCopies(book.getCopies() + 1);
            System.out.println("After returning, copies: " + book.getCopies());
                                 
            updateBookAvailability(bookId);  
            return true;
        }
        return false;
    }

    void updateBookAvailability(String bookId) {
        Book book = getBook(bookId);
        if (book != null) {
            book.setAvailable(book.getCopies() > 0);  
        }
    }
}