package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lim/direct/notification/interactive/INTipsCard;", "Lim/direct/notification/interactive/INCard;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText$annotations", "()V", "getText", "()Ljava/lang/String;", "itemId", "getItemId", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INTipsCard implements INCard {
    private final String text;

    public static /* synthetic */ INTipsCard copy$default(INTipsCard iNTipsCard, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iNTipsCard.text;
        }
        return iNTipsCard.copy(str);
    }

    public static /* synthetic */ void getText$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final INTipsCard copy(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new INTipsCard(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof INTipsCard) && Intrinsics.areEqual(this.text, ((INTipsCard) obj).text);
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public String toString() {
        return "INTipsCard(text=" + this.text + ")";
    }

    public INTipsCard(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }

    @Override // im.direct.notification.interactive.INCard
    public String getItemId() {
        return "INTipsCard " + this.text;
    }
}