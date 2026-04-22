package tv.danmaku.bili.report.sample.rule.glob;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: GlobRuleConfigF.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/report/sample/rule/glob/GlobRuleConfigF;", "", "glob", "", "sample", "", "<init>", "(Ljava/lang/String;F)V", "getGlob", "()Ljava/lang/String;", "setGlob", "(Ljava/lang/String;)V", "getSample", "()F", "setSample", "(F)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GlobRuleConfigF {
    private String glob;
    private float sample;

    public GlobRuleConfigF() {
        this(null, 0.0f, 3, null);
    }

    public static /* synthetic */ GlobRuleConfigF copy$default(GlobRuleConfigF globRuleConfigF, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globRuleConfigF.glob;
        }
        if ((i & 2) != 0) {
            f = globRuleConfigF.sample;
        }
        return globRuleConfigF.copy(str, f);
    }

    public final String component1() {
        return this.glob;
    }

    public final float component2() {
        return this.sample;
    }

    public final GlobRuleConfigF copy(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "glob");
        return new GlobRuleConfigF(str, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GlobRuleConfigF) {
            GlobRuleConfigF globRuleConfigF = (GlobRuleConfigF) obj;
            return Intrinsics.areEqual(this.glob, globRuleConfigF.glob) && Float.compare(this.sample, globRuleConfigF.sample) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.glob.hashCode() * 31) + Float.floatToIntBits(this.sample);
    }

    public String toString() {
        String str = this.glob;
        return "GlobRuleConfigF(glob=" + str + ", sample=" + this.sample + ")";
    }

    public GlobRuleConfigF(String glob, float sample) {
        Intrinsics.checkNotNullParameter(glob, "glob");
        this.glob = glob;
        this.sample = sample;
    }

    public /* synthetic */ GlobRuleConfigF(String str, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0f : f);
    }

    public final String getGlob() {
        return this.glob;
    }

    public final float getSample() {
        return this.sample;
    }

    public final void setGlob(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.glob = str;
    }

    public final void setSample(float f) {
        this.sample = f;
    }
}