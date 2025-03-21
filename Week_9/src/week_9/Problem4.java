package week_9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem4 {
    static Logger logger = LogManager.getLogger(Problem4.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number to divide 100: ");
            int userInput = scanner.nextInt();

            int result = 100 / userInput;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            logger.error("Division by zero error occurred: {}", e.getMessage(), e);
            System.out.println("ArithmeticException: Division by zero is not allowed. Please enter a valid number.");
        
        } catch (InputMismatchException e) {
            logger.error("Invalid input type: ", e.getMessage(), e);
            System.out.println("InputMismatchException: Please enter a valid integer.");
        } 
    }
}