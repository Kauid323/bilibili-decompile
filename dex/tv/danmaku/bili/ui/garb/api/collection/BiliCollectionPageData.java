package tv.danmaku.bili.ui.garb.api.collection;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: BiliCollectionData.kt */
@Bson
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionPageData;", "", "ps", "", "hasMore", "", "lastId", "", "lastType", "<init>", "(IZJI)V", "getPs", "()I", "getHasMore", "()Z", "getLastId", "()J", "getLastType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCollectionPageData {
    public static final int $stable = 0;
    @SerializedName("has_more")
    private final boolean hasMore;
    @SerializedName("last_id")
    private final long lastId;
    @SerializedName("last_type")
    private final int lastType;
    @SerializedName("ps")
    private final int ps;

    public static /* synthetic */ BiliCollectionPageData copy$default(BiliCollectionPageData biliCollectionPageData, int i, boolean z, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = biliCollectionPageData.ps;
        }
        if ((i3 & 2) != 0) {
            z = biliCollectionPageData.hasMore;
        }
        boolean z2 = z;
        if ((i3 & 4) != 0) {
            j = biliCollectionPageData.lastId;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            i2 = biliCollectionPageData.lastType;
        }
        return biliCollectionPageData.copy(i, z2, j2, i2);
    }

    public final int component1() {
        return this.ps;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final long component3() {
        return this.lastId;
    }

    public final int component4() {
        return this.lastType;
    }

    public final BiliCollectionPageData copy(int i, boolean z, long j, int i2) {
        return new BiliCollectionPageData(i, z, j, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCollectionPageData) {
            BiliCollectionPageData biliCollectionPageData = (BiliCollectionPageData) obj;
            return this.ps == biliCollectionPageData.ps && this.hasMore == biliCollectionPageData.hasMore && this.lastId == biliCollectionPageData.lastId && this.lastType == biliCollectionPageData.lastType;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.ps * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lastId)) * 31) + this.lastType;
    }

    public String toString() {
        int i = this.ps;
        boolean z = this.hasMore;
        long j = this.lastId;
        return "BiliCollectionPageData(ps=" + i + ", hasMore=" + z + ", lastId=" + j + ", lastType=" + this.lastType + ")";
    }

    public BiliCollectionPageData(int ps, boolean hasMore, long lastId, int lastType) {
        this.ps = ps;
        this.hasMore = hasMore;
        this.lastId = lastId;
        this.lastType = lastType;
    }

    public final int getPs() {
        return this.ps;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getLastId() {
        return this.lastId;
    }

    public final int getLastType() {
        return this.lastType;
    }
}