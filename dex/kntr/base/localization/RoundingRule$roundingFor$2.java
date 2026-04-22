package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class RoundingRule$roundingFor$2 extends FunctionReferenceImpl implements Function1<Double, Double> {
    public static final RoundingRule$roundingFor$2 INSTANCE = new RoundingRule$roundingFor$2();

    RoundingRule$roundingFor$2() {
        super(1, MathKt.class, "floor", "floor(D)D", 1);
    }

    public final Double invoke(double p0) {
        return Double.valueOf(Math.floor(p0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).doubleValue());
    }
}