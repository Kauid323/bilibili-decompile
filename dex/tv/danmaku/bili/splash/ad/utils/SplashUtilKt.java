package tv.danmaku.bili.splash.ad.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splashwidget.BuildConfig;

/* compiled from: SplashUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002¨\u0006\u0005"}, d2 = {"isDebug", "", "()Z", "isDebug$delegate", "Lkotlin/Lazy;", "splashwidget_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashUtilKt {
    private static final Lazy isDebug$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.utils.SplashUtilKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean z;
            z = BuildConfig.DEBUG;
            return Boolean.valueOf(z);
        }
    });

    public static final boolean isDebug() {
        return ((Boolean) isDebug$delegate.getValue()).booleanValue();
    }
}