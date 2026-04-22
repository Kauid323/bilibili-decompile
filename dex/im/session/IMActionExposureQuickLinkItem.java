package im.session;

import im.session.model.IMQuickLinkItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/session/IMActionExposureQuickLinkItem;", "Lim/session/IMAction;", "item", "Lim/session/model/IMQuickLinkItem;", "<init>", "(Lim/session/model/IMQuickLinkItem;)V", "getItem", "()Lim/session/model/IMQuickLinkItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionExposureQuickLinkItem implements IMAction {
    private final IMQuickLinkItem item;

    public static /* synthetic */ IMActionExposureQuickLinkItem copy$default(IMActionExposureQuickLinkItem iMActionExposureQuickLinkItem, IMQuickLinkItem iMQuickLinkItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMQuickLinkItem = iMActionExposureQuickLinkItem.item;
        }
        return iMActionExposureQuickLinkItem.copy(iMQuickLinkItem);
    }

    public final IMQuickLinkItem component1() {
        return this.item;
    }

    public final IMActionExposureQuickLinkItem copy(IMQuickLinkItem iMQuickLinkItem) {
        Intrinsics.checkNotNullParameter(iMQuickLinkItem, "item");
        return new IMActionExposureQuickLinkItem(iMQuickLinkItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMActionExposureQuickLinkItem) && Intrinsics.areEqual(this.item, ((IMActionExposureQuickLinkItem) obj).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    public String toString() {
        return "IMActionExposureQuickLinkItem(item=" + this.item + ")";
    }

    public IMActionExposureQuickLinkItem(IMQuickLinkItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
    }

    public final IMQuickLinkItem getItem() {
        return this.item;
    }
}