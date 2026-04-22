package kntr.base.net.comm.lbs.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;

/* compiled from: LbConfig.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lkntr/base/net/comm/lbs/internal/LbConfig;", "", "<init>", "()V", "ENABLE", "", "enable", "getEnable", "()Ljava/lang/Boolean;", "BALANCE_RULES", "", "balanceRulesDDKEY", "getBalanceRulesDDKEY", "()Ljava/lang/String;", "TARGET_DOMAIN", "targetDomain", "getTargetDomain", "lbs_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LbConfig {
    public static final String BALANCE_RULES = "[{\"weight\":4000,\"rule\":[\"i0.hdslb.com\",\"i1.hdslb.com\",\"i2.hdslb.com\"]},{\"weight\":3000,\"rule\":[\"i1.hdslb.com\",\"i2.hdslb.com\",\"i0.hdslb.com\"]},{\"weight\":3000,\"rule\":[\"i2.hdslb.com\",\"i0.hdslb.com\",\"i1.hdslb.com\"]}]";
    public static final boolean ENABLE = true;
    public static final String TARGET_DOMAIN = "";
    public static final LbConfig INSTANCE = new LbConfig();
    private static final String balanceRulesDDKEY = "bfs.cdn_balance_degrade_rules";

    private LbConfig() {
    }

    public final Boolean getEnable() {
        return Boolean.valueOf(IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "http_load_balance_enable", false, 2, null));
    }

    public final String getBalanceRulesDDKEY() {
        return balanceRulesDDKEY;
    }

    public final String getTargetDomain() {
        return IPlatformConfig.CC.config$default(KConfig.INSTANCE, "bfs.cdn_balance_url", null, 2, null);
    }
}