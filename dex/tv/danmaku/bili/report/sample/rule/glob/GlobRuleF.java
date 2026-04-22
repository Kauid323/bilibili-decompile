package tv.danmaku.bili.report.sample.rule.glob;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import tv.danmaku.bili.BR;

/* compiled from: GlobRuleConfigF.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/glob/GlobRuleF;", "", "config", "Ltv/danmaku/bili/report/sample/rule/glob/GlobRuleConfigF;", "<init>", "(Ltv/danmaku/bili/report/sample/rule/glob/GlobRuleConfigF;)V", "regex", "Lkotlin/text/Regex;", "sample", "", "getSample", "()F", "matches", "", "target", "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GlobRuleF {
    private final Regex regex;
    private final float sample;

    public GlobRuleF(GlobRuleConfigF config) {
        String globToRegex;
        Intrinsics.checkNotNullParameter(config, "config");
        globToRegex = GlobRuleConfigFKt.globToRegex(config.getGlob());
        this.regex = new Regex(globToRegex);
        this.sample = config.getSample();
    }

    public final float getSample() {
        return this.sample;
    }

    public final boolean matches(String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            return this.regex.matches(target);
        } catch (Exception e) {
            return false;
        }
    }
}