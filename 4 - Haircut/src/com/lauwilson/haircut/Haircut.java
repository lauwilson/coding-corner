package com.lauwilson.haircut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Haircut {
    private Scanner scan;
    private static PrintWriter pw;
    private int numTestCases;
    
    public static void main(String[] args) {
        try {
          //  scan = new Scanner(new File("input.txt"));
            pw = new PrintWriter("output.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Terminating program");
            return;
        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding unsupported. Terminating program");
            return;
        }
        
      //  numTestCases = scan.nextInt();
        /*int[] test = new int[200000];
        for (int i = 0; i < 200000; i++)
            test[i] = i;
        for (int i = 0; i < 200000; i++)
            System.out.println(test[i]);
        
        */
        
        List<Integer> test = new LinkedList<Integer>();

        pw.close();
    }
}

class CircularLinkedList {
    class Node {
        TreeSet<Integer> freeBarbers;
        Node next;
        
        public Node() {
            freeBarbers = new TreeSet<Integer>();
        }
    }
    
    Node head;
    
    
    void add(Node n) {
        // INSERT ADDING LOGIC
    }
    
    
    public CircularLinkedList(int max) {
        head = new Node();
    }
    
}