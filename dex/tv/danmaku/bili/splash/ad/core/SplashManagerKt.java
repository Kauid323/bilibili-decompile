package tv.danmaku.bili.splash.ad.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.core.model.SplashDataModel;

/* compiled from: SplashManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"splashState", "Ltv/danmaku/bili/splash/ad/core/model/SplashDataModel;", "getSplashState", "()Ltv/danmaku/bili/splash/ad/core/model/SplashDataModel;", "setSplashState", "(Ltv/danmaku/bili/splash/ad/core/model/SplashDataModel;)V", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashManagerKt {
    private static SplashDataModel splashState = new SplashDataModel();

    public static final SplashDataModel getSplashState() {
        return splashState;
    }

    public static final void setSplashState(SplashDataModel splashDataModel) {
        Intrinsics.checkNotNullParameter(splashDataModel, "<set-?>");
        splashState = splashDataModel;
    }
}