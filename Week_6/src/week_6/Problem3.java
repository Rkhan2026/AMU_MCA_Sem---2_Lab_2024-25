package week_6;
import java.util.Scanner;

public class Problem3 {
    
    //Method to compare two strings character by character
    //static means that the method belongs to the Main class and not an object of the Main class.
    
    //The compareStrings method is declared static so that it can be called directly from the main method 
    //without needing to create an object of the Problem3 class. If it were non-static, you would have to create an instance
    
    static int compareStrings(String str1, String str2) {
        int i = 0;
        // Compare each character of both strings until one ends or mismatch occurs
        while (i < str1.length() && i < str2.length()) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            //Return the difference if characters are not equal
            //This difference determines the lexicographic order:
                //1. A negative value means str1 is smaller.
               // 2. A positive value means str2 is smaller.
               // 3. A zero value means the characters are equal.
            if (c1 != c2) {
                return c1 - c2;
            }
            i++;
        }
         // If all characters are the same, compare lengths-->
        //If the loop completes without returning, it means all checked characters were equal.
             //The method then returns the difference in their lengths:
             //If str1 is shorter, it returns a negative value.
             //If str1 is longer, it returns a positive value.
             //If they have the same length, it returns 0.
        return str1.length() - str2.length();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read three strings from the user
        System.out.println("Enter first string:");
        String str1 = scanner.nextLine();

        System.out.println("Enter second string:");
        String str2 = scanner.nextLine();

        System.out.println("Enter third string:");
        String str3 = scanner.nextLine();

        // Sorting logic without using any inbuilt sorting or comparison methods
        String temp;

        // Compare and swap str1 and str2 if needed
        // If str1 comes after str2 lexicographically, swap them
        if (compareStrings(str1, str2) > 0) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // Compare and swap str2 and str3 if needed
         // If str2 comes after str3 lexicographically, swap them
        if (compareStrings(str2, str3) > 0) {
            temp = str2;
            str2 = str3;
            str3 = temp;
        }

        // Compare and swap str1 and str2 again if needed after the second swap
        // Ensures that str1 and str2 are in correct order
        if (compareStrings(str1, str2) > 0) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // Print the sorted strings
        System.out.println("\nSorted Strings --> ");
        System.out.println("" + str1 + " " + str2 + " " + str3);
   
        scanner.close();
    }  
}