package kntr.common.share.common.ui.poster;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/share/common/ui/poster/SharePosterDanmu;", "", "items", "", "", "icon", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getIcon", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterDanmu {
    public static final int $stable = 8;
    private final String icon;
    private final List<String> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SharePosterDanmu copy$default(SharePosterDanmu sharePosterDanmu, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sharePosterDanmu.items;
        }
        if ((i & 2) != 0) {
            str = sharePosterDanmu.icon;
        }
        return sharePosterDanmu.copy(list, str);
    }

    public final List<String> component1() {
        return this.items;
    }

    public final String component2() {
        return this.icon;
    }

    public final SharePosterDanmu copy(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(str, "icon");
        return new SharePosterDanmu(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePosterDanmu) {
            SharePosterDanmu sharePosterDanmu = (SharePosterDanmu) obj;
            return Intrinsics.areEqual(this.items, sharePosterDanmu.items) && Intrinsics.areEqual(this.icon, sharePosterDanmu.icon);
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.icon.hashCode();
    }

    public String toString() {
        List<String> list = this.items;
        return "SharePosterDanmu(items=" + list + ", icon=" + this.icon + ")";
    }

    public SharePosterDanmu(List<String> list, String icon) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.items = list;
        this.icon = icon;
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final String getIcon() {
        return this.icon;
    }
}