package week_3;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("\nEnter a four-digit number: ");
            n = s.nextInt();
            if (n >= 1000 && n <= 9999) {
                break;
            } else {
                System.out.println("\nInvalid input! Please enter a valid four-digit number.");
            }
        }
        int rev = 0, lastD; int even_count = 0; int odd_count = 0;
        while (n != 0) {
            lastD = n % 10;

            if (lastD % 2 == 0) {
                even_count++;
            } else {
                odd_count++;
            }

            rev = (rev * 10) + lastD;
            n /= 10;
        }
        System.out.println("\nDigits -->");
        while (rev != 0) {
            lastD = rev % 10;
            System.out.println(lastD);
            rev /= 10;
        }
        System.out.println("\nNumber of Even Digits: " + even_count);
        System.out.println("Number of Odd Digits: " + odd_count);
        s.close();
    }
}