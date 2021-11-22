package xyz.becvar.crypter;

import xyz.becvar.crypter.utils.BasicUtils;
import xyz.becvar.crypter.utils.console.ConsoleColors;
import java.util.Scanner;

public class Cracker {

    public static Scanner scanner = new Scanner(System.in);

    public static void init() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Brute-force     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Random");
        String process = scanner.nextLine();

        if (process.equalsIgnoreCase("1")) {
            bruteForce();
        } else if (process.equalsIgnoreCase("2")) {
            random();
        } else {
            BasicUtils.exitApp("Sorry process not found");
        }
    }

    public static void bruteForce() {
        //Print menu
        Main.consoleUtils.printEmptySpacer();
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Bcrypt         " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "CRC16");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "3)" + ConsoleColors.ANSI_GREEN + "MD4            " + ConsoleColors.ANSI_YELLOW + "4)" + ConsoleColors.ANSI_GREEN + "MD5");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "5)" + ConsoleColors.ANSI_GREEN + "NTLM           " + ConsoleColors.ANSI_YELLOW + "6)" + ConsoleColors.ANSI_GREEN + "RIPEMD160");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "7)" + ConsoleColors.ANSI_GREEN + "SHA1           " + ConsoleColors.ANSI_YELLOW + "8)" + ConsoleColors.ANSI_GREEN + "SHA256");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "9)" + ConsoleColors.ANSI_GREEN + "Whirlpool      " + ConsoleColors.ANSI_YELLOW + "10)" + ConsoleColors.ANSI_GREEN + "Base58");
        Main.consoleUtils.printEmptySpacer();
        Main.consoleUtils.printEmptySpacer();
        Main.consoleUtils.printEmptySpacer();
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "0." + ConsoleColors.ANSI_GREEN + "Crack hash");

        //Get user input and send to select function
        System.out.print(ConsoleColors.ANSI_YELLOW + "type the number of the algorithm: ");
        String algorithm = scanner.nextLine();

        //Check if value is valid
        if (!BasicUtils.ifValueValid(algorithm)) {
            Main.consoleUtils.printEmptySpacer();
            
            if (algorithm.equalsIgnoreCase("1")) { //Bcrypt

            } else if (algorithm.equalsIgnoreCase("2")) { //CRC16

            } else if (algorithm.equalsIgnoreCase("3")) { //MD4
                
            } else if (algorithm.equalsIgnoreCase("4")) { //MD5
                
            } else if (algorithm.equalsIgnoreCase("5")) { //NTLM
                
            } else if (algorithm.equalsIgnoreCase("6")) { //RIPEMD160
                
            } else if (algorithm.equalsIgnoreCase("7")) { //SHA1
                
            } else if (algorithm.equalsIgnoreCase("8")) { //SHA256
                
            } else if (algorithm.equalsIgnoreCase("9")) { //Whirlpool
                
            } else {
                BasicUtils.exitApp("Error your vote not found");
            }
        } else {
            BasicUtils.exitApp("Error your vote is invalid");
        }
    }

    public static void random() {

    }
}
