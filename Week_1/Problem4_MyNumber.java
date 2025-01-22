import java.util.Scanner;
import java.lang.Math;
public class Problem4_MyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();

        // Compute rounded value
        double numRound;
        double fractionalPart = num - (int) num; // Extract fractional part
        
        if (fractionalPart >= 0.5) {
            numRound = (int) num + 1; // Round up for positive numbers
        } else if (fractionalPart <= -0.5) {
            numRound = (int) num - 1; // Round down for negative numbers
        } else {
            numRound = (int) num; // Keep integer part as is
        }

        //Explanation Ceil Value:
       
        //Positive Numbers:
        //If the fractional part is greater than 0 (e.g., 5.65.6), the ceiling is 5+1=6
        
        //Exact Integers:
        //If the number is already an integer (e.g.,5.0), the ceiling remains 5.
        
        //Negative Numbers:
        //For negative numbers (e.g.,−3.6), the integer part 
        //−3 is already the smallest integer greater than or equal to −3.6.
        
        // Compute ceiling value
        double numCeil;
        if (fractionalPart > 0) {
            numCeil = (int) num + 1; // Add 1 to the integer part for positive numbers with a fractional part
        } else {
            numCeil = (int) num; // For exact integers or negative numbers, no adjustment is needed
        }

       //Explanation Floor Value:

        //Positive Numbers:
        //If the number is positive (e.g., 5.6), the floor is just the integer part.
        
        //Exact Integers:
        //If the number is already an integer (e.g., 5.0), the floor remains 5.

        //Negative Numbers:
        //For negative numbers (e.g., −3.6), the floor is −3−1=−4 because −4 is the largest integer less than −3.6.
       
        // Compute floor value
        double numFloor;
        if (fractionalPart < 0) {
            numFloor = (int) num - 1; // Subtract 1 for negative numbers with a fractional part
        } else {
            numFloor = (int) num;  // For positive numbers or exact integers, no adjustment is needed
        }

        // Convert to integer value
        int numInteger = (int) num;

        // Display results
        System.out.println("\nUsing Inbuilt Functions -->");
        System.out.println("\nFor num = " + num + "-->");
        System.out.println("Rounded value: " + Math.round(num));
        System.out.println("Ceil value: " + Math.ceil(num));
        System.out.println("Floor value: " + Math.floor(num));
        
        // Display results
        System.out.println("\nUsing User Created Methods -->");
        System.out.println("\nFor num = " + num + "-->");
        System.out.println("Rounded value: " + numRound);
        System.out.println("Ceil value: " + numCeil);
        System.out.println("Floor value: " + numFloor);
        System.out.println("Integer value: " + numInteger);

        scanner.close(); // Close the scanner
    }
}