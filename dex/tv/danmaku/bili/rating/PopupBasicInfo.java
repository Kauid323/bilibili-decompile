package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: RatingDialogBean.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Ltv/danmaku/bili/rating/PopupBasicInfo;", "", ReportUtilKt.POS_TITLE, "", "subtitle", "icon", "confirmButton", "Ltv/danmaku/bili/rating/PopupButton;", "cancelButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/rating/PopupButton;Ltv/danmaku/bili/rating/PopupButton;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/PopupBasicInfo;", "(Lcom/bapis/bilibili/app/home/v1/PopupBasicInfo;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getIcon", "getConfirmButton", "()Ltv/danmaku/bili/rating/PopupButton;", "getCancelButton", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PopupBasicInfo {
    public static final int $stable = 0;
    private final PopupButton cancelButton;
    private final PopupButton confirmButton;
    private final String icon;
    private final String subtitle;
    private final String title;

    public PopupBasicInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PopupBasicInfo copy$default(PopupBasicInfo popupBasicInfo, String str, String str2, String str3, PopupButton popupButton, PopupButton popupButton2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = popupBasicInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = popupBasicInfo.subtitle;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = popupBasicInfo.icon;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            popupButton = popupBasicInfo.confirmButton;
        }
        PopupButton popupButton3 = popupButton;
        if ((i & 16) != 0) {
            popupButton2 = popupBasicInfo.cancelButton;
        }
        return popupBasicInfo.copy(str, str4, str5, popupButton3, popupButton2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.icon;
    }

    public final PopupButton component4() {
        return this.confirmButton;
    }

    public final PopupButton component5() {
        return this.cancelButton;
    }

    public final PopupBasicInfo copy(String str, String str2, String str3, PopupButton popupButton, PopupButton popupButton2) {
        return new PopupBasicInfo(str, str2, str3, popupButton, popupButton2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PopupBasicInfo) {
            PopupBasicInfo popupBasicInfo = (PopupBasicInfo) obj;
            return Intrinsics.areEqual(this.title, popupBasicInfo.title) && Intrinsics.areEqual(this.subtitle, popupBasicInfo.subtitle) && Intrinsics.areEqual(this.icon, popupBasicInfo.icon) && Intrinsics.areEqual(this.confirmButton, popupBasicInfo.confirmButton) && Intrinsics.areEqual(this.cancelButton, popupBasicInfo.cancelButton);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.confirmButton == null ? 0 : this.confirmButton.hashCode())) * 31) + (this.cancelButton != null ? this.cancelButton.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        String str3 = this.icon;
        PopupButton popupButton = this.confirmButton;
        return "PopupBasicInfo(title=" + str + ", subtitle=" + str2 + ", icon=" + str3 + ", confirmButton=" + popupButton + ", cancelButton=" + this.cancelButton + ")";
    }

    public PopupBasicInfo(String title, String subtitle, String icon, PopupButton confirmButton, PopupButton cancelButton) {
        this.title = title;
        this.subtitle = subtitle;
        this.icon = icon;
        this.confirmButton = confirmButton;
        this.cancelButton = cancelButton;
    }

    public /* synthetic */ PopupBasicInfo(String str, String str2, String str3, PopupButton popupButton, PopupButton popupButton2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : popupButton, (i & 16) != 0 ? null : popupButton2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final PopupButton getConfirmButton() {
        return this.confirmButton;
    }

    public final PopupButton getCancelButton() {
        return this.cancelButton;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PopupBasicInfo(com.bapis.bilibili.app.home.v1.PopupBasicInfo builder) {
        this(r2, r3, r4, r5, new PopupButton(r0));
        Intrinsics.checkNotNullParameter(builder, "builder");
        String title = builder.getTitle();
        String subtitle = builder.getSubtitle();
        String icon = builder.getIcon();
        com.bapis.bilibili.app.home.v1.PopupButton confirmButton = builder.getConfirmButton();
        Intrinsics.checkNotNullExpressionValue(confirmButton, "getConfirmButton(...)");
        PopupButton popupButton = new PopupButton(confirmButton);
        com.bapis.bilibili.app.home.v1.PopupButton cancelButton = builder.getCancelButton();
        Intrinsics.checkNotNullExpressionValue(cancelButton, "getCancelButton(...)");
    }
}