package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterQrcode;", "", "link", "", "expire", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getExpire", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterQrcode {
    public static final int $stable = 0;
    private final String expire;
    private final String link;

    public static /* synthetic */ SharePosterQrcode copy$default(SharePosterQrcode sharePosterQrcode, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharePosterQrcode.link;
        }
        if ((i & 2) != 0) {
            str2 = sharePosterQrcode.expire;
        }
        return sharePosterQrcode.copy(str, str2);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.expire;
    }

    public final SharePosterQrcode copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, "expire");
        return new SharePosterQrcode(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterQrcode) {
            SharePosterQrcode sharePosterQrcode = (SharePosterQrcode) obj;
            return Intrinsics.areEqual(this.link, sharePosterQrcode.link) && Intrinsics.areEqual(this.expire, sharePosterQrcode.expire);
        }
        return false;
    }

    public int hashCode() {
        return (this.link.hashCode() * 31) + this.expire.hashCode();
    }

    public String toString() {
        String str = this.link;
        return "SharePosterQrcode(link=" + str + ", expire=" + this.expire + ")";
    }

    public SharePosterQrcode(String link, String expire) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(expire, "expire");
        this.link = link;
        this.expire = expire;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getExpire() {
        return this.expire;
    }
}