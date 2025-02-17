package week_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();
        Admin admin = new Admin("A001", "Library Admin");

        System.out.println("Welcome to the Online Library System!");
        System.out.print("Register your account\nEnter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        User user = new User(userId, name);
        System.out.println("User registered successfully. Welcome, " + name + "!");

        while (true) {
            System.out.println("\nOnline Library Catalog System");
            System.out.println("1 Add Book (Admin)");
            System.out.println("2 Display Available Books");
            System.out.println("3 Borrow Book");
            System.out.println("4 Return Book");
            System.out.println("5 Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    String genre;
                    while (true) {
                        System.out.print("Enter Genre (Fiction/Non-Fiction): ");
                        genre = scanner.nextLine().trim();
                        if (genre.equalsIgnoreCase("Fiction") || genre.equalsIgnoreCase("Non-Fiction")) {
                            break;
                        }
                        System.out.println("Invalid genre! Please only enter 'Fiction' or 'Non-Fiction'.");
                    }

                    System.out.print("Enter Copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Book book;
                    if (genre.equalsIgnoreCase("Fiction")) {
                        book = new FictionBook(bookId, title, author, copies);
                    } else {
                        book = new NonFictionBook(bookId, title, author, copies);
                    }

                    admin.addBookToCatalog(catalog, book);
                    break;

                case 2:
                    catalog.displayAvailableBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    String borrowBookId = scanner.nextLine();
                    user.borrowBook(catalog, borrowBookId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    user.returnBook(catalog, returnBookId);
                    break;

                case 5:
                    System.out.println("Exiting. Thank you, " + name + "!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}