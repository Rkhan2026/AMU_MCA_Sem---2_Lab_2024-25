package week_4;
import java.util.Scanner;

class Commission {
    double sale;

    Commission(double sale) {
        this.sale = sale;
    }

    void commission() {
        if (sale < 500) System.out.print(" " + 0.02 * sale);   // 2% commission for sales under 500
        
        else if (sale >=500 && sale<5000) System.out.print(" " +  0.05 * sale);  // 5% commission for sales between 500 and 5000
        
        else if (sale>=5000) System.out.print(" " + 0.08 * sale); // 8% commission for sales 5000 and above   
               
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("\nEnter the sale amount or enter negative sale to quit program: ");
            double sale = scanner.nextDouble();        
            if (sale < 0) {
                System.out.println("\nInvalid Input");
                continue;
            }         
           
            Commission commissionObj = new Commission(sale);           
            commissionObj.commission();                                                        
        }       
    }
}