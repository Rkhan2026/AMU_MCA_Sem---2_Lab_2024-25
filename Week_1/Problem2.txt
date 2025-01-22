import java.util.Scanner;
public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter First Number:");
        int num1=sc.nextInt();
        System.out.println("Enter Second Number:");
        int num2=sc.nextInt();
            
        int sum = num1+num2;
        System.out.println("\nSum: "+sum);
        
        int diff = num1-num2;
        System.out.println("Difference: "+diff);
        
        int product = num1*num2;
        System.out.println("Product: "+product);
        
        int quotient = num1/num2;
        System.out.println("Quotient: "+quotient);
        
        int min; int max;
	if (num1<num2) {
		min = num1;
 		System.out.println("Minimum Value Is: "+min);
	}
	else if (num2<num1) {
		min = num2;
 		System.out.println("Minimum Value Is: "+min);
	}
	else if (num1==num2){
 		System.out.println("Both Numbers Are Same");
	}

      	if (num1>num2) {
		max = num1;
 		System.out.println("Maximum Value Is: "+max);
	}
	else if (num2>num1) {
		max = num2;
 		System.out.println("Maximum Value Is: "+max);
	}
	else if (num1==num2){
 		System.out.println("Both Numbers Are Same");
	}
       
    } 
}