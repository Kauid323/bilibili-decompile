package tv.danmaku.bili.bilow.lb.internal;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LbRule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/bilow/lb/internal/LbRule;", "", "weight", "", "rule", "", "", "<init>", "(ILjava/util/List;)V", "getWeight", "()I", "getRule", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LbRule {
    @SerializedName("rule")
    private final List<String> rule;
    @SerializedName("weight")
    private final int weight;

    public LbRule() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LbRule copy$default(LbRule lbRule, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = lbRule.weight;
        }
        if ((i2 & 2) != 0) {
            list = lbRule.rule;
        }
        return lbRule.copy(i, list);
    }

    public final int component1() {
        return this.weight;
    }

    public final List<String> component2() {
        return this.rule;
    }

    public final LbRule copy(int i, List<String> list) {
        return new LbRule(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LbRule) {
            LbRule lbRule = (LbRule) obj;
            return this.weight == lbRule.weight && Intrinsics.areEqual(this.rule, lbRule.rule);
        }
        return false;
    }

    public int hashCode() {
        return (this.weight * 31) + (this.rule == null ? 0 : this.rule.hashCode());
    }

    public String toString() {
        int i = this.weight;
        return "LbRule(weight=" + i + ", rule=" + this.rule + ")";
    }

    public LbRule(int weight, List<String> list) {
        this.weight = weight;
        this.rule = list;
    }

    public /* synthetic */ LbRule(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : list);
    }

    public final int getWeight() {
        return this.weight;
    }

    public final List<String> getRule() {
        return this.rule;
    }
}