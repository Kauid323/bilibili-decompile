package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: utfEncoding.kt */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        int i = 0;
        for (String it : strings) {
            i += it.length();
        }
        int resultLength = i;
        byte[] result = new byte[resultLength];
        int i2 = 0;
        for (String s : strings) {
            int si = 0;
            int length = s.length();
            while (si < length) {
                result[i2] = (byte) s.charAt(si);
                si++;
                i2++;
            }
        }
        if (i2 == result.length) {
            return result;
        }
        throw new AssertionError("Should have reached the end");
    }
}