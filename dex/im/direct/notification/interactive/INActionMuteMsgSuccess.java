package im.direct.notification.interactive;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lim/direct/notification/interactive/INActionMuteMsgSuccess;", "Lim/direct/notification/interactive/INAction;", "card", "Lim/direct/notification/interactive/INMessageCard;", "isMuted", "", "<init>", "(Lim/direct/notification/interactive/INMessageCard;Z)V", "getCard", "()Lim/direct/notification/interactive/INMessageCard;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INActionMuteMsgSuccess implements INAction {
    private final INMessageCard card;
    private final boolean isMuted;

    public static /* synthetic */ INActionMuteMsgSuccess copy$default(INActionMuteMsgSuccess iNActionMuteMsgSuccess, INMessageCard iNMessageCard, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iNMessageCard = iNActionMuteMsgSuccess.card;
        }
        if ((i2 & 2) != 0) {
            z = iNActionMuteMsgSuccess.isMuted;
        }
        return iNActionMuteMsgSuccess.copy(iNMessageCard, z);
    }

    public final INMessageCard component1() {
        return this.card;
    }

    public final boolean component2() {
        return this.isMuted;
    }

    public final INActionMuteMsgSuccess copy(INMessageCard iNMessageCard, boolean z) {
        Intrinsics.checkNotNullParameter(iNMessageCard, "card");
        return new INActionMuteMsgSuccess(iNMessageCard, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof INActionMuteMsgSuccess) {
            INActionMuteMsgSuccess iNActionMuteMsgSuccess = (INActionMuteMsgSuccess) obj;
            return Intrinsics.areEqual(this.card, iNActionMuteMsgSuccess.card) && this.isMuted == iNActionMuteMsgSuccess.isMuted;
        }
        return false;
    }

    public int hashCode() {
        return (this.card.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMuted);
    }

    public String toString() {
        INMessageCard iNMessageCard = this.card;
        return "INActionMuteMsgSuccess(card=" + iNMessageCard + ", isMuted=" + this.isMuted + ")";
    }

    public INActionMuteMsgSuccess(INMessageCard card, boolean isMuted) {
        Intrinsics.checkNotNullParameter(card, "card");
        this.card = card;
        this.isMuted = isMuted;
    }

    public final INMessageCard getCard() {
        return this.card;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }
}