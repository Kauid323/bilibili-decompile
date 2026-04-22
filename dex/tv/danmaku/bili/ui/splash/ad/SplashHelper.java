package tv.danmaku.bili.ui.splash.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.LongSparseArray;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.StringUtils;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.globalactions.TopViewIdsUpdateAction;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.performance.DLog;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResDownloadRequest;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.moduleservice.splash.SplashCoreService;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.xpref.Xpref;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.SplashOrderFilterReason;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.splash.ad.core.SplashCoreDataHolder;
import tv.danmaku.bili.ui.splash.ad.core.SplashOrderSelectHelperKt;
import tv.danmaku.bili.ui.splash.ad.core.SplashPreloadHelperKt;
import tv.danmaku.bili.ui.splash.ad.core.SplashUpdateComponentKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashNotShowReason;
import tv.danmaku.bili.ui.splash.ad.customreporter.StrategyNotSelectReason;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.ad.model.SplashDataKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashPeakTask;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowData;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.ui.splash.ad.model.SplashSource;
import tv.danmaku.bili.ui.splash.ad.model.SplashTaskResult;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivity;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivityKt;
import tv.danmaku.bili.ui.splash.ad.service.SplashServiceHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.SplashLocalInfoHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashStateStorageHelperKt;
import tv.danmaku.bili.ui.splash.utils.FastJsonUtilKt;
import tv.danmaku.bili.ui.splash.utils.SplashAESUtils;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.utils.SplashUtils;
import tv.danmaku.bili.ui.splash.utils.SplashUtilsKt;

public class SplashHelper {
    private static final String DIR_SPLASH = "splash2";
    private static final String ENCRYPTED_FILE_CONFIG = "splash.data";
    private static final String FILE_CONFIG = "splash.json";
    public static final String PREF_KEY_HOT_SHOW_INTERVAL = "splash_hot_show_interval";
    public static final String PREF_KEY_LAST_SHOW_TIME = "last_splash_show_time";
    private static final int SHOW_STATE_LIMIT_OR_NOT_EXIT = 4;
    private static final int SHOW_STATE_NOT_PRESENT = 3;
    private static final int SHOW_STATE_NO_CONFIG = 1;
    private static final int SHOW_STATE_NO_STRATEGY = 2;
    private static final int SHOW_STATE_SUCCESS = 5;
    private static final int SHOW_STRATEGY_REQUEST_NONE = -1;
    public static final String TAG = "[Splash]SplashHelper";
    private static volatile Splash mRealtimeSplash;
    private static Future<Splash> mRealtimeSplashTask;
    private static Future<SplashTaskResult> mRequestShowSplashTask;
    private static Future<SplashTaskResult> mSplashTask;
    public static volatile SplashNotShowReason notShowReason;
    private static final Object CONFIG_SYNC_LOCK = new Object();
    private static volatile int mRequestedNewStrategyCount = -1;
    private static int sShowState = 2;
    private static int sRequestShowState = 2;
    private static volatile long mPreloadStartTime = 0;
    private static Runnable sDelayUpdateRunnable = null;
    private static volatile boolean sRefreshSplashDataTaskFinished = true;
    private static long sLastRequestTime = 0;

    public static boolean trustRealtimeShowTopView() {
        return SplashCoreDataHolder.INSTANCE.getTrustRealtimeShowTopView();
    }

