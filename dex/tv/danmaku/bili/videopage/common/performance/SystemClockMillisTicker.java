package tv.danmaku.bili.videopage.common.performance;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PerformanceTracerImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/SystemClockMillisTicker;", "Ltv/danmaku/bili/videopage/common/performance/ITicker;", "<init>", "()V", "currentTime", "", "getInterval", "start", ShareIconObserverKt.SHARE_FROM_END, "getUnit", "Ljava/util/concurrent/TimeUnit;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SystemClockMillisTicker implements ITicker {
    @Override // tv.danmaku.bili.videopage.common.performance.ITicker
    public long currentTime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // tv.danmaku.bili.videopage.common.performance.ITicker
    public long getInterval(long start, long end) {
        return end - start;
    }

    @Override // tv.danmaku.bili.videopage.common.performance.ITicker
    public TimeUnit getUnit() {
        return TimeUnit.MILLISECONDS;
    }
}