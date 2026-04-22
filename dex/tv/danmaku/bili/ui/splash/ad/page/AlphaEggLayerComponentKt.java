package tv.danmaku.bili.ui.splash.ad.page;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.homepage.splash.actions.PreDisplayStatusBarAction;
import com.bilibili.lib.homepage.splash.actions.RealBannerRectUpdateAction;
import com.bilibili.lib.homepage.splash.actions.TopViewAnimationEndAction;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.button.widget.SplashCircleCountdownButtonKt;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashEgg;
import tv.danmaku.bili.ui.splash.ad.model.SplashEggKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashTopViewType;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashLayoutHelperKt;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.widget.SplashContainerView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AlphaEggLayerComponent.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\b\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0004H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0003*\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"HALF_BLACK", "", "observerSplashLinkageAnimationState", "", "Ltv/danmaku/bili/ui/splash/ad/page/FullImageSplash;", "tryDoExitSplashLinkageAnimation", "Ltv/danmaku/bili/ui/splash/ad/page/BaseSplash;", "addEggLayer", "handleEggPlayFinishEvent", "interceptExitEvent", "", "doLinkageTransform", "rect", "Landroid/graphics/Rect;", "doLaunchDanmakuExitAnimate", "TAG", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AlphaEggLayerComponentKt {
    private static final int HALF_BLACK = 2130706432;
    private static final String TAG = "[Splash]FullImageSplash";

    public static final void observerSplashLinkageAnimationState(FullImageSplash $this$observerSplashLinkageAnimationState) {
        Intrinsics.checkNotNullParameter($this$observerSplashLinkageAnimationState, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerSplashLinkageAnimationState), (CoroutineContext) null, (CoroutineStart) null, new AlphaEggLayerComponentKt$observerSplashLinkageAnimationState$1($this$observerSplashLinkageAnimationState, null), 3, (Object) null);
    }

    public static final void tryDoExitSplashLinkageAnimation(BaseSplash $this$tryDoExitSplashLinkageAnimation) {
        SplashViewModel.SplashExitInfo exitInfo;
        MutableLiveData splashExit;
        MutableLiveData splashExit2;
        Intrinsics.checkNotNullParameter($this$tryDoExitSplashLinkageAnimation, "<this>");
        Rect rect = $this$tryDoExitSplashLinkageAnimation.getLinkageTargetRect();
        BLog.i(TAG, "tryDoExitSplashLinkageAnimation， rect = " + rect);
        if (rect != null) {
            $this$tryDoExitSplashLinkageAnimation.setQueryItem($this$tryDoExitSplashLinkageAnimation.mSplash, false);
            SplashViewModel splashViewModel = $this$tryDoExitSplashLinkageAnimation.mSplashViewModel;
            if (splashViewModel == null || (splashExit2 = splashViewModel.getSplashExit()) == null || (exitInfo = (SplashViewModel.SplashExitInfo) splashExit2.getValue()) == null) {
                exitInfo = new SplashViewModel.SplashExitInfo();
            }
            exitInfo.setAnimState(1);
            SplashViewModel splashViewModel2 = $this$tryDoExitSplashLinkageAnimation.mSplashViewModel;
            if (splashViewModel2 != null && (splashExit = splashViewModel2.getSplashExit()) != null) {
                splashExit.setValue(exitInfo);
            }
            SplashViewModel splashViewModel3 = $this$tryDoExitSplashLinkageAnimation.mSplashViewModel;
            if (splashViewModel3 != null) {
                splashViewModel3.update(new RealBannerRectUpdateAction((Rect) null));
            }
            $this$tryDoExitSplashLinkageAnimation.mExecuteAnim = true;
            if (!$this$tryDoExitSplashLinkageAnimation.mSplash.isEggVideoPlayed) {
                $this$tryDoExitSplashLinkageAnimation.mRootContainer.setBackground(new ColorDrawable(0));
            }
            SplashViewModel splashViewModel4 = $this$tryDoExitSplashLinkageAnimation.mSplashViewModel;
            if (splashViewModel4 != null) {
                splashViewModel4.update(new PlayerEvent.OnStop("countdown"));
            }
            $this$tryDoExitSplashLinkageAnimation.doTransformAnimation(rect);
            return;
        }
        $this$tryDoExitSplashLinkageAnimation.exitSplash(false);
    }

    public static final void addEggLayer(final FullImageSplash $this$addEggLayer) {
        Intrinsics.checkNotNullParameter($this$addEggLayer, "<this>");
        Context context = $this$addEggLayer.getContext();
        if (context == null) {
            return;
        }
        View view2 = $this$addEggLayer.getView();
        ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if (viewGroup == null) {
            return;
        }
        ViewGroup rootView = viewGroup;
        if (!SplashEggKt.isEggSplash($this$addEggLayer.mSplash)) {
            return;
        }
        SplashEgg splashEgg = $this$addEggLayer.mSplash.splashEgg;
        File file = BusinessSplashResHelper.fetchResourceFileByHash(splashEgg != null ? splashEgg.getVideoHash() : null);
        if (file == null) {
            BLog.i(TAG, "splash egg resource not ready");
            return;
        }
        SplashAlphaPlayer $this$addEggLayer_u24lambda_u240 = new SplashAlphaPlayer(context, (AttributeSet) null, 0, BusinessSplashDefine.FILE_URI_PREFIX + file.getAbsolutePath(), (Function0) null, (Function0) null, (Function0) null, (Function0) null, 246, (DefaultConstructorMarker) null);
        $this$addEggLayer_u24lambda_u240.setLayoutParams(SplashLayoutHelperKt.createMatchParentLayoutParams(rootView));
        $this$addEggLayer_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AlphaEggLayerComponentKt.addEggLayer$lambda$0$0(FullImageSplash.this, view3);
            }
        });
        $this$addEggLayer.eggPlayer = $this$addEggLayer_u24lambda_u240;
        rootView.addView((View) $this$addEggLayer.eggPlayer, 0);
        SplashEgg splashEgg2 = $this$addEggLayer.mSplash.splashEgg;
        $this$addEggLayer.eggCountdownView = SplashCircleCountdownButtonKt.createCircleCountdownButton(context, splashEgg2 != null ? (int) splashEgg2.getDuration() : 0, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit addEggLayer$lambda$1;
                addEggLayer$lambda$1 = AlphaEggLayerComponentKt.addEggLayer$lambda$1(FullImageSplash.this);
                return addEggLayer$lambda$1;
            }
        }, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit addEggLayer$lambda$2;
                addEggLayer$lambda$2 = AlphaEggLayerComponentKt.addEggLayer$lambda$2(FullImageSplash.this);
                return addEggLayer$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEggLayer$lambda$0$0(FullImageSplash $this_addEggLayer, View it) {
        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
        Splash splash = $this_addEggLayer.mSplash;
        SplashAlphaPlayer splashAlphaPlayer = $this_addEggLayer.eggPlayer;
        splashAdHelper.reportSplashEggClick$splash_debug(splash, splashAlphaPlayer != null ? splashAlphaPlayer.getCurrentPlayTime() : 0L, SplashConfigKt.getSplashEnableEggClickable());
        if (SplashConfigKt.getSplashEnableEggClickable()) {
            Intent intent = $this_addEggLayer.buildThirdIntent($this_addEggLayer.mSplash.appLink, $this_addEggLayer.mSplash.appPkg);
            $this_addEggLayer.onJumpClickWithFrom(intent, $this_addEggLayer.mSplash.appLink, SplashActionType.EGG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEggLayer$lambda$1(FullImageSplash $this_addEggLayer) {
        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
        Splash splash = $this_addEggLayer.mSplash;
        SplashAlphaPlayer splashAlphaPlayer = $this_addEggLayer.eggPlayer;
        splashAdHelper.reportSplashEggClose$splash_debug(splash, splashAlphaPlayer != null ? splashAlphaPlayer.getCurrentPlayTime() : 0L);
        $this_addEggLayer.exitSplash(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEggLayer$lambda$2(FullImageSplash $this_addEggLayer) {
        if (!$this_addEggLayer.isEggPlayFinished) {
            handleEggPlayFinishEvent($this_addEggLayer);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleEggPlayFinishEvent(final FullImageSplash $this$handleEggPlayFinishEvent) {
        $this$handleEggPlayFinishEvent.isEggPlayFinished = true;
        SplashAdHelper.INSTANCE.reportSplashEggPlayDone$splash_debug($this$handleEggPlayFinishEvent.mSplash);
        Message message = Message.obtain();
        message.what = 2;
        message.obj = null;
        $this$handleEggPlayFinishEvent.mSplashView.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AlphaEggLayerComponentKt.handleEggPlayFinishEvent$lambda$0(FullImageSplash.this);
            }
        });
        $this$handleEggPlayFinishEvent.handleMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleEggPlayFinishEvent$lambda$0(FullImageSplash $this_handleEggPlayFinishEvent) {
        SplashAlphaPlayer splashAlphaPlayer = $this_handleEggPlayFinishEvent.eggPlayer;
        if (splashAlphaPlayer != null) {
            splashAlphaPlayer.setVisibility(8);
        }
    }

    public static final boolean interceptExitEvent(FullImageSplash $this$interceptExitEvent) {
        Intrinsics.checkNotNullParameter($this$interceptExitEvent, "<this>");
        if ($this$interceptExitEvent.getContext() != null && SplashEggKt.isEggSplash($this$interceptExitEvent.mSplash)) {
            SplashAlphaPlayer player = $this$interceptExitEvent.eggPlayer;
            if (player == null) {
                SplashAdHelper.INSTANCE.reportSplashEggShowFail($this$interceptExitEvent.mSplash, 1);
                return false;
            } else if (!player.hasPrepared()) {
                SplashAdHelper.INSTANCE.reportSplashEggShowFail($this$interceptExitEvent.mSplash, 2);
                return false;
            } else if ($this$interceptExitEvent.getLinkageTargetRect() == null) {
                SplashAdHelper.INSTANCE.reportSplashEggShowFail($this$interceptExitEvent.mSplash, 3);
                return false;
            } else if ($this$interceptExitEvent.mSplash.isEggVideoPlayed) {
                return false;
            } else {
                $this$interceptExitEvent.mSplash.isEggVideoPlayed = true;
                SplashViewModel splashViewModel = $this$interceptExitEvent.mSplashViewModel;
                if (splashViewModel != null) {
                    splashViewModel.update(new PreDisplayStatusBarAction());
                }
                SplashViewModel splashViewModel2 = $this$interceptExitEvent.mSplashViewModel;
                if (splashViewModel2 != null) {
                    splashViewModel2.update(new PlayerEvent.OnStop("egg"));
                }
                SplashAdHelper.INSTANCE.reportSplashEggShow$splash_debug($this$interceptExitEvent.mSplash);
                player.play();
                LifecycleOwner viewLifecycleOwner = $this$interceptExitEvent.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new AlphaEggLayerComponentKt$interceptExitEvent$1($this$interceptExitEvent, null), 3, (Object) null);
                $this$interceptExitEvent.mStartTimeMIll = SystemClock.elapsedRealtime();
                View it = $this$interceptExitEvent.eggCountdownView;
                if (it != null) {
                    player.addView(it);
                }
                List alphaViews = $this$interceptExitEvent.getAlphaView();
                for (View v : alphaViews) {
                    v.setVisibility(8);
                }
                $this$interceptExitEvent.mSplashView.setVisibility(4);
                $this$interceptExitEvent.mRootContainer.setBackgroundColor(HALF_BLACK);
                return true;
            }
        }
        return false;
    }

    public static final void doLinkageTransform(final FullImageSplash $this$doLinkageTransform, final Rect rect) {
        Intrinsics.checkNotNullParameter($this$doLinkageTransform, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        $this$doLinkageTransform.doBeforeAnimation();
        final Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$doLinkageTransform$animatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.i("[Splash]FullImageSplash", "[Splash]mLinkageAnimatorListener, onAnimationStart");
                FullImageSplash.this.mIsShowAnimator = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.i("[Splash]FullImageSplash", "[Splash]mLinkageAnimatorListener, onAnimationEnd");
                FullImageSplash.this.mIsShowAnimator = false;
                SplashViewModel splashViewModel = FullImageSplash.this.mSplashViewModel;
                if (splashViewModel != null) {
                    splashViewModel.update(new TopViewAnimationEndAction());
                }
                FullImageSplash.this.exitSplash(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        final Function0 transformAction = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit doLinkageTransform$lambda$0;
                doLinkageTransform$lambda$0 = AlphaEggLayerComponentKt.doLinkageTransform$lambda$0(FullImageSplash.this, rect, animatorListener);
                return doLinkageTransform$lambda$0;
            }
        };
        if ($this$doLinkageTransform.getTransformView().getWidth() > 0 && $this$doLinkageTransform.getTransformView().getHeight() > 0) {
            transformAction.invoke();
            return;
        }
        BLog.e(TAG, "[Splash]doLinkageTransform, transformView not ready, next post");
        $this$doLinkageTransform.getTransformView().post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                transformAction.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLinkageTransform$lambda$0(final FullImageSplash $this_doLinkageTransform, final Rect $rect, final Animator.AnimatorListener $animatorListener) {
        try {
            BLog.i(TAG, "[Splash]doLinkageTransform, transformAction invoke, type = " + $this_doLinkageTransform.mSplash.topViewType);
            if ($this_doLinkageTransform.mSplash.topViewType == SplashTopViewType.LAUNCH_DANMAKU.getType()) {
                doLaunchDanmakuExitAnimate($this_doLinkageTransform);
            } else if ($this_doLinkageTransform.mSplash.isSearchLinkage()) {
                ImageView transformView = $this_doLinkageTransform.getTransformView();
                Intrinsics.checkNotNullExpressionValue(transformView, "getTransformView(...)");
                BusinessSplashAnimatorHelperKt.doBusinessSplashSearchBarLinkageAnimation(transformView, $rect, $this_doLinkageTransform.getAlphaView(), $animatorListener);
            } else if ($this_doLinkageTransform.mSplash.isEggVideoPlayed) {
                SplashContainerView splashContainerView = $this_doLinkageTransform.mRootContainer;
                Intrinsics.checkNotNullExpressionValue(splashContainerView, "mRootContainer");
                ImageView transformView2 = $this_doLinkageTransform.getTransformView();
                Intrinsics.checkNotNullExpressionValue(transformView2, "getTransformView(...)");
                BusinessSplashAnimatorHelperKt.doKeepRadioScaleAnimate((View) splashContainerView, transformView2, $rect, $animatorListener);
            } else if ($this_doLinkageTransform.mSplash.topViewType == SplashTopViewType.TV_CLOSE.getType()) {
                $this_doLinkageTransform.asyncGetTransformView(new TakeSnapshotCallback() { // from class: tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$$ExternalSyntheticLambda4
                    @Override // tv.danmaku.bili.ui.splash.ad.page.TakeSnapshotCallback
                    public final void onTake(View view2) {
                        AlphaEggLayerComponentKt.doLinkageTransform$lambda$0$0($rect, $this_doLinkageTransform, $animatorListener, view2);
                    }
                });
            } else if ($this_doLinkageTransform.mSplash.topViewType == SplashTopViewType.BG_DISAPPEAR.getType()) {
                ImageView transformView3 = $this_doLinkageTransform.getTransformView();
                Intrinsics.checkNotNullExpressionValue(transformView3, "getTransformView(...)");
                BusinessSplashAnimatorHelperKt.doBgDisappearAnimation(transformView3, $this_doLinkageTransform.getAlphaView(), $animatorListener);
            } else if ($this_doLinkageTransform.mSplash.topViewType == SplashTopViewType.NONE.getType()) {
                $this_doLinkageTransform.exitSplash(false);
            } else {
                ImageView transformView4 = $this_doLinkageTransform.getTransformView();
                Intrinsics.checkNotNullExpressionValue(transformView4, "getTransformView(...)");
                BusinessSplashAnimatorHelperKt.doTopViewScaleAnimation(transformView4, $rect, $this_doLinkageTransform.getAlphaView(), $animatorListener);
            }
        } catch (Exception e) {
            $this_doLinkageTransform.exitSplash(false);
            CrashReporter.INSTANCE.postCaughtException(e);
            BLog.e("Splash", "do topview anim error");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doLinkageTransform$lambda$0$0(Rect $rect, FullImageSplash $this_doLinkageTransform, Animator.AnimatorListener $animatorListener, View view2) {
        if (view2 != null) {
            BusinessSplashAnimatorHelperKt.doTvCloseSplashAnimate(view2, $rect, $this_doLinkageTransform.getAlphaView(), $animatorListener);
        } else {
            $this_doLinkageTransform.exitSplash(false);
        }
    }

    private static final void doLaunchDanmakuExitAnimate(BaseSplash $this$doLaunchDanmakuExitAnimate) {
        SplashViewModel viewModel = $this$doLaunchDanmakuExitAnimate.mSplashViewModel;
        if (viewModel == null) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$doLaunchDanmakuExitAnimate), (CoroutineContext) null, (CoroutineStart) null, new AlphaEggLayerComponentKt$doLaunchDanmakuExitAnimate$1(viewModel, $this$doLaunchDanmakuExitAnimate, null), 3, (Object) null);
    }
}