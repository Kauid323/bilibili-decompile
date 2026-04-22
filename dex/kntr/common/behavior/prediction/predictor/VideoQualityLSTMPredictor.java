package kntr.common.behavior.prediction.predictor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.base.neuron.KNeuron;
import kntr.common.behavior.prediction.impl.DateUtilsModel;
import kntr.common.behavior.prediction.impl.UtilsKt;
import kntr.common.behavior.prediction.model.VideoQualityDeviceSwitchInfo;
import kntr.common.behavior.prediction.predictor.machine.VideoQualityTreeModels;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J.\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tH\u0002J%\u0010\u0015\u001a\u0004\u0018\u00010\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tH\u0002¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\tJ,\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkntr/common/behavior/prediction/predictor/VideoQualityLSTMPredictor;", "", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/common/behavior/prediction/predictor/VideoQualityPredictorConfig;", "<init>", "(Lkntr/common/behavior/prediction/predictor/VideoQualityPredictorConfig;)V", "name", "", "labelToQualities", "", "", "clampQn", "qn", "process", "", "isWifi", "", "currentTime", "Lkntr/common/behavior/prediction/impl/DateUtilsModel;", "switches", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "predictAll", "input", "extra", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/Integer;", "predict", "(ZLkntr/common/behavior/prediction/impl/DateUtilsModel;Ljava/util/List;)Ljava/lang/Integer;", "Lkntr/common/behavior/prediction/predictor/VideoQualityLSTMPredictor$MaxQn;", "recentSwitches", "trackCost", "", "type", "lastTime", "", "size", "MaxQn", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityLSTMPredictor {
    private final VideoQualityPredictorConfig config;
    private final List<Integer> labelToQualities;
    private final String name;

    public VideoQualityLSTMPredictor(VideoQualityPredictorConfig config) {
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        this.config = config;
        this.name = "video-quality-lstm";
        this.labelToQualities = CollectionsKt.listOf(new Integer[]{16, 32, 64, 80, Integer.valueOf((int) BackoffConfigKt.MAX_DELAY_SECONDS)});
    }

    /* compiled from: VideoQualityPredictor.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lkntr/common/behavior/prediction/predictor/VideoQualityLSTMPredictor$MaxQn;", "", "wifi", "", "mobile", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getWifi", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMobile", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/common/behavior/prediction/predictor/VideoQualityLSTMPredictor$MaxQn;", "equals", "", "other", "hashCode", "toString", "", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MaxQn {
        private final Integer mobile;
        private final Integer wifi;

        public static /* synthetic */ MaxQn copy$default(MaxQn maxQn, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = maxQn.wifi;
            }
            if ((i & 2) != 0) {
                num2 = maxQn.mobile;
            }
            return maxQn.copy(num, num2);
        }

        public final Integer component1() {
            return this.wifi;
        }

        public final Integer component2() {
            return this.mobile;
        }

        public final MaxQn copy(Integer num, Integer num2) {
            return new MaxQn(num, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MaxQn) {
                MaxQn maxQn = (MaxQn) obj;
                return Intrinsics.areEqual(this.wifi, maxQn.wifi) && Intrinsics.areEqual(this.mobile, maxQn.mobile);
            }
            return false;
        }

        public int hashCode() {
            return ((this.wifi == null ? 0 : this.wifi.hashCode()) * 31) + (this.mobile != null ? this.mobile.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.wifi;
            return "MaxQn(wifi=" + num + ", mobile=" + this.mobile + ")";
        }

        public MaxQn(Integer wifi, Integer mobile) {
            this.wifi = wifi;
            this.mobile = mobile;
        }

        public final Integer getWifi() {
            return this.wifi;
        }

        public final Integer getMobile() {
            return this.mobile;
        }
    }

    private final int clampQn(int qn) {
        return qn >= 100 ? BackoffConfigKt.MAX_DELAY_SECONDS : qn;
    }

    private final List<Double> process(boolean isWifi, DateUtilsModel currentTime, List<VideoQualityDeviceSwitchInfo> list) {
        double logDeltaTime;
        char c;
        Iterable $this$forEach$iv;
        long st;
        long baseTime;
        char c2;
        int i;
        char c3;
        char c4;
        double logDeltaTime2;
        VideoQualityLSTMPredictor videoQualityLSTMPredictor = this;
        if (list.size() <= 1) {
            return null;
        }
        long st2 = UtilsKt.currentTimestamp();
        long baseTime2 = ((VideoQualityDeviceSwitchInfo) CollectionsKt.first(list)).getCtime();
        logDeltaTime = VideoQualityPredictorKt.logDeltaTime(currentTime, baseTime2);
        int i2 = 0;
        char c5 = 2;
        char c6 = 3;
        List vectors = CollectionsKt.mutableListOf(new List[]{CollectionsKt.listOf(new Double[]{Double.valueOf(logDeltaTime), Double.valueOf(currentTime.getHourType()), Double.valueOf(isWifi ? 1.0d : 2.0d), Double.valueOf(1.0d), Double.valueOf(currentTime.getVacationType()), Double.valueOf(1.0d), Double.valueOf(currentTime.getHolidayType()), Double.valueOf(1.0d)})});
        List<VideoQualityDeviceSwitchInfo> $this$sortedByDescending$iv = list;
        Iterable $this$forEach$iv2 = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.common.behavior.prediction.predictor.VideoQualityLSTMPredictor$process$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                VideoQualityDeviceSwitchInfo it = (VideoQualityDeviceSwitchInfo) t2;
                VideoQualityDeviceSwitchInfo it2 = (VideoQualityDeviceSwitchInfo) t;
                return ComparisonsKt.compareValues(Long.valueOf(it.getCtime()), Long.valueOf(it2.getCtime()));
            }
        });
        for (Object element$iv : $this$forEach$iv2) {
            VideoQualityDeviceSwitchInfo it = (VideoQualityDeviceSwitchInfo) element$iv;
            if (vectors.size() >= 10) {
                c = c5;
                $this$forEach$iv = $this$forEach$iv2;
                st = st2;
                baseTime = baseTime2;
                c2 = 5;
                i = i2;
                c3 = c6;
                c4 = 4;
            } else {
                $this$forEach$iv = $this$forEach$iv2;
                DateUtilsModel tm = new DateUtilsModel(it.getCtime());
                logDeltaTime2 = VideoQualityPredictorKt.logDeltaTime(tm, baseTime2);
                baseTime = baseTime2;
                st = st2;
                i = 0;
                c = 2;
                c3 = 3;
                c4 = 4;
                c2 = 5;
                vectors.add(CollectionsKt.listOf(new Double[]{Double.valueOf(logDeltaTime2), Double.valueOf(tm.getHourType()), Double.valueOf(it.getNetwork() == 1 ? 1.0d : 2.0d), Double.valueOf(videoQualityLSTMPredictor.clampQn(it.getFromQuality())), Double.valueOf(it.getVacationType()), Double.valueOf(videoQualityLSTMPredictor.clampQn(it.getPlayerQuality())), Double.valueOf(it.getHolidayType()), Double.valueOf(videoQualityLSTMPredictor.clampQn(it.getToQuality()))}));
            }
            videoQualityLSTMPredictor = this;
            c5 = c;
            $this$forEach$iv2 = $this$forEach$iv;
            baseTime2 = baseTime;
            c6 = c3;
            i2 = i;
            st2 = st;
        }
        long st3 = st2;
        int i3 = i2;
        while (vectors.size() < 10) {
            ArrayList arrayList = new ArrayList(8);
            for (int i4 = i3; i4 < 8; i4++) {
                arrayList.add(Double.valueOf(0.0d));
            }
            vectors.add(arrayList);
        }
        List<Double> flatten = CollectionsKt.flatten(CollectionsKt.asReversedMutable(vectors));
        trackCost$default(this, "process", st3, list.size(), null, 8, null);
        return flatten;
    }

    private final Integer predictAll(List<Double> list, String extra) {
        Integer num;
        Integer num2;
        long st = UtilsKt.currentTimestamp();
        Iterable output = new VideoQualityTreeModels().predictAll(list);
        double rowSum = CollectionsKt.sumOfDouble(output) + 1.0E-9d;
        Iterable $this$map$iv = output;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(Double.valueOf(((Number) item$iv$iv).doubleValue() / rowSum));
        }
        List probs = (List) destination$iv$iv;
        Pair pair = TuplesKt.to(-1, -1);
        List logInfos = new ArrayList();
        int size = probs.size();
        Pair pair2 = pair;
        for (int i = 0; i < size; i++) {
            int prob = (int) (((Number) probs.get(i)).doubleValue() * 100.0d);
            if (prob > ((Number) pair2.getFirst()).intValue()) {
                pair2 = TuplesKt.to(Integer.valueOf(prob), Integer.valueOf(i));
            }
            logInfos.add((((Integer) CollectionsKt.getOrNull(this.labelToQualities, i)) != null ? num2.intValue() : -1) + ": " + prob + "%");
        }
        UtilsKt.logI(this.name, "predictAll output { " + CollectionsKt.joinToString$default(logInfos, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + " }.");
        if (((Number) pair2.getFirst()).intValue() >= this.config.getLstmConfidenceThreshold()) {
            Integer num3 = (Integer) CollectionsKt.getOrNull(this.labelToQualities, ((Number) pair2.getSecond()).intValue());
            num = Integer.valueOf(num3 != null ? num3.intValue() : this.config.getLstmDefaultMaxQn());
        } else {
            num = null;
        }
        Integer it = num;
        trackCost("predictAll", st, list.size(), extra + ", prob: " + pair2.getFirst() + "%, qn: " + (it != null ? it.intValue() : -1) + ".");
        return num;
    }

    private final Integer predict(boolean isWifi, DateUtilsModel currentTime, List<VideoQualityDeviceSwitchInfo> list) {
        int max;
        boolean z = isWifi;
        List input = process(isWifi, currentTime, list);
        if (input == null) {
            return null;
        }
        Integer predictAll = predictAll(input, "wifi: " + z + ", size: " + list.size());
        if (predictAll != null) {
            int qn = predictAll.intValue();
            if (z) {
                max = Math.max(qn, this.config.getLstmDefaultMaxQn());
            } else {
                Pair pair = TuplesKt.to(-1, -1);
                Map qns = new LinkedHashMap();
                List<VideoQualityDeviceSwitchInfo> $this$forEach$iv = list;
                for (Object element$iv : $this$forEach$iv) {
                    VideoQualityDeviceSwitchInfo it = (VideoQualityDeviceSwitchInfo) element$iv;
                    if (it.isWifi() == z) {
                        int toQ = it.getToQuality();
                        Integer num = (Integer) qns.get(Integer.valueOf(toQ));
                        int cnt = (num != null ? num.intValue() : 0) + 1;
                        qns.put(Integer.valueOf(toQ), Integer.valueOf(cnt));
                        if (cnt > ((Number) pair.getSecond()).intValue() || (cnt == ((Number) pair.getSecond()).intValue() && toQ > ((Number) pair.getFirst()).intValue())) {
                            pair = TuplesKt.to(Integer.valueOf(toQ), Integer.valueOf(cnt));
                        }
                    }
                    z = isWifi;
                }
                max = Math.max(qn, ((Number) pair.getFirst()).intValue() != -1 ? ((Number) pair.getFirst()).intValue() : this.config.getLstmDefaultMaxQn());
            }
            return Integer.valueOf(max);
        }
        return null;
    }

    public final MaxQn predict(List<VideoQualityDeviceSwitchInfo> list) {
        boolean isValid;
        Intrinsics.checkNotNullParameter(list, "recentSwitches");
        if (!this.config.getEnableLSTMPredictor() && !this.config.getEnableLSTMChecker()) {
            UtilsKt.logI(this.name, "is disabled.");
            return null;
        }
        DateUtilsModel currentTime = new DateUtilsModel(0L, 1, null);
        List wifiSwitches = new ArrayList();
        List mobileSwitches = new ArrayList();
        List<VideoQualityDeviceSwitchInfo> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            VideoQualityDeviceSwitchInfo it = (VideoQualityDeviceSwitchInfo) element$iv;
            isValid = VideoQualityPredictorKt.isValid(it);
            if (isValid) {
                if (it.isWifi()) {
                    wifiSwitches.add(it);
                } else {
                    mobileSwitches.add(it);
                }
            }
        }
        int maxCnt = this.config.getRecentSwitchesSaveCnt();
        MaxQn it2 = new MaxQn(predict(true, currentTime, CollectionsKt.plus(wifiSwitches, CollectionsKt.take(mobileSwitches, Math.max(0, maxCnt - wifiSwitches.size())))), predict(false, currentTime, CollectionsKt.plus(mobileSwitches, CollectionsKt.take(wifiSwitches, Math.max(0, maxCnt - mobileSwitches.size())))));
        String extra = "w_qn: " + it2.getWifi() + ", m_qn: " + it2.getMobile() + ".";
        trackCost("total", currentTime.getTime(), list.size(), extra);
        return it2;
    }

    static /* synthetic */ void trackCost$default(VideoQualityLSTMPredictor videoQualityLSTMPredictor, String str, long j, int i, String str2, int i2, Object obj) {
        String str3;
        if ((i2 & 8) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        videoQualityLSTMPredictor.trackCost(str, j, i, str3);
    }

    private final void trackCost(String type, long lastTime, int size, String extra) {
        Map $this$trackCost_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$trackCost_u24lambda_u240.put("type", type);
        $this$trackCost_u24lambda_u240.put("cost", String.valueOf(UtilsKt.currentTimestamp() - lastTime));
        $this$trackCost_u24lambda_u240.put("size", String.valueOf(size));
        if (extra != null) {
            $this$trackCost_u24lambda_u240.put("extra", extra);
        }
        Map result = MapsKt.build($this$trackCost_u24lambda_u240);
        UtilsKt.logI(this.name, "trackCost(" + result + ").");
        KNeuron.INSTANCE.simpleTrackT("infra.bp.vq.lstm.cost", result);
    }
}