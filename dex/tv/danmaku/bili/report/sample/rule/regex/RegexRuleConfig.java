package tv.danmaku.bili.report.sample.rule.regex;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RegexRuleConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/regex/RegexRuleConfig;", "", "regex", "", "sample", "", "<init>", "(Ljava/lang/String;I)V", "getRegex", "()Ljava/lang/String;", "setRegex", "(Ljava/lang/String;)V", "getSample", "()I", "setSample", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RegexRuleConfig {
    private String regex;
    private int sample;

    public RegexRuleConfig() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ RegexRuleConfig copy$default(RegexRuleConfig regexRuleConfig, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = regexRuleConfig.regex;
        }
        if ((i2 & 2) != 0) {
            i = regexRuleConfig.sample;
        }
        return regexRuleConfig.copy(str, i);
    }

    public final String component1() {
        return this.regex;
    }

    public final int component2() {
        return this.sample;
    }

    public final RegexRuleConfig copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "regex");
        return new RegexRuleConfig(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegexRuleConfig) {
            RegexRuleConfig regexRuleConfig = (RegexRuleConfig) obj;
            return Intrinsics.areEqual(this.regex, regexRuleConfig.regex) && this.sample == regexRuleConfig.sample;
        }
        return false;
    }

    public int hashCode() {
        return (this.regex.hashCode() * 31) + this.sample;
    }

    public String toString() {
        String str = this.regex;
        return "RegexRuleConfig(regex=" + str + ", sample=" + this.sample + ")";
    }

    public RegexRuleConfig(String regex, int sample) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        this.regex = regex;
        this.sample = sample;
    }

    public /* synthetic */ RegexRuleConfig(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getRegex() {
        return this.regex;
    }

    public final int getSample() {
        return this.sample;
    }

    public final void setRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.regex = str;
    }

    public final void setSample(int i) {
        this.sample = i;
    }
}