import java.util.Scanner;
public class Problem4 {

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
		System.out.println("Enter number of terms : ");
		int term = s.nextInt();
		int Sum = 0;
		int N=0;
		for(int i=1; i<=term; i++)
		{
			N=(2*i);	
			Sum = Sum + N; 
		}
		System.out.println("Sum Of Series 2+4+6+-----N Where N Will Be "+N+" Is : "+Sum);
		s.close();
    }
    
}
