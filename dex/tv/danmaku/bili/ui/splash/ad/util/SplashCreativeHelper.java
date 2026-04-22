package tv.danmaku.bili.ui.splash.ad.util;

import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.utils.SplashUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCreativeHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/util/SplashCreativeHelper;", "", "<init>", "()V", "TAG", "", "isOnlyImageCardType", "", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "isOnlyVideoCardType", "isImageVideoMixCardType", "isSplashDownloadEnable", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashCreativeHelper {
    public static final int $stable = 0;
    public static final SplashCreativeHelper INSTANCE = new SplashCreativeHelper();
    private static final String TAG = "[Splash]SplashCreativeHelper";

    private SplashCreativeHelper() {
    }

    @JvmStatic
    public static final boolean isOnlyImageCardType(Splash splash) {
        int cardType = splash != null ? splash.cardType : -1;
        return cardType == 14 || cardType == 15;
    }

    @JvmStatic
    public static final boolean isOnlyVideoCardType(Splash splash) {
        int cardType = splash != null ? splash.cardType : -1;
        return cardType == 16 || cardType == 39 || cardType == 109;
    }

    @JvmStatic
    public static final boolean isImageVideoMixCardType(Splash splash) {
        int cardType = splash != null ? splash.cardType : -1;
        return cardType == 152;
    }

    @JvmStatic
    public static final boolean isSplashDownloadEnable(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        if (SplashUtils.isWifiConnected()) {
            return true;
        }
        if (!splash.preLoadEnable) {
            BLog.e(TAG, splash.id + " download abort, cause enable_pre_download: false");
            return false;
        } else if (!SplashUtils.isMobileConnected()) {
            BLog.e(TAG, splash.id + " download abort, cause enable_pre_download: true, but network not 4G/5G");
            return false;
        } else {
            boolean isForeground = BiliContext.isVisible();
            if (!SplashUtils.isMobileConnected() || isForeground || splash.backDownloadEnable) {
                return true;
            }
            BLog.e(TAG, splash.id + " download abort, cause enable_background_download: false, isForeground: false, network: 4G/5G");
            return false;
        }
    }
}