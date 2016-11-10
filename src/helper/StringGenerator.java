package helper;

import java.util.Random;

/**
 *
 * @author Antoine NOSAL
 */
public class StringGenerator {

    /**
     * Default size of the generated String
     */
    private static int STRING_DEFAULT_SIZE = 1000;
    
    /**
     * @param args [0] the length of the String you want
     */
    public static void main(String[] args) {
        
        String generatedString;
        
        // Generate a String
        if (args.length > 0) {
            generatedString = StringGenerator.generateString(Integer.parseInt(args[0]));
        } else {
            generatedString = StringGenerator.generateString(STRING_DEFAULT_SIZE);
        }
        
        // Print this generatedString in the console
        System.out.println(generatedString);
        
    }

    /**
     * Return a random string
     * @param length length of the generated string
     * @return Generated String
     */
    public static String generateString(int length) {
        String result = "";
        Random r = new Random();
        // Precise the possible characters 
        String characters = "abcdefghijklmnopqrstuvwxyz123456789";
        for (int i = 0; i < length; i++) {
            result += characters.charAt(r.nextInt(characters.length()));
        }
        return result;
    }

}
