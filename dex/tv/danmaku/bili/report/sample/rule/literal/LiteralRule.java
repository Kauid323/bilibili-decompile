package tv.danmaku.bili.report.sample.rule.literal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LiteralRuleConfig.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/literal/LiteralRule;", "", "config", "Ltv/danmaku/bili/report/sample/rule/literal/LiteralRuleConfig;", "<init>", "(Ltv/danmaku/bili/report/sample/rule/literal/LiteralRuleConfig;)V", "literal", "", "sample", "", "getSample", "()I", "matches", "", "target", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiteralRule {
    private final String literal;
    private final int sample;

    public LiteralRule(LiteralRuleConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.literal = config.getLiteral();
        this.sample = config.getSample();
    }

    public final int getSample() {
        return this.sample;
    }

    public final boolean matches(String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return this.literal.equals(target);
    }
}