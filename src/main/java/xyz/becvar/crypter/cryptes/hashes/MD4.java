package xyz.becvar.crypter.cryptes.hashes;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class MD4 {

    //Generate MD4 hash
    public static String createMD4(String string) {
        Security.addProvider(new BouncyCastleProvider());

        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("MD4");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        crypt.update(string.getBytes(StandardCharsets.UTF_8));
        return Hex.toHexString(crypt.digest());
    }

}
