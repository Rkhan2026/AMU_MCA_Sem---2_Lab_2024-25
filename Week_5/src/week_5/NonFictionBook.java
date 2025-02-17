package week_5;

class NonFictionBook extends Book {
   NonFictionBook(String bookId, String title, String author, int copies) {
        super(bookId, title, author, "Non-Fiction", copies);  
    }

    @Override
    void displayDetails() {
        System.out.println("Non-Fiction Book - " + getTitle() + " by " + getAuthor() +
                " Copies: " + getCopies() + " | Available: " + (isAvailable() ? "Yes" : "No"));
    }
}