package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine NOSAL
 */
public class CompleteComparison {

    /**
     * Default sub string
     */
    private static String DEFAULT_SUBSTRING = "cde";

    /**
     * @param args  [0] Sub String you are looking for
     *              [1] '-s' for a small String example, '-l' for a long one
     */
    public static void main(String[] args) {

        System.out.println("---\n");
        
        InputStream is = null;
        try {

            String path = "resources\\smallString.txt";
            String subString = DEFAULT_SUBSTRING;
            switch(args.length) {
                case 1:
                    subString = args[0];
                    break;
                case 2:
                    subString = args[0];
                    if (args[1].equals("-s")) {
                        path = "resources\\smallString.txt";
                    } else if (args[1].equals("-l")) {
                        path = "resources\\veryLongString.txt";
                    }
                    break;
                default:
                    break;
            }

            // Create file, stream and reader
            File txtFileWithString = new File(path);
            is = new FileInputStream(txtFileWithString);
            Reader reader = new InputStreamReader(is);
            
            String tmp = "";
            int c;
            int index = 1;
            boolean atLeastOneTime = false;
            
            // During this loop, we compare each subtring of the string to the substring searched
            // In order to do that, we iterate character by character and construct all possible substring with the right length
            while ((c = reader.read()) != -1) {
                char character = (char) c;
                if (tmp.length() < subString.length()-1) {
                    tmp += character;
                } else {
                    tmp += character;
                    if (tmp.indexOf(subString) != -1) {
                        atLeastOneTime = true;
                        int i = index - subString.length();
                        System.out.println("The sub string has been found at the position: " + i);
                    }
                    tmp = tmp.substring(1, tmp.length());
                }
                index++;
            }

        if(!atLeastOneTime) {
            System.out.println("The sub string has been found at the position: -1");
        }
            
        System.out.println("\n---");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompleteComparison.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompleteComparison.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(CompleteComparison.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
