package kntr.app.game.base.viewmodel;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lkntr/app/game/base/viewmodel/PageLoadMoreState;", RoomRecommendViewModel.EMPTY_CURSOR, "isLoading", RoomRecommendViewModel.EMPTY_CURSOR, "error", "noMore", "<init>", "(ZZZ)V", "()Z", "getError", "getNoMore", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PageLoadMoreState {
    public static final int $stable = 0;
    private final boolean error;
    private final boolean isLoading;
    private final boolean noMore;
    public static final Companion Companion = new Companion(null);
    private static final PageLoadMoreState Idle = new PageLoadMoreState(false, false, false, 4, null);
    private static final PageLoadMoreState Loading = new PageLoadMoreState(true, false, false, 4, null);
    private static final PageLoadMoreState NoMore = new PageLoadMoreState(false, false, true);
    private static final PageLoadMoreState Error = new PageLoadMoreState(false, true, false, 4, null);

    public static /* synthetic */ PageLoadMoreState copy$default(PageLoadMoreState pageLoadMoreState, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pageLoadMoreState.isLoading;
        }
        if ((i & 2) != 0) {
            z2 = pageLoadMoreState.error;
        }
        if ((i & 4) != 0) {
            z3 = pageLoadMoreState.noMore;
        }
        return pageLoadMoreState.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.isLoading;
    }

    public final boolean component2() {
        return this.error;
    }

    public final boolean component3() {
        return this.noMore;
    }

    public final PageLoadMoreState copy(boolean z, boolean z2, boolean z3) {
        return new PageLoadMoreState(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PageLoadMoreState) {
            PageLoadMoreState pageLoadMoreState = (PageLoadMoreState) obj;
            return this.isLoading == pageLoadMoreState.isLoading && this.error == pageLoadMoreState.error && this.noMore == pageLoadMoreState.noMore;
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.error)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.noMore);
    }

    public String toString() {
        boolean z = this.isLoading;
        boolean z2 = this.error;
        return "PageLoadMoreState(isLoading=" + z + ", error=" + z2 + ", noMore=" + this.noMore + ")";
    }

    public PageLoadMoreState(boolean isLoading, boolean error, boolean noMore) {
        this.isLoading = isLoading;
        this.error = error;
        this.noMore = noMore;
    }

    public /* synthetic */ PageLoadMoreState(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean getError() {
        return this.error;
    }

    public final boolean getNoMore() {
        return this.noMore;
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkntr/app/game/base/viewmodel/PageLoadMoreState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Idle", "Lkntr/app/game/base/viewmodel/PageLoadMoreState;", "getIdle", "()Lkntr/app/game/base/viewmodel/PageLoadMoreState;", "Loading", "getLoading", "NoMore", "getNoMore", "Error", "getError", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PageLoadMoreState getIdle() {
            return PageLoadMoreState.Idle;
        }

        public final PageLoadMoreState getLoading() {
            return PageLoadMoreState.Loading;
        }

        public final PageLoadMoreState getNoMore() {
            return PageLoadMoreState.NoMore;
        }

        public final PageLoadMoreState getError() {
            return PageLoadMoreState.Error;
        }
    }
}