package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine NOSAL
 */
public class SimpleComparison {

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

            // Create a File object
            File txtFileWithString = new File(path);

            // Create the stream
            is = new FileInputStream(txtFileWithString);

            // Read the file
            byte[] b = new byte[is.available()];
            is.read(b);

            // Create the string and print the position of the substring is it exists
            String retrievedString = new String(b);
            System.out.println("The substring '" + subString + "' has been found one time at the position: " + retrievedString.indexOf(subString));

            System.out.println("\n---");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimpleComparison.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleComparison.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(SimpleComparison.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
