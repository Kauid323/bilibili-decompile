package tv.danmaku.bili.splash.ad.config;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SplashDefaultConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/splash/ad/config/SplashDefaultConfig;", "", "<init>", "()V", "DEFAULT_INTERVAL_FOR_PULL", "", "DEFAULT_INTERVAL_FOR_SHOW", "DEFAULT_MAX_SHOW_COUNT", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashDefaultConfig {
    public static final int $stable = 0;
    public static final int DEFAULT_INTERVAL_FOR_PULL = 900;
    public static final int DEFAULT_INTERVAL_FOR_SHOW = 900;
    public static final int DEFAULT_MAX_SHOW_COUNT = 6;
    public static final SplashDefaultConfig INSTANCE = new SplashDefaultConfig();

    private SplashDefaultConfig() {
    }
}