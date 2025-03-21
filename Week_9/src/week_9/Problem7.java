package week_9;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Problem7 {

    static Logger logger = LogManager.getLogger(Problem7.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter an integer for 'a': ");
            int a = sc.nextInt(); 
            
            System.out.print("Enter an integer for 'b': ");
            int b = sc.nextInt();

            System.out.println("You entered: a = " + a + ", b = " + b);
            
        } catch (InputMismatchException e) {  
            logger.error("InputMismatchException : Severe runtime exception occurred: Invalid input type. Please enter integers only.", e);
               //System.exit(0) or EXIT_SUCCESS;  ---> Success
               //System.exit(1) or EXIT_FAILURE;  ---> Exception
               //System.exit(-1) or EXIT_ERROR;   ---> Error
               System.exit(1);
        }
    }
}