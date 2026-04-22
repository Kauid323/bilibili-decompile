package kntr.app.im.chat.ui;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: PageConfig.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/ui/ListScrollingHolder;", RoomRecommendViewModel.EMPTY_CURSOR, "canScrollBackward", RoomRecommendViewModel.EMPTY_CURSOR, "isScrollInProgress", "<init>", "(ZZ)V", "getCanScrollBackward", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListScrollingHolder {
    public static final int $stable = 0;
    private final boolean canScrollBackward;
    private final boolean isScrollInProgress;

    public static /* synthetic */ ListScrollingHolder copy$default(ListScrollingHolder listScrollingHolder, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = listScrollingHolder.canScrollBackward;
        }
        if ((i & 2) != 0) {
            z2 = listScrollingHolder.isScrollInProgress;
        }
        return listScrollingHolder.copy(z, z2);
    }

    public final boolean component1() {
        return this.canScrollBackward;
    }

    public final boolean component2() {
        return this.isScrollInProgress;
    }

    public final ListScrollingHolder copy(boolean z, boolean z2) {
        return new ListScrollingHolder(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ListScrollingHolder) {
            ListScrollingHolder listScrollingHolder = (ListScrollingHolder) obj;
            return this.canScrollBackward == listScrollingHolder.canScrollBackward && this.isScrollInProgress == listScrollingHolder.isScrollInProgress;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canScrollBackward) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isScrollInProgress);
    }

    public String toString() {
        boolean z = this.canScrollBackward;
        return "ListScrollingHolder(canScrollBackward=" + z + ", isScrollInProgress=" + this.isScrollInProgress + ")";
    }

    public ListScrollingHolder(boolean canScrollBackward, boolean isScrollInProgress) {
        this.canScrollBackward = canScrollBackward;
        this.isScrollInProgress = isScrollInProgress;
    }

    public final boolean getCanScrollBackward() {
        return this.canScrollBackward;
    }

    public final boolean isScrollInProgress() {
        return this.isScrollInProgress;
    }
}