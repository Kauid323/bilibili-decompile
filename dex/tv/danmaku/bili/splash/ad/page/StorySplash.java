package tv.danmaku.bili.splash.ad.page;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerType;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerTypeKt;
import tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper;
import tv.danmaku.bili.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt;
import tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.splash.ad.page.component.StatisticComponentKt;
import tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt;
import tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt;
import tv.danmaku.bili.splash.ad.player.SplashCardPlayer;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutHelperKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;
import tv.danmaku.bili.splash.ad.widget.SplashImageView;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: StorySplash.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0017JR\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010 \u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/StorySplash;", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "<init>", "()V", "splashCardPlayer", "Ltv/danmaku/bili/splash/ad/player/SplashCardPlayer;", "playerContainerView", "Landroid/widget/FrameLayout;", "backgroundView", "Ltv/danmaku/bili/splash/ad/widget/SplashImageView;", "showMainMaterial", "", "onJumpClick", "intent", "Landroid/content/Intent;", "schema", "", "jumpUrl", "withFrom", "", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "reportClick", "buttonId", "clickData", "Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "onPageJump", "isSecondPage", "secondPageJumpReason", "liveReserveTriggerType", "Ltv/danmaku/bili/splash/ad/business/livereserve/LiveReserveTriggerType;", "jumpWithAnimation", "onDetach", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StorySplash extends BaseSplash {
    public static final int $stable = 8;
    private SplashImageView backgroundView;
    private FrameLayout playerContainerView;
    private SplashCardPlayer splashCardPlayer;

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void showMainMaterial() {
        Context ctx;
        ViewGroup.LayoutParams videoLp;
        SplashContainerView root = getBinding$adsplash_debug().getRoot();
        ViewGroup rootView = root instanceof ViewGroup ? (ViewGroup) root : null;
        if (rootView == null || (ctx = getContext()) == null) {
            return;
        }
        final FrameLayout containerView = new FrameLayout(ctx);
        this.playerContainerView = containerView;
        if (ListDeviceInfoKt.isHdApp()) {
            videoLp = SplashLayoutHelperKt.createMatchParentHeightLayoutParams(rootView, (int) (((getResources().getDisplayMetrics().heightPixels * getSplash$adsplash_debug().getVideoWidth()) * 1.0f) / getSplash$adsplash_debug().getVideoHeight()));
        } else {
            videoLp = SplashLayoutUtilsKt.createMatchParentLayoutParams(rootView);
        }
        rootView.addView(containerView, 0, videoLp);
        setFullScreenClickListener(containerView);
        final FrameLayout $this$doOnPreDraw$iv = containerView;
        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.StorySplash$showMainMaterial$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                View view = $this$doOnPreDraw$iv;
                StorySplash storySplash = this;
                Fragment fragment = this;
                FrameLayout frameLayout = containerView;
                SplashOrder splash$adsplash_debug = this.getSplash$adsplash_debug();
                final StorySplash storySplash2 = this;
                final StorySplash storySplash3 = this;
                SplashCardPlayer $this$showMainMaterial_u24lambda_u240_u240 = new SplashCardPlayer(fragment, frameLayout, splash$adsplash_debug, new Function1<SplashCardPlayer, Unit>() { // from class: tv.danmaku.bili.splash.ad.page.StorySplash$showMainMaterial$1$1
                    public final void invoke(SplashCardPlayer player) {
                        Intrinsics.checkNotNullParameter(player, "player");
                        PlayerReporterInitComponentKt.initPlayerReporter(StorySplash.this, player);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((SplashCardPlayer) p1);
                        return Unit.INSTANCE;
                    }
                }, new Function1<SplashCardPlayer, Unit>() { // from class: tv.danmaku.bili.splash.ad.page.StorySplash$showMainMaterial$1$2
                    public final void invoke(SplashCardPlayer player) {
                        Intrinsics.checkNotNullParameter(player, "player");
                        BiliCardPlayerScene.CardPlayTask task = player.getTask();
                        Intrinsics.checkNotNull(task);
                        PlayerCallbackRegisterComponentKt.registerCardPlayerStateCallback(StorySplash.this, task, StorySplash.this.getViewModel$adsplash_debug());
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((SplashCardPlayer) p1);
                        return Unit.INSTANCE;
                    }
                });
                $this$showMainMaterial_u24lambda_u240_u240.play();
                storySplash.splashCardPlayer = $this$showMainMaterial_u24lambda_u240_u240;
            }
        });
        if (ListDeviceInfoKt.isHdApp()) {
            SplashImageView $this$showMainMaterial_u24lambda_u241 = new SplashImageView(ctx);
            SplashContainerView root2 = getBinding$adsplash_debug().getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            ViewGroup.LayoutParams $this$showMainMaterial_u24lambda_u241_u240 = SplashLayoutUtilsKt.createMatchParentLayoutParams((ViewGroup) root2);
            $this$showMainMaterial_u24lambda_u241_u240.width = 0;
            $this$showMainMaterial_u24lambda_u241_u240.height = 0;
            $this$showMainMaterial_u24lambda_u241.setLayoutParams($this$showMainMaterial_u24lambda_u241_u240);
            $this$showMainMaterial_u24lambda_u241.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.backgroundView = $this$showMainMaterial_u24lambda_u241;
            getBinding$adsplash_debug().getRoot().addView((View) this.backgroundView, 0);
            ViewInitComponentKt.displayMainImage(this, this.backgroundView);
        }
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onJumpClick(Intent intent, String schema, String jumpUrl, boolean withFrom, SplashActionType actionType, boolean reportClick, String buttonId, ButtonClickData clickData) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        BLog.i("[Splash]StorySplash", "onJumpClick intent:" + intent + " jumpUrl:" + jumpUrl + " withFrom:" + withFrom + ", SplashActionType:" + actionType + " buttonId:" + buttonId);
        SplashLiveReserveHelper.handleLiveBooking$default(SplashLiveReserveHelper.INSTANCE, getContext(), getSplash$adsplash_debug(), LiveReserveTriggerTypeKt.getToLiveReserveTriggerType(actionType).getValue(), false, null, 24, null);
        SplashCustomReporterKt.reportSplashClick(getSplash$adsplash_debug(), jumpUrl, buttonId, actionType.name(), intent != null ? intent.getDataString() : "", StatisticComponentKt.calculateSplashRealDuration(this));
        SplashAdHelper.adReportSplashClicked$adsplash_debug$default(SplashAdHelper.INSTANCE, getSplash$adsplash_debug(), withFrom, actionType, buttonId, StatisticComponentKt.calculateSplashRealDuration(this), null, 32, null);
        jumpWithAnimation(jumpUrl);
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onPageJump(boolean isSecondPage, String secondPageJumpReason, LiveReserveTriggerType liveReserveTriggerType) {
        String jumpUrl = getSplash$adsplash_debug().getInteractUrl();
        if (jumpUrl == null) {
            jumpUrl = getSplash$adsplash_debug().getJumpUrl();
        }
        jumpWithAnimation(jumpUrl);
    }

    private final void jumpWithAnimation(final String jumpUrl) {
        if (jumpUrl == null) {
            return;
        }
        stopCountdown();
        SecondPageComponentKt.firstPageElementDisappear(LinkageAnimationComponentKt.getLinkageAnimationAlphaView(this), new Function0() { // from class: tv.danmaku.bili.splash.ad.page.StorySplash$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit jumpWithAnimation$lambda$0;
                jumpWithAnimation$lambda$0 = StorySplash.jumpWithAnimation$lambda$0(StorySplash.this, jumpUrl);
                return jumpWithAnimation$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpWithAnimation$lambda$0(final StorySplash this$0, String $jumpUrl) {
        SplashCardPlayer splashCardPlayer = this$0.splashCardPlayer;
        if (splashCardPlayer != null) {
            splashCardPlayer.sharePlayer($jumpUrl, new Function0() { // from class: tv.danmaku.bili.splash.ad.page.StorySplash$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit jumpWithAnimation$lambda$0$0;
                    jumpWithAnimation$lambda$0$0 = StorySplash.jumpWithAnimation$lambda$0$0(StorySplash.this);
                    return jumpWithAnimation$lambda$0$0;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpWithAnimation$lambda$0$0(StorySplash this$0) {
        ISplashEvent.CC.exitSplash$default(this$0, true, null, null, 6, null);
        return Unit.INSTANCE;
    }

    public void onDetach() {
        super.onDetach();
        SplashCardPlayer splashCardPlayer = this.splashCardPlayer;
        if (splashCardPlayer != null) {
            splashCardPlayer.stop();
        }
    }
}