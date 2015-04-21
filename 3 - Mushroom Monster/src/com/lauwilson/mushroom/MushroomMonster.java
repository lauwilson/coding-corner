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

public class MushroomMonster {
    public static void main(String[] args) {
        Scanner scan;
        PrintWriter out;
        File fout;
        FileOutputStream fos;
        BufferedWriter bw;
        try {
            scan = new Scanner(new File("A-small-practice.in"));
            fout = new File("small-output.txt");
            fos = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Terminating Program");
            return;
        }
        int numTestCases = scan.nextInt();
        
        int prevInt;
        int newInt;

        
        for (int i = 0; i < numTestCases; i++) {
            
            int method1Sum = 0;
            int method2Sum = 0;
            
            int consumptionRate = 0;
            
            int numOfInputs = scan.nextInt();
            
            int[] testCase = new int[numOfInputs];
            
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
            
            for (int k = 0; k < numOfInputs-1; k++) {
                if (testCase[k] > consumptionRate)
                    method2Sum += consumptionRate;
                else
                    method2Sum += testCase[k];
            }
            
            System.out.println("Case #" + (i+1) + ": " + method1Sum + " " + method2Sum);
            try {
                bw.write("Case #" + (i+1) + ": " + method1Sum + " " + method2Sum);
                bw.newLine();
            } catch (IOException e) {
                System.err.println("Could not write, error occured");
            }
        }
        try {
            bw.close();
        } catch (IOException e) {
            System.err.println("could not close");
        }
        
    }
}
