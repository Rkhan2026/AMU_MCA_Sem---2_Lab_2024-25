package week_11;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;

public class Problem3 {
    static final Logger logger = LogManager.getLogger(Problem3.class);

    public static void main(String[] args) {
        String inputDate, format;
        
        // Read from file using try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("date.txt"))) {
            // File expected to have 2 lines: first line = date, second line = format
            inputDate = br.readLine(); 
            format = br.readLine();

            System.out.println("Date: "+inputDate+", Format: "+format);
            parseDate(inputDate, format);

        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: File 'date.txt' not found.");
        } catch (IOException ex) {
            System.out.println("IOException occurred while reading the file.");
        } catch (NullPointerException e) {
            System.out.println("Unchecked Exception: NullPointerException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked Exception: IllegalArgumentException: Invalid date format pattern - " + e.getMessage());
        } catch (DateParsingException e) {
            System.out.println("Custom DateParsingException: " + e.getMessage());
        } finally {
            logger.info("Parsing operation complete: successful closure of the 'DateFormat' object, regardless of exception occurrence.");
        }
    }

    static void parseDate(String inputDate, String format) {
        try {
            if (inputDate == null || format == null) {
                throw new NullPointerException("NullPointerException: Date string or format not provided in input or file.");
            }
            DateFormat df = new SimpleDateFormat(format);
            df.setLenient(false);  // Strict date parsing
            Date parsedDate = df.parse(inputDate);
            System.out.println("Parsed Date: " + df.format(parsedDate)); // <-- display in same format
        } catch (ParseException e) {
            throw new DateParsingException("Custom Exception: Unable to parse date", e);
        }
    }
}