package week_5;

class Admin {
   String adminId, name;

    Admin(String adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    void addBookToCatalog(Catalog catalog, Book book) {
        catalog.addBook(book);
    }
}