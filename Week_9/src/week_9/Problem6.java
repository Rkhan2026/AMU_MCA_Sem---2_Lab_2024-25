package week_9;

import java.util.Scanner;

import java.io.*;

public class Problem6 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("IOException Error: File operation failed. Please check if the file exists."+"\n"+e);
        }
    }
}