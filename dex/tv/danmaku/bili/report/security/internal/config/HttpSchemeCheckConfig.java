package tv.danmaku.bili.report.security.internal.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: HttpSchemeCheckConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/security/internal/config/HttpSchemeCheckConfig;", "", "<init>", "()V", "DEBUG_TOAST_ENABLE_KEY", "", "DEBUG_TOAST_ENABLE_VALUE", "", "ENABLE", "enable", "getEnable", "()Ljava/lang/Boolean;", "RULES", "rules", "getRules", "()Ljava/lang/String;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HttpSchemeCheckConfig {
    public static final int $stable = 0;
    public static final String DEBUG_TOAST_ENABLE_KEY = "http_scheme_check_debug_toast_enable";
    public static final boolean DEBUG_TOAST_ENABLE_VALUE = true;
    public static final boolean ENABLE = true;
    public static final HttpSchemeCheckConfig INSTANCE = new HttpSchemeCheckConfig();
    public static final String RULES = "[]";

    private HttpSchemeCheckConfig() {
    }

    public final Boolean getEnable() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "net_http_scheme_check_enable", (Object) null, 2, (Object) null);
    }

    public final String getRules() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.http_scheme_check_rules", (Object) null, 2, (Object) null);
    }
}