package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RatingDialogBean.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/rating/RatingGuidePopup;", "", "directRatingGuide", "Ltv/danmaku/bili/rating/DirectRatingGuide;", "ratingThenGuide", "Ltv/danmaku/bili/rating/RatingThenGuide;", "<init>", "(Ltv/danmaku/bili/rating/DirectRatingGuide;Ltv/danmaku/bili/rating/RatingThenGuide;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/RatingGuidePopup;", "(Lcom/bapis/bilibili/app/home/v1/RatingGuidePopup;)V", "getDirectRatingGuide", "()Ltv/danmaku/bili/rating/DirectRatingGuide;", "getRatingThenGuide", "()Ltv/danmaku/bili/rating/RatingThenGuide;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingGuidePopup {
    public static final int $stable = 0;
    private final DirectRatingGuide directRatingGuide;
    private final RatingThenGuide ratingThenGuide;

    public RatingGuidePopup() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ RatingGuidePopup copy$default(RatingGuidePopup ratingGuidePopup, DirectRatingGuide directRatingGuide, RatingThenGuide ratingThenGuide, int i, Object obj) {
        if ((i & 1) != 0) {
            directRatingGuide = ratingGuidePopup.directRatingGuide;
        }
        if ((i & 2) != 0) {
            ratingThenGuide = ratingGuidePopup.ratingThenGuide;
        }
        return ratingGuidePopup.copy(directRatingGuide, ratingThenGuide);
    }

    public final DirectRatingGuide component1() {
        return this.directRatingGuide;
    }

    public final RatingThenGuide component2() {
        return this.ratingThenGuide;
    }

    public final RatingGuidePopup copy(DirectRatingGuide directRatingGuide, RatingThenGuide ratingThenGuide) {
        return new RatingGuidePopup(directRatingGuide, ratingThenGuide);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingGuidePopup) {
            RatingGuidePopup ratingGuidePopup = (RatingGuidePopup) obj;
            return Intrinsics.areEqual(this.directRatingGuide, ratingGuidePopup.directRatingGuide) && Intrinsics.areEqual(this.ratingThenGuide, ratingGuidePopup.ratingThenGuide);
        }
        return false;
    }

    public int hashCode() {
        return ((this.directRatingGuide == null ? 0 : this.directRatingGuide.hashCode()) * 31) + (this.ratingThenGuide != null ? this.ratingThenGuide.hashCode() : 0);
    }

    public String toString() {
        DirectRatingGuide directRatingGuide = this.directRatingGuide;
        return "RatingGuidePopup(directRatingGuide=" + directRatingGuide + ", ratingThenGuide=" + this.ratingThenGuide + ")";
    }

    public RatingGuidePopup(DirectRatingGuide directRatingGuide, RatingThenGuide ratingThenGuide) {
        this.directRatingGuide = directRatingGuide;
        this.ratingThenGuide = ratingThenGuide;
    }

    public /* synthetic */ RatingGuidePopup(DirectRatingGuide directRatingGuide, RatingThenGuide ratingThenGuide, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : directRatingGuide, (i & 2) != 0 ? null : ratingThenGuide);
    }

    public final DirectRatingGuide getDirectRatingGuide() {
        return this.directRatingGuide;
    }

    public final RatingThenGuide getRatingThenGuide() {
        return this.ratingThenGuide;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RatingGuidePopup(com.bapis.bilibili.app.home.v1.RatingGuidePopup builder) {
        this(r0, r1);
        DirectRatingGuide directRatingGuide;
        Intrinsics.checkNotNullParameter(builder, "builder");
        RatingThenGuide ratingThenGuide = null;
        if (builder.hasDirectRatingGuide()) {
            com.bapis.bilibili.app.home.v1.DirectRatingGuide directRatingGuide2 = builder.getDirectRatingGuide();
            Intrinsics.checkNotNullExpressionValue(directRatingGuide2, "getDirectRatingGuide(...)");
            directRatingGuide = new DirectRatingGuide(directRatingGuide2);
        } else {
            directRatingGuide = null;
        }
        if (builder.hasRatingThenGuide()) {
            com.bapis.bilibili.app.home.v1.RatingThenGuide ratingThenGuide2 = builder.getRatingThenGuide();
            Intrinsics.checkNotNullExpressionValue(ratingThenGuide2, "getRatingThenGuide(...)");
            ratingThenGuide = new RatingThenGuide(ratingThenGuide2);
        }
    }
}