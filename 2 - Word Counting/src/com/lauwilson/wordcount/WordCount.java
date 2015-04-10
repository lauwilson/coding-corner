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
        String output = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Type Sometihng");
        input = scan.nextLine();
        
        // scan the input string for escape codes
        
        for (int i = 0; i < input.length(); i++) {
            try {
                    if (input.charAt(i) == '\\') {
                    //System.out.println("starting escape backslash found at index " + i);
                    switch (input.charAt(i +1)) {
                    case 'b': {
                        System.out.println("excape B");
                        break;
                    }
                    case 't': { // Assuming tab characters deliminate by 4 spaces
                        System.out.println("excape T");
                        int spaces = 4 - (i % 4);
                        for (int j = 0; j < spaces; j++) {
                            output.concat(" ");
                        }
                        
                        break;
                    }
                    case 'n': {
                        //System.out.println("excape N");
                        output.concat("\n");
                        break;
                    }
                    case 'f': { // unused in modern editors
                        System.out.println("excape F");
                        break;
                    }
                    case 'r': { //
                        output.concat("\r");
                        break;
                    }
                    case '\"': {
                        System.out.print("\"");
                        break;
                    }
                    case '\'': {
                        System.out.print("\'");
                        break;
                    }
                    case '\\': {
                        System.out.print("\\");
                        break;
                    }
                    default: {
                        System.out.println("\n\\Invalid Escape Character Sequence");
                    }
                    }
                    i++;
                } else {
                    output.concat("" + input.charAt(i));
                } 
            } catch (Exception e) {
                    System.out.println("Invalid String (String never ends)");
                }
        }
        System.out.println(output);
        scan.close();
    }
}
