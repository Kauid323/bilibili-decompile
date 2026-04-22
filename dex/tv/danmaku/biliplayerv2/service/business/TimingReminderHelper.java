package tv.danmaku.biliplayerv2.service.business;

import com.bilibili.app.comm.timing.service.TimingCallback;
import com.bilibili.app.comm.timing.service.manager.BizTimingReminderManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ShutOffTimingService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/service/business/TimingReminderHelper;", "", "<init>", "()V", "isInSleepMode", "", "getLeftTime", "", "getTotalTime", "registerTimingCallback", "", "callback", "Lcom/bilibili/app/comm/timing/service/TimingCallback;", "unregisterTimingCallback", "startTiming", "time", "custom", "isCustomizeTotalTime", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TimingReminderHelper {
    public final boolean isInSleepMode() {
        return BizTimingReminderManager.Companion.getInstance().isInSleepMode();
    }

    public final long getLeftTime() {
        return BizTimingReminderManager.Companion.getInstance().getLeftTimeInMillis();
    }

    public final long getTotalTime() {
        return BizTimingReminderManager.Companion.getInstance().getTotalMinutes();
    }

    public final void registerTimingCallback(TimingCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BizTimingReminderManager.Companion.getInstance().registerTimingCallback(callback);
    }

    public final void unregisterTimingCallback(TimingCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BizTimingReminderManager.Companion.getInstance().unregisterTimingCallback(callback);
    }

    public final void startTiming(long time, boolean custom) {
        BizTimingReminderManager.Companion.getInstance().start(time, custom);
    }

    public final boolean isCustomizeTotalTime() {
        return BizTimingReminderManager.Companion.getInstance().isCustomize();
    }
}