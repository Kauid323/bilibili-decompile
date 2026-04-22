package tv.danmaku.bili.videopage.common.performance;

import android.text.TextUtils;
import bolts.Task;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.api.BiliConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.videopage.common.BuildConfig;
import tv.danmaku.bili.videopage.common.VideoPageConstants;
import tv.danmaku.bili.videopage.common.performance.PerformanceTracerImpl;
import tv.danmaku.biliplayerv2.profiler.ProfilerTags;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: UGCProfilerReporter.kt */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J0\u0010\u0010\u001a\u00020\u00072&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/UGCProfilerReporter;", "Ltv/danmaku/bili/videopage/common/performance/IProfilerReporter;", "<init>", "()V", "mVersionCode", "", "reportPage", "", "watchDog", "Ltv/danmaku/bili/videopage/common/performance/WatchDog;", "extras", "Lcom/alibaba/fastjson/JSONObject;", "reportOldFeedback", "avid", "", "jsonObject", "reportNewFeedback", "trackTParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Named(PerformanceTracerImpl.CLIENT_UGC)
public final class UGCProfilerReporter implements IProfilerReporter {
    private static final String EVENT_PAGE_NAME = "video_detail_show";
    private static final String TABLE_ID_DETAIL_PAGE = "000377";
    private static final String TAG = "PerformanceReporter";
    private final int mVersionCode = BiliConfig.getBiliVersionCode();
    public static final Companion Companion = new Companion(null);
    private static boolean sIsColdBoot = true;

