package xyz.becvar.crypter;

import xyz.becvar.crypter.utils.BasicUtils;
import xyz.becvar.crypter.utils.console.ConsoleColors;
import xyz.becvar.crypter.utils.console.ConsoleUtils;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    //Init instances
    public static ConsoleUtils consoleUtils = new ConsoleUtils();
    public static Main main = new Main();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //Clear console after start app
        consoleUtils.clearConsole();

        //Print main "GUI"
        main.printMain();
    }


    public void printMain() throws IOException {

        //Print menu
        consoleUtils.printSpacer();
        consoleUtils.consoleLog(ConsoleColors.ANSI_GREEN + "Hi, " + System.getProperty("user.name") + " please select algorithm...");
        consoleUtils.printSpacer();
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Base64         " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "AES");
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "3)" + ConsoleColors.ANSI_GREEN + "Bcrypt         " + ConsoleColors.ANSI_YELLOW + "4)" + ConsoleColors.ANSI_GREEN + "CRC16");
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "5)" + ConsoleColors.ANSI_GREEN + "MD4            " + ConsoleColors.ANSI_YELLOW + "6)" + ConsoleColors.ANSI_GREEN + "MD5");
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "7)" + ConsoleColors.ANSI_GREEN + "NTLM           " + ConsoleColors.ANSI_YELLOW + "8)" + ConsoleColors.ANSI_GREEN + "RIPEMD160");
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "9)" + ConsoleColors.ANSI_GREEN + "SHA1           " + ConsoleColors.ANSI_YELLOW + "10)" + ConsoleColors.ANSI_GREEN + "SHA256");
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "11)" + ConsoleColors.ANSI_GREEN + "Whirlpool     " + ConsoleColors.ANSI_YELLOW + "12)" + ConsoleColors.ANSI_GREEN + "Base58");
        consoleUtils.printEmptySpacer();
        consoleUtils.printEmptySpacer();
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "0." + ConsoleColors.ANSI_GREEN + "Crack hash");

        //Get user input and send to select function
        System.out.print(ConsoleColors.ANSI_YELLOW + "type the number of the algorithm: ");
        String algorithm = scanner.nextLine();

        //Check if value is valid
        if (!BasicUtils.ifValueValid(algorithm)) {
            consoleUtils.printEmptySpacer();
            selectAlgorithm(algorithm);
        } else {
            printInvalidMSG();
        }
    }


    //Print error msg and main menu
    public void printInvalidMSG() throws IOException {
        consoleUtils.printLongSpacer();
        consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error your algorithm value is not valid!");
        consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Please select algorithm integer...\n");
        printMain();
    }


    //Set function by algorithm
    public void selectAlgorithm(String algorithm) throws IOException {
        if (algorithm.equals("0")) { //Open cracker gui
            crackerInit();

        } else if (algorithm.equals("1")) { //Base64
            Hasher.base64();

        } else if (algorithm.equals("2")) { //AES
            Hasher.aes();

        }else if (algorithm.equals("3")) { //Bcrypt
            Hasher.bcrypt();

        } else if (algorithm.equals("4")) { //CRC16
            Hasher.crc16();

        } else if (algorithm.equals("5")) { //MD4
            Hasher.md4();

        } else if (algorithm.equals("6")) { //MD5
            Hasher.md5();

        } else if (algorithm.equals("7")) { //NTLM
            Hasher.ntlm();

        } else if (algorithm.equals("8")) { //RIPEMD160
            Hasher.ripemd160();

        } else if (algorithm.equals("9")) { //SHA1
            Hasher.sha1();

        } else if (algorithm.equals("10")) { //SHA256
            Hasher.sha256();

        } else if (algorithm.equals("11")) { //Whirlpool
            Hasher.whirlpool();

        } else if (algorithm.equals("12")) { //Base58
            Hasher.base58();

        } else {
            printInvalidMSG();
        }
    }


    //Init cracker tool
    public static void crackerInit() throws IOException {
        consoleUtils.printEmptySpacer();
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Please select cracking type");
        consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Brute-force     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Random");
        String process = scanner.nextLine();

        if (process.equalsIgnoreCase("1")) { //Bruteforce from file wordlist
            Cracker.bruteForceFromFile();

        } else if (process.equalsIgnoreCase("2")) { //Random generate hash
            Cracker.randomGenerate();

        } else {
            BasicUtils.exitApp("Sorry process not found");
        }
    }
}
