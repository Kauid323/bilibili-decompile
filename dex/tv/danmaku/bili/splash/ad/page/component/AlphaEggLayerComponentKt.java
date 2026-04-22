package tv.danmaku.bili.splash.ad.page.component;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.homepage.splash.actions.PreDisplayStatusBarAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashEgg;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;

/* compiled from: AlphaEggLayerComponent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0006H\u0000\u001a\f\u0010\t\u001a\u00020\u0005*\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "HALF_BLACK", "", "initEggLayer", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "triggerTransportEgg", "", "handleEggPlayFinishEvent", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AlphaEggLayerComponentKt {
    private static final int HALF_BLACK = 2130706432;
    private static final String TAG = "[Splash]AlphaEggLayerComponent";

    public static final void initEggLayer(final BaseSplash $this$initEggLayer) {
        Intrinsics.checkNotNullParameter($this$initEggLayer, "<this>");
        Context context = $this$initEggLayer.getContext();
        if (context != null && ExtSplashOrderKt.isEggSplash($this$initEggLayer.getSplash$adsplash_debug())) {
            SplashContainerView rootView = $this$initEggLayer.getBinding$adsplash_debug().getRoot();
            Intrinsics.checkNotNullExpressionValue(rootView, "getRoot(...)");
            SplashEgg splashEgg = $this$initEggLayer.getSplash$adsplash_debug().getSplashEgg();
            String fileUri = BusinessSplashResHelperKt.fetchResourceLocalUriPathByHash(splashEgg != null ? splashEgg.getVideoHash() : null);
            if (fileUri == null) {
                long id = $this$initEggLayer.getSplash$adsplash_debug().getId();
                SplashEgg splashEgg2 = $this$initEggLayer.getSplash$adsplash_debug().getSplashEgg();
                BLog.i(TAG, "splash egg resource not ready, id = " + id + ", eggResUrl = " + (splashEgg2 != null ? splashEgg2.getVideoUrl() : null));
                return;
            }
            final SplashAlphaPlayer $this$initEggLayer_u24lambda_u240 = new SplashAlphaPlayer(context, null, 0, fileUri, null, null, null, null, BR.group, null);
            $this$initEggLayer_u24lambda_u240.setLayoutParams(SplashLayoutUtilsKt.createMatchParentLayoutParams((ViewGroup) rootView));
            $this$initEggLayer_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.component.AlphaEggLayerComponentKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlphaEggLayerComponentKt.initEggLayer$lambda$0$0(BaseSplash.this, view);
                }
            });
            $this$initEggLayer.getComponentHolder$adsplash_debug().setEggPlayer($this$initEggLayer_u24lambda_u240);
            rootView.addView((View) $this$initEggLayer_u24lambda_u240, 0);
            ComponentHolder componentHolder$adsplash_debug = $this$initEggLayer.getComponentHolder$adsplash_debug();
            SplashEgg splashEgg3 = $this$initEggLayer.getSplash$adsplash_debug().getSplashEgg();
            componentHolder$adsplash_debug.setEggCountdownView((View) SplashCircleCountdownButtonKt.createCircleCountdownButton(context, splashEgg3 != null ? (int) splashEgg3.getDuration() : 0, new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.AlphaEggLayerComponentKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit initEggLayer$lambda$1;
                    initEggLayer$lambda$1 = AlphaEggLayerComponentKt.initEggLayer$lambda$1(BaseSplash.this, $this$initEggLayer_u24lambda_u240);
                    return initEggLayer$lambda$1;
                }
            }, new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.AlphaEggLayerComponentKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit initEggLayer$lambda$2;
                    initEggLayer$lambda$2 = AlphaEggLayerComponentKt.initEggLayer$lambda$2(BaseSplash.this);
                    return initEggLayer$lambda$2;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEggLayer$lambda$0$0(BaseSplash $this_initEggLayer, View it) {
        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
        SplashOrder splash$adsplash_debug = $this_initEggLayer.getSplash$adsplash_debug();
        SplashAlphaPlayer eggPlayer = $this_initEggLayer.getComponentHolder$adsplash_debug().getEggPlayer();
        splashAdHelper.reportSplashEggClick$adsplash_debug(splash$adsplash_debug, eggPlayer != null ? eggPlayer.getCurrentPlayTime() : 0L, SplashConfigKt.getSplashEnableEggClickable());
        if (SplashConfigKt.getSplashEnableEggClickable()) {
            Intent intent = SplashUtilsKt.buildThirdIntent($this_initEggLayer.getSplash$adsplash_debug(), $this_initEggLayer.getSplash$adsplash_debug().getAppLink(), $this_initEggLayer.getSplash$adsplash_debug().getAppPkg());
            ISplashEvent.CC.onJumpClick$default($this_initEggLayer, intent, $this_initEggLayer.getSplash$adsplash_debug().getAppLink(), $this_initEggLayer.getSplash$adsplash_debug().getJumpUrl(), true, SplashActionType.EGG, true, null, null, 192, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initEggLayer$lambda$1(BaseSplash $this_initEggLayer, SplashAlphaPlayer $eggPlayer) {
        SplashAdHelper.INSTANCE.reportSplashEggClose$adsplash_debug($this_initEggLayer.getSplash$adsplash_debug(), $eggPlayer.getCurrentPlayTime());
        ISplashEvent.CC.exitSplash$default($this_initEggLayer, false, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initEggLayer$lambda$2(BaseSplash $this_initEggLayer) {
        if (!$this_initEggLayer.getComponentHolder$adsplash_debug().isEggPlayFinished()) {
            handleEggPlayFinishEvent($this_initEggLayer);
        }
        return Unit.INSTANCE;
    }

    public static final boolean triggerTransportEgg(BaseSplash $this$triggerTransportEgg) {
        Intrinsics.checkNotNullParameter($this$triggerTransportEgg, "<this>");
        if (ExtSplashOrderKt.isEggSplash($this$triggerTransportEgg.getSplash$adsplash_debug()) && !$this$triggerTransportEgg.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed()) {
            $this$triggerTransportEgg.getSplash$adsplash_debug().getRuntimeExtra().setEggVideoPlayed(true);
            SplashAlphaPlayer player = $this$triggerTransportEgg.getComponentHolder$adsplash_debug().getEggPlayer();
            if (player == null) {
                SplashAdHelper.INSTANCE.reportSplashEggShowFail$adsplash_debug($this$triggerTransportEgg.getSplash$adsplash_debug(), 1);
                return false;
            } else if (!player.hasPrepared()) {
                SplashAdHelper.INSTANCE.reportSplashEggShowFail$adsplash_debug($this$triggerTransportEgg.getSplash$adsplash_debug(), 2);
                return false;
            } else if (LinkageAnimationComponentKt.getLinkageTargetRect($this$triggerTransportEgg) == null) {
                SplashAdHelper.INSTANCE.reportSplashEggShowFail$adsplash_debug($this$triggerTransportEgg.getSplash$adsplash_debug(), 3);
                return false;
            } else {
                $this$triggerTransportEgg.getViewModel$adsplash_debug().update(new PreDisplayStatusBarAction());
                $this$triggerTransportEgg.getViewModel$adsplash_debug().update(new PlayerEvent.OnStop("egg"));
                SplashAdHelper.INSTANCE.reportSplashEggShow$adsplash_debug($this$triggerTransportEgg.getSplash$adsplash_debug());
                player.play();
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$triggerTransportEgg), (CoroutineContext) null, (CoroutineStart) null, new AlphaEggLayerComponentKt$triggerTransportEgg$1($this$triggerTransportEgg, null), 3, (Object) null);
                $this$triggerTransportEgg.getComponentHolder$adsplash_debug().setSplashStartTimeMs(SystemClock.elapsedRealtime());
                View it = $this$triggerTransportEgg.getComponentHolder$adsplash_debug().getEggCountdownView();
                if (it != null) {
                    player.addView(it);
                }
                Iterable $this$forEach$iv = LinkageAnimationComponentKt.getLinkageAnimationAlphaView($this$triggerTransportEgg);
                for (Object element$iv : $this$forEach$iv) {
                    View it2 = (View) element$iv;
                    if (it2 != null) {
                        it2.setVisibility(8);
                    }
                }
                $this$triggerTransportEgg.getBinding$adsplash_debug().splashView.setVisibility(4);
                $this$triggerTransportEgg.getBinding$adsplash_debug().rootContainer.setBackgroundColor(HALF_BLACK);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleEggPlayFinishEvent(final BaseSplash $this$handleEggPlayFinishEvent) {
        $this$handleEggPlayFinishEvent.getComponentHolder$adsplash_debug().setEggPlayFinished(true);
        SplashAdHelper.INSTANCE.reportSplashEggPlayDone$adsplash_debug($this$handleEggPlayFinishEvent.getSplash$adsplash_debug());
        $this$handleEggPlayFinishEvent.getBinding$adsplash_debug().splashView.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.AlphaEggLayerComponentKt$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AlphaEggLayerComponentKt.handleEggPlayFinishEvent$lambda$0(BaseSplash.this);
            }
        });
        $this$handleEggPlayFinishEvent.onCountdownEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleEggPlayFinishEvent$lambda$0(BaseSplash $this_handleEggPlayFinishEvent) {
        SplashAlphaPlayer eggPlayer = $this_handleEggPlayFinishEvent.getComponentHolder$adsplash_debug().getEggPlayer();
        if (eggPlayer != null) {
            eggPlayer.setVisibility(8);
        }
    }
}