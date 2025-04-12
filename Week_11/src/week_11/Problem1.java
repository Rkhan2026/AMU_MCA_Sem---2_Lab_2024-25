package week_11;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Different scenarios below:
        
        // 1 - Triggers NullPointerException
        // String inputDate = null;         
        // String format = "yyyy-MM-dd";
        //       Or
        // String inputDate = "31-03-2025";                      
        // String format = null;            
        //        Or
        // String inputDate = null;                      
        // String format = null;  
         
     
         // 2 - Triggers IllegalArgumentException
        // String inputDate = "2025-03-31";    // Valid date
        // String format = "invalid-pattern for date like giberish";   

        
        // 3 - Triggers ParseException
        // String inputDate = "31-03-2025";               
        // String format = "yyyy-MM-dd";

        System.out.print("Enter date string: ");
        String inputDate = scanner.nextLine();
        if (inputDate.trim().isEmpty()) inputDate = null;

        System.out.print("Enter date format (e.g. yyyy-MM-dd): ");
        String format = scanner.nextLine();
        if (format.trim().isEmpty()) format = null;

        try {
            // Creating DateFormat object and parsing inside main
            DateFormat df = new SimpleDateFormat(format);  // May throw IllegalArgumentException
            df.setLenient(false);  // Enable strict parsing

            Date parsedDate = df.parse(inputDate); // May throw NullPointerException or ParseException
            System.out.println("Parsed Date: " + parsedDate); // <-- display in same format
            
        } catch (NullPointerException e) {
            System.out.println("Unchecked Exception: NullPointerException: Date string or format cannot be - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked Exception: IllegalArgumentException: Invalid date format pattern - " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Checked Exception: ParseException: Failed to parse date - " + e.getMessage());
        }
    }
}