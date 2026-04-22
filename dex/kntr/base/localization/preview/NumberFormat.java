package kntr.base.localization.preview;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyNumberFormat.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t0\u0005j\u0002`\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e0\u000ej\u0002`\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000ej\u0002`\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R@\u0010\u0018\u001a0\u0012\u0004\u0012\u00020\b\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019\u0018\u00010\u000ej\u0004\u0018\u0001`\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012\u0082\u0001\u0005\u001e\u001f !\"¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/NumberFormat;", "", "<init>", "()V", "thresholds", "", "Lkotlin/Pair;", "", "Lkntr/base/localization/preview/Units;", "Lkntr/base/localization/preview/Threshold;", "Lkntr/base/localization/preview/Thresholds;", "getThresholds", "()Ljava/util/List;", "rounding", "Lkotlin/Function1;", "", "Lkntr/base/localization/preview/Rounding;", "getRounding", "()Lkotlin/jvm/functions/Function1;", "suffix", "Lkotlin/Function0;", "", "Lkntr/base/localization/preview/Suffix;", "getSuffix", "carry", "Lkotlin/Function3;", "", "", "Lkntr/base/localization/preview/Carry;", "getCarry", "Lkntr/base/localization/preview/ArabicNumberFormat;", "Lkntr/base/localization/preview/ChineseNumberFormat;", "Lkntr/base/localization/preview/EnglishNumberFormat;", "Lkntr/base/localization/preview/JapaneseNumberFormat;", "Lkntr/base/localization/preview/ThaiNumberFormat;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class NumberFormat {
    public /* synthetic */ NumberFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: getCarry */
    public abstract Function1<Units, Function3<Long, Integer, Boolean, String>> mo1632getCarry();

    public abstract Function1<Long, Function1<Double, Double>> getRounding();

    public abstract Function1<Units, Function0<String>> getSuffix();

    public abstract List<Pair<Long, Units>> getThresholds();

    private NumberFormat() {
    }
}