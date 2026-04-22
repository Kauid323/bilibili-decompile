package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.homepage.splash.actions.PreDisplayStatusBarAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashEgg;
import tv.danmaku.bili.ui.splash.ad.model.SplashEggKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.SplashLayoutHelperKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopViewTransitionComponent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "initTopViewTransitionComponent", "", "Ltv/danmaku/bili/ui/splash/ad/page/FullImageSplash;", "triggerTopViewTransition", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopViewTransitionComponentKt {
    private static final String TAG = "[Splash]TopViewTransitionComponent";

    public static final void initTopViewTransitionComponent(FullImageSplash $this$initTopViewTransitionComponent) {
        SplashEgg splashEgg;
        SplashEgg splashEgg2;
        Intrinsics.checkNotNullParameter($this$initTopViewTransitionComponent, "<this>");
        if (SplashEggKt.isTopViewTransitionType($this$initTopViewTransitionComponent.getSplash())) {
            View view2 = $this$initTopViewTransitionComponent.getView();
            String str = null;
            ViewGroup rootView = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
            if (rootView == null) {
                return;
            }
            Splash splash = $this$initTopViewTransitionComponent.getSplash();
            String fileUri = BusinessSplashResHelperKt.md5ToFileUri((splash == null || (splashEgg2 = splash.splashEgg) == null) ? null : splashEgg2.getVideoHash());
            if (fileUri == null) {
                Splash splash2 = $this$initTopViewTransitionComponent.getSplash();
                Long valueOf = splash2 != null ? Long.valueOf(splash2.id) : null;
                Splash splash3 = $this$initTopViewTransitionComponent.getSplash();
                if (splash3 != null && (splashEgg = splash3.splashEgg) != null) {
                    str = splashEgg.getVideoUrl();
                }
                BLog.i(TAG, "splash egg resource not ready, id = " + valueOf + ", eggResUrl = " + str);
                return;
            }
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SplashAlphaPlayer $this$initTopViewTransitionComponent_u24lambda_u240 = new SplashAlphaPlayer(context, (AttributeSet) null, 0, fileUri, (Function0) null, (Function0) null, (Function0) null, (Function0) null, 246, (DefaultConstructorMarker) null);
            $this$initTopViewTransitionComponent_u24lambda_u240.setLayoutParams(SplashLayoutHelperKt.createMatchParentLayoutParams(rootView));
            $this$initTopViewTransitionComponent.topViewTransitionPlayer = $this$initTopViewTransitionComponent_u24lambda_u240;
            rootView.addView((View) $this$initTopViewTransitionComponent.topViewTransitionPlayer, 0);
        }
    }

    public static final boolean triggerTopViewTransition(final FullImageSplash $this$triggerTopViewTransition) {
        Intrinsics.checkNotNullParameter($this$triggerTopViewTransition, "<this>");
        if (SplashEggKt.isTopViewTransitionType($this$triggerTopViewTransition.getSplash())) {
            if ($this$triggerTopViewTransition.topViewTransitionPlayer == null) {
                BLog.i(TAG, "top view transition player is null");
                SplashAdHelper.INSTANCE.reportSplashTopViewTransitionShow$splash_debug($this$triggerTopViewTransition.getSplash(), false, "1");
                return false;
            }
            SplashAlphaPlayer splashAlphaPlayer = $this$triggerTopViewTransition.topViewTransitionPlayer;
            if (!(splashAlphaPlayer != null && splashAlphaPlayer.hasPrepared())) {
                BLog.i(TAG, "top view player not prepared");
                SplashAdHelper.INSTANCE.reportSplashTopViewTransitionShow$splash_debug($this$triggerTopViewTransition.getSplash(), false, "2");
                return false;
            } else if ($this$triggerTopViewTransition.getLinkageTargetRect() == null) {
                BLog.i(TAG, "top view banner not ready");
                SplashAdHelper.INSTANCE.reportSplashTopViewTransitionShow$splash_debug($this$triggerTopViewTransition.getSplash(), false, "3");
                return false;
            } else {
                SplashViewModel splashViewModel = $this$triggerTopViewTransition.mSplashViewModel;
                if (splashViewModel != null) {
                    splashViewModel.update(new PlayerEvent.OnStop("trans"));
                }
                SplashAlphaPlayer splashAlphaPlayer2 = $this$triggerTopViewTransition.topViewTransitionPlayer;
                if (splashAlphaPlayer2 != null) {
                    splashAlphaPlayer2.play();
                }
                SplashAdHelper.reportSplashTopViewTransitionShow$splash_debug$default(SplashAdHelper.INSTANCE, $this$triggerTopViewTransition.getSplash(), true, null, 4, null);
                SplashViewModel splashViewModel2 = $this$triggerTopViewTransition.mSplashViewModel;
                if (splashViewModel2 != null) {
                    splashViewModel2.update(new PreDisplayStatusBarAction());
                }
                $this$triggerTopViewTransition.topViewTransitionCanPlay = true;
                Iterable alphaView = $this$triggerTopViewTransition.getAlphaView();
                if (alphaView != null) {
                    Iterable $this$forEach$iv = alphaView;
                    for (Object element$iv : $this$forEach$iv) {
                        View it = (View) element$iv;
                        it.setVisibility(8);
                    }
                }
                $this$triggerTopViewTransition.mSplashView.setVisibility(4);
                $this$triggerTopViewTransition.mRootContainer.setBackgroundColor(0);
                final Ref.BooleanRef isExit = new Ref.BooleanRef();
                SplashAlphaPlayer splashAlphaPlayer3 = $this$triggerTopViewTransition.topViewTransitionPlayer;
                if (splashAlphaPlayer3 != null) {
                    splashAlphaPlayer3.setOnError(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.TopViewTransitionComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit triggerTopViewTransition$lambda$1;
                            triggerTopViewTransition$lambda$1 = TopViewTransitionComponentKt.triggerTopViewTransition$lambda$1(isExit, $this$triggerTopViewTransition);
                            return triggerTopViewTransition$lambda$1;
                        }
                    });
                }
                SplashAlphaPlayer splashAlphaPlayer4 = $this$triggerTopViewTransition.topViewTransitionPlayer;
                if (splashAlphaPlayer4 != null) {
                    splashAlphaPlayer4.setOnCompletionListener(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.TopViewTransitionComponentKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit triggerTopViewTransition$lambda$2;
                            triggerTopViewTransition$lambda$2 = TopViewTransitionComponentKt.triggerTopViewTransition$lambda$2(isExit, $this$triggerTopViewTransition);
                            return triggerTopViewTransition$lambda$2;
                        }
                    });
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit triggerTopViewTransition$lambda$1(Ref.BooleanRef $isExit, FullImageSplash $this_triggerTopViewTransition) {
        if (!$isExit.element) {
            $isExit.element = true;
            $this_triggerTopViewTransition.exitSplash(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit triggerTopViewTransition$lambda$2(Ref.BooleanRef $isExit, FullImageSplash $this_triggerTopViewTransition) {
        if (!$isExit.element) {
            $isExit.element = true;
            $this_triggerTopViewTransition.exitSplash(false);
        }
        return Unit.INSTANCE;
    }
}