package tv.danmaku.bili.splash.ad.test;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;

/* compiled from: SplashLiteData.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"sdf", "Ljava/text/SimpleDateFormat;", "getSdf", "()Ljava/text/SimpleDateFormat;", "liteData", "Ltv/danmaku/bili/splash/ad/test/SplashLiteData;", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "getLiteData", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)Ltv/danmaku/bili/splash/ad/test/SplashLiteData;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashLiteDataKt {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static final SimpleDateFormat getSdf() {
        return sdf;
    }

    public static final SplashLiteData getLiteData(SplashOrder $this$liteData) {
        Intrinsics.checkNotNullParameter($this$liteData, "<this>");
        long j = 1000;
        return new SplashLiteData($this$liteData.getId(), $this$liteData.getCardType(), $this$liteData.getType(), sdf.format(Long.valueOf($this$liteData.getBeginTime() * j)), sdf.format(Long.valueOf($this$liteData.getEndTime() * j)), $this$liteData.getLocalExposeCount(), sdf.format(Long.valueOf($this$liteData.getLastExposeTime())), BusinessSplashResHelperKt.fetchResourceFileByHash($this$liteData.getImageHash()) != null, BusinessSplashResHelperKt.fetchResourceFileByHash($this$liteData.getVideoHash()) != null, $this$liteData.getImageHash(), $this$liteData.getVideoHash());
    }
}