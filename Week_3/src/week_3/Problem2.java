package week_3;
import java.util.Scanner;
public class Problem2 {

    public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
		int arr[]=new int[3];
		for(int i=0; i<3; i++)
		{
			System.out.println("Enter Digit "+(i+1)+" : ");
			arr[i] = s.nextInt();
                        
                        // Check if the input is within the valid range
                         while (arr[i] < 0 || arr[i] > 9) {
                            System.out.print("Invalid input! Please enter a digit between 0 and 9: ");
                            arr[i] = s.nextInt();
                         }                            
		}
		System.out.println("\nAll Posible Combinations Are : ");
                // Outer loop iterates through the first element of the combination
		for(int i=0; i<3; i++) {
                    // Middle loop iterates through the second element of the combination
                     for(int j=0; j<3; j++)
                    {
                        // Inner loop iterates through the third element of the combination
                        for(int k=0;k<3;k++){
                             // The condition ensures that no two elements in the combination are the same, 
                            //guaranteeing all elements are unique.
                            if(arr[i]!=arr[j]&&arr[j]!=arr[k]&&arr[k]!=arr[i])
					System.out.print(arr[i]+""+arr[j]+""+arr[k]+", ");
                        }                
                    }
                }		
		s.close();
    }
    
}