    public static void preloadSplashData() {
        SplashCustomReporterKt.reportAppLaunch(false);
        BusinessSplashResHelper.registerPeakDownloadListener();
        Log.d(TAG, "Schedule a task to preload splash data async.");
        mPreloadStartTime = System.currentTimeMillis();
        SplashCoreDataHolder.INSTANCE.setPreloadTimeMs(mPreloadStartTime);
        mSplashTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SplashHelper.lambda$preloadSplashData$0();
            }
        });
        SplashUpdateComponentKt.observerAppVisibleChange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SplashTaskResult lambda$preloadSplashData$0() throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            try {
                BLog.i(TAG, "Begin preload splash data async.");
                return loadSplashForShow(true, SplashSource.COLD);
            } catch (Exception e) {
                BLog.w(TAG, "preload splash data failure!", e);
                SplashCustomReporterKt.reportSplashPreloadTime(System.currentTimeMillis() - startTime);
                return null;
            }
        } finally {
            SplashCustomReporterKt.reportSplashPreloadTime(System.currentTimeMillis() - startTime);
        }
    }

    public static void releasePreload() {
        BLog.i(TAG, "releasePreload");
        if (mSplashTask != null) {
            mSplashTask.cancel(true);
            mSplashTask = null;
        }
        if (mRequestShowSplashTask != null) {
            mRequestShowSplashTask.cancel(true);
            mRequestShowSplashTask = null;
        }
        if (mRealtimeSplashTask != null) {
            mRealtimeSplashTask.cancel(true);
            mRealtimeSplashTask = null;
        }
        mRequestedNewStrategyCount = -1;
        SplashCoreDataHolder.INSTANCE.clearPreloadData();
    }

    public static boolean isNeedRePreloadOnPageCreate() {
        return SplashPreloadHelperKt.needRePreloadOnPageCreate();
    }

    public static Splash getSplashForShow(SplashSource source, boolean rePreload) {
        BLog.i(TAG, "getSplashForShow, source = " + source.getValue());
        DLog.d(TAG, "getSplashForShow, source = " + source.getValue());
        if (source == SplashSource.CALL_UP) {
            SplashData preloadData = SplashCoreDataHolder.INSTANCE.getPreloadSplashData();
            if (preloadData == null) {
                return null;
            }
            Splash splash = findTheOne(preloadData, SplashCoreDataHolder.INSTANCE.getShowStrategyList(), false, source, SplashCoreDataHolder.INSTANCE.getSplashRequestId());
            if (splash != null) {
                splash.splashRequestId = SplashCoreDataHolder.INSTANCE.getSplashRequestId();
                if (TextUtils.isEmpty(splash.splashRequestId)) {
                    BLog.e(TAG, "getSplashForShow, call up splash requestId miss");
                }
                splash.isFromCalledUp = true;
            }
            SplashCoreDataHolder.INSTANCE.clearPreloadData();
            return splash;
        }
        SplashTaskResult result = null;
        if (mSplashTask != null && source != SplashSource.HOT) {
            boolean isDone = mSplashTask.isDone();
            if (!isDone) {
                SplashCustomReporterKt.reportLocalShowSplashNotReady();
            }
            if (isDone || (!SplashConfigKt.getSplashLocalSelectAnrFix() && !mSplashTask.isCancelled())) {
                try {
                    result = mSplashTask.get();
                } catch (InterruptedException | ExecutionException e) {
                    BLog.e(TAG, e);
                }
            }
            mSplashTask = null;
        } else {
            Log.d(TAG, "Begin load splash data sync.");
            result = loadSplashForShow(rePreload, source);
        }
        if (result == null) {
            return null;
        }
        return result.getSplash();
    }

    public static Splash getSplashForShow(SplashSource source) {
        return getSplashForShow(source, false);
    }

    public static Splash getRealtimeSplash(SplashSource source) {
        BLog.i(TAG, "getRealtimeSplash, endTime to get realtime splash");
        if (mPreloadStartTime != 0) {
            SplashCustomReporterKt.reportSplashTotalRequestTime(System.currentTimeMillis() - mPreloadStartTime);
        }
        if (SplashConfigKt.getRealtimeSplashEnable()) {
            if (mRealtimeSplashTask != null && mRealtimeSplashTask.isDone()) {
                try {
                    Splash splash = mRealtimeSplashTask.get();
                    if (splash != null) {
                        SplashAdHelper.adSplashRealtimeFinishUIEvent(splash);
                        SplashCustomReporterKt.reportRealtimeDownloadSuccess(splash);
                        AdReporterKt.reportAd(0, splash, splash.id, splash.originRealTimeShowIndex, splash.splashRequestId, source.getValue(), true, SplashOrderFilterReason.SELECTED, null);
                        mRealtimeSplash = null;
                        return splash;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    BLog.e(TAG, e);
                }
            }
            if (mRealtimeSplashTask != null) {
                SplashAdHelper.adSplashRealtimeFailUIEvent(mRealtimeSplash);
                SplashCustomReporterKt.reportRealtimeDownloadFailed(mRealtimeSplash);
                Splash realtimeSplash = mRealtimeSplash;
                if (realtimeSplash != null) {
                    AdReporterKt.reportAd(0, realtimeSplash, realtimeSplash.id, realtimeSplash.originRealTimeShowIndex, realtimeSplash.splashRequestId, source.getValue(), true, SplashOrderFilterReason.RESOURCE_NOT_READY, null);
                }
            }
            mRealtimeSplash = null;
            return null;
        }
        return null;
    }

    public static SplashTaskResult getRequestedShowSplash() {
        if (SplashConfigKt.getEnableRequestSplashShow()) {
            SplashTaskResult result = null;
            if (mRequestShowSplashTask != null && mRequestShowSplashTask.isDone()) {
                try {
                    result = mRequestShowSplashTask.get();
                } catch (InterruptedException | ExecutionException e) {
                    BLog.e(TAG, "getRequestedShowSplash", e);
                }
                reportSplashShowRequestUiEvent(mRequestedNewStrategyCount);
                mRequestShowSplashTask = null;
            } else {
                reportSplashShowRequestUiEvent(-1L);
            }
            if (result == null) {
                SplashCustomReporterKt.reportShowRequestFailed();
            } else {
                SplashCustomReporterKt.reportShowRequestSuccess();
            }
            if (result != null && mRequestedNewStrategyCount > 0) {
                return result;
            }
            if (SplashConfigKt.getRealTimeShowListEmptyEnable() && result != null && mRequestedNewStrategyCount == 0) {
                notShowReason = SplashNotShowReason.SHOW_FORBID;
                return result;
            }
            return null;
        }
        return null;
    }

    private static void reportSplashShowRequestUiEvent(long size) {
        if (sRequestShowState == 1) {
            return;
        }
        BLog.d(TAG, "splash code request size = " + size);
        SplashAdHelper.adSplashCodeRequestUIEvent(size);
    }

    private static SplashTaskResult loadSplashForShow(boolean preload, final SplashSource source) {
        DLog.d(TAG, "loadSplashForShow, preload  " + preload + "source " + source.getValue());
        Splash splash = null;
        final SplashData splashData = readConfigFromDisk();
        if (splashData != null) {
            if (preload) {
                SplashCoreDataHolder.INSTANCE.setPreloadSplashData(splashData);
            }
            updateHotSplashInterval(splashData);
            splash = findTheOne(splashData, splashData.getStrategyList(), false, source, splashData.getSplashRequestId());
            if (splash != null) {
                splash.splashRequestId = splashData.getSplashRequestId();
                sShowState = 5;
            } else if (!SplashNotShowReason.NO_RES.equals(notShowReason) && !SplashNotShowReason.SHOW_COUNT_LIMIT.equals(notShowReason)) {
                notShowReason = SplashNotShowReason.LOCAL_SHOW_FORBID;
            }
            if (preload && SplashConfigKt.getEnableRequestSplashShow()) {
                final long startTime = System.currentTimeMillis();
                mRequestShowSplashTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda5
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return SplashHelper.lambda$loadSplashForShow$1(SplashSource.this, splashData, startTime);
                    }
                });
                if (!DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() && (splash == null || !splash.hasTopViewLinkedCard())) {
                    SplashCoreDataHolder.INSTANCE.initTrustedPegasusTopViewList();
                    SplashViewModel.Companion.update(new TopViewIdsUpdateAction(SplashCoreDataHolder.INSTANCE.getTrustedPegasusTopViewIds()));
                }
            }
        } else {
            sShowState = 1;
            sRequestShowState = 1;
            notShowReason = SplashNotShowReason.NO_LOCAL_DATA;
        }
        BLog.ifmt(TAG, "Finish loading splash for show. SplashData(%s), splash(%s), showState(%s)", new Object[]{Boolean.valueOf(splashData != null), Boolean.valueOf(splash != null), Integer.valueOf(sShowState)});
        return new SplashTaskResult(splashData, splash, null, splashData != null ? splashData.getSplashRequestId() : "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SplashTaskResult lambda$loadSplashForShow$1(SplashSource source, SplashData splashData, long startTime) throws Exception {
        BLog.i(TAG, "request show success");
        String topviewIds = null;
        try {
            if (DDConfig.INSTANCE.getSplashTopViewBannerMixinExp()) {
                long topViewIdsStartTime = System.currentTimeMillis();
                topviewIds = SplashCoreDataHolder.INSTANCE.getValidTopViewIds();
                BLog.i(TAG, "loadSplashForShow, getIds cost " + (System.currentTimeMillis() - topViewIdsStartTime));
            }
            SplashShowData showData = findSplashShowList(topviewIds);
            List<SplashShowStrategy> showStrategyList = null;
            if (showData != null) {
                showStrategyList = showData.getStrategyList();
            }
            String splashRequestId = showData != null ? showData.getSplashRequestId() : "";
            SplashCoreDataHolder.INSTANCE.setShowStrategyList(showStrategyList);
            int splashCount = handleRealTimeSplashLoad(showStrategyList, splashRequestId, source);
            long selectStartTime = System.currentTimeMillis();
            Splash requestSplash = findTheOne(splashData, showStrategyList, true, source, splashRequestId);
            long selectCostTime = System.currentTimeMillis() - selectStartTime;
            if (requestSplash != null && showData != null) {
                requestSplash.splashRequestId = splashRequestId;
                requestSplash.bindBanner = getShowBanner(requestSplash.id, showStrategyList);
                sRequestShowState = 5;
            } else if (!SplashNotShowReason.NO_RES.equals(notShowReason) && !SplashNotShowReason.SHOW_COUNT_LIMIT.equals(notShowReason)) {
                notShowReason = SplashNotShowReason.SHOW_FORBID;
            }
            BLog.ifmt(TAG, "Finish request splash for show. SplashData(%s), splash(%s), sRequestShowState(%s)", new Object[]{true, Boolean.valueOf(requestSplash != null), Integer.valueOf(sRequestShowState)});
            SplashCustomReporterKt.reportShowRequestTime(System.currentTimeMillis() - startTime, showStrategyList != null ? showStrategyList.size() : 0, splashCount, selectCostTime);
            return new SplashTaskResult(splashData, requestSplash, showStrategyList, splashRequestId);
        } catch (Exception e) {
            Log.w(TAG, "preload splash data failure!", e);
            return null;
        }
    }

    private static String getShowBanner(long id, List<SplashShowStrategy> showStrategyList) {
        if (showStrategyList == null || showStrategyList.isEmpty()) {
            return null;
        }
        for (SplashShowStrategy strategy : showStrategyList) {
            if (strategy.getId() == id && strategy.getBanner() != null) {
                return strategy.getBanner().toJSONString();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int handleRealTimeSplashLoad(List<SplashShowStrategy> showStrategyList, String splashRequestId, SplashSource source) {
        int splashCount = 0;
        if (SplashConfigKt.getRealtimeSplashEnable() && showStrategyList != null) {
            if (!showStrategyList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i >= showStrategyList.size()) {
                        break;
                    }
                    SplashShowStrategy strategy = showStrategyList.get(i);
                    Splash splashContent = null;
                    if (strategy != null && strategy.isValid()) {
                        Splash splashContent2 = strategy.getSplashContent();
                        splashContent = splashContent2;
                        if (splashContent2 != null) {
                            if (!splashContent.isValid()) {
                                Splash splashContent3 = splashContent;
                                if (strategy != null && splashContent3 != null) {
                                    AdReporterKt.reportAd(0, null, strategy.getId(), i, splashRequestId, source.getValue(), true, strategy.isValid() ? SplashOrderFilterReason.STRATEGY_TIME_INVALID : SplashOrderFilterReason.SPLASH_TIME_INVALID, strategy.getAdCb());
                                }
                                i++;
                            } else {
                                if (SplashUtils.isWifiConnected()) {
                                    splashContent.networkType = Splash.NETWORK_WIFI;
                                } else {
                                    splashContent.networkType = Splash.NETWORK_MOBILE;
                                }
                                splashContent.originRealTimeShowIndex = i;
                                if (!TextUtils.isEmpty(strategy.getAdCb())) {
                                    splashContent.adCb = strategy.getAdCb();
                                }
                                splashContent.splashRequestId = splashRequestId;
                                splashContent.bindBanner = getShowBanner(splashContent.id, showStrategyList);
                                downloadRealtimeSplash(splashContent);
                            }
                        }
                    }
                    Splash splashContent32 = splashContent;
                    if (strategy != null) {
                        AdReporterKt.reportAd(0, null, strategy.getId(), i, splashRequestId, source.getValue(), true, strategy.isValid() ? SplashOrderFilterReason.STRATEGY_TIME_INVALID : SplashOrderFilterReason.SPLASH_TIME_INVALID, strategy.getAdCb());
                    }
                    i++;
                }
                for (SplashShowStrategy str : showStrategyList) {
                    if (str.getSplashContent() != null) {
                        splashCount++;
                    }
                }
                return splashCount;
            }
        }
        return 0;
    }

    private static void downloadRealtimeSplash(final Splash splash) {
        if (mRequestShowSplashTask == null || mRequestShowSplashTask.isCancelled()) {
            BLog.i(TAG, "download task was canceled");
            return;
        }
        String imageUrl = splash.imageUrl;
        String videoUrl = splash.videoUrl;
        boolean isValidImageSplash = false;
        boolean isValidVideoSplash = splash.isVideo() && !TextUtils.isEmpty(videoUrl);
        if (!splash.isVideo() && !TextUtils.isEmpty(imageUrl)) {
            isValidImageSplash = true;
        }
        if (!isValidVideoSplash && !isValidImageSplash) {
            BLog.i(TAG, "invalid real splash isVideo:" + splash.isVideo());
            SplashCustomReporterKt.reportRealtimeDownloadError(splash, "splash_not_valid");
            return;
        }
        splash.isRealTimeSplash = true;
        mRealtimeSplash = splash;
        final long startTime = System.currentTimeMillis();
        BLog.i(TAG, "start download realtime splash");
        mRealtimeSplashTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SplashHelper.lambda$downloadRealtimeSplash$3(Splash.this, startTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Splash lambda$downloadRealtimeSplash$3(final Splash splash, long startTime) throws Exception {
        Splash realtimeSplash;
        try {
            BLog.i(TAG, "downloadRealtimeSplash, splashId = " + splash.id);
            if (splash.isVideo()) {
                realtimeSplash = handleRealtimeSplashVideoTypeDownload(splash, startTime);
            } else {
                realtimeSplash = handleRealtimeSplashImageTypeDownload(splash, startTime);
            }
            if (realtimeSplash == null) {
                return null;
            }
            Splash realtimeSplash2 = handleRealtimeEggVideoTypeDownload(realtimeSplash, System.currentTimeMillis());
            if (mRealtimeSplashTask != null && !mRealtimeSplashTask.isCancelled()) {
                Task.BACKGROUND_EXECUTOR.submit(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashHelper.lambda$downloadRealtimeSplash$2(Splash.this);
                    }
                });
                BLog.i(TAG, "realtime splash download success");
                return realtimeSplash2;
            }
            BLog.i(TAG, "realtime splash download timeout");
            return null;
        } catch (Exception e) {
            SplashCustomReporterKt.reportRealtimeDownloadError(splash, "exception occur", e);
            BLog.i(TAG, "download real splash failed", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$downloadRealtimeSplash$2(Splash splash) {
        BusinessSplashResHelper.downloadButtonRes(splash.splashGuideButton, splash.splashType);
        BusinessSplashResHelper.downloadMainLogo(splash.logoUrl, splash.logoHash, splash.splashType);
    }

    private static Splash handleRealtimeSplashImageTypeDownload(Splash splash, long startTime) throws Exception {
        long bytesSize;
        File file = BusinessSplashResHelper.fetchResourceFileByHash(splash.imageHash);
        boolean fromCache = false;
        if (file != null) {
            splash.imageUrl = BusinessSplashDefine.FILE_URI_PREFIX + file.getAbsolutePath();
            fromCache = true;
            bytesSize = file.length();
            BLog.i(TAG, "get realtime splash resource from cache");
        } else {
            String imageUrl = splash.imageUrl;
            if (imageUrl != null) {
                BLog.i(TAG, "get realtime splash resource from network");
                ResponseBody body = OkHttpClientWrapper.get().newCall(new Request.Builder().url(imageUrl).build()).execute().body();
                if (body == null) {
                    SplashCustomReporterKt.reportRealtimeDownloadError(splash, "response_invalid");
                    return null;
                }
                byte[] bytes = body.bytes();
                if (!TextUtils.isEmpty(splash.imageHash)) {
                    MessageDigest digest = MessageDigest.getInstance("MD5");
                    digest.update(bytes);
                    String md5 = StringUtils.toHexString(digest.digest());
                    if (splash.imageHash != null && !splash.imageHash.equals(md5)) {
                        BLog.i(TAG, "download realtime splash failed md5 not match");
                        SplashCustomReporterKt.reportRealtimeDownloadError(splash, "md5 not match");
                        return null;
                    }
                }
                long bytesSize2 = bytes.length;
                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                if (bmp == null) {
                    BLog.i(TAG, "download realtime splash failed bmp is null");
                    SplashCustomReporterKt.reportRealtimeDownloadError(splash, "bitmap decode error");
                    return null;
                }
                splash.realTimeSplashBitmap = bmp;
                splash.imageFrom = "realtime";
                bytesSize = bytesSize2;
            } else {
                return null;
            }
        }
        splash.localSplashImageSize = bytesSize / 1024;
        SplashCustomReporterKt.reportRealtimeDownloadTime(splash, System.currentTimeMillis() - startTime, fromCache, (int) (bytesSize / 1024));
        return splash;
    }

    private static Splash handleRealtimeSplashVideoTypeDownload(Splash splash, long startTime) {
        File file = BusinessSplashResHelper.fetchResourceFileByHash(splash.videoHash);
        boolean fromCache = false;
        if (file != null) {
            fromCache = true;
            BLog.i(TAG, "handleRealtimeSplashVideoTypeDownload, get realtime splash resource from cache");
        } else {
            boolean success = ResManager.downloadSync(new ResDownloadRequest(splash.videoUrl, splash.videoHash).md5(splash.videoHash).downloadTag("realtime_splash_video").bizType(DownloadBizType.Splash));
            BLog.i(TAG, "handleRealtimeSplashVideoTypeDownload, get realtime splash resource from net, success = " + success);
            if (!success || (file = BusinessSplashResHelper.fetchResourceFileByHash(splash.videoHash)) == null) {
                return null;
            }
            splash.videoFrom = "realtime";
        }
        splash.localSplashVideoSize = file.length() / 1024;
        SplashCustomReporterKt.reportRealtimeDownloadTime(splash, System.currentTimeMillis() - startTime, fromCache, (int) (file.length() / 1024));
        return splash;
    }

    private static Splash handleRealtimeEggVideoTypeDownload(Splash splash, long startTime) {
        if (splash.secondPage == null) {
            return splash;
        }
        String videoHash = splash.secondPage.getSecondVideoHash();
        String videoUrl = splash.secondPage.getSecondVideoUrl();
        if (videoUrl.isEmpty() || videoHash.isEmpty()) {
            return splash;
        }
        File file = BusinessSplashResHelper.fetchResourceFileByHash(videoHash);
        boolean fromCache = false;
        if (file != null) {
            splash.secondPage.setSecondVideoUrl(BusinessSplashDefine.FILE_URI_PREFIX + file.getAbsolutePath());
            fromCache = true;
            BLog.i(TAG, "handleRealtimeSplashVideoTypeDownload, get realtime splash resource from cache");
        } else {
            boolean success = ResManager.downloadSync(new ResDownloadRequest(videoUrl, videoHash).md5(videoHash).downloadTag("realtime_splash_egg_video").bizType(DownloadBizType.Splash));
            BLog.i(TAG, "handleRealtimeSplashVideoTypeDownload, get realtime splash resource from net, success = " + success);
            if (success && (file = BusinessSplashResHelper.fetchResourceFileByHash(splash.videoHash)) != null) {
                splash.secondPage.setSecondVideoUrl(BusinessSplashDefine.FILE_URI_PREFIX + file.getAbsolutePath());
            } else {
                return null;
            }
        }
        SplashCustomReporterKt.reportRealtimeDownloadTime(splash, System.currentTimeMillis() - startTime, fromCache, (int) (file.length() / 1024));
        return splash;
    }

    private static Splash findTheOne(SplashData splashData, List<SplashShowStrategy> showStrategy, boolean fromRealShow, SplashSource source, String splashRequestId) {
        return findTheOne(splashData, showStrategy, fromRealShow, source, 0L, splashRequestId);
    }

    public static Splash getShowSplashByTopView(SplashTaskResult result, Long expectTopViewId) {
        if (result == null) {
            return null;
        }
        SplashData splashData = result.getSplashData();
        List<SplashShowStrategy> showStrategy = result.getRealTimeShowStrategies();
        if (splashData == null) {
            return null;
        }
        return findTheOne(splashData, showStrategy, true, SplashSource.COLD, expectTopViewId.longValue(), result.getRequestId());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0309  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Splash findTheOne(final SplashData splashData, List<SplashShowStrategy> showStrategy, boolean fromRealShow, SplashSource source, long expectTopViewId, String splashRequestId) {
        String str;
        boolean z;
        int i;
        int step;
        List<SplashShowStrategy> sortedStrategies;
        boolean needUpdateConfig;
        int strategyIndex;
        List<SplashShowStrategy> sortedStrategies2;
        boolean z2;
        String str2;
        int strategyIndex2;
        boolean strategyIdFound;
        boolean z3;
        String str3;
        SplashShowStrategy strategy;
        boolean z4 = fromRealShow;
        String str4 = TAG;
        if (showStrategy == null || showStrategy.isEmpty()) {
            str = TAG;
            z = z4;
        } else if (splashData.getSplashList() != null) {
            if (!z4) {
                i = 1;
            } else if (expectTopViewId != 0) {
                step = 3;
                sortedStrategies = SplashOrderSelectHelperKt.resortRealTimeShowList(z4, splashData.getSplashList(), showStrategy, expectTopViewId);
                changeShowState(z4, 3);
                needUpdateConfig = false;
                strategyIndex = 0;
                while (strategyIndex < sortedStrategies.size()) {
                    SplashShowStrategy strategy2 = sortedStrategies.get(strategyIndex);
                    if (!strategy2.isValid()) {
                        BLog.i(str4, "findTheOne, strategy time not valid, id = " + strategy2.getId() + ", strategy.index = " + strategy2.getOriginIndex());
                        SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy2.getId(), strategyIndex, strategy2.getOriginIndex(), StrategyNotSelectReason.STRATEGY_TIME_INVALID, source, fromRealShow);
                        sortedStrategies2 = sortedStrategies;
                        AdReporterKt.reportAd(step, null, strategy2.getId(), strategy2.getOriginIndex() != Integer.MAX_VALUE ? strategy2.getOriginIndex() : strategyIndex, splashRequestId, source.getValue(), fromRealShow, SplashOrderFilterReason.STRATEGY_TIME_INVALID, strategy2.getAdCb());
                        z2 = z4;
                        str2 = str4;
                        strategyIndex2 = strategyIndex;
                    } else {
                        SplashShowStrategy strategy3 = strategy2;
                        int oldCount = strategyIndex;
                        String str5 = str4;
                        sortedStrategies2 = sortedStrategies;
                        boolean z5 = z4;
                        changeShowState(z5, 4);
                        boolean strategyIdFound2 = false;
                        boolean needUpdateConfig2 = needUpdateConfig;
                        for (Splash splash : splashData.getSplashList()) {
                            if (splash.id != strategy3.getId()) {
                                strategyIdFound = strategyIdFound2;
                            } else {
                                if (!TextUtils.isEmpty(strategy3.getAdCb())) {
                                    splash.adCb = strategy3.getAdCb();
                                }
                                strategyIdFound = true;
                            }
                            boolean z6 = z5;
                            String str6 = str5;
                            int strategyIndex3 = oldCount;
                            if (!SplashOrderSelectHelperKt.isValidBusinessSplash(step, splash, strategy3, oldCount, source, fromRealShow, splashRequestId)) {
                                BLog.i(str6, "findTheOne skip,is not ValidBusinessSplash " + splash);
                                str5 = str6;
                                oldCount = strategyIndex3;
                                z5 = z6;
                                strategyIdFound2 = strategyIdFound;
                            } else {
                                int oldCount2 = splash.localExposeCount;
                                boolean reachShowLimit = SplashOrderSelectHelperKt.isSplashReachShowCountLimit(splash, strategy3, strategyIndex3, source, fromRealShow, splashData.getValidMaxCount());
                                if (oldCount2 != splash.localExposeCount) {
                                    needUpdateConfig2 = true;
                                }
                                if (reachShowLimit) {
                                    notShowReason = SplashNotShowReason.SHOW_COUNT_LIMIT;
                                    AdReporterKt.reportAd(step, splash, strategy3.getId(), strategy3.getOriginIndex() != Integer.MAX_VALUE ? strategy3.getOriginIndex() : strategyIndex3, splashRequestId, source.getValue(), fromRealShow, SplashOrderFilterReason.REACH_MAX_SHOW_COUNT, null);
                                    BLog.i(str6, "findTheOne skip,reachShowLimit " + splash);
                                    oldCount = strategyIndex3;
                                    strategy = strategy3;
                                    z3 = z6;
                                    str3 = str6;
                                } else if (splashData.getKeepIds() == null || !splashData.getKeepIds().contains(Long.valueOf(splash.id)) || !splash.isLocalExposed) {
                                    oldCount = strategyIndex3;
                                    z3 = z6;
                                    str3 = str6;
                                    strategy = strategy3;
                                    Splash validSplash = SplashOrderSelectHelperKt.getValidResSplash(splash, strategy, oldCount, source, z3);
                                    if (validSplash == null) {
                                        notShowReason = SplashNotShowReason.NO_RES;
                                        AdReporterKt.reportAd(step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : oldCount, splashRequestId, source.getValue(), fromRealShow, SplashOrderFilterReason.RESOURCE_NOT_READY, null);
                                        BLog.i(str3, "findTheOne skip, validSplash is null " + splash);
                                    } else {
                                        if (needUpdateConfig2) {
                                            Task.BACKGROUND_EXECUTOR.execute(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda7
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    SplashHelper.saveConfigToDisk(SplashData.this);
                                                }
                                            });
                                        }
                                        SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), oldCount, strategy.getOriginIndex(), StrategyNotSelectReason.SELECTED, source, fromRealShow);
                                        AdReporterKt.reportAd(step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : oldCount, splashRequestId, source.getValue(), fromRealShow, SplashOrderFilterReason.SELECTED, null);
                                        validSplash.originRealTimeShowIndex = strategy.getOriginIndex();
                                        return validSplash;
                                    }
                                } else {
                                    notShowReason = SplashNotShowReason.SHOW_COUNT_LIMIT;
                                    SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy3.getId(), strategyIndex3, strategy3.getOriginIndex(), StrategyNotSelectReason.PROGRAM_EXPOSED, source, fromRealShow);
                                    str3 = str6;
                                    oldCount = strategyIndex3;
                                    z3 = z6;
                                    AdReporterKt.reportAd(step, splash, strategy3.getId(), strategy3.getOriginIndex() != Integer.MAX_VALUE ? strategy3.getOriginIndex() : strategyIndex3, splashRequestId, source.getValue(), fromRealShow, SplashOrderFilterReason.PROGRAM_EXPOSED, null);
                                    BLog.i(str3, "findTheOne skip, splashData.getKeepIds() != null && isLocalExposed " + splash);
                                    strategy = strategy3;
                                }
                                strategy3 = strategy;
                                z5 = z3;
                                strategyIdFound2 = strategyIdFound;
                                str5 = str3;
                            }
                        }
                        z2 = z5;
                        str2 = str5;
                        strategyIndex2 = oldCount;
                        if (!strategyIdFound2) {
                            AdReporterKt.reportAd(step, null, strategy3.getId(), strategy3.getOriginIndex() != Integer.MAX_VALUE ? strategy3.getOriginIndex() : strategyIndex2, splashRequestId, source.getValue(), fromRealShow, SplashOrderFilterReason.LOCAL_LIST_NOT_CONTAIN, strategy3.getAdCb());
                        }
                        needUpdateConfig = needUpdateConfig2;
                    }
                    strategyIndex = strategyIndex2 + 1;
                    z4 = z2;
                    str4 = str2;
                    sortedStrategies = sortedStrategies2;
                }
                if (needUpdateConfig) {
                    Task.BACKGROUND_EXECUTOR.execute(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            SplashHelper.saveConfigToDisk(SplashData.this);
                        }
                    });
                }
                return null;
            } else {
                i = 2;
            }
            step = i;
            sortedStrategies = SplashOrderSelectHelperKt.resortRealTimeShowList(z4, splashData.getSplashList(), showStrategy, expectTopViewId);
            changeShowState(z4, 3);
            needUpdateConfig = false;
            strategyIndex = 0;
            while (strategyIndex < sortedStrategies.size()) {
            }
            if (needUpdateConfig) {
            }
            return null;
        } else {
            str = TAG;
            z = z4;
        }
        changeShowState(z, 3);
        BLog.e(str, "splash has no strategy.");
        return null;
    }

    private static void changeShowState(boolean request, int showState) {
        if (request) {
            sRequestShowState = showState;
        } else {
            sShowState = showState;
        }
    }

    public static void forceUpdateSplash(String openEvent) {
        BLog.i(TAG, "forceUpdateSplash, start update splash, openEvent = " + openEvent);
        SplashData localSplashData = readConfigFromDisk();
        SplashData newSplashData = SplashServiceHelperKt.requestSplashList(SplashPreloadHelperKt.getLoadedResSplashList(localSplashData), SplashDataKt.getUnExposeKeepIds(localSplashData), openEvent);
        if (newSplashData == null) {
            BLog.i(TAG, "forceUpdateSplash, server data invalid");
            return;
        }
        reportNewKeepIdReceive(newSplashData.getKeepIds(), newSplashData.getSplashList());
        updateHotSplashInterval(newSplashData);
        List<Splash> mergeList = mergeSplashList(newSplashData, localSplashData);
        newSplashData.setSplashList(mergeList);
        if (SplashConfigKt.getSplashListResponseSaveImmediate()) {
            saveConfigToDisk(newSplashData);
            saveResourceToDisk(mergeList, localSplashData);
        } else {
            saveResourceToDisk(mergeList, localSplashData);
            saveConfigToDisk(newSplashData);
        }
        long nextUpdateTimeMs = newSplashData.getValidIntervalForUpdate() * 1000;
        SplashStateStorageHelperKt.setSplashLastRequestIntervalMs(nextUpdateTimeMs);
        BLog.i(TAG, "forceUpdateSplash, end update splash, openEvent = " + openEvent + ", next update time = " + nextUpdateTimeMs + "ms");
    }

    private static void reportNewKeepIdReceive(List<Long> keepIds, List<Splash> splashList) {
        if (keepIds == null || keepIds.isEmpty() || splashList == null || splashList.isEmpty()) {
            return;
        }
        Set<Long> idSet = new HashSet<>(keepIds);
        for (Splash splash : splashList) {
            if (idSet.contains(Long.valueOf(splash.id))) {
                String videoState = "new";
                if (BusinessSplashResHelper.isResourceExistByHash(splash.videoHash)) {
                    videoState = "local";
                }
                String imageState = "new";
                if (BusinessSplashResHelper.isResourceExistByHash(splash.imageHash)) {
                    imageState = "local";
                }
                if (SplashCreativeHelper.isOnlyImageCardType(splash)) {
                    SplashAdHelper.reportNewProgramSplashReceive(splash.id, null, imageState, splash.adCb);
                } else if (SplashCreativeHelper.isOnlyVideoCardType(splash)) {
                    SplashAdHelper.reportNewProgramSplashReceive(splash.id, videoState, null, splash.adCb);
                } else if (SplashCreativeHelper.isImageVideoMixCardType(splash)) {
                    SplashAdHelper.reportNewProgramSplashReceive(splash.id, videoState, imageState, splash.adCb);
                }
            }
        }
    }

    private static List<Splash> mergeSplashList(SplashData newData, SplashData localData) {
        List<Splash> oldList = new ArrayList<>();
        List<Splash> newList = new ArrayList<>();
        List<Long> mergeIds = new ArrayList<>();
        if (localData != null && localData.getSplashList() != null) {
            oldList = localData.getSplashList();
        }
        if (newData != null) {
            if (newData.getSplashList() != null) {
                newList = newData.getSplashList();
            }
            if (newData.getKeepIds() != null) {
                LongSparseArray<Object> newIds = new LongSparseArray<>();
                Object value = new Object();
                for (Splash splash : newList) {
                    if (splash != null) {
                        newIds.put(splash.id, value);
                    }
                }
                for (Long id : newData.getKeepIds()) {
                    if (id != null && newIds.indexOfKey(id.longValue()) < 0) {
                        mergeIds.add(id);
                    }
                }
            }
        }
        LongSparseArray<Splash> oldSplash = new LongSparseArray<>();
        for (Splash splash2 : oldList) {
            if (splash2 != null) {
                oldSplash.put(splash2.id, splash2);
            }
        }
        for (Long id2 : mergeIds) {
            Splash splash3 = oldSplash.get(id2.longValue());
            if (splash3 != null) {
                newList.add(splash3);
            }
        }
        Set<Long> idSet = new HashSet<>();
        for (Splash splash4 : newList) {
            idSet.add(Long.valueOf(splash4.id));
            Splash old = oldSplash.get(splash4.id);
            if (old != null) {
                splash4.localExposeCount = old.localExposeCount;
                splash4.lastExposeTime = old.lastExposeTime;
            }
        }
        List<Long> deleteIds = new ArrayList<>();
        for (int i = 0; i < oldSplash.size(); i++) {
            Long id3 = Long.valueOf(oldSplash.keyAt(i));
            if (!idSet.contains(id3)) {
                deleteIds.add(id3);
            }
        }
        SplashAdHelper.reportSplashOrderDelete(deleteIds);
        return newList;
    }

    public static void increaseSplashShowCount(Splash splash) {
        SplashData data = readConfigFromDisk();
        updateLocalSplashOrder(data, splash);
        saveConfigToDisk(data);
    }

    private static SplashShowData findSplashShowList(String topviewIds) {
        SplashShowData showStrategy = SplashServiceHelperKt.requestSplashShow(topviewIds);
        List<SplashShowStrategy> newStrategyList = showStrategy == null ? null : showStrategy.getStrategyList();
        if (newStrategyList != null) {
            mRequestedNewStrategyCount = newStrategyList.size();
        }
        return showStrategy;
    }

    private static void updateLocalSplashOrder(SplashData data, Splash splash) {
        BLog.i("updateLocalSplashOrder, splashId = " + splash.id + " ，exposeCount = " + splash.localExposeCount);
        if (data == null || data.getSplashList() == null) {
            BLog.i("updateLocalSplashOrder, splash data invalid");
            return;
        }
        for (Splash sp : data.getSplashList()) {
            if (sp.id == splash.id) {
                int exposeCount = splash.localExposeCount + 1;
                long time = System.currentTimeMillis();
                splash.localExposeCount = exposeCount;
                splash.lastExposeTime = time;
                splash.isLocalExposed = true;
                sp.localExposeCount = exposeCount;
                sp.lastExposeTime = time;
                sp.isLocalExposed = true;
                return;
            }
        }
    }

    public static void saveConfigToDisk(SplashData data) {
        Context context = BiliContext.application();
        if (data == null || context == null) {
            BLog.e(TAG, "saveConfigToDisk, data is null");
            return;
        }
        BLog.d(TAG, "saveConfigToDisk, start");
        List<Splash> encryptedData = data.getEncryptedData();
        data.trimEncryptedData();
        File splashDir = new File(context.getFilesDir(), DIR_SPLASH);
        if (!splashDir.exists()) {
            boolean success = splashDir.mkdirs();
            BLog.i(TAG, "saveConfigToDisk, dir make success = " + success);
        }
        String filePath = new File(splashDir, FILE_CONFIG).getAbsolutePath();
        File encryptedFile = new File(splashDir, ENCRYPTED_FILE_CONFIG);
        try {
            synchronized (CONFIG_SYNC_LOCK) {
                if (SplashConfigKt.getSplashUseStreamIo()) {
                    FastJsonUtilKt.saveObjectToFileUseStream(data, filePath, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            return SplashHelper.lambda$saveConfigToDisk$6((String) obj);
                        }
                    });
                } else {
                    FileUtils.stringToFile(filePath, JSON.toJSONString(data));
                }
                if (!encryptedData.isEmpty()) {
                    FileUtils.stringToFile(encryptedFile.getAbsolutePath(), SplashAESUtils.encrypt(JSON.toJSONString(encryptedData)));
                } else if (encryptedFile.exists()) {
                    FileUtils.deleteQuietly(encryptedFile);
                }
            }
        } catch (IOException e) {
            BLog.e(TAG, "save config error", e);
            CrashReporter.INSTANCE.postCaughtException(e);
            File configFile = new File(filePath);
            if (configFile.exists()) {
                FileUtils.deleteQuietly(configFile);
            }
            if (encryptedFile.exists()) {
                FileUtils.deleteQuietly(encryptedFile);
            }
        }
        BLog.d(TAG, "saveConfigToDisk, end");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$saveConfigToDisk$6(String errMsg) {
        SplashCustomReporterKt.reportSplashSerializeFailed(true, errMsg);
        return null;
    }

    public static SplashData readConfigFromDisk() {
        String config;
        BLog.i(TAG, "readConfigFromDisk, start");
        Context context = BiliContext.application();
        if (context == null) {
            return null;
        }
        File splashDir = new File(context.getFilesDir(), DIR_SPLASH);
        if (!splashDir.exists()) {
            boolean success = splashDir.mkdirs();
            BLog.e(TAG, "readConfigFromDisk, dir create success" + success);
        }
        File file = new File(splashDir, FILE_CONFIG);
        if (!file.exists()) {
            return null;
        }
        SplashData splashData = null;
        try {
            if (SplashConfigKt.getSplashUseStreamIo()) {
                synchronized (CONFIG_SYNC_LOCK) {
                    splashData = (SplashData) FastJsonUtilKt.readObjectFromFileUseStream(file.getAbsolutePath(), SplashData.class, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            return SplashHelper.lambda$readConfigFromDisk$7((String) obj);
                        }
                    });
                }
            } else {
                synchronized (CONFIG_SYNC_LOCK) {
                    config = FileUtils.string(file.getAbsolutePath());
                }
                if (TextUtils.isEmpty(config)) {
                    boolean success2 = file.delete();
                    BLog.i(TAG, "readConfigFromDisk, delete success = " + success2);
                    return null;
                }
                splashData = (SplashData) JSON.parseObject(config, SplashData.class);
            }
        } catch (Exception e) {
            CrashReporter.INSTANCE.postCaughtException(e);
            BLog.e(TAG, "read config error", e);
            FileUtils.deleteQuietly(file);
        }
        if (splashData == null) {
            boolean success3 = file.delete();
            BLog.i(TAG, "readConfigFromDisk, delete success = " + success3);
            return null;
        }
        List<Splash> encryptedSplash = readEncryptedConfig(context);
        if (encryptedSplash != null && !encryptedSplash.isEmpty()) {
            splashData.addSplashData(encryptedSplash);
        }
        if (SplashAdHelper.INSTANCE.getLastSplashRequestId() == null) {
            SplashAdHelper.INSTANCE.setLastSplashRequestId(splashData.getSplashRequestId());
        }
        BLog.i(TAG, "readConfigFromDisk, end");
        return splashData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$readConfigFromDisk$7(String errMsg) {
        SplashCustomReporterKt.reportSplashSerializeFailed(false, errMsg);
        return null;
    }

    private static List<Splash> readEncryptedConfig(Context context) {
        String path = context.getFilesDir() + File.separator + DIR_SPLASH + File.separator + ENCRYPTED_FILE_CONFIG;
        File file = new File(path);
        String encryptedData = FileUtils.string(file.getAbsolutePath());
        if (TextUtils.isEmpty(encryptedData)) {
            FileUtils.deleteQuietly(file);
            return null;
        }
        try {
            return JSON.parseArray(SplashAESUtils.decrypt(encryptedData), Splash.class);
        } catch (Exception e) {
            BLog.e(TAG, "read encrypt config error", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void saveResourceToDisk(List<Splash> newSplashList, SplashData sSplashData) {
        Context context = BiliContext.application();
        if (context == null) {
            return;
        }
        File resDir = new File(context.getFilesDir(), DIR_SPLASH);
        if (!resDir.exists()) {
            boolean success = resDir.mkdirs();
            BLog.i(TAG, "saveResourceToDisk, create dir success = " + success);
        }
        List<Splash> oldResList = SplashPreloadHelperKt.getResReadySplashListFromDisk(sSplashData);
        List<Splash> saveList = new ArrayList<>(newSplashList);
        BusinessSplashResHelper.deleteUselessResources(saveList, oldResList);
        SplashLocalInfoHelper.getDeviceSize();
        boolean isPeakDownloaderEnable = SplashConfigKt.getBusinessSplashUsePeakDownloader();
        for (Splash splash : saveList) {
            if (splash != null) {
                splash.originImageUrl = splash.imageUrl;
                splash.originVideoUrl = splash.videoUrl;
                if (!SplashCreativeHelper.isSplashDownloadEnable(splash)) {
                    SplashCustomReporterKt.reportSplashDownloadDisable(splash);
                    BLog.d(TAG, "saveResourceToDisk, downloadNotEnable, splashId = " + splash.id);
                } else {
                    if (isPeakDownloaderEnable) {
                        List<SplashPeakTask> unReadyPeakList = SplashCreativeHelperKt.getUnReadyPeakTaskList(splash);
                        if (!unReadyPeakList.isEmpty()) {
                            BusinessSplashResHelper.downloadUsePeak(unReadyPeakList, splash);
                            BusinessSplashResHelper.downloadSecondPageEggVideo(splash);
                            BusinessSplashResHelper.downloadEggResourceAsync(splash);
                            BusinessSplashResHelper.downloadMainLogo(splash.logoUrl, splash.logoHash, splash.splashType);
                            BusinessSplashResHelper.downloadButtonRes(splash.splashGuideButton, splash.splashType);
                            if (splash.secondPage != null) {
                                BusinessSplashResHelper.downloadButtonRes(splash.secondPage.getSecondPageButtons(), splash.splashType);
                            }
                            BusinessSplashResHelper.downloadAnimationResourceAsync(splash);
                        }
                    }
                    handleMainImageDownload(splash);
                    handleMainVideoDownload(splash);
                    BusinessSplashResHelper.downloadSecondPageEggVideo(splash);
                    BusinessSplashResHelper.downloadEggResourceAsync(splash);
                    BusinessSplashResHelper.downloadMainLogo(splash.logoUrl, splash.logoHash, splash.splashType);
                    BusinessSplashResHelper.downloadButtonRes(splash.splashGuideButton, splash.splashType);
                    if (splash.secondPage != null) {
                    }
                    BusinessSplashResHelper.downloadAnimationResourceAsync(splash);
                }
            }
        }
        BusinessSplashResHelper.downloadTopViewRes(saveList, oldResList);
    }

    private static void handleMainImageDownload(Splash splash) {
        if (TextUtils.isEmpty(splash.imageUrl) || TextUtils.isEmpty(splash.imageHash)) {
            return;
        }
        boolean isLocalVideoExists = BusinessSplashResHelper.isResourceExistByHash(splash.videoHash);
        boolean isLocalImageExists = BusinessSplashResHelper.isResourceExistByHash(splash.imageHash);
        boolean isDownloadSuccessViaNet = false;
        if (!isLocalImageExists) {
            isDownloadSuccessViaNet = BusinessSplashResHelper.downloadMainImageSync(splash);
            BLog.i(TAG, "handleMainImageDownload, tech report, imageHash = " + splash.imageHash + ", splashId = " + splash.id + ", isDownloadSuccessViaNet = " + isDownloadSuccessViaNet + ", cardType = " + splash.cardType);
            SplashCustomReporterKt.reportSplashResDownload(splash, isDownloadSuccessViaNet);
        }
        if (SplashCreativeHelper.isImageVideoMixCardType(splash)) {
            if (isLocalVideoExists && isDownloadSuccessViaNet) {
                SplashAdHelper.adSplashDownloadSuccess(splash.adCb);
            }
        } else if (SplashCreativeHelper.isOnlyImageCardType(splash) && isDownloadSuccessViaNet) {
            SplashAdHelper.adSplashDownloadSuccess(splash.adCb);
        }
    }

    private static void updateHotSplashInterval(SplashData splashData) {
        Context context = BiliContext.application();
        if (context == null) {
            return;
        }
        BLog.i(TAG, "updateHotSplashInterval, interval = " + splashData.getValidIntervalForShow());
        Xpref.getDefaultSharedPreferences(context).edit().putInt(PREF_KEY_HOT_SHOW_INTERVAL, splashData.getValidIntervalForShow()).apply();
    }

    private static int getHotSplashInterval() {
        Context context = BiliContext.application();
        if (context == null) {
            return 900;
        }
        return Xpref.getDefaultSharedPreferences(context).getInt(PREF_KEY_HOT_SHOW_INTERVAL, 900);
    }

    private static void handleMainVideoDownload(Splash splash) {
        if (TextUtils.isEmpty(splash.videoUrl) || TextUtils.isEmpty(splash.videoHash)) {
            return;
        }
        boolean isLocalVideoExists = BusinessSplashResHelper.isResourceExistByHash(splash.videoHash);
        boolean isLocalImageExists = BusinessSplashResHelper.isResourceExistByHash(splash.imageHash);
        boolean isDownloadSuccessViaNet = false;
        if (!isLocalVideoExists) {
            isDownloadSuccessViaNet = BusinessSplashResHelper.downloadMainVideoSync(splash);
            BLog.d(TAG, "handleMainVideoDownload, tech report,  videoHash = " + splash.videoHash + ", splashId = " + splash.id + ", isDownloadSuccessViaNet = " + isDownloadSuccessViaNet + ", cardType = " + splash.type);
            SplashCustomReporterKt.reportSplashResDownload(splash, isDownloadSuccessViaNet);
        }
        if (SplashCreativeHelper.isImageVideoMixCardType(splash)) {
            if (isLocalImageExists && isDownloadSuccessViaNet) {
                SplashAdHelper.adSplashDownloadSuccess(splash.adCb);
            }
        } else if (SplashCreativeHelper.isOnlyVideoCardType(splash) && isDownloadSuccessViaNet) {
            SplashAdHelper.adSplashDownloadSuccess(splash.adCb);
        }
    }

    public static void onSplashColdStart(Context appContext) {
        int lastSplashShowTime = (int) (SystemClock.elapsedRealtime() / 1000);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(appContext).edit().putInt(PREF_KEY_LAST_SHOW_TIME, lastSplashShowTime).apply();
    }

    public static void updateSplash(long delay, final String openEvent) {
        BLog.i(TAG, "update splash delay = " + delay + "ms, openEvent = " + openEvent);
        if (!sRefreshSplashDataTaskFinished) {
            BLog.i(TAG, "updateSplash, cancel this task caused by prev task is running.");
            SplashCustomReporterKt.reportSplashListRequest(openEvent, SplashCustomReporterKt.STATE_CANCEL);
            return;
        }
        if (sDelayUpdateRunnable != null) {
            BLog.i(TAG, "updateSplash, prev task is not running, cancel prev delay task");
            HandlerThreads.getHandler(0).removeCallbacks(sDelayUpdateRunnable);
            SplashCustomReporterKt.reportSplashListRequest(openEvent, SplashCustomReporterKt.STATE_REMOVE_PREV_DELAY_TASK);
        }
        sDelayUpdateRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.splash.ad.SplashHelper$$ExternalSyntheticLambda3
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return SplashHelper.lambda$updateSplash$8(r1);
                    }
                });
            }
        };
        SplashCustomReporterKt.reportSplashListRequest(openEvent, SplashCustomReporterKt.STATE_ADD_TO_DELAY_TASK);
        HandlerThreads.postDelayed(0, sDelayUpdateRunnable, delay);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$updateSplash$8(String openEvent) throws Exception {
        sRefreshSplashDataTaskFinished = false;
        forceUpdateSplash(openEvent);
        sDelayUpdateRunnable = null;
        sRefreshSplashDataTaskFinished = true;
        updateSplash(SplashStateStorageHelperKt.getSplashLastRequestIntervalMs(), BusinessSplashDefineKt.SPLASH_OPEN_EVENT_CYCLE);
        return null;
    }

    public static void update() {
        updateSplash(0L, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD);
    }

    public static void addIPCActivityCallback(Context context, boolean mainProcess) {
        if (mainProcess) {
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().remove(PREF_KEY_LAST_SHOW_TIME).apply();
        }
        SplashCoreService s = (SplashCoreService) BLRouter.INSTANCE.get(SplashCoreService.class, "default");
        if (s != null) {
            s.addIPCCallBack(context);
        }
    }

    private static boolean checkWithoutSplash(Activity activity) {
        if (activity != null && activity.getIntent() != null && activity.getIntent().getData() != null) {
            Uri uri = activity.getIntent().getData();
            try {
                String params = uri.getQueryParameter("h5awaken");
                if (!TextUtils.isEmpty(params)) {
                    String h5awakenDec = new String(Base64.decode(params.getBytes(), 0));
                    String fakeUrl = uri + "&" + h5awakenDec;
                    Uri newUri = Uri.parse(fakeUrl);
                    if ("huaweichanglian".equals(newUri.getQueryParameter("open_app_from_type"))) {
                        BLog.i(TAG, "open from huawei changlian, not show hot splash");
                        activity.getIntent().setData(SplashUtilsKt.removeUriParameter(uri, "h5awaken"));
                        return true;
                    }
                }
            } catch (Exception e) {
                BLog.e(TAG, "checkWithoutSplash, base64 decode failed");
            }
        }
        return false;
    }

    private SplashHelper() {
    }

    public static void checkHotSplash(Activity activity) {
        BLog.i(TAG, "checkHotSplash");
        SplashCustomReporterKt.reportAppLaunch(true);
        if (TeenagersMode.getInstance().isEnable() || RestrictedMode.isEnable(RestrictedType.LESSONS, "splash")) {
            return;
        }
        tryUpdateSplashListWhenHotLaunch();
        if ((activity instanceof IDrawerHost) && ((IDrawerHost) activity).isSplashShowing()) {
            BLog.i(TAG, "checkHotSplash, failure cold splash showing");
        } else if (activity instanceof HotSplashActivity) {
            BLog.i(TAG, "checkHotSplash, failure hot splash showing");
        } else {
            int lastShowTime = BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity).getInt(PREF_KEY_LAST_SHOW_TIME, 0);
            BLog.i(TAG, "checkHotSplash, lastShowTime = 0");
            if (lastShowTime == 0) {
                if (SplashConfigKt.getSplashSchemeColdStockEnable()) {
                    BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity).edit().putInt(PREF_KEY_LAST_SHOW_TIME, ((int) (SystemClock.elapsedRealtime() / 1000)) + 1).apply();
                }
            } else if (checkWithoutSplash(activity)) {
                BLog.i(TAG, "checkHotSplashInner, failure changlian");
            } else {
                int hotShowInterval = getHotSplashInterval();
                int currentTime = (int) (SystemClock.elapsedRealtime() / 1000);
                int hotInterval = currentTime - lastShowTime;
                if (hotInterval < hotShowInterval) {
                    BLog.i(TAG, "checkHotSplash, failure interval. hotShowIntervalMs = " + hotShowInterval + ", nowIntervalMs = " + hotInterval);
                    return;
                }
                BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity).edit().putInt(PREF_KEY_LAST_SHOW_TIME, currentTime).apply();
                Splash splash = getSplashForShow(SplashSource.HOT);
                if (splash == null) {
                    SplashAdHelper.stockReport(BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT, false);
                    BLog.i(TAG, "checkHotSplash, failure no order");
                    return;
                }
                try {
                    BLog.i(TAG, "show hot splash " + splash);
                    HotSplashActivityKt.setPendingShowHotSplash(splash);
                    HotSplashActivityKt.isHotSplashShowing = true;
                    RouteRequest request = new RouteRequest.Builder("bilibili://main/hot-splash").addFlag(335544320).build();
                    BLRouter.routeTo(request, activity);
                } catch (Exception e) {
                    BLog.w(e.getMessage(), e);
                    HotSplashActivityKt.setPendingShowHotSplash(null);
                    HotSplashActivityKt.isHotSplashShowing = false;
                }
            }
        }
    }

    private static void tryUpdateSplashListWhenHotLaunch() {
        long now = System.currentTimeMillis();
        boolean validInterval = now - sLastRequestTime > SplashConfigKt.getHotLaunchRequestListColdTimeMs();
        sLastRequestTime = now;
        if (SplashConfigKt.getEnableHotLaunchRequestList() && SplashConfigKt.getEnableHotLaunchBehaviorRequestList() && validInterval) {
            BLog.i(TAG, "checkHotSplash, needUpdateSplash");
            updateSplash(SplashConfigKt.getHotSplashDelayRefreshListTimeMs(), BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT);
        }
    }
}