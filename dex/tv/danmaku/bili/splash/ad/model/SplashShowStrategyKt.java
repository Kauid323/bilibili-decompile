package tv.danmaku.bili.splash.ad.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashShowStrategy.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isValid", "", "Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "(Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;)Z", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashShowStrategyKt {
    public static final boolean isValid(SplashShowStrategy $this$isValid) {
        Intrinsics.checkNotNullParameter($this$isValid, "<this>");
        long currentTime = System.currentTimeMillis() / 1000;
        return currentTime <= $this$isValid.getEtime() && $this$isValid.getStime() <= currentTime;
    }
}