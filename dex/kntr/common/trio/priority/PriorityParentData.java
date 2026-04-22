package kntr.common.trio.priority;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComposePriorityHorizon.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lkntr/common/trio/priority/PriorityParentData;", "", "priority", "", "<init>", "(I)V", "getPriority", "()I", "setPriority", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class PriorityParentData {
    private int priority;

    public PriorityParentData() {
        this(0, 1, null);
    }

    public static /* synthetic */ PriorityParentData copy$default(PriorityParentData priorityParentData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = priorityParentData.priority;
        }
        return priorityParentData.copy(i);
    }

    public final int component1() {
        return this.priority;
    }

    public final PriorityParentData copy(int i) {
        return new PriorityParentData(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PriorityParentData) && this.priority == ((PriorityParentData) obj).priority;
    }

    public int hashCode() {
        return this.priority;
    }

    public String toString() {
        return "PriorityParentData(priority=" + this.priority + ")";
    }

    public PriorityParentData(int priority) {
        this.priority = priority;
    }

    public /* synthetic */ PriorityParentData(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }
}