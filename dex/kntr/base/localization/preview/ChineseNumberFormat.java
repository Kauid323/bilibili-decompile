package kntr.base.localization.preview;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.preview.Units;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LegacyNumberFormat.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\rj\u0002`\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lkntr/base/localization/preview/ChineseNumberFormat;", "Lkntr/base/localization/preview/NumberFormat;", "<init>", "()V", "thresholds", "", "Lkotlin/Pair;", "", "Lkntr/base/localization/preview/Units;", "Lkntr/base/localization/preview/Threshold;", "getThresholds", "()Ljava/util/List;", "rounding", "Lkotlin/Function1;", "", "Lkntr/base/localization/preview/Rounding;", "getRounding", "()Lkotlin/jvm/functions/Function1;", "carry", "", "getCarry", "()Ljava/lang/Void;", "Lkntr/base/localization/preview/SimplifiedChineseNumberFormat;", "Lkntr/base/localization/preview/TraditionalChineseNumberFormat;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
abstract class ChineseNumberFormat extends NumberFormat {
    private final Void carry;
    private final Function1<Long, Function1<Double, Double>> rounding;
    private final List<Pair<Long, Units>> thresholds;

    public /* synthetic */ ChineseNumberFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChineseNumberFormat() {
        super(null);
        this.thresholds = CollectionsKt.listOf(new Pair[]{LegacyNumberFormatKt.toThreshold$default(Units.TenThousands.INSTANCE, 0L, 1, null), LegacyNumberFormatKt.toThreshold$default(Units.HundredMillions.INSTANCE, 0L, 1, null)});
        this.rounding = new Function1() { // from class: kntr.base.localization.preview.ChineseNumberFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Function1 rounding$lambda$0;
                rounding$lambda$0 = ChineseNumberFormat.rounding$lambda$0(((Long) obj).longValue());
                return rounding$lambda$0;
            }
        };
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public List<Pair<Long, Units>> getThresholds() {
        return this.thresholds;
    }

    @Override // kntr.base.localization.preview.NumberFormat
    public Function1<Long, Function1<Double, Double>> getRounding() {
        return this.rounding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 rounding$lambda$0(long it) {
        return it < 1000000 ? ChineseNumberFormat$rounding$1$1.INSTANCE : ChineseNumberFormat$rounding$1$2.INSTANCE;
    }

    @Override // kntr.base.localization.preview.NumberFormat
    /* renamed from: getCarry */
    public Void mo1632getCarry() {
        return this.carry;
    }
}