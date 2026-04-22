package tv.danmaku.biliplayerimpl.clock;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerTimer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerimpl/clock/ProgressRange;", "", "startPosition", "", "endPosition", "isActive", "", "<init>", "(JJZ)V", "getStartPosition", "()J", "setStartPosition", "(J)V", "getEndPosition", "setEndPosition", "()Z", "setActive", "(Z)V", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ProgressRange {
    private long endPosition;
    private boolean isActive;
    private long startPosition;

    public ProgressRange(long startPosition, long endPosition, boolean isActive) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.isActive = isActive;
    }

    public /* synthetic */ ProgressRange(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? false : z);
    }

    public final long getEndPosition() {
        return this.endPosition;
    }

    public final long getStartPosition() {
        return this.startPosition;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setEndPosition(long j) {
        this.endPosition = j;
    }

    public final void setStartPosition(long j) {
        this.startPosition = j;
    }
}