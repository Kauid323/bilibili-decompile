package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.ad.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.ui.splash.ad.page.PortVideoSplash;
import tv.danmaku.bili.ui.splash.ad.player.SplashIjkPlayerKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PortVideoSplash extends HalfImageSplash {
    private IjkMediaPlayer mMediaPlayer;
    private Surface mSurface;
    private TextureView mTextureView;

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showContent() {
        this.mSplashView.setVisibility(4);
        this.mTextureView = new TextureView(getContext());
        this.mTextureView.setSurfaceTextureListener(new AnonymousClass1(this));
        FrameLayout container = (FrameLayout) getView().findViewById(R.id.float_container);
        container.addView(this.mTextureView, 0, new FrameLayout.LayoutParams(-2, -2, 17));
        container.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.PortVideoSplash$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                PortVideoSplash.this.m1548lambda$showContent$0$tvdanmakubiliuisplashadpagePortVideoSplash(view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.splash.ad.page.PortVideoSplash$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        final /* synthetic */ PortVideoSplash val$fragment;

        AnonymousClass1(PortVideoSplash portVideoSplash) {
            this.val$fragment = portVideoSplash;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            PortVideoSplash.this.mSurface = new Surface(surface);
            Context context = PortVideoSplash.this.getApplicationContext();
            if (context == null) {
                return;
            }
            PortVideoSplash portVideoSplash = PortVideoSplash.this;
            Surface surface2 = PortVideoSplash.this.mSurface;
            String md5ToFileUri = BusinessSplashResHelperKt.md5ToFileUri(PortVideoSplash.this.mSplash.videoHash);
            final PortVideoSplash portVideoSplash2 = this.val$fragment;
            Function1 function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.PortVideoSplash$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return PortVideoSplash.AnonymousClass1.lambda$onSurfaceTextureAvailable$0(PortVideoSplash.this, (IjkMediaPlayer) obj);
                }
            };
            final PortVideoSplash portVideoSplash3 = this.val$fragment;
            portVideoSplash.mMediaPlayer = SplashIjkPlayerKt.createSplashIjkPlayer(context, surface2, md5ToFileUri, function1, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.page.PortVideoSplash$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return PortVideoSplash.AnonymousClass1.this.m1549lambda$onSurfaceTextureAvailable$1$tvdanmakubiliuisplashadpagePortVideoSplash$1(portVideoSplash3, (IjkMediaPlayer) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onSurfaceTextureAvailable$0(PortVideoSplash fragment, IjkMediaPlayer player) {
            PlayerReporterInitComponentKt.initPlayerReporter(fragment, player);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onSurfaceTextureAvailable$1$tv-danmaku-bili-ui-splash-ad-page-PortVideoSplash$1  reason: not valid java name */
        public /* synthetic */ Unit m1549lambda$onSurfaceTextureAvailable$1$tvdanmakubiliuisplashadpagePortVideoSplash$1(PortVideoSplash fragment, IjkMediaPlayer player) {
            if (PortVideoSplash.this.mSplashViewModel != null) {
                PlayerCallbackRegisterComponentKt.registerIjkPlayerStateCallback(fragment, player, PortVideoSplash.this.mSplashViewModel);
                return null;
            }
            return null;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            if (PortVideoSplash.this.mSurface != null) {
                PortVideoSplash.this.mSurface.release();
                PortVideoSplash.this.mSurface = null;
            }
            if (PortVideoSplash.this.mMediaPlayer != null) {
                PortVideoSplash.this.mMediaPlayer.release();
                PortVideoSplash.this.mMediaPlayer = null;
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showContent$0$tv-danmaku-bili-ui-splash-ad-page-PortVideoSplash  reason: not valid java name */
    public /* synthetic */ void m1548lambda$showContent$0$tvdanmakubiliuisplashadpagePortVideoSplash(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        int oldWidth = oldRight - oldLeft;
        int oldHeight = oldBottom - oldTop;
        int newWidth = right - left;
        int newHeight = bottom - top;
        if (newWidth == oldWidth && newHeight == oldHeight) {
            return;
        }
        adjustVideoSize(newWidth, newHeight);
    }

    private void adjustVideoSize(int containerWidth, int containerHeight) {
        int videoWith = containerWidth;
        int videoHeight = containerHeight;
        int hPadding = 0;
        int vPadding = 0;
        float wAspect = (videoWith * 1.0f) / this.mSplash.videoWidth;
        float hAspect = (videoHeight * 1.0f) / this.mSplash.videoHeight;
        if (wAspect > hAspect) {
            float actualVideoHeight = this.mSplash.videoHeight * wAspect;
            vPadding = (int) (((actualVideoHeight - videoHeight) / 2.0f) + 0.5f);
            videoHeight = (int) (0.5f + actualVideoHeight);
        } else {
            float actualVideoWith = this.mSplash.videoWidth * hAspect;
            hPadding = (int) (((actualVideoWith - videoWith) / 2.0f) + 0.5f);
            videoWith = (int) (0.5f + actualVideoWith);
        }
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mTextureView.getLayoutParams();
        param.width = videoWith;
        param.height = videoHeight;
        param.gravity = 17;
        this.mTextureView.setLayoutParams(param);
        this.mTextureView.setPadding(-hPadding, -vPadding, -hPadding, -vPadding);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public void doBeforeAnimation() {
        ViewGroup.LayoutParams layoutParams = this.mSplashView.getLayoutParams();
        layoutParams.height = this.mTextureView.getLayoutParams().height;
        this.mSplashView.setLayoutParams(layoutParams);
        this.mSplashView.setImageBitmap(this.mTextureView.getBitmap());
        this.mSplashView.setVisibility(0);
        this.mSplashView.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.PortVideoSplash$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PortVideoSplash.this.m1547lambda$doBeforeAnimation$1$tvdanmakubiliuisplashadpagePortVideoSplash();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doBeforeAnimation$1$tv-danmaku-bili-ui-splash-ad-page-PortVideoSplash  reason: not valid java name */
    public /* synthetic */ void m1547lambda$doBeforeAnimation$1$tvdanmakubiliuisplashadpagePortVideoSplash() {
        this.mTextureView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public ImageView getTransformView() {
        return this.mSplashView;
    }
}