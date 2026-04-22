package c.t.m.g;

/* compiled from: TML */
public class x2 {
    public static void a(byte[] bArr, int i, boolean z) {
        if (z) {
            int i2 = i / 8;
            bArr[i2] = (byte) ((1 << (i % 8)) | bArr[i2]);
            return;
        }
        int i3 = i / 8;
        bArr[i3] = (byte) ((~(1 << (i % 8))) & bArr[i3]);
    }

    public static boolean a(byte[] bArr, int i) {
        return (bArr[i / 8] & (1 << (i % 8))) != 0;
    }
}