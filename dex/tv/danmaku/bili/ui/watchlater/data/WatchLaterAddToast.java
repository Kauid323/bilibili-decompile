package tv.danmaku.bili.ui.watchlater.data;

import BottomSheetItemData$;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterAddToast.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003JM\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WatchLaterAddToast;", "", "showToast", "", "iconType", "", "toast", "", "jumpText", "appJumpLink", "avids", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getShowToast", "()Z", "setShowToast", "(Z)V", "getIconType", "()I", "setIconType", "(I)V", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getJumpText", "setJumpText", "getAppJumpLink", "setAppJumpLink", "getAvids", "setAvids", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterAddToast {
    public static final int $stable = 8;
    @JSONField(name = "app_jump_link")
    private String appJumpLink;
    @JSONField(name = "avids")
    private String avids;
    @JSONField(name = "icon_type")
    private int iconType;
    @JSONField(name = "jump_text")
    private String jumpText;
    @JSONField(name = "show_toast")
    private boolean showToast;
    @JSONField(name = "toast")
    private String toast;

    public WatchLaterAddToast() {
        this(false, 0, null, null, null, null, 63, null);
    }

    public static /* synthetic */ WatchLaterAddToast copy$default(WatchLaterAddToast watchLaterAddToast, boolean z, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = watchLaterAddToast.showToast;
        }
        if ((i2 & 2) != 0) {
            i = watchLaterAddToast.iconType;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = watchLaterAddToast.toast;
        }
        String str5 = str;
        if ((i2 & 8) != 0) {
            str2 = watchLaterAddToast.jumpText;
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = watchLaterAddToast.appJumpLink;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = watchLaterAddToast.avids;
        }
        return watchLaterAddToast.copy(z, i3, str5, str6, str7, str4);
    }

    public final boolean component1() {
        return this.showToast;
    }

    public final int component2() {
        return this.iconType;
    }

    public final String component3() {
        return this.toast;
    }

    public final String component4() {
        return this.jumpText;
    }

    public final String component5() {
        return this.appJumpLink;
    }

    public final String component6() {
        return this.avids;
    }

    public final WatchLaterAddToast copy(boolean z, int i, String str, String str2, String str3, String str4) {
        return new WatchLaterAddToast(z, i, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterAddToast) {
            WatchLaterAddToast watchLaterAddToast = (WatchLaterAddToast) obj;
            return this.showToast == watchLaterAddToast.showToast && this.iconType == watchLaterAddToast.iconType && Intrinsics.areEqual(this.toast, watchLaterAddToast.toast) && Intrinsics.areEqual(this.jumpText, watchLaterAddToast.jumpText) && Intrinsics.areEqual(this.appJumpLink, watchLaterAddToast.appJumpLink) && Intrinsics.areEqual(this.avids, watchLaterAddToast.avids);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showToast) * 31) + this.iconType) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.jumpText == null ? 0 : this.jumpText.hashCode())) * 31) + (this.appJumpLink == null ? 0 : this.appJumpLink.hashCode())) * 31) + (this.avids != null ? this.avids.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.showToast;
        int i = this.iconType;
        String str = this.toast;
        String str2 = this.jumpText;
        String str3 = this.appJumpLink;
        return "WatchLaterAddToast(showToast=" + z + ", iconType=" + i + ", toast=" + str + ", jumpText=" + str2 + ", appJumpLink=" + str3 + ", avids=" + this.avids + ")";
    }

    public WatchLaterAddToast(boolean showToast, int iconType, String toast, String jumpText, String appJumpLink, String avids) {
        this.showToast = showToast;
        this.iconType = iconType;
        this.toast = toast;
        this.jumpText = jumpText;
        this.appJumpLink = appJumpLink;
        this.avids = avids;
    }

    public /* synthetic */ WatchLaterAddToast(boolean z, int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) == 0 ? i : 0, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4);
    }

    public final boolean getShowToast() {
        return this.showToast;
    }

    public final void setShowToast(boolean z) {
        this.showToast = z;
    }

    public final int getIconType() {
        return this.iconType;
    }

    public final void setIconType(int i) {
        this.iconType = i;
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setToast(String str) {
        this.toast = str;
    }

    public final String getJumpText() {
        return this.jumpText;
    }

    public final void setJumpText(String str) {
        this.jumpText = str;
    }

    public final String getAppJumpLink() {
        return this.appJumpLink;
    }

    public final void setAppJumpLink(String str) {
        this.appJumpLink = str;
    }

    public final String getAvids() {
        return this.avids;
    }

    public final void setAvids(String str) {
        this.avids = str;
    }
}