    /* compiled from: UGCProfilerReporter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/UGCProfilerReporter$Companion;", "", "<init>", "()V", "TAG", "", "TABLE_ID_DETAIL_PAGE", "EVENT_PAGE_NAME", "sIsColdBoot", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.videopage.common.performance.IProfilerReporter
    public void reportPage(final WatchDog watchDog, final JSONObject extras) {
        Intrinsics.checkNotNullParameter(watchDog, "watchDog");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.videopage.common.performance.UGCProfilerReporter$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object reportPage$lambda$0;
                reportPage$lambda$0 = UGCProfilerReporter.reportPage$lambda$0(extras, watchDog, this);
                return reportPage$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0627  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object reportPage$lambda$0(JSONObject $extras, WatchDog $watchDog, UGCProfilerReporter this$0) {
        String avid;
        long start;
        long layoutTime;
        String isUrlPreload;
        Object schema;
        String uniteType;
        String uniteType2;
        String isColdBoot;
        String fromSpmid;
        Map jSONObject;
        HashMap trackTParams;
        Triple prepared;
        Triple firstFrame;
        Map map;
        try {
            avid = $extras.getString("avid");
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (TextUtils.isEmpty(avid)) {
            throw new IllegalArgumentException("Losing avid");
        }
        Boolean isAutoPlay = $extras.getBoolean(PerformanceConstants.EXTRA_KEY_IS_AUTO_PLAY);
        if (isAutoPlay.booleanValue()) {
            Triple create = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_CREATE);
            Triple created = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_VIEW_CREATED);
            Triple resume = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_RESUME);
            Triple layout = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_VIEW_TREE_LAYOUT);
            Triple api = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_DETAIL_DATA);
            Triple bind = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_DETAIL_IMAGE_BIND);
            if (create == null || created == null || resume == null || layout == null || api == null || bind == null) {
                throw new IllegalArgumentException("Losing basic record, data = " + $watchDog);
            }
            if (((Number) layout.getThird()).longValue() <= ((Number) resume.getThird()).longValue() || ((Number) api.getThird()).longValue() <= ((Number) resume.getThird()).longValue()) {
                throw new IllegalStateException("Illegal start time, data = " + $watchDog);
            }
            try {
                start = Math.min(((Number) resume.getThird()).longValue(), ((Number) created.getThird()).longValue());
                layoutTime = ((Number) layout.getThird()).longValue() - start;
            } catch (Exception e3) {
                e = e3;
            }
            if (layoutTime <= 0) {
                throw new IllegalStateException("Illegal layout time, data = " + $watchDog);
            }
            long apiTime = ((Number) api.getThird()).longValue() - start;
            if (apiTime <= 0) {
                throw new IllegalStateException("Illegal api time, data = " + $watchDog);
            }
            int showTime = (int) (((Number) bind.getThird()).longValue() - start);
            if (showTime <= 0) {
                throw new IllegalStateException("Illegal show time, data = " + $watchDog);
            }
            Triple startService = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_START_BUSINESS_SERVICES);
            Triple startResolve = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_START_RESOLVE_PLAY_URL);
            Triple endResolve = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_END_RESOLVE_PLAY_URL);
            Triple fireResolve = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_RESOLVE_PLAY_URL_FIRE);
            Triple setMediaItem = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_SET_MEDIA_ITEM);
            Object startPosition = $extras.get(ProfilerTags.KEY_EXTRAS_START_POSITION);
            Object resolveType = $extras.get(ProfilerTags.KEY_EXTRAS_RESOLVE_TYPE);
            Object quality = $extras.get(ProfilerTags.KEY_EXTRAS_QN);
            int network = $extras.getIntValue(PerformanceConstants.EXTRA_KEY_NETWORK);
            try {
                String str = "1";
                isUrlPreload = $extras.getBoolean(PerformanceConstants.EXTRA_KEY_IS_URL_PRELOAD).booleanValue() ? "1" : "0";
                Object obj = $extras.get(PerformanceConstants.EXTRA_KEY_SCHEMA);
                String str2 = "";
                if (obj == null) {
                    obj = "";
                }
                schema = obj;
                Object obj2 = $extras.get("host");
                if (obj2 != 0) {
                    str2 = obj2;
                }
                uniteType = str2;
                String string = $extras.getString("uniteType");
                if (string == null) {
                    string = "0";
                }
                uniteType2 = string;
                if (sIsColdBoot) {
                    sIsColdBoot = false;
                } else {
                    str = "0";
                }
                isColdBoot = str;
                String from = $extras.getString("from");
                fromSpmid = $extras.getString("from_spmid");
                jSONObject = new JSONObject();
                jSONObject.put("from", from);
                jSONObject.put("from_spmid", fromSpmid);
                jSONObject.put("spmid", VideoPageConstants.UGC_VIDEO_DETAIL_SPMID);
            } catch (Exception e4) {
                e = e4;
            }
            try {
                jSONObject.put("version_code", Integer.valueOf(this$0.mVersionCode));
                jSONObject.put("usePreloadUrl", isUrlPreload);
                jSONObject.put("isAppColdBoot", isColdBoot);
                jSONObject.put("LayoutTime", Long.valueOf(layoutTime));
                jSONObject.put("ApiTime", Long.valueOf(apiTime));
                jSONObject.put("ShowTime", Integer.valueOf(showTime));
                jSONObject.put("realWaitPlayTime", 0);
                jSONObject.put("prepareTime", 0);
                jSONObject.put("renderFirstFrameTime", 0);
                jSONObject.put("startPosition", startPosition);
                jSONObject.put("resolveType", resolveType);
                jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, quality);
                jSONObject.put(PerformanceConstants.EXTRA_KEY_SCHEMA, schema);
                jSONObject.put("host", uniteType);
                jSONObject.put("uniteType", uniteType2);
                jSONObject.put("is_new_detail", "0");
                jSONObject.put("network_type", Integer.valueOf(network));
                trackTParams = new HashMap();
                HashMap hashMap = trackTParams;
                Object obj3 = $extras.get("from");
                hashMap.put("from", obj3 != null ? obj3.toString() : null);
                trackTParams.put("from_spmid", fromSpmid);
                trackTParams.put("spmid", VideoPageConstants.UGC_VIDEO_DETAIL_SPMID);
                trackTParams.put("usePreloadUrl", isUrlPreload);
                trackTParams.put("isAppColdBoot", isColdBoot);
                trackTParams.put("LayoutTime", String.valueOf(layoutTime));
                trackTParams.put("ApiTime", String.valueOf(apiTime));
                trackTParams.put("ShowTime", String.valueOf(showTime));
                trackTParams.put("realWaitPlayTime", "0");
                trackTParams.put("prepareTime", "0");
                trackTParams.put("renderFirstFrameTime", "0");
                trackTParams.put("startPosition", startPosition != null ? startPosition.toString() : null);
                trackTParams.put("resolveType", resolveType != null ? resolveType.toString() : null);
                trackTParams.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, quality != null ? quality.toString() : null);
                trackTParams.put(PerformanceConstants.EXTRA_KEY_SCHEMA, schema.toString());
                trackTParams.put("host", uniteType.toString());
                trackTParams.put("uniteType", uniteType2);
                trackTParams.put("is_new_detail", "0");
                trackTParams.put("network_type", String.valueOf(network));
            } catch (Exception e5) {
                e = e5;
                if (BuildConfig.DEBUG) {
                    BLog.e(TAG, "something is wrong in ugc preformance report!", e);
                }
                return null;
            }
            try {
                prepared = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_PLAYER_PREPARED);
                firstFrame = $watchDog.getRecord(PerformanceTracerImpl.Entry.ON_PLAYER_FIRST_FRAME);
                if (startService != null) {
                    long startUgcServiceTime = ((Number) startService.getThird()).longValue() - start;
                    Map map2 = jSONObject;
                    map2.put("startUgcServiceTime", Long.valueOf(startUgcServiceTime));
                    trackTParams.put("startUgcServiceTime", String.valueOf(startUgcServiceTime));
                    map = map2;
                } else {
                    map = jSONObject;
                }
                if (startResolve != null) {
                    long startResolveTime = ((Number) startResolve.getThird()).longValue() - start;
                    map.put("startResolvePlayUrlTime", Long.valueOf(startResolveTime));
                    trackTParams.put("startResolvePlayUrlTime", String.valueOf(startResolveTime));
                }
                if (endResolve != null) {
                    long endResolveTime = ((Number) endResolve.getThird()).longValue() - start;
                    map.put("endResolvePlayUrlTime", Long.valueOf(endResolveTime));
                    trackTParams.put("endResolvePlayUrlTime", String.valueOf(endResolveTime));
                }
                if (fireResolve != null) {
                    long fireResolveTime = ((Number) fireResolve.getThird()).longValue() - start;
                    map.put("resolvePlayUrlFireTime", Long.valueOf(fireResolveTime));
                    trackTParams.put("resolvePlayUrlFireTime", String.valueOf(fireResolveTime));
                }
                if (setMediaItem != null) {
                    long setMediaItemTime = ((Number) setMediaItem.getThird()).longValue() - start;
                    map.put("setMediaItemTime", Long.valueOf(setMediaItemTime));
                    trackTParams.put("setMediaItemTime", String.valueOf(setMediaItemTime));
                }
            } catch (Exception e6) {
                e = e6;
                if (BuildConfig.DEBUG) {
                }
                return null;
            }
            if (prepared != null && firstFrame != null) {
                long prepare = ((Number) prepared.getThird()).longValue() - start;
                long first = ((Number) firstFrame.getThird()).longValue() - start;
                if (prepare <= 0 || first <= 0) {
                    throw new IllegalStateException("player not ready to rendering first frame，drop the data!");
                }
                map.put("prepareTime", Long.valueOf(prepare));
                map.put("renderFirstFrameTime", Long.valueOf(first));
                trackTParams.put("prepareTime", String.valueOf(prepare));
                trackTParams.put("renderFirstFrameTime", String.valueOf(first));
                trackTParams.put("completedTime", String.valueOf(((Number) firstFrame.getThird()).longValue() - ((Number) create.getThird()).longValue()));
                if (setMediaItem != null) {
                    trackTParams.put("firstVideoRenderDuration", String.valueOf(((Number) firstFrame.getThird()).longValue() - ((Number) setMediaItem.getThird()).longValue()));
                }
                this$0.reportNewFeedback(trackTParams);
                this$0.reportOldFeedback(avid, map);
                return null;
            }
            throw new IllegalStateException("player not ready to rendering first frame，drop the data!");
        }
        throw new IllegalStateException("do not report when the action is manual");
    }

    private final void reportOldFeedback(String avid, JSONObject jsonObject) {
        UGCDetailPerformanceReportEvent event = new UGCDetailPerformanceReportEvent();
        event.setPageName(EVENT_PAGE_NAME);
        event.setPageArg(avid);
        event.setArgs(jsonObject.toJSONString());
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(true, "000377", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    private final void reportNewFeedback(HashMap<String, String> hashMap) {
        String sample = ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE;
        int num = 5;
        try {
            String str = (String) ConfigManager.Companion.config().get("videodetail.ugc_flash_trace_sample", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE);
            if (str != null) {
                sample = str;
            }
            num = Integer.parseInt(sample);
        } catch (Exception e) {
        }
        int finalNum = num;
        final boolean report = UgcSamples.sample(finalNum);
        Neurons.trackT$default(false, "main.detail.ugc.show.verbose", hashMap, 0, new Function0() { // from class: tv.danmaku.bili.videopage.common.performance.UGCProfilerReporter$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean reportNewFeedback$lambda$0;
                reportNewFeedback$lambda$0 = UGCProfilerReporter.reportNewFeedback$lambda$0(report);
                return Boolean.valueOf(reportNewFeedback$lambda$0);
            }
        }, 8, (Object) null);
        if (BuildConfig.DEBUG) {
            BLog.i(TAG, String.valueOf(hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportNewFeedback$lambda$0(boolean $report) {
        return $report;
    }
}