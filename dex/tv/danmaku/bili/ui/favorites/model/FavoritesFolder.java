package tv.danmaku.bili.ui.favorites.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FavoritesFolder;", "", "count", "", "list", "", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "<init>", "(ILjava/util/List;)V", "getCount", "()I", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFolder {
    public static final int $stable = 8;
    @SerializedName("count")
    private final int count;
    @SerializedName("list")
    private final List<FavoritesFolderItem> list;

    public FavoritesFolder() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavoritesFolder copy$default(FavoritesFolder favoritesFolder, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = favoritesFolder.count;
        }
        if ((i2 & 2) != 0) {
            list = favoritesFolder.list;
        }
        return favoritesFolder.copy(i, list);
    }

    public final int component1() {
        return this.count;
    }

    public final List<FavoritesFolderItem> component2() {
        return this.list;
    }

    public final FavoritesFolder copy(int i, List<FavoritesFolderItem> list) {
        return new FavoritesFolder(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoritesFolder) {
            FavoritesFolder favoritesFolder = (FavoritesFolder) obj;
            return this.count == favoritesFolder.count && Intrinsics.areEqual(this.list, favoritesFolder.list);
        }
        return false;
    }

    public int hashCode() {
        return (this.count * 31) + (this.list == null ? 0 : this.list.hashCode());
    }

    public String toString() {
        int i = this.count;
        return "FavoritesFolder(count=" + i + ", list=" + this.list + ")";
    }

    public FavoritesFolder(int count, List<FavoritesFolderItem> list) {
        this.count = count;
        this.list = list;
    }

    public /* synthetic */ FavoritesFolder(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final int getCount() {
        return this.count;
    }

    public final List<FavoritesFolderItem> getList() {
        return this.list;
    }
}