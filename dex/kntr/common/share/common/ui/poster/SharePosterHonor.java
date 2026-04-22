package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterHonor;", "", "content", "", "icon", "contentColor", "backgroundColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getIcon", "getContentColor", "getBackgroundColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterHonor {
    public static final int $stable = 0;
    private final String backgroundColor;
    private final String content;
    private final String contentColor;
    private final String icon;

    public static /* synthetic */ SharePosterHonor copy$default(SharePosterHonor sharePosterHonor, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharePosterHonor.content;
        }
        if ((i & 2) != 0) {
            str2 = sharePosterHonor.icon;
        }
        if ((i & 4) != 0) {
            str3 = sharePosterHonor.contentColor;
        }
        if ((i & 8) != 0) {
            str4 = sharePosterHonor.backgroundColor;
        }
        return sharePosterHonor.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.contentColor;
    }

    public final String component4() {
        return this.backgroundColor;
    }

    public final SharePosterHonor copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(str3, "contentColor");
        Intrinsics.checkNotNullParameter(str4, "backgroundColor");
        return new SharePosterHonor(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterHonor) {
            SharePosterHonor sharePosterHonor = (SharePosterHonor) obj;
            return Intrinsics.areEqual(this.content, sharePosterHonor.content) && Intrinsics.areEqual(this.icon, sharePosterHonor.icon) && Intrinsics.areEqual(this.contentColor, sharePosterHonor.contentColor) && Intrinsics.areEqual(this.backgroundColor, sharePosterHonor.backgroundColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.content.hashCode() * 31) + this.icon.hashCode()) * 31) + this.contentColor.hashCode()) * 31) + this.backgroundColor.hashCode();
    }

    public String toString() {
        String str = this.content;
        String str2 = this.icon;
        String str3 = this.contentColor;
        return "SharePosterHonor(content=" + str + ", icon=" + str2 + ", contentColor=" + str3 + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public SharePosterHonor(String content, String icon, String contentColor, String backgroundColor) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        this.content = content;
        this.icon = icon;
        this.contentColor = contentColor;
        this.backgroundColor = backgroundColor;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getContentColor() {
        return this.contentColor;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }
}