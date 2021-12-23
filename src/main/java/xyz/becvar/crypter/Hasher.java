package xyz.becvar.crypter;

import xyz.becvar.crypter.cryptes.encryptions.AES;
import xyz.becvar.crypter.cryptes.encryptions.BASE58;
import xyz.becvar.crypter.cryptes.encryptions.BASE64;
import xyz.becvar.crypter.cryptes.hashes.*;
import xyz.becvar.crypter.utils.BasicUtils;
import xyz.becvar.crypter.utils.console.ConsoleColors;

public class Hasher {

    //Base64 encode or decode
    public static void base64() {

        //Select default process value
        String processString = "1";

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = Main.scanner.nextLine();

        //Selct process (Encode or decode)
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
        String stringValue = Main.scanner.nextLine();

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
        String ans = Main.scanner.nextLine();

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



    //AES encode or decode methode
    public static void aes() {

        //Select key from user
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Select key");
        String key = Main.scanner.nextLine();

        //Select default process value
        String processString = "1";

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = Main.scanner.nextLine();

        //Select encode or decode methode
        if (process.equalsIgnoreCase("1")) {
            processString = "1";
        } else if (process.equalsIgnoreCase("2")) {
            processString = "2";
        } else {
            aes();
        }

        //Check if key is valid
        if (key.isEmpty()) {
            aes();
        } else {

            //Print msg
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string...");

            //Get string input
            String stringValue = Main.scanner.nextLine();

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
            String ans = Main.scanner.nextLine();

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



    //Base58 encryption methode
    public static void base58() {

        //Set default process
        String processString = "1";

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = Main.scanner.nextLine();

        //Select encode or decode methode
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
        String stringValue = Main.scanner.nextLine();

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
        String ans = Main.scanner.nextLine();

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



    //Hash Bcrypt
    public static void bcrypt() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type salt cost value");
        String cost = Main.scanner.nextLine();

        if (value.isEmpty() || cost.isEmpty()) {
            bcrypt();
        } else {
            if (BasicUtils.isInteger(cost)) {
                Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + BCryptHash.createBcrypt(value, Integer.parseInt(cost)));

                //Print msg
                System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

                //Get ans
                String ans = Main.scanner.nextLine();

                //make action by input
                if (ans.equalsIgnoreCase("y")) {
                    bcrypt();
                } else if (ans.equalsIgnoreCase("n")) {
                    BasicUtils.exitApp("Crypter exited...");
                } else {
                    System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                    BasicUtils.exitApp("Crypter exited...");
                }
            } else {
                bcrypt();
            }
        }
    }



    //Hash crc16
    public static void crc16() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + CRC16.generateCRC16(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                crc16();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            crc16();
        }
    }



    //Hash md4
    public static void md4() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + MD4.createMD4(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                md4();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            md4();
        }
    }



    //Hash md5
    public static void md5() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + MD5.createMD5(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                md5();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            md5();
        }
    }



    //Hash NTLM
    public static void ntlm() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + NTLM.generateNTLM(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                ntlm();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            ntlm();
        }
    }



    //Hash RIPE Message Digest
    public static void ripemd160() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + RIPEMD160.generateRIPME160(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                ripemd160();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            ripemd160();
        }
    }



    //Hash sha1
    public static void sha1() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + SHA1.createSHA1(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                sha1();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            sha1();
        }
    }



    //Hash sha256
    public static void sha256() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type salt value");
        String salt = Main.scanner.nextLine();

        if (value.isEmpty() || salt.isEmpty()) {
            sha256();
        } else {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + SHA256.createSHA256(value, salt));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                sha256();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        }
    }



    //Hash Whirlpool
    public static void whirlpool() {
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string to hash");
        String value = Main.scanner.nextLine();

        if (!value.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_BLUE + Whirlpool.createWhirlpool(value));

            //Print msg
            System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

            //Get ans
            String ans = Main.scanner.nextLine();

            //make action by input
            if (ans.equalsIgnoreCase("y")) {
                whirlpool();
            } else if (ans.equalsIgnoreCase("n")) {
                BasicUtils.exitApp("Crypter exited...");
            } else {
                System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
                BasicUtils.exitApp("Crypter exited...");
            }
        } else {
            whirlpool();
        }
    }



    //becvoldCrypt encryption methode
    public static void becvoldCrypt() {

        //Set default process
        String processString = "1";

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "1)" + ConsoleColors.ANSI_GREEN + "Encode     " + ConsoleColors.ANSI_YELLOW + "2)" + ConsoleColors.ANSI_GREEN + "Decode");
        String process = Main.scanner.nextLine();

        //Select encode or decode methode
        if (process.equalsIgnoreCase("1")) {
            processString = "1";
        } else if (process.equalsIgnoreCase("2")) {
            processString = "2";
        } else {
            becvoldCrypt();
        }

        //Print msg
        Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Type your string...");

        //Get string input
        String stringValue = Main.scanner.nextLine();

        //Check if string is empty
        if (stringValue.isEmpty()) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_RED + "Error your string is empty");
            becvoldCrypt();
        }

        //Encode and decode string1
        if (processString.equalsIgnoreCase("1")) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Encoded string: " + Main.becvoldCrypt.encrypt(stringValue));
            System.out.println(stringValue);
        } else if (processString.equalsIgnoreCase("2")) {
            Main.consoleUtils.consoleLog(ConsoleColors.ANSI_YELLOW + "Decoded string: " + Main.becvoldCrypt.decrypt(stringValue));
            System.out.println(stringValue);
        }

        //Print msg
        System.out.print(ConsoleColors.ANSI_GREEN + "You want to code another[Y]: ");

        //Get ans
        String ans = Main.scanner.nextLine();

        //make action by input
        if (ans.equalsIgnoreCase("y")) {
            becvoldCrypt();
        } else if (ans.equalsIgnoreCase("n")) {
            BasicUtils.exitApp("Crypter exited...");
        } else {
            System.out.print(ConsoleColors.ANSI_RED + "Error " + ans + " is wrong value");
            BasicUtils.exitApp("Crypter exited...");
        }
    }
}
