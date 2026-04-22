package tv.danmaku.bili.splash.ad.page;

import androidx.fragment.app.Fragment;
import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashPageFactory.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"createSplashPageInner", "Landroidx/fragment/app/Fragment;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashPageFactoryKt {
    public static final Fragment createSplashPageInner(SplashOrder splash) {
        if (splash == null || (ExtSplashOrderKt.isVideo(splash) && CpuUtils.isX86(BiliContext.application()))) {
            return null;
        }
        if (ExtSplashOrderKt.isMiddlePageSplash(splash)) {
            Fragment immersiveVideoSplash = new ImmersiveVideoSplash();
            immersiveVideoSplash.setSplash$adsplash_debug(splash);
            return immersiveVideoSplash;
        }
        switch (splash.getCardType()) {
            case 14:
                Fragment fullImageSplash = new FullImageSplash();
                fullImageSplash.setSplash$adsplash_debug(splash);
                return fullImageSplash;
            case 15:
                Fragment halfImageSplash = new HalfImageSplash();
                halfImageSplash.setSplash$adsplash_debug(splash);
                return halfImageSplash;
            case 16:
                Fragment portVideoSplash = new PortVideoSplash();
                portVideoSplash.setSplash$adsplash_debug(splash);
                return portVideoSplash;
            case 39:
                Fragment fullVideoSplash = new FullVideoSplash();
                fullVideoSplash.setSplash$adsplash_debug(splash);
                return fullVideoSplash;
            case 109:
                Fragment storySplash = new StorySplash();
                storySplash.setSplash$adsplash_debug(splash);
                return storySplash;
            case 152:
                Fragment bannerSplash = new BannerSplash();
                bannerSplash.setSplash$adsplash_debug(splash);
                return bannerSplash;
            default:
                if (SplashUtilsKt.isDebug()) {
                    throw new IllegalArgumentException("unknown splash card type");
                }
                return null;
        }
    }
}