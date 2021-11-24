package xyz.becvar.crypter;

import xyz.becvar.crypter.cryptes.encryptions.AES;
import xyz.becvar.crypter.cryptes.encryptions.BASE58;
import xyz.becvar.crypter.cryptes.encryptions.BASE64;
import xyz.becvar.crypter.cryptes.hashes.*;

public class ArgumentUsage {

    public static void init(String[] args) {
        if (args[0].equalsIgnoreCase("help")) {
            Main.consoleUtils.consoleLog("Usage: java -jar crypter.jar [process] [string] [algorithm]");
            Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash test md5");
            Main.consoleUtils.consoleLog("List of algorithmes [base64, base58, aes, bcrypt, crc16, md4, md5, ntlm, ripemd16, sha1, sha256, whirlpool]");

        //hash process
        } else if (args[0].equalsIgnoreCase("hash")) {
            if (args[1].isEmpty()) {
                Main.consoleUtils.consoleLog("Error text value is empty");
            } else {
                if (args[2].equalsIgnoreCase("bcrypt")) {
                    if (args.length <= 3) {
                        Main.consoleUtils.consoleLog("Please type cost value for bcrypt");
                        Main. consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash test bcrypt 10");
                    } else {
                        String hash = BCryptHash.createBcrypt(args[1], Integer.parseInt(args[3]));
                        Main.consoleUtils.consoleLog("Bcrypt hash from " + args[1] + " is " + hash);
                    }
                } else if (args[2].equalsIgnoreCase("crc16")) {
                    String hash = CRC16.generateCRC16(args[1]);
                    Main.consoleUtils.consoleLog("CRC16 hash from " + args[1] + " is " + hash);
                } else if (args[2].equalsIgnoreCase("base64")) {

                    if (args.length <= 3) {
                        Main.consoleUtils.consoleLog("Please select methode encode or decode");
                        Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text base64 encode/decode");
                    } else {
                        if (args[3].equalsIgnoreCase("encode")) {

                            String hash = BASE64.base64Encode(args[1]);
                            Main.consoleUtils.consoleLog("Encoded string: " + hash);

                        } else if (args[3].equalsIgnoreCase("decode")) {

                            String hash = BASE64.base64Decode(args[1]);
                            Main.consoleUtils.consoleLog("Decode string: " + hash);

                        } else {
                            Main.consoleUtils.consoleLog("Please select methode encode or decode");
                            Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text base64 encode/decode");
                        }
                    }

                } else if (args[2].equalsIgnoreCase("base58")) {

                    if (args.length <= 3) {
                        Main.consoleUtils.consoleLog("Please select methode encode or decode");
                        Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text base58 encode/decode");
                    } else {
                        if (args[3].equalsIgnoreCase("encode")) {

                            String hash = BASE58.encode(args[1].getBytes());
                            Main.consoleUtils.consoleLog("Encoded string: " + hash);

                        } else if (args[3].equalsIgnoreCase("decode")) {

                            String hash = new String(BASE58.decode(args[1]));
                            Main.consoleUtils.consoleLog("Decode string: " + hash);

                        } else {
                            Main.consoleUtils.consoleLog("Please select methode encode or decode");
                            Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text base58 encode/decode");
                        }
                    }

                }  else if (args[2].equalsIgnoreCase("aes")) {


                    if (args.length <= 3) {
                        Main.consoleUtils.consoleLog("Please select methode encode or decode");
                        Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text aes encode/decode key");
                    } else {
                        if (args[3].equalsIgnoreCase("encode")) {

                            if (args.length <= 4) {
                                Main.consoleUtils.consoleLog("Please select encryption key");
                                Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text aes encode/decode key");
                            } else {
                                String hash = AES.encryptAES(args[1], args[4]);
                                Main.consoleUtils.consoleLog("Encoded string: " + hash);
                            }

                        } else if (args[3].equalsIgnoreCase("decode")) {

                            if (args.length <= 4) {
                                Main.consoleUtils.consoleLog("Please select encryption key");
                                Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text aes encode/decode key");
                            } else {
                                String hash = AES.decryptAES(args[1], args[4]);
                                Main.consoleUtils.consoleLog("Decoded string: " + hash);
                            }
                        } else {
                            Main.consoleUtils.consoleLog("Please select methode encode or decode");
                            Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash text aes encode/decode key");
                        }
                    }
                }  else if (args[2].equalsIgnoreCase("md4")) {
                    String hash = MD4.createMD4(args[1]);
                    Main.consoleUtils.consoleLog("MD4 hash from " + args[1] + " is " + hash);
                }  else if (args[2].equalsIgnoreCase("md5")) {
                    String hash = MD5.createMD5(args[1]);
                    Main.consoleUtils.consoleLog("MD5 hash from " + args[1] + " is " + hash);
                } else if (args[2].equalsIgnoreCase("ntlm")) {
                    String hash = NTLM.generateNTLM(args[1]);
                    Main.consoleUtils.consoleLog("NTLM hash from " + args[1] + " is " + hash);
                } else if (args[2].equalsIgnoreCase("ripemd16")) {
                    String hash = RIPEMD160.generateRIPME160(args[1]);
                    Main.consoleUtils.consoleLog("RIPEMD160 hash from " + args[1] + " is " + hash);
                } else if (args[2].equalsIgnoreCase("sha1")) {
                    String hash = SHA1.createSHA1(args[1]);
                    Main.consoleUtils.consoleLog("SHA1 hash from " + args[1] + " is " + hash);
                } else if (args[2].equalsIgnoreCase("sha256")) {
                    if (args.length <= 3) {
                        Main.consoleUtils.consoleLog("Please type salt value for sha256");
                        Main.consoleUtils.consoleLog("Example usage: java -jar crypter.jar hash test sha256 salt");
                    } else {
                        String hash = SHA256.createSHA256(args[1], args[3]);
                        Main.consoleUtils.consoleLog("SHA256 hash from " + args[1] + " is " + hash);
                    }
                } else if (args[2].equalsIgnoreCase("whirlpool")) {
                    String hash = Whirlpool.createWhirlpool(args[1]);
                    Main.consoleUtils.consoleLog("Whirlpool hash from " + args[1] + " is " + hash);
                } else {
                    Main.consoleUtils.consoleLog(args[2] + " not found list of algorithmes [base64 base58, aes, bcrypt, crc16, md4, md5, ntlm, ripemd16, sha1, sha256, whirlpool]");
                }
            }
        } else {
            Main.consoleUtils.consoleLog("Argument not found... type help");
        }
    }
}
