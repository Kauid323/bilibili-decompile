package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RatingDialogBean.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/rating/RatingThenGuide;", "", "ratingPopup", "Ltv/danmaku/bili/rating/RatingPopup;", "guidePopup", "Ltv/danmaku/bili/rating/PopupBasicInfo;", "<init>", "(Ltv/danmaku/bili/rating/RatingPopup;Ltv/danmaku/bili/rating/PopupBasicInfo;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/RatingThenGuide;", "(Lcom/bapis/bilibili/app/home/v1/RatingThenGuide;)V", "getRatingPopup", "()Ltv/danmaku/bili/rating/RatingPopup;", "getGuidePopup", "()Ltv/danmaku/bili/rating/PopupBasicInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingThenGuide {
    public static final int $stable = 0;
    private final PopupBasicInfo guidePopup;
    private final RatingPopup ratingPopup;

    public RatingThenGuide() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ RatingThenGuide copy$default(RatingThenGuide ratingThenGuide, RatingPopup ratingPopup, PopupBasicInfo popupBasicInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            ratingPopup = ratingThenGuide.ratingPopup;
        }
        if ((i & 2) != 0) {
            popupBasicInfo = ratingThenGuide.guidePopup;
        }
        return ratingThenGuide.copy(ratingPopup, popupBasicInfo);
    }

    public final RatingPopup component1() {
        return this.ratingPopup;
    }

    public final PopupBasicInfo component2() {
        return this.guidePopup;
    }

    public final RatingThenGuide copy(RatingPopup ratingPopup, PopupBasicInfo popupBasicInfo) {
        return new RatingThenGuide(ratingPopup, popupBasicInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingThenGuide) {
            RatingThenGuide ratingThenGuide = (RatingThenGuide) obj;
            return Intrinsics.areEqual(this.ratingPopup, ratingThenGuide.ratingPopup) && Intrinsics.areEqual(this.guidePopup, ratingThenGuide.guidePopup);
        }
        return false;
    }

    public int hashCode() {
        return ((this.ratingPopup == null ? 0 : this.ratingPopup.hashCode()) * 31) + (this.guidePopup != null ? this.guidePopup.hashCode() : 0);
    }

    public String toString() {
        RatingPopup ratingPopup = this.ratingPopup;
        return "RatingThenGuide(ratingPopup=" + ratingPopup + ", guidePopup=" + this.guidePopup + ")";
    }

    public RatingThenGuide(RatingPopup ratingPopup, PopupBasicInfo guidePopup) {
        this.ratingPopup = ratingPopup;
        this.guidePopup = guidePopup;
    }

    public /* synthetic */ RatingThenGuide(RatingPopup ratingPopup, PopupBasicInfo popupBasicInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ratingPopup, (i & 2) != 0 ? null : popupBasicInfo);
    }

    public final RatingPopup getRatingPopup() {
        return this.ratingPopup;
    }

    public final PopupBasicInfo getGuidePopup() {
        return this.guidePopup;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RatingThenGuide(com.bapis.bilibili.app.home.v1.RatingThenGuide builder) {
        this(r0, new PopupBasicInfo(r2));
        Intrinsics.checkNotNullParameter(builder, "builder");
        RatingPopup ratingPopup = new RatingPopup(builder.getRatingPopup().getTitle());
        com.bapis.bilibili.app.home.v1.PopupBasicInfo guidePopup = builder.getGuidePopup();
        Intrinsics.checkNotNullExpressionValue(guidePopup, "getGuidePopup(...)");
    }
}