package tv.danmaku.bili.ui.favorites.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FavoritesTabs;", "", "defaultTab", "", "tabs", "", "Ltv/danmaku/bili/ui/favorites/model/Tab;", "<init>", "(ILjava/util/List;)V", "getDefaultTab", "()I", "getTabs", "()Ljava/util/List;", "defaultPosition", "getDefaultPosition", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesTabs {
    public static final int $stable = 8;
    @SerializedName(FavoritesConstsKt.KEY_DEFAULT_TAB_ID)
    private final int defaultTab;
    @SerializedName("tabs")
    private final List<Tab> tabs;

    public FavoritesTabs() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavoritesTabs copy$default(FavoritesTabs favoritesTabs, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = favoritesTabs.defaultTab;
        }
        if ((i2 & 2) != 0) {
            list = favoritesTabs.tabs;
        }
        return favoritesTabs.copy(i, list);
    }

    public final int component1() {
        return this.defaultTab;
    }

    public final List<Tab> component2() {
        return this.tabs;
    }

    public final FavoritesTabs copy(int i, List<Tab> list) {
        return new FavoritesTabs(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoritesTabs) {
            FavoritesTabs favoritesTabs = (FavoritesTabs) obj;
            return this.defaultTab == favoritesTabs.defaultTab && Intrinsics.areEqual(this.tabs, favoritesTabs.tabs);
        }
        return false;
    }

    public int hashCode() {
        return (this.defaultTab * 31) + (this.tabs == null ? 0 : this.tabs.hashCode());
    }

    public String toString() {
        int i = this.defaultTab;
        return "FavoritesTabs(defaultTab=" + i + ", tabs=" + this.tabs + ")";
    }

    public FavoritesTabs(int defaultTab, List<Tab> list) {
        this.defaultTab = defaultTab;
        this.tabs = list;
    }

    public /* synthetic */ FavoritesTabs(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final int getDefaultTab() {
        return this.defaultTab;
    }

    public final List<Tab> getTabs() {
        return this.tabs;
    }

    public final int getDefaultPosition() {
        List $this$indexOfFirst$iv = this.tabs;
        if ($this$indexOfFirst$iv != null) {
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                Tab it = (Tab) item$iv;
                if (it.getTabId() == this.defaultTab) {
                    return index$iv;
                }
                index$iv++;
            }
            return -1;
        }
        return 0;
    }
}