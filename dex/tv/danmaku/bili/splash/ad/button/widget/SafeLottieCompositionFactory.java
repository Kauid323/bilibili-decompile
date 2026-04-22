package tv.danmaku.bili.splash.ad.button.widget;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.widget.SafeLottieAnimationView;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SafeLottieCompositionFactory.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/widget/SafeLottieCompositionFactory;", "", "<init>", "()V", "safeLoadPlayLottie", "", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "lottieAnimationView", "Ltv/danmaku/bili/splash/ad/widget/SafeLottieAnimationView;", "inputStream", "Ljava/io/InputStream;", "cacheKey", "", "callBack", "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieComposition;", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SafeLottieCompositionFactory {
    public static final int $stable = 0;
    public static final SafeLottieCompositionFactory INSTANCE = new SafeLottieCompositionFactory();

    private SafeLottieCompositionFactory() {
    }

    public static /* synthetic */ void safeLoadPlayLottie$default(SafeLottieCompositionFactory safeLottieCompositionFactory, SplashOrder splashOrder, SafeLottieAnimationView safeLottieAnimationView, InputStream inputStream, String str, Function1 function1, int i, Object obj) {
        String str2;
        Function1 function12;
        if ((i & 8) == 0) {
            str2 = str;
        } else {
            str2 = null;
        }
        if ((i & 16) == 0) {
            function12 = function1;
        } else {
            function12 = new Function1() { // from class: tv.danmaku.bili.splash.ad.button.widget.SafeLottieCompositionFactory$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit safeLoadPlayLottie$lambda$0;
                    safeLoadPlayLottie$lambda$0 = SafeLottieCompositionFactory.safeLoadPlayLottie$lambda$0((LottieComposition) obj2);
                    return safeLoadPlayLottie$lambda$0;
                }
            };
        }
        safeLottieCompositionFactory.safeLoadPlayLottie(splashOrder, safeLottieAnimationView, inputStream, str2, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit safeLoadPlayLottie$lambda$0(LottieComposition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void safeLoadPlayLottie(final SplashOrder splash, SafeLottieAnimationView lottieAnimationView, InputStream inputStream, final String cacheKey, final Function1<? super LottieComposition, Unit> function1) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(function1, "callBack");
        try {
            lottieAnimationView.setExceptionCallback(new Function0() { // from class: tv.danmaku.bili.splash.ad.button.widget.SafeLottieCompositionFactory$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit safeLoadPlayLottie$lambda$1;
                    safeLoadPlayLottie$lambda$1 = SafeLottieCompositionFactory.safeLoadPlayLottie$lambda$1(SplashOrder.this, cacheKey);
                    return safeLoadPlayLottie$lambda$1;
                }
            });
            LottieCompositionFactory.fromJsonInputStream(inputStream, cacheKey).addListener(new LottieListener() { // from class: tv.danmaku.bili.splash.ad.button.widget.SafeLottieCompositionFactory$$ExternalSyntheticLambda1
                public final void onResult(Object obj) {
                    SafeLottieCompositionFactory.safeLoadPlayLottie$lambda$2(SplashOrder.this, cacheKey, function1, (LottieComposition) obj);
                }
            });
        } catch (Exception e) {
            SplashCustomReporterKt.reportResourceLoadException(splash, String.valueOf(cacheKey), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit safeLoadPlayLottie$lambda$1(SplashOrder $splash, String $cacheKey) {
        SplashCustomReporterKt.reportResourceLoadException($splash, String.valueOf($cacheKey), 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void safeLoadPlayLottie$lambda$2(SplashOrder $splash, String $cacheKey, Function1 $callBack, LottieComposition it) {
        if (it == null) {
            BLog.i("[Splash]SafeLottieCompositionFactory", "lottie resource unready, splashId = " + $splash.getId() + ", key = " + $cacheKey);
            return;
        }
        try {
            $callBack.invoke(it);
        } catch (Exception e) {
            SplashCustomReporterKt.reportResourceLoadException($splash, String.valueOf($cacheKey), 0);
        }
    }
}