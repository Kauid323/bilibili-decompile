package tv.danmaku.bili.splash.ad.reporter.ad;

import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SplashReportConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/splash/ad/reporter/ad/SplashReportConfig;", "", "<init>", "()V", "resourceId", "", "getResourceId", "()J", "sourceId", "getSourceId", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashReportConfig {
    public static final int $stable = 0;
    public static final SplashReportConfig INSTANCE = new SplashReportConfig();

    private SplashReportConfig() {
    }

    public final long getResourceId() {
        return ListDeviceInfoKt.isHdApp() ? 5713L : 926L;
    }

    public final long getSourceId() {
        return ListDeviceInfoKt.isHdApp() ? 5714L : 929L;
    }
}