package tv.danmaku.bili.bilow.domain;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0007J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/bilow/domain/RuleConfig;", "", "sample", "", "domains", "", "", "<init>", "(FLjava/util/List;)V", "getSample", "()F", "setSample", "(F)V", "getDomains", "()Ljava/util/List;", "setDomains", "(Ljava/util/List;)V", "valid", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RuleConfig {
    private List<String> domains;
    private float sample;

    public RuleConfig() {
        this(0.0f, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RuleConfig copy$default(RuleConfig ruleConfig, float f, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ruleConfig.sample;
        }
        if ((i & 2) != 0) {
            list = ruleConfig.domains;
        }
        return ruleConfig.copy(f, list);
    }

    public final float component1() {
        return this.sample;
    }

    public final List<String> component2() {
        return this.domains;
    }

    public final RuleConfig copy(float f, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "domains");
        return new RuleConfig(f, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RuleConfig) {
            RuleConfig ruleConfig = (RuleConfig) obj;
            return Float.compare(this.sample, ruleConfig.sample) == 0 && Intrinsics.areEqual(this.domains, ruleConfig.domains);
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.sample) * 31) + this.domains.hashCode();
    }

    public String toString() {
        float f = this.sample;
        return "RuleConfig(sample=" + f + ", domains=" + this.domains + ")";
    }

    public RuleConfig(float sample, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "domains");
        this.sample = sample;
        this.domains = list;
    }

    public /* synthetic */ RuleConfig(float f, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final float getSample() {
        return this.sample;
    }

    public final void setDomains(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.domains = list;
    }

    public final void setSample(float f) {
        this.sample = f;
    }

    public final boolean valid() {
        return this.sample > 0.0f && this.domains.size() > 1;
    }
}