package week_8;

import java.io.*;
import java.util.Scanner;

public class Problem1_ExceptionCounter {

    public static int countExceptions(String filePath) {
        int exceptionCount = 0; 
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {          
                if (line.contains("catch")) exceptionCount++;      
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please check the filename and path. "+e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return exceptionCount; 
    }

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the Java file (without .java extension):");
        //Path For Home Laptop --> E:\Practical Lab Related\Lab Assignments\Week_8\src\week_8\Counting_Exceptions.java
        String userInput = scanner.nextLine().trim();

        // If the user input does not end with ".java", append it
        if (!userInput.endsWith(".java")) {
            userInput = userInput + ".java";
        }       

        int totalExceptions = countExceptions(userInput);

        System.out.println("\nTotal number of exceptions found in " + userInput + ": " + totalExceptions);
    }
}