package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterArc;", "", "pic", "", "title", "pubtime", "playIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPic", "()Ljava/lang/String;", "getTitle", "getPubtime", "getPlayIcon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterArc {
    public static final int $stable = 0;
    private final String pic;
    private final String playIcon;
    private final String pubtime;
    private final String title;

    public static /* synthetic */ SharePosterArc copy$default(SharePosterArc sharePosterArc, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharePosterArc.pic;
        }
        if ((i & 2) != 0) {
            str2 = sharePosterArc.title;
        }
        if ((i & 4) != 0) {
            str3 = sharePosterArc.pubtime;
        }
        if ((i & 8) != 0) {
            str4 = sharePosterArc.playIcon;
        }
        return sharePosterArc.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.pic;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.pubtime;
    }

    public final String component4() {
        return this.playIcon;
    }

    public final SharePosterArc copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "pic");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "pubtime");
        Intrinsics.checkNotNullParameter(str4, "playIcon");
        return new SharePosterArc(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterArc) {
            SharePosterArc sharePosterArc = (SharePosterArc) obj;
            return Intrinsics.areEqual(this.pic, sharePosterArc.pic) && Intrinsics.areEqual(this.title, sharePosterArc.title) && Intrinsics.areEqual(this.pubtime, sharePosterArc.pubtime) && Intrinsics.areEqual(this.playIcon, sharePosterArc.playIcon);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.pic.hashCode() * 31) + this.title.hashCode()) * 31) + this.pubtime.hashCode()) * 31) + this.playIcon.hashCode();
    }

    public String toString() {
        String str = this.pic;
        String str2 = this.title;
        String str3 = this.pubtime;
        return "SharePosterArc(pic=" + str + ", title=" + str2 + ", pubtime=" + str3 + ", playIcon=" + this.playIcon + ")";
    }

    public SharePosterArc(String pic, String title, String pubtime, String playIcon) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pubtime, "pubtime");
        Intrinsics.checkNotNullParameter(playIcon, "playIcon");
        this.pic = pic;
        this.title = title;
        this.pubtime = pubtime;
        this.playIcon = playIcon;
    }

    public final String getPic() {
        return this.pic;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPubtime() {
        return this.pubtime;
    }

    public final String getPlayIcon() {
        return this.playIcon;
    }
}