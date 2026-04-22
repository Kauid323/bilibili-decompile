package tv.danmaku.bili.ui.splash.ad.core;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelper;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: SplashPreloadHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "needRePreloadOnPageCreate", "", "getLoadedResSplashList", "localData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "getResReadySplashListFromDisk", "", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashPreloadHelperKt {
    private static final String TAG = "[Splash]SplashPreloadHelper";

    public static final boolean needRePreloadOnPageCreate() {
        long now = System.currentTimeMillis();
        long expireTimeMs = SplashConfigKt.getSplashMaxPreloadExpireTimeMs();
        long preloadTimeMs = SplashCoreDataHolder.INSTANCE.getPreloadTimeMs();
        boolean preloadDataExpired = now - preloadTimeMs > expireTimeMs && SplashConfigKt.getSplashEnablePreloadExpireReload();
        if (preloadDataExpired) {
            BLog.i(TAG, "needRePreloadOnPageCreate, needPreload = true, now = " + now + ", preloadTimeMs = " + preloadTimeMs + ", timeoutMs = " + expireTimeMs);
            long timeDifference = (now - preloadTimeMs) / ((long) IjkMediaCodecInfo.RANK_MAX);
            SplashAdHelper.INSTANCE.reportPreloadDataExpired(timeDifference);
            SplashCustomReporterKt.reportPreloadDataExpired(timeDifference);
            SplashCoreDataHolder.INSTANCE.setPreloadTimeMs(System.currentTimeMillis());
        }
        return preloadDataExpired;
    }

    public static final String getLoadedResSplashList(SplashData localData) {
        List<Long> keepIds;
        Iterable savedResList = getResReadySplashListFromDisk(localData);
        List savedResIds = new ArrayList();
        Iterable $this$forEach$iv = savedResList;
        for (Object element$iv : $this$forEach$iv) {
            Splash splash = (Splash) element$iv;
            boolean z = false;
            if (localData != null && (keepIds = localData.getKeepIds()) != null && keepIds.contains(Long.valueOf(splash.id))) {
                z = true;
            }
            if (!z || !splash.isLocalExposed) {
                savedResIds.add(String.valueOf(splash.id));
            }
        }
        return CollectionsKt.joinToString$default(savedResIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final List<Splash> getResReadySplashListFromDisk(SplashData localData) {
        List localResReadySplashList = new ArrayList();
        if (localData == null) {
            return EnhancedUnmodifiabilityKt.unmodifiable(localResReadySplashList);
        }
        Iterable localSplashList = localData.getSplashList();
        List<Splash> list = (Collection) localSplashList;
        if (list == null || list.isEmpty()) {
            return EnhancedUnmodifiabilityKt.unmodifiable(localResReadySplashList);
        }
        Iterable $this$forEach$iv = localSplashList;
        for (Object element$iv : $this$forEach$iv) {
            Splash splash = (Splash) element$iv;
            boolean isImageReady = BusinessSplashResHelper.isResourceExistByHash(splash.imageHash);
            boolean isVideoReady = BusinessSplashResHelper.isResourceExistByHash(splash.videoHash);
            if (isImageReady && SplashCreativeHelper.isOnlyImageCardType(splash)) {
                localResReadySplashList.add(splash);
            } else if (isVideoReady && SplashCreativeHelper.isOnlyVideoCardType(splash)) {
                localResReadySplashList.add(splash);
            } else if (isImageReady && isVideoReady && SplashCreativeHelper.isImageVideoMixCardType(splash)) {
                localResReadySplashList.add(splash);
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(localResReadySplashList);
    }
}