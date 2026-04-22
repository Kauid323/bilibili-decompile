package tv.danmaku.bili.overseas.internal;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;

/* compiled from: NetChange.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/overseas/internal/DnsProviderConfig;", "", "<init>", "()V", "DEFAULT_CD", "", "totalSwitcher", "", "getTotalSwitcher", "()Z", "netSwitchDisable", "getNetSwitchDisable", "googleCD", "getGoogleCD", "()J", "locationCD", "getLocationCD", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DnsProviderConfig {
    public static final int $stable = 0;
    private static final long DEFAULT_CD = -1;
    public static final DnsProviderConfig INSTANCE = new DnsProviderConfig();
    private static final long googleCD;
    private static final long locationCD;

    private DnsProviderConfig() {
    }

    public final boolean getTotalSwitcher() {
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "httpdns_provider_total_switch", (Object) null, 2, (Object) null);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean getNetSwitchDisable() {
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "httpdns_net_provider_switch_disable", (Object) null, 2, (Object) null);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final long getGoogleCD() {
        return googleCD;
    }

    static {
        String str = (String) ConfigManager.Companion.config().get("httpdns.request_google_cool_down_time", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        googleCD = (str != null ? Long.parseLong(str) : -1L) * 1000;
        String str2 = (String) ConfigManager.Companion.config().get("httpdns.request_location_cool_down_time", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        locationCD = (str2 != null ? Long.parseLong(str2) : -1L) * 1000;
    }

    public final long getLocationCD() {
        return locationCD;
    }
}