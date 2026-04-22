package tv.danmaku.biliplayerv2.service.business;

import com.bilibili.app.comm.timing.service.TimingCallback;
import kotlin.Deprecated;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ShutOffTimingService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H'J\b\u0010\f\u001a\u00020\u0007H'J\b\u0010\r\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0003H'J\b\u0010\u0013\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/business/IShutOffTimeService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "startShutOffTiming", "", "time", "", "isCustomize", "", "getLeftTime", "getTotalTime", "setDisableOnTimeAlert", "disable", "isDisableOnTimeAlert", "isInSleepMode", "registerTimingCallback", "callback", "Lcom/bilibili/app/comm/timing/service/TimingCallback;", "unregisterTimingCallback", "existTimingReminder", "isCustomizeTotalTime", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IShutOffTimeService extends IPlayerService {
    void existTimingReminder();

    long getLeftTime();

    long getTotalTime();

    boolean isCustomizeTotalTime();

    @Deprecated(message = "改为全局弹窗，无法停用")
    boolean isDisableOnTimeAlert();

    boolean isInSleepMode();

    void registerTimingCallback(TimingCallback timingCallback);

    @Deprecated(message = "改为全局弹窗，无法停用")
    void setDisableOnTimeAlert(boolean z);

    void startShutOffTiming(long j, boolean z);

    void unregisterTimingCallback(TimingCallback timingCallback);
}