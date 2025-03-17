package week_8;
import java.util.Scanner;

public class Problem2_NullPointerExceptionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        System.out.println("\nExample A: ");
        A(scanner);
        System.out.println("\nExample B:");
        B(scanner);
        System.out.println("\nExample C: ");
        C(scanner);
    }
    /*
     * Method A demonstrates the creation and assignment of a Customer object to a BankAccount.
     * Approach:
     * - A Customer object is created based on user input (`y` for yes).
     * - The fill_Bank_Account() method is used to assign the Customer object to the BankAccount.
     * - Finally, accountDetails() is called to print the account holders name.
     * Logic Explanation:
     * - The program starts by creating a BankAccount object.
     * - The Customer object is created based on user input.
     * - If the user enters "y", a Customer instance is created and assigned to BankAccount.
     * - If "n" or any other input is given, accountDetails() tries to access an uninitialized Customer, causing a NullPointerException.
     */
    static void A(Scanner scanner) {
        
        class Customer {
            String name;

            Customer(String name) {
                this.name = name;
            }
        }

        class BankAccount {
            String accountNumber;
            Customer customer;
            
            void fill_Bank_Account(Customer c){
                   customer = c;
            }

            void accountDetails() {
                System.out.println("Account Holder: " + customer.name);
            }
        }

        BankAccount account = new BankAccount();
        Customer customer;

         try {
                System.out.println("\nEnter y to create account: ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    customer = new Customer("Mohd Shadab Khan");
                    account.fill_Bank_Account(customer);
                }

                account.accountDetails();
             
         } catch(NullPointerException e){
              System.out.println("\nError: NullPointerException Occurred");
              System.out.println("Reason: No customer was assigned to the bank account.");
              System.out.println("Exception Details: " + e);
         }       
    }
    /*
     * Method B demonstrates the creation and assignment of a VitalSigns object to a Patient.
     * Approach:
     * - A Patient object is created with a name.
     * - The VitalSigns object is created based on user input (`y` for yes).
     * - The fill_vital_signs() method is used to assign the VitalSigns object to the Patient.
     * - Finally, showPatientInfo() is called to display the patient's name and vitals.
     * Logic Explanation:
     * - The program starts by creating a Patient object.
     * - The VitalSigns object is created only if the user enters "y".
     * - If the user chooses "y", a VitalSigns instance is created and assigned to the Patient.
     * - If the user chooses "n" or any other input, showPatientInfo() attempts to access vitals.displayVitals(), leading to a NullPointerException.
     */
    static void B (Scanner scanner) {
        class VitalSigns {
            int heartRate;
            double temperature;

           VitalSigns(int heartRate, double temperature) {
                 this.heartRate = heartRate;
                 this.temperature = temperature;
            }

           void displayVitals() {
                System.out.println("Heart Rate: " + heartRate + " bpm");
                System.out.println("Temperature: " + temperature + " °C");
            }
        }

        class Patient {
            String name;
            VitalSigns vitals; 

            Patient(String name) {
                this.name = name;
            }

            public void fill_vital_signs(VitalSigns v){
                vitals = v;
            }
            
           void showPatientInfo() {
                System.out.println("Patient Name: " + name);
                System.out.println("Vital Signs:");
                vitals.displayVitals();
            }
        }
            
        Patient patient = new Patient("Saim");
        VitalSigns vitals;

        try {
                System.out.println("\nEnter y to record vitals: ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    vitals = new VitalSigns(80, 36.5); 
                    patient.fill_vital_signs(vitals);
                }

                patient.showPatientInfo();
        } catch(NullPointerException e){
              System.out.println("\nError: NullPointerException Occurred!");
              System.out.println("Reason: No vital signs were assigned to the patient.");
              System.out.println("Exception Details: " + e);
        }     
    }     
    /*
     * Method C demonstrates the creation and assignment of an array of Order objects.
     * Approach:
     * - A fixed-size array of Order objects is declared but remains `null` initially.
     * - The array is initialized based on user input (`y` for yes).
     * - If "y" is entered, the three Order objects are assigned to the array.
     * - A loop iterates over the array to print order details using `showOrder()`.
     * Logic Explanation:
     * - The program begins by creating an Order array of size 3, but it only holds null references initially.
     * - The user is prompted to decide whether to initialize the array.
     * - If the user enters "y", all three indexes of the array are assigned Order objects.
     * - If the user enters "n" or any other input, the array remains filled with null, leading to a NullPointerException when calling showOrder().
     * 
     */    
     static void C (Scanner scanner) {
                 
        class Order {
            String orderId;

           Order(String orderId) {
                 this.orderId = orderId;
            }

            void showOrder() {
                System.out.println("Order ID: " + orderId);
            }
        }

          Order[] orders = new Order[3];
          
          try{
              
                System.out.println("\nEnter y to initialize order array: ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    orders[0] = new Order("ORD123");
                    orders[1] = new Order("ORD456");
                    orders[2] = new Order("ORD789");
                }

                System.out.println("Orders: ");
         
                for (int i=0;i<3;i++) {
                    orders[i].showOrder(); 
                }
          
          } catch (NullPointerException e){
               System.out.println("\nError: NullPointerException Occurred!");
               System.out.println("Reason: Order at indexs 0 to 2 were not initialized.");
               System.out.println("Exception Details: " + e);
          
          }
     }
}