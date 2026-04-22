package c.t.m.g;

/* compiled from: TML */
public class z2 {
    public static byte[] a(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() != 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}