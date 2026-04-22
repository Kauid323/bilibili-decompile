package tv.danmaku.bili.report;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tv.danmaku.bili.BR;

final class SimpleSerialization {
    SimpleSerialization() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeInt(OutputStream os, int n) throws IOException {
        os.write((n >>> 0) & BR.hallCover);
        os.write((n >>> 8) & BR.hallCover);
        os.write((n >>> 16) & BR.hallCover);
        os.write((n >>> 24) & BR.hallCover);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int readInt(InputStream is) throws IOException {
        byte[] aInt = new byte[4];
        int count = is.read(aInt);
        if (count != 4) {
            throw new EOFException();
        }
        int n = ((aInt[0] & 255) << 0) + ((aInt[1] & 255) << 8) + ((aInt[2] & 255) << 16) + ((aInt[3] & 255) << 24);
        return n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeLong(OutputStream os, long n) throws IOException {
        os.write((byte) (n >>> 0));
        os.write((byte) (n >>> 8));
        os.write((byte) (n >>> 16));
        os.write((byte) (n >>> 24));
        os.write((byte) (n >>> 32));
        os.write((byte) (n >>> 40));
        os.write((byte) (n >>> 48));
        os.write((byte) (n >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long readLong(InputStream is) throws IOException {
        byte[] aLong = new byte[8];
        int count = is.read(aLong);
        if (count == 8) {
            long n = ((aLong[0] & 255) << 0) + ((aLong[1] & 255) << 8) + ((aLong[2] & 255) << 16) + ((aLong[3] & 255) << 24) + ((aLong[4] & 255) << 32) + ((aLong[5] & 255) << 40) + ((aLong[6] & 255) << 48) + ((aLong[7] & 255) << 56);
            return n;
        }
        throw new EOFException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeString(OutputStream os, String s) throws IOException {
        byte[] b = s.getBytes("UTF-8");
        int length = b.length;
        writeLong(os, length);
        os.write(b, 0, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readString(InputStream is) throws IOException {
        int n = (int) readLong(is);
        if (n < 0) {
            throw new IOException();
        }
        if (n == 0) {
            return "";
        }
        byte[] b = streamToBytes(is, n);
        return new String(b, "UTF-8");
    }

    private static byte[] streamToBytes(InputStream in, int length) throws IOException {
        try {
            byte[] bytes = new byte[length];
            int pos = 0;
            while (pos < length) {
                int count = in.read(bytes, pos, length - pos);
                if (count == -1) {
                    break;
                }
                pos += count;
            }
            if (pos != length) {
                throw new IOException("Expected " + length + " bytes, read " + pos + " bytes");
            }
            return bytes;
        } catch (OutOfMemoryError e) {
            throw new IOException("Required too large buffer!");
        }
    }
}