package tv.danmaku.bili.ui.watchlater.data;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.watchlater.data.PageState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;", "", "data", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterList;", "pageState", "Ltv/danmaku/bili/ui/watchlater/data/PageState;", "playUrl", "", "isLoadMore", "", "isRefreshing", "hasMore", "<init>", "(Ltv/danmaku/bili/ui/watchlater/data/WatchLaterList;Ltv/danmaku/bili/ui/watchlater/data/PageState;Ljava/lang/String;ZZZ)V", "getData", "()Ltv/danmaku/bili/ui/watchlater/data/WatchLaterList;", "getPageState", "()Ltv/danmaku/bili/ui/watchlater/data/PageState;", "getPlayUrl", "()Ljava/lang/String;", "()Z", "getHasMore", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterTabState {
    public static final int $stable = 0;
    private final WatchLaterList data;
    private final boolean hasMore;
    private final boolean isLoadMore;
    private final boolean isRefreshing;
    private final PageState pageState;
    private final String playUrl;

    public WatchLaterTabState() {
        this(null, null, null, false, false, false, 63, null);
    }

    public static /* synthetic */ WatchLaterTabState copy$default(WatchLaterTabState watchLaterTabState, WatchLaterList watchLaterList, PageState pageState, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            watchLaterList = watchLaterTabState.data;
        }
        if ((i & 2) != 0) {
            pageState = watchLaterTabState.pageState;
        }
        PageState pageState2 = pageState;
        if ((i & 4) != 0) {
            str = watchLaterTabState.playUrl;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            z = watchLaterTabState.isLoadMore;
        }
        boolean z4 = z;
        if ((i & 16) != 0) {
            z2 = watchLaterTabState.isRefreshing;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = watchLaterTabState.hasMore;
        }
        return watchLaterTabState.copy(watchLaterList, pageState2, str2, z4, z5, z3);
    }

    public final WatchLaterList component1() {
        return this.data;
    }

    public final PageState component2() {
        return this.pageState;
    }

    public final String component3() {
        return this.playUrl;
    }

    public final boolean component4() {
        return this.isLoadMore;
    }

    public final boolean component5() {
        return this.isRefreshing;
    }

    public final boolean component6() {
        return this.hasMore;
    }

    public final WatchLaterTabState copy(WatchLaterList watchLaterList, PageState pageState, String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(watchLaterList, "data");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        return new WatchLaterTabState(watchLaterList, pageState, str, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterTabState) {
            WatchLaterTabState watchLaterTabState = (WatchLaterTabState) obj;
            return Intrinsics.areEqual(this.data, watchLaterTabState.data) && Intrinsics.areEqual(this.pageState, watchLaterTabState.pageState) && Intrinsics.areEqual(this.playUrl, watchLaterTabState.playUrl) && this.isLoadMore == watchLaterTabState.isLoadMore && this.isRefreshing == watchLaterTabState.isRefreshing && this.hasMore == watchLaterTabState.hasMore;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.data.hashCode() * 31) + this.pageState.hashCode()) * 31) + (this.playUrl == null ? 0 : this.playUrl.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRefreshing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore);
    }

    public String toString() {
        WatchLaterList watchLaterList = this.data;
        PageState pageState = this.pageState;
        String str = this.playUrl;
        boolean z = this.isLoadMore;
        boolean z2 = this.isRefreshing;
        return "WatchLaterTabState(data=" + watchLaterList + ", pageState=" + pageState + ", playUrl=" + str + ", isLoadMore=" + z + ", isRefreshing=" + z2 + ", hasMore=" + this.hasMore + ")";
    }

    public WatchLaterTabState(WatchLaterList data, PageState pageState, String playUrl, boolean isLoadMore, boolean isRefreshing, boolean hasMore) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        this.data = data;
        this.pageState = pageState;
        this.playUrl = playUrl;
        this.isLoadMore = isLoadMore;
        this.isRefreshing = isRefreshing;
        this.hasMore = hasMore;
    }

    public /* synthetic */ WatchLaterTabState(WatchLaterList watchLaterList, PageState pageState, String str, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new WatchLaterList(null, 1, null) : watchLaterList, (i & 2) != 0 ? PageState.Loading.INSTANCE : pageState, (i & 4) == 0 ? str : null, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) == 0 ? z3 : false);
    }

    public final WatchLaterList getData() {
        return this.data;
    }

    public final PageState getPageState() {
        return this.pageState;
    }

    public final String getPlayUrl() {
        return this.playUrl;
    }

    public final boolean isLoadMore() {
        return this.isLoadMore;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }
}