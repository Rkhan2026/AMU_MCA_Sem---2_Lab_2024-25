//Custom Exception For Problem 2 Onwards
package week_10;
public class DatabaseConnectionException extends Exception {   
    public DatabaseConnectionException(String message){
        super(message);
    }
}