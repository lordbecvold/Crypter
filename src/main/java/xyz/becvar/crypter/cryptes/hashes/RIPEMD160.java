package xyz.becvar.crypter.cryptes.hashes;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RIPEMD160 {

    //Generate RIPEMD160 from input string
    public static String generateRIPME160(String string) {
        byte[] r = new byte[0];
        try {
            r = string.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RIPEMD160Digest d = new RIPEMD160Digest();
        d.update (r, 0, r.length);
        byte[] o = new byte[d.getDigestSize()];
        d.doFinal (o, 0);
        try {
            Hex.encode (o, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String finalhash = d.toString().substring(0,d.toString().indexOf("org"));

        return finalhash;
    }
}
