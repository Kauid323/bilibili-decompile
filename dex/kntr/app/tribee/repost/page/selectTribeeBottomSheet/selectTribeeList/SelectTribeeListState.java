package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectTribeeState.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListState;", "", "items", "", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "isLoadingMore", "", "hasMore", "selectedTribee", "selectedPartition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "listScrollPosition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "<init>", "(Ljava/util/List;ZZLkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;)V", "getItems", "()Ljava/util/List;", "()Z", "getHasMore", "getSelectedTribee", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "getSelectedPartition", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "getListScrollPosition", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectTribeeListState {
    public static final int $stable = 0;
    private final boolean hasMore;
    private final boolean isLoadingMore;
    private final List<SelectableTribeeItem> items;
    private final SelectTribeeListScrollPosition listScrollPosition;
    private final SelectableTribeePartition selectedPartition;
    private final SelectableTribeeItem selectedTribee;

    public SelectTribeeListState() {
        this(null, false, false, null, null, null, 63, null);
    }

    public static /* synthetic */ SelectTribeeListState copy$default(SelectTribeeListState selectTribeeListState, List list, boolean z, boolean z2, SelectableTribeeItem selectableTribeeItem, SelectableTribeePartition selectableTribeePartition, SelectTribeeListScrollPosition selectTribeeListScrollPosition, int i, Object obj) {
        List<SelectableTribeeItem> list2 = list;
        if ((i & 1) != 0) {
            list2 = selectTribeeListState.items;
        }
        if ((i & 2) != 0) {
            z = selectTribeeListState.isLoadingMore;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = selectTribeeListState.hasMore;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            selectableTribeeItem = selectTribeeListState.selectedTribee;
        }
        SelectableTribeeItem selectableTribeeItem2 = selectableTribeeItem;
        if ((i & 16) != 0) {
            selectableTribeePartition = selectTribeeListState.selectedPartition;
        }
        SelectableTribeePartition selectableTribeePartition2 = selectableTribeePartition;
        if ((i & 32) != 0) {
            selectTribeeListScrollPosition = selectTribeeListState.listScrollPosition;
        }
        return selectTribeeListState.copy(list2, z3, z4, selectableTribeeItem2, selectableTribeePartition2, selectTribeeListScrollPosition);
    }

    public final List<SelectableTribeeItem> component1() {
        return this.items;
    }

    public final boolean component2() {
        return this.isLoadingMore;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final SelectableTribeeItem component4() {
        return this.selectedTribee;
    }

    public final SelectableTribeePartition component5() {
        return this.selectedPartition;
    }

    public final SelectTribeeListScrollPosition component6() {
        return this.listScrollPosition;
    }

    public final SelectTribeeListState copy(List<SelectableTribeeItem> list, boolean z, boolean z2, SelectableTribeeItem selectableTribeeItem, SelectableTribeePartition selectableTribeePartition, SelectTribeeListScrollPosition selectTribeeListScrollPosition) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new SelectTribeeListState(list, z, z2, selectableTribeeItem, selectableTribeePartition, selectTribeeListScrollPosition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectTribeeListState) {
            SelectTribeeListState selectTribeeListState = (SelectTribeeListState) obj;
            return Intrinsics.areEqual(this.items, selectTribeeListState.items) && this.isLoadingMore == selectTribeeListState.isLoadingMore && this.hasMore == selectTribeeListState.hasMore && Intrinsics.areEqual(this.selectedTribee, selectTribeeListState.selectedTribee) && Intrinsics.areEqual(this.selectedPartition, selectTribeeListState.selectedPartition) && Intrinsics.areEqual(this.listScrollPosition, selectTribeeListState.listScrollPosition);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.items.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadingMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + (this.selectedTribee == null ? 0 : this.selectedTribee.hashCode())) * 31) + (this.selectedPartition == null ? 0 : this.selectedPartition.hashCode())) * 31) + (this.listScrollPosition != null ? this.listScrollPosition.hashCode() : 0);
    }

    public String toString() {
        List<SelectableTribeeItem> list = this.items;
        boolean z = this.isLoadingMore;
        boolean z2 = this.hasMore;
        SelectableTribeeItem selectableTribeeItem = this.selectedTribee;
        SelectableTribeePartition selectableTribeePartition = this.selectedPartition;
        return "SelectTribeeListState(items=" + list + ", isLoadingMore=" + z + ", hasMore=" + z2 + ", selectedTribee=" + selectableTribeeItem + ", selectedPartition=" + selectableTribeePartition + ", listScrollPosition=" + this.listScrollPosition + ")";
    }

    public SelectTribeeListState(List<SelectableTribeeItem> list, boolean isLoadingMore, boolean hasMore, SelectableTribeeItem selectedTribee, SelectableTribeePartition selectedPartition, SelectTribeeListScrollPosition listScrollPosition) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.isLoadingMore = isLoadingMore;
        this.hasMore = hasMore;
        this.selectedTribee = selectedTribee;
        this.selectedPartition = selectedPartition;
        this.listScrollPosition = listScrollPosition;
    }

    public /* synthetic */ SelectTribeeListState(List list, boolean z, boolean z2, SelectableTribeeItem selectableTribeeItem, SelectableTribeePartition selectableTribeePartition, SelectTribeeListScrollPosition selectTribeeListScrollPosition, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z, (i & 4) == 0 ? z2 : false, (i & 8) != 0 ? null : selectableTribeeItem, (i & 16) != 0 ? null : selectableTribeePartition, (i & 32) != 0 ? null : selectTribeeListScrollPosition);
    }

    public final List<SelectableTribeeItem> getItems() {
        return this.items;
    }

    public final boolean isLoadingMore() {
        return this.isLoadingMore;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final SelectableTribeeItem getSelectedTribee() {
        return this.selectedTribee;
    }

    public final SelectableTribeePartition getSelectedPartition() {
        return this.selectedPartition;
    }

    public final SelectTribeeListScrollPosition getListScrollPosition() {
        return this.listScrollPosition;
    }
}