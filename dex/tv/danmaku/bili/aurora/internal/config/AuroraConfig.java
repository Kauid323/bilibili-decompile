package tv.danmaku.bili.aurora.internal.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: AuroraConfig.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/aurora/internal/config/AuroraConfig;", "", "<init>", "()V", "ROUTE_ENABLED", "", "routeEnabled", "getRouteEnabled", "()Ljava/lang/Boolean;", "ROUTE_SKIP_HOSTS", "", "routeSkipHosts", "getRouteSkipHosts", "()Ljava/lang/String;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuroraConfig {
    public static final AuroraConfig INSTANCE = new AuroraConfig();
    public static final boolean ROUTE_ENABLED = true;
    public static final String ROUTE_SKIP_HOSTS = "i0.hdslb.com,i1.hdslb.com,i2.hdslb.com";

    private AuroraConfig() {
    }

    public final Boolean getRouteEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "net_aurora_route_enabled", (Object) null, 2, (Object) null);
    }

    public final String getRouteSkipHosts() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.aurora_route_skip_hosts", (Object) null, 2, (Object) null);
    }
}