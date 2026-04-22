package tv.danmaku.biliplayerv2.utils;

import com.bilibili.base.util.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TimeFormater.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/TimeFormater;", "", "<init>", "()V", "formatTime", "", "position", "", "forceShowHour", "", "isShowZeroOfHour", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TimeFormater {
    public static final TimeFormater INSTANCE = new TimeFormater();

    public final String formatTime(long j) {
        return formatTime$default(this, j, false, false, 6, null);
    }

    public final String formatTime(long j, boolean z) {
        return formatTime$default(this, j, z, false, 4, null);
    }

    private TimeFormater() {
    }

    public static /* synthetic */ String formatTime$default(TimeFormater timeFormater, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return timeFormater.formatTime(j, z, z2);
    }

    public final String formatTime(long position, boolean forceShowHour, boolean isShowZeroOfHour) {
        String formatPlayTime = NumberFormat.formatPlayTime(999 + position, forceShowHour, isShowZeroOfHour);
        Intrinsics.checkNotNullExpressionValue(formatPlayTime, "formatPlayTime(...)");
        return formatPlayTime;
    }
}