package kntr.common.ouro.core.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkConflictResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/utils/MarkConflictRule;", "T", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "", "displayStrategy", "Lkntr/common/ouro/core/utils/ConflictResolutionStrategy;", "defaultDisplayValue", "defaultInsertValue", "<init>", "(Lkntr/common/ouro/core/utils/ConflictResolutionStrategy;Lkntr/common/ouro/core/model/mark/OuroTextMark;Lkntr/common/ouro/core/model/mark/OuroTextMark;)V", "getDisplayStrategy", "()Lkntr/common/ouro/core/utils/ConflictResolutionStrategy;", "getDefaultDisplayValue", "()Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "getDefaultInsertValue", "component1", "component2", "component3", "copy", "(Lkntr/common/ouro/core/utils/ConflictResolutionStrategy;Lkntr/common/ouro/core/model/mark/OuroTextMark;Lkntr/common/ouro/core/model/mark/OuroTextMark;)Lkntr/common/ouro/core/utils/MarkConflictRule;", "equals", "", "other", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MarkConflictRule<T extends OuroTextMark> {
    private final T defaultDisplayValue;
    private final T defaultInsertValue;
    private final ConflictResolutionStrategy displayStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarkConflictRule copy$default(MarkConflictRule markConflictRule, ConflictResolutionStrategy conflictResolutionStrategy, OuroTextMark ouroTextMark, OuroTextMark ouroTextMark2, int i, Object obj) {
        if ((i & 1) != 0) {
            conflictResolutionStrategy = markConflictRule.displayStrategy;
        }
        if ((i & 2) != 0) {
            ouroTextMark = markConflictRule.defaultDisplayValue;
        }
        if ((i & 4) != 0) {
            ouroTextMark2 = markConflictRule.defaultInsertValue;
        }
        return markConflictRule.copy(conflictResolutionStrategy, ouroTextMark, ouroTextMark2);
    }

    public final ConflictResolutionStrategy component1() {
        return this.displayStrategy;
    }

    public final T component2() {
        return this.defaultDisplayValue;
    }

    public final T component3() {
        return this.defaultInsertValue;
    }

    public final MarkConflictRule<T> copy(ConflictResolutionStrategy conflictResolutionStrategy, T t, T t2) {
        Intrinsics.checkNotNullParameter(conflictResolutionStrategy, "displayStrategy");
        return new MarkConflictRule<>(conflictResolutionStrategy, t, t2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MarkConflictRule) {
            MarkConflictRule markConflictRule = (MarkConflictRule) obj;
            return this.displayStrategy == markConflictRule.displayStrategy && Intrinsics.areEqual(this.defaultDisplayValue, markConflictRule.defaultDisplayValue) && Intrinsics.areEqual(this.defaultInsertValue, markConflictRule.defaultInsertValue);
        }
        return false;
    }

    public int hashCode() {
        return (((this.displayStrategy.hashCode() * 31) + (this.defaultDisplayValue == null ? 0 : this.defaultDisplayValue.hashCode())) * 31) + (this.defaultInsertValue != null ? this.defaultInsertValue.hashCode() : 0);
    }

    public String toString() {
        ConflictResolutionStrategy conflictResolutionStrategy = this.displayStrategy;
        T t = this.defaultDisplayValue;
        return "MarkConflictRule(displayStrategy=" + conflictResolutionStrategy + ", defaultDisplayValue=" + t + ", defaultInsertValue=" + this.defaultInsertValue + ")";
    }

    public MarkConflictRule(ConflictResolutionStrategy displayStrategy, T t, T t2) {
        Intrinsics.checkNotNullParameter(displayStrategy, "displayStrategy");
        this.displayStrategy = displayStrategy;
        this.defaultDisplayValue = t;
        this.defaultInsertValue = t2;
    }

    public /* synthetic */ MarkConflictRule(ConflictResolutionStrategy conflictResolutionStrategy, OuroTextMark ouroTextMark, OuroTextMark ouroTextMark2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(conflictResolutionStrategy, (i & 2) != 0 ? null : ouroTextMark, (i & 4) != 0 ? null : ouroTextMark2);
    }

    public final ConflictResolutionStrategy getDisplayStrategy() {
        return this.displayStrategy;
    }

    public final T getDefaultDisplayValue() {
        return this.defaultDisplayValue;
    }

    public final T getDefaultInsertValue() {
        return this.defaultInsertValue;
    }
}