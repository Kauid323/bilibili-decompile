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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JW\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FollowResponse;", "", "count", "", "hasMore", "", "hasInvalid", "nextOid", "", "nextOType", "list", "", "Ltv/danmaku/bili/ui/favorites/model/FollowItem;", "nextScore", "<init>", "(IZZJILjava/util/List;I)V", "getCount", "()I", "getHasMore", "()Z", "getHasInvalid", "getNextOid", "()J", "getNextOType", "getList", "()Ljava/util/List;", "getNextScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowResponse {
    public static final int $stable = 8;
    @SerializedName("count")
    private final int count;
    @SerializedName("has_invalid")
    private final boolean hasInvalid;
    @SerializedName("has_more")
    private final boolean hasMore;
    @SerializedName("list")
    private final List<FollowItem> list;
    @SerializedName("next_otype")
    private final int nextOType;
    @SerializedName("next_oid")
    private final long nextOid;
    @SerializedName("next_score")
    private final int nextScore;

    public FollowResponse() {
        this(0, false, false, 0L, 0, null, 0, BR.countdownTrackEnabled, null);
    }

    public final int component1() {
        return this.count;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final boolean component3() {
        return this.hasInvalid;
    }

    public final long component4() {
        return this.nextOid;
    }

    public final int component5() {
        return this.nextOType;
    }

    public final List<FollowItem> component6() {
        return this.list;
    }

    public final int component7() {
        return this.nextScore;
    }

    public final FollowResponse copy(int i, boolean z, boolean z2, long j, int i2, List<FollowItem> list, int i3) {
        return new FollowResponse(i, z, z2, j, i2, list, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FollowResponse) {
            FollowResponse followResponse = (FollowResponse) obj;
            return this.count == followResponse.count && this.hasMore == followResponse.hasMore && this.hasInvalid == followResponse.hasInvalid && this.nextOid == followResponse.nextOid && this.nextOType == followResponse.nextOType && Intrinsics.areEqual(this.list, followResponse.list) && this.nextScore == followResponse.nextScore;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.count * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasInvalid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.nextOid)) * 31) + this.nextOType) * 31) + (this.list == null ? 0 : this.list.hashCode())) * 31) + this.nextScore;
    }

    public String toString() {
        int i = this.count;
        boolean z = this.hasMore;
        boolean z2 = this.hasInvalid;
        long j = this.nextOid;
        int i2 = this.nextOType;
        List<FollowItem> list = this.list;
        return "FollowResponse(count=" + i + ", hasMore=" + z + ", hasInvalid=" + z2 + ", nextOid=" + j + ", nextOType=" + i2 + ", list=" + list + ", nextScore=" + this.nextScore + ")";
    }

    public FollowResponse(int count, boolean hasMore, boolean hasInvalid, long nextOid, int nextOType, List<FollowItem> list, int nextScore) {
        this.count = count;
        this.hasMore = hasMore;
        this.hasInvalid = hasInvalid;
        this.nextOid = nextOid;
        this.nextOType = nextOType;
        this.list = list;
        this.nextScore = nextScore;
    }

    public /* synthetic */ FollowResponse(int i, boolean z, boolean z2, long j, int i2, List list, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? false : z2, (i4 & 8) != 0 ? 0L : j, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list, (i4 & 64) == 0 ? i3 : 0);
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasInvalid() {
        return this.hasInvalid;
    }

    public final long getNextOid() {
        return this.nextOid;
    }

    public final int getNextOType() {
        return this.nextOType;
    }

    public final List<FollowItem> getList() {
        return this.list;
    }

    public final int getNextScore() {
        return this.nextScore;
    }
}