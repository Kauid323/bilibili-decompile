package shark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: HPPC.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lshark/internal/hppc/HPPC;", "", "()V", "MAX_HASH_ARRAY_LENGTH", "", "MIN_HASH_ARRAY_LENGTH", "PHI_C64", "", "expandAtCount", "arraySize", "loadFactor", "", "minBufferSize", "elements", "mixPhi", "k", "nextBufferSize", "nextHighestPowerOfTwo", "input", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class HPPC {
    public static final HPPC INSTANCE = new HPPC();
    private static final int MAX_HASH_ARRAY_LENGTH = 1073741824;
    private static final int MIN_HASH_ARRAY_LENGTH = 4;
    private static final long PHI_C64 = -7046029254386353131L;

    private HPPC() {
    }

    public final int mixPhi(long k) {
        long h = PHI_C64 * k;
        return (int) ((h >>> 32) ^ h);
    }

    public final int minBufferSize(int elements, double loadFactor) {
        long length = (long) Math.ceil(elements / loadFactor);
        if (length == elements) {
            length++;
        }
        long length2 = Math.max(4, nextHighestPowerOfTwo(length));
        if (length2 > ((long) MAX_HASH_ARRAY_LENGTH)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(new Object[]{Integer.valueOf(elements), Double.valueOf(loadFactor)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format);
        }
        return (int) length2;
    }

    public final long nextHighestPowerOfTwo(long input) {
        long v = input - 1;
        long v2 = v | (v >> 1);
        long v3 = v2 | (v2 >> 2);
        long v4 = v3 | (v3 >> 4);
        long v5 = v4 | (v4 >> 8);
        long v6 = v5 | (v5 >> 16);
        return (v6 | (v6 >> 32)) + 1;
    }

    public final int expandAtCount(int arraySize, double loadFactor) {
        return Math.min(arraySize - 1, (int) Math.ceil(arraySize * loadFactor));
    }

    public final int nextBufferSize(int arraySize, int elements, double loadFactor) {
        if (arraySize == MAX_HASH_ARRAY_LENGTH) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(new Object[]{Integer.valueOf(elements), Double.valueOf(loadFactor)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format);
        }
        return arraySize << 1;
    }
}