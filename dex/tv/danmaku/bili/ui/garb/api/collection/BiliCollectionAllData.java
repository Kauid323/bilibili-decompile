package tv.danmaku.bili.ui.garb.api.collection;

import BottomSheetItemData$;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: BiliCollectionData.kt */
@Bson
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;", "", "result", "", "Lcom/bili/digital/common/data/SpaceBannerItem;", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionPageData;", "total", "", "all", "collectionPublic", "", "<init>", "(Ljava/util/List;Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionPageData;IIZ)V", "getResult", "()Ljava/util/List;", "getPage", "()Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionPageData;", "getTotal", "()I", "getAll", "getCollectionPublic", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCollectionAllData {
    public static final int $stable = 8;
    @SerializedName("all")
    private final int all;
    @SerializedName("collection_public")
    private final boolean collectionPublic;
    @SerializedName(LoginReporterV2.PAGE_FROM_KEY)
    private final BiliCollectionPageData page;
    @SerializedName("result")
    private final List<SpaceBannerItem> result;
    @SerializedName("total")
    private final int total;

    public static /* synthetic */ BiliCollectionAllData copy$default(BiliCollectionAllData biliCollectionAllData, List list, BiliCollectionPageData biliCollectionPageData, int i, int i2, boolean z, int i3, Object obj) {
        List<SpaceBannerItem> list2 = list;
        if ((i3 & 1) != 0) {
            list2 = biliCollectionAllData.result;
        }
        if ((i3 & 2) != 0) {
            biliCollectionPageData = biliCollectionAllData.page;
        }
        BiliCollectionPageData biliCollectionPageData2 = biliCollectionPageData;
        if ((i3 & 4) != 0) {
            i = biliCollectionAllData.total;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = biliCollectionAllData.all;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            z = biliCollectionAllData.collectionPublic;
        }
        return biliCollectionAllData.copy(list2, biliCollectionPageData2, i4, i5, z);
    }

    public final List<SpaceBannerItem> component1() {
        return this.result;
    }

    public final BiliCollectionPageData component2() {
        return this.page;
    }

    public final int component3() {
        return this.total;
    }

    public final int component4() {
        return this.all;
    }

    public final boolean component5() {
        return this.collectionPublic;
    }

    public final BiliCollectionAllData copy(List<SpaceBannerItem> list, BiliCollectionPageData biliCollectionPageData, int i, int i2, boolean z) {
        return new BiliCollectionAllData(list, biliCollectionPageData, i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCollectionAllData) {
            BiliCollectionAllData biliCollectionAllData = (BiliCollectionAllData) obj;
            return Intrinsics.areEqual(this.result, biliCollectionAllData.result) && Intrinsics.areEqual(this.page, biliCollectionAllData.page) && this.total == biliCollectionAllData.total && this.all == biliCollectionAllData.all && this.collectionPublic == biliCollectionAllData.collectionPublic;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.result == null ? 0 : this.result.hashCode()) * 31) + (this.page != null ? this.page.hashCode() : 0)) * 31) + this.total) * 31) + this.all) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.collectionPublic);
    }

    public String toString() {
        List<SpaceBannerItem> list = this.result;
        BiliCollectionPageData biliCollectionPageData = this.page;
        int i = this.total;
        int i2 = this.all;
        return "BiliCollectionAllData(result=" + list + ", page=" + biliCollectionPageData + ", total=" + i + ", all=" + i2 + ", collectionPublic=" + this.collectionPublic + ")";
    }

    public BiliCollectionAllData(List<SpaceBannerItem> list, BiliCollectionPageData page, int total, int all, boolean collectionPublic) {
        this.result = list;
        this.page = page;
        this.total = total;
        this.all = all;
        this.collectionPublic = collectionPublic;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BiliCollectionAllData(List list, BiliCollectionPageData biliCollectionPageData, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r3, i, i2, z);
        List list2;
        BiliCollectionPageData biliCollectionPageData2;
        if ((i3 & 1) == 0) {
            list2 = list;
        } else {
            list2 = null;
        }
        if ((i3 & 2) == 0) {
            biliCollectionPageData2 = biliCollectionPageData;
        } else {
            biliCollectionPageData2 = null;
        }
    }

    public final List<SpaceBannerItem> getResult() {
        return this.result;
    }

    public final BiliCollectionPageData getPage() {
        return this.page;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getAll() {
        return this.all;
    }

    public final boolean getCollectionPublic() {
        return this.collectionPublic;
    }
}