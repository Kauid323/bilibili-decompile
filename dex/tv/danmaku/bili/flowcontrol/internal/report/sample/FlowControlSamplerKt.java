package tv.danmaku.bili.flowcontrol.internal.report.sample;

import com.bilibili.lib.rpc.track.model.flowcontrol.Event;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.report.sample.Sample;
import tv.danmaku.bili.report.sample.Whitelist;
import tv.danmaku.bili.report.sample.rule.literal.LiteralRuleConfigFKt;
import tv.danmaku.bili.report.sample.rule.literal.LiteralRuleF;

/* compiled from: FlowControlSampler.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\b\u0010\t\u001a\u00020\u0003H\u0002\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"flowControlSample", "Lkotlin/Pair;", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/flowcontrol/Event;", "sBizSampleRules", "", "Ltv/danmaku/bili/report/sample/rule/literal/LiteralRuleF;", "defRate", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FlowControlSamplerKt {
    private static final List<LiteralRuleF> sBizSampleRules;

    public static final Pair<Boolean, Float> flowControlSample(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Whitelist.Companion.wl()) {
            return new Pair<>(true, Float.valueOf(1.0f));
        }
        String lowerCase = event.toString().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        LiteralRuleF bizRate = LiteralRuleConfigFKt.matchLiteralRuleF(lowerCase, sBizSampleRules);
        if (bizRate != null) {
            return Sample.Companion.sample(bizRate.getSample());
        }
        return Sample.Companion.sample(defRate());
    }

    static {
        String bizSample = FlowControlConfig.INSTANCE.getBizSample();
        if (bizSample == null) {
            bizSample = "";
        }
        List<LiteralRuleF> parseLiteralRuleF = LiteralRuleConfigFKt.parseLiteralRuleF(bizSample);
        if (parseLiteralRuleF == null) {
            parseLiteralRuleF = CollectionsKt.emptyList();
        }
        sBizSampleRules = parseLiteralRuleF;
    }

    private static final float defRate() {
        Float defSample = FlowControlConfig.INSTANCE.getDefSample();
        if (defSample != null) {
            return defSample.floatValue();
        }
        return 1.0f;
    }
}