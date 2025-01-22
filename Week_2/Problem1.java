import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
		System.out.println("Enter how many numbers in total : ");
                int n =s.nextInt();
		int [] arr = new int[n];
		int CountEven = 0, CountOdd = 0;
                System.out.println("Enter the numbers : ");
		for(int i = 0; i<n; i++)
		{
			arr[i] = s.nextInt();
			if(arr[i]%2==0) CountEven++;
			else CountOdd++;
		}
		System.out.println("\nCount Of Even Numbers : "+CountEven);
		System.out.println("\nCount Of Odd Numbers : "+CountOdd);
    }
}
