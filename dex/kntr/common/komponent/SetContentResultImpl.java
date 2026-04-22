package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÁ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/komponent/SetContentResultImpl;", "Lkntr/common/komponent/SetContentResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SetContentResultImpl implements SetContentResult {
    public static final int $stable = 0;
    public static final SetContentResultImpl INSTANCE = new SetContentResultImpl();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetContentResultImpl) {
            SetContentResultImpl setContentResultImpl = (SetContentResultImpl) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -132361805;
    }

    public String toString() {
        return "SetContentResultImpl";
    }

    private SetContentResultImpl() {
    }
}