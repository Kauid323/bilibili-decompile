package tv.danmaku.bili.ui.splash.ad.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashPlayerHelperKt;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.splash.ad.state.actions.SplashJumpClickEvent;
import tv.danmaku.bili.ui.splash.ad.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.ui.splash.ad.landingpage.SplashImmersiveVideoLandingActivityV2Kt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.player.MiddlePageShareData;
import tv.danmaku.bili.ui.splash.ad.player.SplashMediaPlayerManager;
import tv.danmaku.bili.ui.splash.ad.util.SplashLayoutHelperKt;
import tv.danmaku.bili.ui.splash.event.EventSplashStorageKt;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCodecHelper;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: ImmersiveVideoSplashV2.kt */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001c\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/page/ImmersiveVideoSplashV2;", "Ltv/danmaku/bili/ui/splash/ad/page/FullImageSplash;", "<init>", "()V", "textureView", "Landroid/view/TextureView;", "playerSurface", "Landroid/view/Surface;", "showContent", "", "startContDown", "leftTimeMillis", "", "jumpToImmersivePage", PerformanceConstants.EXTRA_KEY_SCHEMA, "", "jumpUrl", "textureListener", "tv/danmaku/bili/ui/splash/ad/page/ImmersiveVideoSplashV2$textureListener$1", "Ltv/danmaku/bili/ui/splash/ad/page/ImmersiveVideoSplashV2$textureListener$1;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ImmersiveVideoSplashV2 extends FullImageSplash {
    public static final int $stable = 8;
    private Surface playerSurface;
    private final ImmersiveVideoSplashV2$textureListener$1 textureListener = new TextureView.SurfaceTextureListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$textureListener$1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            Surface surface2;
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[read]ImmersiveVideoSplashV2", "onSurfaceTextureAvailable, width = " + width + ", height = " + height);
            ImmersiveVideoSplashV2.this.playerSurface = new Surface(surface);
            SplashMediaPlayerManager splashMediaPlayerManager = SplashMediaPlayerManager.INSTANCE;
            surface2 = ImmersiveVideoSplashV2.this.playerSurface;
            Intrinsics.checkNotNull(surface2);
            splashMediaPlayerManager.play(surface2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[read]ImmersiveVideoSplashV2", "onSurfaceTextureSizeChanged, width = " + width + ", height = " + height);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            Surface surface2;
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[read]ImmersiveVideoSplashV2", "onSurfaceTextureDestroyed");
            surface2 = ImmersiveVideoSplashV2.this.playerSurface;
            if (surface2 != null) {
                surface2.release();
            }
            ImmersiveVideoSplashV2.this.playerSurface = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    };
    private TextureView textureView;

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showContent() {
        super.showContent();
        View view2 = getView();
        ViewGroup rootView = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if (rootView == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SplashMediaPlayerManager splashMediaPlayerManager = SplashMediaPlayerManager.INSTANCE;
            Splash splash = getSplash();
            String fetchResourceLocalPathByHash = EventSplashStorageKt.fetchResourceLocalPathByHash(splash != null ? splash.videoHash : null);
            if (fetchResourceLocalPathByHash == null) {
                fetchResourceLocalPathByHash = "";
            }
            Result.constructor-impl(splashMediaPlayerManager.initPlayer(fetchResourceLocalPathByHash, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit showContent$lambda$0$0;
                    showContent$lambda$0$0 = ImmersiveVideoSplashV2.showContent$lambda$0$0(ImmersiveVideoSplashV2.this, (MediaPlayer) obj);
                    return showContent$lambda$0$0;
                }
            }, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit showContent$lambda$0$1;
                    showContent$lambda$0$1 = ImmersiveVideoSplashV2.showContent$lambda$0$1(ImmersiveVideoSplashV2.this, (MediaPlayer) obj);
                    return showContent$lambda$0$1;
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        ImageView imageView = this.mSplashView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        TextureView $this$showContent_u24lambda_u241 = new TextureView(rootView.getContext());
        $this$showContent_u24lambda_u241.setLayoutParams(SplashLayoutHelperKt.createMatchParentLayoutParams(rootView));
        $this$showContent_u24lambda_u241.setSurfaceTextureListener(this.textureListener);
        this.textureView = $this$showContent_u24lambda_u241;
        rootView.addView(this.textureView, 0);
        BLog.i("[read]ImmersiveVideoSplashV2", "showContent");
        TextureView textureView = this.textureView;
        if (textureView != null) {
            textureView.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ImmersiveVideoSplashV2.showContent$lambda$2(ImmersiveVideoSplashV2.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showContent$lambda$0$0(ImmersiveVideoSplashV2 this$0, MediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        PlayerReporterInitComponentKt.initPlayerReporter(this$0, player);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showContent$lambda$0$1(ImmersiveVideoSplashV2 this$0, MediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        SplashViewModel splashViewModel = this$0.mSplashViewModel;
        Intrinsics.checkNotNull(splashViewModel);
        PlayerCallbackRegisterComponentKt.registerMediaPlayerStateCallback((Fragment) this$0, player, splashViewModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContent$lambda$2(ImmersiveVideoSplashV2 this$0) {
        TextureView tvv = this$0.textureView;
        if (tvv == null) {
            return;
        }
        MiddlePageShareData $this$showContent_u24lambda_u242_u240 = SplashMediaPlayerManager.INSTANCE.getShareData();
        $this$showContent_u24lambda_u242_u240.setSplash(this$0.mSplash);
        $this$showContent_u24lambda_u242_u240.setPlayerWidth(tvv.getWidth());
        $this$showContent_u24lambda_u242_u240.setPlayerHeight(tvv.getHeight());
        Splash splash = this$0.mSplash;
        $this$showContent_u24lambda_u242_u240.setVideoWidth(splash != null ? splash.videoWidth : IjkCodecHelper.IJKCODEC_H265_HEIGHT);
        Splash splash2 = this$0.mSplash;
        $this$showContent_u24lambda_u242_u240.setVideoHeight(splash2 != null ? splash2.videoHeight : IjkCodecHelper.IJKCODEC_H265_WIDTH);
        Splash splash3 = this$0.mSplash;
        $this$showContent_u24lambda_u242_u240.setMiddlePageInfo(splash3 != null ? splash3.middlePageInfo : null);
        BLog.i("[read]ImmersiveVideoSplashV2", "centerCropVideo, start");
        SplashPlayerHelperKt.centerCropVideo(tvv.getWidth(), tvv.getHeight(), this$0.mSplash.videoWidth, this$0.mSplash.videoHeight, tvv);
        BLog.i("[read]ImmersiveVideoSplashV2", "centerCropVideo, end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void startContDown(long leftTimeMillis) {
        if (leftTimeMillis < 1) {
            jumpToImmersivePage(this.mSplash.appLink, this.mSplash.jumpUrl);
        } else {
            super.startContDown(leftTimeMillis);
        }
    }

    private final void jumpToImmersivePage(final String schema, final String jumpUrl) {
        SplashViewModel splashViewModel = this.mSplashViewModel;
        if (splashViewModel != null) {
            splashViewModel.update(new PlayerEvent.OnStop("countdown"));
        }
        ValueAnimator $this$jumpToImmersivePage_u24lambda_u240 = ValueAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        $this$jumpToImmersivePage_u24lambda_u240.setDuration(200L);
        $this$jumpToImmersivePage_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ImmersiveVideoSplashV2.jumpToImmersivePage$lambda$0$0(ImmersiveVideoSplashV2.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNull($this$jumpToImmersivePage_u24lambda_u240);
        ValueAnimator $this$addListener_u24default$iv = $this$jumpToImmersivePage_u24lambda_u240;
        $this$addListener_u24default$iv.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$jumpToImmersivePage$lambda$0$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BLog.i("[read]ImmersiveVideoSplashV2", "onSurfaceTextureAvailable, jumpToImmersivePage");
                MiddlePageShareData $this$jumpToImmersivePage_u24lambda_u240_u241_u240 = SplashMediaPlayerManager.INSTANCE.getShareData();
                final ImmersiveVideoSplashV2 immersiveVideoSplashV2 = ImmersiveVideoSplashV2.this;
                $this$jumpToImmersivePage_u24lambda_u240_u241_u240.setTakeLatestScreenshot(new Function0<Bitmap>() { // from class: tv.danmaku.bili.ui.splash.ad.page.ImmersiveVideoSplashV2$jumpToImmersivePage$1$2$1$1
                    /* renamed from: invoke */
                    public final Bitmap m1542invoke() {
                        TextureView textureView;
                        textureView = ImmersiveVideoSplashV2.this.textureView;
                        if (textureView != null) {
                            return textureView.getBitmap();
                        }
                        return null;
                    }
                });
                $this$jumpToImmersivePage_u24lambda_u240_u241_u240.setSplash(ImmersiveVideoSplashV2.this.mSplash);
                $this$jumpToImmersivePage_u24lambda_u240_u241_u240.setJumpUrl(jumpUrl);
                $this$jumpToImmersivePage_u24lambda_u240_u241_u240.setSchema(schema);
                SplashViewModel splashViewModel2 = ImmersiveVideoSplashV2.this.mSplashViewModel;
                if (splashViewModel2 != null) {
                    splashViewModel2.update(new SplashJumpClickEvent("jumpToImmersivePage"));
                }
                BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(SplashImmersiveVideoLandingActivityV2Kt.SPLASH_IMMERSIVE_LANDING_PAGE_V2), (Context) null, 2, (Object) null);
                FragmentActivity activity = ImmersiveVideoSplashV2.this.getActivity();
                if (activity != null) {
                    activity.overridePendingTransition(0, 0);
                }
                ImmersiveVideoSplashV2.this.exitSplash(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        $this$jumpToImmersivePage_u24lambda_u240.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpToImmersivePage$lambda$0$0(ImmersiveVideoSplashV2 this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alphaVal = ((Float) animatedValue).floatValue();
        Iterable alphaView = this$0.getAlphaView();
        Intrinsics.checkNotNullExpressionValue(alphaView, "getAlphaView(...)");
        Iterable $this$forEach$iv = alphaView;
        for (Object element$iv : $this$forEach$iv) {
            View it2 = (View) element$iv;
            if (it2 != null) {
                it2.setAlpha(alphaVal);
            }
        }
    }
}