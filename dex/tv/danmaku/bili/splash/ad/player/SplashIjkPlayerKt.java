package tv.danmaku.bili.splash.ad.player;

import android.content.Context;
import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SplashIjkPlayer.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\tH\u0000¨\u0006\f"}, d2 = {"createSplashIjkPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "context", "Landroid/content/Context;", "surface", "Landroid/view/Surface;", "playUrl", "", "onInitPlayerReporter", "Lkotlin/Function1;", "", "onRegisterStateCallback", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashIjkPlayerKt {
    public static final IjkMediaPlayer createSplashIjkPlayer(Context context, Surface surface, String playUrl, Function1<? super IjkMediaPlayer, Unit> function1, Function1<? super IjkMediaPlayer, Unit> function12) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(function1, "onInitPlayerReporter");
        Intrinsics.checkNotNullParameter(function12, "onRegisterStateCallback");
        IjkMediaPlayer $this$createSplashIjkPlayer_u24lambda_u240 = new IjkMediaPlayer(context);
        $this$createSplashIjkPlayer_u24lambda_u240.setOption(4, "start-on-prepared", 1L);
        $this$createSplashIjkPlayer_u24lambda_u240.setDataSource(playUrl);
        $this$createSplashIjkPlayer_u24lambda_u240.setVolume(0.0f);
        $this$createSplashIjkPlayer_u24lambda_u240.setSurface(surface);
        $this$createSplashIjkPlayer_u24lambda_u240.prepareAsync();
        function1.invoke($this$createSplashIjkPlayer_u24lambda_u240);
        function12.invoke($this$createSplashIjkPlayer_u24lambda_u240);
        return $this$createSplashIjkPlayer_u24lambda_u240;
    }
}