package tv.danmaku.bili.splash.ad.page;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.VideoShareDataUpdateAction;
import com.bilibili.lib.homepage.splash.model.PlayerShareData;
import com.bilibili.lib.homepage.splash.model.SplashState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashTopViewType;
import tv.danmaku.bili.splash.ad.model.SplashVideoInfo;
import tv.danmaku.bili.splash.ad.page.component.CountdownComponentKt;
import tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.splash.ad.player.SplashBannerPlayer;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.state.actions.DoSplashLinkageAnimationAction;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.utils.image.SplashImageUtilKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.splash.ad.utils.ui.ViewLayerUtilKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;
import tv.danmaku.bili.splash.ad.widget.SplashImageView;
import tv.danmaku.bili.widget.RoundRectFrameLayout;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: BannerSplash.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J-\u0010\u001a\u001a\u00020\u000f2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000f0\u001cH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\u0016\u0010\"\u001a\u00020\r*\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/BannerSplash;", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "<init>", "()V", "bannerPlayer", "Ltv/danmaku/bili/splash/ad/player/SplashBannerPlayer;", "getBannerPlayer", "()Ltv/danmaku/bili/splash/ad/player/SplashBannerPlayer;", "setBannerPlayer", "(Ltv/danmaku/bili/splash/ad/player/SplashBannerPlayer;)V", "videoRadius", "", "hasPrepareForShare", "", "showMainMaterial", "", "onSplashReady", "realReady", "onCountdownEnd", "prepareShare", "showVideoLayer", "checkTopViewDown", "", "()Ljava/lang/Integer;", "doCutout", "doShare", "asyncGetLinkageTransformView", AuthResultCbHelper.ARGS_CALLBACK, "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "transformView", "onSkipClick", "isSame", "Landroid/graphics/Rect;", "other", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BannerSplash extends BaseSplash {
    public static final int $stable = 8;
    private SplashBannerPlayer bannerPlayer;
    private boolean hasPrepareForShare;
    private final float videoRadius = ListExtentionsKt.toPx(4);

    public final SplashBannerPlayer getBannerPlayer() {
        return this.bannerPlayer;
    }

    public final void setBannerPlayer(SplashBannerPlayer splashBannerPlayer) {
        this.bannerPlayer = splashBannerPlayer;
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void showMainMaterial() {
        showVideoLayer();
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onSplashReady(boolean realReady) {
        super.showMainMaterial();
        super.onSplashReady(realReady);
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onCountdownEnd() {
        prepareShare();
        super.onCountdownEnd();
    }

    private final void prepareShare() {
        int type;
        if (this.hasPrepareForShare) {
            return;
        }
        boolean supportShareType = true;
        this.hasPrepareForShare = true;
        Integer downReason = checkTopViewDown();
        if (getSplash$adsplash_debug().getTopViewType() != SplashTopViewType.BG_DISAPPEAR.getType() && getSplash$adsplash_debug().getTopViewType() != SplashTopViewType.LAUNCH_DANMAKU.getType()) {
            supportShareType = false;
        }
        if (supportShareType && downReason != null) {
            SplashAdHelper.INSTANCE.reportTopVideoTransitionDownSuccess$adsplash_debug(getSplash$adsplash_debug(), downReason.intValue());
        }
        if (supportShareType && downReason == null) {
            SplashAdHelper.INSTANCE.reportTopVideoTransitionSuccess$adsplash_debug(getSplash$adsplash_debug());
            doCutout();
            doShare();
            return;
        }
        if (getSplash$adsplash_debug().getTopViewType() == SplashTopViewType.BG_DISAPPEAR.getType()) {
            SplashOrder splash$adsplash_debug = getSplash$adsplash_debug();
            if (((SplashState) getViewModel$adsplash_debug().getState().getValue()).getSkipClick()) {
                type = SplashTopViewType.NONE.getType();
            } else {
                type = SplashTopViewType.TV_CLOSE.getType();
            }
            splash$adsplash_debug.setTopViewType(type);
        }
        SplashViewModel viewModel$adsplash_debug = getViewModel$adsplash_debug();
        String valueOf = String.valueOf(getSplash$adsplash_debug().getId());
        SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
        viewModel$adsplash_debug.update(new VideoShareDataUpdateAction(new PlayerShareData(1, valueOf, 0, splashBannerPlayer != null ? splashBannerPlayer.getCurrentPosition() : 0L, getSplash$adsplash_debug().getAdCb(), 4, (DefaultConstructorMarker) null)));
    }

    private final void showVideoLayer() {
        String videoUri;
        Rect expectBannerRect = ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getExpectBannerRect();
        if (expectBannerRect == null || (videoUri = BusinessSplashResHelperKt.fetchResourceLocalUriPathByHash(getSplash$adsplash_debug().getVideoHash())) == null) {
            return;
        }
        View roundRectFrameLayout = new RoundRectFrameLayout(getBinding$adsplash_debug().getRoot().getContext());
        roundRectFrameLayout.setRadius(this.videoRadius);
        SplashContainerView root = getBinding$adsplash_debug().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        roundRectFrameLayout.setLayoutParams(SplashLayoutUtilsKt.rectToLayoutParams((ViewGroup) root, expectBannerRect));
        int insertIndex = ViewLayerUtilKt.findIndexInParent((View) getBinding$adsplash_debug().splashView) + 1;
        getBinding$adsplash_debug().getRoot().addView(roundRectFrameLayout, insertIndex);
        BLog.i("[Splash]BannerSplash", "showVideoLayer");
        Fragment fragment = (Fragment) this;
        ViewGroup viewGroup = (ViewGroup) roundRectFrameLayout;
        SplashVideoInfo splashStoryInfo = getSplash$adsplash_debug().getSplashStoryInfo();
        long cid = splashStoryInfo != null ? splashStoryInfo.getCid() : 0L;
        SplashVideoInfo splashStoryInfo2 = getSplash$adsplash_debug().getSplashStoryInfo();
        this.bannerPlayer = new SplashBannerPlayer(fragment, viewGroup, videoUri, cid, splashStoryInfo2 != null ? splashStoryInfo2.getAvid() : 0L, new Function1() { // from class: tv.danmaku.bili.splash.ad.page.BannerSplash$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showVideoLayer$lambda$1;
                showVideoLayer$lambda$1 = BannerSplash.showVideoLayer$lambda$1(BannerSplash.this, (SplashBannerPlayer) obj);
                return showVideoLayer$lambda$1;
            }
        }, new Function1() { // from class: tv.danmaku.bili.splash.ad.page.BannerSplash$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit showVideoLayer$lambda$2;
                showVideoLayer$lambda$2 = BannerSplash.showVideoLayer$lambda$2(BannerSplash.this, (SplashBannerPlayer) obj);
                return showVideoLayer$lambda$2;
            }
        });
        final View $this$doOnPreDraw$iv = roundRectFrameLayout;
        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.BannerSplash$showVideoLayer$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                View view = $this$doOnPreDraw$iv;
                BLog.i("[Splash]BannerSplash", "showVideoLayer, onPreDraw");
                SplashBannerPlayer bannerPlayer = this.getBannerPlayer();
                if (bannerPlayer != null) {
                    bannerPlayer.play();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showVideoLayer$lambda$1(BannerSplash this$0, SplashBannerPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PlayerReporterInitComponentKt.initPlayerReporter(this$0, player);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showVideoLayer$lambda$2(BannerSplash this$0, SplashBannerPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        BiliCardPlayerScene.CardPlayTask task = player.getTask();
        Intrinsics.checkNotNull(task);
        PlayerCallbackRegisterComponentKt.registerCardPlayerStateCallback((Fragment) this$0, task, this$0.getViewModel$adsplash_debug());
        return Unit.INSTANCE;
    }

    private final Integer checkTopViewDown() {
        Rect expectBannerRect = ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getExpectBannerRect();
        boolean isBannerPositionCorrect = expectBannerRect != null && isSame(expectBannerRect, ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getRealBannerRect());
        boolean supportVersion = Build.VERSION.SDK_INT >= 26;
        String realShowTopViewId = ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getRealShowTopViewId();
        Long pegasusTopViewId = realShowTopViewId != null ? StringsKt.toLongOrNull(realShowTopViewId) : null;
        int topViewType = getSplash$adsplash_debug().getTopViewType();
        BLog.i("[Splash]BannerSplash", "checkTopViewDown,  pegasus support, topViewType = " + topViewType + ", pegasusTopViewId = " + pegasusTopViewId + ", splashId = " + getSplash$adsplash_debug().getId() + ", bannerRect Correct = " + isBannerPositionCorrect + ", supportVersion = " + supportVersion + ",bannerSharePlay,reason = " + ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getBannerSharePlayInfo().getReason() + ", supportShare = " + ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getBannerSharePlayInfo().getSupportShare());
        long id = getSplash$adsplash_debug().getId();
        if (pegasusTopViewId == null || pegasusTopViewId.longValue() != id) {
            return 1;
        }
        if (((SplashState) getViewModel$adsplash_debug().getState().getValue()).getBannerSharePlayInfo().getSupportShare()) {
            if (isBannerPositionCorrect) {
                return !supportVersion ? 5 : null;
            }
            return 4;
        }
        BLog.i("[Splash]BannerSplash", "checkTopViewDown, pegasus not support,, topViewType = " + getSplash$adsplash_debug().getTopViewType() + ", reason = " + ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getBannerSharePlayInfo().getReason());
        return Integer.valueOf(((SplashState) getViewModel$adsplash_debug().getState().getValue()).getBannerSharePlayInfo().getReason());
    }

    private final void doCutout() {
        Object obj;
        Rect expectRect = ((SplashState) getViewModel$adsplash_debug().getState().getValue()).getExpectBannerRect();
        if (expectRect != null && getBinding$adsplash_debug().splashView.isLaidOut()) {
            try {
                Result.Companion companion = Result.Companion;
                BannerSplash $this$doCutout_u24lambda_u240 = this;
                SplashImageView splashImageView = $this$doCutout_u24lambda_u240.getBinding$adsplash_debug().splashView;
                Intrinsics.checkNotNullExpressionValue(splashImageView, "splashView");
                Bitmap bm = ViewKt.drawToBitmap$default((View) splashImageView, (Bitmap.Config) null, 1, (Object) null);
                Bitmap cutBm = SplashImageUtilKt.cutoutRoundRect(bm, new RectF(expectRect.left, expectRect.top, expectRect.right, expectRect.bottom), $this$doCutout_u24lambda_u240.videoRadius);
                $this$doCutout_u24lambda_u240.getBinding$adsplash_debug().splashView.setImageBitmap(cutBm);
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable it = Result.exceptionOrNull-impl(obj);
            if (it != null) {
                it.printStackTrace();
            }
        }
    }

    private final void doShare() {
        Integer sharePlayer;
        SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
        long currentPosition = splashBannerPlayer != null ? splashBannerPlayer.getCurrentPosition() : 0L;
        SplashBannerPlayer splashBannerPlayer2 = this.bannerPlayer;
        int shareId = (splashBannerPlayer2 == null || (sharePlayer = splashBannerPlayer2.sharePlayer()) == null) ? -1 : sharePlayer.intValue();
        BLog.i("[Splash]BannerSplash", "onCountdownEnd, shareId = " + shareId);
        getViewModel$adsplash_debug().update(new VideoShareDataUpdateAction(new PlayerShareData(0, String.valueOf(getSplash$adsplash_debug().getId()), shareId, currentPosition, getSplash$adsplash_debug().getAdCb())));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BannerSplash$doShare$1(this, null), 3, (Object) null);
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash
    public void asyncGetLinkageTransformView(final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, AuthResultCbHelper.ARGS_CALLBACK);
        BLog.i("[Splash]BannerSplash", "asyncGetTransformView, before snapshot");
        SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
        if (splashBannerPlayer != null) {
            splashBannerPlayer.takeSnapshot(new Function1() { // from class: tv.danmaku.bili.splash.ad.page.BannerSplash$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit asyncGetLinkageTransformView$lambda$0;
                    asyncGetLinkageTransformView$lambda$0 = BannerSplash.asyncGetLinkageTransformView$lambda$0(BannerSplash.this, function1, (Bitmap) obj);
                    return asyncGetLinkageTransformView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asyncGetLinkageTransformView$lambda$0(BannerSplash this$0, Function1 $callback, Bitmap playerBm) {
        boolean isStillAlive = ListExtentionsKt.isViewAlive((Fragment) this$0) && this$0.getBinding$adsplash_debug().splashView.isLaidOut();
        BLog.i("[Splash]BannerSplash", "doBeforeAnimation, finish snapshot, isStillAlive = " + isStillAlive + "， snapShotSuccess = " + (playerBm != null));
        if (!isStillAlive || playerBm == null) {
            $callback.invoke((Object) null);
            return Unit.INSTANCE;
        }
        SplashImageView splashImageView = this$0.getBinding$adsplash_debug().splashView;
        Intrinsics.checkNotNullExpressionValue(splashImageView, "splashView");
        Bitmap bgBm = ViewKt.drawToBitmap$default((View) splashImageView, (Bitmap.Config) null, 1, (Object) null);
        BLog.i("[Splash]BannerSplash", "doBeforeAnimation, finish snapshot");
        this$0.getBinding$adsplash_debug().splashView.setImageBitmap(SplashImageUtilKt.mergeCoverToBgImage(bgBm, playerBm, ((SplashState) this$0.getViewModel$adsplash_debug().getState().getValue()).getExpectBannerRect(), this$0.videoRadius));
        $callback.invoke(this$0.getBinding$adsplash_debug().splashView);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onSkipClick() {
        CountdownComponentKt.doStopCountdown(this);
        prepareShare();
        getViewModel$adsplash_debug().update(new DoSplashLinkageAnimationAction("skip"));
    }

    private final boolean isSame(Rect $this$isSame, Rect other) {
        int delta = ListExtentionsKt.toPx(2);
        return other != null && Math.abs($this$isSame.left - other.left) <= delta && Math.abs($this$isSame.top - other.top) <= delta && Math.abs($this$isSame.right - other.right) <= delta && Math.abs($this$isSame.bottom - other.bottom) <= delta;
    }
}