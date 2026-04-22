package tv.danmaku.bili.ui.splash.ad.page;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import tv.danmaku.bili.ui.splash.BuildConfig;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.mod.SplashModHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashPageFactory.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"createSplashPage", "Landroidx/fragment/app/Fragment;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashPageFactoryKt {
    public static final Fragment createSplashPage(Splash splash) {
        if (splash == null || (splash.isVideo() && SplashModHelper.getSIsX86Device())) {
            return null;
        }
        if (splash.isMiddlePageSplash()) {
            Fragment immersiveVideoSplashV2 = new ImmersiveVideoSplashV2();
            immersiveVideoSplashV2.setSplash(splash);
            return immersiveVideoSplashV2;
        }
        switch (splash.cardType) {
            case 14:
                Fragment fullImageSplash = new FullImageSplash();
                fullImageSplash.setSplash(splash);
                return fullImageSplash;
            case 15:
                Fragment halfImageSplash = new HalfImageSplash();
                halfImageSplash.setSplash(splash);
                return halfImageSplash;
            case 16:
                Fragment portVideoSplash = new PortVideoSplash();
                portVideoSplash.setSplash(splash);
                return portVideoSplash;
            case 39:
                Fragment fullVideoSplash = new FullVideoSplash();
                fullVideoSplash.setSplash(splash);
                return fullVideoSplash;
            case Splash.CARD_TYPE_STORY /* 109 */:
                Fragment storySplash = new StorySplash();
                storySplash.setSplash(splash);
                return storySplash;
            case Splash.CARD_TYPE_BANNER /* 152 */:
                Fragment bannerSplash = new BannerSplash();
                bannerSplash.setSplash(splash);
                return bannerSplash;
            default:
                if (BuildConfig.DEBUG) {
                    throw new IllegalArgumentException("unknown splash card type");
                }
                return null;
        }
    }
}