package c.t.m.g;

import com.ashampoo.xmp.XMPConst;

/* compiled from: TML */
public class v2 {
    public static final byte[] a = new byte[0];

    public static String a(double[] dArr, int i, boolean z) {
        if (dArr == null) {
            return "null";
        }
        int length = dArr.length - 1;
        if (length == -1) {
            return z ? XMPConst.ARRAY_ITEM_NAME : "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('[');
        }
        int i2 = 0;
        while (true) {
            sb.append(b4.a(dArr[i2], i));
            if (i2 == length) {
                break;
            }
            sb.append(",");
            i2++;
        }
        if (z) {
            sb.append(']');
        }
        return sb.toString();
    }
}