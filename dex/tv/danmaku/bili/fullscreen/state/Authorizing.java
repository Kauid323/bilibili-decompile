package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/Authorizing;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeLoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Authorizing implements NetCodeState, NetCodeLoadingState {
    public static final int $stable = 0;
    public static final Authorizing INSTANCE = new Authorizing();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Authorizing) {
            Authorizing authorizing = (Authorizing) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 320366869;
    }

    public String toString() {
        return "Authorizing";
    }

    private Authorizing() {
    }
}