import org.junit.Assert;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import xyz.becvar.crypter.cryptes.hashes.BCryptHash;

public class HashTest {

    @Test
    public void testBcrypt() {
        boolean val = BCrypt.checkpw("test", BCryptHash.createBcrypt("test", 5));
        Assert.assertEquals(true, val);
    }

    @Test
    public void testCRC16() {
        String CRC16 = xyz.becvar.crypter.cryptes.hashes.CRC16.generateCRC16("test");
        Assert.assertEquals("9516", CRC16);
    }

    @Test
    public void testMD4() {
        String MD4 = xyz.becvar.crypter.cryptes.hashes.MD4.createMD4("test");
        Assert.assertEquals("db346d691d7acc4dc2625db19f9e3f52", MD4);
    }

    @Test
    public void testMD5() {
        String MD5 = xyz.becvar.crypter.cryptes.hashes.MD5.createMD5("test");
        Assert.assertEquals("098f6bcd4621d373cade4e832627b4f6", MD5);
    }

    @Test
    public void testNTLM() {
        String NTLM = xyz.becvar.crypter.cryptes.hashes.NTLM.generateNTLM("test");
        Assert.assertEquals("0CB6948805F797BF2A82807973B89537", NTLM);
    }

    @Test
    public void testSHA1() {
        String SHA1 = xyz.becvar.crypter.cryptes.hashes.SHA1.createSHA1("test");
        Assert.assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", SHA1);
    }

    @Test
    public void testSHA256() {
        String SHA256 = xyz.becvar.crypter.cryptes.hashes.SHA256.createSHA256("test", "salt");
        Assert.assertEquals("4edf07edc95b2fdcbcaf2378fd12d8ac212c2aa6e326c59c3e629be3039d6432", SHA256);
    }

    @Test
    public void testWhirlpool() {
        String Whirlpool = xyz.becvar.crypter.cryptes.hashes.Whirlpool.createWhirlpool("test");
        Assert.assertEquals("b913d5bbb8e461c2c5961cbe0edcdadfd29f068225ceb37da6defcf89849368f8c6c2eb6a4c4ac75775d032a0ecfdfe8550573062b653fe92fc7b8fb3b7be8d6", Whirlpool);
    }

    @Test
    public void testBase64Encode() {
        String BASE64 = xyz.becvar.crypter.cryptes.encryptions.BASE64.base64Encode("test");
        Assert.assertEquals("dGVzdA==", BASE64);
    }

    @Test
    public void testBase64Decode() {
        String BASE64 = xyz.becvar.crypter.cryptes.encryptions.BASE64.base64Decode("dGVzdA==");
        Assert.assertEquals("test", BASE64);
    }

    @Test
    public void testBase58Encode() {
        String BASE58 = xyz.becvar.crypter.cryptes.encryptions.BASE58.encode("test".getBytes());
        Assert.assertEquals("3yZe7d", BASE58);
    }

    @Test
    public void testBase58Decode() {
        String BASE58 = new String(xyz.becvar.crypter.cryptes.encryptions.BASE58.decode("3yZe7d"));
        Assert.assertEquals("test", BASE58);
    }

    @Test
    public void testAESEncode() {
        String AES = xyz.becvar.crypter.cryptes.encryptions.AES.encryptAES("test", "123");
        Assert.assertEquals("7/K+Pp/bAKsiqOD/8B4OqA==", AES);
    }

    @Test
    public void testAESDecode() {
        String AES = xyz.becvar.crypter.cryptes.encryptions.AES.decryptAES("7/K+Pp/bAKsiqOD/8B4OqA==", "123");
        Assert.assertEquals("test", AES);
    }
}
