/**
 * 
 */
package com.lauwilson.carryadd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author wilson
 *
 */
public class CarryAdder {
    static Scanner scan;
    static String input;
    static String[] inputArray;
    static int[] intArray;
    static int maxLength = 0;              // the longest numerical number
    static int sum = 0;                        // the sum of all the numbers
    static int[] carryArray;
    static int carryIn = 0;
    
    public static void printLine() {
        for (int i = 0; i < ((Integer) sum).toString().length(); i++) {
            System.out.print("-");
        }
    }
    
    public static void main(String[] args) {
        try {
            scan = new Scanner(new File("src" + File.separator + "input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt not found");
            return;
        }
        
        input = scan.nextLine();
        System.out.println(input);
        inputArray = input.split("[+]");

        // Calculate the sum of the numbers
        for (int i = 0; i < inputArray.length; i++) {
            sum += Integer.parseInt(inputArray[i]);
        }
        
        // Figure out the longest numerical number for output formatting reasons
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].length() > maxLength) {
                maxLength = inputArray[i].length();
            }
        }
        
        // Convert String array to ints
        intArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            intArray[i] = Integer.parseInt(inputArray[i]);
        }
        
        // Add the carries to an array
        carryArray = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int onesDigitTotal = 0;
            for (int k = 0; k < intArray.length; k++) {
                onesDigitTotal += intArray[k] % 10;
                intArray[k] /= 10;
            }
            // add the carry-in
            onesDigitTotal += carryIn;
            
            carryArray[i] = onesDigitTotal / 10;
            carryIn = onesDigitTotal / 10;
        }
        
        // Print the carry array to console
        System.out.println();
        for (int i = carryArray.length - 2; i > -1; i--) {
            if (carryArray[i] == 0) {
                System.out.print(" ");
            } else {
                System.out.print(carryArray[i]);
            }
        }
        System.out.println(" \tCarry In");
        
        // printing all numbers with the correct formatting
        printLine();
        System.out.println();
        for (int i = 0; i < inputArray.length; i++) {
            int extraSpacing = ((Integer) sum).toString().length() - inputArray[i].length();
            for (int j = 0; j < extraSpacing; j++) {
                System.out.print(" ");
            }
            System.out.print(inputArray[i]);
            System.out.println("\tInput #" + (i + 1));
        }
        
        printLine();
        System.out.println("\n" + sum + "\tTotal");
        
    } // end of main
} // end of class
