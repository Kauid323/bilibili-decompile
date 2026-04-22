package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerWindowManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.splash.ad.player.SplashPlayerHelperKt;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.ui.splash.OnClickTouchListener;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash;
import tv.danmaku.bili.ui.splash.ad.player.SplashIjkPlayerKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.SplashAudioManager;
import tv.danmaku.bili.ui.splash.ad.util.SplashLayoutHelperKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class FullVideoSplash extends FullImageSplash {
    private static final float MAX_SOUND = 1.0f;
    private IjkMediaPlayer mMediaPlayer;
    private Surface mSurface;
    protected TextureView mTextureView;
    private boolean mOpenSound = false;
    private final SplashAudioManager mAudioManager = new SplashAudioManager();

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showContent() {
        ViewGroup rootView = (ViewGroup) getView();
        Context context = getContext();
        if (rootView == null || context == null) {
            return;
        }
        this.mSplashView.setVisibility(4);
        this.mTextureView = new TextureView(context);
        this.mTextureView.setSurfaceTextureListener(new AnonymousClass1(this));
        rootView.addView(this.mTextureView, 0, SplashLayoutHelperKt.createMatchParentLayoutParams(rootView));
        this.mTextureView.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FullVideoSplash.this.m1535lambda$showContent$0$tvdanmakubiliuisplashadpageFullVideoSplash();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        final /* synthetic */ FullVideoSplash val$fragment;

        AnonymousClass1(FullVideoSplash fullVideoSplash) {
            this.val$fragment = fullVideoSplash;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            Context context = FullVideoSplash.this.getApplicationContext();
            if (context == null) {
                return;
            }
            FullVideoSplash.this.mSurface = new Surface(surface);
            FullVideoSplash fullVideoSplash = FullVideoSplash.this;
            Surface surface2 = FullVideoSplash.this.mSurface;
            String md5ToFileUri = BusinessSplashResHelperKt.md5ToFileUri(FullVideoSplash.this.mSplash.videoHash);
            final FullVideoSplash fullVideoSplash2 = this.val$fragment;
            Function1 function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return FullVideoSplash.AnonymousClass1.lambda$onSurfaceTextureAvailable$0(FullVideoSplash.this, (IjkMediaPlayer) obj);
                }
            };
            final FullVideoSplash fullVideoSplash3 = this.val$fragment;
            fullVideoSplash.mMediaPlayer = SplashIjkPlayerKt.createSplashIjkPlayer(context, surface2, md5ToFileUri, function1, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return FullVideoSplash.AnonymousClass1.this.m1537lambda$onSurfaceTextureAvailable$1$tvdanmakubiliuisplashadpageFullVideoSplash$1(fullVideoSplash3, (IjkMediaPlayer) obj);
                }
            });
            FullVideoSplash.this.mMediaPlayer.setOnVideoFirstFrameRenderListener(new IjkMediaPlayer.OnVideoFirstFrameRenderListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash$1$$ExternalSyntheticLambda2
                @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnVideoFirstFrameRenderListener
                public final int onVideoFirstFrameRender() {
                    return FullVideoSplash.AnonymousClass1.this.m1538lambda$onSurfaceTextureAvailable$2$tvdanmakubiliuisplashadpageFullVideoSplash$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onSurfaceTextureAvailable$0(FullVideoSplash fragment, IjkMediaPlayer player) {
            PlayerReporterInitComponentKt.initPlayerReporter(fragment, player);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onSurfaceTextureAvailable$1$tv-danmaku-bili-ui-splash-ad-page-FullVideoSplash$1  reason: not valid java name */
        public /* synthetic */ Unit m1537lambda$onSurfaceTextureAvailable$1$tvdanmakubiliuisplashadpageFullVideoSplash$1(FullVideoSplash fragment, IjkMediaPlayer player) {
            if (FullVideoSplash.this.mSplashViewModel != null) {
                PlayerCallbackRegisterComponentKt.registerIjkPlayerStateCallback(fragment, player, FullVideoSplash.this.mSplashViewModel);
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onSurfaceTextureAvailable$2$tv-danmaku-bili-ui-splash-ad-page-FullVideoSplash$1  reason: not valid java name */
        public /* synthetic */ int m1538lambda$onSurfaceTextureAvailable$2$tvdanmakubiliuisplashadpageFullVideoSplash$1() {
            HandlerThreads.post(0, FullVideoSplash.this.mPreloadSecondPageEggVideoRunnable);
            return 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            if (FullVideoSplash.this.mSurface != null) {
                FullVideoSplash.this.mSurface.release();
                FullVideoSplash.this.mSurface = null;
            }
            if (FullVideoSplash.this.mMediaPlayer != null) {
                FullVideoSplash.this.mMediaPlayer.release();
                FullVideoSplash.this.mMediaPlayer = null;
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showContent$0$tv-danmaku-bili-ui-splash-ad-page-FullVideoSplash  reason: not valid java name */
    public /* synthetic */ void m1535lambda$showContent$0$tvdanmakubiliuisplashadpageFullVideoSplash() {
        SplashPlayerHelperKt.centerCropVideo(this.mTextureView.getWidth(), this.mTextureView.getHeight(), this.mSplash.videoWidth, this.mSplash.videoHeight, this.mTextureView);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onSoundButtonClicked() {
        if (this.mMediaPlayer == null) {
            return;
        }
        this.mOpenSound = !this.mOpenSound;
        String type = this.mOpenSound ? "1" : "0";
        SplashAdHelper.reportSecondPageSoundButtonClick(this.mSplash, type);
        float sound = this.mOpenSound ? 1.0f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mMediaPlayer.setVolume(sound);
        if (this.mOpenSound) {
            this.mAudioManager.requestFocus();
        } else {
            this.mAudioManager.releaseFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void handleDestroyView() {
        super.handleDestroyView();
        this.mAudioManager.releaseFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onTriggerSecondPage(SplashActionType actionType) {
        if (this.mMediaPlayer == null || this.mSplash.secondPage == null) {
            return;
        }
        IMiniPlayerWindowManager mpwm = (IMiniPlayerWindowManager) BLRouter.INSTANCE.getServices(IMiniPlayerWindowManager.class).get("default");
        if (mpwm != null && mpwm.isMiniPlayerActive(true)) {
            this.mSplash.secondPage.setOpenSound(false);
        }
        this.mOpenSound = this.mSplash.secondPage.getOpenSound();
        float sound = this.mOpenSound ? 1.0f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mMediaPlayer.setVolume(sound);
        super.onTriggerSecondPage(actionType);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showJumpView() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.mTextureView.setOnTouchListener(new OnClickTouchListener(context, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullVideoSplash$$ExternalSyntheticLambda0
            public final Object invoke() {
                return FullVideoSplash.this.m1536lambda$showJumpView$1$tvdanmakubiliuisplashadpageFullVideoSplash();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showJumpView$1$tv-danmaku-bili-ui-splash-ad-page-FullVideoSplash  reason: not valid java name */
    public /* synthetic */ Unit m1536lambda$showJumpView$1$tvdanmakubiliuisplashadpageFullVideoSplash() {
        SplashAdHelper.adSplashOutsideClick(this.mSplash);
        if (this.mSplash.isSplashClickable()) {
            onJumpClick(buildThirdIntent(this.mSplash.appLink, this.mSplash.appPkg), this.mSplash.appLink);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public void doBeforeAnimation() {
        if (this.mSplash.isEggVideoPlayed && this.eggPlayer != null) {
            setLastFrame(this.eggPlayer.getTextureView());
        } else {
            setLastFrame(this.mTextureView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public List<View> getAlphaView() {
        List<View> views = super.getAlphaView();
        if (this.mSplash.isEggVideoPlayed || this.topViewTransitionCanPlay) {
            views.add(this.mTextureView);
        }
        return views;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onTriggerSecondPageEggVideo() {
        if (this.mSplash.secondPageShowStyle == 3 && this.secondPageEggPlayer != null && this.mMediaPlayer != null) {
            this.mMediaPlayer.pause();
        }
    }
}