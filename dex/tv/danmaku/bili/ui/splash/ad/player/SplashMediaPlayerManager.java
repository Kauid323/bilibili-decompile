package tv.danmaku.bili.ui.splash.ad.player;

import android.media.MediaPlayer;
import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: SplashMediaPlayerManager.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/player/SplashMediaPlayerManager;", "", "<init>", "()V", X86IjkRequest.POOL, "Landroid/media/MediaPlayer;", "getPlayer", "()Landroid/media/MediaPlayer;", "setPlayer", "(Landroid/media/MediaPlayer;)V", "shareData", "Ltv/danmaku/bili/ui/splash/ad/player/MiddlePageShareData;", "getShareData", "()Ltv/danmaku/bili/ui/splash/ad/player/MiddlePageShareData;", "setShareData", "(Ltv/danmaku/bili/ui/splash/ad/player/MiddlePageShareData;)V", "initPlayer", "videoPath", "", "onInitPlayerReporter", "Lkotlin/Function1;", "", "onRegisterStateCallback", "play", "playerSurface", "Landroid/view/Surface;", "release", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashMediaPlayerManager {
    private static MediaPlayer player;
    public static final SplashMediaPlayerManager INSTANCE = new SplashMediaPlayerManager();
    private static MiddlePageShareData shareData = new MiddlePageShareData();
    public static final int $stable = 8;

    private SplashMediaPlayerManager() {
    }

    public final MediaPlayer getPlayer() {
        return player;
    }

    public final void setPlayer(MediaPlayer mediaPlayer) {
        player = mediaPlayer;
    }

    public final MiddlePageShareData getShareData() {
        return shareData;
    }

    public final void setShareData(MiddlePageShareData middlePageShareData) {
        Intrinsics.checkNotNullParameter(middlePageShareData, "<set-?>");
        shareData = middlePageShareData;
    }

    public final MediaPlayer initPlayer(String videoPath, Function1<? super MediaPlayer, Unit> function1, Function1<? super MediaPlayer, Unit> function12) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(function1, "onInitPlayerReporter");
        Intrinsics.checkNotNullParameter(function12, "onRegisterStateCallback");
        MediaPlayer $this$initPlayer_u24lambda_u240 = new MediaPlayer();
        $this$initPlayer_u24lambda_u240.setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        $this$initPlayer_u24lambda_u240.setDataSource(videoPath);
        $this$initPlayer_u24lambda_u240.prepareAsync();
        function1.invoke($this$initPlayer_u24lambda_u240);
        function12.invoke($this$initPlayer_u24lambda_u240);
        player = $this$initPlayer_u24lambda_u240;
        MediaPlayer mediaPlayer = player;
        Intrinsics.checkNotNull(mediaPlayer);
        return mediaPlayer;
    }

    public final void play(Surface playerSurface) {
        Intrinsics.checkNotNullParameter(playerSurface, "playerSurface");
        MediaPlayer $this$play_u24lambda_u240 = player;
        if ($this$play_u24lambda_u240 != null) {
            $this$play_u24lambda_u240.setSurface(playerSurface);
        }
    }

    public final void release() {
        MediaPlayer mediaPlayer = player;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = player;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        player = null;
    }
}