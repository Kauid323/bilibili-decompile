package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreServiceKtx.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerErrorEvent;", "", "what", "", "extra", "<init>", "(II)V", "getWhat", "()I", "getExtra", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerErrorEvent {
    private final int extra;
    private final int what;

    public static /* synthetic */ PlayerErrorEvent copy$default(PlayerErrorEvent playerErrorEvent, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = playerErrorEvent.what;
        }
        if ((i3 & 2) != 0) {
            i2 = playerErrorEvent.extra;
        }
        return playerErrorEvent.copy(i, i2);
    }

    public final int component1() {
        return this.what;
    }

    public final int component2() {
        return this.extra;
    }

    public final PlayerErrorEvent copy(int i, int i2) {
        return new PlayerErrorEvent(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayerErrorEvent) {
            PlayerErrorEvent playerErrorEvent = (PlayerErrorEvent) obj;
            return this.what == playerErrorEvent.what && this.extra == playerErrorEvent.extra;
        }
        return false;
    }

    public int hashCode() {
        return (this.what * 31) + this.extra;
    }

    public String toString() {
        int i = this.what;
        return "PlayerErrorEvent(what=" + i + ", extra=" + this.extra + ")";
    }

    public PlayerErrorEvent(int what, int extra) {
        this.what = what;
        this.extra = extra;
    }

    public final int getExtra() {
        return this.extra;
    }

    public final int getWhat() {
        return this.what;
    }
}