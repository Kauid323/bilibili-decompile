package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterStat;", "", "view", "Lkntr/common/share/common/ui/poster/PlacardStatItem;", "like", "reply", "displayMode", "", "<init>", "(Lkntr/common/share/common/ui/poster/PlacardStatItem;Lkntr/common/share/common/ui/poster/PlacardStatItem;Lkntr/common/share/common/ui/poster/PlacardStatItem;I)V", "getView", "()Lkntr/common/share/common/ui/poster/PlacardStatItem;", "getLike", "getReply", "getDisplayMode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterStat {
    public static final int $stable = 0;
    private final int displayMode;
    private final PlacardStatItem like;
    private final PlacardStatItem reply;
    private final PlacardStatItem view;

    public static /* synthetic */ SharePosterStat copy$default(SharePosterStat sharePosterStat, PlacardStatItem placardStatItem, PlacardStatItem placardStatItem2, PlacardStatItem placardStatItem3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            placardStatItem = sharePosterStat.view;
        }
        if ((i2 & 2) != 0) {
            placardStatItem2 = sharePosterStat.like;
        }
        if ((i2 & 4) != 0) {
            placardStatItem3 = sharePosterStat.reply;
        }
        if ((i2 & 8) != 0) {
            i = sharePosterStat.displayMode;
        }
        return sharePosterStat.copy(placardStatItem, placardStatItem2, placardStatItem3, i);
    }

    public final PlacardStatItem component1() {
        return this.view;
    }

    public final PlacardStatItem component2() {
        return this.like;
    }

    public final PlacardStatItem component3() {
        return this.reply;
    }

    public final int component4() {
        return this.displayMode;
    }

    public final SharePosterStat copy(PlacardStatItem placardStatItem, PlacardStatItem placardStatItem2, PlacardStatItem placardStatItem3, int i) {
        Intrinsics.checkNotNullParameter(placardStatItem, "view");
        Intrinsics.checkNotNullParameter(placardStatItem2, "like");
        Intrinsics.checkNotNullParameter(placardStatItem3, "reply");
        return new SharePosterStat(placardStatItem, placardStatItem2, placardStatItem3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterStat) {
            SharePosterStat sharePosterStat = (SharePosterStat) obj;
            return Intrinsics.areEqual(this.view, sharePosterStat.view) && Intrinsics.areEqual(this.like, sharePosterStat.like) && Intrinsics.areEqual(this.reply, sharePosterStat.reply) && this.displayMode == sharePosterStat.displayMode;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.view.hashCode() * 31) + this.like.hashCode()) * 31) + this.reply.hashCode()) * 31) + this.displayMode;
    }

    public String toString() {
        PlacardStatItem placardStatItem = this.view;
        PlacardStatItem placardStatItem2 = this.like;
        PlacardStatItem placardStatItem3 = this.reply;
        return "SharePosterStat(view=" + placardStatItem + ", like=" + placardStatItem2 + ", reply=" + placardStatItem3 + ", displayMode=" + this.displayMode + ")";
    }

    public SharePosterStat(PlacardStatItem view, PlacardStatItem like, PlacardStatItem reply, int displayMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(like, "like");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.view = view;
        this.like = like;
        this.reply = reply;
        this.displayMode = displayMode;
    }

    public final PlacardStatItem getView() {
        return this.view;
    }

    public final PlacardStatItem getLike() {
        return this.like;
    }

    public final PlacardStatItem getReply() {
        return this.reply;
    }

    public final int getDisplayMode() {
        return this.displayMode;
    }
}