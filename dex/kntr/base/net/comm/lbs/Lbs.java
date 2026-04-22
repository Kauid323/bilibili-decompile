package kntr.base.net.comm.lbs;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.lbs.internal.LbBucketsKt;
import kntr.base.net.comm.lbs.internal.LbConfig;
import kntr.base.net.comm.lbs.internal.LbRuleKt;
import kntr.base.net.comm.muiltidomain.RuleConfig;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Lbs.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bJ*\u0010\u0012\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/base/net/comm/lbs/Lbs;", "", "<init>", "()V", "enable", "", "deviceRule", "", "", "getDeviceRule", "()Ljava/util/List;", "setDeviceRule", "(Ljava/util/List;)V", "regex", "Lkotlin/text/Regex;", "maybeChangeHost", "host", "isLbHost", "isTargetHost", "parseRegex", "lbsMultiDomainRules", "Lkntr/base/net/comm/muiltidomain/RuleConfig;", "isEnabled", "lbs_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Lbs {
    private static List<String> deviceRule;
    private static final Regex regex;
    public static final Lbs INSTANCE = new Lbs();
    private static final boolean enable = INSTANCE.isEnabled();

    private Lbs() {
    }

    static {
        Lbs lbs = INSTANCE;
        String targetDomain = LbConfig.INSTANCE.getTargetDomain();
        if (targetDomain == null) {
            targetDomain = "";
        }
        regex = lbs.parseRegex(targetDomain);
        if (enable) {
            String it = KConfig.INSTANCE.config(LbConfig.INSTANCE.getBalanceRulesDDKEY(), LbConfig.BALANCE_RULES);
            Intrinsics.checkNotNull(it);
            List rules = LbRuleKt.parseBalanceRules(it);
            List newDevice = LbBucketsKt.getDeviceRule(rules);
            deviceRule = newDevice;
            if (deviceRule != null) {
            }
            KLog_androidKt.getKLog().i("net.Lbs", "update deviceRule " + deviceRule);
        }
    }

    public final List<String> getDeviceRule() {
        return deviceRule;
    }

    public final void setDeviceRule(List<String> list) {
        deviceRule = list;
    }

    public final String maybeChangeHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (!enable) {
            return host;
        }
        try {
            List dr = deviceRule;
            if (isTargetHost(regex, deviceRule, host) && dr != null) {
                String str = (String) CollectionsKt.firstOrNull(dr);
                if (str != null) {
                    return str;
                }
            }
            return host;
        } catch (Exception e) {
            return host;
        }
    }

    public final boolean isLbHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (enable) {
            return isTargetHost(regex, deviceRule, host);
        }
        return false;
    }

    private final boolean isTargetHost(Regex regex2, List<String> list, String host) {
        MatchResult find = regex2 != null ? Regex.find$default(regex2, host, 0, 2, (Object) null) : null;
        boolean z = true;
        if ((find != null ? find.getValue() : null) != null) {
            return true;
        }
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z = false;
        }
        if (z) {
            return false;
        }
        return list.contains(host);
    }

    private final Regex parseRegex(String regex2) {
        String str = regex2;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            return new Regex(regex2);
        } catch (Exception e) {
            return null;
        }
    }

    public final RuleConfig lbsMultiDomainRules() {
        List it = deviceRule;
        if (it != null) {
            return new RuleConfig(1.0f, it);
        }
        return null;
    }

    private final boolean isEnabled() {
        Boolean enable2 = LbConfig.INSTANCE.getEnable();
        if (enable2 != null) {
            return enable2.booleanValue();
        }
        return true;
    }
}