package tv.danmaku.bili.flowcontrol.internal.model;

import com.bilibili.api.utils.GsonInstance;
import com.bilibili.lib.dd.DeviceDecision;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.tracker.EventListener;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: TimePolicies.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/model/TimePolicies;", "", "tracker", "Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;", "<init>", "(Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;)V", "blockApi", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "blockTime", "Ltv/danmaku/bili/flowcontrol/internal/model/TimeConfig;", "enable", "", "inBlockTime", "isBlocked", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TimePolicies {
    private final HashSet<String> blockApi;
    private final HashSet<TimeConfig> blockTime;
    private boolean enable;
    private final EventListener tracker;

    /* JADX WARN: Type inference failed for: r5v0, types: [tv.danmaku.bili.flowcontrol.internal.model.TimePolicies$_init_$lambda$1$$inlined$parseJson$1] */
    /* JADX WARN: Type inference failed for: r6v0, types: [tv.danmaku.bili.flowcontrol.internal.model.TimePolicies$_init_$lambda$0$$inlined$parseJson$1] */
    public TimePolicies(EventListener tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.tracker = tracker;
        this.blockApi = new HashSet<>();
        this.blockTime = new HashSet<>();
        this.enable = true;
        this.enable = DeviceDecision.INSTANCE.getBoolean("flowcontrol.block.enable", true);
        try {
            String it = DeviceDecision.INSTANCE.dd("flowcontrol.block.api", "[]");
            if (it != null) {
                Gson $this$parseJson$iv = GsonInstance.globalGson;
                List apiList = (List) $this$parseJson$iv.fromJson(it, new TypeToken<List<? extends String>>() { // from class: tv.danmaku.bili.flowcontrol.internal.model.TimePolicies$_init_$lambda$0$$inlined$parseJson$1
                }.getType());
                this.blockApi.addAll(apiList);
            }
            String it2 = DeviceDecision.INSTANCE.dd("flowcontrol.block.api.time", "[]");
            if (it2 != null) {
                Gson $this$parseJson$iv2 = GsonInstance.globalGson;
                List timeList = (List) $this$parseJson$iv2.fromJson(it2, new TypeToken<List<? extends TimeConfig>>() { // from class: tv.danmaku.bili.flowcontrol.internal.model.TimePolicies$_init_$lambda$1$$inlined$parseJson$1
                }.getType());
                this.blockTime.addAll(timeList);
            }
        } catch (Throwable th) {
        }
        boolean z = this.enable;
        HashSet<TimeConfig> hashSet = this.blockTime;
        BLog.v("net.flowcontrol.time", "TimePolicies enable:" + z + " blockTime: " + hashSet + "  blockApi:" + this.blockApi.size());
    }

    private final boolean inBlockTime() {
        TimeConfig it;
        long current = System.currentTimeMillis();
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
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (this.enable) {
            if (inBlockTime()) {
                String key = host + path;
                if (this.blockApi.contains(key)) {
                    BLog.w("net.flowcontrol.time", "Blocked " + host + path + " for  flow control:TimePolicies");
                    this.tracker.onBlocked(host, path);
                    return true;
                }
                BLog.d("net.flowcontrol.time", host + path + " request ");
            } else {
                BLog.d("net.flowcontrol.time", host + path + " request ");
            }
            return false;
        }
        return false;
    }
}