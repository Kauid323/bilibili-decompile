package kntr.common.ouro.core.plugin.textStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: OuroTextStyleAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroToggleBoldAction;", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroToggleBoldAction implements OuroTextStyleAction {
    public static final OuroToggleBoldAction INSTANCE = new OuroToggleBoldAction();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroToggleBoldAction) {
            OuroToggleBoldAction ouroToggleBoldAction = (OuroToggleBoldAction) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -1545162179;
    }

    public String toString() {
        return "OuroToggleBoldAction";
    }

    private OuroToggleBoldAction() {
    }
}