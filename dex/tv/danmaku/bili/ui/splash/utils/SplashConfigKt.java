package tv.danmaku.bili.ui.splash.utils;

import android.content.SharedPreferences;
import com.bilibili.adcommon.utils.ext.AdExtensions;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.performance.DLog;
import com.bilibili.lib.stagger.StaggerManager;
import com.bilibili.lib.stagger.StaggerManagerKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: SplashConfig.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b:\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007\"\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007\"\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007\"\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007\"\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019\"\u001b\u0010\u001b\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001c\u0010\u0019\"\u001b\u0010\u001e\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001f\u0010\u0007\"\u001b\u0010!\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b\"\u0010\u0007\"\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u0007\"\u001b\u0010&\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b'\u0010\u0007\"\u001b\u0010)\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b*\u0010\u0007\"\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b.\u0010/\"\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007\"\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007\"\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007\"\u001b\u0010:\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0019\"\u001b\u0010=\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0019\"\u0011\u0010@\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bA\u0010\u0007\"\u001b\u0010B\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\t\u001a\u0004\bC\u0010\u0019\"\u001b\u0010E\u001a\u00020\u00178@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\t\u001a\u0004\bF\u0010\u0019\"\u001b\u0010H\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\t\u001a\u0004\bI\u0010\u0007\"\u001b\u0010K\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\t\u001a\u0004\bL\u0010\u0007\"\u001b\u0010N\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\t\u001a\u0004\bO\u0010\u0007\"\u001b\u0010Q\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\t\u001a\u0004\bR\u0010\u0007\"\u001b\u0010T\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\t\u001a\u0004\bU\u0010\u0007\"\u001b\u0010W\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\t\u001a\u0004\bX\u0010\u0007\"\u001b\u0010Z\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\t\u001a\u0004\b[\u0010\u0007\"\u001b\u0010]\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\t\u001a\u0004\b^\u0010\u0019\"+\u0010a\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bb\u0010\u0019\"\u0004\bc\u0010d¨\u0006g"}, d2 = {"FF_SPLASH_REALTIME_SHOW_LIST_EMPTY_ENABLE", "", "FF_SPLASH_EVENT_SPLASH_ENABLE", "TAG", "realTimeShowListEmptyEnable", "", "getRealTimeShowListEmptyEnable", "()Z", "realTimeShowListEmptyEnable$delegate", "Lkotlin/Lazy;", "eventSplashEnable", "getEventSplashEnable", "eventSplashEnable$delegate", "useVideoRelativePosition", "getUseVideoRelativePosition", "useVideoRelativePosition$delegate", "performDestroyViewOnDetach", "getPerformDestroyViewOnDetach", "performDestroyViewOnDetach$delegate", "realtimeSplashEnable", "getRealtimeSplashEnable", "realtimeSplashEnable$delegate", "splashMaxPrepareTime", "", "getSplashMaxPrepareTime", "()J", "splashMaxPrepareTime$delegate", "bannerSplashMaxPrepareTimeMs", "getBannerSplashMaxPrepareTimeMs", "bannerSplashMaxPrepareTimeMs$delegate", "useStagger", "getUseStagger", "useStagger$delegate", "businessSplashUsePeakDownloader", "getBusinessSplashUsePeakDownloader", "businessSplashUsePeakDownloader$delegate", "splashPrepareEnable", "getSplashPrepareEnable", "topViewReadShowEnable", "getTopViewReadShowEnable", "topViewReadShowEnable$delegate", "disableHotLaunchTopView", "getDisableHotLaunchTopView", "disableHotLaunchTopView$delegate", "splashGuideButtonMaxShowTime", "", "getSplashGuideButtonMaxShowTime", "()I", "splashGuideButtonMaxShowTime$delegate", "enableRequestSplashShow", "getEnableRequestSplashShow", "enableRequestSplashShow$delegate", "enableHotLaunchRequestList", "getEnableHotLaunchRequestList", "enableHotLaunchRequestList$delegate", "enableHotLaunchBehaviorRequestList", "getEnableHotLaunchBehaviorRequestList", "enableHotLaunchBehaviorRequestList$delegate", "hotSplashDelayRefreshListTimeMs", "getHotSplashDelayRefreshListTimeMs", "hotSplashDelayRefreshListTimeMs$delegate", "hotLaunchRequestListColdTimeMs", "getHotLaunchRequestListColdTimeMs", "hotLaunchRequestListColdTimeMs$delegate", "splashUseStreamIo", "getSplashUseStreamIo", "splashMaxPreloadExpireTimeMs", "getSplashMaxPreloadExpireTimeMs", "splashMaxPreloadExpireTimeMs$delegate", "clickGuideShowMaxCount", "getClickGuideShowMaxCount", "clickGuideShowMaxCount$delegate", "splashEnablePreloadExpireReload", "getSplashEnablePreloadExpireReload", "splashEnablePreloadExpireReload$delegate", "splashEnableEggClickable", "getSplashEnableEggClickable", "splashEnableEggClickable$delegate", "splashSurpriseRainClickable", "getSplashSurpriseRainClickable", "splashSurpriseRainClickable$delegate", "splashSchemeColdStockEnable", "getSplashSchemeColdStockEnable", "splashSchemeColdStockEnable$delegate", "splashUpdateListWhenEnterBackground", "getSplashUpdateListWhenEnterBackground", "splashUpdateListWhenEnterBackground$delegate", "splashListResponseSaveImmediate", "getSplashListResponseSaveImmediate", "splashListResponseSaveImmediate$delegate", "splashLocalSelectAnrFix", "getSplashLocalSelectAnrFix", "splashLocalSelectAnrFix$delegate", "danmakuSplashExitDelay", "getDanmakuSplashExitDelay", "danmakuSplashExitDelay$delegate", "<set-?>", "splashRequestDisperseInterval", "getSplashRequestDisperseInterval", "setSplashRequestDisperseInterval", "(J)V", "splashRequestDisperseInterval$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashConfigKt {
    private static final String FF_SPLASH_EVENT_SPLASH_ENABLE = "splash_event_splash_enable";
    private static final String FF_SPLASH_REALTIME_SHOW_LIST_EMPTY_ENABLE = "splash_realtime_show_list_empty_enable";
    private static final String TAG = "SplashConfig";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(SplashConfigKt.class, "splashRequestDisperseInterval", "getSplashRequestDisperseInterval()J", 1))};
    private static final Lazy realTimeShowListEmptyEnable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean realTimeShowListEmptyEnable_delegate$lambda$0;
            realTimeShowListEmptyEnable_delegate$lambda$0 = SplashConfigKt.realTimeShowListEmptyEnable_delegate$lambda$0();
            return Boolean.valueOf(realTimeShowListEmptyEnable_delegate$lambda$0);
        }
    });
    private static final Lazy eventSplashEnable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean eventSplashEnable_delegate$lambda$0;
            eventSplashEnable_delegate$lambda$0 = SplashConfigKt.eventSplashEnable_delegate$lambda$0();
            return Boolean.valueOf(eventSplashEnable_delegate$lambda$0);
        }
    });
    private static final Lazy useVideoRelativePosition$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda10
        public final Object invoke() {
            boolean useVideoRelativePosition_delegate$lambda$0;
            useVideoRelativePosition_delegate$lambda$0 = SplashConfigKt.useVideoRelativePosition_delegate$lambda$0();
            return Boolean.valueOf(useVideoRelativePosition_delegate$lambda$0);
        }
    });
    private static final Lazy performDestroyViewOnDetach$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda12
        public final Object invoke() {
            boolean performDestroyViewOnDetach_delegate$lambda$0;
            performDestroyViewOnDetach_delegate$lambda$0 = SplashConfigKt.performDestroyViewOnDetach_delegate$lambda$0();
            return Boolean.valueOf(performDestroyViewOnDetach_delegate$lambda$0);
        }
    });
    private static final Lazy realtimeSplashEnable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda13
        public final Object invoke() {
            boolean realtimeSplashEnable_delegate$lambda$0;
            realtimeSplashEnable_delegate$lambda$0 = SplashConfigKt.realtimeSplashEnable_delegate$lambda$0();
            return Boolean.valueOf(realtimeSplashEnable_delegate$lambda$0);
        }
    });
    private static final Lazy splashMaxPrepareTime$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda14
        public final Object invoke() {
            long splashMaxPrepareTime_delegate$lambda$0;
            splashMaxPrepareTime_delegate$lambda$0 = SplashConfigKt.splashMaxPrepareTime_delegate$lambda$0();
            return Long.valueOf(splashMaxPrepareTime_delegate$lambda$0);
        }
    });
    private static final Lazy bannerSplashMaxPrepareTimeMs$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda15
        public final Object invoke() {
            long bannerSplashMaxPrepareTimeMs_delegate$lambda$0;
            bannerSplashMaxPrepareTimeMs_delegate$lambda$0 = SplashConfigKt.bannerSplashMaxPrepareTimeMs_delegate$lambda$0();
            return Long.valueOf(bannerSplashMaxPrepareTimeMs_delegate$lambda$0);
        }
    });
    private static final Lazy useStagger$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda16
        public final Object invoke() {
            boolean useStagger_delegate$lambda$0;
            useStagger_delegate$lambda$0 = SplashConfigKt.useStagger_delegate$lambda$0();
            return Boolean.valueOf(useStagger_delegate$lambda$0);
        }
    });
    private static final Lazy businessSplashUsePeakDownloader$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda17
        public final Object invoke() {
            boolean businessSplashUsePeakDownloader_delegate$lambda$0;
            businessSplashUsePeakDownloader_delegate$lambda$0 = SplashConfigKt.businessSplashUsePeakDownloader_delegate$lambda$0();
            return Boolean.valueOf(businessSplashUsePeakDownloader_delegate$lambda$0);
        }
    });
    private static final Lazy topViewReadShowEnable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda18
        public final Object invoke() {
            boolean z;
            z = SplashConfigKt.topViewReadShowEnable_delegate$lambda$0();
            return Boolean.valueOf(z);
        }
    });
    private static final Lazy disableHotLaunchTopView$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda11
        public final Object invoke() {
            boolean disableHotLaunchTopView_delegate$lambda$0;
            disableHotLaunchTopView_delegate$lambda$0 = SplashConfigKt.disableHotLaunchTopView_delegate$lambda$0();
            return Boolean.valueOf(disableHotLaunchTopView_delegate$lambda$0);
        }
    });
    private static final Lazy splashGuideButtonMaxShowTime$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda19
        public final Object invoke() {
            int splashGuideButtonMaxShowTime_delegate$lambda$0;
            splashGuideButtonMaxShowTime_delegate$lambda$0 = SplashConfigKt.splashGuideButtonMaxShowTime_delegate$lambda$0();
            return Integer.valueOf(splashGuideButtonMaxShowTime_delegate$lambda$0);
        }
    });
    private static final Lazy enableRequestSplashShow$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda20
        public final Object invoke() {
            boolean enableRequestSplashShow_delegate$lambda$0;
            enableRequestSplashShow_delegate$lambda$0 = SplashConfigKt.enableRequestSplashShow_delegate$lambda$0();
            return Boolean.valueOf(enableRequestSplashShow_delegate$lambda$0);
        }
    });
    private static final Lazy enableHotLaunchRequestList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda21
        public final Object invoke() {
            boolean enableHotLaunchRequestList_delegate$lambda$0;
            enableHotLaunchRequestList_delegate$lambda$0 = SplashConfigKt.enableHotLaunchRequestList_delegate$lambda$0();
            return Boolean.valueOf(enableHotLaunchRequestList_delegate$lambda$0);
        }
    });
    private static final Lazy enableHotLaunchBehaviorRequestList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda22
        public final Object invoke() {
            boolean enableHotLaunchBehaviorRequestList_delegate$lambda$0;
            enableHotLaunchBehaviorRequestList_delegate$lambda$0 = SplashConfigKt.enableHotLaunchBehaviorRequestList_delegate$lambda$0();
            return Boolean.valueOf(enableHotLaunchBehaviorRequestList_delegate$lambda$0);
        }
    });
    private static final Lazy hotSplashDelayRefreshListTimeMs$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda23
        public final Object invoke() {
            long hotSplashDelayRefreshListTimeMs_delegate$lambda$0;
            hotSplashDelayRefreshListTimeMs_delegate$lambda$0 = SplashConfigKt.hotSplashDelayRefreshListTimeMs_delegate$lambda$0();
            return Long.valueOf(hotSplashDelayRefreshListTimeMs_delegate$lambda$0);
        }
    });
    private static final Lazy hotLaunchRequestListColdTimeMs$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda24
        public final Object invoke() {
            long hotLaunchRequestListColdTimeMs_delegate$lambda$0;
            hotLaunchRequestListColdTimeMs_delegate$lambda$0 = SplashConfigKt.hotLaunchRequestListColdTimeMs_delegate$lambda$0();
            return Long.valueOf(hotLaunchRequestListColdTimeMs_delegate$lambda$0);
        }
    });
    private static final Lazy splashMaxPreloadExpireTimeMs$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda25
        public final Object invoke() {
            long splashMaxPreloadExpireTimeMs_delegate$lambda$0;
            splashMaxPreloadExpireTimeMs_delegate$lambda$0 = SplashConfigKt.splashMaxPreloadExpireTimeMs_delegate$lambda$0();
            return Long.valueOf(splashMaxPreloadExpireTimeMs_delegate$lambda$0);
        }
    });
    private static final Lazy clickGuideShowMaxCount$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda26
        public final Object invoke() {
            long clickGuideShowMaxCount_delegate$lambda$0;
            clickGuideShowMaxCount_delegate$lambda$0 = SplashConfigKt.clickGuideShowMaxCount_delegate$lambda$0();
            return Long.valueOf(clickGuideShowMaxCount_delegate$lambda$0);
        }
    });
    private static final Lazy splashEnablePreloadExpireReload$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean splashEnablePreloadExpireReload_delegate$lambda$0;
            splashEnablePreloadExpireReload_delegate$lambda$0 = SplashConfigKt.splashEnablePreloadExpireReload_delegate$lambda$0();
            return Boolean.valueOf(splashEnablePreloadExpireReload_delegate$lambda$0);
        }
    });
    private static final Lazy splashEnableEggClickable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            boolean splashEnableEggClickable_delegate$lambda$0;
            splashEnableEggClickable_delegate$lambda$0 = SplashConfigKt.splashEnableEggClickable_delegate$lambda$0();
            return Boolean.valueOf(splashEnableEggClickable_delegate$lambda$0);
        }
    });
    private static final Lazy splashSurpriseRainClickable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            boolean splashSurpriseRainClickable_delegate$lambda$0;
            splashSurpriseRainClickable_delegate$lambda$0 = SplashConfigKt.splashSurpriseRainClickable_delegate$lambda$0();
            return Boolean.valueOf(splashSurpriseRainClickable_delegate$lambda$0);
        }
    });
    private static final Lazy splashSchemeColdStockEnable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda5
        public final Object invoke() {
            boolean splashSchemeColdStockEnable_delegate$lambda$0;
            splashSchemeColdStockEnable_delegate$lambda$0 = SplashConfigKt.splashSchemeColdStockEnable_delegate$lambda$0();
            return Boolean.valueOf(splashSchemeColdStockEnable_delegate$lambda$0);
        }
    });
    private static final Lazy splashUpdateListWhenEnterBackground$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda6
        public final Object invoke() {
            boolean splashUpdateListWhenEnterBackground_delegate$lambda$0;
            splashUpdateListWhenEnterBackground_delegate$lambda$0 = SplashConfigKt.splashUpdateListWhenEnterBackground_delegate$lambda$0();
            return Boolean.valueOf(splashUpdateListWhenEnterBackground_delegate$lambda$0);
        }
    });
    private static final Lazy splashListResponseSaveImmediate$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda7
        public final Object invoke() {
            boolean splashListResponseSaveImmediate_delegate$lambda$0;
            splashListResponseSaveImmediate_delegate$lambda$0 = SplashConfigKt.splashListResponseSaveImmediate_delegate$lambda$0();
            return Boolean.valueOf(splashListResponseSaveImmediate_delegate$lambda$0);
        }
    });
    private static final Lazy splashLocalSelectAnrFix$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda8
        public final Object invoke() {
            boolean splashLocalSelectAnrFix_delegate$lambda$0;
            splashLocalSelectAnrFix_delegate$lambda$0 = SplashConfigKt.splashLocalSelectAnrFix_delegate$lambda$0();
            return Boolean.valueOf(splashLocalSelectAnrFix_delegate$lambda$0);
        }
    });
    private static final Lazy danmakuSplashExitDelay$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.utils.SplashConfigKt$$ExternalSyntheticLambda9
        public final Object invoke() {
            long danmakuSplashExitDelay_delegate$lambda$0;
            danmakuSplashExitDelay_delegate$lambda$0 = SplashConfigKt.danmakuSplashExitDelay_delegate$lambda$0();
            return Long.valueOf(danmakuSplashExitDelay_delegate$lambda$0);
        }
    });
    private static final SharedPreferencesField splashRequestDisperseInterval$delegate = new SharedPreferencesField("sp_splash_request_disperse_interval", 0L, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    public static final boolean getRealTimeShowListEmptyEnable() {
        return ((Boolean) realTimeShowListEmptyEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean realTimeShowListEmptyEnable_delegate$lambda$0() {
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), FF_SPLASH_REALTIME_SHOW_LIST_EMPTY_ENABLE, (Object) null, 2, (Object) null);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "realTimeShowListEmptyEnable:" + value);
        return value;
    }

    public static final boolean getEventSplashEnable() {
        return ((Boolean) eventSplashEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eventSplashEnable_delegate$lambda$0() {
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), FF_SPLASH_EVENT_SPLASH_ENABLE, (Object) null, 2, (Object) null);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "eventSplashEnable:" + value);
        return value;
    }

    public static final boolean getUseVideoRelativePosition() {
        return ((Boolean) useVideoRelativePosition$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useVideoRelativePosition_delegate$lambda$0() {
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "splash_event_splash_use_video_relative_position", (Object) null, 2, (Object) null);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "useVideoRelativePosition:" + value);
        return value;
    }

    public static final boolean getPerformDestroyViewOnDetach() {
        return ((Boolean) performDestroyViewOnDetach$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean performDestroyViewOnDetach_delegate$lambda$0() {
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "ff_splash_perform_destroy_view_on_detach", (Object) null, 2, (Object) null);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_perform_destroy_view_on_detach:" + value);
        return value;
    }

    public static final boolean getRealtimeSplashEnable() {
        return ((Boolean) realtimeSplashEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean realtimeSplashEnable_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_realtime_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_realtime_splash_enable:" + value);
        return value;
    }

    public static final long getSplashMaxPrepareTime() {
        return ((Number) splashMaxPrepareTime$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long splashMaxPrepareTime_delegate$lambda$0() {
        Long longOrNull;
        String str = (String) ConfigManager.Companion.config().get("splash.business_splash_video_white_fix_time", "300");
        long value = (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 300L : longOrNull.longValue();
        BLog.i(TAG, "business_splash_video_white_fix_time:" + value);
        return value;
    }

    public static final long getBannerSplashMaxPrepareTimeMs() {
        return ((Number) bannerSplashMaxPrepareTimeMs$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long bannerSplashMaxPrepareTimeMs_delegate$lambda$0() {
        Long longOrNull;
        String dd = DeviceDecision.INSTANCE.dd("dd_splash_banner_splash_max_prepare_time_ms", "300");
        long value = (dd == null || (longOrNull = StringsKt.toLongOrNull(dd)) == null) ? 300L : longOrNull.longValue();
        BLog.i(TAG, "dd_splash_banner_splash_max_prepare_time_ms:" + value);
        return value;
    }

    public static final boolean getUseStagger() {
        return ((Boolean) useStagger$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useStagger_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_staggered_download_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        boolean staggerEnable = StaggerManagerKt.isEnabled(StaggerManager.INSTANCE);
        BLog.i(TAG, "ff_splash_use_stagger:" + value + " staggerEnable:" + staggerEnable);
        return value && staggerEnable;
    }

    public static final boolean getBusinessSplashUsePeakDownloader() {
        return ((Boolean) businessSplashUsePeakDownloader$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean businessSplashUsePeakDownloader_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_business_splash_use_peak_downloader", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_business_splash_use_peak_downloader:" + value);
        return value;
    }

    public static final boolean getSplashPrepareEnable() {
        return getSplashMaxPrepareTime() > 0;
    }

    public static final boolean getTopViewReadShowEnable() {
        return ((Boolean) topViewReadShowEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean topViewReadShowEnable_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_top_view_read_show_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_top_view_read_show:" + value);
        return value;
    }

    public static final boolean getDisableHotLaunchTopView() {
        return ((Boolean) disableHotLaunchTopView$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableHotLaunchTopView_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_disable_hot_launch_top_view", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_disable_hot_launch_top_view:" + value);
        return value;
    }

    public static final int getSplashGuideButtonMaxShowTime() {
        return ((Number) splashGuideButtonMaxShowTime$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int splashGuideButtonMaxShowTime_delegate$lambda$0() {
        int value = AdExtensions.toIntOrDefault((String) ConfigManager.Companion.config().get("splash.button_guide_show_times", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE), 5);
        BLog.i(TAG, "splash.button_guide_show_times:" + value);
        return value;
    }

    public static final boolean getEnableRequestSplashShow() {
        return ((Boolean) enableRequestSplashShow$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableRequestSplashShow_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_enable_request_show", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_enable_request_show:" + value);
        return value;
    }

    public static final boolean getEnableHotLaunchRequestList() {
        return ((Boolean) enableHotLaunchRequestList$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableHotLaunchRequestList_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_hot_launch_request_list_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_hot_launch_request_list_enable:" + value);
        return value;
    }

    public static final boolean getEnableHotLaunchBehaviorRequestList() {
        return ((Boolean) enableHotLaunchBehaviorRequestList$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableHotLaunchBehaviorRequestList_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_hot_launch_behavior_request_list_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_hot_launch_behavior_request_list_enable:" + value);
        return value;
    }

    public static final long getHotSplashDelayRefreshListTimeMs() {
        return ((Number) hotSplashDelayRefreshListTimeMs$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long hotSplashDelayRefreshListTimeMs_delegate$lambda$0() {
        long value = AdExtensions.toLongOrDefault((String) ConfigManager.Companion.config().get("splash.hot_launch_refresh_list_delay_ms", "2000"), (long) PlayerToastConfig.DURATION_2);
        BLog.i(TAG, "splash.hot_launch_refresh_list_delay_ms:" + value);
        return value;
    }

    public static final long getHotLaunchRequestListColdTimeMs() {
        return ((Number) hotLaunchRequestListColdTimeMs$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long hotLaunchRequestListColdTimeMs_delegate$lambda$0() {
        long value = AdExtensions.toLongOrDefault((String) ConfigManager.Companion.config().get("splash.hot_launch_request_list_cold_time_ms", "500"), 500L);
        BLog.i(TAG, "splash.hot_launch_request_list_cold_time_ms:" + value);
        return value;
    }

    public static final boolean getSplashUseStreamIo() {
        boolean z;
        try {
            z = DeviceDecision.INSTANCE.getBoolean("ff_splash_use_stream_reader", true);
        } catch (Throwable th) {
            z = false;
        }
        boolean it = z;
        BLog.i(TAG, "ff_splash_use_stream_reader:" + it);
        DLog.i(TAG, "ff_splash_use_stream_reader:" + it);
        return z;
    }

    public static final long getSplashMaxPreloadExpireTimeMs() {
        return ((Number) splashMaxPreloadExpireTimeMs$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long splashMaxPreloadExpireTimeMs_delegate$lambda$0() {
        long value = AdExtensions.toLongOrDefault((String) ConfigManager.Companion.config().get("splash.splash_preload_max_expired_time_second", "60"), 60L);
        BLog.i(TAG, "splash.splash_preload_max_expired_time_second:" + value);
        return ((long) IjkMediaCodecInfo.RANK_MAX) * value;
    }

    public static final long getClickGuideShowMaxCount() {
        return ((Number) clickGuideShowMaxCount$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long clickGuideShowMaxCount_delegate$lambda$0() {
        long value = AdExtensions.toLongOrDefault(DeviceDecision.INSTANCE.dd("splash.splash_animation_guide_max_count", "3"), 3L);
        BLog.i(TAG, "splash.splash_animation_guide_max_count:" + value);
        return value;
    }

    public static final boolean getSplashEnablePreloadExpireReload() {
        return ((Boolean) splashEnablePreloadExpireReload$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashEnablePreloadExpireReload_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_enable_preload_expire_reload", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_enable_preload_expire_reload:" + value);
        return value;
    }

    public static final boolean getSplashEnableEggClickable() {
        return ((Boolean) splashEnableEggClickable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashEnableEggClickable_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_egg_click_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_egg_click_enable:" + value);
        return value;
    }

    public static final boolean getSplashSurpriseRainClickable() {
        return ((Boolean) splashSurpriseRainClickable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashSurpriseRainClickable_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_splash_business_egg_click_enable", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "ff_splash_business_egg_click_enable:" + value);
        return value;
    }

    public static final boolean getSplashSchemeColdStockEnable() {
        return ((Boolean) splashSchemeColdStockEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashSchemeColdStockEnable_delegate$lambda$0() {
        boolean enable = DeviceDecision.INSTANCE.getBoolean("dd_splash_scheme_cold_start_can_show_hot_splash", true);
        BLog.i(TAG, "dd_splash_scheme_cold_start_can_show_hot_splash:" + enable);
        return enable;
    }

    public static final boolean getSplashUpdateListWhenEnterBackground() {
        return ((Boolean) splashUpdateListWhenEnterBackground$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashUpdateListWhenEnterBackground_delegate$lambda$0() {
        boolean enable = DeviceDecision.INSTANCE.getBoolean("dd_splash_update_list_background", false);
        BLog.i(TAG, "dd_splash_update_list_background:" + enable);
        return enable;
    }

    public static final boolean getSplashListResponseSaveImmediate() {
        return ((Boolean) splashListResponseSaveImmediate$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashListResponseSaveImmediate_delegate$lambda$0() {
        boolean enable = DeviceDecision.INSTANCE.getBoolean("dd_splash_list_response_save_immediate", true);
        BLog.i(TAG, "dd_splash_list_response_save_immediate:" + enable);
        return enable;
    }

    public static final boolean getSplashLocalSelectAnrFix() {
        return ((Boolean) splashLocalSelectAnrFix$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean splashLocalSelectAnrFix_delegate$lambda$0() {
        boolean enable = DeviceDecision.INSTANCE.getBoolean("dd_splash_local_select_anr_fix", true);
        BLog.i(TAG, "dd_splash_local_select_anr_fix:" + enable);
        return enable;
    }

    public static final long getDanmakuSplashExitDelay() {
        return ((Number) danmakuSplashExitDelay$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long danmakuSplashExitDelay_delegate$lambda$0() {
        long value = AdExtensions.toLongOrDefault(DeviceDecision.INSTANCE.dd("dd_splash_danmaku_splash_exit_delay", "250"), 250L);
        BLog.i(TAG, "splash.dd_splash_danmaku_splash_exit_delay:" + value + " ms");
        return value;
    }

    public static final long getSplashRequestDisperseInterval() {
        return ((Number) splashRequestDisperseInterval$delegate.getValue((Object) null, $$delegatedProperties[0])).longValue();
    }

    public static final void setSplashRequestDisperseInterval(long j) {
        splashRequestDisperseInterval$delegate.setValue((Object) null, $$delegatedProperties[0], Long.valueOf(j));
    }
}