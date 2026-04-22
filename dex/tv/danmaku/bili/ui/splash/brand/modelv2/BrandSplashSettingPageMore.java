package tv.danmaku.bili.ui.splash.brand.modelv2;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingPageMore.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J1\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "", "hasMore", "", "lastSplashBizId", "", "groupNo", "", "type", "", "<init>", "(ZJLjava/lang/String;I)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLastSplashBizId", "()J", "setLastSplashBizId", "(J)V", "getGroupNo", "()Ljava/lang/String;", "setGroupNo", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingPageMore {
    public static final int $stable = 8;
    @SerializedName("group_no")
    private String groupNo;
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("last_splash_biz_id")
    private long lastSplashBizId;
    @SerializedName("type")
    private int type;

    public static /* synthetic */ BrandSplashSettingPageMore copy$default(BrandSplashSettingPageMore brandSplashSettingPageMore, boolean z, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = brandSplashSettingPageMore.hasMore;
        }
        if ((i2 & 2) != 0) {
            j = brandSplashSettingPageMore.lastSplashBizId;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str = brandSplashSettingPageMore.groupNo;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = brandSplashSettingPageMore.type;
        }
        return brandSplashSettingPageMore.copy(z, j2, str2, i);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final long component2() {
        return this.lastSplashBizId;
    }

    public final String component3() {
        return this.groupNo;
    }

    public final int component4() {
        return this.type;
    }

    public final BrandSplashSettingPageMore copy(boolean z, long j, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "groupNo");
        return new BrandSplashSettingPageMore(z, j, str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplashSettingPageMore) {
            BrandSplashSettingPageMore brandSplashSettingPageMore = (BrandSplashSettingPageMore) obj;
            return this.hasMore == brandSplashSettingPageMore.hasMore && this.lastSplashBizId == brandSplashSettingPageMore.lastSplashBizId && Intrinsics.areEqual(this.groupNo, brandSplashSettingPageMore.groupNo) && this.type == brandSplashSettingPageMore.type;
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lastSplashBizId)) * 31) + this.groupNo.hashCode()) * 31) + this.type;
    }

    public String toString() {
        boolean z = this.hasMore;
        long j = this.lastSplashBizId;
        String str = this.groupNo;
        return "BrandSplashSettingPageMore(hasMore=" + z + ", lastSplashBizId=" + j + ", groupNo=" + str + ", type=" + this.type + ")";
    }

    public BrandSplashSettingPageMore(boolean hasMore, long lastSplashBizId, String groupNo, int type) {
        Intrinsics.checkNotNullParameter(groupNo, "groupNo");
        this.hasMore = hasMore;
        this.lastSplashBizId = lastSplashBizId;
        this.groupNo = groupNo;
        this.type = type;
    }

    public /* synthetic */ BrandSplashSettingPageMore(boolean z, long j, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? "" : str, i);
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final long getLastSplashBizId() {
        return this.lastSplashBizId;
    }

    public final void setLastSplashBizId(long j) {
        this.lastSplashBizId = j;
    }

    public final String getGroupNo() {
        return this.groupNo;
    }

    public final void setGroupNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupNo = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}