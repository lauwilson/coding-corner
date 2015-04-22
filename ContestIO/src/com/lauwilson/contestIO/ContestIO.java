package com.lauwilson.contestIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ContestIO {
    
    public static Scanner setInput(String file) {
        try {
            return new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return null;
        }
    }
    
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
