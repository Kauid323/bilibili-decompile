package kntr.common.ouro.core.plugin.paragraphStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: OuroParagraphStyleAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleH3Action;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleParagraphTypeAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroToggleH3Action extends OuroToggleParagraphTypeAction {
    public static final OuroToggleH3Action INSTANCE = new OuroToggleH3Action();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroToggleH3Action) {
            OuroToggleH3Action ouroToggleH3Action = (OuroToggleH3Action) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -684103518;
    }

    public String toString() {
        return "OuroToggleH3Action";
    }

    private OuroToggleH3Action() {
        super(ParagraphType.H3, null);
    }
}