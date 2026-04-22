package im.session;

import BottomSheetItemData$;
import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/session/IMActionSessionDeleteConfirm;", "Lim/session/IMAction;", "card", "Lim/session/model/IMSessionCard;", "del", "", "<init>", "(Lim/session/model/IMSessionCard;Z)V", "getCard", "()Lim/session/model/IMSessionCard;", "getDel", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionSessionDeleteConfirm implements IMAction {
    private final IMSessionCard card;
    private final boolean del;

    public static /* synthetic */ IMActionSessionDeleteConfirm copy$default(IMActionSessionDeleteConfirm iMActionSessionDeleteConfirm, IMSessionCard iMSessionCard, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMSessionCard = iMActionSessionDeleteConfirm.card;
        }
        if ((i2 & 2) != 0) {
            z = iMActionSessionDeleteConfirm.del;
        }
        return iMActionSessionDeleteConfirm.copy(iMSessionCard, z);
    }

    public final IMSessionCard component1() {
        return this.card;
    }

    public final boolean component2() {
        return this.del;
    }

    public final IMActionSessionDeleteConfirm copy(IMSessionCard iMSessionCard, boolean z) {
        Intrinsics.checkNotNullParameter(iMSessionCard, "card");
        return new IMActionSessionDeleteConfirm(iMSessionCard, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMActionSessionDeleteConfirm) {
            IMActionSessionDeleteConfirm iMActionSessionDeleteConfirm = (IMActionSessionDeleteConfirm) obj;
            return Intrinsics.areEqual(this.card, iMActionSessionDeleteConfirm.card) && this.del == iMActionSessionDeleteConfirm.del;
        }
        return false;
    }

    public int hashCode() {
        return (this.card.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.del);
    }

    public String toString() {
        IMSessionCard iMSessionCard = this.card;
        return "IMActionSessionDeleteConfirm(card=" + iMSessionCard + ", del=" + this.del + ")";
    }

    public IMActionSessionDeleteConfirm(IMSessionCard card, boolean del) {
        Intrinsics.checkNotNullParameter(card, "card");
        this.card = card;
        this.del = del;
    }

    public /* synthetic */ IMActionSessionDeleteConfirm(IMSessionCard iMSessionCard, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMSessionCard, (i2 & 2) != 0 ? true : z);
    }

    public final IMSessionCard getCard() {
        return this.card;
    }

    public final boolean getDel() {
        return this.del;
    }
}