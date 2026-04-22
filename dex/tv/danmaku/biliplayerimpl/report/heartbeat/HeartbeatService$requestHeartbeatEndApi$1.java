package tv.danmaku.biliplayerimpl.report.heartbeat;

import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HeartbeatService.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"tv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService$requestHeartbeatEndApi$1", "Lcom/bilibili/okretro/BiliApiDataCallback;", "", "onDataSuccess", "", "data", "onError", "t", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HeartbeatService$requestHeartbeatEndApi$1 extends BiliApiDataCallback<String> {
    final /* synthetic */ ReportContext $reportBak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeartbeatService$requestHeartbeatEndApi$1(ReportContext $reportBak) {
        this.$reportBak = $reportBak;
    }

    public void onDataSuccess(String data) {
        final ReportContext reportContext = this.$reportBak;
        HandlerThreads.post(3, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$requestHeartbeatEndApi$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HeartbeatService$requestHeartbeatEndApi$1.onDataSuccess$lambda$0(ReportContext.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDataSuccess$lambda$0(ReportContext $reportBak) {
        HeartBeatCacheManager.INSTANCE.removeCacheFile($reportBak);
    }

    public void onError(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        final ReportContext reportContext = this.$reportBak;
        HandlerThreads.post(3, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService$requestHeartbeatEndApi$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HeartbeatService$requestHeartbeatEndApi$1.onError$lambda$1(ReportContext.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$1(ReportContext $reportBak) {
        HeartBeatCacheManager.INSTANCE.saveCacheFile($reportBak);
    }
}