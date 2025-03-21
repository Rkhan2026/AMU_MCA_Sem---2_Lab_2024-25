package week_9;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Problem3 {

    static Logger logger = LogManager.getLogger(Problem3.class);

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a: ");
            int a = sc.nextInt();
            
            System.out.print("Enter b: ");
            int b = sc.nextInt();
            
            int result = a/b;
            
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {             
            logger.error("ArithmeticException Occured:Division by Zero ", e);
        }            
    }
}