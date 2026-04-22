package tv.danmaku.bili.ui.favorites.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JW\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FavoritesTabList;", "", "total", "", "hasMore", "", "hasInvalid", "list", "", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "nextOid", "", "nextOType", "nextScore", "<init>", "(IZZLjava/util/List;JII)V", "getTotal", "()I", "getHasMore", "()Z", "getHasInvalid", "getList", "()Ljava/util/List;", "getNextOid", "()J", "getNextOType", "getNextScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesTabList {
    public static final int $stable = 8;
    @SerializedName("has_invalid")
    private final boolean hasInvalid;
    @SerializedName("has_more")
    private final boolean hasMore;
    @SerializedName("list")
    private final List<FavoritesMediasItem> list;
    @SerializedName("next_otype")
    private final int nextOType;
    @SerializedName("next_oid")
    private final long nextOid;
    @SerializedName("next_score")
    private final int nextScore;
    @SerializedName("total")
    private final int total;

    public FavoritesTabList() {
        this(0, false, false, null, 0L, 0, 0, BR.countdownTrackEnabled, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavoritesTabList copy$default(FavoritesTabList favoritesTabList, int i, boolean z, boolean z2, List list, long j, int i2, int i3, int i4, Object obj) {
        return favoritesTabList.copy((i4 & 1) != 0 ? favoritesTabList.total : i, (i4 & 2) != 0 ? favoritesTabList.hasMore : z, (i4 & 4) != 0 ? favoritesTabList.hasInvalid : z2, (i4 & 8) != 0 ? favoritesTabList.list : list, (i4 & 16) != 0 ? favoritesTabList.nextOid : j, (i4 & 32) != 0 ? favoritesTabList.nextOType : i2, (i4 & 64) != 0 ? favoritesTabList.nextScore : i3);
    }

    public final int component1() {
        return this.total;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final boolean component3() {
        return this.hasInvalid;
    }

    public final List<FavoritesMediasItem> component4() {
        return this.list;
    }

    public final long component5() {
        return this.nextOid;
    }

    public final int component6() {
        return this.nextOType;
    }

    public final int component7() {
        return this.nextScore;
    }

    public final FavoritesTabList copy(int i, boolean z, boolean z2, List<FavoritesMediasItem> list, long j, int i2, int i3) {
        return new FavoritesTabList(i, z, z2, list, j, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoritesTabList) {
            FavoritesTabList favoritesTabList = (FavoritesTabList) obj;
            return this.total == favoritesTabList.total && this.hasMore == favoritesTabList.hasMore && this.hasInvalid == favoritesTabList.hasInvalid && Intrinsics.areEqual(this.list, favoritesTabList.list) && this.nextOid == favoritesTabList.nextOid && this.nextOType == favoritesTabList.nextOType && this.nextScore == favoritesTabList.nextScore;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.total * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasInvalid)) * 31) + (this.list == null ? 0 : this.list.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.nextOid)) * 31) + this.nextOType) * 31) + this.nextScore;
    }

    public String toString() {
        int i = this.total;
        boolean z = this.hasMore;
        boolean z2 = this.hasInvalid;
        List<FavoritesMediasItem> list = this.list;
        long j = this.nextOid;
        int i2 = this.nextOType;
        return "FavoritesTabList(total=" + i + ", hasMore=" + z + ", hasInvalid=" + z2 + ", list=" + list + ", nextOid=" + j + ", nextOType=" + i2 + ", nextScore=" + this.nextScore + ")";
    }

    public FavoritesTabList(int total, boolean hasMore, boolean hasInvalid, List<FavoritesMediasItem> list, long nextOid, int nextOType, int nextScore) {
        this.total = total;
        this.hasMore = hasMore;
        this.hasInvalid = hasInvalid;
        this.list = list;
        this.nextOid = nextOid;
        this.nextOType = nextOType;
        this.nextScore = nextScore;
    }

    public /* synthetic */ FavoritesTabList(int i, boolean z, boolean z2, List list, long j, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? false : z2, (i4 & 8) != 0 ? CollectionsKt.emptyList() : list, (i4 & 16) != 0 ? 0L : j, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) == 0 ? i3 : 0);
    }

    public final int getTotal() {
        return this.total;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasInvalid() {
        return this.hasInvalid;
    }

    public final List<FavoritesMediasItem> getList() {
        return this.list;
    }

    public final long getNextOid() {
        return this.nextOid;
    }

    public final int getNextOType() {
        return this.nextOType;
    }

    public final int getNextScore() {
        return this.nextScore;
    }
}