package im.keywordBlocking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/keywordBlocking/KBActionClickItem;", "Lim/keywordBlocking/KBAction;", "item", "Lim/keywordBlocking/KBListItem;", "<init>", "(Lim/keywordBlocking/KBListItem;)V", "getItem", "()Lim/keywordBlocking/KBListItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBActionClickItem implements KBAction {
    private final KBListItem item;

    public static /* synthetic */ KBActionClickItem copy$default(KBActionClickItem kBActionClickItem, KBListItem kBListItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kBListItem = kBActionClickItem.item;
        }
        return kBActionClickItem.copy(kBListItem);
    }

    public final KBListItem component1() {
        return this.item;
    }

    public final KBActionClickItem copy(KBListItem kBListItem) {
        return new KBActionClickItem(kBListItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KBActionClickItem) && Intrinsics.areEqual(this.item, ((KBActionClickItem) obj).item);
    }

    public int hashCode() {
        if (this.item == null) {
            return 0;
        }
        return this.item.hashCode();
    }

    public String toString() {
        return "KBActionClickItem(item=" + this.item + ")";
    }

    public KBActionClickItem(KBListItem item) {
        this.item = item;
    }

    public final KBListItem getItem() {
        return this.item;
    }
}