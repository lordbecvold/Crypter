package xyz.becvar.crypter.utils;

import xyz.becvar.crypter.utils.console.ConsoleColors;

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
}
