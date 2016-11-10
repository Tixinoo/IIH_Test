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
     * @param args [0] Sub String you are looking for
     */
    public static void main(String[] args) {

        InputStream is = null;
        try {

            String subString = "";
            if (args.length == 1) {
                subString = args[0];
            } else {
                subString = DEFAULT_SUBSTRING;
            }

            // Create a File object
            File txtFileWithString = new File("src\\resources\\smallString.txt");

            // Create the stream
            is = new FileInputStream(txtFileWithString);

            // Read the file
            byte[] b = new byte[is.available()];
            is.read(b);

            // Create the string and print the position of the substring is it exists
            String retrievedString = new String(b);
            System.out.println(retrievedString.indexOf(subString));

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
