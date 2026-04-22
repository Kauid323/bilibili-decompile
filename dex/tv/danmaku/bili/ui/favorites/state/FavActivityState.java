package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabs;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIState;

/* compiled from: FavoritesState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavActivityState;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIState;", "pageState", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "showAddIcon", "", "tabs", "Ltv/danmaku/bili/ui/favorites/model/FavoritesTabs;", "<init>", "(Ltv/danmaku/bili/ui/favorites/state/FavPageState;ZLtv/danmaku/bili/ui/favorites/model/FavoritesTabs;)V", "getPageState", "()Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "getShowAddIcon", "()Z", "getTabs", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesTabs;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavActivityState implements IUIState {
    public static final int $stable = 8;
    private final FavPageState pageState;
    private final boolean showAddIcon;
    private final FavoritesTabs tabs;

    public FavActivityState() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ FavActivityState copy$default(FavActivityState favActivityState, FavPageState favPageState, boolean z, FavoritesTabs favoritesTabs, int i, Object obj) {
        if ((i & 1) != 0) {
            favPageState = favActivityState.pageState;
        }
        if ((i & 2) != 0) {
            z = favActivityState.showAddIcon;
        }
        if ((i & 4) != 0) {
            favoritesTabs = favActivityState.tabs;
        }
        return favActivityState.copy(favPageState, z, favoritesTabs);
    }

    public final FavPageState component1() {
        return this.pageState;
    }

    public final boolean component2() {
        return this.showAddIcon;
    }

    public final FavoritesTabs component3() {
        return this.tabs;
    }

    public final FavActivityState copy(FavPageState favPageState, boolean z, FavoritesTabs favoritesTabs) {
        Intrinsics.checkNotNullParameter(favPageState, "pageState");
        Intrinsics.checkNotNullParameter(favoritesTabs, "tabs");
        return new FavActivityState(favPageState, z, favoritesTabs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavActivityState) {
            FavActivityState favActivityState = (FavActivityState) obj;
            return Intrinsics.areEqual(this.pageState, favActivityState.pageState) && this.showAddIcon == favActivityState.showAddIcon && Intrinsics.areEqual(this.tabs, favActivityState.tabs);
        }
        return false;
    }

    public int hashCode() {
        return (((this.pageState.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showAddIcon)) * 31) + this.tabs.hashCode();
    }

    public String toString() {
        FavPageState favPageState = this.pageState;
        boolean z = this.showAddIcon;
        return "FavActivityState(pageState=" + favPageState + ", showAddIcon=" + z + ", tabs=" + this.tabs + ")";
    }

    public FavActivityState(FavPageState pageState, boolean showAddIcon, FavoritesTabs tabs) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        this.pageState = pageState;
        this.showAddIcon = showAddIcon;
        this.tabs = tabs;
    }

    public /* synthetic */ FavActivityState(FavPageState.Init init, boolean z, FavoritesTabs favoritesTabs, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FavPageState.Init.INSTANCE : init, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new FavoritesTabs(0, null, 3, null) : favoritesTabs);
    }

    public final FavPageState getPageState() {
        return this.pageState;
    }

    public final boolean getShowAddIcon() {
        return this.showAddIcon;
    }

    public final FavoritesTabs getTabs() {
        return this.tabs;
    }
}