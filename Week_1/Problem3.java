import java.util.Scanner;
public class Problem3 {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
	System.out.println("Enter How Many Fahrenheit Numbers To Convert : ");
	
	int n = sc.nextInt();
	
      double [] f_arr = new double[n];         
      for(int i = 0; i<n; i++)
		{
			System.out.println("\nEnter Temperature In Fahrenheit: ");  
			f_arr[i] = sc.nextDouble();
		}
      double [] c_arr = new double[n];         
      for(int i = 0; i<n; i++)
		{
			double ctemp = ((f_arr[i] - 32) / 1.8);  
       			double Ctemp= Math.round(ctemp*100)/100D;     
			
			c_arr[i] = Ctemp;
		}
       
        System.out.println("\nThe Given Temperatures From Fahrenheit To Celsius Are In Below Table --> ");
  	
	System.out.printf(" -------------------------%n");
	
	System.out.printf(" | %-10s | %-8s |%n", "Fahrenheit", "Celsius");
	System.out.printf(" -------------------------%n");
	for(int i = 0; i<n; i++)
		{
			System.out.printf(" | %-10s | %-8s |%n",  f_arr[i], c_arr[i]);
		}
        System.out.printf(" -------------------------%n");
             
    }
    
}