package tv.danmaku.bili.ui.splash.ad.core;

import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelperKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCoreDataHolder.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010%¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/core/SplashCoreDataHolder;", "", "<init>", "()V", "preloadTimeMs", "", "getPreloadTimeMs", "()J", "setPreloadTimeMs", "(J)V", "preloadSplashData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "getPreloadSplashData", "()Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "setPreloadSplashData", "(Ltv/danmaku/bili/ui/splash/ad/model/SplashData;)V", "trustedPegasusTopViewList", "", "getTrustedPegasusTopViewList", "()Ljava/util/List;", "setTrustedPegasusTopViewList", "(Ljava/util/List;)V", "trustRealtimeShowTopView", "", "getTrustRealtimeShowTopView", "()Z", "trustedPegasusTopViewIds", "", "getTrustedPegasusTopViewIds", "()Ljava/lang/String;", "showStrategyList", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowStrategy;", "getShowStrategyList", "setShowStrategyList", "splashRequestId", "getSplashRequestId", "setSplashRequestId", "(Ljava/lang/String;)V", "initTrustedPegasusTopViewList", "", "getValidTopViewIds", "clearPreloadData", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashCoreDataHolder {
    private static SplashData preloadSplashData;
    private static long preloadTimeMs;
    private static List<SplashShowStrategy> showStrategyList;
    private static String splashRequestId;
    private static List<Long> trustedPegasusTopViewList;
    public static final SplashCoreDataHolder INSTANCE = new SplashCoreDataHolder();
    public static final int $stable = 8;

    private SplashCoreDataHolder() {
    }

    public final long getPreloadTimeMs() {
        return preloadTimeMs;
    }

    public final void setPreloadTimeMs(long j) {
        preloadTimeMs = j;
    }

    public final SplashData getPreloadSplashData() {
        return preloadSplashData;
    }

    public final void setPreloadSplashData(SplashData splashData) {
        preloadSplashData = splashData;
    }

    public final List<Long> getTrustedPegasusTopViewList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(trustedPegasusTopViewList);
    }

    public final void setTrustedPegasusTopViewList(List<Long> list) {
        trustedPegasusTopViewList = list;
    }

    public final boolean getTrustRealtimeShowTopView() {
        List<Long> list = trustedPegasusTopViewList;
        return (list != null && (list.isEmpty() ^ true)) || DDConfig.INSTANCE.getSplashTopViewBannerMixinExp();
    }

    public final String getTrustedPegasusTopViewIds() {
        String joinToString$default;
        List<Long> list = trustedPegasusTopViewList;
        return (list == null || (joinToString$default = CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? "" : joinToString$default;
    }

    public final void setShowStrategyList(List<SplashShowStrategy> list) {
        showStrategyList = list;
    }

    public final List<SplashShowStrategy> getShowStrategyList() {
        if (showStrategyList != null) {
            splashRequestId = SplashAdHelper.INSTANCE.getLastSplashRequestId();
            return EnhancedUnmodifiabilityKt.unmodifiable(showStrategyList);
        }
        SplashData splashData = preloadSplashData;
        splashRequestId = splashData != null ? splashData.getSplashRequestId() : null;
        SplashData splashData2 = preloadSplashData;
        return EnhancedUnmodifiabilityKt.unmodifiable(splashData2 != null ? splashData2.getStrategyList() : null);
    }

    public final String getSplashRequestId() {
        return splashRequestId;
    }

    public final void setSplashRequestId(String str) {
        splashRequestId = str;
    }

    public final void initTrustedPegasusTopViewList() {
        ArrayList arrayList;
        Iterable splashList;
        SplashData splashData = preloadSplashData;
        if (splashData != null && (splashList = splashData.getSplashList()) != null) {
            Iterable $this$filter$iv = splashList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Splash it = (Splash) element$iv$iv;
                if (it.isTopView() && it.isValid() && SplashCreativeHelperKt.isMainResourcesReady(it)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv2.add(Long.valueOf(((Splash) item$iv$iv).id));
            }
            arrayList = (List) destination$iv$iv2;
        } else {
            arrayList = null;
        }
        trustedPegasusTopViewList = arrayList;
        BLog.i("[Splash]SplashCoreDataHolder", "initTrustedPegasusTopViewList, topview ids get done");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0020 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getValidTopViewIds() {
        Iterable splashList;
        boolean z;
        SplashData splashData = preloadSplashData;
        if (splashData != null && (splashList = splashData.getSplashList()) != null) {
            Iterable $this$filter$iv = splashList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Splash it = (Splash) element$iv$iv;
                if (it.isTopView() && it.isValid() && SplashCreativeHelperKt.isMainResourcesReady(it)) {
                    SplashData splashData2 = preloadSplashData;
                    Intrinsics.checkNotNull(splashData2);
                    if (!SplashOrderSelectHelperKt.isReachSplashShowLimit(it, splashData2.getMaxCount())) {
                        z = true;
                        if (!z) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv2.add(Long.valueOf(((Splash) item$iv$iv).id));
            }
            String joinToString$default = CollectionsKt.joinToString$default((List) destination$iv$iv2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (joinToString$default != null) {
                return joinToString$default;
            }
        }
        return "";
    }

    public final void clearPreloadData() {
        BLog.i("[Splash]SplashCoreDataHolder", "clearPreloadData, cache clean");
        preloadSplashData = null;
        showStrategyList = null;
        splashRequestId = null;
        trustedPegasusTopViewList = null;
    }
}