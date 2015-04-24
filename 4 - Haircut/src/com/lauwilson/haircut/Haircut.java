package com.lauwilson.haircut;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

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
            // do the loopy thing
            int numOfBarbers = scan.nextInt();
            int customerNo = scan.nextInt();
            int[] barberList = new int[numOfBarbers];
            int slowestBarber = 0;
            ArrayList<TreeSet<Integer>> availableBarbers = new ArrayList<TreeSet<Integer>>();
            
            // add the i-th barber's cutting speed to an array and figure out how long
            // the slowest barber takes to complete a haircut
            for (int j = 0; j < numOfBarbers; j++) {
                int barberSpeed = scan.nextInt();
                slowestBarber = Math.max(slowestBarber, barberSpeed);
                barberList[j] = barberSpeed;
            }
            
            // create an arraylist with index: 0 to (value of slowestBarber)
            for (int j = 0; j <= slowestBarber; j++) {
                availableBarbers.add(new TreeSet<Integer>());
            }
            
            // add each barber to the first index of available barbers (time = 0)
            for (int j = 0; j < barberList.length; j++) {
                availableBarbers.get(0).add(j);
            }
            
            // counting logic
            int time = 0;
            int nextCustomer = 1;
            
            while (nextCustomer < customerNo) {
                while (availableBarbers.get(time).size() == 0)
                    time = (time + 1) % (slowestBarber + 1); // CHECK LOGIC HERE MAY BE INDEX + 1 ERROR TODO
                int nextBarber = availableBarbers.get(time).first();
                availableBarbers.get(time).remove(nextBarber);
                int nextTime = (time + barberList[nextBarber]) % (slowestBarber + 1);
                availableBarbers.get(nextTime).add(nextBarber);
                nextCustomer++;
            }
            // pop the last barber = the barber we want
            while (availableBarbers.get(time).size() == 0)
                time = (time + 1) % (slowestBarber + 1); // CHECK LOGIC HERE MAY BE INDEX + 1 ERROR TODO
            System.out.println("Case #" + (i + 1) + ": " + (availableBarbers.get(time).first() + 1));
        }
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
        new Haircut("B-supersmall-practice.in", "small-output.txt").run();
    }
}