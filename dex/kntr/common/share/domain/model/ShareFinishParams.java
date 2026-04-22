package kntr.common.share.domain.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareOnlineParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/share/domain/model/ShareFinishParams;", "", "target", "Lkntr/common/share/common/ShareTarget;", "link", "", "<init>", "(Lkntr/common/share/common/ShareTarget;Ljava/lang/String;)V", "getTarget", "()Lkntr/common/share/common/ShareTarget;", "getLink", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareFinishParams {
    public static final int $stable = ShareTarget.$stable;
    private final String link;
    private final ShareTarget target;

    public static /* synthetic */ ShareFinishParams copy$default(ShareFinishParams shareFinishParams, ShareTarget shareTarget, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            shareTarget = shareFinishParams.target;
        }
        if ((i & 2) != 0) {
            str = shareFinishParams.link;
        }
        return shareFinishParams.copy(shareTarget, str);
    }

    public final ShareTarget component1() {
        return this.target;
    }

    public final String component2() {
        return this.link;
    }

    public final ShareFinishParams copy(ShareTarget shareTarget, String str) {
        Intrinsics.checkNotNullParameter(shareTarget, "target");
        Intrinsics.checkNotNullParameter(str, "link");
        return new ShareFinishParams(shareTarget, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareFinishParams) {
            ShareFinishParams shareFinishParams = (ShareFinishParams) obj;
            return Intrinsics.areEqual(this.target, shareFinishParams.target) && Intrinsics.areEqual(this.link, shareFinishParams.link);
        }
        return false;
    }

    public int hashCode() {
        return (this.target.hashCode() * 31) + this.link.hashCode();
    }

    public String toString() {
        ShareTarget shareTarget = this.target;
        return "ShareFinishParams(target=" + shareTarget + ", link=" + this.link + ")";
    }

    public ShareFinishParams(ShareTarget target, String link) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(link, "link");
        this.target = target;
        this.link = link;
    }

    public /* synthetic */ ShareFinishParams(ShareTarget shareTarget, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareTarget, (i & 2) != 0 ? "" : str);
    }

    public final ShareTarget getTarget() {
        return this.target;
    }

    public final String getLink() {
        return this.link;
    }
}