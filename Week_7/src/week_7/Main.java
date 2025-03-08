package week_7;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataProcessor processor = new DataProcessor();

       while (true) {
            System.out.println("Menu-->");
            System.out.println("\n1. Write numeric values to input file");
            System.out.println("2. Read values, calculate average, and save to output file");
            System.out.println("3. Read and print values from input file");
            System.out.println("4. Read and print average from output file");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter input file name (without .txt): ");
                    String inputFile = scanner.nextLine().trim() + ".txt";
                    processor.writeValuesToFile(inputFile);
                    break;

                case 2:
                    System.out.print("Enter input file name (without .txt): ");
                    String inputFilePath = scanner.nextLine().trim() + ".txt";

                    System.out.print("Enter output file name (without .txt): ");
                    String outputFilePath = scanner.nextLine().trim() + ".txt";
  
                    try {
                        List<String> values = processor.readValuesFromFile(inputFilePath);
                        List<Double> validValues = processor.validateData(values);
                        
                        double average = processor.calculateAverage(validValues);                   
                        processor.writeResultToFile(average, outputFilePath);
                    } catch (InvalidDataException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
         
                    break;

                case 3:
                    System.out.print("Enter input file name (without .txt): ");
                    String readFile = scanner.nextLine().trim() + ".txt";

                    List<String> fileValues = processor.readValuesFromFile(readFile);
                    processor.printValuesfromInput(fileValues);       
                    
                    break;
                
                 case 4:
                    System.out.print("Enter output file name (without .txt): ");
                    String outputFile = scanner.nextLine().trim() + ".txt";
                    processor.readAndPrintAverage(outputFile);
                    break;
                     
                case 5:
                    System.out.println("Exiting Menu.");                  
                    return; //to leave he while loop

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}