package week_8;

import java.util.Scanner;

class SampleClass {
    void displayMessage() {
        System.out.println("Hello World");
    }
}

public class Problem2_NullPointerExceptionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nExample A: Null Object Method Access");
        handleNullObjectMethodAccess(scanner);
        
        System.out.println("\nExample B: Null Object in an Array");
        handleNullObjectInArray(scanner);
        
        System.out.println("\nExample C: Null Object in Object Reference Swap");
        handleNullObjectInObjectReferenceSwap(scanner);
    }

    // Example A: Handling method call on a potentially null object
    // Approach: Allow user input to decide whether to instantiate the object
    // Logic: If the user enters 'yes', a new SampleClass object is created; otherwise, it remains null.
    // Using a try-catch block to handle NullPointerException if obj is null.
    static void handleNullObjectMethodAccess(Scanner scanner) {
        System.out.print("Enter 'yes' to create object, anything else to keep it null: ");
        String input = scanner.nextLine();
        SampleClass obj = input.equalsIgnoreCase("yes") ? new SampleClass() : null;

        try {
            obj.displayMessage();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to call a method on a null object.");
        }
    }

    // Example B: Handling potential null values inside an array
    // Approach: User decides the array size and which elements should be initialized
    // Logic: If the user inputs 'yes', a new object is assigned to the array element; otherwise, it remains null.
    // A try-catch block is used to prevent NullPointerException when accessing an uninitialized array element.
    static void handleNullObjectInArray(Scanner scanner) {
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        SampleClass[] objects = new SampleClass[size];
        
        for (int i = 0; i < size; i++) {
            System.out.print("Enter 'yes' to initialize element " + i + ", anything else to keep it null: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                objects[i] = new SampleClass();
            }
        }
        
        System.out.print("Enter index to access (0 to " + (size - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        try {
            objects[index].displayMessage();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to access a method on a null object inside an array.");
        }
    }

    // Example C: Handling object reference swapping when one reference is null
    // Approach: Initially, obj1 is assigned a valid object, while obj2 is null
    // Logic: If the user chooses to swap, obj1 and obj2 references are exchanged
    // This may result in obj1 becoming null, which is handled using a try-catch block
    static void handleNullObjectInObjectReferenceSwap(Scanner scanner) {
        SampleClass obj1 = new SampleClass();
        SampleClass obj2 = null;
        
        System.out.println("Before swap: obj1 is initialized, obj2 is null.");
        System.out.print("Enter 'swap' to exchange references: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("swap")) {
            SampleClass temp = obj1;
            obj1 = obj2;
            obj2 = temp;
        }
        
        try {
            obj1.displayMessage();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to call a method on a swapped null object.");
        }
    }
}