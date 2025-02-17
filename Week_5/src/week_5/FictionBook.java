package week_5;

class FictionBook extends Book {
    FictionBook(String bookId, String title, String author, int copies) {
        super(bookId, title, author, "Fiction", copies);
    }

    @Override
    void displayDetails() {
        System.out.println("Fiction Book - " + getTitle() + " by " + getAuthor() +
                " Copies: " + getCopies() + " | Available: " + (isAvailable() ? "Yes" : "No"));
    }
}