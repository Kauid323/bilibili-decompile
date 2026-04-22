package kntr.base.dd.impl.internal.decide;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.decide.Operator;
import kotlin.Metadata;

/* compiled from: Operator.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"parseOperator", "Lkntr/base/dd/impl/internal/decide/Operator;", "raw", "", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OperatorKt {
    public static final Operator parseOperator(String raw) {
        if (raw != null) {
            Operator from = Operator.Logic.Companion.from(raw);
            if (from == null && (from = Operator.Compare.Companion.from(raw)) == null) {
                from = Operator.Custom.Companion.from(raw);
            }
            return from;
        }
        return null;
    }
}