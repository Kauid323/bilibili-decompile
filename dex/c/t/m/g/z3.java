package c.t.m.g;

import java.security.MessageDigest;

/* compiled from: TML */
public class z3 {
    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            bArr = str.getBytes(com.alipay.sdk.m.o.a.z);
        } catch (Throwable th) {
            bArr = null;
        }
        return a(bArr, str2);
    }

    public static String a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return z2.a(messageDigest.digest(), "");
        } catch (Throwable th) {
            if (w3.a()) {
                w3.a("MessageDigestUtil", "getMessageDigest[" + str + "] error.", th);
            }
            return "";
        }
    }
}