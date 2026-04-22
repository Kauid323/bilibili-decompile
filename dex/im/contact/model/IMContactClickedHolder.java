package im.contact.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: IMContactClickedHolder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÂ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lim/contact/model/IMContactClickedHolder;", "", "item", "Lim/contact/model/IMContactItem;", "isGroup", "", "instant", "", "<init>", "(Lim/contact/model/IMContactItem;ZJ)V", "getItem", "()Lim/contact/model/IMContactItem;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactClickedHolder {
    private final long instant;
    private final boolean isGroup;
    private final IMContactItem item;

    private final long component3() {
        return this.instant;
    }

    public static /* synthetic */ IMContactClickedHolder copy$default(IMContactClickedHolder iMContactClickedHolder, IMContactItem iMContactItem, boolean z, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMContactItem = iMContactClickedHolder.item;
        }
        if ((i2 & 2) != 0) {
            z = iMContactClickedHolder.isGroup;
        }
        if ((i2 & 4) != 0) {
            j = iMContactClickedHolder.instant;
        }
        return iMContactClickedHolder.copy(iMContactItem, z, j);
    }

    public final IMContactItem component1() {
        return this.item;
    }

    public final boolean component2() {
        return this.isGroup;
    }

    public final IMContactClickedHolder copy(IMContactItem iMContactItem, boolean z, long j) {
        Intrinsics.checkNotNullParameter(iMContactItem, "item");
        return new IMContactClickedHolder(iMContactItem, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactClickedHolder) {
            IMContactClickedHolder iMContactClickedHolder = (IMContactClickedHolder) obj;
            return Intrinsics.areEqual(this.item, iMContactClickedHolder.item) && this.isGroup == iMContactClickedHolder.isGroup && this.instant == iMContactClickedHolder.instant;
        }
        return false;
    }

    public int hashCode() {
        return (((this.item.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isGroup)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.instant);
    }

    public String toString() {
        IMContactItem iMContactItem = this.item;
        boolean z = this.isGroup;
        return "IMContactClickedHolder(item=" + iMContactItem + ", isGroup=" + z + ", instant=" + this.instant + ")";
    }

    public IMContactClickedHolder(IMContactItem item, boolean isGroup, long instant) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.isGroup = isGroup;
        this.instant = instant;
    }

    public /* synthetic */ IMContactClickedHolder(IMContactItem iMContactItem, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMContactItem, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? Clock.System.INSTANCE.now().toEpochMilliseconds() : j);
    }

    public final IMContactItem getItem() {
        return this.item;
    }

    public final boolean isGroup() {
        return this.isGroup;
    }
}