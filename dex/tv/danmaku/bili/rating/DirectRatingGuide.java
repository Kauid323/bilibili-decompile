package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: RatingDialogBean.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/rating/DirectRatingGuide;", "", ReportUtilKt.POS_TITLE, "", "gotoButton", "Ltv/danmaku/bili/rating/PopupButton;", "feedbackButton", "cancelButton", "<init>", "(Ljava/lang/String;Ltv/danmaku/bili/rating/PopupButton;Ltv/danmaku/bili/rating/PopupButton;Ltv/danmaku/bili/rating/PopupButton;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/DirectRatingGuide;", "(Lcom/bapis/bilibili/app/home/v1/DirectRatingGuide;)V", "getTitle", "()Ljava/lang/String;", "getGotoButton", "()Ltv/danmaku/bili/rating/PopupButton;", "getFeedbackButton", "getCancelButton", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DirectRatingGuide {
    public static final int $stable = 0;
    private final PopupButton cancelButton;
    private final PopupButton feedbackButton;
    private final PopupButton gotoButton;
    private final String title;

    public DirectRatingGuide() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DirectRatingGuide copy$default(DirectRatingGuide directRatingGuide, String str, PopupButton popupButton, PopupButton popupButton2, PopupButton popupButton3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = directRatingGuide.title;
        }
        if ((i & 2) != 0) {
            popupButton = directRatingGuide.gotoButton;
        }
        if ((i & 4) != 0) {
            popupButton2 = directRatingGuide.feedbackButton;
        }
        if ((i & 8) != 0) {
            popupButton3 = directRatingGuide.cancelButton;
        }
        return directRatingGuide.copy(str, popupButton, popupButton2, popupButton3);
    }

    public final String component1() {
        return this.title;
    }

    public final PopupButton component2() {
        return this.gotoButton;
    }

    public final PopupButton component3() {
        return this.feedbackButton;
    }

    public final PopupButton component4() {
        return this.cancelButton;
    }

    public final DirectRatingGuide copy(String str, PopupButton popupButton, PopupButton popupButton2, PopupButton popupButton3) {
        return new DirectRatingGuide(str, popupButton, popupButton2, popupButton3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DirectRatingGuide) {
            DirectRatingGuide directRatingGuide = (DirectRatingGuide) obj;
            return Intrinsics.areEqual(this.title, directRatingGuide.title) && Intrinsics.areEqual(this.gotoButton, directRatingGuide.gotoButton) && Intrinsics.areEqual(this.feedbackButton, directRatingGuide.feedbackButton) && Intrinsics.areEqual(this.cancelButton, directRatingGuide.cancelButton);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.gotoButton == null ? 0 : this.gotoButton.hashCode())) * 31) + (this.feedbackButton == null ? 0 : this.feedbackButton.hashCode())) * 31) + (this.cancelButton != null ? this.cancelButton.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        PopupButton popupButton = this.gotoButton;
        PopupButton popupButton2 = this.feedbackButton;
        return "DirectRatingGuide(title=" + str + ", gotoButton=" + popupButton + ", feedbackButton=" + popupButton2 + ", cancelButton=" + this.cancelButton + ")";
    }

    public DirectRatingGuide(String title, PopupButton gotoButton, PopupButton feedbackButton, PopupButton cancelButton) {
        this.title = title;
        this.gotoButton = gotoButton;
        this.feedbackButton = feedbackButton;
        this.cancelButton = cancelButton;
    }

    public /* synthetic */ DirectRatingGuide(String str, PopupButton popupButton, PopupButton popupButton2, PopupButton popupButton3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : popupButton, (i & 4) != 0 ? null : popupButton2, (i & 8) != 0 ? null : popupButton3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final PopupButton getGotoButton() {
        return this.gotoButton;
    }

    public final PopupButton getFeedbackButton() {
        return this.feedbackButton;
    }

    public final PopupButton getCancelButton() {
        return this.cancelButton;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DirectRatingGuide(com.bapis.bilibili.app.home.v1.DirectRatingGuide builder) {
        this(r0, r1, r2, new PopupButton(r4));
        Intrinsics.checkNotNullParameter(builder, "builder");
        String title = builder.getTitle();
        com.bapis.bilibili.app.home.v1.PopupButton gotoButton = builder.getGotoButton();
        Intrinsics.checkNotNullExpressionValue(gotoButton, "getGotoButton(...)");
        PopupButton popupButton = new PopupButton(gotoButton);
        com.bapis.bilibili.app.home.v1.PopupButton feedbackButton = builder.getFeedbackButton();
        Intrinsics.checkNotNullExpressionValue(feedbackButton, "getFeedbackButton(...)");
        PopupButton popupButton2 = new PopupButton(feedbackButton);
        com.bapis.bilibili.app.home.v1.PopupButton cancelButton = builder.getCancelButton();
        Intrinsics.checkNotNullExpressionValue(cancelButton, "getCancelButton(...)");
    }
}