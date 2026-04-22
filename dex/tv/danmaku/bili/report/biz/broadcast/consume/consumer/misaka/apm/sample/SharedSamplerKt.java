package tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.sample;

import com.bilibili.lib.moss.internal.stream.internal.tracker.ProtocolsKt;
import com.bilibili.lib.rpc.track.model.broadcast.Event;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.broadcast.consume.consumer.misaka.apm.config.BroadcastMisakaConfig;
import tv.danmaku.bili.report.sample.Sample;
import tv.danmaku.bili.report.sample.rule.literal.LiteralRule;
import tv.danmaku.bili.report.sample.rule.literal.LiteralRuleConfigKt;
import tv.danmaku.bili.report.sample.rule.regex.RegexRule;
import tv.danmaku.bili.report.sample.rule.regex.RegexRuleConfigKt;

/* compiled from: SharedSampler.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0002\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"sampleShared", "Lkotlin/Pair;", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/broadcast/Event;", "targetPath", "", "sEventSampleRules", "", "Ltv/danmaku/bili/report/sample/rule/regex/RegexRule;", "sBizSampleRules", "Ltv/danmaku/bili/report/sample/rule/literal/LiteralRule;", "defRate", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SharedSamplerKt {
    private static final List<LiteralRule> sBizSampleRules;
    private static final List<RegexRule> sEventSampleRules;

    public static final Pair<Boolean, Float> sampleShared(Event event, String targetPath) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(targetPath, "targetPath");
        RegexRule eventRate = RegexRuleConfigKt.matchRegexRule(ProtocolsKt.eventToString(event), sEventSampleRules);
        if (eventRate != null) {
            return Sample.Companion.sample(eventRate.getSample());
        }
        LiteralRule bizRate = LiteralRuleConfigKt.matchLiteralRule(targetPath, sBizSampleRules);
        if (bizRate != null) {
            return Sample.Companion.sample(bizRate.getSample());
        }
        return Sample.Companion.sample(defRate());
    }

    static {
        String eventSample = BroadcastMisakaConfig.INSTANCE.getEventSample();
        if (eventSample == null) {
            eventSample = "[]";
        }
        List<RegexRule> parseRegexRules = RegexRuleConfigKt.parseRegexRules(eventSample);
        if (parseRegexRules == null) {
            parseRegexRules = CollectionsKt.emptyList();
        }
        sEventSampleRules = parseRegexRules;
        String bizSample = BroadcastMisakaConfig.INSTANCE.getBizSample();
        List<LiteralRule> parseLiteralRules = LiteralRuleConfigKt.parseLiteralRules(bizSample != null ? bizSample : "[]");
        if (parseLiteralRules == null) {
            parseLiteralRules = CollectionsKt.emptyList();
        }
        sBizSampleRules = parseLiteralRules;
    }

    private static final int defRate() {
        Integer intOrNull;
        String defSample = BroadcastMisakaConfig.INSTANCE.getDefSample();
        if (defSample == null || (intOrNull = StringsKt.toIntOrNull(defSample)) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }
}