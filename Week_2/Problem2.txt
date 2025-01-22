import java.util.Scanner;
public class Problem2 {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Digit Till Where You Wish To Print The Squares And Cubes Of Numbers: ");
		int n=sc.nextInt();
		System.out.println("\nThe Squares And Cubes Of Numbers 1 to "+n+" Are As follows -->");
		for(int i=1; i<=n; i++)
		{
			System.out.println("\n"+i+"-->"+i*i+"-->"+i*i*i);
		}
    }
    
}
