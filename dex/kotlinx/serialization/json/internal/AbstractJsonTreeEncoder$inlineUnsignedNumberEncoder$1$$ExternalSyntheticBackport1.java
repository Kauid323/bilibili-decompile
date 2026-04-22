package kotlinx.serialization.json.internal;

import com.bilibili.gripper.riskcontrol.RiskCollect$Companion$;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1$$ExternalSyntheticBackport1 {
    public static /* synthetic */ String m(long j, int i) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        i = (i < 2 || i > 36) ? 10 : 10;
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long m = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : RiskCollect$Companion$.ExternalSyntheticBackport0.m(j, i);
            long j2 = i;
            cArr[63] = Character.forDigit((int) (j - (m * j2)), i);
            i3 = 63;
            while (m > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (m % j2), i);
                m /= j2;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }
}