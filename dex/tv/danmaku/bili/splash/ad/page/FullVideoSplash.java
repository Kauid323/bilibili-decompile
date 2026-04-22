package tv.danmaku.bili.splash.ad.page;

import android.content.Context;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerWindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.splash.ad.page.component.AlphaEggLayerComponentKt;
import tv.danmaku.bili.splash.ad.page.component.ComponentHolder;
import tv.danmaku.bili.splash.ad.page.component.TopViewTransitionComponentKt;
import tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.UiUtilsKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutHelperKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;
import tv.danmaku.bili.splash.ad.widget.SplashImageView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: FullVideoSplash.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/FullVideoSplash;", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "<init>", "()V", "videoContainerView", "Landroid/view/TextureView;", "getVideoContainerView$adsplash_debug", "()Landroid/view/TextureView;", "setVideoContainerView$adsplash_debug", "(Landroid/view/TextureView;)V", "videoSurface", "Landroid/view/Surface;", "player", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "getPlayer$adsplash_debug", "()Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "setPlayer$adsplash_debug", "(Ltv/danmaku/ijk/media/player/IjkMediaPlayer;)V", "backgroundView", "Ltv/danmaku/bili/splash/ad/widget/SplashImageView;", "showMainMaterial", "", "showVideo", "setSecondPageVolume", "onSoundButtonClicked", "onCountdownEnd", "onDetach", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullVideoSplash extends BaseSplash {
    public static final int $stable = 8;
    private SplashImageView backgroundView;
    private IjkMediaPlayer player;
    private TextureView videoContainerView;
    private Surface videoSurface;

    public final TextureView getVideoContainerView$adsplash_debug() {
        return this.videoContainerView;
    }

    public final void setVideoContainerView$adsplash_debug(TextureView textureView) {
        this.videoContainerView = textureView;
    }

    public final IjkMediaPlayer getPlayer$adsplash_debug() {
        return this.player;
    }

    public final void setPlayer$adsplash_debug(IjkMediaPlayer ijkMediaPlayer) {
        this.player = ijkMediaPlayer;
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void showMainMaterial() {
        Context ctx;
        showVideo();
        if (!ListDeviceInfoKt.isHdApp() || (ctx = getContext()) == null) {
            return;
        }
        SplashImageView $this$showMainMaterial_u24lambda_u240 = new SplashImageView(ctx);
        SplashContainerView root = getBinding$adsplash_debug().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewGroup.LayoutParams $this$showMainMaterial_u24lambda_u240_u240 = SplashLayoutUtilsKt.createMatchParentLayoutParams((ViewGroup) root);
        $this$showMainMaterial_u24lambda_u240_u240.width = 0;
        $this$showMainMaterial_u24lambda_u240_u240.height = 0;
        $this$showMainMaterial_u24lambda_u240.setLayoutParams($this$showMainMaterial_u24lambda_u240_u240);
        $this$showMainMaterial_u24lambda_u240.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.backgroundView = $this$showMainMaterial_u24lambda_u240;
        getBinding$adsplash_debug().getRoot().addView((View) this.backgroundView, 0);
        ViewInitComponentKt.displayMainImage(this, this.backgroundView);
    }

    private final void showVideo() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        SplashContainerView rootView = getBinding$adsplash_debug().getRoot();
        Intrinsics.checkNotNullExpressionValue(rootView, "getRoot(...)");
        getBinding$adsplash_debug().splashView.setVisibility(4);
        TextureView $this$showVideo_u24lambda_u240 = new TextureView(context);
        $this$showVideo_u24lambda_u240.setSurfaceTextureListener(new FullVideoSplash$showVideo$1$1(this));
        this.videoContainerView = $this$showVideo_u24lambda_u240;
        setFullScreenClickListener(this.videoContainerView);
        ViewGroup.LayoutParams videoLp = SplashLayoutHelperKt.createPinkHdCompatFullscreenVideoLayoutParams((ViewGroup) rootView, getSplash$adsplash_debug());
        rootView.addView(this.videoContainerView, 0, videoLp);
        TextureView textureView = this.videoContainerView;
        if (textureView != null) {
            textureView.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.FullVideoSplash$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FullVideoSplash.showVideo$lambda$1(FullVideoSplash.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showVideo$lambda$1(FullVideoSplash this$0) {
        TextureView tv2 = this$0.videoContainerView;
        if (tv2 == null) {
            return;
        }
        UiUtilsKt.centerCropVideo(tv2.getWidth(), tv2.getHeight(), this$0.getSplash$adsplash_debug().getVideoWidth(), this$0.getSplash$adsplash_debug().getVideoHeight(), tv2);
    }

    public final void setSecondPageVolume() {
        IMiniPlayerWindowManager iMiniPlayerWindowManager = (IMiniPlayerWindowManager) BLRouter.get$default(BLRouter.INSTANCE, IMiniPlayerWindowManager.class, (String) null, 2, (Object) null);
        boolean z = true;
        boolean isMiniPlayerActive = iMiniPlayerWindowManager != null ? iMiniPlayerWindowManager.isMiniPlayerActive(true) : false;
        ComponentHolder componentHolder$adsplash_debug = getComponentHolder$adsplash_debug();
        SplashSecondPageInfo secondPage = getSplash$adsplash_debug().getSecondPage();
        if (!(secondPage != null ? secondPage.getOpenSound() : false) || isMiniPlayerActive) {
            z = false;
        }
        componentHolder$adsplash_debug.setOpenSound(z);
        float sound = getComponentHolder$adsplash_debug().getOpenSound() ? 1.0f : 0.0f;
        IjkMediaPlayer ijkMediaPlayer = this.player;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setVolume(sound);
        }
    }

    public final void onSoundButtonClicked() {
        float sound;
        if (this.player == null) {
            return;
        }
        ComponentHolder $this$onSoundButtonClicked_u24lambda_u240 = getComponentHolder$adsplash_debug();
        $this$onSoundButtonClicked_u24lambda_u240.setOpenSound(!$this$onSoundButtonClicked_u24lambda_u240.getOpenSound());
        String type = $this$onSoundButtonClicked_u24lambda_u240.getOpenSound() ? "1" : "0";
        SplashAdHelper.INSTANCE.reportSecondPageSoundButtonClick$adsplash_debug(getSplash$adsplash_debug(), type);
        if ($this$onSoundButtonClicked_u24lambda_u240.getOpenSound()) {
            sound = 1.0f;
        } else {
            sound = 0.0f;
        }
        IjkMediaPlayer ijkMediaPlayer = this.player;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setVolume(sound);
        }
        if ($this$onSoundButtonClicked_u24lambda_u240.getOpenSound()) {
            $this$onSoundButtonClicked_u24lambda_u240.getAudioManager().requestFocus();
        } else {
            $this$onSoundButtonClicked_u24lambda_u240.getAudioManager().releaseFocus();
        }
    }

    @Override // tv.danmaku.bili.splash.ad.page.BaseSplash, tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onCountdownEnd() {
        if (!AlphaEggLayerComponentKt.triggerTransportEgg(this) && !TopViewTransitionComponentKt.triggerTopViewTransition(this)) {
            super.onCountdownEnd();
        }
    }

    public void onDetach() {
        super.onDetach();
        if (getComponentHolder$adsplash_debug().getOpenSound()) {
            getComponentHolder$adsplash_debug().getAudioManager().releaseFocus();
        }
    }
}