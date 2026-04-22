package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: SelectTribeeState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "", "index", "", "offset", "<init>", "(II)V", "getIndex", "()I", "getOffset", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectTribeeListScrollPosition {
    public static final int $stable = 0;
    private final int index;
    private final int offset;

    public static /* synthetic */ SelectTribeeListScrollPosition copy$default(SelectTribeeListScrollPosition selectTribeeListScrollPosition, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = selectTribeeListScrollPosition.index;
        }
        if ((i3 & 2) != 0) {
            i2 = selectTribeeListScrollPosition.offset;
        }
        return selectTribeeListScrollPosition.copy(i, i2);
    }

    public final int component1() {
        return this.index;
    }

    public final int component2() {
        return this.offset;
    }

    public final SelectTribeeListScrollPosition copy(int i, int i2) {
        return new SelectTribeeListScrollPosition(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectTribeeListScrollPosition) {
            SelectTribeeListScrollPosition selectTribeeListScrollPosition = (SelectTribeeListScrollPosition) obj;
            return this.index == selectTribeeListScrollPosition.index && this.offset == selectTribeeListScrollPosition.offset;
        }
        return false;
    }

    public int hashCode() {
        return (this.index * 31) + this.offset;
    }

    public String toString() {
        int i = this.index;
        return "SelectTribeeListScrollPosition(index=" + i + ", offset=" + this.offset + ")";
    }

    public SelectTribeeListScrollPosition(int index, int offset) {
        this.index = index;
        this.offset = offset;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getOffset() {
        return this.offset;
    }
}