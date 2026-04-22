package tv.danmaku.bili.player.router;

import com.bilibili.playerbizcommon.IPlayerSleepModeService;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.sleepmode.SleepModeManager;

/* compiled from: PlayerSleepModeRouteService.kt */
@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/player/router/PlayerSleepModeRouteService;", "Lcom/bilibili/playerbizcommon/IPlayerSleepModeService;", "<init>", "()V", "start", "", "totalMinutes", "", "continueTimerInBackground", "value", "", "getLeftTimeInMillis", "getTotalTime", "isRunning", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("sleep_mode")
public final class PlayerSleepModeRouteService implements IPlayerSleepModeService {
    public static final int $stable = 0;

    public void start(long totalMinutes) {
        if (totalMinutes >= 0) {
            SleepModeManager.getInstance().start(totalMinutes);
        }
    }

    public void continueTimerInBackground(boolean value) {
        SleepModeManager.getInstance().setContinueTimerInBackground(value);
    }

    public long getLeftTimeInMillis() {
        return SleepModeManager.getInstance().getLeftTimeInMillis();
    }

    public long getTotalTime() {
        return SleepModeManager.getInstance().getTotalTime();
    }

    public boolean isRunning() {
        return SleepModeManager.getInstance().isRunning();
    }
}