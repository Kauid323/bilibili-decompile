package kntr.base.net.comm.flowcontrol.internal.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.tracker.EventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: TimePolicies.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/model/TimePolicies;", "", "tracker", "Lkntr/base/net/comm/flowcontrol/internal/tracker/EventListener;", "<init>", "(Lkntr/base/net/comm/flowcontrol/internal/tracker/EventListener;)V", "blockApi", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "blockTime", "Lkntr/base/net/comm/flowcontrol/internal/model/TimeConfig;", "enable", "", "inBlockTime", "isBlocked", "host", "path", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TimePolicies {
    private final HashSet<String> blockApi;
    private final HashSet<TimeConfig> blockTime;
    private boolean enable;
    private final EventListener tracker;

    public TimePolicies(EventListener tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.tracker = tracker;
        this.blockApi = new HashSet<>();
        this.blockTime = new HashSet<>();
        this.enable = true;
        this.enable = KConfig.INSTANCE.ff("flowcontrol.block.enable", true);
        try {
            String it = KConfig.INSTANCE.config("flowcontrol.block.api", "[]");
            if (it != null) {
                Json this_$iv = Json.Default;
                this_$iv.getSerializersModule();
                List apiList = (List) this_$iv.decodeFromString(new ArrayListSerializer(StringSerializer.INSTANCE), it);
                this.blockApi.addAll(apiList);
            }
            String it2 = KConfig.INSTANCE.config("flowcontrol.block.api.time", "[]");
            if (it2 != null) {
                Json this_$iv2 = Json.Default;
                this_$iv2.getSerializersModule();
                List timeList = (List) this_$iv2.decodeFromString(new ArrayListSerializer(TimeConfig.Companion.serializer()), it2);
                this.blockTime.addAll(timeList);
            }
        } catch (Throwable th) {
        }
        ILogger kLog = KLog_androidKt.getKLog();
        boolean z = this.enable;
        HashSet<TimeConfig> hashSet = this.blockTime;
        kLog.v("net.flowcontrol.time", "TimePolicies enable:" + z + " blockTime: " + hashSet + "  blockApi:" + this.blockApi.size());
    }

    private final boolean inBlockTime() {
        TimeConfig it;
        long current = Clock.System.INSTANCE.now().toEpochMilliseconds();
        Iterable $this$any$iv = this.blockTime;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            TimeConfig it2 = (TimeConfig) element$iv;
            if (it2.getS() > current || current > it2.getE()) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean isBlocked(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.enable) {
            if (inBlockTime()) {
                String key = host + path;
                if (this.blockApi.contains(key)) {
                    KLog_androidKt.getKLog().w("net.flowcontrol.time", "Blocked " + host + path + " for  flow control:TimePolicies");
                    this.tracker.onBlocked(host, path);
                    return true;
                }
                KLog_androidKt.getKLog().d("net.flowcontrol.time", host + path + " request ");
            } else {
                KLog_androidKt.getKLog().d("net.flowcontrol.time", host + path + " request ");
            }
            return false;
        }
        return false;
    }
}