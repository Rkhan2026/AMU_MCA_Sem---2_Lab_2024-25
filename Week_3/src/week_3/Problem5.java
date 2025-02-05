package week_3;
import java.util.Scanner;

class Coordinate {
    double bottomLeftX, bottomLeftY, topRightX, topRightY;

    Coordinate(double bottomLeftX, double bottomLeftY, double topRightX, double topRightY) {
        //since user can enter the coordiantes in any manner 
        //so we calculate the correct coordiantes of all values
        //to get a consistent coordiantes of bottom left and top right
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

};

class Rectangle extends Coordinate{
    
    Rectangle(double bottomLeftX, double bottomLeftY, double topRightX, double topRightY) {
        super(bottomLeftX, bottomLeftY, topRightX, topRightY);
    }

     Rectangle intersection(Rectangle r2) {               
                 
         //Checking if a rectangle is inside another:
            //If r1 rectangle is inside r2, return null.
            //                    or
            //If r2 is inside r1 rectangle, return null.
         //this can also check if even one rectangle is inside the other and it is touching 
         //the other rectangle without forming overlap then it still returns null
        if ((this.bottomLeftX >= r2.bottomLeftX && this.topRightX <= r2.topRightX &&
             this.bottomLeftY >= r2.bottomLeftY && this.topRightY <= r2.topRightY) 
                ||
            (r2.bottomLeftX >= this.bottomLeftX && r2.topRightX <= this.topRightX &&
             r2.bottomLeftY >= this.bottomLeftY && r2.topRightY <= this.topRightY)) {
            return null;
        }
                                              
        // this.topRightX <= r2.bottomLeftX:
        //         This checks if the first rectangle is completely to the left of the second rectangle.
         
        //this.bottomLeftX >= r2.topRightX:
        //          This checks if the first rectangle is completely to the right of the second rectangle 
         
        //this.topRightY <= r2.bottomLeftY:
        //         This checks if the first rectangle is completely below the second rectangle.
 
        //this.bottomLeftY >= r2.topRightY:
        //        This checks if the first rectangle is completely above the second rectangle.
             
        else if (this.topRightX <= r2.bottomLeftX || this.bottomLeftX >= r2.topRightX ||
             this.topRightY <= r2.bottomLeftY ||  this.bottomLeftY >= r2.topRightY) {
            return null;
        }
    
        else {
            double interLeftBottomX = Math.max (this.bottomLeftX, r2.bottomLeftX);
            double interLeftBottomY = Math.max (this.bottomLeftY, r2.bottomLeftY);
            double interRightTopX = Math.min (this.topRightX, r2.topRightX);
            double interRightTopY = Math.min (this.topRightY, r2.topRightY);
      
            return new Rectangle(interLeftBottomX, interLeftBottomY, interRightTopX, interRightTopY );
        }           
    }
    public void print() {
        System.out.println("Bottom-Left (" + bottomLeftX + ", " + bottomLeftY + ") to Top-Right (" + topRightX + ", " + topRightY + ")");
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter coordinates for Rectangle 1 (x1, y1 are Bottom Left Corrdinates and x2, y2 are top right coordinates):");
        double x1 = scanner.nextInt(), y1 = scanner.nextInt();
        double x2 = scanner.nextInt(), y2 = scanner.nextInt();
        Rectangle r1 = new Rectangle(x1, y1, x2, y2);

        System.out.println("Enter coordinates for Rectangle 2 (x3, y2 are Bottom Left Corrdinates and x4, y4 are top right coordinates):");
        double x3 = scanner.nextInt(), y3 = scanner.nextInt();
        double x4 = scanner.nextInt(), y4 = scanner.nextInt();
        Rectangle r2 = new Rectangle(x3, y3, x4, y4);

        Rectangle r3 = r1.intersection(r2);

        System.out.println("\nRectangle 1:"); r1.print();
        System.out.println("\nRectangle 2:"); r2.print();

        if (r3 != null) {
            System.out.println("\nIntersection Rectangle Coordinates -->");r3.print();
        } else {
            System.out.println("\nNo Overlapping Rectangle");
        }
        scanner.close();
    }
}