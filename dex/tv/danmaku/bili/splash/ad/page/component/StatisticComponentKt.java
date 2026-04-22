package tv.danmaku.bili.splash.ad.page.component;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.BaseSplash;

/* compiled from: StatisticComponent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"calculateSplashRealDuration", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "calculateExposeTimeWhenSkip", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StatisticComponentKt {
    public static final long calculateSplashRealDuration(BaseSplash $this$calculateSplashRealDuration) {
        Intrinsics.checkNotNullParameter($this$calculateSplashRealDuration, "<this>");
        return SystemClock.elapsedRealtime() - $this$calculateSplashRealDuration.getComponentHolder$adsplash_debug().getSplashStartTimeMs();
    }

    public static final float calculateExposeTimeWhenSkip(BaseSplash $this$calculateExposeTimeWhenSkip) {
        Intrinsics.checkNotNullParameter($this$calculateExposeTimeWhenSkip, "<this>");
        return ((float) (SystemClock.elapsedRealtime() - $this$calculateExposeTimeWhenSkip.getComponentHolder$adsplash_debug().getSplashStartTimeMs())) / 1000.0f;
    }
}