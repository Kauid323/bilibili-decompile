package im.session;

import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/session/IMActionExposureSessionCard;", "Lim/session/IMSilentAction;", "card", "Lim/session/model/IMSessionCard;", "<init>", "(Lim/session/model/IMSessionCard;)V", "getCard", "()Lim/session/model/IMSessionCard;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionExposureSessionCard implements IMSilentAction {
    private final IMSessionCard card;

    public static /* synthetic */ IMActionExposureSessionCard copy$default(IMActionExposureSessionCard iMActionExposureSessionCard, IMSessionCard iMSessionCard, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMSessionCard = iMActionExposureSessionCard.card;
        }
        return iMActionExposureSessionCard.copy(iMSessionCard);
    }

    public final IMSessionCard component1() {
        return this.card;
    }

    public final IMActionExposureSessionCard copy(IMSessionCard iMSessionCard) {
        Intrinsics.checkNotNullParameter(iMSessionCard, "card");
        return new IMActionExposureSessionCard(iMSessionCard);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMActionExposureSessionCard) && Intrinsics.areEqual(this.card, ((IMActionExposureSessionCard) obj).card);
    }

    public int hashCode() {
        return this.card.hashCode();
    }

    public IMActionExposureSessionCard(IMSessionCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        this.card = card;
    }

    public final IMSessionCard getCard() {
        return this.card;
    }

    public String toString() {
        return "IMActionExposureSessionCard(card=" + this.card.getLogString() + ")";
    }
}