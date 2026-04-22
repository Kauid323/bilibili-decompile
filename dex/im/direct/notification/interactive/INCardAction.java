package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/direct/notification/interactive/INCardAction;", "Lim/direct/notification/interactive/INAction;", "card", "Lim/direct/notification/interactive/INMessageCard;", "operation", "Lim/direct/notification/interactive/INMinorOperation;", "<init>", "(Lim/direct/notification/interactive/INMessageCard;Lim/direct/notification/interactive/INMinorOperation;)V", "getCard", "()Lim/direct/notification/interactive/INMessageCard;", "getOperation", "()Lim/direct/notification/interactive/INMinorOperation;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INCardAction implements INAction {
    private final INMessageCard card;
    private final INMinorOperation operation;

    public static /* synthetic */ INCardAction copy$default(INCardAction iNCardAction, INMessageCard iNMessageCard, INMinorOperation iNMinorOperation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iNMessageCard = iNCardAction.card;
        }
        if ((i2 & 2) != 0) {
            iNMinorOperation = iNCardAction.operation;
        }
        return iNCardAction.copy(iNMessageCard, iNMinorOperation);
    }

    public final INMessageCard component1() {
        return this.card;
    }

    public final INMinorOperation component2() {
        return this.operation;
    }

    public final INCardAction copy(INMessageCard iNMessageCard, INMinorOperation iNMinorOperation) {
        Intrinsics.checkNotNullParameter(iNMessageCard, "card");
        Intrinsics.checkNotNullParameter(iNMinorOperation, "operation");
        return new INCardAction(iNMessageCard, iNMinorOperation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof INCardAction) {
            INCardAction iNCardAction = (INCardAction) obj;
            return Intrinsics.areEqual(this.card, iNCardAction.card) && Intrinsics.areEqual(this.operation, iNCardAction.operation);
        }
        return false;
    }

    public int hashCode() {
        return (this.card.hashCode() * 31) + this.operation.hashCode();
    }

    public String toString() {
        INMessageCard iNMessageCard = this.card;
        return "INCardAction(card=" + iNMessageCard + ", operation=" + this.operation + ")";
    }

    public INCardAction(INMessageCard card, INMinorOperation operation) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.card = card;
        this.operation = operation;
    }

    public final INMessageCard getCard() {
        return this.card;
    }

    public final INMinorOperation getOperation() {
        return this.operation;
    }
}