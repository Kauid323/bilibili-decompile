package kntr.common.behavior.prediction.predictor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.base.neuron.KNeuron;
import kntr.common.behavior.prediction.impl.BPPlatform;
import kntr.common.behavior.prediction.impl.DateUtilsModel;
import kntr.common.behavior.prediction.impl.UtilsKt;
import kntr.common.behavior.prediction.impl.UtilsKt$decodeFromString$json$1;
import kntr.common.behavior.prediction.impl.Utils_androidKt;
import kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo;
import kntr.common.behavior.prediction.model.VideoQualityDeviceBehaviorData;
import kntr.common.behavior.prediction.model.VideoQualityDeviceSwitchInfo;
import kntr.common.behavior.prediction.predictor.VideoQualityLSTMPredictor;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a+\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0002¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"toActionInfo", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo;", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceBehaviorData;", "merge", "other", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/common/behavior/prediction/predictor/VideoQualityPredictorConfig;", "update", "asTag", "Lkntr/common/behavior/prediction/predictor/VideoQualityDeviceTagInfo;", "isWifi", "", "isValid", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "logDeltaTime", "", "Lkntr/common/behavior/prediction/impl/DateUtilsModel;", "base", "", "getLstmQn", "", "predicate", "Lkotlin/Function0;", "(Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "behavior-prediction_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityPredictorKt {

    /* compiled from: VideoQualityPredictor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BPPlatform.values().length];
            try {
                iArr[BPPlatform.IOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ VideoQualityDeviceTagInfo access$asTag(VideoQualityDeviceActionInfo $receiver, boolean isWifi, VideoQualityPredictorConfig config) {
        return asTag($receiver, isWifi, config);
    }

    public static final /* synthetic */ VideoQualityDeviceActionInfo access$merge(VideoQualityDeviceActionInfo $receiver, VideoQualityDeviceActionInfo other, VideoQualityPredictorConfig config) {
        return merge($receiver, other, config);
    }

    public static final /* synthetic */ VideoQualityDeviceActionInfo access$toActionInfo(VideoQualityDeviceBehaviorData $receiver) {
        return toActionInfo($receiver);
    }

    public static final /* synthetic */ VideoQualityDeviceActionInfo access$update(VideoQualityDeviceActionInfo $receiver, VideoQualityPredictorConfig config) {
        return update($receiver, config);
    }

    public static final VideoQualityDeviceActionInfo toActionInfo(VideoQualityDeviceBehaviorData $this$toActionInfo) {
        Object obj = null;
        if (StringsKt.isBlank($this$toActionInfo.getActionInfo())) {
            if ($this$toActionInfo.isOverwrite()) {
                return new VideoQualityDeviceActionInfo((String) null, (String) null, (String) null, 0, 0, (Integer) null, (Integer) null, (List) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
            }
            return null;
        }
        String jsonStr$iv = $this$toActionInfo.getActionInfo();
        try {
            Json json$iv = JsonKt.Json$default((Json) null, UtilsKt$decodeFromString$json$1.INSTANCE, 1, (Object) null);
            String string$iv$iv = UtilsKt.fixJson(jsonStr$iv);
            json$iv.getSerializersModule();
            obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(VideoQualityDeviceActionInfo.Companion.serializer()), string$iv$iv);
        } catch (Exception e) {
            UtilsKt.logE("JsonUtils", "decodeFromString error.");
        }
        return (VideoQualityDeviceActionInfo) obj;
    }

    public static final VideoQualityDeviceActionInfo merge(VideoQualityDeviceActionInfo $this$merge, VideoQualityDeviceActionInfo other, VideoQualityPredictorConfig config) {
        return update(new VideoQualityDeviceActionInfo((String) null, (String) null, other.getVipTag(), 0, 0, (Integer) null, (Integer) null, CollectionsKt.plus(other.getRecentSwitches(), $this$merge.getRecentSwitches()), 123, (DefaultConstructorMarker) null), config);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final VideoQualityDeviceActionInfo update(VideoQualityDeviceActionInfo $this$update, VideoQualityPredictorConfig config) {
        String str;
        Integer mobile;
        VideoQualityTagType lSTMTagType;
        Integer wifi;
        ArrayList arrayList;
        Iterable $this$groupBy$iv = $this$update.getRecentSwitches();
        Map linkedHashMap = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            VideoQualityDeviceSwitchInfo it = (VideoQualityDeviceSwitchInfo) element$iv$iv;
            Integer valueOf = Integer.valueOf(it.getNetwork());
            Object value$iv$iv$iv = linkedHashMap.get(valueOf);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(valueOf, arrayList);
            } else {
                arrayList = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = arrayList;
            List list$iv$iv = (List) key$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        Map $this$flatMap$iv = linkedHashMap;
        Collection destination$iv$iv = new ArrayList();
        for (Map.Entry element$iv$iv2 : $this$flatMap$iv.entrySet()) {
            Iterable group = (List) element$iv$iv2.getValue();
            Iterable $this$distinctBy$iv = group;
            HashSet set$iv = new HashSet();
            ArrayList list$iv = new ArrayList();
            for (Object e$iv : $this$distinctBy$iv) {
                VideoQualityDeviceSwitchInfo it2 = (VideoQualityDeviceSwitchInfo) e$iv;
                Long valueOf2 = Long.valueOf(it2.getCtime());
                Map $this$flatMap$iv2 = $this$flatMap$iv;
                if (!set$iv.add(valueOf2)) {
                    $this$flatMap$iv = $this$flatMap$iv2;
                } else {
                    list$iv.add(e$iv);
                    $this$flatMap$iv = $this$flatMap$iv2;
                }
            }
            Map $this$flatMap$iv3 = $this$flatMap$iv;
            ArrayList $this$sortedByDescending$iv = list$iv;
            Iterable list$iv$iv2 = CollectionsKt.take(CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.common.behavior.prediction.predictor.VideoQualityPredictorKt$update$lambda$1$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    VideoQualityDeviceSwitchInfo it3 = (VideoQualityDeviceSwitchInfo) t2;
                    VideoQualityDeviceSwitchInfo it4 = (VideoQualityDeviceSwitchInfo) t;
                    return ComparisonsKt.compareValues(Long.valueOf(it3.getCtime()), Long.valueOf(it4.getCtime()));
                }
            }), config.getRecentSwitchesSaveCnt());
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv2);
            $this$flatMap$iv = $this$flatMap$iv3;
        }
        List filteredSwitches = (List) destination$iv$iv;
        Pair wifi2 = update$determine(filteredSwitches, config, true);
        Pair mobile2 = update$determine(filteredSwitches, config, false);
        VideoQualityLSTMPredictor.MaxQn lstmMaxQn = new VideoQualityLSTMPredictor(config).predict(filteredSwitches);
        String str2 = null;
        VideoQualityDeviceActionInfo videoQualityDeviceActionInfo = new VideoQualityDeviceActionInfo(wifi2.getFirst(), mobile2.getFirst(), $this$update.getVipTag(), wifi2.getSecond().intValue(), mobile2.getSecond().intValue(), lstmMaxQn != null ? lstmMaxQn.getWifi() : null, lstmMaxQn != null ? lstmMaxQn.getMobile() : null, filteredSwitches);
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("wifi", wifi2.getFirst());
        pairArr[1] = TuplesKt.to("mobile", mobile2.getFirst());
        if (lstmMaxQn != null && (wifi = lstmMaxQn.getWifi()) != null) {
            int it3 = wifi.intValue();
            VideoQualityTagType lSTMTagType2 = config.getLSTMTagType(it3);
            if (lSTMTagType2 != null) {
                str = lSTMTagType2.getDisplayName();
                pairArr[2] = TuplesKt.to("wifi-lstm", String.valueOf(str));
                if (lstmMaxQn != null && (mobile = lstmMaxQn.getMobile()) != null) {
                    int it4 = mobile.intValue();
                    lSTMTagType = config.getLSTMTagType(it4);
                    if (lSTMTagType != null) {
                        str2 = lSTMTagType.getDisplayName();
                    }
                }
                pairArr[3] = TuplesKt.to("mobile-lstm", String.valueOf(str2));
                Map params = MapsKt.mapOf(pairArr);
                UtilsKt.logI("VideoQualityDeviceActionInfo.update", "lstm-verify params: " + params);
                if (!config.getEnableLSTMPredictor() || config.getEnableLSTMChecker()) {
                    KNeuron.INSTANCE.simpleTrackT("infra.bp.vq.lstm.verify", params);
                }
                return videoQualityDeviceActionInfo;
            }
        }
        str = null;
        pairArr[2] = TuplesKt.to("wifi-lstm", String.valueOf(str));
        if (lstmMaxQn != null) {
            int it42 = mobile.intValue();
            lSTMTagType = config.getLSTMTagType(it42);
            if (lSTMTagType != null) {
            }
        }
        pairArr[3] = TuplesKt.to("mobile-lstm", String.valueOf(str2));
        Map params2 = MapsKt.mapOf(pairArr);
        UtilsKt.logI("VideoQualityDeviceActionInfo.update", "lstm-verify params: " + params2);
        if (!config.getEnableLSTMPredictor()) {
        }
        KNeuron.INSTANCE.simpleTrackT("infra.bp.vq.lstm.verify", params2);
        return videoQualityDeviceActionInfo;
    }

    private static final Pair<String, Integer> update$determine(List<VideoQualityDeviceSwitchInfo> list, VideoQualityPredictorConfig $config, boolean isWifi) {
        Object obj;
        int upSwitches = 0;
        int downSwitches = 0;
        int noisySwitches = 0;
        Map downCount = new LinkedHashMap();
        Iterator<VideoQualityDeviceSwitchInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VideoQualityDeviceSwitchInfo it2 = it.next();
            if (it2.isWifi() == isWifi) {
                if (it2.getToQuality() > $config.getUpSwitchMinQnLimit() && it2.getToQuality() >= it2.getPlayerQuality()) {
                    upSwitches++;
                } else if (it2.getToQuality() > 0 && it2.getToQuality() < $config.getDownSwitchMinQnLimit() && it2.getToQuality() < it2.getPlayerQuality()) {
                    downSwitches++;
                    Integer valueOf = Integer.valueOf(it2.getToQuality());
                    Integer num = (Integer) downCount.get(Integer.valueOf(it2.getToQuality()));
                    downCount.put(valueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                } else {
                    noisySwitches++;
                }
            }
        }
        double total = upSwitches + downSwitches + (noisySwitches * $config.getNoisySwitchWeight());
        UtilsKt.logI("VideoQualityDeviceActionInfo.update", "determine(isWifi: " + isWifi + ") -> (up: " + upSwitches + ", down: " + downSwitches + ", noisy: " + noisySwitches + ", total: " + total + ")");
        double d = 100;
        double upRate = (total > 0.0d ? upSwitches / total : 0.0d) * d;
        double downRate = (total > 0.0d ? downSwitches / total : 0.0d) * d;
        if (upRate >= $config.getUpSwitchMinRateLimit()) {
            return TuplesKt.to(CollectionsKt.first($config.getHighQualityTagNames()), 0);
        }
        if (isWifi || downRate < $config.getDownSwitchMinRateLimit() || downSwitches < $config.getDownSwitchCntMinLimit()) {
            return TuplesKt.to("常规", 0);
        }
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : downCount.entrySet()) {
            int it3 = ((Number) entry$iv.getValue()).intValue();
            Integer num2 = (Integer) CollectionsKt.maxOrNull(downCount.values());
            if (num2 != null && it3 == num2.intValue()) {
                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
            }
        }
        Iterator it4 = result$iv.entrySet().iterator();
        if (it4.hasNext()) {
            Object next = it4.next();
            if (it4.hasNext()) {
                Map.Entry it5 = (Map.Entry) next;
                int intValue = ((Number) it5.getKey()).intValue();
                do {
                    Object next2 = it4.next();
                    Map.Entry it6 = (Map.Entry) next2;
                    int intValue2 = ((Number) it6.getKey()).intValue();
                    if (intValue > intValue2) {
                        next = next2;
                        intValue = intValue2;
                    }
                } while (it4.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        int maxQn = entry != null ? ((Number) entry.getKey()).intValue() : 16;
        return TuplesKt.to(CollectionsKt.first($config.getLowDataQualityTagNames()), Integer.valueOf(maxQn));
    }

    public static final VideoQualityDeviceTagInfo asTag(VideoQualityDeviceActionInfo $this$asTag, boolean isWifi, final VideoQualityPredictorConfig config) {
        Pair pair;
        Integer lstmQn = getLstmQn($this$asTag, isWifi, new Function0() { // from class: kntr.common.behavior.prediction.predictor.VideoQualityPredictorKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean enableLSTMPredictor;
                enableLSTMPredictor = VideoQualityPredictorConfig.this.getEnableLSTMPredictor();
                return Boolean.valueOf(enableLSTMPredictor);
            }
        });
        boolean isLstm = false;
        if (lstmQn != null) {
            isLstm = true;
            pair = TuplesKt.to(config.getLSTMTagType(lstmQn.intValue()), lstmQn);
        } else {
            pair = isWifi ? TuplesKt.to(config.getTagType($this$asTag.getWifiTag()), Integer.valueOf($this$asTag.getWifiMaxQn())) : TuplesKt.to(config.getTagType($this$asTag.getMobileTag()), Integer.valueOf($this$asTag.getMobileMaxQn()));
        }
        VideoQualityTagType tag = (VideoQualityTagType) pair.component1();
        int qn = ((Number) pair.component2()).intValue();
        return new VideoQualityDeviceTagInfo(config.getTagType($this$asTag.getVipTag()), tag, qn, isLstm);
    }

    public static final boolean isValid(VideoQualityDeviceSwitchInfo $this$isValid) {
        Set allowQns = SetsKt.setOf(new Integer[]{0, 16, 32, 64, 80, 100, 112, 116, Integer.valueOf((int) BackoffConfigKt.MAX_DELAY_SECONDS), 125, 126, 127, 128, 129});
        Set allowNt = WhenMappings.$EnumSwitchMapping$0[Utils_androidKt.currentBPPlatform().ordinal()] == 1 ? SetsKt.setOf(new Integer[]{1, 2, 4, 5, 6}) : SetsKt.setOf(new Integer[]{1, 2});
        if (allowNt.contains(Integer.valueOf($this$isValid.getNetwork())) && SetsKt.setOf(new Integer[]{0, 1, 2}).contains(Integer.valueOf($this$isValid.getHolidayType())) && SetsKt.setOf(new Integer[]{1, 2, 3}).contains(Integer.valueOf($this$isValid.getVacationType())) && allowQns.contains(Integer.valueOf($this$isValid.getToQuality())) && allowQns.contains(Integer.valueOf($this$isValid.getPlayerQuality()))) {
            return allowQns.contains(Integer.valueOf($this$isValid.getFromQuality())) || $this$isValid.getFromQuality() == -1;
        }
        return false;
    }

    public static final double logDeltaTime(DateUtilsModel $this$logDeltaTime, long base) {
        if ($this$logDeltaTime.getTime() <= base) {
            return 0.0d;
        }
        return Math.rint(Math.log((($this$logDeltaTime.getTime() - base) / ((long) MediaAttrUtils.TYPE_PAY_SEASON)) + 1.0d) * ((double) MediaAttrUtils.TYPE_PAY_SEASON)) / ((double) MediaAttrUtils.TYPE_PAY_SEASON);
    }

    static /* synthetic */ Integer getLstmQn$default(VideoQualityDeviceActionInfo videoQualityDeviceActionInfo, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: kntr.common.behavior.prediction.predictor.VideoQualityPredictorKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean lstmQn$lambda$0;
                    lstmQn$lambda$0 = VideoQualityPredictorKt.getLstmQn$lambda$0();
                    return Boolean.valueOf(lstmQn$lambda$0);
                }
            };
        }
        return getLstmQn(videoQualityDeviceActionInfo, z, function0);
    }

    public static final boolean getLstmQn$lambda$0() {
        return true;
    }

    private static final Integer getLstmQn(VideoQualityDeviceActionInfo $this$getLstmQn, boolean isWifi, Function0<Boolean> function0) {
        if (((Boolean) function0.invoke()).booleanValue()) {
            return isWifi ? $this$getLstmQn.getLstmWifiMaxQn() : $this$getLstmQn.getLstmMobileMaxQn();
        }
        return null;
    }
}