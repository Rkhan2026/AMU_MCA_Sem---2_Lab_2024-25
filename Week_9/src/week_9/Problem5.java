package week_9;

import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
     String accountHolder;
     double balance;
     double interestRate = 0.05;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
       balance = balance + amount;
       System.out.println("Deposit successful. New balance: " + balance);       
    }

    public void withdraw(double amount) {
       
       balance = balance - amount;
       System.out.println("Withdrawal successful. New balance: " + balance);
       
    }

    public double getBalance() {
        return balance;
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        
        String name = scanner.nextLine();

        double initialBalance = 0;

        while(true) {
          System.out.print("Enter initial deposit amount: ");
          double bl = scanner.nextDouble();        
          if (bl>0) {
            initialBalance = bl; break;
          }
          else System.out.println("Enter Positive Value");        
        } 
               
        BankAccount account = new BankAccount(name, initialBalance);

        System.out.println("Account created for " + name + " with balance: " + initialBalance);

         boolean exit = false;
           
         while (!exit) {
                System.out.println("\nChoose an operation: ");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            
                            if (depositAmount>0) account.deposit(depositAmount);
                            else System.out.println("Enter Positive Value");
                        } catch (InputMismatchException e) {
                            System.out.println("InputMismatchException : Invalid input! Please enter a valid number.");
                            scanner.next();
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = scanner.nextDouble();

                            if (withdrawAmount<account.getBalance()) account.withdraw(withdrawAmount);
                             else System.out.println("Enter amount less than current balance");
                        } catch (InputMismatchException e) {
                            System.out.println("InputMismatchException : Invalid input! Please enter a valid number.");
                            scanner.next();
                        }
                        break;

                    case 3:
                        System.out.println("\nCurrent balance: " + account.getBalance());
                        break;

                    case 4:
                       return;

                    default:
                        System.out.println("\nPlease enter a number between 1 and 4.");
                }
            }
        } 
}