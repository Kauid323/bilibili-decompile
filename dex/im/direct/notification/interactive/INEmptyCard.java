package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlinx.datetime.Clock;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lim/direct/notification/interactive/INEmptyCard;", "Lim/direct/notification/interactive/INCard;", "height", "", "<init>", "(I)V", "getHeight$annotations", "()V", "getHeight", "()I", "itemId", "", "getItemId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INEmptyCard implements INCard {
    private final int height;
    private final String itemId = Clock.System.INSTANCE.now().toString();

    public static /* synthetic */ INEmptyCard copy$default(INEmptyCard iNEmptyCard, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = iNEmptyCard.height;
        }
        return iNEmptyCard.copy(i2);
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    public final int component1() {
        return this.height;
    }

    public final INEmptyCard copy(int i2) {
        return new INEmptyCard(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof INEmptyCard) && this.height == ((INEmptyCard) obj).height;
    }

    public int hashCode() {
        return this.height;
    }

    public String toString() {
        return "INEmptyCard(height=" + this.height + ")";
    }

    public INEmptyCard(int height) {
        this.height = height;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // im.direct.notification.interactive.INCard
    public String getItemId() {
        return this.itemId;
    }
}