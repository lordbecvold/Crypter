package xyz.becvar.crypter.cryptes.hashes;

import jcifs.smb.NtlmPasswordAuthentication;
import xyz.becvar.crypter.utils.EncryptUtils;

/**
 * NTLM passwords encoding.
 * This implementation depends on the JCIFS library.
 */
public class NTLM {

    //Generate NTLM hash from string
    public static String generateNTLM(String value) {
        String s = (value != null) ? value : "";
        byte[] hash = NtlmPasswordAuthentication.nTOWFv1(s);
        return new EncryptUtils().bytesToHex(hash).toUpperCase();
    }
}
