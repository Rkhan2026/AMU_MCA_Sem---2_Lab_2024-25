package week_6;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine(); 

        // Temporary array to store the characters of the current word
        char[] word = new char[sentence.length()];
        int wordIndex = 0;  // To keep track of the position in the word array
        
        // Variable to store the final reversed sentence
        String rev_str = "";

        // Loop through each character of the sentence
        //we go till  i<=sentence.length() to deal with last word
        for (int i = 0; i <=sentence.length(); i++) {
            
            // Check if the current character is or the end of the sentence or a space, punctuation.
            
            //i == sentence.length() ensures that the last remaining word (if there's no punctuation or space at the end of the sentence) 
            //is processed and reversed correctly.
            //It prevents going beyond the end of the string, avoiding errors
            if (i == sentence.length() || sentence.charAt(i) == ' ' || sentence.charAt(i) == '.' || sentence.charAt(i) == ',' || sentence.charAt(i) == '!' || sentence.charAt(i) == '?' || sentence.charAt(i) == ';' || sentence.charAt(i) == ':') {
                
                // Reverse the current word and add it to the result array
                for (int j = wordIndex - 1; j >= 0; j--) {
                    rev_str = rev_str + word[j];  // Add each character of the word in reverse order                    
                }

                //If the current character is space, punctuation, append it after the reversed word
                
                //i < sentence.length() ensures that loop or condition checks only valid string index, 
                //avoiding errors when accessing characters in the string becuase we have i<=sentence.length() && .charAt punctuations. 
                //so whole thing needs to be true as there is && (logical and) between them
                if (i < sentence.length() && (sentence.charAt(i) == ' ' || sentence.charAt(i) == '.' || sentence.charAt(i) == ',' || sentence.charAt(i) == '!' || sentence.charAt(i) == '?' || sentence.charAt(i) == ';' || sentence.charAt(i) == ':') ) {
                   rev_str = rev_str + sentence.charAt(i);  // Add the punctuation mark                    
                }
                
                // Reset the word index for the next word
                wordIndex = 0;
            } else {
                // Add the current character to the word array if it's part of a word i.e. the char is not a space or punctuation.               
                word[wordIndex] = sentence.charAt(i);
                wordIndex++;
            }
        }  
        System.out.println("\nReversed Sentence: " + rev_str);
    }
}