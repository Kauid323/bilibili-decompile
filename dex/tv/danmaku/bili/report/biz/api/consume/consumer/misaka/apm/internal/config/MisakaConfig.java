package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: MisakaConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/consumer/misaka/apm/internal/config/MisakaConfig;", "", "<init>", "()V", "DEF_SAMPLE_RATE", "", "defSample", "", "getDefSample", "()Ljava/lang/String;", "DEF_BIZ_SAMPLE", "bizSample", "getBizSample", "DEF_BIZ_FILTER", "bizFilter", "getBizFilter", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaConfig {
    public static final String DEF_BIZ_FILTER = "";
    public static final String DEF_BIZ_SAMPLE = "[]";
    public static final int DEF_SAMPLE_RATE = 100;
    public static final MisakaConfig INSTANCE = new MisakaConfig();

    private MisakaConfig() {
    }

    public final String getDefSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "misaka.apm_view_report_rate2", (Object) null, 2, (Object) null);
    }

    public final String getBizSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "misaka.api_sample_rules", (Object) null, 2, (Object) null);
    }

    public final String getBizFilter() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "misaka.api_filter_rules", (Object) null, 2, (Object) null);
    }
}