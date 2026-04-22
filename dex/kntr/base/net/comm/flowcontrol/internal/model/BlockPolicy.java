package kntr.base.net.comm.flowcontrol.internal.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: BlockPolicy.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/model/BlockPolicy;", "", "host", "", "path", "policy", "Lkntr/base/net/comm/flowcontrol/internal/model/RetryAfterPolicy;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/net/comm/flowcontrol/internal/model/RetryAfterPolicy;)V", "value", "", "duration", "getDuration", "()J", "", "update", "getUpdate", "()I", "expire", "", "block", "", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BlockPolicy {
    private long duration;
    private long expire;
    private final String host;
    private final String path;
    private final RetryAfterPolicy policy;
    private int update;

    public BlockPolicy(String host, String path, RetryAfterPolicy policy) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.host = host;
        this.path = path;
        this.policy = policy;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getUpdate() {
        return this.update;
    }

    public final void update() {
        this.update++;
        this.duration = this.policy.getDelay();
        this.expire = Clock.System.INSTANCE.now().toEpochMilliseconds() + this.duration;
    }

    public final boolean block() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds() <= this.expire;
    }
}