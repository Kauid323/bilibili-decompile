package tv.danmaku.bili.splash.ad.page;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.component.HalfSplashComponentKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutHelperKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: PortVideoSplash.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/PortVideoSplash;", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "<init>", "()V", "videoContainerView", "Landroid/view/TextureView;", "getVideoContainerView$adsplash_debug", "()Landroid/view/TextureView;", "setVideoContainerView$adsplash_debug", "(Landroid/view/TextureView;)V", "videoSurface", "Landroid/view/Surface;", "player", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showMainMaterial", "showPortVideo", "adjustVideoSize", "containerWidth", "", "containerHeight", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PortVideoSplash extends BaseSplash {
    public static final int $stable = 8;
    private IjkMediaPlayer player;
    private TextureView videoContainerView;
    private Surface videoSurface;

    public final TextureView getVideoContainerView$adsplash_debug() {
        return this.videoContainerView;
    }

    public final void setVideoContainerView$adsplash_debug(TextureView textureView) {
        this.videoContainerView = textureView;
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        HalfSplashComponentKt.initHalfSplashContentContainer(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void showMainMaterial() {
        showPortVideo();
        if (ListDeviceInfoKt.isHdApp()) {
            getBinding$adsplash_debug().splashView.setVisibility(0);
            super.showMainMaterial();
        }
    }

    private final void showPortVideo() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        getBinding$adsplash_debug().splashView.setVisibility(4);
        this.videoContainerView = new TextureView(context);
        TextureView textureView = this.videoContainerView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(new PortVideoSplash$showPortVideo$1(this));
        }
        ViewGroup topContainer = getComponentHolder$adsplash_debug().getTopContainer();
        if (topContainer != null) {
            topContainer.addView(this.videoContainerView, 0, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        ViewGroup topContainer2 = getComponentHolder$adsplash_debug().getTopContainer();
        if (topContainer2 != null) {
            topContainer2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: tv.danmaku.bili.splash.ad.page.PortVideoSplash$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    PortVideoSplash.showPortVideo$lambda$0(PortVideoSplash.this, view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPortVideo$lambda$0(PortVideoSplash this$0, View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        TextureView textureView;
        int oldWidth = oldRight - oldLeft;
        int oldHeight = oldBottom - oldTop;
        int newWidth = right - left;
        int newHeight = bottom - top;
        if (newWidth == oldWidth && newHeight == oldHeight) {
            return;
        }
        if (ListDeviceInfoKt.isHdApp()) {
            float expectWidth = ((this$0.getSplash$adsplash_debug().getVideoWidth() * newHeight) * 1.0f) / this$0.getSplash$adsplash_debug().getVideoHeight();
            ViewGroup layer = this$0.getComponentHolder$adsplash_debug().getTopContainer();
            if (layer != null && (textureView = this$0.videoContainerView) != null) {
                textureView.setLayoutParams(SplashLayoutHelperKt.createMatchParentHeightLayoutParams(layer, (int) expectWidth));
                return;
            }
            return;
        }
        this$0.adjustVideoSize(newWidth, newHeight);
    }

    private final void adjustVideoSize(int containerWidth, int containerHeight) {
        int videoWith = containerWidth;
        int videoHeight = containerHeight;
        int hPadding = 0;
        int vPadding = 0;
        float wAspect = (videoWith * 1.0f) / getSplash$adsplash_debug().getVideoWidth();
        float hAspect = (videoHeight * 1.0f) / getSplash$adsplash_debug().getVideoHeight();
        if (wAspect > hAspect) {
            float actualVideoHeight = getSplash$adsplash_debug().getVideoHeight() * wAspect;
            vPadding = (int) (((actualVideoHeight - videoHeight) / 2) + 0.5f);
            videoHeight = (int) (0.5f + actualVideoHeight);
        } else {
            float actualVideoWith = getSplash$adsplash_debug().getVideoWidth() * hAspect;
            hPadding = (int) (((actualVideoWith - videoWith) / 2) + 0.5f);
            videoWith = (int) (0.5f + actualVideoWith);
        }
        TextureView textureView = this.videoContainerView;
        FrameLayout.LayoutParams $this$adjustVideoSize_u24lambda_u240 = null;
        ViewGroup.LayoutParams layoutParams = textureView != null ? textureView.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            $this$adjustVideoSize_u24lambda_u240 = layoutParams2;
            $this$adjustVideoSize_u24lambda_u240.width = videoWith;
            $this$adjustVideoSize_u24lambda_u240.height = videoHeight;
            $this$adjustVideoSize_u24lambda_u240.gravity = 17;
        }
        FrameLayout.LayoutParams param = $this$adjustVideoSize_u24lambda_u240;
        TextureView textureView2 = this.videoContainerView;
        if (textureView2 != null) {
            textureView2.setLayoutParams(param);
        }
        TextureView textureView3 = this.videoContainerView;
        if (textureView3 != null) {
            textureView3.setPadding(-hPadding, -vPadding, -hPadding, -vPadding);
        }
    }
}