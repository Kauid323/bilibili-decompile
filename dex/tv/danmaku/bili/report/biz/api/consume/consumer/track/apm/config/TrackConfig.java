package tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.config;

import com.bilibili.lib.blconfig.ConfigManager;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TrackConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\t¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/track/apm/config/TrackConfig;", "", "<init>", "()V", "DEF_SAMPLE", "", "defSample", "", "getDefSample", "()Ljava/lang/String;", "NET_SAMPLE", "netSample", "getNetSample", "NET_PROTOCOL_SAMPLE", "netProtocolSample", "getNetProtocolSample", "DEF_IMAGE_SAMPLE", "defImageSample", "getDefImageSample", "IMAGE_SAMPLE", "imageSample", "getImageSample", "DEF_ERROR_SAMPLE", "defErrorSample", "getDefErrorSample", "NET_ERROR_SAMPLE", "netErrorSample", "getNetErrorSample", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TrackConfig {
    public static final int DEF_ERROR_SAMPLE = 10000;
    public static final int DEF_IMAGE_SAMPLE = 10;
    public static final int DEF_SAMPLE = 10;
    public static final String IMAGE_SAMPLE = "[]";
    public static final TrackConfig INSTANCE = new TrackConfig();
    public static final String NET_ERROR_SAMPLE = "[]";
    public static final String NET_PROTOCOL_SAMPLE = "[]";
    public static final String NET_SAMPLE = "[]";

    private TrackConfig() {
    }

    public final String getDefSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_def_sample2", (Object) null);
    }

    public final String getNetSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_net_sample2", (Object) null);
    }

    public final String getNetProtocolSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_net_protocol_sample2", (Object) null);
    }

    public final String getDefImageSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_def_image_sample2", (Object) null);
    }

    public final String getImageSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_image_sample2", (Object) null);
    }

    public final String getDefErrorSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_def_error_sample2", (Object) null);
    }

    public final String getNetErrorSample() {
        return (String) ConfigManager.Companion.config().get("neuron.track_net_error_sample2", (Object) null);
    }
}