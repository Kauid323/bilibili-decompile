package tv.danmaku.bili.ui.garb.api.collection;

import com.bili.digital.common.data.BiliCollectionPreferenceData;
import com.bili.digital.common.data.SpaceBannerTop;
import com.bilibili.bson.common.Bson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliCollectionData.kt */
@Bson
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionData;", "", "preference", "Lcom/bili/digital/common/data/BiliCollectionPreferenceData;", "all", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;", "top", "Lcom/bili/digital/common/data/SpaceBannerTop;", "globalInfo", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoData;", "userInfo", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionUserData;", "<init>", "(Lcom/bili/digital/common/data/BiliCollectionPreferenceData;Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;Lcom/bili/digital/common/data/SpaceBannerTop;Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoData;Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionUserData;)V", "getPreference", "()Lcom/bili/digital/common/data/BiliCollectionPreferenceData;", "getAll", "()Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionAllData;", "getTop", "()Lcom/bili/digital/common/data/SpaceBannerTop;", "getGlobalInfo", "()Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoData;", "getUserInfo", "()Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionUserData;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliCollectionData {
    public static final int $stable = 8;
    private final BiliCollectionAllData all;
    private final BiliCollectionGlobalInfoData globalInfo;
    private final BiliCollectionPreferenceData preference;
    private final SpaceBannerTop top;
    private final BiliCollectionUserData userInfo;

    public BiliCollectionData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BiliCollectionData copy$default(BiliCollectionData biliCollectionData, BiliCollectionPreferenceData biliCollectionPreferenceData, BiliCollectionAllData biliCollectionAllData, SpaceBannerTop spaceBannerTop, BiliCollectionGlobalInfoData biliCollectionGlobalInfoData, BiliCollectionUserData biliCollectionUserData, int i, Object obj) {
        if ((i & 1) != 0) {
            biliCollectionPreferenceData = biliCollectionData.preference;
        }
        if ((i & 2) != 0) {
            biliCollectionAllData = biliCollectionData.all;
        }
        BiliCollectionAllData biliCollectionAllData2 = biliCollectionAllData;
        if ((i & 4) != 0) {
            spaceBannerTop = biliCollectionData.top;
        }
        SpaceBannerTop spaceBannerTop2 = spaceBannerTop;
        if ((i & 8) != 0) {
            biliCollectionGlobalInfoData = biliCollectionData.globalInfo;
        }
        BiliCollectionGlobalInfoData biliCollectionGlobalInfoData2 = biliCollectionGlobalInfoData;
        if ((i & 16) != 0) {
            biliCollectionUserData = biliCollectionData.userInfo;
        }
        return biliCollectionData.copy(biliCollectionPreferenceData, biliCollectionAllData2, spaceBannerTop2, biliCollectionGlobalInfoData2, biliCollectionUserData);
    }

    public final BiliCollectionPreferenceData component1() {
        return this.preference;
    }

    public final BiliCollectionAllData component2() {
        return this.all;
    }

    public final SpaceBannerTop component3() {
        return this.top;
    }

    public final BiliCollectionGlobalInfoData component4() {
        return this.globalInfo;
    }

    public final BiliCollectionUserData component5() {
        return this.userInfo;
    }

    public final BiliCollectionData copy(BiliCollectionPreferenceData biliCollectionPreferenceData, BiliCollectionAllData biliCollectionAllData, SpaceBannerTop spaceBannerTop, BiliCollectionGlobalInfoData biliCollectionGlobalInfoData, BiliCollectionUserData biliCollectionUserData) {
        return new BiliCollectionData(biliCollectionPreferenceData, biliCollectionAllData, spaceBannerTop, biliCollectionGlobalInfoData, biliCollectionUserData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCollectionData) {
            BiliCollectionData biliCollectionData = (BiliCollectionData) obj;
            return Intrinsics.areEqual(this.preference, biliCollectionData.preference) && Intrinsics.areEqual(this.all, biliCollectionData.all) && Intrinsics.areEqual(this.top, biliCollectionData.top) && Intrinsics.areEqual(this.globalInfo, biliCollectionData.globalInfo) && Intrinsics.areEqual(this.userInfo, biliCollectionData.userInfo);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.preference == null ? 0 : this.preference.hashCode()) * 31) + (this.all == null ? 0 : this.all.hashCode())) * 31) + (this.top == null ? 0 : this.top.hashCode())) * 31) + (this.globalInfo == null ? 0 : this.globalInfo.hashCode())) * 31) + (this.userInfo != null ? this.userInfo.hashCode() : 0);
    }

    public String toString() {
        BiliCollectionPreferenceData biliCollectionPreferenceData = this.preference;
        BiliCollectionAllData biliCollectionAllData = this.all;
        SpaceBannerTop spaceBannerTop = this.top;
        BiliCollectionGlobalInfoData biliCollectionGlobalInfoData = this.globalInfo;
        return "BiliCollectionData(preference=" + biliCollectionPreferenceData + ", all=" + biliCollectionAllData + ", top=" + spaceBannerTop + ", globalInfo=" + biliCollectionGlobalInfoData + ", userInfo=" + this.userInfo + ")";
    }

    public BiliCollectionData(BiliCollectionPreferenceData preference, BiliCollectionAllData all, SpaceBannerTop top, BiliCollectionGlobalInfoData globalInfo, BiliCollectionUserData userInfo) {
        this.preference = preference;
        this.all = all;
        this.top = top;
        this.globalInfo = globalInfo;
        this.userInfo = userInfo;
    }

    public /* synthetic */ BiliCollectionData(BiliCollectionPreferenceData biliCollectionPreferenceData, BiliCollectionAllData biliCollectionAllData, SpaceBannerTop spaceBannerTop, BiliCollectionGlobalInfoData biliCollectionGlobalInfoData, BiliCollectionUserData biliCollectionUserData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : biliCollectionPreferenceData, (i & 2) != 0 ? null : biliCollectionAllData, (i & 4) != 0 ? null : spaceBannerTop, (i & 8) != 0 ? null : biliCollectionGlobalInfoData, (i & 16) != 0 ? null : biliCollectionUserData);
    }

    public final BiliCollectionPreferenceData getPreference() {
        return this.preference;
    }

    public final BiliCollectionAllData getAll() {
        return this.all;
    }

    public final SpaceBannerTop getTop() {
        return this.top;
    }

    public final BiliCollectionGlobalInfoData getGlobalInfo() {
        return this.globalInfo;
    }

    public final BiliCollectionUserData getUserInfo() {
        return this.userInfo;
    }
}