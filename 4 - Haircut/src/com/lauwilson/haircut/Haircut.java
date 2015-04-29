package com.lauwilson.haircut;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import com.lauwilson.contestIO.ContestIO;

/**
 * Google Code Jam 2015 - Round 1A
 * https://code.google.com/codejam/contest/4224486/dashboard#s=p1
 * 
 * @author wilson
 */
public class Haircut {
    /**
     * The Scanner which reads input from a file.
     */
    private Scanner scan;
    
    /**
     * The BufferedWriter which will write the output to a file.
     */
    private BufferedWriter bw;
    
    private int numTestCases;
    
    /**
     * Constructor for a Haircut object. Will automatically load the 
     * Scanner and BufferedWriter.
     * 
     * @param inputFile     The file to read from.
     * @param outputFile    The file to write to.
     */
    public Haircut(String inputFile, String outputFile) {
        scan = ContestIO.setInput(inputFile);
        bw = ContestIO.setOutput(outputFile);
    }
 
    /**
     * Method which runs the program logic.
     */
    public void run() {
        numTestCases = scan.nextInt();
        
        for (int i = 0; i < numTestCases; i++) {
            int numberOfBarbers = scan.nextInt();
            long customerNumber = scan.nextInt();
            
            // int array holds the cutting speed of every barber.
            int[] barberList = new int[numberOfBarbers];
            
            // determine the speed of the slowest barber, which determines
            // the worst case scenario.
            long slowestBarber = 0;
            
            for (int j = 0; j < numberOfBarbers; j++) {
                barberList[j] = scan.nextInt();
                slowestBarber = Math.max(slowestBarber, barberList[j]);           
            }
            
            long timeServed = findTime(customerNumber, slowestBarber, barberList);
            
            // figure out the total number of customers served in the previous
            // time period and get the remaining amount.
            long customersRemaining = ((long) customerNumber) - countServedCustomers(timeServed - 1, barberList);
            
            for (int k = 0; k < barberList.length; k++) {
                // true if barber available in this time period.
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
    
    /**
     * Method figures out the total amount of customers served by all barbers in a given time period.
     * 
     * @param time          The time period.
     * @param barberList    The cutting speeds of every barber in the shop.
     * @return              The total number of customers served.
     */
    public long countServedCustomers(long time, int[] barberList) {
        long customersServed = 0;
        for (int i = 0; i < barberList.length; i++) {
            customersServed += (time / barberList[i]) + 1;
        }
        return customersServed;
    }
    
    /**
     * Method finds the time period that the desired customer is served in.
     * 
     * @param customerNo        The desired customer.
     * @param slowestBarber     The cutting speed of the slowest barber.
     * @param barberList        The list of barbers in the shop.
     * @return                  The time period which the customer will be served.
     */
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

    /**
     * Method closes the output file and flushes output.
     */
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
    
    /**
     * Main driver method for the program.
     * 
     * @param args unused.
     */
    public static void main(String[] args) {
        new Haircut("B-small-practice.in", "B-small-output.txt").run();
        new Haircut("B-large-practice.in", "B-large-output.txt").run();
    }
}