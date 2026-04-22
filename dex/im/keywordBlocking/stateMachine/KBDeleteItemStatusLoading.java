package im.keywordBlocking.stateMachine;

import im.keywordBlocking.KBListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBDeleteItemStateMachine.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStatusLoading;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;", "item", "Lim/keywordBlocking/KBListItem;", "<init>", "(Lim/keywordBlocking/KBListItem;)V", "getItem", "()Lim/keywordBlocking/KBListItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDeleteItemStatusLoading implements KBDeleteItemStatus {
    private final KBListItem item;

    public static /* synthetic */ KBDeleteItemStatusLoading copy$default(KBDeleteItemStatusLoading kBDeleteItemStatusLoading, KBListItem kBListItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kBListItem = kBDeleteItemStatusLoading.item;
        }
        return kBDeleteItemStatusLoading.copy(kBListItem);
    }

    public final KBListItem component1() {
        return this.item;
    }

    public final KBDeleteItemStatusLoading copy(KBListItem kBListItem) {
        Intrinsics.checkNotNullParameter(kBListItem, "item");
        return new KBDeleteItemStatusLoading(kBListItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KBDeleteItemStatusLoading) && Intrinsics.areEqual(this.item, ((KBDeleteItemStatusLoading) obj).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    public String toString() {
        return "KBDeleteItemStatusLoading(item=" + this.item + ")";
    }

    public KBDeleteItemStatusLoading(KBListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
    }

    @Override // im.keywordBlocking.stateMachine.KBDeleteItemStatus
    public KBListItem getItem() {
        return this.item;
    }
}