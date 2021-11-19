package xyz.becvar.crypter;

import xyz.becvar.crypter.cryptes.encryptions.AES;
import xyz.becvar.crypter.cryptes.encryptions.BASE58;
import xyz.becvar.crypter.cryptes.encryptions.BASE64;
import xyz.becvar.crypter.utils.BasicUtils;
import xyz.becvar.crypter.utils.console.ConsoleColors;
import java.util.Scanner;

public class Hasher {

    public static Scanner scanner = new Scanner(System.in);

    public static void base64() {

        String processString = "1";

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = scanner.nextLine();

        if (process.equalsIgnoreCase("1")) {
            processString = "1";
        } else if (process.equalsIgnoreCase("2")) {
            processString = "2";
        } else {
            base64();
        }

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string...");

        //Get string input
        String stringValue = scanner.nextLine();

        //Check if string is empty
        if (stringValue.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error your string is empty");
            base64();
        }

        //Encode and decode string1
        if (processString.equalsIgnoreCase("1")) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Encoded string: " + BASE64.base64Encode(stringValue));
        } else if (processString.equalsIgnoreCase("2")) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Decoded string: " + BASE64.base64Decode(stringValue));
        }

        //Print msg
        System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

        //Get ans
        String ans = scanner.nextLine();

        //make action by input
        if (ans.equalsIgnoreCase("y")) {
            base64();
        } else if (ans.equalsIgnoreCase("n")) {
            BasicUtils.exitApp("Crypter exited...");
        } else {
            System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
            BasicUtils.exitApp("Crypter exited...");
        }
    }

    public static void aes() {

        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Select key");
        String key = scanner.nextLine();

        String processString = "1";

        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = scanner.nextLine();

        if (process.equalsIgnoreCase("1")) {
            processString = "1";
        } else if (process.equalsIgnoreCase("2")) {
            processString = "2";
        } else {
            aes();
        }

        if (key.isEmpty()) {
            aes();
        } else {
            //Print msg
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string...");

            //Get string input
            String stringValue = scanner.nextLine();

            //Check if string is empty
            if (stringValue.isEmpty()) {
                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error your string is empty");
                aes();
            }

            //Encode and decode string1
            if (processString.equalsIgnoreCase("1")) {
                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Encoded string: " + AES.encryptAES(stringValue, key));
            } else if (processString.equalsIgnoreCase("2")) {
                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Decoded string: " + AES.decryptAES(stringValue, key));
            }

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                aes();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        }

    }

    public static void bcrypt() {

    }

    public static void crc16() {

    }

    public static void md4() {

    }

    public static void md5() {

    }

    public static void ntlm() {

    }

    public static void ripemd160() {

    }

    public static void sha1() {

    }

    public static void sha256() {

    }

    public static void whirlpool() {

    }

    public static void base58() {
        String processString = "1";

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = scanner.nextLine();

        if (process.equalsIgnoreCase("1")) {
            processString = "1";
        } else if (process.equalsIgnoreCase("2")) {
            processString = "2";
        } else {
            base58();
        }

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string...");

        //Get string input
        String stringValue = scanner.nextLine();

        //Check if string is empty
        if (stringValue.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error your string is empty");
            base58();
        }

        //Encode and decode string1
        if (processString.equalsIgnoreCase("1")) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Encoded string: " + BASE58.encode(stringValue.getBytes()));
        } else if (processString.equalsIgnoreCase("2")) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Decoded string: " + new String(BASE58.decode(stringValue)));
        }

        //Print msg
        System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

        //Get ans
        String ans = scanner.nextLine();

        //make action by input
        if (ans.equalsIgnoreCase("y")) {
            base58();
        } else if (ans.equalsIgnoreCase("n")) {
            BasicUtils.exitApp("Crypter exited...");
        } else {
            System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
            BasicUtils.exitApp("Crypter exited...");
        }
    }
}
