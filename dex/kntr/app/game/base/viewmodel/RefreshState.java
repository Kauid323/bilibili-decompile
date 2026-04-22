package kntr.app.game.base.viewmodel;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/game/base/viewmodel/RefreshState;", RoomRecommendViewModel.EMPTY_CURSOR, "refreshing", RoomRecommendViewModel.EMPTY_CURSOR, "error", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZLjava/lang/String;)V", "getRefreshing", "()Z", "getError", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RefreshState {
    public static final int $stable = 0;
    private final String error;
    private final boolean refreshing;
    public static final Companion Companion = new Companion(null);
    private static final RefreshState Refreshing = new RefreshState(true, null);
    private static final RefreshState Idle = new RefreshState(false, null);

    public static /* synthetic */ RefreshState copy$default(RefreshState refreshState, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = refreshState.refreshing;
        }
        if ((i & 2) != 0) {
            str = refreshState.error;
        }
        return refreshState.copy(z, str);
    }

    public final boolean component1() {
        return this.refreshing;
    }

    public final String component2() {
        return this.error;
    }

    public final RefreshState copy(boolean z, String str) {
        return new RefreshState(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RefreshState) {
            RefreshState refreshState = (RefreshState) obj;
            return this.refreshing == refreshState.refreshing && Intrinsics.areEqual(this.error, refreshState.error);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.refreshing) * 31) + (this.error == null ? 0 : this.error.hashCode());
    }

    public String toString() {
        boolean z = this.refreshing;
        return "RefreshState(refreshing=" + z + ", error=" + this.error + ")";
    }

    public RefreshState(boolean refreshing, String error) {
        this.refreshing = refreshing;
        this.error = error;
    }

    public final boolean getRefreshing() {
        return this.refreshing;
    }

    public final String getError() {
        return this.error;
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lkntr/app/game/base/viewmodel/RefreshState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Refreshing", "Lkntr/app/game/base/viewmodel/RefreshState;", "getRefreshing", "()Lkntr/app/game/base/viewmodel/RefreshState;", "Idle", "getIdle", "error", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RefreshState getRefreshing() {
            return RefreshState.Refreshing;
        }

        public final RefreshState getIdle() {
            return RefreshState.Idle;
        }

        public final RefreshState error(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new RefreshState(false, error);
        }
    }
}