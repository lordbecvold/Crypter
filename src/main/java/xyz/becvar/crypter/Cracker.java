package xyz.becvar.crypter;

import xyz.becvar.crypter.cryptes.hashes.*;
import xyz.becvar.crypter.utils.BasicUtils;
import xyz.becvar.crypter.utils.FileUtils;
import xyz.becvar.crypter.utils.console.ConsoleColors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Cracker {

    //Init def vars
    public static String filePath;
    public static String hashToCrack;
    public static String cost;
    public static String salt;
    public static boolean canCrack = true;

    public static void bruteForceFromFile() {

        // Print info
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Brute-force is brute-force attack consists of an attacker submitting many passwords or passphrases with the hope of eventually guessing correctly.");

        Main.consoleUtils.printEmptySpacer();
        System.out.print(ConsoleColors.ANSI_YELLOW + "Please type path to wordlist: ");
        filePath = Main.scanner.nextLine();
        Main.consoleUtils.printEmptySpacer();

        //Check if wordlist file valid
        if (!FileUtils.isWordlistValid(filePath)) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error wordlist path is invalid");
            bruteForceFromFile();

        } else {


            //Print menu
            Main.consoleUtils.printEmptySpacer();
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Please select algorithm");
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Bcrypt         " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "CRC16");
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "3)" + ConsoleColors.ANSI_GREEN + "MD4            " + ConsoleColors.ANSI_YELLOW + "4)" + ConsoleColors.ANSI_GREEN + "MD5");
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "5)" + ConsoleColors.ANSI_GREEN + "NTLM           " + ConsoleColors.ANSI_YELLOW + "6)" + ConsoleColors.ANSI_GREEN + "RIPEMD160");
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "7)" + ConsoleColors.ANSI_GREEN + "SHA1           " + ConsoleColors.ANSI_YELLOW + "8)" + ConsoleColors.ANSI_GREEN + "SHA256");
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "9)" + ConsoleColors.ANSI_GREEN + "Whirlpool");
            Main.consoleUtils.printEmptySpacer();

            //Get user input and send to select function
            System.out.print(ConsoleColors.ANSI_YELLOW + "type the number of the algorithm: ");
            String algorithm = Main.scanner.nextLine();

            //Check if value is valid
            if (!BasicUtils.ifValueValid(algorithm)) {
                Main.consoleUtils.printEmptySpacer();

                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type hash to crack");
                hashToCrack = Main.scanner.nextLine();

                if (hashToCrack.isEmpty()) {
                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error your hash is invalid");
                    bruteForceFromFile();

                } else {

                    if (algorithm.equalsIgnoreCase("1")) {
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type salt cost value");
                        cost = Main.scanner.nextLine();
                    }

                    if (algorithm.equalsIgnoreCase("8")) {
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type salt value");
                        salt = Main.scanner.nextLine();
                    }

                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = br.readLine()) != null) {

                            if (algorithm.equalsIgnoreCase("1")) { //Bcrypt
                                String hash = BCryptHash.createBcrypt(line, Integer.parseInt(cost));
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:Bcrypt -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("2")) { //CRC16
                                String hash = CRC16.generateCRC16(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:CRC16 -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("3")) { //MD4
                                String hash = MD4.createMD4(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:MD4 -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("4")) { //MD5
                                String hash = MD5.createMD5(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:MD5 -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("5")) { //NTLM
                                String hash = NTLM.generateNTLM(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:NTLM -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("6")) { //RIPEMD160
                                String hash = RIPEMD160.generateRIPME160(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:RIPEMD160 -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("7")) { //SHA1
                                String hash = SHA1.createSHA1(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:SHA1 -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("8")) { //SHA256
                                String hash = SHA256.createSHA256(line, salt);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:SHA256 -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else if (algorithm.equalsIgnoreCase("9")) { //Whirlpool
                                String hash = Whirlpool.createWhirlpool(line);
                                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "[" + line + "]:Whirlpool -> "+ ConsoleColors.ANSI_GREEN + hash);

                                if (hash.equalsIgnoreCase(hashToCrack)) {
                                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + line);
                                    System.in.read();
                                    System.exit(0);
                                }

                            } else {
                                BasicUtils.exitApp("Error your vote not found");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    public static void randomGenerate() throws IOException {

        Main.consoleUtils.printEmptySpacer();

        System.out.print(ConsoleColors.ANSI_GREEN + "Please type your hash to crack: ");
        hashToCrack = Main.scanner.nextLine();

        if (hashToCrack.isEmpty()) {
            BasicUtils.exitApp("Hash value is empty!");
        }

        Main.consoleUtils.printEmptySpacer();
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Please select algorithm");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Bcrypt         " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "CRC16");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "3)" + ConsoleColors.ANSI_GREEN + "MD4            " + ConsoleColors.ANSI_YELLOW + "4)" + ConsoleColors.ANSI_GREEN + "MD5");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "5)" + ConsoleColors.ANSI_GREEN + "NTLM           " + ConsoleColors.ANSI_YELLOW + "6)" + ConsoleColors.ANSI_GREEN + "RIPEMD160");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "7)" + ConsoleColors.ANSI_GREEN + "SHA1           " + ConsoleColors.ANSI_YELLOW + "8)" + ConsoleColors.ANSI_GREEN + "SHA256");
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "9)" + ConsoleColors.ANSI_GREEN + "Whirlpool");
        Main.consoleUtils.printEmptySpacer();

        //Get user input and send to select function
        System.out.print(ConsoleColors.ANSI_YELLOW + "type the number of the algorithm: ");
        String algorithm = Main.scanner.nextLine();

        if (!BasicUtils.ifValueValid(algorithm)) {

            if (algorithm.equalsIgnoreCase("1")) {

                while (canCrack) {

                    int cost = 13;

                    String random = BasicUtils.genrateString();

                    String hash = BCryptHash.createBcrypt(random, cost);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "BCrypt -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }

            } else if (algorithm.equalsIgnoreCase("2")) {

                String random = BasicUtils.genrateString();

                String hash = CRC16.generateCRC16(random);

                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "CRC16 -> " + ConsoleColors.ANSI_GREEN + hash);

                if (hashToCrack.equalsIgnoreCase(hash)) {
                    canCrack = false;
                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                    System.in.read();
                    System.exit(0);
                }

            } else if (algorithm.equalsIgnoreCase("3")) {

                String random = BasicUtils.genrateString();

                String hash = MD4.createMD4(random);

                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "MD4 -> " + ConsoleColors.ANSI_GREEN + hash);

                if (hashToCrack.equalsIgnoreCase(hash)) {
                    canCrack = false;
                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                    System.in.read();
                    System.exit(0);
                }
            } else if (algorithm.equalsIgnoreCase("4")) {

                while (canCrack) {
                    String random = BasicUtils.genrateString();

                    String hash = MD5.createMD5(random);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "MD5 -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }

            } else if (algorithm.equalsIgnoreCase("5")) {

                while (canCrack) {
                    String random = BasicUtils.genrateString();

                    String hash = NTLM.generateNTLM(random);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "NTLM -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }

            } else if (algorithm.equalsIgnoreCase("6")) {

                while (canCrack) {
                    String random = BasicUtils.genrateString();

                    String hash = RIPEMD160.generateRIPME160(random);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "RIPEMD160 -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }

            } else if (algorithm.equalsIgnoreCase("7")) {

                while (canCrack) {
                    String random = BasicUtils.genrateString();

                    String hash = SHA1.createSHA1(random);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "SHA1 -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }

            } else if (algorithm.equalsIgnoreCase("8")) {

                while (canCrack) {
                    String random = BasicUtils.genrateString();
                    String randomSalt = BasicUtils.genrateSalt();

                    String hash = SHA256.createSHA256(random, randomSalt);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "SHA256 -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }

            } else if (algorithm.equalsIgnoreCase("9")) {

                while (canCrack) {
                    String random = BasicUtils.genrateString();

                    String hash = Whirlpool.createWhirlpool(random);

                    Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + random + ":" + ConsoleColors.ANSI_YELLOW + "Whirlpool -> " + ConsoleColors.ANSI_GREEN + hash);

                    if (hashToCrack.equalsIgnoreCase(hash)) {
                        canCrack = false;
                        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Plaintext from " + hashToCrack + " is " + random);
                        System.in.read();
                        System.exit(0);
                    }
                }
            }

        } else {
            BasicUtils.exitApp("Error your vote not found");
        }
    }
}


