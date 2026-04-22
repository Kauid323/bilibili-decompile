package kntr.common.ouro.core.plugin.pasteboard;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroPasteboardAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/core/plugin/pasteboard/OuroCopyAction;", "Lkntr/common/ouro/core/action/OuroAction;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "<init>", "(Lkntr/common/ouro/core/model/OuroTextRange;)V", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroCopyAction implements OuroAction {
    private final OuroTextRange range;

    public OuroCopyAction() {
        this(null, 1, null);
    }

    public static /* synthetic */ OuroCopyAction copy$default(OuroCopyAction ouroCopyAction, OuroTextRange ouroTextRange, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroTextRange = ouroCopyAction.range;
        }
        return ouroCopyAction.copy(ouroTextRange);
    }

    public final OuroTextRange component1() {
        return this.range;
    }

    public final OuroCopyAction copy(OuroTextRange ouroTextRange) {
        return new OuroCopyAction(ouroTextRange);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroCopyAction) && Intrinsics.areEqual(this.range, ((OuroCopyAction) obj).range);
    }

    public int hashCode() {
        if (this.range == null) {
            return 0;
        }
        return this.range.hashCode();
    }

    public String toString() {
        return "OuroCopyAction(range=" + this.range + ")";
    }

    public OuroCopyAction(OuroTextRange range) {
        this.range = range;
    }

    public /* synthetic */ OuroCopyAction(OuroTextRange ouroTextRange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ouroTextRange);
    }

    public final OuroTextRange getRange() {
        return this.range;
    }
}