/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Tarek
 */
public class UserInput {
    
    private static Scanner scnr;
    
    // Default Constructor (no def bc no fields)
    public UserInput(){
    }
    
    // get String input from user
    public static String getString(String msg) {
        String input = "";
        boolean isValid = false;
        // continues until user inputs valid input
        while(!isValid){
            try {
                System.out.println(msg);
                input = scnr.nextLine();
                isValid = true;

            }
            catch (InputMismatchException | NumberFormatException e){
                System.out.println("Error: Invalid input");
                isValid = true;

            }
            catch (Exception e){
                System.out.println("Error: Unknown Error");
                isValid = true;
            }
        }
        return input;
    }
    
    // checks if the String input is an int
    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Error: Invalid input");
            System.out.println(e);
            return false;
        }
    }
    
    // gets int input from user
    public static int getInt(String msg) {
        int intInput = 0;
        boolean isValid = false;
        // continues until user inputs valid input
        while(!isValid){
            try {
                System.out.println(msg);
                String input = scnr.nextLine();
                if(!isInt(input)) {
                    System.out.println("Error: Invalid input");
                    continue;
                }
                intInput = Integer.parseInt(input);
                isValid = true;
            }
            catch (InputMismatchException e){
                System.out.println("Error: Invalid input");
                System.out.println(e);
                isValid = true;
            }
        }
        return intInput;
    }
    
    // checks if the String input is an double
    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        }
        catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Error: Invalid input");
            System.out.println(e);
            return false;
        }
    }
    
    // gets double input from user
    public static double getDouble(String msg) {
        double doubleInput = 0.0;
        boolean isValid = false;
        // continues until user inputs valid input
        while(!isValid){
            try {
                System.out.println(msg);
                String input = scnr.nextLine();
                doubleInput = Double.parseDouble(input);
                isValid = true;

            }
            catch (InputMismatchException | NumberFormatException e){
                System.out.println("Error: Invalid input");
                isValid = true;
            }
        }
        return doubleInput;
    }
    
}
