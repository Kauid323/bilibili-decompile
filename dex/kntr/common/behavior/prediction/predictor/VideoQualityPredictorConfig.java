package kntr.common.behavior.prediction.predictor;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.behavior.prediction.impl.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\fJ\u000e\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0012J\u001d\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005¢\u0006\u0002\u0010EJ\u0015\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010D\u001a\u00020\u0005¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0011\u0010%\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0011\u0010'\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0011\u0010)\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014R\u0011\u0010+\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0014R\u0011\u0010-\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0014R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0011\u00105\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0014R\u0011\u00107\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0014R\u0011\u00109\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0014R\u0011\u0010;\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0014¨\u0006H"}, d2 = {"Lkntr/common/behavior/prediction/predictor/VideoQualityPredictorConfig;", "", "<init>", "()V", "enablePredict", "", "getEnablePredict", "()Z", "disableDeviceFeatureFetcher", "getDisableDeviceFeatureFetcher", "highQualityTagNames", "", "", "getHighQualityTagNames", "()Ljava/util/Set;", "lowDataQualityTagNames", "getLowDataQualityTagNames", "recentSwitchesSaveCnt", "", "getRecentSwitchesSaveCnt", "()I", "upSwitchMinRateLimit", "getUpSwitchMinRateLimit", "upSwitchMinQnLimit", "getUpSwitchMinQnLimit", "downSwitchMinQnLimit", "getDownSwitchMinQnLimit", "downSwitchCntMinLimit", "getDownSwitchCntMinLimit", "downSwitchMinRateLimit", "getDownSwitchMinRateLimit", "noisySwitchWeight", "", "getNoisySwitchWeight", "()D", "deviceHighQualityMaxQn", "getDeviceHighQualityMaxQn", "mediaHighQualityMaxQn", "getMediaHighQualityMaxQn", "deviceHighQualityMaxQnSmall", "getDeviceHighQualityMaxQnSmall", "mediaHighQualityMaxQnSmall", "getMediaHighQualityMaxQnSmall", "defaultQualityMaxQn", "getDefaultQualityMaxQn", "defaultQualityMaxQnSmall", "getDefaultQualityMaxQnSmall", "enablePredictOnSmall", "getEnablePredictOnSmall", "enableLSTMPredictor", "getEnableLSTMPredictor", "enableLSTMChecker", "getEnableLSTMChecker", "lstmConfidenceThreshold", "getLstmConfidenceThreshold", "lstmDefaultMaxQn", "getLstmDefaultMaxQn", "offPeakLowScreenQn", "getOffPeakLowScreenQn", "offPeakHighScreenQn", "getOffPeakHighScreenQn", "getTagType", "Lkntr/common/behavior/prediction/predictor/VideoQualityTagType;", "tag", "getLSTMTagType", "qn", "getHighQualityMaxQn", "isMedia", "isHighScene", "(ZZ)Ljava/lang/Integer;", "(Z)Ljava/lang/Integer;", "isOffPeakBillingPeriod", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityPredictorConfig {
    private final boolean enablePredict = KConfig.INSTANCE.ff("bp.video_quality_enable", false);
    private final boolean disableDeviceFeatureFetcher = KConfig.INSTANCE.ff("bp.disable_fetch_device_feature", false);
    private final Set<String> highQualityTagNames = UtilsKt.getSetValue$default(KConfig.INSTANCE, "bp.video_high_quality_names", SetsKt.setOf("高清优先"), null, 4, null);
    private final Set<String> lowDataQualityTagNames = UtilsKt.getSetValue$default(KConfig.INSTANCE, "bp.video_low_data_quality_names", SetsKt.setOf("省流优先"), null, 4, null);
    private final int recentSwitchesSaveCnt = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.recent_switches_save_cnt", 10);
    private final int upSwitchMinRateLimit = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.up_switch_min_rate_limit", 60);
    private final int upSwitchMinQnLimit = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.up_switch_min_qn_limit", 80);
    private final int downSwitchMinQnLimit = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.down_switch_min_qn_limit", 80);
    private final int downSwitchCntMinLimit = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.down_switch_cnt_min_limit", 2);
    private final int downSwitchMinRateLimit = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.down_switch_min_rate_limit", 90);
    private final double noisySwitchWeight = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.noisy_switch_weight", 50) / 100.0d;
    private final int deviceHighQualityMaxQn = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.device_high_quality_max_qn", 116);
    private final int mediaHighQualityMaxQn = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.media_high_quality_max_qn", BackoffConfigKt.MAX_DELAY_SECONDS);
    private final int deviceHighQualityMaxQnSmall = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.device_high_quality_max_qn_small", 64);
    private final int mediaHighQualityMaxQnSmall = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.media_high_quality_max_qn_small", 80);
    private final int defaultQualityMaxQn = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.default_quality_max_qn", 80);
    private final int defaultQualityMaxQnSmall = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.video.default_quality_max_qn_small", 64);
    private final boolean enablePredictOnSmall = KConfig.INSTANCE.ff("bp.predict_on_small_enable", false);
    private final boolean enableLSTMPredictor = KConfig.INSTANCE.ff("bp.vq.lstm_predictor_enable", false);
    private final boolean enableLSTMChecker = KConfig.INSTANCE.ff("bp.vq.lstm_checker_enable", false);
    private final int lstmConfidenceThreshold = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.vq.lstm_confidence_threshold", 80);
    private final int lstmDefaultMaxQn = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.vq.lstm_default_max_qn", 80);
    private final int offPeakLowScreenQn = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.vq.off_peak_low_screen_qn", 80);
    private final int offPeakHighScreenQn = UtilsKt.getIntValue(KConfig.INSTANCE, "bp.vq.off_peak_high_screen_qn", 116);

    public final boolean getEnablePredict() {
        return this.enablePredict;
    }

    public final boolean getDisableDeviceFeatureFetcher() {
        return this.disableDeviceFeatureFetcher;
    }

    public final Set<String> getHighQualityTagNames() {
        return this.highQualityTagNames;
    }

    public final Set<String> getLowDataQualityTagNames() {
        return this.lowDataQualityTagNames;
    }

    public final int getRecentSwitchesSaveCnt() {
        return this.recentSwitchesSaveCnt;
    }

    public final int getUpSwitchMinRateLimit() {
        return this.upSwitchMinRateLimit;
    }

    public final int getUpSwitchMinQnLimit() {
        return this.upSwitchMinQnLimit;
    }

    public final int getDownSwitchMinQnLimit() {
        return this.downSwitchMinQnLimit;
    }

    public final int getDownSwitchCntMinLimit() {
        return this.downSwitchCntMinLimit;
    }

    public final int getDownSwitchMinRateLimit() {
        return this.downSwitchMinRateLimit;
    }

    public final double getNoisySwitchWeight() {
        return this.noisySwitchWeight;
    }

    public final int getDeviceHighQualityMaxQn() {
        return this.deviceHighQualityMaxQn;
    }

    public final int getMediaHighQualityMaxQn() {
        return this.mediaHighQualityMaxQn;
    }

    public final int getDeviceHighQualityMaxQnSmall() {
        return this.deviceHighQualityMaxQnSmall;
    }

    public final int getMediaHighQualityMaxQnSmall() {
        return this.mediaHighQualityMaxQnSmall;
    }

    public final int getDefaultQualityMaxQn() {
        return this.defaultQualityMaxQn;
    }

    public final int getDefaultQualityMaxQnSmall() {
        return this.defaultQualityMaxQnSmall;
    }

    public final boolean getEnablePredictOnSmall() {
        return this.enablePredictOnSmall;
    }

    public final boolean getEnableLSTMPredictor() {
        return this.enableLSTMPredictor;
    }

    public final boolean getEnableLSTMChecker() {
        return this.enableLSTMChecker;
    }

    public final int getLstmConfidenceThreshold() {
        return this.lstmConfidenceThreshold;
    }

    public final int getLstmDefaultMaxQn() {
        return this.lstmDefaultMaxQn;
    }

    public final int getOffPeakLowScreenQn() {
        return this.offPeakLowScreenQn;
    }

    public final int getOffPeakHighScreenQn() {
        return this.offPeakHighScreenQn;
    }

    public final VideoQualityTagType getTagType(String tag) {
        return CollectionsKt.contains(this.highQualityTagNames, tag) ? VideoQualityTagType.High : CollectionsKt.contains(this.lowDataQualityTagNames, tag) ? VideoQualityTagType.Low : VideoQualityTagType.Normal;
    }

    public final VideoQualityTagType getLSTMTagType(int qn) {
        return qn > this.lstmDefaultMaxQn ? VideoQualityTagType.High : qn < this.lstmDefaultMaxQn ? VideoQualityTagType.Low : VideoQualityTagType.Normal;
    }

    public final Integer getHighQualityMaxQn(boolean isMedia, boolean isHighScene) {
        if (!isHighScene && !this.enablePredictOnSmall) {
            return null;
        }
        if (isMedia && isHighScene) {
            return Integer.valueOf(this.mediaHighQualityMaxQn);
        }
        if (!isMedia || isHighScene) {
            if (isMedia || !isHighScene) {
                if (isMedia || isHighScene) {
                    return null;
                }
                return Integer.valueOf(this.deviceHighQualityMaxQnSmall);
            }
            return Integer.valueOf(this.deviceHighQualityMaxQn);
        }
        return Integer.valueOf(this.mediaHighQualityMaxQnSmall);
    }

    public final Integer getDefaultQualityMaxQn(boolean isHighScene) {
        if (isHighScene) {
            return Integer.valueOf(this.defaultQualityMaxQn);
        }
        if (this.enablePredictOnSmall) {
            return Integer.valueOf(this.defaultQualityMaxQnSmall);
        }
        return null;
    }

    public final boolean isOffPeakBillingPeriod() {
        return KConfig.INSTANCE.ff("bp.vq.off_peak_billing_period", false);
    }
}