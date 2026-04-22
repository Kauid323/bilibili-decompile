package tv.danmaku.bili.splash.ad.reporter.tech;

import android.util.Log;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.performance.BootOpt;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.teenagersmode.TeenagersMode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.splash.ad.core.SplashManagerKt;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashCustomReporter.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a=\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00012%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0002\b\u0011H\u0002\u001a*\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a(\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0000\u001a \u0010\u001f\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0019\u001a\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\fH\u0000\u001a\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\fH\u0000\u001a$\u0010$\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0001\u001a\b\u0010(\u001a\u00020\u000bH\u0000\u001a\b\u0010)\u001a\u00020\u000bH\u0000\u001a\u001a\u0010*\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u001a\u0010+\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0006\u0010-\u001a\u00020\u000b\u001a\u0006\u0010.\u001a\u00020\u000b\u001a\u0018\u0010/\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u000201\u001a\u001c\u00102\u001a\u00020\u000b2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000104H\u0002\u001a\u0012\u00105\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0018\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0017H\u0000\u001a\u001e\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0017\u001a\u0016\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@\u001a\u001c\u0010A\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00192\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010C\u001aB\u0010D\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010F\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u00012\b\u0010H\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\u0015H\u0000\u001a\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u0017H\u0000\u001a\u0006\u0010O\u001a\u00020\u000b\u001a\u0012\u0010Q\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0012\u0010R\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0012\u0010S\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001a\u0010U\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010V\u001a\u00020\u0017H\u0000\u001a\u0010\u0010W\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\fH\u0000\u001a\u0018\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0001H\u0000\u001a\u0018\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0001H\u0000\u001a\u000e\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0001\u001a8\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\u00192\u0006\u0010c\u001a\u00020\u00192\u0006\u0010%\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u0017H\u0000\u001a\u0010\u0010h\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020\u0015H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010j\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"KEY_EVENT_TYPE", "", "TYPE_SUCCESS_STATE", "TRIGGER_TIME", "SUCCESS", "FAILED", "IS_NEW_SPLASH", "STATE_CANCEL", "STATE_REMOVE_PREV_DELAY_TASK", "STATE_ADD_TO_DELAY_TASK", "report", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "eventType", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "reportRealtimeDownloadTime", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "time", "", "fromCache", "", "size", "", "reportShowRequestTime", "splashCount", "selectCostTime", "reportSplashTotalRequestTime", "reportRealtimeDownloadFailed", "reportResourceLoadException", "errorRes", "exceptType", "reportRealtimeDownloadSuccess", "reportRealtimeMatShow", "reportRealtimeDownloadError", "reason", "t", "", "reportShowRequestSuccess", "reportShowRequestFailed", "reportVideoRenderTime", "reportVideoPrepareTime", "mSplashPrepareStartTime", "onStartPrepareADSplash", "onADSplashReady", "reportShowType", "strategy", "Ltv/danmaku/bili/splash/ad/reporter/tech/SplashShowType;", "reportTrackT", "map", "", "reportSplashExpose", "reportSplashStock", "isHot", "isDeepLink", "reportStockNotReportReason", "notLauncher", "disableSplash", "showEventSplash", "reportSplashStorageUsage", "usedSizeByte", "type", "Lcom/bilibili/lib/resmanager/DownloadBizType;", "reportSplashResourcesDelete", "resources", "", "reportSplashClick", "jumpUrl", "buttonId", "buttonType", "intentData", "showTimeBeforeClick", "reportSplashPreloadTime", "firstHotLaunch", "reportAppLaunch", "isHotLaunch", "isFirstMainActivityLaunch", "reportMainActivityLaunch", "mSplashShowTime", "reportSplashDuration", "reportSkipClick", "reportRequestList", "loadedResSplashList", "reportSplashResDownload", SplashCustomReporterKt.SUCCESS, "reportSplashDownloadDisable", "reportSplashListRequest", "openEvent", AuthResultCbHelper.ARGS_STATE, "reportSplashSerializeFailed", "serialize", "failReason", "reportDeepLinkByNewIntent", "deeplink", "reportStrategySplashNotSelectReason", "strategyId", "strategyIndex", "strategyOriginIndex", "Ltv/danmaku/bili/splash/ad/reporter/tech/StrategyNotSelectReason;", "source", "Ltv/danmaku/bili/splash/ad/model/SplashSource;", "realShow", "reportPreloadDataExpired", "timeSpan", "TAG", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCustomReporterKt {
    private static final String FAILED = "failed";
    private static final String IS_NEW_SPLASH = "new_splash";
    private static final String KEY_EVENT_TYPE = "event_type";
    public static final String STATE_ADD_TO_DELAY_TASK = "add_to_delay_task";
    public static final String STATE_CANCEL = "cancel";
    public static final String STATE_REMOVE_PREV_DELAY_TASK = "remove_prev_delay_task";
    private static final String SUCCESS = "success";
    private static final String TAG = "[Splash]SplashCustomReporter";
    private static final String TRIGGER_TIME = "trigger_time";
    private static final String TYPE_SUCCESS_STATE = "success_state";
    private static boolean firstHotLaunch = true;
    private static boolean isFirstMainActivityLaunch = true;
    private static long mSplashPrepareStartTime;
    private static long mSplashShowTime;

    public static final void reportRealtimeDownloadError(SplashOrder splashOrder, String str) {
        Intrinsics.checkNotNullParameter(splashOrder, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(str, "reason");
        reportRealtimeDownloadError$default(splashOrder, str, null, 4, null);
    }

    static /* synthetic */ void report$default(SplashOrder splashOrder, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj2) {
                    Unit report$lambda$0;
                    report$lambda$0 = SplashCustomReporterKt.report$lambda$0((Map) obj2);
                    return report$lambda$0;
                }
            };
        }
        report(splashOrder, str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit report$lambda$0(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return Unit.INSTANCE;
    }

    private static final void report(SplashOrder $this$report, String eventType, Function1<? super Map<String, String>, Unit> function1) {
        Map map;
        if (SamplerKt.getEventSampler(eventType)) {
            if ($this$report == null) {
                map = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "null"), TuplesKt.to(IS_NEW_SPLASH, "1")});
            } else {
                Pair[] pairArr = new Pair[15];
                pairArr[0] = TuplesKt.to(UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "not_null");
                pairArr[1] = TuplesKt.to(PeakTaskDefine.SPLASH_ID, String.valueOf($this$report.getId()));
                String imageUrl = $this$report.getImageUrl();
                if (imageUrl == null) {
                    imageUrl = "";
                }
                pairArr[2] = TuplesKt.to("splash_image_url", imageUrl);
                String imageHash = $this$report.getImageHash();
                if (imageHash == null) {
                    imageHash = "";
                }
                pairArr[3] = TuplesKt.to("splash_image_hash", imageHash);
                String videoUrl = $this$report.getVideoUrl();
                if (videoUrl == null) {
                    videoUrl = "";
                }
                pairArr[4] = TuplesKt.to("splash_video_url", videoUrl);
                String videoHash = $this$report.getVideoHash();
                if (videoHash == null) {
                    videoHash = "";
                }
                pairArr[5] = TuplesKt.to("splash_video_hash", videoHash);
                pairArr[6] = TuplesKt.to("splash_card_type", String.valueOf($this$report.getCardType()));
                pairArr[7] = TuplesKt.to("splash_type", String.valueOf($this$report.getType()));
                pairArr[8] = TuplesKt.to("splash_interactive", String.valueOf($this$report.getInteractType()));
                String jumpUrl = $this$report.getJumpUrl();
                if (jumpUrl == null) {
                    jumpUrl = "";
                }
                pairArr[9] = TuplesKt.to("jump_url", jumpUrl);
                String appLink = $this$report.getAppLink();
                if (appLink == null) {
                    appLink = "";
                }
                pairArr[10] = TuplesKt.to("schema", appLink);
                String interactUrl = $this$report.getInteractUrl();
                pairArr[11] = TuplesKt.to("interact_url", interactUrl != null ? interactUrl : "");
                pairArr[12] = TuplesKt.to("is_hot_splash", String.valueOf($this$report.getRuntimeExtra().isHotSplash()));
                pairArr[13] = TuplesKt.to("is_deep", String.valueOf($this$report.getRuntimeExtra().isFromCalledUp() ? 1 : 0));
                pairArr[14] = TuplesKt.to(IS_NEW_SPLASH, "1");
                map = MapsKt.mutableMapOf(pairArr);
            }
            map.put("mixin_banner", DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() ? "1" : "0");
            function1.invoke(map);
            map.put(KEY_EVENT_TYPE, eventType);
            reportTrackT(map);
        }
    }

    public static final void reportRealtimeDownloadTime(SplashOrder splash, final long time, final boolean fromCache, final int size) {
        report(splash, "realtime_download_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit reportRealtimeDownloadTime$lambda$0;
                reportRealtimeDownloadTime$lambda$0 = SplashCustomReporterKt.reportRealtimeDownloadTime$lambda$0(time, fromCache, size, (Map) obj);
                return reportRealtimeDownloadTime$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportRealtimeDownloadTime$lambda$0(long $time, boolean $fromCache, int $size, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($time));
        $this$report.put("from_cache", String.valueOf($fromCache));
        $this$report.put("res_size", String.valueOf($size));
        return Unit.INSTANCE;
    }

    public static final void reportShowRequestTime(final long time, final int size, final int splashCount, final long selectCostTime) {
        report(null, "show_request_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit reportShowRequestTime$lambda$0;
                reportShowRequestTime$lambda$0 = SplashCustomReporterKt.reportShowRequestTime$lambda$0(time, size, splashCount, selectCostTime, (Map) obj);
                return reportShowRequestTime$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportShowRequestTime$lambda$0(long $time, int $size, int $splashCount, long $selectCostTime, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($time));
        $this$report.put("show_size", String.valueOf($size));
        $this$report.put("show_splash_count", String.valueOf($splashCount));
        $this$report.put(TRIGGER_TIME, String.valueOf(SplashManagerKt.getSplashState().getShowRequestStartTime() - BootOpt.INSTANCE.getProcessStartTime()));
        $this$report.put("select_time", String.valueOf($selectCostTime));
        return Unit.INSTANCE;
    }

    public static final void reportSplashTotalRequestTime(final long time) {
        report(null, "splash_total_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit reportSplashTotalRequestTime$lambda$0;
                reportSplashTotalRequestTime$lambda$0 = SplashCustomReporterKt.reportSplashTotalRequestTime$lambda$0(time, (Map) obj);
                return reportSplashTotalRequestTime$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashTotalRequestTime$lambda$0(long $time, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($time));
        return Unit.INSTANCE;
    }

    public static final void reportRealtimeDownloadFailed(SplashOrder splash) {
        report(splash, "realtime_download_state", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda27
            public final Object invoke(Object obj) {
                Unit reportRealtimeDownloadFailed$lambda$0;
                reportRealtimeDownloadFailed$lambda$0 = SplashCustomReporterKt.reportRealtimeDownloadFailed$lambda$0((Map) obj);
                return reportRealtimeDownloadFailed$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportRealtimeDownloadFailed$lambda$0(Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put(TYPE_SUCCESS_STATE, FAILED);
        return Unit.INSTANCE;
    }

    public static final void reportResourceLoadException(SplashOrder splash, final String errorRes, final int exceptType) {
        Intrinsics.checkNotNullParameter(errorRes, "errorRes");
        report(splash, "splash_resource_exception", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit reportResourceLoadException$lambda$0;
                reportResourceLoadException$lambda$0 = SplashCustomReporterKt.reportResourceLoadException$lambda$0(errorRes, exceptType, (Map) obj);
                return reportResourceLoadException$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportResourceLoadException$lambda$0(String $errorRes, int $exceptType, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("error_resource", $errorRes);
        $this$report.put("splash_expect_material_type", String.valueOf($exceptType));
        return Unit.INSTANCE;
    }

    public static final void reportRealtimeDownloadSuccess(final SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        report(splash, "realtime_download_state", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                Unit reportRealtimeDownloadSuccess$lambda$0;
                reportRealtimeDownloadSuccess$lambda$0 = SplashCustomReporterKt.reportRealtimeDownloadSuccess$lambda$0(SplashOrder.this, (Map) obj);
                return reportRealtimeDownloadSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportRealtimeDownloadSuccess$lambda$0(SplashOrder $splash, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put(TYPE_SUCCESS_STATE, SUCCESS);
        $this$report.put("splash_pic_size", String.valueOf($splash.getRuntimeExtra().getLocalSplashImageSize()));
        $this$report.put("splash_video_size", String.valueOf($splash.getRuntimeExtra().getLocalSplashVideoSize()));
        $this$report.put(ExtSplashOrderKt.isVideo($splash) ? "video_from" : "event_from", ExtSplashOrderKt.isVideo($splash) ? $splash.getRuntimeExtra().getVideoFrom() : $splash.getRuntimeExtra().getImageFrom());
        return Unit.INSTANCE;
    }

    public static final void reportRealtimeMatShow(final SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        report(splash, "realtime_show_state", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda30
            public final Object invoke(Object obj) {
                Unit reportRealtimeMatShow$lambda$0;
                reportRealtimeMatShow$lambda$0 = SplashCustomReporterKt.reportRealtimeMatShow$lambda$0(SplashOrder.this, (Map) obj);
                return reportRealtimeMatShow$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportRealtimeMatShow$lambda$0(SplashOrder $splash, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put(ExtSplashOrderKt.isVideo($splash) ? "video_from" : "pic_from", ExtSplashOrderKt.isVideo($splash) ? $splash.getRuntimeExtra().getVideoFrom() : $splash.getRuntimeExtra().getImageFrom());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void reportRealtimeDownloadError$default(SplashOrder splashOrder, String str, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        reportRealtimeDownloadError(splashOrder, str, th);
    }

    public static final void reportRealtimeDownloadError(SplashOrder splash, final String reason, final Throwable t) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(reason, "reason");
        report(splash, "realtime_download_error", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit reportRealtimeDownloadError$lambda$0;
                reportRealtimeDownloadError$lambda$0 = SplashCustomReporterKt.reportRealtimeDownloadError$lambda$0(reason, t, (Map) obj);
                return reportRealtimeDownloadError$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportRealtimeDownloadError$lambda$0(String $reason, Throwable $t, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("error_message", $reason);
        if ($t != null) {
            String stackTraceString = Log.getStackTraceString($t);
            Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(...)");
            $this$report.put("error_stack", stackTraceString);
        }
        return Unit.INSTANCE;
    }

    public static final void reportShowRequestSuccess() {
        report(null, "show_state", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit reportShowRequestSuccess$lambda$0;
                reportShowRequestSuccess$lambda$0 = SplashCustomReporterKt.reportShowRequestSuccess$lambda$0((Map) obj);
                return reportShowRequestSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportShowRequestSuccess$lambda$0(Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put(TYPE_SUCCESS_STATE, SUCCESS);
        return Unit.INSTANCE;
    }

    public static final void reportShowRequestFailed() {
        report(null, "show_state", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Unit reportShowRequestFailed$lambda$0;
                reportShowRequestFailed$lambda$0 = SplashCustomReporterKt.reportShowRequestFailed$lambda$0((Map) obj);
                return reportShowRequestFailed$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportShowRequestFailed$lambda$0(Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put(TYPE_SUCCESS_STATE, FAILED);
        return Unit.INSTANCE;
    }

    public static final void reportVideoRenderTime(SplashOrder splash, final long time) {
        report(splash, "video_render_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit reportVideoRenderTime$lambda$0;
                reportVideoRenderTime$lambda$0 = SplashCustomReporterKt.reportVideoRenderTime$lambda$0(time, (Map) obj);
                return reportVideoRenderTime$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportVideoRenderTime$lambda$0(long $time, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($time));
        return Unit.INSTANCE;
    }

    public static final void reportVideoPrepareTime(SplashOrder splash, final long time) {
        report(splash, "video_prepare_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda29
            public final Object invoke(Object obj) {
                Unit reportVideoPrepareTime$lambda$0;
                reportVideoPrepareTime$lambda$0 = SplashCustomReporterKt.reportVideoPrepareTime$lambda$0(time, (Map) obj);
                return reportVideoPrepareTime$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportVideoPrepareTime$lambda$0(long $time, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($time));
        return Unit.INSTANCE;
    }

    public static final void onStartPrepareADSplash() {
        mSplashPrepareStartTime = System.currentTimeMillis();
    }

    public static final void onADSplashReady() {
        if (mSplashPrepareStartTime > 0) {
            report(null, "splash_prepare_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda31
                public final Object invoke(Object obj) {
                    Unit onADSplashReady$lambda$0;
                    onADSplashReady$lambda$0 = SplashCustomReporterKt.onADSplashReady$lambda$0((Map) obj);
                    return onADSplashReady$lambda$0;
                }
            });
            mSplashPrepareStartTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onADSplashReady$lambda$0(Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf(System.currentTimeMillis() - mSplashPrepareStartTime));
        $this$report.put("max_prepare_time", String.valueOf(SplashConfigKt.getSplashMaxPrepareTime()));
        return Unit.INSTANCE;
    }

    public static final void reportShowType(SplashOrder splash, final SplashShowType strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        report(splash, "splash_show_type", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit reportShowType$lambda$0;
                reportShowType$lambda$0 = SplashCustomReporterKt.reportShowType$lambda$0(SplashShowType.this, (Map) obj);
                return reportShowType$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportShowType$lambda$0(SplashShowType $strategy, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("show_type", $strategy.getType());
        return Unit.INSTANCE;
    }

    private static final void reportTrackT(Map<String, String> map) {
        BLog.i("SplashCustomTracker", "report:" + map);
        if (SplashUtilsKt.isDebug()) {
            return;
        }
        Neurons.trackT$default(false, "splash.show.realtime.track", map, 0, new Function0() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda18
            public final Object invoke() {
                boolean reportTrackT$lambda$0;
                reportTrackT$lambda$0 = SplashCustomReporterKt.reportTrackT$lambda$0();
                return Boolean.valueOf(reportTrackT$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportTrackT$lambda$0() {
        return true;
    }

    public static final void reportSplashExpose(SplashOrder splash) {
        report$default(splash, "splash_expose", null, 2, null);
        mSplashShowTime = System.currentTimeMillis();
    }

    public static final void reportSplashStock(final boolean isHot, final boolean isDeepLink) {
        report(null, "splash_stock", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                Unit reportSplashStock$lambda$0;
                reportSplashStock$lambda$0 = SplashCustomReporterKt.reportSplashStock$lambda$0(isHot, isDeepLink, (Map) obj);
                return reportSplashStock$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashStock$lambda$0(boolean $isHot, boolean $isDeepLink, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("is_hot", String.valueOf($isHot));
        $this$report.put("is_called_up", String.valueOf($isDeepLink ? 1 : 0));
        return Unit.INSTANCE;
    }

    public static final void reportStockNotReportReason(final boolean notLauncher, final boolean disableSplash, final boolean showEventSplash) {
        report(null, "splash_stock_not_report_reason", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit reportStockNotReportReason$lambda$0;
                reportStockNotReportReason$lambda$0 = SplashCustomReporterKt.reportStockNotReportReason$lambda$0(disableSplash, notLauncher, showEventSplash, (Map) obj);
                return reportStockNotReportReason$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportStockNotReportReason$lambda$0(boolean $disableSplash, boolean $notLauncher, boolean $showEventSplash, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        if ($disableSplash) {
            $this$report.put("disable_splash", "true");
        }
        if ($notLauncher) {
            $this$report.put("not_launcher", "true");
        }
        if (TeenagersMode.getInstance().isEnable()) {
            $this$report.put("teen_mode", "true");
        }
        if (RestrictedMode.isEnable(RestrictedType.LESSONS, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH)) {
            $this$report.put("lesson_mode", "true");
        }
        if ($showEventSplash) {
            $this$report.put("event_splash", "true");
        }
        return Unit.INSTANCE;
    }

    public static final void reportSplashStorageUsage(long usedSizeByte, final DownloadBizType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        final long maxSize = type.getMaxSizeMB();
        long j = (long) MisakaHelper.MAX_REPORT_SIZE;
        final long usedSizeMB = (usedSizeByte / j) / j;
        BLog.i(TAG, "reportSplashStorageUsage, usedSizeMB = " + usedSizeMB + ", maxSize = " + maxSize + ", type = " + type);
        report(null, "splash_storage_usage", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit reportSplashStorageUsage$lambda$0;
                reportSplashStorageUsage$lambda$0 = SplashCustomReporterKt.reportSplashStorageUsage$lambda$0(usedSizeMB, maxSize, type, (Map) obj);
                return reportSplashStorageUsage$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashStorageUsage$lambda$0(long $usedSizeMB, long $maxSize, DownloadBizType $type, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("used_size", String.valueOf($usedSizeMB));
        $this$report.put("max_size", String.valueOf($maxSize));
        $this$report.put("ad_type", String.valueOf($type));
        return Unit.INSTANCE;
    }

    public static final void reportSplashResourcesDelete(final int reason, final List<String> list) {
        Intrinsics.checkNotNullParameter(list, "resources");
        report(null, "splash_material_delete", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                Unit reportSplashResourcesDelete$lambda$0;
                reportSplashResourcesDelete$lambda$0 = SplashCustomReporterKt.reportSplashResourcesDelete$lambda$0(reason, list, (Map) obj);
                return reportSplashResourcesDelete$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashResourcesDelete$lambda$0(int $reason, List $resources, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("delete_reason", String.valueOf($reason));
        $this$report.put("md5", CollectionsKt.joinToString$default($resources, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return Unit.INSTANCE;
    }

    public static final void reportSplashClick(SplashOrder splash, final String jumpUrl, final String buttonId, final String buttonType, final String intentData, final long showTimeBeforeClick) {
        report(splash, "splash_button_click", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit reportSplashClick$lambda$0;
                reportSplashClick$lambda$0 = SplashCustomReporterKt.reportSplashClick$lambda$0(jumpUrl, buttonId, buttonType, intentData, showTimeBeforeClick, (Map) obj);
                return reportSplashClick$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashClick$lambda$0(String $jumpUrl, String $buttonId, String $buttonType, String $intentData, long $showTimeBeforeClick, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("jump_url", $jumpUrl == null ? "" : $jumpUrl);
        $this$report.put("button_id", $buttonId == null ? "" : $buttonId);
        $this$report.put("button_type", $buttonType == null ? "" : $buttonType);
        $this$report.put("intent_data", $intentData != null ? $intentData : "");
        $this$report.put("show_time", String.valueOf($showTimeBeforeClick));
        return Unit.INSTANCE;
    }

    public static final void reportSplashPreloadTime(final long time) {
        report(null, "splash_preload_time", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reportSplashPreloadTime$lambda$0;
                reportSplashPreloadTime$lambda$0 = SplashCustomReporterKt.reportSplashPreloadTime$lambda$0(time, (Map) obj);
                return reportSplashPreloadTime$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashPreloadTime$lambda$0(long $time, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($time));
        return Unit.INSTANCE;
    }

    public static final void reportAppLaunch(final boolean isHotLaunch) {
        if (firstHotLaunch && isHotLaunch) {
            firstHotLaunch = false;
        } else {
            report(null, "app_launch", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj) {
                    Unit reportAppLaunch$lambda$0;
                    reportAppLaunch$lambda$0 = SplashCustomReporterKt.reportAppLaunch$lambda$0(isHotLaunch, (Map) obj);
                    return reportAppLaunch$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportAppLaunch$lambda$0(boolean $isHotLaunch, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("is_hot", String.valueOf($isHotLaunch));
        return Unit.INSTANCE;
    }

    public static final void reportMainActivityLaunch() {
        report(null, "main_activity_launch", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit reportMainActivityLaunch$lambda$0;
                reportMainActivityLaunch$lambda$0 = SplashCustomReporterKt.reportMainActivityLaunch$lambda$0((Map) obj);
                return reportMainActivityLaunch$lambda$0;
            }
        });
        isFirstMainActivityLaunch = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportMainActivityLaunch$lambda$0(Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("is_first_launch", String.valueOf(isFirstMainActivityLaunch));
        return Unit.INSTANCE;
    }

    public static final void reportSplashDuration(SplashOrder splash) {
        if (mSplashShowTime != 0) {
            final long duration = System.currentTimeMillis() - mSplashShowTime;
            report(splash, "splash_show_duration", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    Unit reportSplashDuration$lambda$0;
                    reportSplashDuration$lambda$0 = SplashCustomReporterKt.reportSplashDuration$lambda$0(duration, (Map) obj);
                    return reportSplashDuration$lambda$0;
                }
            });
        }
        mSplashShowTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashDuration$lambda$0(long $duration, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time", String.valueOf($duration));
        return Unit.INSTANCE;
    }

    public static final void reportSkipClick(SplashOrder splash) {
        report$default(splash, "skip_click", null, 2, null);
    }

    public static final void reportRequestList(final String loadedResSplashList) {
        report(null, "request_list", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Unit reportRequestList$lambda$0;
                reportRequestList$lambda$0 = SplashCustomReporterKt.reportRequestList$lambda$0(loadedResSplashList, (Map) obj);
                return reportRequestList$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportRequestList$lambda$0(String $loadedResSplashList, Map $this$report) {
        List split$default;
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("local_splash_size", ($loadedResSplashList == null || (split$default = StringsKt.split$default($loadedResSplashList, new String[]{","}, false, 0, 6, (Object) null)) == null || (r0 = String.valueOf(split$default.size())) == null) ? "0" : "0");
        return Unit.INSTANCE;
    }

    public static final void reportSplashResDownload(SplashOrder splash, final boolean success) {
        report(splash, "res_download", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit reportSplashResDownload$lambda$0;
                reportSplashResDownload$lambda$0 = SplashCustomReporterKt.reportSplashResDownload$lambda$0(success, (Map) obj);
                return reportSplashResDownload$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashResDownload$lambda$0(boolean $success, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put(TYPE_SUCCESS_STATE, $success ? SUCCESS : FAILED);
        return Unit.INSTANCE;
    }

    public static final void reportSplashDownloadDisable(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        report$default(splash, "download_disable", null, 2, null);
    }

    public static final void reportSplashListRequest(final String openEvent, final String state) {
        Intrinsics.checkNotNullParameter(openEvent, "openEvent");
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        report(null, "splash_list_request_state", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                Unit reportSplashListRequest$lambda$0;
                reportSplashListRequest$lambda$0 = SplashCustomReporterKt.reportSplashListRequest$lambda$0(openEvent, state, (Map) obj);
                return reportSplashListRequest$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashListRequest$lambda$0(String $openEvent, String $state, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("open_event", $openEvent);
        $this$report.put(TYPE_SUCCESS_STATE, $state);
        return Unit.INSTANCE;
    }

    public static final void reportSplashSerializeFailed(final boolean serialize, final String failReason) {
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        report(null, "splash_serialize", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit reportSplashSerializeFailed$lambda$0;
                reportSplashSerializeFailed$lambda$0 = SplashCustomReporterKt.reportSplashSerializeFailed$lambda$0(serialize, failReason, (Map) obj);
                return reportSplashSerializeFailed$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSplashSerializeFailed$lambda$0(boolean $serialize, String $failReason, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put($serialize ? "serialize_fail" : "deserialize_fail", $failReason);
        return Unit.INSTANCE;
    }

    public static final void reportDeepLinkByNewIntent(final String deeplink) {
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        report(null, "splash_called_up", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit reportDeepLinkByNewIntent$lambda$0;
                reportDeepLinkByNewIntent$lambda$0 = SplashCustomReporterKt.reportDeepLinkByNewIntent$lambda$0(deeplink, (Map) obj);
                return reportDeepLinkByNewIntent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDeepLinkByNewIntent$lambda$0(String $deeplink, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("deeplink", $deeplink);
        $this$report.put("exception", "new_intent");
        return Unit.INSTANCE;
    }

    public static final void reportStrategySplashNotSelectReason(final long strategyId, final int strategyIndex, final int strategyOriginIndex, final StrategyNotSelectReason reason, final SplashSource source, final boolean realShow) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(source, "source");
        report(null, "strategy_not_select", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                Unit reportStrategySplashNotSelectReason$lambda$0;
                reportStrategySplashNotSelectReason$lambda$0 = SplashCustomReporterKt.reportStrategySplashNotSelectReason$lambda$0(strategyId, strategyIndex, strategyOriginIndex, reason, source, realShow, (Map) obj);
                return reportStrategySplashNotSelectReason$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportStrategySplashNotSelectReason$lambda$0(long $strategyId, int $strategyIndex, int $strategyOriginIndex, StrategyNotSelectReason $reason, SplashSource $source, boolean $realShow, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("strategy_id", String.valueOf($strategyId));
        $this$report.put("strategy_index", String.valueOf($strategyIndex));
        $this$report.put("strategy_origin_index", String.valueOf($strategyOriginIndex));
        $this$report.put("reason", String.valueOf($reason.getReason()));
        $this$report.put("source", String.valueOf($source.getValue()));
        $this$report.put("real_show", String.valueOf($realShow));
        return Unit.INSTANCE;
    }

    public static final void reportPreloadDataExpired(final long timeSpan) {
        report(null, "preload_expired", new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                Unit reportPreloadDataExpired$lambda$0;
                reportPreloadDataExpired$lambda$0 = SplashCustomReporterKt.reportPreloadDataExpired$lambda$0(timeSpan, (Map) obj);
                return reportPreloadDataExpired$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportPreloadDataExpired$lambda$0(long $timeSpan, Map $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.put("time_difference", String.valueOf($timeSpan));
        return Unit.INSTANCE;
    }
}