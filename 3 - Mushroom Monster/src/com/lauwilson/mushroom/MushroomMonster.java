package com.lauwilson.mushroom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import com.lauwilson.contestIO.ContestIO;

/**
 * Google Code Jam 2015 - Round 1A
 * https://code.google.com/codejam/contest/4224486/dashboard#s=p0
 * 
 * @author wilson
 *
 */
public class MushroomMonster {
    public static void main(String[] args) {
        /**
         * The Scanner which reads from the input file.
         */
        Scanner scan;
        
        /**
         * The BufferedWriter which will write the output to a file.
         */
        BufferedWriter bw;
        
        // attempt to load the scanner and writer. Terminate if exception occurs.
        if ((scan = ContestIO.setInput("A-small-practice.in")) == null ||
                (bw = ContestIO.setOutput("small-output.txt")) == null) {
            System.out.println("IO Setup occured. Terminating Program");
            return;
        }
        
        int numTestCases = scan.nextInt();
        
        int prevInt;
        int newInt;

        for (int i = 0; i < numTestCases; i++) {
            /**
             * The sum of mushrooms eaten in the first method.
             */
            int method1Sum = 0;
            
            /**
             * The sum of mushrooms eaten in the second method.
             */
            int method2Sum = 0;
            
            /**
             * The maximum consumption rate of mushrooms that Kaylin potentially eats
             * in one time period.
             */
            int consumptionRate = 0;
            
            int numOfInputs = scan.nextInt();
            
            // set up the array of numbers that represent mushroom values in the case.
            int[] testCase = new int[numOfInputs];
            
            // scan the initial number of mushrooms into the array.
            newInt = scan.nextInt();
            testCase[0] = newInt;
            
            for (int j = 1; j < numOfInputs; j++) {
                prevInt = newInt;
                newInt = scan.nextInt();
                testCase[j] = newInt;
                
                // check if Kaylin eats any mushrooms in method 1
                // Kaylin eats if: newInt < prevInt
                int intervalRate = (prevInt - newInt);
                if (intervalRate > 0)
                    method1Sum += intervalRate;
                
                //check if consumption this interval is larger than previous max
                // consumption rate. Replace max if interval is larger.
                consumptionRate = (intervalRate > consumptionRate ?
                                                intervalRate : consumptionRate);
            }
            
            // loop through the array of mushroom values and determine how many
            // mushrooms were eaten in the second method.
            for (int k = 0; k < numOfInputs-1; k++) {
                if (testCase[k] > consumptionRate)
                    method2Sum += consumptionRate;
                else
                    method2Sum += testCase[k];
            }
            
            // print the values to console and writes it to the file.
            System.out.println("Case #" + (i+1) + ": " + method1Sum + " " + method2Sum);
            try {
                bw.write("Case #" + (i+1) + ": " + method1Sum + " " + method2Sum);
                bw.newLine();
            } catch (IOException e) {
                System.err.println("Could not write, error occured");
            }
        }
        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.err.println("could not close");
        }
        
    }
}
