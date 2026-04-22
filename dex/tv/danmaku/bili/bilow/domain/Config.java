package tv.danmaku.bili.bilow.domain;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/bilow/domain/Config;", "", "<init>", "()V", "MULTI_DOMAIN_RULES", "", "multiDomainRules", "getMultiDomainRules", "()Ljava/lang/String;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class Config {
    public static final Config INSTANCE = new Config();
    public static final String MULTI_DOMAIN_RULES = "[]";

    private Config() {
    }

    public final String getMultiDomainRules() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "okhttp.multi_domain_rules", (Object) null, 2, (Object) null);
    }
}