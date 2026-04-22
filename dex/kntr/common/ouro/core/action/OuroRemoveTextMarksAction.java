package kntr.common.ouro.core.action;

import java.util.Collection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextMarkAction.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB)\b\u0016\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\t\"\u00020\u0004¢\u0006\u0004\b\u0007\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/action/OuroRemoveTextMarksAction;", "Lkntr/common/ouro/core/action/OuroTextMarkAction;", "marks", "", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "<init>", "(Ljava/util/Collection;Lkntr/common/ouro/core/model/OuroSelection;)V", "", "(Lkntr/common/ouro/core/model/OuroSelection;[Lkntr/common/ouro/core/model/mark/OuroTextMark;)V", "mark", "(Lkntr/common/ouro/core/model/mark/OuroTextMark;Lkntr/common/ouro/core/model/OuroSelection;)V", "getMarks", "()Ljava/util/Collection;", "getSelection", "()Lkntr/common/ouro/core/model/OuroSelection;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroRemoveTextMarksAction implements OuroTextMarkAction {
    private final Collection<OuroTextMark> marks;
    private final OuroSelection selection;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroRemoveTextMarksAction copy$default(OuroRemoveTextMarksAction ouroRemoveTextMarksAction, Collection collection, OuroSelection ouroSelection, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = ouroRemoveTextMarksAction.marks;
        }
        if ((i & 2) != 0) {
            ouroSelection = ouroRemoveTextMarksAction.selection;
        }
        return ouroRemoveTextMarksAction.copy(collection, ouroSelection);
    }

    public final Collection<OuroTextMark> component1() {
        return this.marks;
    }

    public final OuroSelection component2() {
        return this.selection;
    }

    public final OuroRemoveTextMarksAction copy(Collection<? extends OuroTextMark> collection, OuroSelection ouroSelection) {
        Intrinsics.checkNotNullParameter(collection, "marks");
        return new OuroRemoveTextMarksAction(collection, ouroSelection);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroRemoveTextMarksAction) {
            OuroRemoveTextMarksAction ouroRemoveTextMarksAction = (OuroRemoveTextMarksAction) obj;
            return Intrinsics.areEqual(this.marks, ouroRemoveTextMarksAction.marks) && Intrinsics.areEqual(this.selection, ouroRemoveTextMarksAction.selection);
        }
        return false;
    }

    public int hashCode() {
        return (this.marks.hashCode() * 31) + (this.selection == null ? 0 : this.selection.hashCode());
    }

    public String toString() {
        Collection<OuroTextMark> collection = this.marks;
        return "OuroRemoveTextMarksAction(marks=" + collection + ", selection=" + this.selection + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroRemoveTextMarksAction(Collection<? extends OuroTextMark> collection, OuroSelection selection) {
        Intrinsics.checkNotNullParameter(collection, "marks");
        this.marks = collection;
        this.selection = selection;
    }

    public /* synthetic */ OuroRemoveTextMarksAction(Collection collection, OuroSelection ouroSelection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, (i & 2) != 0 ? null : ouroSelection);
    }

    public final Collection<OuroTextMark> getMarks() {
        return this.marks;
    }

    public final OuroSelection getSelection() {
        return this.selection;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroRemoveTextMarksAction(OuroSelection selection, OuroTextMark... marks) {
        this(ArraysKt.toList(marks), selection);
        Intrinsics.checkNotNullParameter(marks, "marks");
    }

    public /* synthetic */ OuroRemoveTextMarksAction(OuroSelection ouroSelection, OuroTextMark[] ouroTextMarkArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ouroSelection, ouroTextMarkArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroRemoveTextMarksAction(OuroTextMark mark, OuroSelection selection) {
        this(CollectionsKt.listOf(mark), selection);
        Intrinsics.checkNotNullParameter(mark, "mark");
    }

    public /* synthetic */ OuroRemoveTextMarksAction(OuroTextMark ouroTextMark, OuroSelection ouroSelection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroTextMark, (i & 2) != 0 ? null : ouroSelection);
    }
}