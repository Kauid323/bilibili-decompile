package tv.danmaku.bili.rating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RatingDialogBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/rating/PopupButton;", "", "text", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "builder", "Lcom/bapis/bilibili/app/home/v1/PopupButton;", "(Lcom/bapis/bilibili/app/home/v1/PopupButton;)V", "getText", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PopupButton {
    public static final int $stable = 0;
    private final String text;
    private final String url;

    public PopupButton() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ PopupButton copy$default(PopupButton popupButton, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = popupButton.text;
        }
        if ((i & 2) != 0) {
            str2 = popupButton.url;
        }
        return popupButton.copy(str, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.url;
    }

    public final PopupButton copy(String str, String str2) {
        return new PopupButton(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PopupButton) {
            PopupButton popupButton = (PopupButton) obj;
            return Intrinsics.areEqual(this.text, popupButton.text) && Intrinsics.areEqual(this.url, popupButton.url);
        }
        return false;
    }

    public int hashCode() {
        return ((this.text == null ? 0 : this.text.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        return "PopupButton(text=" + str + ", url=" + this.url + ")";
    }

    public PopupButton(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public /* synthetic */ PopupButton(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupButton(com.bapis.bilibili.app.home.v1.PopupButton builder) {
        this(builder.getText(), builder.getUrl());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }
}