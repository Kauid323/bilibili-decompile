package tv.danmaku.bili.ui.splash.ad.core;

import android.util.LongSparseArray;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.SplashOrderFilterReason;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.StrategyNotSelectReason;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.ui.splash.ad.model.SplashSource;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelper;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SplashOrderSelectHelper.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u001aB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a8\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0000\u001a2\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0000\u001a:\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"TAG", "", "isValidBusinessSplash", "", "step", "", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "strategy", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowStrategy;", "index", "source", "Ltv/danmaku/bili/ui/splash/ad/model/SplashSource;", "realShow", "requestId", "isSceneSupport", "isSplashReachShowCountLimit", "maxCount", "isReachSplashShowLimit", "getValidResSplash", "resortRealTimeShowList", "", "fromRealShow", "splashList", "showStrategy", "expectTopViewId", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashOrderSelectHelperKt {
    private static final String TAG = "[Splash]SplashOrderSelectHelper";

    public static final boolean isValidBusinessSplash(int step, Splash splash, SplashShowStrategy strategy, int index, SplashSource source, boolean realShow, String requestId) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(source, "source");
        if (splash.id != strategy.getId()) {
            return false;
        }
        if (!realShow && DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() && splash.isTopView()) {
            BLog.i(TAG, "isValidBusinessSplash, mixExp not support local show topview");
            return false;
        } else if (!splash.isValid()) {
            BLog.i(TAG, "isValidBusinessSplash, splashId = " + splash.id + " time not valid");
            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.SPLASH_TIME_INVALID, source, realShow);
            SplashAdHelper.reportSplashOrderSelectFilterEvent$default(step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : index, requestId, source.getValue(), realShow, SplashOrderFilterReason.SPLASH_TIME_INVALID, null, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, null);
            return false;
        } else if (!isSceneSupport(splash, source)) {
            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.SPLASH_MISMATCH_SCENE, source, realShow);
            SplashAdHelper.reportSplashOrderSelectFilterEvent$default(step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : index, requestId, source.getValue(), realShow, SplashOrderFilterReason.SPLASH_MISMATCH_SCENE, null, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, null);
            return false;
        } else {
            return true;
        }
    }

    private static final boolean isSceneSupport(Splash splash, SplashSource source) {
        if (source == SplashSource.CALL_UP && !splash.supportCalledUp) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.id + " from callup but splash not support");
            return false;
        } else if (source == SplashSource.HOT && splash.isTopView() && SplashConfigKt.getDisableHotLaunchTopView()) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.id + " hot show topview disable");
            return false;
        } else if (source == SplashSource.HOT && splash.cardType == 109) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.id + " hot show not support story splash");
            return false;
        } else if (source == SplashSource.HOT && splash.isSearchLinkage()) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.id + " hot show not support search linkage splash");
            return false;
        } else if ((source == SplashSource.HOT || splash.cardType != 39) && splash.isMiddlePageSplash()) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.id + " hot show not support middle page splash");
            return false;
        } else {
            return true;
        }
    }

    public static final boolean isSplashReachShowCountLimit(Splash splash, SplashShowStrategy strategy, int index, SplashSource source, boolean realShow, int maxCount) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(source, "source");
        long lastShowTime = splash.lastExposeTime;
        Date lastShowDate = new Date(lastShowTime);
        Date today = new Date();
        if (!DateUtils.isSameDay(lastShowDate, today)) {
            splash.localExposeCount = 0;
        }
        boolean reachLimit = splash.localExposeCount >= maxCount;
        if (reachLimit) {
            BLog.i(TAG, "isSplashReachShowCountLimit, splashId = " + splash.id + " reach limit. maxCount = " + maxCount);
            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.REACH_MAX_SHOW_COUNT, source, realShow);
        }
        return reachLimit;
    }

    public static final boolean isReachSplashShowLimit(Splash $this$isReachSplashShowLimit, int maxCount) {
        int showCount;
        Intrinsics.checkNotNullParameter($this$isReachSplashShowLimit, "<this>");
        long lastShowTime = $this$isReachSplashShowLimit.lastExposeTime;
        Date lastShowDate = new Date(lastShowTime);
        Date today = new Date();
        if (!DateUtils.isSameDay(lastShowDate, today)) {
            showCount = 0;
        } else {
            showCount = $this$isReachSplashShowLimit.localExposeCount;
        }
        return showCount >= maxCount;
    }

    public static final Splash getValidResSplash(Splash splash, SplashShowStrategy strategy, int index, SplashSource source, boolean realShow) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(source, "source");
        File imageFile = BusinessSplashResHelper.fetchResourceFileByHash(splash.imageHash);
        File videoFile = BusinessSplashResHelper.fetchResourceFileByHash(splash.videoHash);
        if (imageFile == null && videoFile == null) {
            BLog.e(TAG, "splashId = " + splash.id + " image/video file not exist.");
        }
        if (SplashCreativeHelper.isOnlyImageCardType(splash) && imageFile != null) {
            splash.imageUrl = BusinessSplashDefine.FILE_URI_PREFIX + imageFile.getAbsolutePath();
        } else if (!SplashCreativeHelper.isOnlyVideoCardType(splash) || videoFile == null) {
            if (SplashCreativeHelper.isImageVideoMixCardType(splash) && videoFile != null && imageFile != null) {
                splash.imageUrl = BusinessSplashDefine.FILE_URI_PREFIX + imageFile.getAbsolutePath();
            } else {
                BLog.i(TAG, "getValidResSplash, splashId = " + splash.id + ", resource not ready");
                SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.RESOURCE_NOT_READY, source, realShow);
                return null;
            }
        }
        return splash;
    }

    public static final List<SplashShowStrategy> resortRealTimeShowList(boolean fromRealShow, List<? extends Splash> list, List<SplashShowStrategy> list2, long expectTopViewId) {
        List<Splash> splashList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List<SplashShowStrategy> showStrategy = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        Intrinsics.checkNotNullParameter(splashList, "splashList");
        Intrinsics.checkNotNullParameter(showStrategy, "showStrategy");
        List sortedStrategies = new ArrayList();
        if (!fromRealShow || SplashCoreDataHolder.INSTANCE.getTrustRealtimeShowTopView()) {
            BLog.i(TAG, "resortRealTimeShowList, fromRealShow = " + fromRealShow + ", trust realtime show = " + SplashCoreDataHolder.INSTANCE.getTrustRealtimeShowTopView());
            sortedStrategies.addAll(showStrategy);
            return EnhancedUnmodifiabilityKt.unmodifiable(sortedStrategies);
        }
        LongSparseArray topViewIds = new LongSparseArray();
        Object v = new Object();
        for (Splash splash : splashList) {
            if (splash.isTopView()) {
                topViewIds.put(splash.id, v);
            }
        }
        List temp = new ArrayList();
        for (SplashShowStrategy strategy : showStrategy) {
            if (topViewIds.get(strategy.getId()) != null) {
                sortedStrategies.add(strategy);
            } else {
                temp.add(strategy);
            }
        }
        if (expectTopViewId != 0) {
            Iterator it = sortedStrategies.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SplashShowStrategy strategy2 = (SplashShowStrategy) it.next();
                if (strategy2.getId() == expectTopViewId) {
                    temp.add(0, strategy2);
                    break;
                }
            }
            sortedStrategies.clear();
        }
        sortedStrategies.addAll(temp);
        return EnhancedUnmodifiabilityKt.unmodifiable(sortedStrategies);
    }
}