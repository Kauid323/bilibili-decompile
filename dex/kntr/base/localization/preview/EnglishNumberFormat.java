package kntr.base.localization.preview;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.preview.Units;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyNumberFormat.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001aHÖ\u0001J\t\u0010\"\u001a\u00020\u0015HÖ\u0001R.\u0010\u0004\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t0\u0005j\u0002`\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e0\u000ej\u0002`\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000ej\u0002`\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R>\u0010\u0018\u001a,\u0012\u0004\u0012\u00020\b\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00190\u000ej\u0002`\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/EnglishNumberFormat;", "Lkntr/base/localization/preview/NumberFormat;", "<init>", "()V", "thresholds", "", "Lkotlin/Pair;", "", "Lkntr/base/localization/preview/Units;", "Lkntr/base/localization/preview/Threshold;", "Lkntr/base/localization/preview/Thresholds;", "getThresholds", "()Ljava/util/List;", "rounding", "Lkotlin/Function1;", "", "Lkntr/base/localization/preview/Rounding;", "getRounding", "()Lkotlin/jvm/functions/Function1;", "suffix", "Lkotlin/Function0;", "", "Lkntr/base/localization/preview/Suffix;", "getSuffix", "carry", "Lkotlin/Function3;", "", "", "Lkntr/base/localization/preview/Carry;", "getCarry", "equals", "other", "", "hashCode", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EnglishNumberFormat extends NumberFormat {
    public static final EnglishNumberFormat INSTANCE = new EnglishNumberFormat();
    private static final Function1<Units, Function3<Long, Integer, Boolean, String>> carry;
    private static final Function1<Long, Function1<Double, Double>> rounding;
    private static final Function1<Units, Function0<String>> suffix;
    private static final List<Pair<Long, Units>> thresholds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EnglishNumberFormat) {
            EnglishNumberFormat englishNumberFormat = (EnglishNumberFormat) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -1694722939;
    }

    public String toString() {
        return "EnglishNumberFormat";
    }

    private EnglishNumberFormat() {
        super(null);
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public List<Pair<Long, Units>> getThresholds() {
        return thresholds;
    }

    static {
        Pair threshold;
        threshold = LegacyNumberFormatKt.toThreshold(Units.Thousands.INSTANCE, 10000L);
        thresholds = CollectionsKt.listOf(new Pair[]{threshold, LegacyNumberFormatKt.toThreshold$default(Units.Millions.INSTANCE, 0L, 1, null), LegacyNumberFormatKt.toThreshold$default(Units.Billions.INSTANCE, 0L, 1, null)});
        rounding = new Function1() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Function1 rounding$lambda$0;
                rounding$lambda$0 = EnglishNumberFormat.rounding$lambda$0(((Long) obj).longValue());
                return rounding$lambda$0;
            }
        };
        suffix = new Function1() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Function0 suffix$lambda$0;
                suffix$lambda$0 = EnglishNumberFormat.suffix$lambda$0((Units) obj);
                return suffix$lambda$0;
            }
        };
        carry = new Function1() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Function3 carry$lambda$0;
                carry$lambda$0 = EnglishNumberFormat.carry$lambda$0((Units) obj);
                return carry$lambda$0;
            }
        };
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public Function1<Long, Function1<Double, Double>> getRounding() {
        return rounding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 rounding$lambda$0(long it) {
        return it < 1000000 ? EnglishNumberFormat$rounding$1$1.INSTANCE : EnglishNumberFormat$rounding$1$2.INSTANCE;
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public Function1<Units, Function0<String>> getSuffix() {
        return suffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 suffix$lambda$0(Units it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, Units.Thousands.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda0
            public final Object invoke() {
                String suffix$lambda$0$0;
                suffix$lambda$0$0 = EnglishNumberFormat.suffix$lambda$0$0();
                return suffix$lambda$0$0;
            }
        } : Intrinsics.areEqual(it, Units.Millions.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda1
            public final Object invoke() {
                String suffix$lambda$0$1;
                suffix$lambda$0$1 = EnglishNumberFormat.suffix$lambda$0$1();
                return suffix$lambda$0$1;
            }
        } : Intrinsics.areEqual(it, Units.Billions.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda2
            public final Object invoke() {
                String suffix$lambda$0$2;
                suffix$lambda$0$2 = EnglishNumberFormat.suffix$lambda$0$2();
                return suffix$lambda$0$2;
            }
        } : new Function0() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda3
            public final Object invoke() {
                String suffix$lambda$0$3;
                suffix$lambda$0$3 = EnglishNumberFormat.suffix$lambda$0$3();
                return suffix$lambda$0$3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$0() {
        return "K";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$1() {
        return "M";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$2() {
        return "B";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$3() {
        return "";
    }

    @Override // kntr.base.localization.preview.NumberFormat
    /* renamed from: getCarry */
    public Function1<Units, Function3<Long, Integer, Boolean, String>> mo1632getCarry() {
        return carry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 carry$lambda$0(Units it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof Units.Thousands ? it : null) != null) {
            return new Function3() { // from class: kntr.base.localization.preview.EnglishNumberFormat$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    String carry$lambda$0$1$0;
                    carry$lambda$0$1$0 = EnglishNumberFormat.carry$lambda$0$1$0(((Long) obj).longValue(), ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
                    return carry$lambda$0$1$0;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String carry$lambda$0$1$0(long num, int digits, boolean trimEnd) {
        String format;
        format = LegacyNumberFormatKt.format(INSTANCE, num, digits, trimEnd);
        return format;
    }
}