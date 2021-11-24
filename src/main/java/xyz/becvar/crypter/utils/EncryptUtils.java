package xyz.becvar.crypter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptUtils {

    private final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    //Move bytes to hex code
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }



    //Check if string encoded in base64
    public static boolean checkForEncodeBase64(String string) {
        String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(string);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }
}
