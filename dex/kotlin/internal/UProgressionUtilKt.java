package kotlin.internal;

import androidx.collection.MutableFloatFloatMap$;
import kntr.common.ouro.core.utils.ConverterUtilsKt$;
import kotlin.Metadata;
import kotlin.UByte$;
import kotlin.UInt;
import kotlin.ULong;

/* compiled from: UProgressionUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    private static final int m1092differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int ac = UByte$.ExternalSyntheticBackport1.m(i, i3);
        int bc = UByte$.ExternalSyntheticBackport1.m(i2, i3);
        return UInt.constructor-impl(ConverterUtilsKt$.ExternalSyntheticBackport0.m(ac, bc) >= 0 ? ac - bc : UInt.constructor-impl(ac - bc) + i3);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    private static final long m1093differenceModulosambcqE(long j, long j2, long j3) {
        long ac = UByte$.ExternalSyntheticBackport2.m(j, j3);
        long bc = UByte$.ExternalSyntheticBackport2.m(j2, j3);
        return ULong.constructor-impl(MutableFloatFloatMap$.ExternalSyntheticBackport0.m(ac, bc) >= 0 ? ac - bc : ULong.constructor-impl(ac - bc) + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m1095getProgressionLastElementNkh28Cs(int i, int i2, int step) {
        if (step > 0) {
            if (ConverterUtilsKt$.ExternalSyntheticBackport0.m(i, i2) < 0) {
                return UInt.constructor-impl(i2 - m1092differenceModuloWZ9TVnA(i2, i, UInt.constructor-impl(step)));
            }
        } else if (step >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else {
            if (ConverterUtilsKt$.ExternalSyntheticBackport0.m(i, i2) > 0) {
                return UInt.constructor-impl(m1092differenceModuloWZ9TVnA(i, i2, UInt.constructor-impl(-step)) + i2);
            }
        }
        return i2;
    }

    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m1094getProgressionLastElement7ftBX0g(long j, long j2, long step) {
        if (step > 0) {
            if (MutableFloatFloatMap$.ExternalSyntheticBackport0.m(j, j2) < 0) {
                return ULong.constructor-impl(j2 - m1093differenceModulosambcqE(j2, j, ULong.constructor-impl(step)));
            }
        } else if (step >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else {
            if (MutableFloatFloatMap$.ExternalSyntheticBackport0.m(j, j2) > 0) {
                return ULong.constructor-impl(m1093differenceModulosambcqE(j, j2, ULong.constructor-impl(-step)) + j2);
            }
        }
        return j2;
    }
}