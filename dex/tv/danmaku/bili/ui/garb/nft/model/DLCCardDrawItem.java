package tv.danmaku.bili.ui.garb.nft.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplay;

/* compiled from: DLCCardDrawItem.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawItem;", "", "url", "", AppConfig.HOST_TAG, "Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "display", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "<init>", "(Ljava/lang/String;Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;)V", "getUrl", "()Ljava/lang/String;", "getTag", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "getDisplay", "()Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardDrawItem {
    public static final int $stable = 0;
    private final BiliDLCCardDisplay display;
    private final DLCTagModel tag;
    private final String url;

    public static /* synthetic */ DLCCardDrawItem copy$default(DLCCardDrawItem dLCCardDrawItem, String str, DLCTagModel dLCTagModel, BiliDLCCardDisplay biliDLCCardDisplay, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dLCCardDrawItem.url;
        }
        if ((i & 2) != 0) {
            dLCTagModel = dLCCardDrawItem.tag;
        }
        if ((i & 4) != 0) {
            biliDLCCardDisplay = dLCCardDrawItem.display;
        }
        return dLCCardDrawItem.copy(str, dLCTagModel, biliDLCCardDisplay);
    }

    public final String component1() {
        return this.url;
    }

    public final DLCTagModel component2() {
        return this.tag;
    }

    public final BiliDLCCardDisplay component3() {
        return this.display;
    }

    public final DLCCardDrawItem copy(String str, DLCTagModel dLCTagModel, BiliDLCCardDisplay biliDLCCardDisplay) {
        Intrinsics.checkNotNullParameter(biliDLCCardDisplay, "display");
        return new DLCCardDrawItem(str, dLCTagModel, biliDLCCardDisplay);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCCardDrawItem) {
            DLCCardDrawItem dLCCardDrawItem = (DLCCardDrawItem) obj;
            return Intrinsics.areEqual(this.url, dLCCardDrawItem.url) && Intrinsics.areEqual(this.tag, dLCCardDrawItem.tag) && Intrinsics.areEqual(this.display, dLCCardDrawItem.display);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.tag != null ? this.tag.hashCode() : 0)) * 31) + this.display.hashCode();
    }

    public String toString() {
        String str = this.url;
        DLCTagModel dLCTagModel = this.tag;
        return "DLCCardDrawItem(url=" + str + ", tag=" + dLCTagModel + ", display=" + this.display + ")";
    }

    public DLCCardDrawItem(String url, DLCTagModel tag, BiliDLCCardDisplay display) {
        Intrinsics.checkNotNullParameter(display, "display");
        this.url = url;
        this.tag = tag;
        this.display = display;
    }

    public final String getUrl() {
        return this.url;
    }

    public final DLCTagModel getTag() {
        return this.tag;
    }

    public final BiliDLCCardDisplay getDisplay() {
        return this.display;
    }
}