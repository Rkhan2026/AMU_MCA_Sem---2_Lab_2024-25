package week_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Important Note Regarding The Closing Of the File Stream=>
//Because the BufferedReader instance is declared in a try-with-resource statement, 
//it will be closed regardless of whether the try statement completes normally or abruptly. 
//So you don't need to close it yourself in the finally statement. (This is also the case with nested resource statements)

class DataProcessor {

    // Method to write numeric values to a file
    public void writeValuesToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter numeric values (type 'done' to finish):");

            while (true) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                try {
                    writer.write(input);
                    writer.newLine();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                }
                
            }          
            System.out.println("Write Values To File Method Completed");
        } catch (IOException e) {
             System.out.println("Error writing to file - " + e.getMessage());
        }
    }

    // Reads values from a file
    //faraz Sir said to make it so that List<Double> values to List<String> values then define 
    //custom exception and also check whether the string value is numeric by a user defined way then only add value to List<Doubles>
    //in validate data.   
    public List<String> readValuesFromFile(String filePath) {        
        List<String> values = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            values.add(line.trim());     
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the file - " + e.getMessage());
        }            
        return values;
    }

    // Method to validate numeric values
    public List<Double> validateData(List<String> values) throws InvalidDataException {
        List<Double> validValues = new ArrayList<>();

        if (values.isEmpty()) {  
                throw new InvalidDataException("Invalid data found: "); 
        }
        
        else {
            
            for (String value : values) {                 
                if (value == null) {
                    throw new InvalidDataException("Invalid data found: Null or blank value");
                }
                //The regex pattern \\d+ is used to match one or more digits in a string.
                // \\d	Matches any single digit (0-9).
                // +	Matches one or more occurrences of digits.               
                else if (value.matches("\\d+")) {
                    validValues.add(Double.parseDouble(value)); // Add valid number      
                } else {
                     throw new InvalidDataException("Invalid data found: '" + value + "' is not a number");
                }
            }                      
        }
        
        return validValues;
    }

    // Method to calculate the average
    public double calculateAverage(List<Double> validValues) {
        if (validValues.isEmpty()) {
            System.out.println("Warning - There are no valid values present.");            
        }       
        double sum = 0;
        for (double value : validValues) {
            sum = sum + value;
        }   
        
        return sum / validValues.size();
    }

    // Method to write the average to an output file
    public void writeResultToFile(double average, String outputPath) {             
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            
            if (Double.isNaN(average)) {
                System.out.println("Computed average is NaN. Result will not be written to the file.");
                return; // Stop further execution
            }
            
            writer.write("Average: " + average);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file - " + e.getMessage());
        }
       
        System.out.println("Write Result To File Method Completed");
        
    }
    
    // Method to print values to the console
    public void printValuesfromInput(List<String> values) {
        if (values.isEmpty()) {
            System.out.println("No valid numeric values found.");
        } else {
            System.out.println("Values in the file:");
            for (String value : values) {
                System.out.println(value);
            }
        }
    }

    // Method to read and print the average from an output file
    public void readAndPrintAverage(String outputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath))) {
            String average = reader.readLine();
            if (average != null) {
                System.out.println(average);
            } else {
                System.out.println("The output file is empty.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Output file not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the output file - " + e.getMessage());
        }
    }
}