package video.base.utils;

import kotlin.Metadata;
import kotlinx.datetime.Clock;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getCurrentTimeMillis", "", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DateKt {
    public static final long getCurrentTimeMillis() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }
}