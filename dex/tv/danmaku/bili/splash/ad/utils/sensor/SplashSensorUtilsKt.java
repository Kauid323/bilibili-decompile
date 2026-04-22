package tv.danmaku.bili.splash.ad.utils.sensor;

import android.content.Context;
import com.bilibili.app.comm.list.common.sensor.SensorUtilsKt;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.settings2.ISettings;
import com.bilibili.lib.settings2.Settings2Service;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashSensorUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"hasAccSensorAndEnable", "", "context", "Landroid/content/Context;", "hasGyroscopeSensorAndEnable", "sensorSwitchEnable", "ACCELERATE_SPEED_THRESHOLD", "", "getACCELERATE_SPEED_THRESHOLD", "()I", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSensorUtilsKt {
    private static final int ACCELERATE_SPEED_THRESHOLD;

    public static final boolean hasAccSensorAndEnable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !SplashSensorDebugKt.disableSplashSensor(context) && SensorUtilsKt.hasAccSensor(context);
    }

    public static final boolean hasGyroscopeSensorAndEnable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !SplashSensorDebugKt.disableSplashSensor(context) && SensorUtilsKt.hasGyroscopeSensor(context);
    }

    public static final boolean sensorSwitchEnable(Context context) {
        ISettings iSettings;
        ISettings.IPrivacy privacy;
        Intrinsics.checkNotNullParameter(context, "context");
        Settings2Service settings2Service = (Settings2Service) BLRouter.get$default(BLRouter.INSTANCE, Settings2Service.class, (String) null, 2, (Object) null);
        if (settings2Service == null || (iSettings = settings2Service.settings2()) == null || (privacy = iSettings.privacy(context)) == null) {
            return true;
        }
        return privacy.getSplashSensorSwitch(true);
    }

    public static final int getACCELERATE_SPEED_THRESHOLD() {
        return ACCELERATE_SPEED_THRESHOLD;
    }

    static {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "splash.splash_shake_speed_threshold", (Object) null, 2, (Object) null);
        ACCELERATE_SPEED_THRESHOLD = str != null ? Integer.parseInt(str) : 12;
    }
}