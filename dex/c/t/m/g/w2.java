package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: TML */
public class w2 {
    public static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
            stringBuffer.append(a[(i4 >> 18) & 63]);
            stringBuffer.append(a[(i4 >> 12) & 63]);
            stringBuffer.append(a[(i4 >> 6) & 63]);
            stringBuffer.append(a[i4 & 63]);
            i2 += 3;
            i3 = i3 >= 14 ? 0 : i3 + 1;
        }
        int i5 = 0 + length;
        if (i2 == i5 - 2) {
            int i6 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            stringBuffer.append(a[(i6 >> 18) & 63]);
            stringBuffer.append(a[(i6 >> 12) & 63]);
            stringBuffer.append(a[(i6 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == i5 - 1) {
            int i7 = (bArr[i2] & 255) << 16;
            stringBuffer.append(a[(i7 >> 18) & 63]);
            stringBuffer.append(a[(i7 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static int a(char c2) {
        int i;
        if (c2 < 'A' || c2 > 'Z') {
            if (c2 >= 'a' && c2 <= 'z') {
                i = c2 - 'a';
            } else if (c2 < '0' || c2 > '9') {
                if (c2 != '+') {
                    if (c2 != '/') {
                        if (c2 == '=') {
                            return 0;
                        }
                        throw new RuntimeException("unexpected code: " + c2);
                    }
                    return 63;
                }
                return 62;
            } else {
                i = (c2 - '0') + 26;
            }
            return i + 26;
        }
        return c2 - 'A';
    }

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                System.err.println("Error while decoding BASE64: " + e.toString());
            }
            return byteArray;
        } catch (IOException e2) {
            throw new RuntimeException();
        }
    }

    public static void a(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else if (i == length) {
                return;
            } else {
                int i2 = i + 2;
                int i3 = i + 3;
                int a2 = (a(str.charAt(i)) << 18) + (a(str.charAt(i + 1)) << 12) + (a(str.charAt(i2)) << 6) + a(str.charAt(i3));
                outputStream.write((a2 >> 16) & 255);
                if (str.charAt(i2) == '=') {
                    return;
                }
                outputStream.write((a2 >> 8) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write(a2 & 255);
                i += 4;
            }
        }
    }
}