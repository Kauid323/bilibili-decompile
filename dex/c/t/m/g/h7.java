package c.t.m.g;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* compiled from: TML */
public class h7 {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(com.alipay.sdk.m.o.a.z));
            return a(messageDigest.digest(), "");
        } catch (Exception e) {
            return str;
        }
    }

    public static byte[] b(byte[] bArr) {
        int read;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[0];
        byte[] bArr3 = new byte[1024];
        int i = 0;
        do {
            try {
                read = inflaterInputStream.read(bArr3);
                if (read > 0) {
                    i += read;
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                    System.arraycopy(bArr3, 0, bArr4, bArr2.length, read);
                    bArr2 = bArr4;
                    continue;
                }
            } catch (Exception e) {
                return null;
            }
        } while (read > 0);
        try {
            byteArrayInputStream.close();
            inflaterInputStream.close();
            return bArr2;
        } catch (IOException e2) {
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString(b & 255)).append(str);
        }
        return sb.toString();
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}