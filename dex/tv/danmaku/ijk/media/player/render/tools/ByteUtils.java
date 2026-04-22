package tv.danmaku.ijk.media.player.render.tools;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ByteUtils {
    public static final boolean IS_BIG_ENDING = isBigendian();

    public static byte[] getBytes(short data) {
        byte[] bytes = {(byte) (data & 255), (byte) ((65280 & data) >> 8)};
        return bytes;
    }

    public static byte[] getBytes(char data) {
        byte[] bytes = {(byte) data, (byte) (data >> '\b')};
        return bytes;
    }

    public static byte[] getBytes(int data) {
        byte[] bytes = {(byte) (data & 255), (byte) ((65280 & data) >> 8), (byte) ((16711680 & data) >> 16), (byte) (((-16777216) & data) >> 24)};
        return bytes;
    }

    public static byte[] getBytes(long data) {
        byte[] bytes = {(byte) (data & 255), (byte) ((data >> 8) & 255), (byte) ((data >> 16) & 255), (byte) ((data >> 24) & 255), (byte) ((data >> 32) & 255), (byte) ((data >> 40) & 255), (byte) ((data >> 48) & 255), (byte) (255 & (data >> 56))};
        return bytes;
    }

    public static byte[] getBytes(float data) {
        int intBits = Float.floatToIntBits(data);
        return getBytes(intBits);
    }

    public static byte[] getBytes(double data) {
        long intBits = Double.doubleToLongBits(data);
        return getBytes(intBits);
    }

    public static byte[] getBytes(String data, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        return data.getBytes(charset);
    }

    public static byte[] getBytes(String data) {
        return getBytes(data, "UTF-8");
    }

    public static short getShort(byte[] bytes) {
        return (short) ((bytes[0] & 255) | ((bytes[1] << 8) & 65280));
    }

    public static char getChar(byte[] bytes) {
        return (char) ((bytes[0] & 255) | ((bytes[1] << 8) & 65280));
    }

    public static int getInt(byte[] bytes) {
        return (bytes[0] & 255) | ((bytes[1] << 8) & 65280) | ((bytes[2] << 16) & 16711680) | ((bytes[3] << 24) & (-16777216));
    }

    public static int getIntFill(byte[] bytes) {
        return (bytes[3] & 255) | ((bytes[2] << 8) & 65280) | ((bytes[1] << 16) & 16711680) | ((bytes[0] << 24) & (-16777216));
    }

    public static long getLong(byte[] bytes) {
        return (bytes[0] & 255) | ((bytes[1] << 8) & 65280) | ((bytes[2] << 16) & 16711680) | ((bytes[3] << 24) & 4278190080L) | ((bytes[4] << 32) & 1095216660480L) | ((bytes[5] << 40) & 280375465082880L) | ((bytes[6] << 48) & 71776119061217280L) | ((bytes[7] << 56) & (-72057594037927936L));
    }

    public static float getFloat(byte[] bytes) {
        return Float.intBitsToFloat(getInt(bytes));
    }

    public static double getDouble(byte[] bytes) {
        long l = getLong(bytes);
        System.out.println(l);
        return Double.longBitsToDouble(l);
    }

    public static String getString(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    public static String getString(byte[] bytes) {
        return getString(bytes, "UTF-8");
    }

    public static byte[] randomBytes(int length) {
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) Math.ceil(Math.random() * 256.0d);
        }
        return bytes;
    }

    public static void intToByteArrayFull(byte[] dst, int pos, int interger) {
        dst[pos] = (byte) ((interger >> 24) & 255);
        dst[pos + 1] = (byte) ((interger >> 16) & 255);
        dst[pos + 2] = (byte) ((interger >> 8) & 255);
        dst[pos + 3] = (byte) (interger & 255);
    }

    public static void intToByteArrayTwoByte(byte[] dst, int pos, int interger) {
        dst[pos] = (byte) ((interger >> 8) & 255);
        dst[pos + 1] = (byte) (interger & 255);
    }

    public static short getShort(byte firstByte, byte secondByte, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            short shortValue = (short) ((firstByte & 255) | 0);
            return (short) ((secondByte & 255) | ((short) (shortValue << 8)));
        }
        short shortValue2 = (short) ((secondByte & 255) | 0);
        return (short) ((firstByte & 255) | ((short) (shortValue2 << 8)));
    }

    public static byte[] getBytes(short shortValue, ByteOrder order) {
        byte[] byteArray = new byte[2];
        if (order == ByteOrder.BIG_ENDIAN) {
            byteArray[1] = (byte) (shortValue & 255);
            byteArray[0] = (byte) (((short) (shortValue >> 8)) & 255);
        } else {
            byteArray[0] = (byte) (shortValue & 255);
            byteArray[1] = (byte) (((short) (shortValue >> 8)) & 255);
        }
        return byteArray;
    }

    public static short[] getShorts(byte[] bytes, ByteOrder order) {
        if (bytes == null || bytes.length % 2 != 0) {
            return null;
        }
        short[] shorts = new short[bytes.length / 2];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = getShort(bytes[i * 2], bytes[(i * 2) + 1], order);
        }
        return shorts;
    }

    public static byte[] getBytes(short[] shorts, ByteOrder order) {
        if (shorts == null) {
            return null;
        }
        byte[] byteArray = new byte[shorts.length * 2];
        for (int i = 0; i < shorts.length; i++) {
            byte[] tmp = getBytes(shorts[i], order);
            byteArray[i * 2] = tmp[0];
            byteArray[(i * 2) + 1] = tmp[1];
        }
        return byteArray;
    }

    public static short safeShort(int value) {
        return (short) Math.max(Math.min(value, 32767), -32768);
    }

    public static short[] safeShorts(int[] value) {
        if (value == null) {
            return null;
        }
        short[] shorts = new short[value.length];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = safeShort(value[i]);
        }
        return shorts;
    }

    public static boolean isBigendian() {
        boolean bRet = (1 >> 8) == 1;
        return bRet;
    }
}