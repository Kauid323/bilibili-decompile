package c.t.m.g;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: TML */
public class h3 {
    public static Cipher a(byte[] bArr, byte[] bArr2, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return b(bArr, 0, bArr.length, bArr2, bArr3);
    }

    public static byte[] b(byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3) {
        return a(bArr, i, i2, bArr2, bArr3, 1);
    }

    public static byte[] b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        try {
            byte[] a = k3.a(16);
            byte[] a2 = a(bArr, i, i2, a, a, 1);
            if (d4.a(a2)) {
                return a2;
            }
            byte[] bArr2 = new byte[a.length + a2.length];
            System.arraycopy(a, 0, bArr2, 0, a.length);
            System.arraycopy(a2, 0, bArr2, a.length, a2.length);
            return bArr2;
        } catch (Throwable th) {
            w3.a("Encrypt2Util", "encrypt error.", th);
            return v2.a;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3, int i3) {
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0 && i >= 0 && i2 > 0) {
            try {
                Cipher a = a(bArr2, bArr3, i3);
                if (a == null) {
                    return v2.a;
                }
                return a.doFinal(bArr, i, i2);
            } catch (Throwable th) {
                w3.a("Encrypt2Util", "en-de crypt error.", th);
                return v2.a;
            }
        }
        return v2.a;
    }

    public static String b(String str) {
        try {
            return w2.a(b(str.getBytes(com.alipay.sdk.m.o.a.z)));
        } catch (Throwable th) {
            w3.a("Encrypt2Util", "enc aes base64 error.", th);
            return "";
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(bArr, 0, bArr.length, bArr2, bArr3);
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3) {
        return a(bArr, i, i2, bArr2, bArr3, 2);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return a(bArr, i + 16, i2 - 16, bArr2, bArr2, 2);
    }

    public static String a(String str) {
        try {
            return new String(a(w2.a(str)), com.alipay.sdk.m.o.a.z);
        } catch (Throwable th) {
            w3.a("Encrypt2Util", "dec aes base64 error.", th);
            return "";
        }
    }
}