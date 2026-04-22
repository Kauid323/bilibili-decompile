package tv.danmaku.bili.splash.ad.page;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt;
import tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3Kt;
import tv.danmaku.bili.splash.ad.player.MiddlePageShareData;
import tv.danmaku.bili.splash.ad.player.SplashMediaPlayerManager;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.splash.ad.state.actions.SplashSkipClickEvent;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.utils.UiUtilsKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;

/* compiled from: ImmersiveVideoSplash.kt */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004*\u0001\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/ImmersiveVideoSplash;", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "<init>", "()V", "textureView", "Landroid/view/TextureView;", "playerSurface", "Landroid/view/Surface;", "showMainMaterial", "", "textureListener", "tv/danmaku/bili/splash/ad/page/ImmersiveVideoSplash$textureListener$1", "Ltv/danmaku/bili/splash/ad/page/ImmersiveVideoSplash$textureListener$1;", "onCountdownEnd", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImmersiveVideoSplash extends BaseSplash {
    public static final int $stable = 8;
    private Surface playerSurface;
    private final ImmersiveVideoSplash$textureListener$1 textureListener = new TextureView.SurfaceTextureListener() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$textureListener$1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            Surface surface2;
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[Splash]ImmersiveVideoSplashV2", "onSurfaceTextureAvailable, width = " + width + ", height = " + height);
            ImmersiveVideoSplash.this.playerSurface = new Surface(surface);
            SplashMediaPlayerManager splashMediaPlayerManager = SplashMediaPlayerManager.INSTANCE;
            surface2 = ImmersiveVideoSplash.this.playerSurface;
            Intrinsics.checkNotNull(surface2);
            splashMediaPlayerManager.setSurface(surface2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[Splash]ImmersiveVideoSplashV2", "onSurfaceTextureSizeChanged, width = " + width + ", height = " + height);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            Surface surface2;
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[Splash]ImmersiveVideoSplashV2", "onSurfaceTextureDestroyed");
            surface2 = ImmersiveVideoSplash.this.playerSurface;
            if (surface2 != null) {
                surface2.release();
            }
            ImmersiveVideoSplash.this.playerSurface = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    };
    private TextureView textureView;

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void showMainMaterial() {
        View view = getView();
        ViewGroup rootView = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (rootView == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            final ImmersiveVideoSplash $this$showMainMaterial_u24lambda_u240 = this;
            SplashMediaPlayerManager splashMediaPlayerManager = SplashMediaPlayerManager.INSTANCE;
            String fetchResourceLocalPathByHash = BusinessSplashResHelperKt.fetchResourceLocalPathByHash($this$showMainMaterial_u24lambda_u240.getSplash$adsplash_debug().getVideoHash());
            if (fetchResourceLocalPathByHash == null) {
                fetchResourceLocalPathByHash = "";
            }
            Result.constructor-impl(splashMediaPlayerManager.initPlayer(fetchResourceLocalPathByHash, new Function1() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit showMainMaterial$lambda$0$0;
                    showMainMaterial$lambda$0$0 = ImmersiveVideoSplash.showMainMaterial$lambda$0$0(ImmersiveVideoSplash.this, (MediaPlayer) obj);
                    return showMainMaterial$lambda$0$0;
                }
            }, new Function1() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit showMainMaterial$lambda$0$1;
                    showMainMaterial$lambda$0$1 = ImmersiveVideoSplash.showMainMaterial$lambda$0$1(ImmersiveVideoSplash.this, (MediaPlayer) obj);
                    return showMainMaterial$lambda$0$1;
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        getBinding$adsplash_debug().splashView.setVisibility(4);
        TextureView $this$showMainMaterial_u24lambda_u241 = new TextureView(rootView.getContext());
        $this$showMainMaterial_u24lambda_u241.setLayoutParams(SplashLayoutUtilsKt.createMatchParentLayoutParams(rootView));
        $this$showMainMaterial_u24lambda_u241.setSurfaceTextureListener(this.textureListener);
        this.textureView = $this$showMainMaterial_u24lambda_u241;
        rootView.addView(this.textureView, 0);
        BLog.i("[Splash]ImmersiveVideoSplashV2", "showContent");
        TextureView textureView = this.textureView;
        if (textureView != null) {
            textureView.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ImmersiveVideoSplash.showMainMaterial$lambda$2(ImmersiveVideoSplash.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showMainMaterial$lambda$0$0(ImmersiveVideoSplash $this_runCatching, MediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PlayerReporterInitComponentKt.initPlayerReporter($this_runCatching, player);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showMainMaterial$lambda$0$1(ImmersiveVideoSplash $this_runCatching, MediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PlayerCallbackRegisterComponentKt.registerMediaPlayerStateCallback((Fragment) $this_runCatching, player, $this_runCatching.getViewModel$adsplash_debug());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMainMaterial$lambda$2(ImmersiveVideoSplash this$0) {
        TextureView tvv = this$0.textureView;
        if (tvv == null) {
            return;
        }
        MiddlePageShareData $this$showMainMaterial_u24lambda_u242_u240 = SplashMediaPlayerManager.INSTANCE.getShareData();
        $this$showMainMaterial_u24lambda_u242_u240.setSplash(this$0.getSplash$adsplash_debug());
        $this$showMainMaterial_u24lambda_u242_u240.setPlayerWidth(tvv.getWidth());
        $this$showMainMaterial_u24lambda_u242_u240.setPlayerHeight(tvv.getHeight());
        $this$showMainMaterial_u24lambda_u242_u240.setVideoWidth(this$0.getSplash$adsplash_debug().getVideoWidth());
        $this$showMainMaterial_u24lambda_u242_u240.setVideoHeight(this$0.getSplash$adsplash_debug().getVideoHeight());
        $this$showMainMaterial_u24lambda_u242_u240.setMiddlePageInfo(this$0.getSplash$adsplash_debug().getMiddlePageInfo());
        BLog.i("[Splash]ImmersiveVideoSplashV2", "centerCropVideo, start");
        UiUtilsKt.centerCropVideo(tvv.getWidth(), tvv.getHeight(), this$0.getSplash$adsplash_debug().getVideoWidth(), this$0.getSplash$adsplash_debug().getVideoHeight(), tvv);
        BLog.i("[Splash]ImmersiveVideoSplashV2", "centerCropVideo, end");
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onCountdownEnd() {
        getViewModel$adsplash_debug().update(new PlayerEvent.OnStop("countdown"));
        ValueAnimator $this$onCountdownEnd_u24lambda_u240 = ValueAnimator.ofFloat(1.0f, 0.0f);
        $this$onCountdownEnd_u24lambda_u240.setDuration(200L);
        $this$onCountdownEnd_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ImmersiveVideoSplash.onCountdownEnd$lambda$0$0(ImmersiveVideoSplash.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNull($this$onCountdownEnd_u24lambda_u240);
        ValueAnimator $this$addListener_u24default$iv = $this$onCountdownEnd_u24lambda_u240;
        $this$addListener_u24default$iv.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$onCountdownEnd$lambda$0$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BLog.i("[Splash]ImmersiveVideoSplashV2", "onSurfaceTextureAvailable, jumpToImmersivePage");
                MiddlePageShareData $this$onCountdownEnd_u24lambda_u240_u241_u240 = SplashMediaPlayerManager.INSTANCE.getShareData();
                final ImmersiveVideoSplash immersiveVideoSplash = ImmersiveVideoSplash.this;
                $this$onCountdownEnd_u24lambda_u240_u241_u240.setTakeLatestScreenshot(new Function0<Bitmap>() { // from class: tv.danmaku.bili.splash.ad.page.ImmersiveVideoSplash$onCountdownEnd$1$2$1$1
                    /* renamed from: invoke */
                    public final Bitmap m1416invoke() {
                        TextureView textureView;
                        textureView = ImmersiveVideoSplash.this.textureView;
                        if (textureView != null) {
                            return textureView.getBitmap();
                        }
                        return null;
                    }
                });
                $this$onCountdownEnd_u24lambda_u240_u241_u240.setSplash(ImmersiveVideoSplash.this.getSplash$adsplash_debug());
                $this$onCountdownEnd_u24lambda_u240_u241_u240.setJumpUrl(ImmersiveVideoSplash.this.getSplash$adsplash_debug().getJumpUrl());
                $this$onCountdownEnd_u24lambda_u240_u241_u240.setSchema(ImmersiveVideoSplash.this.getSplash$adsplash_debug().getAppLink());
                ImmersiveVideoSplash.this.getViewModel$adsplash_debug().update(new SplashSkipClickEvent("jumpToImmersive"));
                BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(SplashImmersiveVideoLandingActivityV3Kt.SPLASH_IMMERSIVE_LANDING_PAGE_V3), (Context) null, 2, (Object) null);
                FragmentActivity activity = ImmersiveVideoSplash.this.getActivity();
                if (activity != null) {
                    activity.overridePendingTransition(0, 0);
                }
                ISplashEvent.CC.exitSplash$default(ImmersiveVideoSplash.this, true, null, null, 6, null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        $this$onCountdownEnd_u24lambda_u240.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCountdownEnd$lambda$0$0(ImmersiveVideoSplash this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alphaVal = ((Float) animatedValue).floatValue();
        Iterable $this$forEach$iv = LinkageAnimationComponentKt.getLinkageAnimationAlphaView(this$0);
        for (Object element$iv : $this$forEach$iv) {
            View v = (View) element$iv;
            if (v != null) {
                v.setAlpha(alphaVal);
            }
        }
    }
}