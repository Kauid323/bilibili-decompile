package tv.danmaku.bili.ui.splash.utils.sensor;

import android.content.Context;
import com.bilibili.app.comm.list.common.sensor.SensorUtilsKt;
import com.bilibili.app.preferences.settings2.Settings2;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashSensorUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\"\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"hasAccSensorAndEnable", "", "context", "Landroid/content/Context;", "hasGyroscopeSensorAndEnable", "sensorSwitchEnable", "ACCELERATE_SPEED_THRESHOLD", "", "getACCELERATE_SPEED_THRESHOLD", "()I", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashSensorUtilsKt {
    private static final int ACCELERATE_SPEED_THRESHOLD;

    public static final boolean hasAccSensorAndEnable(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return !SplashSensorDebugKt.disableSplashSensor(context2) && SensorUtilsKt.hasAccSensor(context2);
    }

    public static final boolean hasGyroscopeSensorAndEnable(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return !SplashSensorDebugKt.disableSplashSensor(context2) && SensorUtilsKt.hasGyroscopeSensor(context2);
    }

    public static final boolean sensorSwitchEnable(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return Settings2.privacy(context2).getSplashSensorSwitch(true);
    }

    public static final int getACCELERATE_SPEED_THRESHOLD() {
        return ACCELERATE_SPEED_THRESHOLD;
    }

    static {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "splash.splash_shake_speed_threshold", (Object) null, 2, (Object) null);
        ACCELERATE_SPEED_THRESHOLD = str != null ? Integer.parseInt(str) : 12;
    }
}