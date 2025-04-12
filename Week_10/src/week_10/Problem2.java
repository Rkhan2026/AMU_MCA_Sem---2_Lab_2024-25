package week_10;

import java.sql.*;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Problem2 {
    static Logger logger = LogManager.getLogger(Problem2.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            executeJDBC(scanner);
        } catch (DatabaseConnectionException e) {
            logger.error("Custom DatabaseConnectionException: " + e.getMessage());
        } finally {
            logger.info("Successful closure of the database connection, "
                      + "regardless of whether an exception occurred or not.");
        }
    }

    static void executeJDBC(Scanner scanner) throws DatabaseConnectionException {
        System.out.println("Retrieving Database Variables From src/config.properties....");
        String url = Config_Loader.get("DB_URL");
        String user = Config_Loader.get("DB_USERNAME");
        String password = Config_Loader.get("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("\nVariables Retrieved Successfully");
           
            Statement cr = con.createStatement();
            String createTable = "CREATE TABLE Students "
                               + "(ID NUMBER PRIMARY KEY, "
                               + "Name VARCHAR2(30), "
                               + "Course VARCHAR2(35))";
            cr.executeUpdate(createTable);          

            Statement ir = con.createStatement();
            String insertRecord = "INSERT INTO Students VALUES(1, 'Saim Khan', 'B.C.A')";
            ir.executeUpdate(insertRecord);
            
            Statement sr = con.createStatement();
            String selectQuery = "SELECT * FROM Students";
            ResultSet rs = sr.executeQuery(selectQuery);

            System.out.println("\nRetrieving Records -->");
            System.out.printf("-----------------------------------------------%n");
            System.out.printf("| %-10s | %-18s | %-9s |\n", "ID", "Name", "Course");
            System.out.printf("-----------------------------------------------%n");

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                String Course = rs.getString("Course");
                System.out.printf("| %-10s | %-18s | %-9s |\n", ID, Name, Course);
            }
            System.out.printf("-----------------------------------------------%n");

            cr.close();
            ir.close();
            sr.close();
            rs.close();

        } catch (SQLException e) {
            throw new DatabaseConnectionException("Problem With Database Connection");
        }
    }
}