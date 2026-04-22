package kntr.base.localization.preview;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.preview.Units;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyNumberFormat.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\bHÖ\u0001R*\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0002`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkntr/base/localization/preview/SimplifiedChineseNumberFormat;", "Lkntr/base/localization/preview/ChineseNumberFormat;", "<init>", "()V", "suffix", "Lkotlin/Function1;", "Lkntr/base/localization/preview/Units;", "Lkotlin/Function0;", "", "Lkntr/base/localization/preview/Suffix;", "getSuffix", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SimplifiedChineseNumberFormat extends ChineseNumberFormat {
    public static final SimplifiedChineseNumberFormat INSTANCE = new SimplifiedChineseNumberFormat();
    private static final Function1<Units, Function0<String>> suffix = new Function1() { // from class: kntr.base.localization.preview.SimplifiedChineseNumberFormat$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Function0 suffix$lambda$0;
            suffix$lambda$0 = SimplifiedChineseNumberFormat.suffix$lambda$0((Units) obj);
            return suffix$lambda$0;
        }
    };

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimplifiedChineseNumberFormat) {
            SimplifiedChineseNumberFormat simplifiedChineseNumberFormat = (SimplifiedChineseNumberFormat) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 2082117322;
    }

    public String toString() {
        return "SimplifiedChineseNumberFormat";
    }

    private SimplifiedChineseNumberFormat() {
        super(null);
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public Function1<Units, Function0<String>> getSuffix() {
        return suffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 suffix$lambda$0(Units it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, Units.TenThousands.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.SimplifiedChineseNumberFormat$$ExternalSyntheticLambda1
            public final Object invoke() {
                String suffix$lambda$0$0;
                suffix$lambda$0$0 = SimplifiedChineseNumberFormat.suffix$lambda$0$0();
                return suffix$lambda$0$0;
            }
        } : Intrinsics.areEqual(it, Units.HundredMillions.INSTANCE) ? new Function0() { // from class: kntr.base.localization.preview.SimplifiedChineseNumberFormat$$ExternalSyntheticLambda2
            public final Object invoke() {
                String suffix$lambda$0$1;
                suffix$lambda$0$1 = SimplifiedChineseNumberFormat.suffix$lambda$0$1();
                return suffix$lambda$0$1;
            }
        } : new Function0() { // from class: kntr.base.localization.preview.SimplifiedChineseNumberFormat$$ExternalSyntheticLambda3
            public final Object invoke() {
                String suffix$lambda$0$2;
                suffix$lambda$0$2 = SimplifiedChineseNumberFormat.suffix$lambda$0$2();
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
        return "亿";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String suffix$lambda$0$2() {
        return "";
    }
}