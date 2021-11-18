package xyz.becvar.crypter.cryptes.hashes;

import org.bouncycastle.crypto.digests.WhirlpoolDigest;
import org.bouncycastle.util.encoders.Hex;

public class Whirlpool {

    public static String createWhirlpool(String string) {
        WhirlpoolDigest messageDigest = new WhirlpoolDigest();

        messageDigest.reset();
        final byte[] bytes = string.getBytes();
        messageDigest.update(bytes, 0, bytes.length);

        byte[] hash = new byte[messageDigest.getDigestSize()];

        messageDigest.doFinal(hash, 0);

        return Hex.toHexString(hash);
    }
}
