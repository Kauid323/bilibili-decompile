package tv.danmaku.bili.ui.splash;

import kotlin.Metadata;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashLite.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isResourcesReady", "", "Ltv/danmaku/bili/ui/splash/SplashLite;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashLiteKt {
    public static final boolean isResourcesReady(SplashLite $this$isResourcesReady) {
        if ($this$isResourcesReady == null) {
            return false;
        }
        int ct = $this$isResourcesReady.getCardType();
        Splash splash = new Splash();
        splash.cardType = ct;
        if (SplashCreativeHelper.isOnlyVideoCardType(splash)) {
            return $this$isResourcesReady.isVideoExists();
        }
        if (SplashCreativeHelper.isOnlyImageCardType(splash)) {
            return $this$isResourcesReady.isImageExists();
        }
        return SplashCreativeHelper.isImageVideoMixCardType(splash) && $this$isResourcesReady.isVideoExists() && $this$isResourcesReady.isImageExists();
    }
}