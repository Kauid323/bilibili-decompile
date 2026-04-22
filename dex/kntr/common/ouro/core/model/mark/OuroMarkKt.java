package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroMark.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"mergeParent", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "parent", "(Lkntr/common/ouro/core/model/mark/OuroMark;Lkntr/common/ouro/core/model/mark/OuroMark;)Lkntr/common/ouro/core/model/mark/OuroMark;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroMarkKt {
    public static final <T extends OuroMark> T mergeParent(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "parent");
        return (T) t.getMergeRule().invoke(t, t2);
    }
}