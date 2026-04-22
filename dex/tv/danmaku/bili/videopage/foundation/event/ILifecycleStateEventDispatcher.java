package tv.danmaku.bili.videopage.foundation.event;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ILifecycleStateEventDispatcher.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/foundation/event/ILifecycleStateEventDispatcher;", "", "addEventObserver", "", "observer", "Ltv/danmaku/bili/videopage/foundation/event/ILifecycleStateEventObserver;", "removeEventObserver", "videopagefoundation_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ILifecycleStateEventDispatcher {
    void addEventObserver(ILifecycleStateEventObserver iLifecycleStateEventObserver);

    void removeEventObserver(ILifecycleStateEventObserver iLifecycleStateEventObserver);
}