package week_10;

import java.sql.*;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*
        System.out.print("Enter Oracle Username: ");
        String user = scanner.nextLine();
        System.out.print("Enter Oracle Password: ");
        String password = scanner.nextLine();

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        */
        
        System.out.println("Retrieving Database Variables From src/config.properties....");
        String url = Config_Loader.get("DB_URL");
        String user = Config_Loader.get("DB_USERNAME");
        String password = Config_Loader.get("DB_PASSWORD");
        
        try{
           Connection con = DriverManager.getConnection(url,user,password);
           System.out.println("\nVariables Retrieved Successfully");
           
           Statement cr = con.createStatement();           
            String Create_Table = "CREATE TABLE Students "
                     + "(ID NUMBER PRIMARY KEY,"
                    + "Name VARCHAR2(30), "
                    + "Course VARCHAR2(35))";

            cr.executeUpdate(Create_Table);
           
           Statement ir = con.createStatement();
           String Insert_Statement = "INSERT INTO Students VALUES(1,'Shadab Khan','B.C.A')";
           ir.executeUpdate(Insert_Statement);
           
           Statement sr = con.createStatement();
           String select_statement = "SELECT * FROM Students";
           ResultSet rs = sr.executeQuery(select_statement);
           
           System.out.println("\nRetrieving Records -->");
  	
           System.out.printf("-----------------------------------------------%n");          
           System.out.printf("| %-10s | %-18s | %-9s |\n", "ID", "Name", "Course");
           System.out.printf("----------------------------------------------%n");
           
           while(rs.next()){
               int ID = rs.getInt("ID");
               
               String Name = rs.getString("Name");
               
               String Course = rs.getString("Course");
               
               System.out.printf("| %-10s | %-18s | %-9s |\n",  ID, Name, Course);
               
           }
           System.out.printf("-----------------------------------------------%n");    
           
        cr.close();
        ir.close();
        sr.close();
        rs.close();   
        
        con.close();
    
       }catch(SQLException e){
           System.out.println("SQLException"+e.getMessage());
          // e.printStackTrace();
       }       
    }
}