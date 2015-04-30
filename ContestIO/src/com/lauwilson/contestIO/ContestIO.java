package com.lauwilson.contestIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Class which provides static methods for loading input and output to files.
 * 
 * @author wilson
 */
public class ContestIO {
    
    /**
     * Static method takes in a filepath and loads a scanner to read from that file.
     * 
     * @param file The file to read from.
     * @return A loaded Scanner object which reads from file.
     */
    public static Scanner setInput(String file) {
        try {
            return new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return null;
        }
    }
    
    /**
     * Static method takes in a filepath and buffers a writer to write to that file.
     * 
     * @param file The file to write to.
     * @return A loaded BufferedWriter object which writes to the file.
     */
    public static BufferedWriter setOutput(String file) {
        try {
            File fout = new File(file);
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(
                                    new OutputStreamWriter(fos));
            return bw;
        } catch (IOException e) {
            System.out.println("IO Exception Occured");
            return null;
        }
    }
}
