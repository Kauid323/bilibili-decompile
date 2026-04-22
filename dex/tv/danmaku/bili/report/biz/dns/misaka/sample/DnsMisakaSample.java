package tv.danmaku.bili.report.biz.dns.misaka.sample;

import com.bilibili.lib.rpc.track.model.dns.DnsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.dns.misaka.config.DnsMisakaConfig;
import tv.danmaku.bili.report.sample.Sample;
import tv.danmaku.bili.report.sample.rule.literal.LiteralRule;
import tv.danmaku.bili.report.sample.rule.literal.LiteralRuleConfigKt;

/* compiled from: DnsMisakaSample.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/report/biz/dns/misaka/sample/DnsMisakaSample;", "", "<init>", "()V", "TAG", "", "dnsMisakaSample", "Lkotlin/Pair;", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/dns/DnsEvent;", "eventSampleRules", "", "Ltv/danmaku/bili/report/sample/rule/literal/LiteralRule;", "defSample", "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DnsMisakaSample {
    public static final DnsMisakaSample INSTANCE = new DnsMisakaSample();
    private static final String TAG = "httpdns.misaka.sample";
    private static final List<LiteralRule> eventSampleRules;

    private DnsMisakaSample() {
    }

    static {
        String eventSample = DnsMisakaConfig.INSTANCE.getEventSample();
        if (eventSample == null) {
            eventSample = DnsMisakaConfig.EVENT_SAMPLE;
        }
        List<LiteralRule> parseLiteralRules = LiteralRuleConfigKt.parseLiteralRules(eventSample);
        if (parseLiteralRules == null) {
            parseLiteralRules = CollectionsKt.emptyList();
        }
        eventSampleRules = parseLiteralRules;
    }

    public final Pair<Boolean, Float> dnsMisakaSample(DnsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String lowerCase = event.getEvent().toString().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        LiteralRule eventRate = LiteralRuleConfigKt.matchLiteralRule(lowerCase, eventSampleRules);
        if (eventRate != null) {
            return Sample.Companion.sample(eventRate.getSample());
        }
        return Sample.Companion.sample(defSample());
    }

    private final int defSample() {
        Integer intOrNull;
        String defSample = DnsMisakaConfig.INSTANCE.getDefSample();
        if (defSample == null || (intOrNull = StringsKt.toIntOrNull(defSample)) == null) {
            return 1000;
        }
        return intOrNull.intValue();
    }
}