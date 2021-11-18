package xyz.becvar.crypter.cryptes.encryptions;

import java.nio.charset.Charset;
import java.util.Base64;

public class BASE64 {

    //Function for encode base64
    public static String base64Encode(String string) {
        byte[] encodedBytes = Base64.getEncoder().encode(string.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    //Function for decode string with base64
    public static String base64Decode(String string) {
        byte[] decodedBytes = Base64.getDecoder().decode(string.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }
}
