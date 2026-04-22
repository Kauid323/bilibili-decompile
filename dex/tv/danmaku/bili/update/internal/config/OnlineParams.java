package tv.danmaku.bili.update.internal.config;

import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.VBNumberExtKt;

/* compiled from: OnlineParams.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0002\"\u0014\u0010\t\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\u000e8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0002\"\u0014\u0010\u0015\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"isNewDownloaderEnable", "", "()Z", "isNewDownloaderEnable$delegate", "Lkotlin/Lazy;", "adapterAndroidR", "getAdapterAndroidR", "forceRestart", "getForceRestart", "updateInterval", "", "getUpdateInterval", "()J", "showDialogTimes", "", "getShowDialogTimes$annotations", "()V", "getShowDialogTimes", "()I", "enableStartupUpdate", "getEnableStartupUpdate", "showDialogOnMobileNetwork", "getShowDialogOnMobileNetwork", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OnlineParams {
    private static final Lazy isNewDownloaderEnable$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: tv.danmaku.bili.update.internal.config.OnlineParams$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean isNewDownloaderEnable_delegate$lambda$0;
            isNewDownloaderEnable_delegate$lambda$0 = OnlineParams.isNewDownloaderEnable_delegate$lambda$0();
            return Boolean.valueOf(isNewDownloaderEnable_delegate$lambda$0);
        }
    });

    @Deprecated(message = "Using field defined in fawkes api since 5.42.")
    public static /* synthetic */ void getShowDialogTimes$annotations() {
    }

    public static final boolean isNewDownloaderEnable() {
        return ((Boolean) isNewDownloaderEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNewDownloaderEnable_delegate$lambda$0() {
        Boolean abtest = RuntimeHelper.abtest("updater_new_downloader_enabled");
        if (abtest != null) {
            return abtest.booleanValue();
        }
        return true;
    }

    public static final boolean getAdapterAndroidR() {
        Boolean abtest = RuntimeHelper.abtest("updater_adapt_android11");
        if (abtest != null) {
            return abtest.booleanValue();
        }
        return true;
    }

    public static final boolean getForceRestart() {
        Boolean abtest = RuntimeHelper.abtest("updater_force_restart");
        if (abtest != null) {
            return abtest.booleanValue();
        }
        return false;
    }

    public static final long getUpdateInterval() {
        int result = RuntimeHelper.getConfigInt("update_interval_hours", 4);
        if (result < 0) {
            result = 4;
        }
        return result * VBNumberExtKt.ONE_HOUR * 1000;
    }

    public static final int getShowDialogTimes() {
        int result = RuntimeHelper.getConfigInt("update_dialog_times", 4);
        if (result <= 0) {
            return 4;
        }
        return result;
    }

    public static final boolean getEnableStartupUpdate() {
        return RuntimeHelper.getConfigInt("update_auto_switch", 1) == 1;
    }

    public static final long getShowDialogOnMobileNetwork() {
        int result = RuntimeHelper.getConfigInt("update_allow_4g_dialog", 24);
        if (result <= 0) {
            result = 24;
        }
        return result * VBNumberExtKt.ONE_HOUR * 1000;
    }
}