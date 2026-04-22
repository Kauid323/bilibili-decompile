package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class RoundingRule$roundingFor$1 extends FunctionReferenceImpl implements Function1<Double, Double> {
    public static final RoundingRule$roundingFor$1 INSTANCE = new RoundingRule$roundingFor$1();

    RoundingRule$roundingFor$1() {
        super(1, NumberFormatKt.class, "realRound", "realRound(D)D", 1);
    }

    public final Double invoke(double p0) {
        double realRound;
        realRound = NumberFormatKt.realRound(p0);
        return Double.valueOf(realRound);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).doubleValue());
    }
}