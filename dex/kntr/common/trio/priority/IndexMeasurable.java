package kntr.common.trio.priority;

import androidx.compose.ui.layout.Measurable;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposePriorityHorizon.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/trio/priority/IndexMeasurable;", "", "index", "", "measurable", "Landroidx/compose/ui/layout/Measurable;", "<init>", "(ILandroidx/compose/ui/layout/Measurable;)V", "getIndex", "()I", "getMeasurable", "()Landroidx/compose/ui/layout/Measurable;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IndexMeasurable {
    private final int index;
    private final Measurable measurable;

    public static /* synthetic */ IndexMeasurable copy$default(IndexMeasurable indexMeasurable, int i, Measurable measurable, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = indexMeasurable.index;
        }
        if ((i2 & 2) != 0) {
            measurable = indexMeasurable.measurable;
        }
        return indexMeasurable.copy(i, measurable);
    }

    public final int component1() {
        return this.index;
    }

    public final Measurable component2() {
        return this.measurable;
    }

    public final IndexMeasurable copy(int i, Measurable measurable) {
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return new IndexMeasurable(i, measurable);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexMeasurable) {
            IndexMeasurable indexMeasurable = (IndexMeasurable) obj;
            return this.index == indexMeasurable.index && Intrinsics.areEqual(this.measurable, indexMeasurable.measurable);
        }
        return false;
    }

    public int hashCode() {
        return (this.index * 31) + this.measurable.hashCode();
    }

    public String toString() {
        int i = this.index;
        return "IndexMeasurable(index=" + i + ", measurable=" + this.measurable + ")";
    }

    public IndexMeasurable(int index, Measurable measurable) {
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        this.index = index;
        this.measurable = measurable;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Measurable getMeasurable() {
        return this.measurable;
    }
}