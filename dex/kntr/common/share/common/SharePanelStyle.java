package kntr.common.share.common;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GSharePanel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lkntr/common/share/common/SharePanelStyle;", "", "title", "", "hideTitle", "", "<init>", "(Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getHideTitle", "()Z", "setHideTitle", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePanelStyle {
    public static final int $stable = 8;
    private boolean hideTitle;
    private String title;

    public SharePanelStyle() {
        this(null, false, 3, null);
    }

    public static /* synthetic */ SharePanelStyle copy$default(SharePanelStyle sharePanelStyle, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharePanelStyle.title;
        }
        if ((i & 2) != 0) {
            z = sharePanelStyle.hideTitle;
        }
        return sharePanelStyle.copy(str, z);
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.hideTitle;
    }

    public final SharePanelStyle copy(String str, boolean z) {
        return new SharePanelStyle(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SharePanelStyle) {
            SharePanelStyle sharePanelStyle = (SharePanelStyle) obj;
            return Intrinsics.areEqual(this.title, sharePanelStyle.title) && this.hideTitle == sharePanelStyle.hideTitle;
        }
        return false;
    }

    public int hashCode() {
        return ((this.title == null ? 0 : this.title.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hideTitle);
    }

    public String toString() {
        String str = this.title;
        return "SharePanelStyle(title=" + str + ", hideTitle=" + this.hideTitle + ")";
    }

    public SharePanelStyle(String title, boolean hideTitle) {
        this.title = title;
        this.hideTitle = hideTitle;
    }

    public /* synthetic */ SharePanelStyle(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final boolean getHideTitle() {
        return this.hideTitle;
    }

    public final void setHideTitle(boolean z) {
        this.hideTitle = z;
    }
}