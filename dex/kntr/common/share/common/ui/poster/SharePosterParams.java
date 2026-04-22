package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JG\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterParams;", "", "danmu", "Lkntr/common/share/common/ui/poster/SharePosterDanmu;", "arc", "Lkntr/common/share/common/ui/poster/SharePosterArc;", "stat", "Lkntr/common/share/common/ui/poster/SharePosterStat;", "author", "Lkntr/common/share/common/ui/poster/SharePosterAuthor;", "qrcode", "Lkntr/common/share/common/ui/poster/SharePosterQrcode;", "honor", "Lkntr/common/share/common/ui/poster/SharePosterHonor;", "<init>", "(Lkntr/common/share/common/ui/poster/SharePosterDanmu;Lkntr/common/share/common/ui/poster/SharePosterArc;Lkntr/common/share/common/ui/poster/SharePosterStat;Lkntr/common/share/common/ui/poster/SharePosterAuthor;Lkntr/common/share/common/ui/poster/SharePosterQrcode;Lkntr/common/share/common/ui/poster/SharePosterHonor;)V", "getDanmu", "()Lkntr/common/share/common/ui/poster/SharePosterDanmu;", "getArc", "()Lkntr/common/share/common/ui/poster/SharePosterArc;", "getStat", "()Lkntr/common/share/common/ui/poster/SharePosterStat;", "getAuthor", "()Lkntr/common/share/common/ui/poster/SharePosterAuthor;", "getQrcode", "()Lkntr/common/share/common/ui/poster/SharePosterQrcode;", "getHonor", "()Lkntr/common/share/common/ui/poster/SharePosterHonor;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterParams {
    public static final int $stable = 8;
    private final SharePosterArc arc;
    private final SharePosterAuthor author;
    private final SharePosterDanmu danmu;
    private final SharePosterHonor honor;
    private final SharePosterQrcode qrcode;
    private final SharePosterStat stat;

    public static /* synthetic */ SharePosterParams copy$default(SharePosterParams sharePosterParams, SharePosterDanmu sharePosterDanmu, SharePosterArc sharePosterArc, SharePosterStat sharePosterStat, SharePosterAuthor sharePosterAuthor, SharePosterQrcode sharePosterQrcode, SharePosterHonor sharePosterHonor, int i, Object obj) {
        if ((i & 1) != 0) {
            sharePosterDanmu = sharePosterParams.danmu;
        }
        if ((i & 2) != 0) {
            sharePosterArc = sharePosterParams.arc;
        }
        SharePosterArc sharePosterArc2 = sharePosterArc;
        if ((i & 4) != 0) {
            sharePosterStat = sharePosterParams.stat;
        }
        SharePosterStat sharePosterStat2 = sharePosterStat;
        if ((i & 8) != 0) {
            sharePosterAuthor = sharePosterParams.author;
        }
        SharePosterAuthor sharePosterAuthor2 = sharePosterAuthor;
        if ((i & 16) != 0) {
            sharePosterQrcode = sharePosterParams.qrcode;
        }
        SharePosterQrcode sharePosterQrcode2 = sharePosterQrcode;
        if ((i & 32) != 0) {
            sharePosterHonor = sharePosterParams.honor;
        }
        return sharePosterParams.copy(sharePosterDanmu, sharePosterArc2, sharePosterStat2, sharePosterAuthor2, sharePosterQrcode2, sharePosterHonor);
    }

    public final SharePosterDanmu component1() {
        return this.danmu;
    }

    public final SharePosterArc component2() {
        return this.arc;
    }

    public final SharePosterStat component3() {
        return this.stat;
    }

    public final SharePosterAuthor component4() {
        return this.author;
    }

    public final SharePosterQrcode component5() {
        return this.qrcode;
    }

    public final SharePosterHonor component6() {
        return this.honor;
    }

    public final SharePosterParams copy(SharePosterDanmu sharePosterDanmu, SharePosterArc sharePosterArc, SharePosterStat sharePosterStat, SharePosterAuthor sharePosterAuthor, SharePosterQrcode sharePosterQrcode, SharePosterHonor sharePosterHonor) {
        Intrinsics.checkNotNullParameter(sharePosterDanmu, "danmu");
        Intrinsics.checkNotNullParameter(sharePosterArc, "arc");
        Intrinsics.checkNotNullParameter(sharePosterStat, "stat");
        Intrinsics.checkNotNullParameter(sharePosterAuthor, "author");
        Intrinsics.checkNotNullParameter(sharePosterQrcode, "qrcode");
        return new SharePosterParams(sharePosterDanmu, sharePosterArc, sharePosterStat, sharePosterAuthor, sharePosterQrcode, sharePosterHonor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterParams) {
            SharePosterParams sharePosterParams = (SharePosterParams) obj;
            return Intrinsics.areEqual(this.danmu, sharePosterParams.danmu) && Intrinsics.areEqual(this.arc, sharePosterParams.arc) && Intrinsics.areEqual(this.stat, sharePosterParams.stat) && Intrinsics.areEqual(this.author, sharePosterParams.author) && Intrinsics.areEqual(this.qrcode, sharePosterParams.qrcode) && Intrinsics.areEqual(this.honor, sharePosterParams.honor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.danmu.hashCode() * 31) + this.arc.hashCode()) * 31) + this.stat.hashCode()) * 31) + this.author.hashCode()) * 31) + this.qrcode.hashCode()) * 31) + (this.honor == null ? 0 : this.honor.hashCode());
    }

    public String toString() {
        SharePosterDanmu sharePosterDanmu = this.danmu;
        SharePosterArc sharePosterArc = this.arc;
        SharePosterStat sharePosterStat = this.stat;
        SharePosterAuthor sharePosterAuthor = this.author;
        SharePosterQrcode sharePosterQrcode = this.qrcode;
        return "SharePosterParams(danmu=" + sharePosterDanmu + ", arc=" + sharePosterArc + ", stat=" + sharePosterStat + ", author=" + sharePosterAuthor + ", qrcode=" + sharePosterQrcode + ", honor=" + this.honor + ")";
    }

    public SharePosterParams(SharePosterDanmu danmu, SharePosterArc arc, SharePosterStat stat, SharePosterAuthor author, SharePosterQrcode qrcode, SharePosterHonor honor) {
        Intrinsics.checkNotNullParameter(danmu, "danmu");
        Intrinsics.checkNotNullParameter(arc, "arc");
        Intrinsics.checkNotNullParameter(stat, "stat");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(qrcode, "qrcode");
        this.danmu = danmu;
        this.arc = arc;
        this.stat = stat;
        this.author = author;
        this.qrcode = qrcode;
        this.honor = honor;
    }

    public final SharePosterDanmu getDanmu() {
        return this.danmu;
    }

    public final SharePosterArc getArc() {
        return this.arc;
    }

    public final SharePosterStat getStat() {
        return this.stat;
    }

    public final SharePosterAuthor getAuthor() {
        return this.author;
    }

    public final SharePosterQrcode getQrcode() {
        return this.qrcode;
    }

    public final SharePosterHonor getHonor() {
        return this.honor;
    }
}