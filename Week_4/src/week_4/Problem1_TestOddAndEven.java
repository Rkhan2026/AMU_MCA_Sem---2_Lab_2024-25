package week_4;
import java.util.Scanner;

class OddAndEven {
     int countOfOdd;
     int countOfEven;    

    public void addNumber(int number) {
        if (number % 2 == 0) {
            countOfEven++;
        } else if ( number % 2 !=0 ){
            countOfOdd++;
        }
    }

    public String toString() {
        return "Number of Odd: " + countOfOdd + ", Number of Even: " + countOfEven;
    }
}

public class Problem1_TestOddAndEven {
    public static void main(String[] args) {
        OddAndEven oddAndEvenCounter = new OddAndEven();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers or type 'Q' or 'q' to quit -->");
        while (true) {
            String input = scanner.next();         
            if (input.equals("Q") || input.equals("q")) {
                break;
            }           
                int number = Integer.parseInt(input);
                oddAndEvenCounter.addNumber(number);            
        }
               
        System.out.println(oddAndEvenCounter.toString());
    }
}