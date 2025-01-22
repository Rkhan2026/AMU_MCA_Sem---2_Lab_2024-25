import java.util.Scanner;
public class Problem3 {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Digit till where you wish to find the sum of the reciprocals: ");
	int n=sc.nextInt();
        double Sum = 0;
	for(int i=1; i<=n; i++)
	{
            Sum = Sum + (1/(double)i);
	}
	System.out.println("\nSum of reciprocal series 1/1 +1/2 +...+1/n where n is "+n+" then : "+Sum);
    }
}