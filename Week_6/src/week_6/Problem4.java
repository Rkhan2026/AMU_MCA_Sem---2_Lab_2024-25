package week_6;
import java.util.Scanner;

// Shape - The base class for all shapes
class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }
    
    public void displayCircle() {
        System.out.println("\nShape: " + name);
    }
    
    public void displayRectangle() {
        System.out.println("\nShape: " + name);
    }   
}

// ShapeOperations - The interface defining common methods for all shapes
interface ShapeOperations {
    double calculateArea();
    double calculatePerimeter();
}

class Circle extends Shape implements ShapeOperations {
    double radius;

    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;  
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;  
    }
}

class Rectangle extends Shape implements ShapeOperations {
    double length; double width;

    Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;  
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);  
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the radius of the Circle: ");
        double circleRadius = scanner.nextDouble();
        Circle circle = new Circle(circleRadius);  


        System.out.print("\nEnter the length of the Rectangle: ");
        double rectangleLength = scanner.nextDouble();
        System.out.print("Enter the width of the Rectangle: ");
        double rectangleWidth = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);  

        circle.displayCircle();
        System.out.println("\n"+ " - Area: " + circle.calculateArea() + ", Perimeter: " + circle.calculatePerimeter());
        
        rectangle.displayRectangle();
        System.out.println("\n" + " - Area: " + rectangle.calculateArea() + ", Perimeter: " + rectangle.calculatePerimeter());        
    }
}