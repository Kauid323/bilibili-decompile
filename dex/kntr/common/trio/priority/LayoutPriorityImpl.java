package kntr.common.trio.priority;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposePriorityHorizon.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B(\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/common/trio/priority/LayoutPriorityImpl;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/layout/ParentDataModifier;", "priority", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getPriority", "()I", "modifyParentData", "Lkntr/common/trio/priority/PriorityParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "equals", "", "other", "hashCode", "toString", "", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class LayoutPriorityImpl extends InspectorValueInfo implements ParentDataModifier {
    private final int priority;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutPriorityImpl(int priority, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.priority = priority;
    }

    public /* bridge */ boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.-CC.$default$all(this, function1);
    }

    public /* bridge */ boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.-CC.$default$any(this, function1);
    }

    public /* bridge */ <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return (R) Modifier.Element.-CC.$default$foldIn(this, r, function2);
    }

    public /* bridge */ <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return (R) Modifier.Element.-CC.$default$foldOut(this, r, function2);
    }

    public /* bridge */ Modifier then(Modifier other) {
        return Modifier.-CC.$default$then(this, other);
    }

    public final int getPriority() {
        return this.priority;
    }

    public PriorityParentData modifyParentData(Density $this$modifyParentData, Object parentData) {
        Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
        PriorityParentData priorityParentData = parentData instanceof PriorityParentData ? (PriorityParentData) parentData : null;
        if (priorityParentData == null) {
            priorityParentData = new PriorityParentData(0, 1, null);
        }
        PriorityParentData it = priorityParentData;
        it.setPriority(this.priority);
        return priorityParentData;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        LayoutPriorityImpl otherModifier = other instanceof LayoutPriorityImpl ? (LayoutPriorityImpl) other : null;
        return otherModifier != null && this.priority == otherModifier.priority;
    }

    public int hashCode() {
        return this.priority;
    }

    public String toString() {
        return "LayoutPriorityImpl(priority=" + this.priority + ")";
    }
}