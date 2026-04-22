package kntr.base.localization.preview;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.preview.Units;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyNumberFormat.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0014HÖ\u0001R*\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\rj\u0002`\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\rj\u0002`\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lkntr/base/localization/preview/JapaneseNumberFormat;", "Lkntr/base/localization/preview/NumberFormat;", "<init>", "()V", "thresholds", "", "Lkotlin/Pair;", "", "Lkntr/base/localization/preview/Units;", "Lkntr/base/localization/preview/Threshold;", "getThresholds", "()Ljava/util/List;", "rounding", "Lkotlin/Function1;", "", "Lkntr/base/localization/preview/Rounding;", "getRounding", "()Lkotlin/jvm/functions/Function1;", "suffix", "Lkotlin/Function0;", "", "Lkntr/base/localization/preview/Suffix;", "getSuffix", "carry", "", "getCarry", "()Ljava/lang/Void;", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class JapaneseNumberFormat extends NumberFormat {
    private static final Void carry = null;
    public static final JapaneseNumberFormat INSTANCE = new JapaneseNumberFormat();
    private static final List<Pair<Long, Units>> thresholds = CollectionsKt.listOf(new Pair[]{LegacyNumberFormatKt.toThreshold$default(Units.TenThousands.INSTANCE, 0, 1, null), LegacyNumberFormatKt.toThreshold$default(Units.HundredMillions.INSTANCE, 0, 1, null)});
    private static final Function1<Long, Function1<Double, Double>> rounding = new Function1() { // from class: kntr.base.localization.preview.JapaneseNumberFormat$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            Function1 rounding$lambda$0;
            rounding$lambda$0 = JapaneseNumberFormat.rounding$lambda$0(((Long) obj).longValue());
            return rounding$lambda$0;
        }
    };
    private static final Function1<Units, Function0<String>> suffix = new Function1() { // from class: kntr.base.localization.preview.JapaneseNumberFormat$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            Function0 suffix$lambda$0;
            suffix$lambda$0 = JapaneseNumberFormat.suffix$lambda$0((Units) obj);
            return suffix$lambda$0;
        }
    };

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseNumberFormat) {
            JapaneseNumberFormat japaneseNumberFormat = (JapaneseNumberFormat) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -1282951108;
    }

    public String toString() {
        return "JapaneseNumberFormat";
    }

    private JapaneseNumberFormat() {
        super(null);
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public List<Pair<Long, Units>> getThresholds() {
        return thresholds;
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public Function1<Long, Function1<Double, Double>> getRounding() {
        return rounding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 rounding$lambda$0(long it) {
        return it < 1000000 ? JapaneseNumberFormat$rounding$1$1.INSTANCE : JapaneseNumberFormat$rounding$1$2.INSTANCE;
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public Function1<Units, Function0<String>> getSuffix() {
        return suffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 suffix$lambda$0(Units it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, Units.TenThousands.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.JapaneseNumberFormat$$ExternalSyntheticLambda0
            public final Object invoke() {
                String suffix$lambda$0$0;
                suffix$lambda$0$0 = JapaneseNumberFormat.suffix$lambda$0$0();
                return suffix$lambda$0$0;
            }
        } : Intrinsics.areEqual(it, Units.HundredMillions.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.JapaneseNumberFormat$$ExternalSyntheticLambda1
            public final Object invoke() {
                String suffix$lambda$0$1;
                suffix$lambda$0$1 = JapaneseNumberFormat.suffix$lambda$0$1();
                return suffix$lambda$0$1;
            }
        } : new Function0() { // from class: kntr.base.localization.preview.JapaneseNumberFormat$$ExternalSyntheticLambda2
            public final Object invoke() {
                String suffix$lambda$0$2;
                suffix$lambda$0$2 = JapaneseNumberFormat.suffix$lambda$0$2();
                return suffix$lambda$0$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$0() {
        return "万";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$1() {
        return "億";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$2() {
        return "";
    }

    @Override // kntr.base.localization.preview.NumberFormat
    /* renamed from: getCarry */
    public Void mo1632getCarry() {
        return carry;
    }
}