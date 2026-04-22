package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FavPageFooterState;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIState;

/* compiled from: FavoritesState.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B]\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003Je\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u0006,"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavTabState;", "T", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIState;", "pageState", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "footerState", "Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;", "itemList", "", "isRefreshing", "", "isCheckMode", "pageNum", "", "hasMore", "hasInvalid", "<init>", "(Ltv/danmaku/bili/ui/favorites/state/FavPageState;Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;Ljava/util/List;ZZIZZ)V", "getPageState", "()Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getFooterState", "()Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;", "getItemList", "()Ljava/util/List;", "()Z", "getPageNum", "()I", "getHasMore", "getHasInvalid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavTabState<T> implements IUIState {
    public static final int $stable = 8;
    private final FavPageFooterState footerState;
    private final boolean hasInvalid;
    private final boolean hasMore;
    private final boolean isCheckMode;
    private final boolean isRefreshing;
    private final List<T> itemList;
    private final int pageNum;
    private final FavPageState pageState;

    public FavTabState() {
        this(null, null, null, false, false, 0, false, false, BR.hallCover, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    public static /* synthetic */ FavTabState copy$default(FavTabState favTabState, FavPageState favPageState, FavPageFooterState favPageFooterState, List list, boolean z, boolean z2, int i, boolean z3, boolean z4, int i2, Object obj) {
        return favTabState.copy((i2 & 1) != 0 ? favTabState.pageState : favPageState, (i2 & 2) != 0 ? favTabState.footerState : favPageFooterState, (i2 & 4) != 0 ? favTabState.itemList : list, (i2 & 8) != 0 ? favTabState.isRefreshing : z, (i2 & 16) != 0 ? favTabState.isCheckMode : z2, (i2 & 32) != 0 ? favTabState.pageNum : i, (i2 & 64) != 0 ? favTabState.hasMore : z3, (i2 & BR.cover) != 0 ? favTabState.hasInvalid : z4);
    }

    public final FavPageState component1() {
        return this.pageState;
    }

    public final FavPageFooterState component2() {
        return this.footerState;
    }

    public final List<T> component3() {
        return this.itemList;
    }

    public final boolean component4() {
        return this.isRefreshing;
    }

    public final boolean component5() {
        return this.isCheckMode;
    }

    public final int component6() {
        return this.pageNum;
    }

    public final boolean component7() {
        return this.hasMore;
    }

    public final boolean component8() {
        return this.hasInvalid;
    }

    public final FavTabState<T> copy(FavPageState favPageState, FavPageFooterState favPageFooterState, List<? extends T> list, boolean z, boolean z2, int i, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(favPageState, "pageState");
        Intrinsics.checkNotNullParameter(favPageFooterState, "footerState");
        Intrinsics.checkNotNullParameter(list, "itemList");
        return new FavTabState<>(favPageState, favPageFooterState, list, z, z2, i, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavTabState) {
            FavTabState favTabState = (FavTabState) obj;
            return Intrinsics.areEqual(this.pageState, favTabState.pageState) && Intrinsics.areEqual(this.footerState, favTabState.footerState) && Intrinsics.areEqual(this.itemList, favTabState.itemList) && this.isRefreshing == favTabState.isRefreshing && this.isCheckMode == favTabState.isCheckMode && this.pageNum == favTabState.pageNum && this.hasMore == favTabState.hasMore && this.hasInvalid == favTabState.hasInvalid;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.pageState.hashCode() * 31) + this.footerState.hashCode()) * 31) + this.itemList.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRefreshing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCheckMode)) * 31) + this.pageNum) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasInvalid);
    }

    public String toString() {
        FavPageState favPageState = this.pageState;
        FavPageFooterState favPageFooterState = this.footerState;
        List<T> list = this.itemList;
        boolean z = this.isRefreshing;
        boolean z2 = this.isCheckMode;
        int i = this.pageNum;
        boolean z3 = this.hasMore;
        return "FavTabState(pageState=" + favPageState + ", footerState=" + favPageFooterState + ", itemList=" + list + ", isRefreshing=" + z + ", isCheckMode=" + z2 + ", pageNum=" + i + ", hasMore=" + z3 + ", hasInvalid=" + this.hasInvalid + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FavTabState(FavPageState pageState, FavPageFooterState footerState, List<? extends T> list, boolean isRefreshing, boolean isCheckMode, int pageNum, boolean hasMore, boolean hasInvalid) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(footerState, "footerState");
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.pageState = pageState;
        this.footerState = footerState;
        this.itemList = list;
        this.isRefreshing = isRefreshing;
        this.isCheckMode = isCheckMode;
        this.pageNum = pageNum;
        this.hasMore = hasMore;
        this.hasInvalid = hasInvalid;
    }

    public /* synthetic */ FavTabState(FavPageState favPageState, FavPageFooterState favPageFooterState, List list, boolean z, boolean z2, int i, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? FavPageState.Init.INSTANCE : favPageState, (i2 & 2) != 0 ? FavPageFooterState.Gone.INSTANCE : favPageFooterState, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? 1 : i, (i2 & 64) == 0 ? z3 : true, (i2 & BR.cover) == 0 ? z4 : false);
    }

    public final FavPageState getPageState() {
        return this.pageState;
    }

    public final FavPageFooterState getFooterState() {
        return this.footerState;
    }

    public final List<T> getItemList() {
        return this.itemList;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public final boolean isCheckMode() {
        return this.isCheckMode;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasInvalid() {
        return this.hasInvalid;
    }
}