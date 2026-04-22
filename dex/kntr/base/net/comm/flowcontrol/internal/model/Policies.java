package kntr.base.net.comm.flowcontrol.internal.model;

import java.util.HashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.tracker.EventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: Policies.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/model/Policies;", "", "tracker", "Lkntr/base/net/comm/flowcontrol/internal/tracker/EventListener;", "<init>", "(Lkntr/base/net/comm/flowcontrol/internal/tracker/EventListener;)V", "map", "", "", "Lkntr/base/net/comm/flowcontrol/internal/model/BlockPolicy;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "isBlocked", "", "host", "path", "block", "", "retryAfter", "", "unblock", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Policies {
    private Map<String, BlockPolicy> map;
    private final Mutex mutex;
    private final EventListener tracker;

    public Policies(EventListener tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.tracker = tracker;
        this.map = new HashMap();
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public final boolean isBlocked(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        String key = host + path;
        BlockPolicy blockPolicy = this.map.get(key);
        boolean blocked = blockPolicy != null ? blockPolicy.block() : false;
        if (blocked) {
            KLog_androidKt.getKLog().w("net.flowcontrol.policy", "Blocked " + host + path + " for flow control");
            this.tracker.onBlocked(host, path);
        }
        return blocked;
    }

    public final void block(String host, String path, int retryAfter) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        String key = host + path;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), (CoroutineStart) null, new Policies$block$1(this, host, path, retryAfter, key, null), 2, (Object) null);
    }

    public final void unblock(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        String key = host + path;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), (CoroutineStart) null, new Policies$unblock$1(this, key, host, path, null), 2, (Object) null);
    }
}