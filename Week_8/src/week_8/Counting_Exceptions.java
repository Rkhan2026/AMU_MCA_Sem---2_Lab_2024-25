package week_8;

import java.io.*;

class Counting_Exceptions {
    public static void main(String[] args) {
        
        // 1. IllegalArgumentException
        try {
            int age = 16;
            if (age < 18) {
                throw new IllegalArgumentException("Age must be 18 or above!");
            } else {
                System.out.println("Valid age: " + age);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 2. IOException
        try {
            FileReader file = new FileReader("abc.txt");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 3. ArithmeticException
        try {
            int b = 0;
            int a = 10;
            if (b == 0) {
                throw new ArithmeticException("Division by zero is not allowed!");
            } else {
                System.out.println("Result: " + (a / b));
            }
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 4. NumberFormatException
        try {
            String str = "abc";
            if (!str.matches("\\d+")) { // Check if string is not numeric
                throw new NumberFormatException("Invalid number format: " + str);
            } else {
                int num = Integer.parseInt(str);
                System.out.println("Parsed number: " + num);
            }
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
