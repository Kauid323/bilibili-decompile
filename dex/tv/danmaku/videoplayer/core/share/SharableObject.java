package tv.danmaku.videoplayer.core.share;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SharableObject.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Ltv/danmaku/videoplayer/core/share/SharableObject;", "", "<init>", "()V", "mCurrentRefCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentRefCount", "", "getCurrentRefCount", "()I", "incrementRefCount", "", "decrementRefCount", "detachByShared", "attachByShared", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class SharableObject {
    private AtomicInteger mCurrentRefCount = new AtomicInteger(0);

    public final int getCurrentRefCount() {
        return this.mCurrentRefCount.get();
    }

    public final void incrementRefCount() {
        this.mCurrentRefCount.incrementAndGet();
    }

    public final void decrementRefCount() {
        this.mCurrentRefCount.decrementAndGet();
    }

    public void detachByShared() {
    }

    public void attachByShared() {
    }
}