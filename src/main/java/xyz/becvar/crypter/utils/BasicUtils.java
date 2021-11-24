package xyz.becvar.crypter.utils;

import xyz.becvar.crypter.utils.console.ConsoleColors;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BasicUtils {

    //Check if string is int
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        //only got here if we didn't return false
        return true;
    }



    //Check if value is valid (Algorithm select)
    public static boolean ifValueValid(String value) {

        if (value.isEmpty()) {
            return true;
        } else if (!isInteger(value)) {
            return true;
        } else {
            return false;
        }
    }



    //Exit app with exit code
    public static void exitApp(String msg) {
        System.out.println(ConsoleColors.ANSI_RED + msg);
        System.exit(0);
    }

    public static String genrateString() {

        int rand = ThreadLocalRandom.current().nextInt(1, 100);

        String SALTCHARS = "0123456789!#$%&()*+,-./:;<=>?@[]^_`{|}~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < rand) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static String genrateSalt() {

        String SALTCHARS = "0123456789!#$%&()*+,-./:;<=>?@[]^_`{|}~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 20) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
