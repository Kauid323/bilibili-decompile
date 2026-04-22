package tv.danmaku.biliplayerv2.service.interact.biz;

import BottomSheetItemData$;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractLayerServiceKtx.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuVisibleChangeParams;", "", "visible", "", "fromUser", "<init>", "(ZZ)V", "getVisible", "()Z", "getFromUser", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuVisibleChangeParams {
    private final boolean fromUser;
    private final boolean visible;

    public static /* synthetic */ DanmakuVisibleChangeParams copy$default(DanmakuVisibleChangeParams danmakuVisibleChangeParams, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = danmakuVisibleChangeParams.visible;
        }
        if ((i & 2) != 0) {
            z2 = danmakuVisibleChangeParams.fromUser;
        }
        return danmakuVisibleChangeParams.copy(z, z2);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final boolean component2() {
        return this.fromUser;
    }

    public final DanmakuVisibleChangeParams copy(boolean z, boolean z2) {
        return new DanmakuVisibleChangeParams(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DanmakuVisibleChangeParams) {
            DanmakuVisibleChangeParams danmakuVisibleChangeParams = (DanmakuVisibleChangeParams) obj;
            return this.visible == danmakuVisibleChangeParams.visible && this.fromUser == danmakuVisibleChangeParams.fromUser;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.visible) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromUser);
    }

    public String toString() {
        boolean z = this.visible;
        return "DanmakuVisibleChangeParams(visible=" + z + ", fromUser=" + this.fromUser + ")";
    }

    public DanmakuVisibleChangeParams(boolean visible, boolean fromUser) {
        this.visible = visible;
        this.fromUser = fromUser;
    }

    public final boolean getFromUser() {
        return this.fromUser;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}