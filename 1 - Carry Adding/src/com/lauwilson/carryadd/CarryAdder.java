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
    
    public void printNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            
        }
    }
    public static void main(String[] args) {
        Scanner scan;
        String input;
        String[] inputArray;
        int maxLength = 0;              // the longest numerical number
        int sum = 0;                        // the sum of all the numbers
        
        // The current digit the loop is isolating and adding.
        int workingDigit;
        
        try {
            scan = new Scanner(new File("src" + File.separator + "input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt not found");
            return;
        }
        
        input = scan.nextLine();
        System.out.println(input);
        inputArray = input.split("[+]");
        
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
        
        // Calculate the sum of the numbers
        for (int i = 0; i < inputArray.length; i++) {
            sum += Integer.parseInt(inputArray[i]);
        }
        
        System.out.println("Sum is: " + sum);
        
        
        
        // Figure out the longest numberical number for output formatting reasons
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].length() > maxLength) {
                maxLength = inputArray[i].length();
            }
        }
        
        // printing all numbers with the correct formatting
        for (int i = 0; i < inputArray.length; i++) {
            int extraSpacing = ((Integer) sum).toString().length() - inputArray[i].length();
            for (int j = 0; j < extraSpacing; j++) {
                System.out.print(" ");
            }
            System.out.println(inputArray[i]);
        }
        
        for (int i = 0; i < ((Integer) sum).toString().length(); i++) {
            System.out.print("-");
        }
        System.out.println("\n" + sum);
        
    }
}
