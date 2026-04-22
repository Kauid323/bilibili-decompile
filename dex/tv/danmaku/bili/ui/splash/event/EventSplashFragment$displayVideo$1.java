package tv.danmaku.bili.ui.splash.event;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;

/* compiled from: EventSplashFragment.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"tv/danmaku/bili/ui/splash/event/EventSplashFragment$displayVideo$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureSizeChanged", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureUpdated", "onSurfaceTextureDestroyed", "", "onSurfaceTextureAvailable", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashFragment$displayVideo$1 implements TextureView.SurfaceTextureListener {
    final /* synthetic */ Resource $resource;
    final /* synthetic */ EventSplashFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventSplashFragment$displayVideo$1(EventSplashFragment $receiver, Resource $resource) {
        this.this$0 = $receiver;
        this.$resource = $resource;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Surface surface2;
        IjkMediaPlayer ijkMediaPlayer;
        Intrinsics.checkNotNullParameter(surface, "surface");
        surface2 = this.this$0.mSurface;
        if (surface2 != null) {
            surface2.release();
        }
        this.this$0.mSurface = null;
        ijkMediaPlayer = this.this$0.mPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
        }
        this.this$0.mPlayer = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
        r0 = r5.this$0.mPlayer;
     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        IjkMediaPlayer ijkMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2;
        IjkMediaPlayer ijkMediaPlayer3;
        IjkMediaPlayer ijkMediaPlayer4;
        IjkMediaPlayer ijkMediaPlayer5;
        IjkMediaPlayer ijkMediaPlayer6;
        IjkMediaPlayer ijkMediaPlayer7;
        Surface surface2;
        Intrinsics.checkNotNullParameter(surface, "surface");
        BLog.i("[EventSplash]EventSplashFragment", "onSurfaceTextureAvailable");
        this.this$0.mSurface = new Surface(surface);
        this.this$0.mPlayer = new IjkMediaPlayer(this.this$0.getApplicationContext());
        ijkMediaPlayer = this.this$0.mPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setOption(4, IjkOptionsHelper.k_start_on_prepared, 1L);
        }
        ijkMediaPlayer2 = this.this$0.mPlayer;
        if (ijkMediaPlayer2 != null) {
            ijkMediaPlayer2.setDataSource(this.$resource.getLocalResourcePath());
        }
        ijkMediaPlayer3 = this.this$0.mPlayer;
        if (ijkMediaPlayer3 != null) {
            ijkMediaPlayer3.setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        ijkMediaPlayer4 = this.this$0.mPlayer;
        if (ijkMediaPlayer4 != null) {
            surface2 = this.this$0.mSurface;
            ijkMediaPlayer4.setSurface(surface2);
        }
        ijkMediaPlayer5 = this.this$0.mPlayer;
        if (ijkMediaPlayer5 != null) {
            ijkMediaPlayer5.prepareAsync();
        }
        ijkMediaPlayer6 = this.this$0.mPlayer;
        if (ijkMediaPlayer6 != null) {
            ijkMediaPlayer6.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$displayVideo$1$$ExternalSyntheticLambda0
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
                public final void onPrepared(IMediaPlayer iMediaPlayer) {
                    BLog.i("[EventSplash]EventSplashFragment", "on prepared");
                }
            });
        }
        if (SplashConfigKt.getUseVideoRelativePosition() || ijkMediaPlayer7 == null) {
            return;
        }
        final EventSplashFragment eventSplashFragment = this.this$0;
        ijkMediaPlayer7.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$displayVideo$1$$ExternalSyntheticLambda1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2, Bundle bundle) {
                boolean onSurfaceTextureAvailable$lambda$1;
                onSurfaceTextureAvailable$lambda$1 = EventSplashFragment$displayVideo$1.onSurfaceTextureAvailable$lambda$1(EventSplashFragment.this, iMediaPlayer, i, i2, bundle);
                return onSurfaceTextureAvailable$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onSurfaceTextureAvailable$lambda$1(EventSplashFragment this$0, IMediaPlayer p0, int what, int extra, Bundle bundle) {
        if (what == 3) {
            this$0.mTimeToVideoPosition = TuplesKt.to(Long.valueOf(System.currentTimeMillis()), 0L);
            return true;
        }
        return true;
    }
}