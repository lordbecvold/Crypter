package xyz.becvar.crypter.cryptes.hashes;

public class CRC16 {

    //Generate crc16 from string
    public static String generateCRC16(String string) {
        Integer crcRes = crc16(string.getBytes());
        return Integer.toHexString(crcRes);
    }

    private static int crc16(final byte[] buffer) {
        /* Note the change here */
        int crc = 0x1D0F;
        for (int j = 0; j < buffer.length ; j++) {
            crc = ((crc  >>> 8) | (crc  << 8) )& 0xffff;
            crc ^= (buffer[j] & 0xff);//byte to int, trunc sign
            crc ^= ((crc & 0xff) >> 4);
            crc ^= (crc << 12) & 0xffff;
            crc ^= ((crc & 0xFF) << 5) & 0xffff;
        }
        crc &= 0xffff;
        return crc;
    }
}
