package c.t.m.g;

import java.util.Random;

/* compiled from: TML */
public class k3 {
    public static final Random a = new Random();

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        a.nextBytes(bArr);
        return bArr;
    }
}