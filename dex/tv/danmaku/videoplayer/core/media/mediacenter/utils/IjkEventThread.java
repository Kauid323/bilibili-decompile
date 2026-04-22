package tv.danmaku.videoplayer.core.media.mediacenter.utils;

import android.os.HandlerThread;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IjkEventThread.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/utils/IjkEventThread;", "Landroid/os/HandlerThread;", "<init>", "()V", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkEventThread extends HandlerThread {
    public IjkEventThread() {
        super("IjkEventDispatchThread", 0);
    }
}