package tv.danmaku.bili.report.biz.dns.misaka.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DnsMisakaConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/report/biz/dns/misaka/config/DnsMisakaConfig;", "", "<init>", "()V", "DEF_SAMPLE", "", "defSample", "", "getDefSample", "()Ljava/lang/String;", "EVENT_SAMPLE", "eventSample", "getEventSample", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DnsMisakaConfig {
    public static final int DEF_SAMPLE = 1000;
    public static final String EVENT_SAMPLE = "[{\"literal\":\"fetch_error\",\"sample\":10000}]";
    public static final DnsMisakaConfig INSTANCE = new DnsMisakaConfig();

    private DnsMisakaConfig() {
    }

    public final String getDefSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "httpdns.def_sample2", (Object) null, 2, (Object) null);
    }

    public final String getEventSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "httpdns.event_sample2", (Object) null, 2, (Object) null);
    }
}