package tv.danmaku.bili.ui.watchlater.data;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;", "Ltv/danmaku/bili/ui/watchlater/data/WLState;", "tabAll", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;", "tabToView", "isCheckMode", "", "asc", "<init>", "(Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;ZZ)V", "getTabAll", "()Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;", "getTabToView", "()Z", "getAsc", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterState implements WLState {
    public static final int $stable = 0;
    private final boolean asc;
    private final boolean isCheckMode;
    private final WatchLaterTabState tabAll;
    private final WatchLaterTabState tabToView;

    public WatchLaterState() {
        this(null, null, false, false, 15, null);
    }

    public static /* synthetic */ WatchLaterState copy$default(WatchLaterState watchLaterState, WatchLaterTabState watchLaterTabState, WatchLaterTabState watchLaterTabState2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            watchLaterTabState = watchLaterState.tabAll;
        }
        if ((i & 2) != 0) {
            watchLaterTabState2 = watchLaterState.tabToView;
        }
        if ((i & 4) != 0) {
            z = watchLaterState.isCheckMode;
        }
        if ((i & 8) != 0) {
            z2 = watchLaterState.asc;
        }
        return watchLaterState.copy(watchLaterTabState, watchLaterTabState2, z, z2);
    }

    public final WatchLaterTabState component1() {
        return this.tabAll;
    }

    public final WatchLaterTabState component2() {
        return this.tabToView;
    }

    public final boolean component3() {
        return this.isCheckMode;
    }

    public final boolean component4() {
        return this.asc;
    }

    public final WatchLaterState copy(WatchLaterTabState watchLaterTabState, WatchLaterTabState watchLaterTabState2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(watchLaterTabState, "tabAll");
        Intrinsics.checkNotNullParameter(watchLaterTabState2, "tabToView");
        return new WatchLaterState(watchLaterTabState, watchLaterTabState2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterState) {
            WatchLaterState watchLaterState = (WatchLaterState) obj;
            return Intrinsics.areEqual(this.tabAll, watchLaterState.tabAll) && Intrinsics.areEqual(this.tabToView, watchLaterState.tabToView) && this.isCheckMode == watchLaterState.isCheckMode && this.asc == watchLaterState.asc;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.tabAll.hashCode() * 31) + this.tabToView.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCheckMode)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.asc);
    }

    public String toString() {
        WatchLaterTabState watchLaterTabState = this.tabAll;
        WatchLaterTabState watchLaterTabState2 = this.tabToView;
        boolean z = this.isCheckMode;
        return "WatchLaterState(tabAll=" + watchLaterTabState + ", tabToView=" + watchLaterTabState2 + ", isCheckMode=" + z + ", asc=" + this.asc + ")";
    }

    public WatchLaterState(WatchLaterTabState tabAll, WatchLaterTabState tabToView, boolean isCheckMode, boolean asc) {
        Intrinsics.checkNotNullParameter(tabAll, "tabAll");
        Intrinsics.checkNotNullParameter(tabToView, "tabToView");
        this.tabAll = tabAll;
        this.tabToView = tabToView;
        this.isCheckMode = isCheckMode;
        this.asc = asc;
    }

    public /* synthetic */ WatchLaterState(WatchLaterTabState watchLaterTabState, WatchLaterTabState watchLaterTabState2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new WatchLaterTabState(null, null, null, false, false, false, 63, null) : watchLaterTabState, (i & 2) != 0 ? new WatchLaterTabState(null, null, null, false, false, false, 63, null) : watchLaterTabState2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final WatchLaterTabState getTabAll() {
        return this.tabAll;
    }

    public final WatchLaterTabState getTabToView() {
        return this.tabToView;
    }

    public final boolean isCheckMode() {
        return this.isCheckMode;
    }

    public final boolean getAsc() {
        return this.asc;
    }
}