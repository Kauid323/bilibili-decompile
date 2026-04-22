package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: RatingDialogBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/rating/RatingPopup;", "", ReportUtilKt.POS_TITLE, "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingPopup {
    public static final int $stable = 0;
    private final String title;

    public RatingPopup() {
        this(null, 1, null);
    }

    public static /* synthetic */ RatingPopup copy$default(RatingPopup ratingPopup, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ratingPopup.title;
        }
        return ratingPopup.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final RatingPopup copy(String str) {
        return new RatingPopup(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RatingPopup) && Intrinsics.areEqual(this.title, ((RatingPopup) obj).title);
    }

    public int hashCode() {
        if (this.title == null) {
            return 0;
        }
        return this.title.hashCode();
    }

    public String toString() {
        return "RatingPopup(title=" + this.title + ")";
    }

    public RatingPopup(String title) {
        this.title = title;
    }

    public /* synthetic */ RatingPopup(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getTitle() {
        return this.title;
    }
}