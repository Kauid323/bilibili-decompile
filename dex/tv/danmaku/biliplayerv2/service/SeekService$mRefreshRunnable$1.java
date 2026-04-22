package tv.danmaku.biliplayerv2.service;

import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SeekService.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/biliplayerv2/service/SeekService$mRefreshRunnable$1", "Ljava/lang/Runnable;", "run", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SeekService$mRefreshRunnable$1 implements Runnable {
    final /* synthetic */ SeekService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SeekService$mRefreshRunnable$1(SeekService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.refresh();
        HandlerThreads.postDelayed(0, this, 1000L);
    }
}