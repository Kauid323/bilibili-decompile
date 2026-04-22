package kotlin;

import androidx.collection.MutableFloatFloatMap$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: UnsignedJVM.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0001\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0001\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0015\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0001\u001a\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010#\u001a\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0019\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0018\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0000¨\u0006("}, d2 = {"uintRemainder", "Lkotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", "", "ulongCompare", "", "uintToULong", "value", "(I)J", "uintToLong", "uintToFloat", "", "floatToUInt", "(F)I", "uintToDouble", "", "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", "", "base", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UnsignedKt {
    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m2988uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m2731constructorimpl((int) ((i & 4294967295L) % (4294967295L & i2)));
    }

    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m2987uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m2731constructorimpl((int) ((i & 4294967295L) / (4294967295L & i2)));
    }

    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m2989ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ULong.m2810constructorimpl(MutableFloatFloatMap$.ExternalSyntheticBackport0.m(j, j2) >= 0 ? 1L : 0L);
        } else if (j >= 0) {
            return ULong.m2810constructorimpl(j / j2);
        } else {
            long quotient = ((j >>> 1) / j2) << 1;
            long rem = j - (quotient * j2);
            return ULong.m2810constructorimpl((MutableFloatFloatMap$.ExternalSyntheticBackport0.m(ULong.m2810constructorimpl(rem), ULong.m2810constructorimpl(j2)) < 0 ? 0 : 1) + quotient);
        }
    }

    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m2990ulongRemaindereb3DHEI(long j, long j2) {
        long j3 = 0;
        if (j2 < 0) {
            if (MutableFloatFloatMap$.ExternalSyntheticBackport0.m(j, j2) < 0) {
                return j;
            }
            return ULong.m2810constructorimpl(j - j2);
        } else if (j >= 0) {
            return ULong.m2810constructorimpl(j % j2);
        } else {
            long quotient = ((j >>> 1) / j2) << 1;
            long rem = j - (quotient * j2);
            if (MutableFloatFloatMap$.ExternalSyntheticBackport0.m(ULong.m2810constructorimpl(rem), ULong.m2810constructorimpl(j2)) >= 0) {
                j3 = j2;
            }
            return ULong.m2810constructorimpl(rem - j3);
        }
    }

    public static final int uintCompare(int v1, int v2) {
        return Intrinsics.compare(v1 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ v2);
    }

    public static final int ulongCompare(long v1, long v2) {
        return Intrinsics.compare(v1 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ v2);
    }

    private static final long uintToULong(int value) {
        return ULong.m2810constructorimpl(value & 4294967295L);
    }

    private static final long uintToLong(int value) {
        return value & 4294967295L;
    }

    private static final float uintToFloat(int value) {
        return (float) uintToDouble(value);
    }

    private static final int floatToUInt(float value) {
        return doubleToUInt(value);
    }

    public static final double uintToDouble(int value) {
        return (Integer.MAX_VALUE & value) + (((value >>> 31) << 30) * 2);
    }

    public static final int doubleToUInt(double value) {
        if (!Double.isNaN(value) && value > uintToDouble(0)) {
            if (value >= uintToDouble(-1)) {
                return -1;
            }
            return value <= 2.147483647E9d ? UInt.m2731constructorimpl((int) value) : UInt.m2731constructorimpl(UInt.m2731constructorimpl((int) (value - ((double) FlowControlConfig.RETRY_MAX_TIMES))) + UInt.m2731constructorimpl(FlowControlConfig.RETRY_MAX_TIMES));
        }
        return 0;
    }

    private static final float ulongToFloat(long value) {
        return (float) ulongToDouble(value);
    }

    private static final long floatToULong(float value) {
        return doubleToULong(value);
    }

    public static final double ulongToDouble(long value) {
        return ((value >>> 11) * 2048) + (2047 & value);
    }

    public static final long doubleToULong(double value) {
        if (!Double.isNaN(value) && value > ulongToDouble(0L)) {
            if (value >= ulongToDouble(-1L)) {
                return -1L;
            }
            return value < 9.223372036854776E18d ? ULong.m2810constructorimpl((long) value) : ULong.m2810constructorimpl(ULong.m2810constructorimpl((long) (value - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    private static final String uintToString(int value) {
        return String.valueOf(value & 4294967295L);
    }

    private static final String uintToString(int value, int base) {
        return ulongToString(value & 4294967295L, base);
    }

    private static final String ulongToString(long value) {
        return ulongToString(value, 10);
    }

    public static final String ulongToString(long value, int base) {
        if (value >= 0) {
            String l = Long.toString(value, CharsKt.checkRadix(base));
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            return l;
        }
        long quotient = ((value >>> 1) / base) << 1;
        long rem = value - (base * quotient);
        if (rem >= base) {
            rem -= base;
            quotient++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(quotient, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(l2, "toString(...)");
        StringBuilder append = sb.append(l2);
        String l3 = Long.toString(rem, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(l3, "toString(...)");
        return append.append(l3).toString();
    }
}