import java.util.Scanner;

public class Problem5 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		System.out.println("Enter number of Rows : ");
		int n = s.nextInt();
		
                System.out.println("\n(i) Floyd's Triangle --> ");
                int a = 1;
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(a+" ");
				a++;
			}
			System.out.println();
		}
                
                System.out.println("\n(ii) Modified Floyd's Triangle --> ");
                for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{	
				//Since in modified floyds triangle, the elements at odd position
				//in odd row will be 1 and the elements at even position will be 0.

				if (i%2!=0){
					if(j%2!=0) System.out.print(1+" ");
					else System.out.print(0+" ");
				}
				//Since in modified floyds triangle, the elements at odd position
				//in even row will be 0 and the elements at even position will be 1.

				else if (i%2==0){
					if(j%2!=0) System.out.print(0+" ");
					else System.out.print(1+" ");
				}
				
			}
			System.out.println();
		}
		s.close();
    }
    
}