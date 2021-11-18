package xyz.becvar.crypter.cryptes.hashes;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptHash {

    //Generate Bcrypt hash from text
    public static String createBcrypt(String clearText, int saltRouds) {
        return BCrypt.hashpw(clearText, BCrypt.gensalt(saltRouds));
    }
}
