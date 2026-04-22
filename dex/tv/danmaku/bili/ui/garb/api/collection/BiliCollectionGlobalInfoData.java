package tv.danmaku.bili.ui.garb.api.collection;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliCollectionData.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoData;", "", "collectionBackgroundUrl", "", "collectionCompletedUrl", "sidebarInfo", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;", "maxSortNum", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;I)V", "getCollectionBackgroundUrl", "()Ljava/lang/String;", "getCollectionCompletedUrl", "getSidebarInfo", "()Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;", "getMaxSortNum", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCollectionGlobalInfoData {
    public static final int $stable = 0;
    @SerializedName("collection_background_url")
    private final String collectionBackgroundUrl;
    @SerializedName("collection_completed_url")
    private final String collectionCompletedUrl;
    @SerializedName("max_sort_num")
    private final int maxSortNum;
    @SerializedName("sidebar_info")
    private final BiliCollectionGlobalInfoSideBarData sidebarInfo;

    public static /* synthetic */ BiliCollectionGlobalInfoData copy$default(BiliCollectionGlobalInfoData biliCollectionGlobalInfoData, String str, String str2, BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = biliCollectionGlobalInfoData.collectionBackgroundUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = biliCollectionGlobalInfoData.collectionCompletedUrl;
        }
        if ((i2 & 4) != 0) {
            biliCollectionGlobalInfoSideBarData = biliCollectionGlobalInfoData.sidebarInfo;
        }
        if ((i2 & 8) != 0) {
            i = biliCollectionGlobalInfoData.maxSortNum;
        }
        return biliCollectionGlobalInfoData.copy(str, str2, biliCollectionGlobalInfoSideBarData, i);
    }

    public final String component1() {
        return this.collectionBackgroundUrl;
    }

    public final String component2() {
        return this.collectionCompletedUrl;
    }

    public final BiliCollectionGlobalInfoSideBarData component3() {
        return this.sidebarInfo;
    }

    public final int component4() {
        return this.maxSortNum;
    }

    public final BiliCollectionGlobalInfoData copy(String str, String str2, BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData, int i) {
        Intrinsics.checkNotNullParameter(str, "collectionBackgroundUrl");
        Intrinsics.checkNotNullParameter(str2, "collectionCompletedUrl");
        return new BiliCollectionGlobalInfoData(str, str2, biliCollectionGlobalInfoSideBarData, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCollectionGlobalInfoData) {
            BiliCollectionGlobalInfoData biliCollectionGlobalInfoData = (BiliCollectionGlobalInfoData) obj;
            return Intrinsics.areEqual(this.collectionBackgroundUrl, biliCollectionGlobalInfoData.collectionBackgroundUrl) && Intrinsics.areEqual(this.collectionCompletedUrl, biliCollectionGlobalInfoData.collectionCompletedUrl) && Intrinsics.areEqual(this.sidebarInfo, biliCollectionGlobalInfoData.sidebarInfo) && this.maxSortNum == biliCollectionGlobalInfoData.maxSortNum;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.collectionBackgroundUrl.hashCode() * 31) + this.collectionCompletedUrl.hashCode()) * 31) + (this.sidebarInfo == null ? 0 : this.sidebarInfo.hashCode())) * 31) + this.maxSortNum;
    }

    public String toString() {
        String str = this.collectionBackgroundUrl;
        String str2 = this.collectionCompletedUrl;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this.sidebarInfo;
        return "BiliCollectionGlobalInfoData(collectionBackgroundUrl=" + str + ", collectionCompletedUrl=" + str2 + ", sidebarInfo=" + biliCollectionGlobalInfoSideBarData + ", maxSortNum=" + this.maxSortNum + ")";
    }

    public BiliCollectionGlobalInfoData(String collectionBackgroundUrl, String collectionCompletedUrl, BiliCollectionGlobalInfoSideBarData sidebarInfo, int maxSortNum) {
        Intrinsics.checkNotNullParameter(collectionBackgroundUrl, "collectionBackgroundUrl");
        Intrinsics.checkNotNullParameter(collectionCompletedUrl, "collectionCompletedUrl");
        this.collectionBackgroundUrl = collectionBackgroundUrl;
        this.collectionCompletedUrl = collectionCompletedUrl;
        this.sidebarInfo = sidebarInfo;
        this.maxSortNum = maxSortNum;
    }

    public /* synthetic */ BiliCollectionGlobalInfoData(String str, String str2, BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : biliCollectionGlobalInfoSideBarData, i);
    }

    public final String getCollectionBackgroundUrl() {
        return this.collectionBackgroundUrl;
    }

    public final String getCollectionCompletedUrl() {
        return this.collectionCompletedUrl;
    }

    public final BiliCollectionGlobalInfoSideBarData getSidebarInfo() {
        return this.sidebarInfo;
    }

    public final int getMaxSortNum() {
        return this.maxSortNum;
    }
}