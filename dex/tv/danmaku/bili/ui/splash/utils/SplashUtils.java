package tv.danmaku.bili.ui.splash.utils;

import android.app.Application;
import android.net.NetworkInfo;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.Connectivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.android.ConnectivityManagerHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/SplashUtils;", "", "<init>", "()V", "CONTEXT", "Landroid/app/Application;", "isWifiConnected", "", "isMobileConnected", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashUtils {
    public static final SplashUtils INSTANCE = new SplashUtils();
    private static final Application CONTEXT = BiliContext.application();
    public static final int $stable = 8;

    private SplashUtils() {
    }

    @JvmStatic
    public static final boolean isWifiConnected() {
        return Connectivity.isConnected(Connectivity.getWifiNetworkInfo(CONTEXT));
    }

    @JvmStatic
    public static final boolean isMobileConnected() {
        NetworkInfo info = Connectivity.getActiveNetworkInfo(CONTEXT);
        if (info == null || !ConnectivityManagerHelper.isActiveNetworkMetered(CONTEXT)) {
            return false;
        }
        int networkClass = ConnectivityManagerHelper.getNetworkClass(info.getSubtype());
        return networkClass == 3 || networkClass == 4;
    }
}