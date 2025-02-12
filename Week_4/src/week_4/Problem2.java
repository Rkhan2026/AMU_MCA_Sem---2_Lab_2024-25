package week_4;
import java.util.Scanner;

class Circle {
    double radius;
    double centerX;
    double centerY;

    Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    double computeArea() {
        return Math.PI * radius * radius;
    }

    double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    void isPointInsideCircle(double x, double y) {
        double distance = Math.sqrt((x - centerX)*(x - centerX) + (y - centerY)*(y - centerY));       
        //point is inside the circle if distance < radius
        //point is on the circle if distance = radius
        //point is outside the circle if distance > radius           
        if (distance < radius) System.out.println("\nGiven Points Lie Inside the Circle.");
        else if (distance == radius) System.out.println("\nGiven Points Lie On the Circle.");    
        else if (distance > radius) System.out.println("\nGiven Points Lie Outside the Circle.");          
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        while (true) {
            System.out.print("Enter the radius of the circle or enter negative radius for exiting the program --> ");          
            while (true) {
                System.out.print("\nEnter the radius: ");  
                double radius = scanner.nextDouble();
                
                if (radius < 0) {
                    System.out.println("Exit the program since negative radius entered.");
                    break;
                }

                System.out.print("\nEnter the x-coordinate of the center: ");
                double centerX = scanner.nextDouble();

                System.out.print("Enter the y-coordinate of the center: ");
                double centerY = scanner.nextDouble();

                Circle circle = new Circle(radius, centerX, centerY);

                System.out.println("\nCircle Information -->");
                System.out.println("Area : " + circle.computeArea());
                System.out.println("Perimeter : " + circle.computePerimeter());

                System.out.print("\nEnter a point's x-coordinate: ");
                double pointX = scanner.nextDouble();

                System.out.print("Enter a point's y-coordinate: ");
                double pointY = scanner.nextDouble();

                circle.isPointInsideCircle(pointX, pointY);              
            }           
        }     
    }
}