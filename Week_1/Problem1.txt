import java.util.Scanner;
public class Problem1 {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
      
       System.out.println("Enter Student Details--> ");  
       System.out.println("Enter Student Name: ");
       String name = sc.nextLine();
       
       System.out.println("Enter Student Faculty No: ");
       String fac_no = sc.nextLine();
       
       System.out.println("Enter Student Enrollment No.: ");
       String  enroll_no = sc.nextLine();
       
       System.out.println("\nEnter Student Address Details--> ");
       System.out.println("Enter Student House No. and House Name: ");
       String h_no_h_name = sc.nextLine();
       
       System.out.println("Enter Student Street Name: ");
       String street_name = sc.nextLine();
       
       System.out.println("Enter Student City Name: ");
       String city_name = sc.nextLine();
       
       System.out.println("Enter Student Pincode: ");
       String pincode = sc.nextLine();
       
       System.out.println("Enter Student State Name: ");
       String state_name = sc.nextLine();
       
       System.out.println("\nStudent Details & Address --> ");  
       
       System.out.println(""+name+", "+fac_no+", "+enroll_no);
       System.out.println(""+h_no_h_name+", "+street_name+", "+city_name+", "+pincode+", "+state_name);
    }
    
}
