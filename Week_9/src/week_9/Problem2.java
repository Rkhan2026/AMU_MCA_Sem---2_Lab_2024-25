package week_9;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter a: ");
            int a = sc.nextInt();
            
            System.out.println("Enter b: ");
            int b = sc.nextInt();
            
            int result = a/b;
            
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) { 
            System.out.println("Arithmetic Exception ==>  Division by zero is not allowed.");
        }
    }
}