package week_10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
https://medium.com/@JavaFusion/what-is-a-properties-file-in-java-e955c3adc92f
*/

//In Java, Properties is a class from the java.util package used to handle 
//configuration data in the form of key-value pairs, typically stored in a file with the .properties extension.

public class Config_Loader {
    // Create a static Properties object to hold the loaded key-value pairs
    // Since static so need to create an object of Config_Loader to use it.
    static Properties props = new Properties();

    // Static block runs once when the class is first used
     //This block runs only once, when the class is first loaded.
     //It ensures the config.properties file is loaded immediately and just once.
     //Useful for initialization of static fields like props.

    static {
        try {
            // Load the properties from the config file located in the 'src' directory
            props.load(new FileInputStream("src/config.properties"));
        } catch (IOException e) {
            System.out.println("Error loading config.properties: " + e.getMessage());
        }
    }

    // Static method to retrieve a property value by key
    // Since props is static, the method that uses it should also be static.
    //now there si no need to create an object in Problem.java files
    static String get(String key) {
        return props.getProperty(key); // Returns the value associated with the given key
    }
}