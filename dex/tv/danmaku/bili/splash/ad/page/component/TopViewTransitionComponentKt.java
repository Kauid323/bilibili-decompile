package tv.danmaku.bili.splash.ad.page.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.homepage.splash.actions.PreDisplayStatusBarAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashEgg;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutHelperKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;

/* compiled from: TopViewTransitionComponent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "initTopViewTransitionComponent", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "triggerTopViewTransition", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopViewTransitionComponentKt {
    private static final String TAG = "[Splash]TopViewTransitionComponent";

    public static final void initTopViewTransitionComponent(BaseSplash $this$initTopViewTransitionComponent) {
        Intrinsics.checkNotNullParameter($this$initTopViewTransitionComponent, "<this>");
        if (ExtSplashOrderKt.isTopViewTransitionType($this$initTopViewTransitionComponent.getSplash$adsplash_debug())) {
            SplashContainerView rootView = $this$initTopViewTransitionComponent.getBinding$adsplash_debug().getRoot();
            Intrinsics.checkNotNullExpressionValue(rootView, "getRoot(...)");
            SplashEgg splashEgg = $this$initTopViewTransitionComponent.getSplash$adsplash_debug().getSplashEgg();
            String fileUri = BusinessSplashResHelperKt.fetchResourceLocalUriPathByHash(splashEgg != null ? splashEgg.getVideoHash() : null);
            if (fileUri == null) {
                long id = $this$initTopViewTransitionComponent.getSplash$adsplash_debug().getId();
                SplashEgg splashEgg2 = $this$initTopViewTransitionComponent.getSplash$adsplash_debug().getSplashEgg();
                BLog.i(TAG, "splash egg resource not ready, id = " + id + ", eggResUrl = " + (splashEgg2 != null ? splashEgg2.getVideoUrl() : null));
                return;
            }
            ComponentHolder componentHolder$adsplash_debug = $this$initTopViewTransitionComponent.getComponentHolder$adsplash_debug();
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SplashAlphaPlayer $this$initTopViewTransitionComponent_u24lambda_u240 = new SplashAlphaPlayer(context, null, 0, fileUri, null, null, null, null, BR.group, null);
            $this$initTopViewTransitionComponent_u24lambda_u240.setLayoutParams(SplashLayoutHelperKt.createPinkHdCompatFullscreenVideoLayoutParams((ViewGroup) rootView, $this$initTopViewTransitionComponent.getSplash$adsplash_debug()));
            componentHolder$adsplash_debug.setTopViewTransitionPlayer($this$initTopViewTransitionComponent_u24lambda_u240);
            rootView.addView((View) $this$initTopViewTransitionComponent.getComponentHolder$adsplash_debug().getTopViewTransitionPlayer(), 0);
        }
    }

    public static final boolean triggerTopViewTransition(final BaseSplash $this$triggerTopViewTransition) {
        Intrinsics.checkNotNullParameter($this$triggerTopViewTransition, "<this>");
        if (ExtSplashOrderKt.isTopViewTransitionType($this$triggerTopViewTransition.getSplash$adsplash_debug())) {
            if ($this$triggerTopViewTransition.getComponentHolder$adsplash_debug().getTopViewTransitionPlayer() == null) {
                BLog.i(TAG, "top view transition player is null");
                SplashAdHelper.INSTANCE.reportSplashTopViewTransitionShow$adsplash_debug($this$triggerTopViewTransition.getSplash$adsplash_debug(), false, "1");
                return false;
            }
            SplashAlphaPlayer topViewTransitionPlayer = $this$triggerTopViewTransition.getComponentHolder$adsplash_debug().getTopViewTransitionPlayer();
            if (!(topViewTransitionPlayer != null && topViewTransitionPlayer.hasPrepared())) {
                BLog.i(TAG, "top view player not ready");
                SplashAdHelper.INSTANCE.reportSplashTopViewTransitionShow$adsplash_debug($this$triggerTopViewTransition.getSplash$adsplash_debug(), false, "2");
                return false;
            } else if (LinkageAnimationComponentKt.getLinkageTargetRect($this$triggerTopViewTransition) == null) {
                SplashAdHelper.INSTANCE.reportSplashTopViewTransitionShow$adsplash_debug($this$triggerTopViewTransition.getSplash$adsplash_debug(), false, "3");
                return false;
            } else {
                $this$triggerTopViewTransition.getViewModel$adsplash_debug().update(new PlayerEvent.OnStop("trans"));
                $this$triggerTopViewTransition.getComponentHolder$adsplash_debug().setTopViewTransitionCanPlay(true);
                SplashAlphaPlayer topViewTransitionPlayer2 = $this$triggerTopViewTransition.getComponentHolder$adsplash_debug().getTopViewTransitionPlayer();
                if (topViewTransitionPlayer2 != null) {
                    topViewTransitionPlayer2.play();
                }
                SplashAdHelper.reportSplashTopViewTransitionShow$adsplash_debug$default(SplashAdHelper.INSTANCE, $this$triggerTopViewTransition.getSplash$adsplash_debug(), true, null, 4, null);
                $this$triggerTopViewTransition.getViewModel$adsplash_debug().update(new PreDisplayStatusBarAction());
                Iterable $this$forEach$iv = LinkageAnimationComponentKt.getLinkageAnimationAlphaView($this$triggerTopViewTransition);
                for (Object element$iv : $this$forEach$iv) {
                    View it = (View) element$iv;
                    if (it != null) {
                        it.setVisibility(8);
                    }
                }
                $this$triggerTopViewTransition.getBinding$adsplash_debug().splashView.setVisibility(8);
                $this$triggerTopViewTransition.getBinding$adsplash_debug().rootContainer.setBackgroundColor(0);
                final Ref.BooleanRef isExit = new Ref.BooleanRef();
                SplashAlphaPlayer topViewTransitionPlayer3 = $this$triggerTopViewTransition.getComponentHolder$adsplash_debug().getTopViewTransitionPlayer();
                if (topViewTransitionPlayer3 != null) {
                    topViewTransitionPlayer3.setOnError(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.TopViewTransitionComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit triggerTopViewTransition$lambda$1;
                            triggerTopViewTransition$lambda$1 = TopViewTransitionComponentKt.triggerTopViewTransition$lambda$1(isExit, $this$triggerTopViewTransition);
                            return triggerTopViewTransition$lambda$1;
                        }
                    });
                }
                SplashAlphaPlayer topViewTransitionPlayer4 = $this$triggerTopViewTransition.getComponentHolder$adsplash_debug().getTopViewTransitionPlayer();
                if (topViewTransitionPlayer4 != null) {
                    topViewTransitionPlayer4.setOnCompletionListener(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.TopViewTransitionComponentKt$$ExternalSyntheticLambda1
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
    public static final Unit triggerTopViewTransition$lambda$1(Ref.BooleanRef $isExit, BaseSplash $this_triggerTopViewTransition) {
        BLog.i(TAG, "triggerTopViewTransition, top view player error");
        if (!$isExit.element) {
            $isExit.element = true;
            ISplashEvent.CC.exitSplash$default($this_triggerTopViewTransition, false, null, null, 6, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit triggerTopViewTransition$lambda$2(Ref.BooleanRef $isExit, BaseSplash $this_triggerTopViewTransition) {
        if (!$isExit.element) {
            $isExit.element = true;
            ISplashEvent.CC.exitSplash$default($this_triggerTopViewTransition, false, null, null, 6, null);
        }
        return Unit.INSTANCE;
    }
}