package week_9;

import java.io.*;
import java.util.Scanner;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "students.txt";

        System.out.println("Welcome to University Management System");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Write Student Data to File");
            System.out.println("2. Read Student Data from File");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt(); 
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                        System.out.println("\nEnter student details (Name and Score). Type 'done' to stop-->");
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            String name = scanner.nextLine();

                            if (name.equalsIgnoreCase("done")) break;

                            System.out.print("Enter Student Score: ");
                            String score = scanner.nextLine();

                            writer.write(name + "," + score);
                            writer.newLine();
                        }
                        System.out.println("\nStudent data has been saved to file.");

                    } catch (IOException e) {
                        System.out.println("\nError: Unable to write to the student data file.");                        
                    } 
                    break;

                case 2:
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                        System.out.println("\nReading student data from file: ");
                        
                        String line = reader.readLine();                        
                        if (line==null) throw new NullPointerException();                       
                         do {
                        
                            String[] parts = line.split(","); // May cause ArrayIndexOutOfBoundsException
                            System.out.println("Reading line: " + line);
                            String name = parts[0];
                            int score = Integer.parseInt(parts[1]); // May cause NumberFormatException

                            System.out.println("\nStudent Name: " + name + " & Score: " + score);
                        }  while ((line = reader.readLine()) != null);

                    } catch (IOException e) {
                        System.out.println("IOException Error: Unable to read the student data file.");
                    } catch (NumberFormatException e) {// An Uncheked Exception 
                        System.out.println("NumberFormatException Error: Invalid score format.");
                    } catch (ArrayIndexOutOfBoundsException e) {// An Uncheked Exception 
                        System.out.println("ArrayIndexOutOfBoundsException Error: Only ',' present in line");
                    } catch (NullPointerException e) {// An Uncheked Exception 
                        System.out.println("NullPointerException Error: The student data file is empty.");
                    }
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}