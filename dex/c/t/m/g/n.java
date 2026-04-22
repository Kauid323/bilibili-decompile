package c.t.m.g;

import android.util.Base64;

/* compiled from: TML */
public class n {
    public static final byte[] a = new byte[0];

    public static byte[] a(String str) {
        try {
            return a(str.getBytes(com.alipay.sdk.m.o.a.z), 4);
        } catch (Throwable th) {
            w3.b("SosoLocUtils", th.toString());
            return a;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] a2 = c3.a(bArr);
        String a3 = i3.a("fc_base");
        if (d4.a(a3)) {
            w3.b("SosoLocUtils", "get pwd empty.");
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i == 4) {
                    byte[] a4 = i3.a(a2, a3);
                    if (!d4.a(a4)) {
                        byte[] encode = Base64.encode(a4, 2);
                        if (!d4.a(encode)) {
                            return encode;
                        }
                    }
                    return a;
                }
                return a;
            }
            a2 = i3.a(a2, a3);
        }
        if (d4.a(a2)) {
            w3.b("SosoLocUtils", "encrypt failed");
            return a;
        }
        byte[] bArr2 = new byte[a2.length + 2];
        System.arraycopy(a(a2.length), 0, bArr2, 0, 2);
        System.arraycopy(a2, 0, bArr2, 2, a2.length);
        return bArr2;
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[2];
        for (int i2 = 0; i2 < 2; i2++) {
            bArr[i2] = Integer.valueOf(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }
}