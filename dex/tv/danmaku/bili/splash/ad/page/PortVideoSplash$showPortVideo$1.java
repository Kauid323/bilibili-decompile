package tv.danmaku.bili.splash.ad.page;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt;
import tv.danmaku.bili.splash.ad.player.SplashIjkPlayerKt;
import tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: PortVideoSplash.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"tv/danmaku/bili/splash/ad/page/PortVideoSplash$showPortVideo$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "", "onSurfaceTextureUpdated", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PortVideoSplash$showPortVideo$1 implements TextureView.SurfaceTextureListener {
    final /* synthetic */ PortVideoSplash this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PortVideoSplash$showPortVideo$1(PortVideoSplash $receiver) {
        this.this$0 = $receiver;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Surface face = new Surface(surface);
        this.this$0.videoSurface = face;
        Context ctx = this.this$0.getApplicationContext();
        if (ctx == null) {
            return;
        }
        PortVideoSplash portVideoSplash = this.this$0;
        String fetchResourceLocalUriPathByHash = BusinessSplashResHelperKt.fetchResourceLocalUriPathByHash(this.this$0.getSplash$adsplash_debug().getVideoHash());
        final PortVideoSplash portVideoSplash2 = this.this$0;
        Function1 function1 = new Function1() { // from class: tv.danmaku.bili.splash.ad.page.PortVideoSplash$showPortVideo$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onSurfaceTextureAvailable$lambda$0;
                onSurfaceTextureAvailable$lambda$0 = PortVideoSplash$showPortVideo$1.onSurfaceTextureAvailable$lambda$0(PortVideoSplash.this, (IjkMediaPlayer) obj);
                return onSurfaceTextureAvailable$lambda$0;
            }
        };
        final PortVideoSplash portVideoSplash3 = this.this$0;
        portVideoSplash.player = SplashIjkPlayerKt.createSplashIjkPlayer(ctx, face, fetchResourceLocalUriPathByHash, function1, new Function1() { // from class: tv.danmaku.bili.splash.ad.page.PortVideoSplash$showPortVideo$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onSurfaceTextureAvailable$lambda$1;
                onSurfaceTextureAvailable$lambda$1 = PortVideoSplash$showPortVideo$1.onSurfaceTextureAvailable$lambda$1(PortVideoSplash.this, (IjkMediaPlayer) obj);
                return onSurfaceTextureAvailable$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSurfaceTextureAvailable$lambda$0(PortVideoSplash this$0, IjkMediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PlayerReporterInitComponentKt.initPlayerReporter(this$0, player);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSurfaceTextureAvailable$lambda$1(PortVideoSplash this$0, IjkMediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PlayerCallbackRegisterComponentKt.registerIjkPlayerStateCallback((Fragment) this$0, player, this$0.getViewModel$adsplash_debug());
        return Unit.INSTANCE;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Surface surface2;
        IjkMediaPlayer ijkMediaPlayer;
        Intrinsics.checkNotNullParameter(surface, "surface");
        surface2 = this.this$0.videoSurface;
        if (surface2 != null) {
            surface2.release();
        }
        this.this$0.videoSurface = null;
        ijkMediaPlayer = this.this$0.player;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
        }
        this.this$0.player = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }
}