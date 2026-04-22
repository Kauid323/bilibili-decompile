package tv.danmaku.bili.report.sample.rule.literal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LiteralRuleConfigF.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/literal/LiteralRuleConfigF;", "", "literal", "", "sample", "", "<init>", "(Ljava/lang/String;F)V", "getLiteral", "()Ljava/lang/String;", "setLiteral", "(Ljava/lang/String;)V", "getSample", "()F", "setSample", "(F)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiteralRuleConfigF {
    private String literal;
    private float sample;

    public LiteralRuleConfigF() {
        this(null, 0.0f, 3, null);
    }

    public static /* synthetic */ LiteralRuleConfigF copy$default(LiteralRuleConfigF literalRuleConfigF, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = literalRuleConfigF.literal;
        }
        if ((i & 2) != 0) {
            f = literalRuleConfigF.sample;
        }
        return literalRuleConfigF.copy(str, f);
    }

    public final String component1() {
        return this.literal;
    }

    public final float component2() {
        return this.sample;
    }

    public final LiteralRuleConfigF copy(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "literal");
        return new LiteralRuleConfigF(str, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiteralRuleConfigF) {
            LiteralRuleConfigF literalRuleConfigF = (LiteralRuleConfigF) obj;
            return Intrinsics.areEqual(this.literal, literalRuleConfigF.literal) && Float.compare(this.sample, literalRuleConfigF.sample) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.literal.hashCode() * 31) + Float.floatToIntBits(this.sample);
    }

    public String toString() {
        String str = this.literal;
        return "LiteralRuleConfigF(literal=" + str + ", sample=" + this.sample + ")";
    }

    public LiteralRuleConfigF(String literal, float sample) {
        Intrinsics.checkNotNullParameter(literal, "literal");
        this.literal = literal;
        this.sample = sample;
    }

    public /* synthetic */ LiteralRuleConfigF(String str, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0f : f);
    }

    public final String getLiteral() {
        return this.literal;
    }

    public final float getSample() {
        return this.sample;
    }

    public final void setLiteral(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.literal = str;
    }

    public final void setSample(float f) {
        this.sample = f;
    }
}