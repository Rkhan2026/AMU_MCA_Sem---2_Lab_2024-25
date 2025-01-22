import java.util.Scanner;
public class Problem5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        System.out.print("Enter another number: ");
        double num2 = scanner.nextDouble();

        // Demonstrate Math class methods
        System.out.println("\nMath.abs(num): " + Math.abs(num));
	System.out.println("Math.abs(num2): " + Math.abs(num2));

        System.out.println("Math.ceil(num): " + Math.ceil(num));
	System.out.println("Math.ceil(num2): " + Math.ceil(num2));

        System.out.println("Math.floor(num): " + Math.floor(num));
	System.out.println("Math.floor(num2): " + Math.floor(num2));

        System.out.println("Math.round(num): " + Math.round(num));
	System.out.println("Math.round(num2): " + Math.round(num2));


        System.out.println("Math.max(num, num2): " + Math.max(num, num2));
        System.out.println("Math.min(num, num2): " + Math.min(num, num2));

        System.out.println("Math.sqrt(num): " + Math.sqrt(num));
 	System.out.println("Math.sqrt(num2): " + Math.sqrt(num2));
        
	System.out.println("Math.pow(num, num2): " + Math.pow(num, num2));

        System.out.println("Math.exp(num): " + Math.exp(num));
	System.out.println("Math.exp(num2): " + Math.exp(num2));

        System.out.println("Math.log(num): " + Math.log(num));
	System.out.println("Math.log(num2): " + Math.log(num2));

        System.out.println("Math.log10(num): " + Math.log10(num));
	System.out.println("Math.log10(num2): " + Math.log10(num2));


        System.out.println("Math.sin(num): " + Math.sin(num));
	System.out.println("Math.sin(num2): " + Math.sin(num2));

        System.out.println("Math.cos(num): " + Math.cos(num));
	System.out.println("Math.cos(num2): " + Math.cos(num2));

        System.out.println("Math.tan(num): " + Math.tan(num));
	System.out.println("Math.tan(num2): " + Math.tan(num2));

        System.out.println("Math.toDegrees(num): " + Math.toDegrees(num));
	System.out.println("Math.toDegrees(num2): " + Math.toDegrees(num2));

        System.out.println("Math.toRadians(num): " + Math.toRadians(num));
	System.out.println("Math.toRadians(num2): " + Math.toRadians(num2));

        System.out.println("Math.cbrt(num): " + Math.cbrt(num));
 	System.out.println("Math.cbrt(num2): " + Math.cbrt(num2));

        System.out.println("Math.signum(num): " + Math.signum(num));
	System.out.println("Math.signum(num2): " + Math.signum(num2));

        System.out.println("Math.hypot(num, num2): " + Math.hypot(num, num2));

    }
    
}