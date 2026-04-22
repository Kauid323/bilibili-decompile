package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.ui.splash.OnClickTouchListener;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.ui.splash.ad.button.model.LiveReserveTriggerType;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.player.SplashCardPlayer;
import tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.SplashLiveReserveHelper;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: StorySplash.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0017J\b\u0010\u000b\u001a\u00020\tH\u0016JT\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J$\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/page/StorySplash;", "Ltv/danmaku/bili/ui/splash/ad/page/FullImageSplash;", "<init>", "()V", "splashCardPlayer", "Ltv/danmaku/bili/ui/splash/ad/player/SplashCardPlayer;", "playerContainerView", "Landroid/widget/FrameLayout;", "showContent", "", "showJumpView", "onDetach", "onJumpClick", "intent", "Landroid/content/Intent;", PerformanceConstants.EXTRA_KEY_SCHEMA, "", "jumpUrl", "withFrom", "", "type", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashActionType;", "reportClick", "buttonId", "clickData", "Ltv/danmaku/bili/ui/splash/ad/button/model/ButtonClickData;", "handlePageJump", "isSecondPage", "secondPageJumpReason", "Ltv/danmaku/bili/ui/splash/ad/button/model/LiveReserveTriggerType;", "jumpWithAnimation", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StorySplash extends FullImageSplash {
    public static final int $stable = 8;
    private FrameLayout playerContainerView;
    private SplashCardPlayer splashCardPlayer;

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showContent() {
        Context ctx;
        final Splash splash;
        View rootView = getView();
        if (!(rootView instanceof ViewGroup) || (ctx = getContext()) == null || (splash = this.mSplash) == null) {
            return;
        }
        final FrameLayout containerView = new FrameLayout(ctx);
        this.playerContainerView = containerView;
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        ((ConstraintLayout.LayoutParams) layoutParams).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
        ((ViewGroup) rootView).addView(containerView, 0, layoutParams);
        final FrameLayout $this$doOnPreDraw$iv = containerView;
        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.StorySplash$showContent$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                View view2 = $this$doOnPreDraw$iv;
                StorySplash storySplash = this;
                Splash splash2 = splash;
                final StorySplash storySplash2 = this;
                final StorySplash storySplash3 = this;
                SplashCardPlayer $this$showContent_u24lambda_u241_u240 = new SplashCardPlayer(this, containerView, splash2, new Function1<SplashCardPlayer, Unit>() { // from class: tv.danmaku.bili.ui.splash.ad.page.StorySplash$showContent$1$1
                    public final void invoke(SplashCardPlayer player) {
                        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
                        PlayerReporterInitComponentKt.initPlayerReporter(StorySplash.this, player);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((SplashCardPlayer) p1);
                        return Unit.INSTANCE;
                    }
                }, new Function1<SplashCardPlayer, Unit>() { // from class: tv.danmaku.bili.ui.splash.ad.page.StorySplash$showContent$1$2
                    public final void invoke(SplashCardPlayer player) {
                        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
                        BiliCardPlayerScene.CardPlayTask task = player.getTask();
                        Intrinsics.checkNotNull(task);
                        SplashViewModel splashViewModel = StorySplash.this.mSplashViewModel;
                        Intrinsics.checkNotNull(splashViewModel);
                        PlayerCallbackRegisterComponentKt.registerCardPlayerStateCallback(StorySplash.this, task, splashViewModel);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((SplashCardPlayer) p1);
                        return Unit.INSTANCE;
                    }
                });
                $this$showContent_u24lambda_u241_u240.play();
                storySplash.splashCardPlayer = $this$showContent_u24lambda_u241_u240;
            }
        });
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showJumpView() {
        FrameLayout frameLayout;
        super.showJumpView();
        Context ctx = getContext();
        if (ctx != null && (frameLayout = this.playerContainerView) != null) {
            frameLayout.setOnTouchListener(new OnClickTouchListener(ctx, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.StorySplash$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit showJumpView$lambda$0;
                    showJumpView$lambda$0 = StorySplash.showJumpView$lambda$0(StorySplash.this);
                    return showJumpView$lambda$0;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showJumpView$lambda$0(StorySplash this$0) {
        Splash splash = this$0.mSplash;
        Intrinsics.checkNotNullExpressionValue(splash, "mSplash");
        SplashAdHelper.adSplashOutsideClick(splash);
        if (this$0.mSplash.isSplashClickable()) {
            this$0.onJumpClick(this$0.buildThirdIntent(this$0.mSplash.appLink, this$0.mSplash.appPkg), this$0.mSplash.appLink);
        }
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onDetach() {
        super.onDetach();
        SplashCardPlayer splashCardPlayer = this.splashCardPlayer;
        if (splashCardPlayer != null) {
            splashCardPlayer.stop();
        }
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    protected void onJumpClick(Intent intent, String schema, String jumpUrl, boolean withFrom, SplashActionType type, boolean reportClick, String buttonId, ButtonClickData clickData) {
        BLog.i("[Splash]StorySplash", "onJumpClick intent:" + intent + " jumpUrl:" + jumpUrl + " withFrom:" + withFrom + ", SplashActionType:" + type + " buttonId:" + buttonId);
        SplashActionType actionType = type == null ? SplashActionType.UNDEFINE : type;
        SplashCustomReporterKt.reportSplashClick(this.mSplash, jumpUrl, buttonId, actionType.name(), intent != null ? intent.getDataString() : "", calculateSplashRealDuration());
        SplashAdHelper.adReportSplashClicked$default(this.mSplash, withFrom, actionType, buttonId, calculateSplashRealDuration(), null, 32, null);
        jumpWithAnimation(jumpUrl, actionType.toLiveReserveTriggerTypeValue());
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void handlePageJump(boolean isSecondPage, String secondPageJumpReason, LiveReserveTriggerType type) {
        String jumpUrl;
        Splash splash = this.mSplash;
        if (splash == null || (jumpUrl = splash.interactUrl) == null) {
            Splash splash2 = this.mSplash;
            jumpUrl = splash2 != null ? splash2.jumpUrl : null;
        }
        jumpWithAnimation(jumpUrl, type);
    }

    private final void jumpWithAnimation(final String jumpUrl, LiveReserveTriggerType type) {
        if (jumpUrl == null) {
            return;
        }
        if (type != null) {
            Context context = getContext();
            Splash splash = this.mSplash;
            Intrinsics.checkNotNullExpressionValue(splash, "mSplash");
            SplashLiveReserveHelper.handleLiveBooking$default(context, splash, type.getValue(), false, null, 24, null);
        }
        stopCountDown();
        List<View> alphaView = getAlphaView();
        Intrinsics.checkNotNullExpressionValue(alphaView, "getAlphaView(...)");
        SecondPageViewHelperKt.firstPageElementDisappear(alphaView, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.StorySplash$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit jumpWithAnimation$lambda$1;
                jumpWithAnimation$lambda$1 = StorySplash.jumpWithAnimation$lambda$1(StorySplash.this, jumpUrl);
                return jumpWithAnimation$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpWithAnimation$lambda$1(final StorySplash this$0, String $jumpUrl) {
        SplashCardPlayer splashCardPlayer = this$0.splashCardPlayer;
        if (splashCardPlayer != null) {
            splashCardPlayer.sharePlayer($jumpUrl, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.StorySplash$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit jumpWithAnimation$lambda$1$0;
                    jumpWithAnimation$lambda$1$0 = StorySplash.jumpWithAnimation$lambda$1$0(StorySplash.this);
                    return jumpWithAnimation$lambda$1$0;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpWithAnimation$lambda$1$0(StorySplash this$0) {
        this$0.exitSplash(true);
        return Unit.INSTANCE;
    }
}