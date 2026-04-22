package tv.danmaku.bili.ui.splash.ad.model;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashEgg.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001a\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"isValid", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashEgg;", "(Ltv/danmaku/bili/ui/splash/ad/model/SplashEgg;)Z", "isEggSplash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "(Ltv/danmaku/bili/ui/splash/ad/model/Splash;)Z", "isTopViewTransitionType", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashEggKt {
    public static final boolean isValid(SplashEgg $this$isValid) {
        if ($this$isValid != null) {
            String videoHash = $this$isValid.getVideoHash();
            if (videoHash == null || StringsKt.isBlank(videoHash)) {
                return false;
            }
            String videoUrl = $this$isValid.getVideoUrl();
            return !(videoUrl == null || StringsKt.isBlank(videoUrl)) && $this$isValid.getDuration() > 0;
        }
        return false;
    }

    public static final boolean isEggSplash(Splash $this$isEggSplash) {
        return $this$isEggSplash != null && $this$isEggSplash.isTopView() && $this$isEggSplash.topViewType == SplashTopViewType.ALPHA_EGG.getType() && isValid($this$isEggSplash.splashEgg);
    }

    public static final boolean isTopViewTransitionType(Splash $this$isTopViewTransitionType) {
        return $this$isTopViewTransitionType != null && $this$isTopViewTransitionType.topViewType == SplashTopViewType.TRANSITION_MODE.getType();
    }
}