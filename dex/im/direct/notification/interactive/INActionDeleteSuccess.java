package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/direct/notification/interactive/INActionDeleteSuccess;", "Lim/direct/notification/interactive/INAction;", "card", "Lim/direct/notification/interactive/INMessageCard;", "<init>", "(Lim/direct/notification/interactive/INMessageCard;)V", "getCard", "()Lim/direct/notification/interactive/INMessageCard;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INActionDeleteSuccess implements INAction {
    private final INMessageCard card;

    public static /* synthetic */ INActionDeleteSuccess copy$default(INActionDeleteSuccess iNActionDeleteSuccess, INMessageCard iNMessageCard, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iNMessageCard = iNActionDeleteSuccess.card;
        }
        return iNActionDeleteSuccess.copy(iNMessageCard);
    }

    public final INMessageCard component1() {
        return this.card;
    }

    public final INActionDeleteSuccess copy(INMessageCard iNMessageCard) {
        Intrinsics.checkNotNullParameter(iNMessageCard, "card");
        return new INActionDeleteSuccess(iNMessageCard);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof INActionDeleteSuccess) && Intrinsics.areEqual(this.card, ((INActionDeleteSuccess) obj).card);
    }

    public int hashCode() {
        return this.card.hashCode();
    }

    public String toString() {
        return "INActionDeleteSuccess(card=" + this.card + ")";
    }

    public INActionDeleteSuccess(INMessageCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        this.card = card;
    }

    public final INMessageCard getCard() {
        return this.card;
    }
}