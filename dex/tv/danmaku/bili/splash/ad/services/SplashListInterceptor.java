package tv.danmaku.bili.splash.ad.services;

import android.app.Application;
import android.graphics.Point;
import com.bilibili.base.BiliContext;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.okretro.interceptor.DefaultRequestInterceptor;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;
import tv.danmaku.bili.splash.ad.utils.SplashLocalInfoHelper;
import tv.danmaku.bili.splash.ad.utils.sensor.SplashSensorUtilsKt;

/* compiled from: SplashListInterceptor.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/splash/ad/services/SplashListInterceptor;", "Lcom/bilibili/okretro/interceptor/DefaultRequestInterceptor;", "<init>", "()V", "addCommonParam", "", "params", "", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashListInterceptor extends DefaultRequestInterceptor {
    public static final int $stable = 8;

    protected void addCommonParam(Map<String, String> map) {
        super.addCommonParam(map);
        Point point = SplashLocalInfoHelper.getDeviceSize();
        int width = Math.min(point.x, point.y);
        int height = Math.max(point.x, point.y);
        if (map != null) {
            map.put("width", String.valueOf(width));
        }
        if (map != null) {
            map.put("height", String.valueOf(height));
        }
        String adExtra = GAdCoreKt.getGAdExtra().get();
        if (map != null) {
            map.put("ad_extra", adExtra);
        }
        String network = NetworkUtilsKt.isWifiConnected() ? NetworkUtilsKt.NETWORK_TYPE_WIFI : NetworkUtilsKt.NETWORK_TYPE_MOBILE;
        if (map != null) {
            map.put("network", network);
        }
        Application it = BiliContext.application();
        if (it != null) {
            boolean sensorSwitchEnable = SplashSensorUtilsKt.sensorSwitchEnable(it);
            if (map != null) {
                map.put("close_sensor", String.valueOf(!sensorSwitchEnable));
            }
        }
        BLog.i("SplashListInterceptor", "request params " + map);
    }
}