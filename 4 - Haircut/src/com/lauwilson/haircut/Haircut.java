package com.lauwilson.haircut;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import com.lauwilson.contestIO.ContestIO;

public class Haircut {
    private Scanner scan;
    private BufferedWriter bw;
    
    private int numTestCases;
    
    public Haircut(String inputFile, String outputFile) {
        scan = ContestIO.setInput(inputFile);
        bw = ContestIO.setOutput(outputFile);
    }
 
    public void run() {
        numTestCases = scan.nextInt();
        
        for (int i = 0; i < numTestCases; i++) {
            int numberOfBarbers = scan.nextInt();
            long customerNumber = scan.nextInt();
            
            int[] barberList = new int[numberOfBarbers];
            long slowestBarber = 0;
            
            for (int j = 0; j < numberOfBarbers; j++) {
                barberList[j] = scan.nextInt();
                slowestBarber = Math.max(slowestBarber, barberList[j]);           
            }
            
            long timeServed = findTime(customerNumber, slowestBarber, barberList);
            
            long customersRemaining = ((long) customerNumber) - countServedCustomers(timeServed - 1, barberList);
            
            for (int k = 0; k < barberList.length; k++) {
                if (timeServed % barberList[k] == 0)
                    customersRemaining--;
                if (customersRemaining == 0) {
                    System.out.println("Case #" + (i + 1) + ": " + (k+1));
                    try {
                        bw.write("Case #" + (i + 1) + ": " + (k+1));
                        bw.newLine();
                    } catch (IOException e) {
                        System.err.println("Case #" + (i + 1) + " - ERROR: Could not write to file");
                    }
                    break;
                }
            }
            
            
        }
        close();
    }
    
    public long countServedCustomers(long time, int[] barberList) {
        long customersServed = 0;
        for (int i = 0; i < barberList.length; i++) {
            customersServed += (time / barberList[i]) + 1;
        }
        return customersServed;
    }
    
    public long findTime(long customerNo, long slowestBarber, int[] barberList) {
        long low = -1;
        long high = slowestBarber * customerNo;
        
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (countServedCustomers(mid, barberList) < customerNo)
                low = mid;
            else
                high = mid;    
        }
        return high;
    }
    
    public void dbg(String s) {
        System.out.println(s);
    }
    
    public void close() {
        if (bw != null) {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                System.err.println("IO Exception Occured: Could not close");
            }
        }
    }
    
    public static void main(String[] args) {
        new Haircut("B-small-practice.in", "B-small-output.txt").run();
        new Haircut("B-large-practice.in", "B-large-output.txt").run();
    }
}