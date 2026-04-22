package kntr.common.share.common.ui.poster;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePosterParams.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lkntr/common/share/common/ui/poster/PlacardStatItem;", "", "text", "", WatchLaterReporterKt.KEY_NUM, "numText", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getNum", "getNumText", "getIcon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlacardStatItem {
    public static final int $stable = 0;
    private final String icon;
    private final String num;
    private final String numText;
    private final String text;

    public static /* synthetic */ PlacardStatItem copy$default(PlacardStatItem placardStatItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = placardStatItem.text;
        }
        if ((i & 2) != 0) {
            str2 = placardStatItem.num;
        }
        if ((i & 4) != 0) {
            str3 = placardStatItem.numText;
        }
        if ((i & 8) != 0) {
            str4 = placardStatItem.icon;
        }
        return placardStatItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.num;
    }

    public final String component3() {
        return this.numText;
    }

    public final String component4() {
        return this.icon;
    }

    public final PlacardStatItem copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, WatchLaterReporterKt.KEY_NUM);
        Intrinsics.checkNotNullParameter(str3, "numText");
        Intrinsics.checkNotNullParameter(str4, "icon");
        return new PlacardStatItem(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlacardStatItem) {
            PlacardStatItem placardStatItem = (PlacardStatItem) obj;
            return Intrinsics.areEqual(this.text, placardStatItem.text) && Intrinsics.areEqual(this.num, placardStatItem.num) && Intrinsics.areEqual(this.numText, placardStatItem.numText) && Intrinsics.areEqual(this.icon, placardStatItem.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.num.hashCode()) * 31) + this.numText.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        String str = this.text;
        String str2 = this.num;
        String str3 = this.numText;
        return "PlacardStatItem(text=" + str + ", num=" + str2 + ", numText=" + str3 + ", icon=" + this.icon + ")";
    }

    public PlacardStatItem(String text, String num, String numText, String icon) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(num, WatchLaterReporterKt.KEY_NUM);
        Intrinsics.checkNotNullParameter(numText, "numText");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.text = text;
        this.num = num;
        this.numText = numText;
        this.icon = icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getNumText() {
        return this.numText;
    }

    public final String getIcon() {
        return this.icon;
    }
}