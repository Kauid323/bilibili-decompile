package kntr.base.net.comm.muiltidomain;

import java.util.HashMap;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0014\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/base/net/comm/muiltidomain/MultiDomain;", "", "<init>", "()V", "rules", "Ljava/util/HashMap;", "", "Lkntr/base/net/comm/muiltidomain/Rule;", "Lkotlin/collections/HashMap;", "rdm", "Lkotlin/random/Random$Default;", "initRules", "", "isEnabled", "", "rawHost", "alternative", "domains", "", "setAlternative", "host", "updateRules", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/net/comm/muiltidomain/RuleConfig;", "multi_domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MultiDomain {
    public static final MultiDomain INSTANCE = new MultiDomain();
    private static HashMap<String, Rule> rules = new HashMap<>();
    private static final Random.Default rdm = Random.Default;

    private MultiDomain() {
    }

    static {
        INSTANCE.initRules();
    }

    public final void initRules() {
        List config;
        String multiDomainRules = Config.INSTANCE.getMultiDomainRules();
        if (multiDomainRules == null) {
            multiDomainRules = "[]";
        }
        config = MultiDomainKt.parse(multiDomainRules);
        if (config == null) {
            config = CollectionsKt.emptyList();
        }
        updateRules(config);
    }

    public final boolean isEnabled(String rawHost) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        Rule it = rules.get(rawHost);
        return it != null && rdm.nextFloat() < it.getSample();
    }

    public final String alternative(String rawHost) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        Rule rule = rules.get(rawHost);
        if (rule != null) {
            return rule.getAlt();
        }
        return null;
    }

    public final List<String> domains(String rawHost) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        Rule rule = rules.get(rawHost);
        if (rule != null) {
            return rule.getDomains();
        }
        return null;
    }

    public final void setAlternative(String rawHost, String host) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        Intrinsics.checkNotNullParameter(host, "host");
        Rule it = rules.get(rawHost);
        if (it != null) {
            it.setAlt(host);
        }
    }

    public final void updateRules(List<RuleConfig> list) {
        Intrinsics.checkNotNullParameter(list, RedirectImpKt.REDIRECT_KV_CONFIG);
        HashMap<String, Rule> hashMap = new HashMap<>(rules);
        List<RuleConfig> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            RuleConfig it = (RuleConfig) element$iv;
            String host = it.getDomains().get(0);
            hashMap.put(host, new Rule(it.getSample(), it.getDomains(), null, 4, null));
        }
        rules = hashMap;
    }
}