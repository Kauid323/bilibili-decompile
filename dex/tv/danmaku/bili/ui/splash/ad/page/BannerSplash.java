package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import java.util.List;
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
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashBannerPlayer;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.splash.ad.state.actions.DoSplashLinkageAnimationAction;
import tv.danmaku.bili.splash.ad.utils.image.SplashImageUtilKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.splash.ad.utils.ui.ViewLayerUtilKt;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashTopViewType;
import tv.danmaku.bili.ui.splash.ad.model.SplashVideoInfo;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.bili.widget.RoundRectFrameLayout;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: BannerSplash.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0014J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\u0016\u0010\u001e\u001a\u00020\t*\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/page/BannerSplash;", "Ltv/danmaku/bili/ui/splash/ad/page/FullImageSplash;", "<init>", "()V", "bannerPlayer", "Ltv/danmaku/bili/splash/ad/player/SplashBannerPlayer;", "videoRadius", "", "hasPrepareForShare", "", "showContent", "", "onSplashReady", "startContDown", "leftTimeMillis", "", "prepareShare", "checkTopViewDown", "", "()Ljava/lang/Integer;", "onSkipClick", "doShare", "showVideoLayer", "getAlphaView", "", "Landroid/view/View;", "asyncGetTransformView", "callback", "Ltv/danmaku/bili/ui/splash/ad/page/TakeSnapshotCallback;", "doCutout", "isSame", "Landroid/graphics/Rect;", "other", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BannerSplash extends FullImageSplash {
    public static final int $stable = 8;
    private SplashBannerPlayer bannerPlayer;
    private boolean hasPrepareForShare;
    private final float videoRadius = ListExtentionsKt.toPx(4);

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showContent() {
        showVideoLayer();
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onSplashReady() {
        super.showContent();
        super.onSplashReady();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void startContDown(long leftTimeMillis) {
        if (leftTimeMillis < 1) {
            prepareShare();
        }
        super.startContDown(leftTimeMillis);
    }

    private final void prepareShare() {
        int type;
        StateFlow state;
        SplashState splashState;
        if (this.hasPrepareForShare) {
            return;
        }
        boolean z = true;
        this.hasPrepareForShare = true;
        Integer downReason = checkTopViewDown();
        boolean supportShareType = this.mSplash.topViewType == SplashTopViewType.BG_DISAPPEAR.getType() || this.mSplash.topViewType == SplashTopViewType.LAUNCH_DANMAKU.getType();
        if (supportShareType && downReason != null) {
            SplashAdHelper.INSTANCE.reportTopVideoTransitionDownSuccess$splash_debug(getSplash(), downReason.intValue());
        }
        if (supportShareType && downReason == null) {
            SplashAdHelper.INSTANCE.reportTopVideoTransitionSuccess$splash_debug(getSplash());
            doCutout();
            doShare();
            return;
        }
        if (this.mSplash.topViewType == SplashTopViewType.BG_DISAPPEAR.getType()) {
            Splash splash = this.mSplash;
            SplashViewModel splashViewModel = this.mSplashViewModel;
            if (splashViewModel == null || (state = splashViewModel.getState()) == null || (splashState = (SplashState) state.getValue()) == null || !splashState.getSkipClick()) {
                z = false;
            }
            if (z) {
                type = SplashTopViewType.NONE.getType();
            } else {
                type = SplashTopViewType.TV_CLOSE.getType();
            }
            splash.topViewType = type;
        }
        SplashViewModel splashViewModel2 = this.mSplashViewModel;
        if (splashViewModel2 != null) {
            Splash splash2 = getSplash();
            String valueOf = String.valueOf(splash2 != null ? Long.valueOf(splash2.id) : null);
            SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
            long currentPosition = splashBannerPlayer != null ? splashBannerPlayer.getCurrentPosition() : 0L;
            Splash splash3 = getSplash();
            splashViewModel2.update(new VideoShareDataUpdateAction(new PlayerShareData(1, valueOf, 0, currentPosition, splash3 != null ? splash3.adCb : null, 4, (DefaultConstructorMarker) null)));
        }
    }

    private final Integer checkTopViewDown() {
        SplashViewModel viewModel = this.mSplashViewModel;
        if (viewModel == null) {
            return null;
        }
        String realShowTopViewId = ((SplashState) viewModel.getState().getValue()).getRealShowTopViewId();
        Long pegasusTopViewId = realShowTopViewId != null ? StringsKt.toLongOrNull(realShowTopViewId) : null;
        Rect expectBannerRect = ((SplashState) viewModel.getState().getValue()).getExpectBannerRect();
        boolean isBannerPositionCorrect = expectBannerRect != null && isSame(expectBannerRect, ((SplashState) viewModel.getState().getValue()).getRealBannerRect());
        boolean supportVersion = Build.VERSION.SDK_INT >= 26;
        Splash splash = this.mSplash;
        Integer valueOf = splash != null ? Integer.valueOf(splash.topViewType) : null;
        Splash splash2 = this.mSplash;
        BLog.i("[Splash]BannerSplash", "checkTopViewDown,  pegasus support, topViewType = " + valueOf + ", pegasusTopViewId = " + pegasusTopViewId + ", splashId = " + (splash2 != null ? Long.valueOf(splash2.id) : null) + ", bannerRect Correct = " + isBannerPositionCorrect + ", supportVersion = " + supportVersion + ",bannerSharePlay,reason = " + ((SplashState) viewModel.getState().getValue()).getBannerSharePlayInfo().getReason() + ", supportShare = " + ((SplashState) viewModel.getState().getValue()).getBannerSharePlayInfo().getSupportShare());
        Splash splash3 = this.mSplash;
        if (!Intrinsics.areEqual(pegasusTopViewId, splash3 != null ? Long.valueOf(splash3.id) : null)) {
            return 1;
        }
        if (((SplashState) viewModel.getState().getValue()).getBannerSharePlayInfo().getSupportShare()) {
            if (isBannerPositionCorrect) {
                return !supportVersion ? 5 : null;
            }
            return 4;
        }
        Splash splash4 = this.mSplash;
        BLog.i("[Splash]BannerSplash", "checkTopViewDown, pegasus not support,, topViewType = " + (splash4 != null ? Integer.valueOf(splash4.topViewType) : null) + ", reason = " + ((SplashState) viewModel.getState().getValue()).getBannerSharePlayInfo().getReason());
        return Integer.valueOf(((SplashState) viewModel.getState().getValue()).getBannerSharePlayInfo().getReason());
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    protected void onSkipClick() {
        stopCountDown();
        prepareShare();
        SplashViewModel splashViewModel = this.mSplashViewModel;
        if (splashViewModel != null) {
            splashViewModel.update(new DoSplashLinkageAnimationAction("skip"));
        }
    }

    private final void doShare() {
        Integer sharePlayer;
        SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
        long currentPosition = splashBannerPlayer != null ? splashBannerPlayer.getCurrentPosition() : 0L;
        SplashBannerPlayer splashBannerPlayer2 = this.bannerPlayer;
        int shareId = (splashBannerPlayer2 == null || (sharePlayer = splashBannerPlayer2.sharePlayer()) == null) ? -1 : sharePlayer.intValue();
        BLog.i("[Splash]BannerSplash", "onCountdownEnd, shareId = " + shareId);
        SplashViewModel splashViewModel = this.mSplashViewModel;
        if (splashViewModel != null) {
            Splash splash = getSplash();
            String valueOf = String.valueOf(splash != null ? Long.valueOf(splash.id) : "0");
            Splash splash2 = getSplash();
            splashViewModel.update(new VideoShareDataUpdateAction(new PlayerShareData(0, valueOf, shareId, currentPosition, splash2 != null ? splash2.adCb : null)));
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BannerSplash$doShare$1(this, null), 3, (Object) null);
    }

    private final void showVideoLayer() {
        StateFlow state;
        SplashState splashState;
        Rect expectBannerRect;
        String str;
        SplashVideoInfo splashVideoInfo;
        SplashVideoInfo splashVideoInfo2;
        SplashViewModel splashViewModel = this.mSplashViewModel;
        if (splashViewModel == null || (state = splashViewModel.getState()) == null || (splashState = (SplashState) state.getValue()) == null || (expectBannerRect = splashState.getExpectBannerRect()) == null) {
            return;
        }
        Splash splash = getSplash();
        if (splash == null || (str = splash.videoHash) == null) {
            return;
        }
        String videoUri = BusinessSplashResHelperKt.md5ToFileUri(str);
        if (videoUri == null) {
            return;
        }
        View view2 = getView();
        ViewGroup rootView = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if (rootView == null) {
            return;
        }
        Context ctx = rootView.getContext();
        RoundRectFrameLayout $this$showVideoLayer_u24lambda_u240 = new RoundRectFrameLayout(ctx);
        $this$showVideoLayer_u24lambda_u240.setRadius(this.videoRadius);
        $this$showVideoLayer_u24lambda_u240.setLayoutParams(SplashLayoutUtilsKt.rectToLayoutParams(rootView, expectBannerRect));
        int insertIndex = ViewLayerUtilKt.findIndexInParent(this.mSplashView) + 1;
        rootView.addView($this$showVideoLayer_u24lambda_u240, insertIndex);
        BLog.i("[Splash]BannerSplash", "showVideoLayer");
        Fragment fragment = (Fragment) this;
        RoundRectFrameLayout roundRectFrameLayout = $this$showVideoLayer_u24lambda_u240;
        Splash splash2 = this.mSplash;
        long j = 0;
        long cid = (splash2 == null || (splashVideoInfo2 = splash2.splashStoryInfo) == null) ? 0L : splashVideoInfo2.getCid();
        Splash splash3 = this.mSplash;
        if (splash3 != null && (splashVideoInfo = splash3.splashStoryInfo) != null) {
            j = splashVideoInfo.getAvid();
        }
        this.bannerPlayer = new SplashBannerPlayer(fragment, roundRectFrameLayout, videoUri, cid, j, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.BannerSplash$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit showVideoLayer$lambda$1;
                showVideoLayer$lambda$1 = BannerSplash.showVideoLayer$lambda$1(BannerSplash.this, (SplashBannerPlayer) obj);
                return showVideoLayer$lambda$1;
            }
        }, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.BannerSplash$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit showVideoLayer$lambda$2;
                showVideoLayer$lambda$2 = BannerSplash.showVideoLayer$lambda$2(BannerSplash.this, (SplashBannerPlayer) obj);
                return showVideoLayer$lambda$2;
            }
        });
        final RoundRectFrameLayout $this$doOnPreDraw$iv = $this$showVideoLayer_u24lambda_u240;
        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.BannerSplash$showVideoLayer$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                SplashBannerPlayer splashBannerPlayer;
                View view3 = $this$doOnPreDraw$iv;
                BLog.i("[Splash]BannerSplash", "showVideoLayer, onPreDraw");
                splashBannerPlayer = this.bannerPlayer;
                if (splashBannerPlayer != null) {
                    splashBannerPlayer.play();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showVideoLayer$lambda$1(BannerSplash this$0, SplashBannerPlayer player) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        PlayerReporterInitComponentKt.initPlayerReporter(this$0, player);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showVideoLayer$lambda$2(BannerSplash this$0, SplashBannerPlayer player) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        BiliCardPlayerScene.CardPlayTask task = player.getTask();
        Intrinsics.checkNotNull(task);
        SplashViewModel splashViewModel = this$0.mSplashViewModel;
        Intrinsics.checkNotNull(splashViewModel);
        PlayerCallbackRegisterComponentKt.registerCardPlayerStateCallback((Fragment) this$0, task, splashViewModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public List<View> getAlphaView() {
        List $this$getAlphaView_u24lambda_u240 = super.getAlphaView();
        if (this.mSplash.topViewType == SplashTopViewType.TV_CLOSE.getType()) {
            SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
            $this$getAlphaView_u24lambda_u240.add(splashBannerPlayer != null ? splashBannerPlayer.getContainer() : null);
        }
        Intrinsics.checkNotNullExpressionValue($this$getAlphaView_u24lambda_u240, "apply(...)");
        return $this$getAlphaView_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public void asyncGetTransformView(final TakeSnapshotCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BLog.i("[Splash]BannerSplash", "asyncGetTransformView, before snapshot");
        SplashBannerPlayer splashBannerPlayer = this.bannerPlayer;
        if (splashBannerPlayer != null) {
            splashBannerPlayer.takeSnapshot(new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.BannerSplash$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit asyncGetTransformView$lambda$0;
                    asyncGetTransformView$lambda$0 = BannerSplash.asyncGetTransformView$lambda$0(BannerSplash.this, callback, (Bitmap) obj);
                    return asyncGetTransformView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asyncGetTransformView$lambda$0(BannerSplash this$0, TakeSnapshotCallback $callback, Bitmap playerBm) {
        StateFlow state;
        SplashState splashState;
        boolean isStillAlive = ListExtentionsKt.isViewAlive((Fragment) this$0) && this$0.mSplashView.isLaidOut();
        BLog.i("[Splash]BannerSplash", "doBeforeAnimation, finish snapshot, isStillAlive = " + isStillAlive + "， snapShotSuccess = " + (playerBm != null));
        Rect rect = null;
        if (!isStillAlive || playerBm == null) {
            $callback.onTake(null);
            return Unit.INSTANCE;
        }
        ImageView imageView = this$0.mSplashView;
        Bitmap bgBm = imageView != null ? ViewKt.drawToBitmap$default(imageView, (Bitmap.Config) null, 1, (Object) null) : null;
        BLog.i("[Splash]BannerSplash", "doBeforeAnimation, finish snapshot");
        ImageView imageView2 = this$0.mSplashView;
        SplashViewModel splashViewModel = this$0.mSplashViewModel;
        if (splashViewModel != null && (state = splashViewModel.getState()) != null && (splashState = (SplashState) state.getValue()) != null) {
            rect = splashState.getExpectBannerRect();
        }
        imageView2.setImageBitmap(SplashImageUtilKt.mergeCoverToBgImage(bgBm, playerBm, rect, this$0.videoRadius));
        $callback.onTake(this$0.mSplashView);
        return Unit.INSTANCE;
    }

    private final void doCutout() {
        StateFlow state;
        SplashState splashState;
        Rect expectRect;
        Object obj;
        SplashViewModel splashViewModel = this.mSplashViewModel;
        if (splashViewModel != null && (state = splashViewModel.getState()) != null && (splashState = (SplashState) state.getValue()) != null && (expectRect = splashState.getExpectBannerRect()) != null && this.mSplashView.isLaidOut()) {
            try {
                Result.Companion companion = Result.Companion;
                BannerSplash $this$doCutout_u24lambda_u240 = this;
                ImageView imageView = $this$doCutout_u24lambda_u240.mSplashView;
                Intrinsics.checkNotNullExpressionValue(imageView, "mSplashView");
                Bitmap bm = ViewKt.drawToBitmap$default(imageView, (Bitmap.Config) null, 1, (Object) null);
                Bitmap cutBm = SplashImageUtilKt.cutoutRoundRect(bm, new RectF(expectRect.left, expectRect.top, expectRect.right, expectRect.bottom), $this$doCutout_u24lambda_u240.videoRadius);
                $this$doCutout_u24lambda_u240.mSplashView.setImageBitmap(cutBm);
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

    private final boolean isSame(Rect $this$isSame, Rect other) {
        int delta = ListExtentionsKt.toPx(2);
        return other != null && Math.abs($this$isSame.left - other.left) <= delta && Math.abs($this$isSame.top - other.top) <= delta && Math.abs($this$isSame.right - other.right) <= delta && Math.abs($this$isSame.bottom - other.bottom) <= delta;
    }
}