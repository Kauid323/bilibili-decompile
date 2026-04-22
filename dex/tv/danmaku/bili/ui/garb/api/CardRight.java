package tv.danmaku.bili.ui.garb.api;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CardRight;", "", "headPicExpire", "", "bannerBgExpire", "<init>", "(JJ)V", "getHeadPicExpire", "()J", "getBannerBgExpire", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardRight {
    public static final int $stable = 0;
    @SerializedName("banner_bg_expire")
    private final long bannerBgExpire;
    @SerializedName("head_pic_expire")
    private final long headPicExpire;

    public static /* synthetic */ CardRight copy$default(CardRight cardRight, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cardRight.headPicExpire;
        }
        if ((i & 2) != 0) {
            j2 = cardRight.bannerBgExpire;
        }
        return cardRight.copy(j, j2);
    }

    public final long component1() {
        return this.headPicExpire;
    }

    public final long component2() {
        return this.bannerBgExpire;
    }

    public final CardRight copy(long j, long j2) {
        return new CardRight(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardRight) {
            CardRight cardRight = (CardRight) obj;
            return this.headPicExpire == cardRight.headPicExpire && this.bannerBgExpire == cardRight.bannerBgExpire;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.headPicExpire) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.bannerBgExpire);
    }

    public String toString() {
        long j = this.headPicExpire;
        return "CardRight(headPicExpire=" + j + ", bannerBgExpire=" + this.bannerBgExpire + ")";
    }

    public CardRight(long headPicExpire, long bannerBgExpire) {
        this.headPicExpire = headPicExpire;
        this.bannerBgExpire = bannerBgExpire;
    }

    public final long getHeadPicExpire() {
        return this.headPicExpire;
    }

    public final long getBannerBgExpire() {
        return this.bannerBgExpire;
    }
}