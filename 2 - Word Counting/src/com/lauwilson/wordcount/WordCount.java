/**
 * 
 */
package com.lauwilson.wordcount;

import java.util.Scanner;
/**
 * @author wilson
 *
 */
public class WordCount {
    // note: valid escape codes are - \b  \t  \n  \f  \r  \"  \'  \\
    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Type Sometihng");
        input = scan.nextLine();
        // scan the input string for escape codes
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\\') {
                //System.out.println("starting escape backslash found at index " + i);
                switch (input.charAt(i +1)) {
                case 'b': {
                    System.out.println("excape B");
                    break;
                }
                case 't': {
                    System.out.println("excape T");
                    break;
                }
                case 'n': {
                    //System.out.println("excape N");
                    System.out.println();
                    break;
                }
                case 'f': {
                    System.out.println("excape F");
                    break;
                }
                case 'r': {
                    System.out.println("excape R");
                    break;
                }
                case '\"': {
                    System.out.println("excape \"");
                    break;
                }
                case '\'': {
                    System.out.println("excape \'");
                    break;
                }
                case '\\': {
                    System.out.println("excape \\");
                    break;
                }
                }
                i++;
            } else {
                System.out.print(input.charAt(i));
            }
        }
        scan.close();
    }
}
