package week_3;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[4];
        int sum = 0; int product = 1; 

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            sum = sum + numbers[i];        
            product = product * numbers[i];     
        }
        System.out.println("\nThe sum of the numbers is: " + sum);
        System.out.println("The product of the numbers is: " + product);

        scanner.close(); 
    }
}
