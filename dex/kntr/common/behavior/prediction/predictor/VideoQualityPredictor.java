package kntr.common.behavior.prediction.predictor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.KDevice;
import kntr.common.behavior.prediction.IBehaviorData;
import kntr.common.behavior.prediction.IPredictionContext;
import kntr.common.behavior.prediction.IPredictionResult;
import kntr.common.behavior.prediction.event.VideoQualityEventHandler;
import kntr.common.behavior.prediction.impl.BPCache;
import kntr.common.behavior.prediction.impl.UtilsKt;
import kntr.common.behavior.prediction.impl.UtilsKt$decodeFromString$json$1;
import kntr.common.behavior.prediction.impl.UtilsKt$encodeToString$json$1;
import kntr.common.behavior.prediction.model.VideoMediaTagInfo;
import kntr.common.behavior.prediction.model.VideoQualityData;
import kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo;
import kntr.common.behavior.prediction.model.VideoQualityDeviceBehaviorData;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001eH\u0002J\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u001d0 2\u0006\u0010\u0010\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkntr/common/behavior/prediction/predictor/VideoQualityPredictor;", "Lkntr/common/behavior/prediction/predictor/IBehaviorPredictor;", "cache", "Lkntr/common/behavior/prediction/impl/BPCache;", "<init>", "(Lkntr/common/behavior/prediction/impl/BPCache;)V", "name", "", "getName", "()Ljava/lang/String;", "localConfig", "Lkntr/common/behavior/prediction/predictor/VideoQualityPredictorConfig;", "localActionInfo", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo;", "canPredict", "", "context", "Lkntr/common/behavior/prediction/IPredictionContext;", "start", "", "update", "data", "Lkntr/common/behavior/prediction/IBehaviorData;", "predict", "Lkntr/common/behavior/prediction/IPredictionResult;", "updateLocalActionInfo", "info", "buvid", "predictMaxQn", "", "Lkntr/common/behavior/prediction/model/VideoQualityData$Context;", "getMaxQns", "", "Lkntr/common/behavior/prediction/predictor/VideoQualityPredictor$PredictKey;", "getVideoMediaInfo", "Lkntr/common/behavior/prediction/model/VideoMediaTagInfo;", WatchLaterReporterKt.KEY_AVID, "PredictKey", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityPredictor implements IBehaviorPredictor {
    private final BPCache cache;
    private VideoQualityDeviceActionInfo localActionInfo;
    private final VideoQualityPredictorConfig localConfig;
    private final String name;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoQualityPredictor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkntr/common/behavior/prediction/predictor/VideoQualityPredictor$PredictKey;", "", "<init>", "(Ljava/lang/String;I)V", "LowScreen", "HighScreen", "IgnoreInputQn", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum PredictKey {
        LowScreen,
        HighScreen,
        IgnoreInputQn;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<PredictKey> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
        if (r1 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoQualityPredictor(BPCache cache) {
        VideoQualityDeviceActionInfo videoQualityDeviceActionInfo;
        Object obj;
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.name = "video-quality";
        this.localConfig = new VideoQualityPredictorConfig();
        String it = BPCache.get$default(this.cache, KDevice.INSTANCE.getBuvid(), getName(), false, 4, null);
        if (it != null) {
            it = StringsKt.isBlank(it) ? null : it;
            if (it != null) {
                String jsonStr$iv = it;
                try {
                    Json json$iv = JsonKt.Json$default((Json) null, UtilsKt$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                    String string$iv$iv = UtilsKt.fixJson(jsonStr$iv);
                    json$iv.getSerializersModule();
                    obj = json$iv.decodeFromString(VideoQualityDeviceActionInfo.Companion.serializer(), string$iv$iv);
                } catch (Exception e) {
                    UtilsKt.logE("JsonUtils", "decodeFromString error.");
                    obj = null;
                }
                VideoQualityDeviceActionInfo videoQualityDeviceActionInfo2 = (VideoQualityDeviceActionInfo) obj;
                videoQualityDeviceActionInfo = videoQualityDeviceActionInfo2 != null ? VideoQualityPredictorKt.access$update(videoQualityDeviceActionInfo2, this.localConfig) : null;
            }
        }
        videoQualityDeviceActionInfo = new VideoQualityDeviceActionInfo((String) null, (String) null, (String) null, 0, 0, (Integer) null, (Integer) null, (List) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
        VideoQualityDeviceActionInfo it2 = videoQualityDeviceActionInfo;
        UtilsKt.logI(getName(), "init localActionInfo (vipTag: <" + it2.getVipTag() + ">, wifi: <" + it2.getWifiTag() + ", " + it2.getWifiMaxQn() + ", " + it2.getLstmWifiMaxQn() + ">, mobile: <" + it2.getMobileTag() + ", " + it2.getMobileMaxQn() + ", " + it2.getLstmMobileMaxQn() + ">)");
        this.localActionInfo = videoQualityDeviceActionInfo;
    }

    @Override // kntr.common.behavior.prediction.predictor.IBehaviorPredictor
    public String getName() {
        return this.name;
    }

    @Override // kntr.common.behavior.prediction.predictor.IBehaviorPredictor
    public boolean canPredict(IPredictionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context instanceof VideoQualityData.Context;
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public void start() {
        String name = getName();
        boolean enablePredict = this.localConfig.getEnablePredict();
        UtilsKt.logI(name, "start with (" + enablePredict + ", " + this.localConfig.getDisableDeviceFeatureFetcher() + ")");
        if (this.localConfig.getEnablePredict() && !this.localConfig.getDisableDeviceFeatureFetcher()) {
            new DeviceFeatureFetcher().fetch();
        }
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public void update(IBehaviorData data) {
        BPCache this_$iv;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof VideoQualityDeviceBehaviorData) {
            UtilsKt.logI(getName(), "update device data " + data);
            VideoQualityDeviceActionInfo it = VideoQualityPredictorKt.access$toActionInfo((VideoQualityDeviceBehaviorData) data);
            if (it != null) {
                this_$iv = this.cache;
                this_$iv.lock.lock();
                try {
                    updateLocalActionInfo(((VideoQualityDeviceBehaviorData) data).isOverwrite() ? VideoQualityPredictorKt.access$update(it, this.localConfig) : VideoQualityPredictorKt.access$merge(this.localActionInfo, it, this.localConfig), ((VideoQualityDeviceBehaviorData) data).getBuvid());
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
        } else if (data instanceof VideoQualityData.Behavior) {
            UtilsKt.logI(getName(), "update media data: " + data);
            if (!StringsKt.isBlank(((VideoQualityData.Behavior) data).getAvid())) {
                this.cache.set(((VideoQualityData.Behavior) data).getAvid(), ((VideoQualityData.Behavior) data).getMediaInfo(), getName(), false);
            }
        } else if (data instanceof VideoQualityEventHandler.RecentBehaviorData) {
            UtilsKt.logI(getName(), "update recent data: " + data);
            this_$iv = this.cache;
            this_$iv.lock.lock();
            try {
                updateLocalActionInfo$default(this, VideoQualityPredictorKt.access$update(VideoQualityDeviceActionInfo.copy$default(this.localActionInfo, null, null, null, 0, 0, null, null, CollectionsKt.plus(this.localActionInfo.getRecentSwitches(), ((VideoQualityEventHandler.RecentBehaviorData) data).getRecentSwitches()), 127, null), this.localConfig), null, 2, null);
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public IPredictionResult predict(IPredictionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof VideoQualityData.Context)) {
            UtilsKt.logE(getName(), "can not predict, context is invalid!");
            return null;
        }
        int it = predictMaxQn((VideoQualityData.Context) context);
        UtilsKt.logI(getName(), "end predict, maxQn = " + it + ".");
        return new VideoQualityData.Result(it);
    }

    static /* synthetic */ void updateLocalActionInfo$default(VideoQualityPredictor videoQualityPredictor, VideoQualityDeviceActionInfo videoQualityDeviceActionInfo, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        videoQualityPredictor.updateLocalActionInfo(videoQualityDeviceActionInfo, str);
    }

    private final void updateLocalActionInfo(VideoQualityDeviceActionInfo info, String buvid) {
        String it;
        String str = buvid;
        if (str.length() == 0) {
            str = KDevice.INSTANCE.getBuvid();
        }
        String key = str;
        this.localActionInfo = info;
        try {
            StringFormat $this$encodeToString$iv$iv = JsonKt.Json$default((Json) null, UtilsKt$encodeToString$json$1.INSTANCE, 1, (Object) null);
            $this$encodeToString$iv$iv.getSerializersModule();
            it = $this$encodeToString$iv$iv.encodeToString(VideoQualityDeviceActionInfo.Companion.serializer(), info);
        } catch (Exception e) {
            UtilsKt.logE("JsonUtils", "encodeToString error.");
            it = null;
        }
        if (it != null) {
            BPCache.set$default(this.cache, key, it, getName(), false, 8, null);
        }
        UtilsKt.logI(getName(), "device(" + key + ") action info has been updated to " + info);
    }

    private final int predictMaxQn(VideoQualityData.Context context) {
        Integer num;
        UtilsKt.logI(getName(), "start predict(" + context + ").");
        if (!this.localConfig.getEnablePredict()) {
            UtilsKt.logI(getName(), "not in the experimental group.");
            return context.getAutoMaxQn();
        }
        Map qns = getMaxQns(context);
        if (context.isHighScreenRatio()) {
            num = qns.get(PredictKey.HighScreen);
        } else {
            num = !context.isHighScreenRatio() ? qns.get(PredictKey.LowScreen) : null;
        }
        int qn = num != null ? num.intValue() : context.getAutoMaxQn();
        Integer num2 = qns.get(PredictKey.IgnoreInputQn);
        return (num2 != null && num2.intValue() == 1) ? qn : Math.min(qn, context.getAutoMaxQn());
    }

    private final Map<PredictKey, Integer> getMaxQns(VideoQualityData.Context context) {
        Map qns = new LinkedHashMap();
        VideoQualityPredictorConfig videoQualityPredictorConfig = this.localConfig;
        VideoMediaTagInfo videoMediaInfo = getVideoMediaInfo(context.getAvid());
        VideoQualityTagType mediaTag = videoQualityPredictorConfig.getTagType(videoMediaInfo != null ? videoMediaInfo.getQualityTag() : null);
        BPCache this_$iv = this.cache;
        this_$iv.lock.lock();
        try {
            VideoQualityDeviceTagInfo deviceTag = VideoQualityPredictorKt.access$asTag(this.localActionInfo, context.isWifi(), this.localConfig);
            this_$iv.lock.unlock();
            UtilsKt.logI(getName(), "media_tag: " + mediaTag.getDisplayName() + ", " + deviceTag.getMessage() + ".");
            if (mediaTag == VideoQualityTagType.High || deviceTag.isHigh()) {
                boolean isMedia = mediaTag == VideoQualityTagType.High;
                qns.put(PredictKey.LowScreen, this.localConfig.getHighQualityMaxQn(isMedia, false));
                qns.put(PredictKey.HighScreen, this.localConfig.getHighQualityMaxQn(isMedia, true));
                if (isMedia) {
                    qns.put(PredictKey.IgnoreInputQn, 1);
                }
            } else if (deviceTag.getDeviceTag() == VideoQualityTagType.Low) {
                qns.put(PredictKey.LowScreen, Integer.valueOf(deviceTag.getDeviceMaxQn()));
                qns.put(PredictKey.HighScreen, Integer.valueOf(deviceTag.getDeviceMaxQn()));
            } else {
                qns.put(PredictKey.LowScreen, this.localConfig.getDefaultQualityMaxQn(false));
                qns.put(PredictKey.HighScreen, this.localConfig.getDefaultQualityMaxQn(true));
            }
            if (this.localConfig.isOffPeakBillingPeriod() && deviceTag.getDeviceTag() != VideoQualityTagType.Low) {
                UtilsKt.logI(getName(), "current is off peak-billing period.");
                PredictKey predictKey = PredictKey.LowScreen;
                Integer num = (Integer) qns.get(PredictKey.LowScreen);
                qns.put(predictKey, Integer.valueOf(Math.max(num != null ? num.intValue() : 0, this.localConfig.getOffPeakLowScreenQn())));
                PredictKey predictKey2 = PredictKey.HighScreen;
                Integer num2 = (Integer) qns.get(PredictKey.HighScreen);
                qns.put(predictKey2, Integer.valueOf(Math.max(num2 != null ? num2.intValue() : 0, this.localConfig.getOffPeakHighScreenQn())));
                qns.put(PredictKey.IgnoreInputQn, 1);
            }
            UtilsKt.logI(getName(), "maxQns = " + qns);
            return qns;
        } catch (Throwable th) {
            this_$iv.lock.unlock();
            throw th;
        }
    }

    private final VideoMediaTagInfo getVideoMediaInfo(String avid) {
        String it = this.cache.get(avid, getName(), false);
        Object obj = null;
        if (it != null) {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it != null) {
                String jsonStr$iv = it;
                try {
                    Json json$iv = JsonKt.Json$default((Json) null, UtilsKt$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                    String string$iv$iv = UtilsKt.fixJson(jsonStr$iv);
                    json$iv.getSerializersModule();
                    obj = json$iv.decodeFromString(VideoMediaTagInfo.Companion.serializer(), string$iv$iv);
                } catch (Exception e) {
                    UtilsKt.logE("JsonUtils", "decodeFromString error.");
                }
                return (VideoMediaTagInfo) obj;
            }
            return null;
        }
        return null;
    }
}