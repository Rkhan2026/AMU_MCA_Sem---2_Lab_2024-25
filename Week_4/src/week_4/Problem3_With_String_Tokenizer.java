package week_4;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Problem3_With_String_Tokenizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     
        System.out.println("Enter the text:");
        String text = scanner.nextLine();
       
        // trim() --> only removes begining and ending spaces.
        //replaceAll("\\s+", " ") --> only replaces multiple spaces inside the text and not the begining and ending spaces.
        
        //regex pattern \\s+ means Match one or more consecutive whitespace characters."
        text = text.trim().replaceAll("\\s+", " ");   
        
        // Count words using StringTokenizer where punctuations are used as delimiter to prevent
        // counting them as words in countTokens.
        StringTokenizer wordTokenizer = new StringTokenizer(text, " ,.!?");
        int wordCount = wordTokenizer.countTokens();
           
              
       // Sentence Count (Only count sentences that contain words)
        StringTokenizer sentenceTokenizer = new StringTokenizer(text, ".!?");  
        
        int sentenceCount = 0;

        while (sentenceTokenizer.hasMoreTokens()) {  
        // Extract the next sentence from the text using the sentence tokenizer.
        // We use `trim()` to remove leading and trailing spaces.
        // Example: In the text `"      fjdnjkn   ioidfn i.   hello   world..,?"`
        //          Without `trim()`, the extracted sentence might contain leading spaces.
        //          With `trim()`, "   hello   world..,?" becomes "hello   world..,?".
        String sentence = sentenceTokenizer.nextToken().trim();

        // Create a new StringTokenizer to count words in the sentence.
        // Delimiters: " ,.!?"
        // This ensures that we only count actual words, ignoring punctuation.
        StringTokenizer stk = new StringTokenizer(sentence, " ,.!?");
        int tk = stk.countTokens();  // Count the number of words in the sentence
       
        // Only count the sentence if it contains at least one word.
        if (tk > 0) {
            sentenceCount++;  
        }
    }
     
        // Count occurrences of 'e' and 'z' using StringTokenizer (character by character)
        int eCount = 0, zCount = 0;
        
        StringTokenizer charTokenizer = new StringTokenizer(text, " ,.!?"); // Tokenize by space and punctuation
       
        while (charTokenizer.hasMoreTokens()) {
            String word = charTokenizer.nextToken();
            //from java StringTokenizer docs --> 
            //        If the returnDelims flag is true, then the delimiter characters are also returned as tokens. 
            //        Each delimiter is returned as a string of length one.
            StringTokenizer letterTokenizer = new StringTokenizer(word, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", true);
            
            while (letterTokenizer.hasMoreTokens()) {
                String letter = letterTokenizer.nextToken();
                if (letter.equalsIgnoreCase("e")) eCount++;
                if (letter.equalsIgnoreCase("z")) zCount++;
            }
        }

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Occurrences of 'e': " + eCount);
        System.out.println("Occurrences of 'z': " + zCount);
    }
}