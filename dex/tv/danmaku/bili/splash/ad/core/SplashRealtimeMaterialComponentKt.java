package tv.danmaku.bili.splash.ad.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import com.bilibili.commons.StringUtils;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResDownloadRequest;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.JsonObject;
import java.io.File;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.Request;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashExtra;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategyKt;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashOrderFilterReason;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashRealtimeMaterialComponent.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0017\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"realtimeMaterialLoadJob", "Lkotlinx/coroutines/Job;", "getRealtimeMaterialLoadJob", "()Lkotlinx/coroutines/Job;", "setRealtimeMaterialLoadJob", "(Lkotlinx/coroutines/Job;)V", "handleRealTimeSplashLoad", "", "showStrategyList", "", "Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "source", "Ltv/danmaku/bili/splash/ad/model/SplashSource;", "downloadRealtimeSplash", "", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "banner", "", "handleRealtimeSplashImageTypeDownload", "", "handleRealtimeSplashVideoTypeDownload", "handleRealtimeEggVideoTypeDownload", "TAG", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashRealtimeMaterialComponentKt {
    private static final String TAG = "[Splash]SplashRealtimeMaterialComponent";
    private static Job realtimeMaterialLoadJob;

    public static final Job getRealtimeMaterialLoadJob() {
        return realtimeMaterialLoadJob;
    }

    public static final void setRealtimeMaterialLoadJob(Job job) {
        realtimeMaterialLoadJob = job;
    }

    public static final int handleRealTimeSplashLoad(List<SplashShowStrategy> list, SplashSource source) {
        int count$iv;
        Intrinsics.checkNotNullParameter(list, "showStrategyList");
        Intrinsics.checkNotNullParameter(source, "source");
        boolean z = false;
        if (list.isEmpty() || !SplashConfigKt.getRealtimeSplashEnable()) {
            return 0;
        }
        List<SplashShowStrategy> $this$count$iv = list;
        if (($this$count$iv instanceof Collection) && $this$count$iv.isEmpty()) {
            count$iv = 0;
        } else {
            count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                SplashShowStrategy it = (SplashShowStrategy) element$iv;
                SplashShowStrategy it2 = it.getSplashContent() != null ? 1 : null;
                if (it2 != null && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int splashCount = count$iv;
        List<SplashShowStrategy> $this$forEachIndexed$iv = list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SplashShowStrategy strategy = (SplashShowStrategy) item$iv;
            SplashOrder splashContent = strategy.getSplashContent();
            if (splashContent != null) {
                if (!SplashShowStrategyKt.isValid(strategy) || !ExtSplashOrderKt.isTimeValid(splashContent)) {
                    SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
                    long id = splashContent.getId();
                    String realShowRequestId = SplashManagerKt.getSplashState().getData().getRealShowRequestId();
                    if (realShowRequestId == null) {
                        realShowRequestId = "";
                    }
                    SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(splashAdHelper, 0, splashContent, id, index, realShowRequestId, source.getValue(), true, null, !SplashShowStrategyKt.isValid(strategy) ? SplashOrderFilterReason.STRATEGY_TIME_INVALID : SplashOrderFilterReason.SPLASH_TIME_INVALID, BR.cover, null);
                } else {
                    splashContent.getRuntimeExtra().setOriginRealTimeShowIndex(index);
                    String adCb = strategy.getAdCb();
                    if (!((adCb == null || StringsKt.isBlank(adCb)) ? true : true)) {
                        splashContent.setAdCb(strategy.getAdCb());
                    }
                    JsonObject banner = strategy.getBanner();
                    downloadRealtimeSplash(splashContent, banner != null ? JsonUtilKt.toJson(banner) : null);
                    return splashCount;
                }
            }
            index = index$iv;
        }
        return splashCount;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if ((r2 == null || kotlin.text.StringsKt.isBlank(r2)) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void downloadRealtimeSplash(SplashOrder splash, String banner) {
        boolean isValidVideoSplash;
        String imageUrl = splash.getImageUrl();
        String videoUrl = splash.getVideoUrl();
        boolean isValidImageSplash = false;
        if (ExtSplashOrderKt.isOnlyVideoSplash(splash)) {
            String str = videoUrl;
        }
        if (!ExtSplashOrderKt.isVideo(splash) || !ListDeviceInfoKt.isHdApp()) {
            isValidVideoSplash = false;
            if (ExtSplashOrderKt.isOnlyImageSplash(splash)) {
                String str2 = imageUrl;
                if (!(str2 == null || StringsKt.isBlank(str2))) {
                    isValidImageSplash = true;
                }
            }
            if (isValidVideoSplash && !isValidImageSplash) {
                BLog.i(TAG, "invalid real splash isVideo:" + ExtSplashOrderKt.isVideo(splash));
                SplashCustomReporterKt.reportRealtimeDownloadError$default(splash, "splash_not_valid", null, 4, null);
                return;
            }
            splash.setRealTimeSplash(true);
            splash.getRuntimeExtra().setSplashRequestId(SplashManagerKt.getSplashState().getData().getRealShowRequestId());
            splash.setNetworkType(!NetworkUtilsKt.isWifiConnected() ? NetworkUtilsKt.NETWORK_TYPE_WIFI : NetworkUtilsKt.NETWORK_TYPE_MOBILE);
            splash.getRuntimeExtra().setBindBanner(banner);
            SplashManagerKt.getSplashState().setRealtimeMaterialSplashDownloadStartTime(System.currentTimeMillis());
            SplashManagerKt.getSplashState().getData().setRealTimeSplash(splash);
            realtimeMaterialLoadJob = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1(splash, null), 2, (Object) null);
        }
        isValidVideoSplash = true;
        if (ExtSplashOrderKt.isOnlyImageSplash(splash)) {
        }
        if (isValidVideoSplash) {
        }
        splash.setRealTimeSplash(true);
        splash.getRuntimeExtra().setSplashRequestId(SplashManagerKt.getSplashState().getData().getRealShowRequestId());
        splash.setNetworkType(!NetworkUtilsKt.isWifiConnected() ? NetworkUtilsKt.NETWORK_TYPE_WIFI : NetworkUtilsKt.NETWORK_TYPE_MOBILE);
        splash.getRuntimeExtra().setBindBanner(banner);
        SplashManagerKt.getSplashState().setRealtimeMaterialSplashDownloadStartTime(System.currentTimeMillis());
        SplashManagerKt.getSplashState().getData().setRealTimeSplash(splash);
        realtimeMaterialLoadJob = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1(splash, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleRealtimeSplashImageTypeDownload(SplashOrder splash) throws Exception {
        long bytesSize;
        File file = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splash.getImageHash());
        boolean fromCache = false;
        if (file != null) {
            fromCache = true;
            bytesSize = file.length();
            BLog.i(TAG, "handleRealtimeSplashImageTypeDownload, from cache");
        } else {
            String imageUrl = splash.getImageUrl();
            if (imageUrl == null) {
                return false;
            }
            BLog.i(TAG, "handleRealtimeSplashImageTypeDownload, from network");
            ResponseBody body = OkHttpClientWrapper.get().newCall(new Request.Builder().url(imageUrl).build()).execute().body();
            if (body == null) {
                SplashCustomReporterKt.reportRealtimeDownloadError$default(splash, "response_invalid", null, 4, null);
                return false;
            }
            byte[] bytes = body.bytes();
            String imageHash = splash.getImageHash();
            if (!(imageHash == null || StringsKt.isBlank(imageHash))) {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(bytes);
                String md5 = StringUtils.toHexString(digest.digest());
                if (!Intrinsics.areEqual(splash.getImageHash(), md5)) {
                    BLog.i(TAG, "handleRealtimeSplashImageTypeDownload, md5 not match");
                    SplashCustomReporterKt.reportRealtimeDownloadError$default(splash, "md5 not match", null, 4, null);
                    return false;
                }
            }
            bytesSize = bytes.length;
            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            if (bmp == null) {
                BLog.i(TAG, "handleRealtimeSplashImageTypeDownload, download realtime splash failed bmp is null");
                SplashCustomReporterKt.reportRealtimeDownloadError$default(splash, "bitmap decode error", null, 4, null);
                return false;
            }
            splash.getRuntimeExtra().setRealTimeSplashBitmap(bmp);
            splash.getRuntimeExtra().setImageFrom("realtime");
        }
        SplashExtra runtimeExtra = splash.getRuntimeExtra();
        long j = (long) MisakaHelper.MAX_REPORT_SIZE;
        runtimeExtra.setLocalSplashImageSize(bytesSize / j);
        SplashCustomReporterKt.reportRealtimeDownloadTime(splash, System.currentTimeMillis() - SplashManagerKt.getSplashState().getRealtimeMaterialSplashDownloadStartTime(), fromCache, (int) (bytesSize / j));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleRealtimeSplashVideoTypeDownload(SplashOrder splash) {
        File file = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splash.getVideoHash());
        boolean fromCache = false;
        if (file != null) {
            fromCache = true;
            BLog.i(TAG, "handleRealtimeSplashVideoTypeDownload, get realtime splash resource from cache");
        } else {
            boolean success = ResManager.downloadSync(new ResDownloadRequest(splash.getVideoUrl(), splash.getVideoHash()).md5(splash.getVideoHash()).downloadTag("realtime_splash_video").bizType(DownloadBizType.Splash));
            BLog.i(TAG, "handleRealtimeSplashVideoTypeDownload, get realtime splash resource from net, success = " + success);
            if (!success || (file = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splash.getVideoHash())) == null) {
                return false;
            }
            splash.getRuntimeExtra().setVideoFrom("realtime");
        }
        SplashExtra runtimeExtra = splash.getRuntimeExtra();
        long length = file.length();
        long j = (long) MisakaHelper.MAX_REPORT_SIZE;
        runtimeExtra.setLocalSplashVideoSize(length / j);
        SplashCustomReporterKt.reportRealtimeDownloadTime(splash, System.currentTimeMillis() - SplashManagerKt.getSplashState().getRealtimeMaterialSplashDownloadStartTime(), fromCache, (int) (file.length() / j));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRealtimeEggVideoTypeDownload(SplashOrder splash) {
        SplashSecondPageInfo secondPage;
        String videoUrl;
        if (!ExtSplashOrderKt.getHasSecondPageEggVideo(splash) || (secondPage = splash.getSecondPage()) == null || (videoUrl = secondPage.getSecondVideoUrl()) == null) {
            return;
        }
        String videoHash = splash.getSecondPage().getSecondVideoHash();
        File file = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(videoHash);
        if (file == null) {
            boolean success = ResManager.downloadSync(new ResDownloadRequest(videoUrl, videoHash).md5(videoHash).downloadTag("realtime_splash_egg_video").bizType(DownloadBizType.Splash));
            BLog.i(TAG, "handleRealtimeEggVideoTypeDownload, get realtime splash resource from net, success = " + success);
        }
    }
}