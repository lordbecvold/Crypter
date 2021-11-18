package xyz.becvar.crypter;

import xyz.becvar.crypter.cryptes.encryptions.BASE64;
import xyz.becvar.crypter.utils.BasicUtils;
import xyz.becvar.crypter.utils.EncryptUtils;
import xyz.becvar.crypter.utils.console.ConsoleColors;
import java.util.Scanner;

public class Hasher {

    public static Scanner scanner = new Scanner(System.in);

    public static void base64() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to encode or decode...");
        String string = scanner.nextLine();

        if (EncryptUtils.checkForEncodeBase64(string)) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Decoded string: " + BASE64.base64Decode(string));
        } else {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Encoded string: " + BASE64.base64Encode(string));
        }

        System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");
        String ans = scanner.nextLine();

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
}
