package tv.danmaku.bili.splash.ad.core;

import android.util.LongSparseArray;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.globalactions.TopViewIdsUpdateAction;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.core.model.SplashTaskResultWrapper;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashExtra;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashListResponseKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashShowResponse;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategyKt;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashOrderFilterReason;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.reporter.tech.StrategyNotSelectReason;
import tv.danmaku.bili.splash.ad.services.SplashServiceHelperKt;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashOrderSelectComponent.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u001a\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0003\u001a\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0003\u001aJ\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a@\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a8\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001eH\u0002\u001a\u0014\u0010&\u001a\u00020\u0007*\u00020\u00032\u0006\u0010%\u001a\u00020\u001eH\u0000\u001a@\u0010'\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a<\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u00072\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"TAG", "", "getLocalListShowSplashInner", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "source", "Ltv/danmaku/bili/splash/ad/model/SplashSource;", "rePreload", "", "getRealtimeShowSplashInner", "Ltv/danmaku/bili/splash/ad/core/model/SplashTaskResultWrapper;", "getRealtimeMaterialSplashInner", "getRealtimeShowTopViewSplashInner", "taskResult", "expectTopViewId", "", "loadSplashForShowInner", "", "isPreload", "requestRealShowSplashInner", "requestRealShowSplashInnerApi", "selectSplashOrder", "data", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "showStrategyList", "", "Ltv/danmaku/bili/splash/ad/model/SplashShowStrategy;", "splashRequestId", "fromRealShow", "isValidBusinessSplash", "step", "", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "strategy", "index", "realShow", "isSceneSupport", "isSplashReachShowCountLimit", "maxCount", "isReachSplashShowLimit", "isSplashResReady", "requestId", "resortRealTimeShowList", "splashList", "showStrategy", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashOrderSelectComponentKt {
    private static final String TAG = "[Splash]SplashOrderSelectComponent";

    /* compiled from: SplashOrderSelectComponent.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SplashSource.values().length];
            try {
                iArr[SplashSource.CALL_UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SplashOrder getLocalListShowSplashInner(SplashSource source, boolean rePreload) {
        Intrinsics.checkNotNullParameter(source, "source");
        BLog.i(TAG, "getLocalListShowSplashInner，source = " + source.getValue() + ", rePreload = " + rePreload);
        SplashOrder splashOrder = null;
        if (WhenMappings.$EnumSwitchMapping$0[source.ordinal()] == 1) {
            SplashListResponse splashListResponse = SplashManagerKt.getSplashState().getData().getSplashListResponse();
            List<SplashShowStrategy> realShowStrategyList = SplashManagerKt.getSplashState().getData().getRealShowStrategyList();
            String realShowRequestId = SplashManagerKt.getSplashState().getData().getRealShowRequestId();
            if (realShowRequestId == null) {
                realShowRequestId = "";
            }
            SplashOrder $this$getLocalListShowSplashInner_u24lambda_u240 = selectSplashOrder$default(splashListResponse, realShowStrategyList, source, realShowRequestId, false, 0L, 48, null);
            if ($this$getLocalListShowSplashInner_u24lambda_u240 != null) {
                $this$getLocalListShowSplashInner_u24lambda_u240.getRuntimeExtra().setSplashRequestId(SplashManagerKt.getSplashState().getData().getRealShowRequestId());
                splashOrder = $this$getLocalListShowSplashInner_u24lambda_u240;
            }
            SplashOrder localShowSplash = splashOrder;
            return localShowSplash;
        } else if (rePreload || SplashManagerKt.getSplashState().getData().getLocalShowSplash() == null || source == SplashSource.HOT) {
            loadSplashForShowInner(rePreload, source);
            SplashOrder localShowSplash2 = SplashManagerKt.getSplashState().getData().getLocalShowSplash();
            SplashManagerKt.getSplashState().getData().setLocalShowSplash(null);
            return localShowSplash2;
        } else {
            SplashOrder localShowSplash3 = SplashManagerKt.getSplashState().getData().getLocalShowSplash();
            SplashManagerKt.getSplashState().getData().setLocalShowSplash(null);
            return localShowSplash3;
        }
    }

    public static final SplashTaskResultWrapper getRealtimeShowSplashInner() {
        BLog.i(TAG, "getRealtimeShowSplashInner");
        if (SplashManagerKt.getSplashState().getPreloadStartTime() != 0) {
            SplashCustomReporterKt.reportSplashTotalRequestTime(System.currentTimeMillis() - SplashManagerKt.getSplashState().getPreloadStartTime());
        }
        SplashOrder realShowSplash = SplashManagerKt.getSplashState().getData().getRealShowSplash();
        boolean realtimeShowFinish = SplashManagerKt.getSplashState().getData().getRealShowJobSuccess();
        List<SplashShowStrategy> realShowStrategyList = SplashManagerKt.getSplashState().getData().getRealShowStrategyList();
        long count = (realShowStrategyList != null ? Integer.valueOf(realShowStrategyList.size()) : 0L).longValue();
        if (realtimeShowFinish) {
            SplashAdHelper.INSTANCE.adSplashCodeRequestUIEvent$adsplash_debug(count);
            BLog.i(TAG, "reportShowRequestSuccess");
            SplashCustomReporterKt.reportShowRequestSuccess();
            SplashTaskResultWrapper result = new SplashTaskResultWrapper(SplashManagerKt.getSplashState().getData().getSplashListResponse(), realShowSplash, SplashManagerKt.getSplashState().getData().getRealShowStrategyList(), SplashManagerKt.getSplashState().getData().getRealShowRequestId());
            SplashManagerKt.getSplashState().getData().setRealShowSplash(null);
            if (count <= 0 && (!SplashConfigKt.getRealTimeShowListEmptyEnable() || count != 0)) {
                return null;
            }
            return result;
        }
        SplashAdHelper.INSTANCE.adSplashCodeRequestUIEvent$adsplash_debug(-1L);
        BLog.i(TAG, "reportShowRequestFailed");
        SplashCustomReporterKt.reportShowRequestFailed();
        return null;
    }

    public static final SplashOrder getRealtimeMaterialSplashInner(SplashSource source) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        BLog.i(TAG, "getRealtimeMaterialSplashInner");
        SplashOrder realTimeSplash = SplashManagerKt.getSplashState().getData().getRealTimeSplash();
        if (realTimeSplash == null) {
            return null;
        }
        SplashManagerKt.getSplashState().getData().setRealTimeSplash(null);
        Job loadJob = SplashRealtimeMaterialComponentKt.getRealtimeMaterialLoadJob();
        if (loadJob == null) {
            return null;
        }
        SplashRealtimeMaterialComponentKt.setRealtimeMaterialLoadJob(null);
        if (!loadJob.isCompleted() || !realTimeSplash.getRuntimeExtra().getRealtimeMaterialLoadSuccess()) {
            BLog.i(TAG, "getRealtimeMaterialSplashInner, job not complete,splash id = " + realTimeSplash.getId());
            SplashAdHelper.INSTANCE.adSplashRealtimeFailUIEvent$adsplash_debug(realTimeSplash);
            SplashCustomReporterKt.reportRealtimeDownloadFailed(realTimeSplash);
            Job job = loadJob.isActive() ? loadJob : null;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
            long id = realTimeSplash.getId();
            int originRealTimeShowIndex = realTimeSplash.getRuntimeExtra().getOriginRealTimeShowIndex();
            String realShowRequestId = SplashManagerKt.getSplashState().getData().getRealShowRequestId();
            SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(splashAdHelper, 0, realTimeSplash, id, originRealTimeShowIndex, realShowRequestId == null ? "" : realShowRequestId, source.getValue(), true, null, SplashOrderFilterReason.RESOURCE_NOT_READY, BR.cover, null);
            return null;
        }
        SplashAdHelper splashAdHelper2 = SplashAdHelper.INSTANCE;
        long id2 = realTimeSplash.getId();
        int originRealTimeShowIndex2 = realTimeSplash.getRuntimeExtra().getOriginRealTimeShowIndex();
        String splashRequestId = realTimeSplash.getRuntimeExtra().getSplashRequestId();
        if (splashRequestId != null || (splashRequestId = SplashManagerKt.getSplashState().getData().getRealShowRequestId()) != null) {
            str = splashRequestId;
        } else {
            str = "";
        }
        SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(splashAdHelper2, 0, realTimeSplash, id2, originRealTimeShowIndex2, str, source.getValue(), true, null, SplashOrderFilterReason.SELECTED, BR.cover, null);
        SplashAdHelper.INSTANCE.adSplashRealtimeFinishUIEvent$adsplash_debug(realTimeSplash);
        SplashCustomReporterKt.reportRealtimeDownloadSuccess(realTimeSplash);
        return realTimeSplash;
    }

    public static final SplashOrder getRealtimeShowTopViewSplashInner(SplashTaskResultWrapper taskResult, long expectTopViewId) {
        SplashListResponse data;
        BLog.i(TAG, "getRealtimeShowTopViewSplashInner");
        if (taskResult == null || (data = taskResult.getSplashData()) == null) {
            return null;
        }
        List<SplashShowStrategy> realTimeShowStrategies = taskResult.getRealTimeShowStrategies();
        SplashSource splashSource = SplashSource.COLD;
        String requestId = taskResult.getRequestId();
        if (requestId == null) {
            requestId = "";
        }
        return selectSplashOrder(data, realTimeShowStrategies, splashSource, requestId, true, expectTopViewId);
    }

    public static final void loadSplashForShowInner(boolean isPreload, SplashSource source) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(source, "source");
        BLog.i(TAG, "loadSplashForShowInner, isPreload = " + isPreload + ", source = " + source.getValue());
        SplashListResponse localData = SplashUpdateComponentKt.readConfigFromDisk();
        if (localData == null) {
            return;
        }
        SplashManagerKt.getSplashState().getData().setSplashListResponse(localData);
        SplashManagerKt.getSplashState().setSplashHotShowInterval(SplashListResponseKt.getValidIntervalForShow(localData));
        List<SplashShowStrategy> strategyList = localData.getStrategyList();
        String splashRequestId = localData.getSplashRequestId();
        String str = "";
        SplashOrder localShowSplash = selectSplashOrder$default(localData, strategyList, source, splashRequestId == null ? "" : splashRequestId, false, 0L, 48, null);
        List validTopViewList = null;
        if (localShowSplash == null) {
            localShowSplash = null;
        } else {
            localShowSplash.getRuntimeExtra().setSplashRequestId(localData.getSplashRequestId());
        }
        SplashManagerKt.getSplashState().getData().setLocalShowSplash(localShowSplash);
        if (isPreload) {
            requestRealShowSplashInner(source);
            if (!DDConfig.INSTANCE.getSplashTopViewBannerMixinExp()) {
                if (!(localShowSplash != null && ExtSplashOrderKt.getHasTopViewLinkedCard(localShowSplash))) {
                    Iterable splashList = localData.getSplashList();
                    if (splashList != null) {
                        Iterable $this$filter$iv = splashList;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            SplashOrder it = (SplashOrder) element$iv$iv;
                            if (((ExtSplashOrderKt.isTopView(it) && ExtSplashOrderKt.isTimeValid(it) && ExtSplashOrderKt.isMainResourceReady(it)) ? 1 : null) != null) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$map$iv = (List) destination$iv$iv;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv2.add(Long.valueOf(((SplashOrder) item$iv$iv).getId()));
                        }
                        validTopViewList = (List) destination$iv$iv2;
                    }
                    SplashManagerKt.getSplashState().getData().setTrustedPegasusTopViewList(validTopViewList);
                    if (validTopViewList != null && (joinToString$default = CollectionsKt.joinToString$default(validTopViewList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) != null) {
                        str = joinToString$default;
                    }
                    String ids = str;
                    SplashViewModel.Companion.update(new TopViewIdsUpdateAction(ids));
                    BLog.i(TAG, "topview ids get done, ids = " + ids);
                }
            }
        }
    }

    private static final void requestRealShowSplashInner(SplashSource source) {
        if (SplashConfigKt.getEnableRequestSplashShow()) {
            SplashManagerKt.getSplashState().setShowRequestStartTime(System.currentTimeMillis());
            BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashOrderSelectComponentKt$requestRealShowSplashInner$1(source, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestRealShowSplashInnerApi(SplashSource source) {
        List realShowStrategyList;
        Object element$iv;
        JsonObject banner;
        boolean z;
        List list;
        Iterable splashList;
        String str = "";
        if (DDConfig.INSTANCE.getSplashTopViewBannerMixinExp()) {
            long start$iv = System.currentTimeMillis();
            SplashListResponse response = SplashManagerKt.getSplashState().getData().getSplashListResponse();
            int maxCount = response != null ? response.getMaxCount() : 3;
            if (response != null && (splashList = response.getSplashList()) != null) {
                Iterable $this$filter$iv = splashList;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    SplashOrder it = (SplashOrder) element$iv$iv;
                    if (ExtSplashOrderKt.isTopView(it) && ExtSplashOrderKt.isTimeValid(it) && ExtSplashOrderKt.isMainResourceReady(it) && !isReachSplashShowLimit(it, maxCount)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    SplashOrder it2 = (SplashOrder) item$iv$iv;
                    destination$iv$iv2.add(Long.valueOf(it2.getId()));
                }
                list = (List) destination$iv$iv2;
            } else {
                list = null;
            }
            List validTopViewList = list;
            str = (validTopViewList == null || (r4 = CollectionsKt.joinToString$default(validTopViewList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? "" : "";
            long $this$requestRealShowSplashInnerApi_u24lambda_u241 = System.currentTimeMillis() - start$iv;
            BLog.i(TAG, "requestRealShowSplashInner, prepareTopViewIds done, ids = " + ((Object) str) + ", cost = " + $this$requestRealShowSplashInnerApi_u24lambda_u241);
        }
        SplashShowResponse showResponse = SplashServiceHelperKt.requestSplashShow(str);
        BLog.i(TAG, "requestShow success");
        if (showResponse == null || (realShowStrategyList = showResponse.getStrategyList()) == null) {
            realShowStrategyList = CollectionsKt.emptyList();
        }
        SplashManagerKt.getSplashState().getData().setRealShowRequestId(showResponse != null ? showResponse.getSplashRequestId() : null);
        SplashManagerKt.getSplashState().getData().setRealShowStrategyList(realShowStrategyList);
        int realTimeSplashCount = SplashRealtimeMaterialComponentKt.handleRealTimeSplashLoad(realShowStrategyList, source);
        SplashManagerKt.getSplashState().setRealtimeShowSelectStartTime(System.currentTimeMillis());
        SplashListResponse splashListResponse = SplashManagerKt.getSplashState().getData().getSplashListResponse();
        String realShowRequestId = SplashManagerKt.getSplashState().getData().getRealShowRequestId();
        SplashOrder realShowSplash = selectSplashOrder$default(splashListResponse, realShowStrategyList, source, realShowRequestId == null ? "" : realShowRequestId, true, 0L, 32, null);
        long realShowSelectEndTime = System.currentTimeMillis();
        if (realShowSplash != null) {
            realShowSplash.getRuntimeExtra().setSplashRequestId(showResponse != null ? showResponse.getSplashRequestId() : null);
            SplashExtra runtimeExtra = realShowSplash.getRuntimeExtra();
            Iterable $this$firstOrNull$iv = realShowStrategyList;
            Iterator<T> it3 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it3.hasNext()) {
                    element$iv = it3.next();
                    SplashShowStrategy it4 = (SplashShowStrategy) element$iv;
                    if (it4.getId() == realShowSplash.getId()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            SplashShowStrategy splashShowStrategy = (SplashShowStrategy) element$iv;
            runtimeExtra.setBindBanner((splashShowStrategy == null || (banner = splashShowStrategy.getBanner()) == null) ? null : JsonUtilKt.toJson(banner));
        }
        SplashCustomReporterKt.reportShowRequestTime(realShowSelectEndTime - SplashManagerKt.getSplashState().getShowRequestStartTime(), realShowStrategyList.size(), realTimeSplashCount, realShowSelectEndTime - SplashManagerKt.getSplashState().getRealtimeShowSelectStartTime());
        SplashManagerKt.getSplashState().getData().setRealShowJobSuccess(true);
        SplashManagerKt.getSplashState().getData().setRealShowSplash(realShowSplash);
        BLog.i(TAG, "requestShow end");
    }

    static /* synthetic */ SplashOrder selectSplashOrder$default(SplashListResponse splashListResponse, List list, SplashSource splashSource, String str, boolean z, long j, int i, Object obj) {
        return selectSplashOrder(splashListResponse, list, splashSource, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? false : z, (i & 32) != 0 ? 0L : j);
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x0050 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final SplashOrder selectSplashOrder(SplashListResponse data, List<SplashShowStrategy> list, SplashSource source, String splashRequestId, boolean fromRealShow, long expectTopViewId) {
        int step;
        boolean z;
        boolean needUpdateConfig;
        Object obj = null;
        if (data != null) {
            List<SplashShowStrategy> list2 = list;
            boolean z2 = true;
            if (list2 == null || list2.isEmpty()) {
                return null;
            }
            if (fromRealShow) {
                step = expectTopViewId != 0 ? 3 : 2;
            } else {
                step = 1;
            }
            Iterable sortedShowList = resortRealTimeShowList(fromRealShow, data.getSplashList(), list, expectTopViewId);
            Iterable $this$forEachIndexed$iv = sortedShowList;
            int index$iv = 0;
            Iterator<T> it = $this$forEachIndexed$iv.iterator();
            boolean needUpdateConfig2 = false;
            while (needUpdateConfig) {
                Object item$iv = it.next();
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SplashShowStrategy strategy = (SplashShowStrategy) item$iv;
                int strategyIndex = index$iv;
                if (!SplashShowStrategyKt.isValid(strategy)) {
                    BLog.i(TAG, "findTheOne, strategy time not valid, id = " + strategy.getId() + ", strategy.index = " + strategy.getOriginIndex());
                    SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), strategyIndex, strategy.getOriginIndex(), StrategyNotSelectReason.STRATEGY_TIME_INVALID, source, fromRealShow);
                    z = z2;
                    SplashAdHelper.INSTANCE.reportSplashOrderSelectFilterEvent$adsplash_debug(step, null, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : strategyIndex, splashRequestId, source.getValue(), fromRealShow, strategy.getAdCb(), SplashOrderFilterReason.STRATEGY_TIME_INVALID);
                } else {
                    z = z2;
                    boolean foundSplashId = false;
                    Iterable splashList = data.getSplashList();
                    if (splashList != null) {
                        Iterable $this$forEach$iv = splashList;
                        for (Object element$iv : $this$forEach$iv) {
                            SplashOrder splash = (SplashOrder) element$iv;
                            if (splash.getId() == strategy.getId()) {
                                foundSplashId = true;
                                String adCb = strategy.getAdCb();
                                if (!((adCb == null || StringsKt.isBlank(adCb)) ? z : false)) {
                                    splash.setAdCb(strategy.getAdCb());
                                }
                            }
                            if (isValidBusinessSplash(step, splash, strategy, strategyIndex, source, fromRealShow, splashRequestId)) {
                                int oldCount = splash.getLocalExposeCount();
                                boolean reachShowLimit = isSplashReachShowCountLimit(splash, strategy, strategyIndex, source, fromRealShow, SplashListResponseKt.getValidMaxCount(data));
                                if (oldCount == splash.getLocalExposeCount()) {
                                    needUpdateConfig = needUpdateConfig2;
                                } else {
                                    needUpdateConfig = true;
                                }
                                if (reachShowLimit) {
                                    SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper.INSTANCE, step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : strategyIndex, splashRequestId, source.getValue(), fromRealShow, null, SplashOrderFilterReason.REACH_MAX_SHOW_COUNT, BR.cover, null);
                                } else {
                                    List<Long> keepIds = data.getKeepIds();
                                    if (((keepIds == null || keepIds.contains(Long.valueOf(splash.getId())) != z) ? false : z) && splash.isLocalExposed()) {
                                        SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), strategyIndex, strategy.getOriginIndex(), StrategyNotSelectReason.PROGRAM_EXPOSED, source, fromRealShow);
                                        SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper.INSTANCE, step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : strategyIndex, splashRequestId, source.getValue(), fromRealShow, null, SplashOrderFilterReason.PROGRAM_EXPOSED, BR.cover, null);
                                    } else {
                                        boolean isResReady = isSplashResReady(step, splash, strategy, strategyIndex, source, fromRealShow, splashRequestId);
                                        if (isResReady) {
                                            if (needUpdateConfig) {
                                                BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashOrderSelectComponentKt$selectSplashOrder$1$1$1(data, null), 3, (Object) null);
                                            }
                                            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), strategyIndex, strategy.getOriginIndex(), StrategyNotSelectReason.SELECTED, source, fromRealShow);
                                            SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper.INSTANCE, step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : strategyIndex, splashRequestId, source.getValue(), fromRealShow, null, SplashOrderFilterReason.SELECTED, BR.cover, null);
                                            splash.getRuntimeExtra().setOriginRealTimeShowIndex(strategy.getOriginIndex());
                                            return splash;
                                        }
                                    }
                                }
                                needUpdateConfig2 = needUpdateConfig;
                            }
                        }
                    }
                    if (!foundSplashId) {
                        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
                        long id = strategy.getId();
                        String realShowRequestId = SplashManagerKt.getSplashState().getData().getRealShowRequestId();
                        if (realShowRequestId == null) {
                            realShowRequestId = "";
                        }
                        SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(splashAdHelper, step, null, id, strategyIndex, realShowRequestId, source.getValue(), true, null, SplashOrderFilterReason.LOCAL_LIST_NOT_CONTAIN, BR.cover, null);
                    }
                }
                z2 = z;
                index$iv = index$iv2;
                obj = null;
            }
            return null;
        }
        return null;
    }

    private static final boolean isValidBusinessSplash(int step, SplashOrder splash, SplashShowStrategy strategy, int index, SplashSource source, boolean realShow, String splashRequestId) {
        if (splash.getId() != strategy.getId()) {
            return false;
        }
        if (!realShow && DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() && ExtSplashOrderKt.isTopView(splash)) {
            BLog.i(TAG, "isValidBusinessSplash, mixExp not support local show topview");
            return false;
        } else if (!ExtSplashOrderKt.isTimeValid(splash)) {
            BLog.i(TAG, "isValidBusinessSplash, splashId = " + splash.getId() + " time not valid");
            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.SPLASH_TIME_INVALID, source, realShow);
            SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper.INSTANCE, step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : index, splashRequestId, source.getValue(), realShow, null, SplashOrderFilterReason.SPLASH_TIME_INVALID, BR.cover, null);
            return false;
        } else if (!isSceneSupport(splash, source)) {
            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.SPLASH_MISMATCH_SCENE, source, realShow);
            SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper.INSTANCE, step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : index, splashRequestId, source.getValue(), realShow, null, SplashOrderFilterReason.SPLASH_MISMATCH_SCENE, BR.cover, null);
            return false;
        } else {
            return true;
        }
    }

    private static final boolean isSceneSupport(SplashOrder splash, SplashSource source) {
        if (source == SplashSource.CALL_UP && !splash.getSupportCalledUp()) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.getId() + " from callup but splash not support");
            return false;
        } else if (source == SplashSource.HOT && ExtSplashOrderKt.isTopView(splash) && SplashConfigKt.getDisableHotLaunchTopView()) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.getId() + " hot show topview disable");
            return false;
        } else if (source == SplashSource.HOT && splash.getCardType() == 109) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.getId() + " hot show not support story splash");
            return false;
        } else if (source == SplashSource.HOT && ExtSplashOrderKt.isSearchLinkage(splash)) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.getId() + " hot show not support search linkage splash");
            return false;
        } else if (source == SplashSource.HOT && ExtSplashOrderKt.isMiddlePageSplash(splash)) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.getId() + " hot show not support middle page splash");
            return false;
        } else if (ListDeviceInfoKt.isHdApp() && ExtSplashOrderKt.isTopView(splash)) {
            BLog.i(TAG, "isSceneSupport, splashId = " + splash.getId() + " hd not support top view splash");
            return false;
        } else {
            return true;
        }
    }

    private static final boolean isSplashReachShowCountLimit(SplashOrder splash, SplashShowStrategy strategy, int index, SplashSource source, boolean realShow, int maxCount) {
        long lastShowTime = splash.getLastExposeTime();
        Date lastShowDate = new Date(lastShowTime);
        Date today = new Date();
        if (!DateUtils.isSameDay(lastShowDate, today)) {
            splash.setLocalExposeCount(0);
        }
        boolean reachLimit = splash.getLocalExposeCount() >= maxCount;
        if (reachLimit) {
            BLog.i(TAG, "isSplashReachShowCountLimit, splashId = " + splash.getId() + " reach limit. maxCount = " + maxCount);
            SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.REACH_MAX_SHOW_COUNT, source, realShow);
        }
        return reachLimit;
    }

    public static final boolean isReachSplashShowLimit(SplashOrder $this$isReachSplashShowLimit, int maxCount) {
        int showCount;
        Intrinsics.checkNotNullParameter($this$isReachSplashShowLimit, "<this>");
        long lastShowTime = $this$isReachSplashShowLimit.getLastExposeTime();
        Date lastShowDate = new Date(lastShowTime);
        Date today = new Date();
        if (!DateUtils.isSameDay(lastShowDate, today)) {
            showCount = 0;
        } else {
            showCount = $this$isReachSplashShowLimit.getLocalExposeCount();
        }
        return showCount >= maxCount;
    }

    private static final boolean isSplashResReady(int step, SplashOrder splash, SplashShowStrategy strategy, int index, SplashSource source, boolean realShow, String requestId) {
        File imageFile = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splash.getImageHash());
        File videoFile = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splash.getVideoHash());
        if (imageFile == null && videoFile == null) {
            BLog.e(TAG, "splashId = " + splash.getId() + " image/video file not exist.");
        }
        if (!ExtSplashOrderKt.isOnlyImageSplash(splash) || imageFile == null) {
            if (!ExtSplashOrderKt.isOnlyVideoSplash(splash) || videoFile == null) {
                if (!ExtSplashOrderKt.isImageVideoMixCardType(splash) || videoFile == null || imageFile == null) {
                    BLog.i(TAG, "getValidResSplash, splashId = " + splash.getId() + ", resource not ready");
                    SplashCustomReporterKt.reportStrategySplashNotSelectReason(strategy.getId(), index, strategy.getOriginIndex(), StrategyNotSelectReason.RESOURCE_NOT_READY, source, realShow);
                    SplashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper.INSTANCE, step, splash, strategy.getId(), strategy.getOriginIndex() != Integer.MAX_VALUE ? strategy.getOriginIndex() : index, requestId, source.getValue(), realShow, null, SplashOrderFilterReason.RESOURCE_NOT_READY, BR.cover, null);
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private static final List<SplashShowStrategy> resortRealTimeShowList(boolean fromRealShow, List<SplashOrder> list, List<SplashShowStrategy> list2, long expectTopViewId) {
        if (list == null) {
            return list2;
        }
        List sortedStrategies = new ArrayList();
        if (!fromRealShow || SplashManagerKt.getSplashState().getData().getTrustRealtimeShowTopView()) {
            BLog.i(TAG, "resortRealTimeShowList, fromRealShow = " + fromRealShow + ", trust realtime show = " + SplashManagerKt.getSplashState().getData().getTrustRealtimeShowTopView());
            sortedStrategies.addAll(list2);
            return sortedStrategies;
        }
        LongSparseArray topViewIds = new LongSparseArray();
        Object v = new Object();
        for (SplashOrder splash : list) {
            if (ExtSplashOrderKt.isTopView(splash)) {
                topViewIds.put(splash.getId(), v);
            }
        }
        List temp = new ArrayList();
        for (SplashShowStrategy strategy : list2) {
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
        return sortedStrategies;
    }
}