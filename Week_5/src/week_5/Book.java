package week_5;

class Book {
    String bookId;
    String title;
    String author;
    String genre;
    int copies;
    boolean Available;

    Book(String bookId, String title, String author, String genre, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        setCopies(copies);  // Ensures availability is set correctly
    }

    void setBookId(String bookId) {
        this.bookId = bookId;
    }
    
    String getBookId() {
        return bookId;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    String getAuthor() {
        return author;
    }  
     
    void setGenre(String genre) {
        this.genre = genre;
    }

    String getGenre() {
        return genre;
    }
    
    //Set Copies and Automatically Update Availability
    void setCopies(int copies) {
        this.copies = copies;
        setAvailable(copies > 0); // Updates availability based on copies
    }
    
    int getCopies() {
        return copies;
    }
    
    // Getter: is<VariableName>() for booleans.
    // Setter: set<VariableName>(boolean <value>).
        
    boolean isAvailable() {
        return Available;
    }

    void setAvailable(boolean Available) {
        this.Available = Available;
    }
                
     void displayDetails() {
        System.out.println("Book ID: " + bookId + " | Title: " + title + " | Author: " + author +
                " | Genre: " + genre + " | Copies: " + copies + " | Available: " + (Available ? "Yes" : "No"));
    }
}