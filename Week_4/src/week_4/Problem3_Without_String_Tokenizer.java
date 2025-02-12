package week_4;
import java.util.Scanner;

public class Problem3_Without_String_Tokenizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     
        System.out.println("Enter the text:");
        String text = scanner.nextLine();
    
        int wordCount = 0;
        int sentenceCount = 0;
        int letterECount = 0;
        int letterZCount = 0;

        // Flag to track if we're in the middle of a word
        boolean inWord = false;        
        
        // Flag to track if we're in the middle of a sentecne
        boolean inSentence = false; 
               
        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            //Count words: A word starts when a sentence ending character is not the first character of the word
            //and we do !inWord becuase otherwise one word will be counted more than once as each non sentence ending character 
            //will execute the if condition
            
            //here we took precaution for all sentence ending charcters becuase whenever there was a space which was followd 
            //by a sentence ending charcater then becuase of the space char the else if condition was executed where inWord became 
            //false and then the next char which is sentence ending char was not equal to space char as in old if conditon 
            // ( if ( (currentChar != ' ') && !inWord) then the word count was incremented wrongly. hence why we took condition for all 
            // sentence endong characters to be false to prevent  the wrong word icnrement
            
            //we took 'and &&' between all cases becuase of 'or || ' was used then since the other conditions 
            //such as currentChar!=' ' would also be true if currentchar was '.' becuase since cuurentChar!='.' would be false
            //even one true makes entire expression true and since inWord is already false then if codnition would execute and 
            //word is wrongly incremented. by taking && we ensure that entire expression si false then false && true becoems false 
            //thereby not executing the wrong word increment
            
            if ( (currentChar != ' ' && currentChar != '.' && currentChar != '!' && currentChar != '?') && !inWord ) {
                wordCount++; // Increment word count when a new word starts
                inWord = true; // Set flag to indicate we are in a word                 
                inSentence = true; //Set flag to indicate we are in a sentence sicne a sentence needs at least one word
            } else if (currentChar == ' ') {
                inWord = false; // Reset inWord flag when we encounter a space                                           
            }
                      
            // Count sentences only if there was at least one word in the sentence
            if ((currentChar == '.' || currentChar == '!' || currentChar == '?') && inSentence) {
                sentenceCount++;
                inSentence = false; // Reset sentence flag to prevent counting multiple consecutive sentence ending character marks
            }
                      
            // Count occurrences of the letter 'e' and 'z'
            if (currentChar == 'e' || currentChar == 'E') {
                letterECount++;
            } else if (currentChar == 'z' || currentChar == 'Z') {
                letterZCount++;
            }
        }
     
        System.out.println("\nNumber of words: " + wordCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Number of times the letter 'e' occurs: " + letterECount);
        System.out.println("Number of times the letter 'z' occurs: " + letterZCount);
    }
}