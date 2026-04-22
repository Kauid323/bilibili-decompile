package tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LiveBroadcastConfig.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/biz/broadcast/consume/consumer/misaka/apm/config/LiveBroadcastConfig;", "", "<init>", "()V", "DEF_EVENT_SAMPLE", "", "eventSample", "getEventSample", "()Ljava/lang/String;", "DEF_BIZ_SAMPLE", "bizSample", "getBizSample", "DEF_SAMPLE", "", "defSample", "getDefSample", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiveBroadcastConfig {
    public static final int $stable = 0;
    public static final String DEF_BIZ_SAMPLE = "[]";
    public static final String DEF_EVENT_SAMPLE = "[]";
    public static final int DEF_SAMPLE = 0;
    public static final LiveBroadcastConfig INSTANCE = new LiveBroadcastConfig();

    private LiveBroadcastConfig() {
    }

    public final String getEventSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "grpc.broadcast_live_event_report_rate", (Object) null, 2, (Object) null);
    }

    public final String getBizSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "grpc.broadcast_live_biz_report_rate", (Object) null, 2, (Object) null);
    }

    public final String getDefSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "grpc.broadcast_live_def_report_rate", (Object) null, 2, (Object) null);
    }
}