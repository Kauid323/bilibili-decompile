package kntr.app.upcomingEpisode.list.utils;

import BottomSheetItemData$;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DraggableSheet.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\f\u0010\u001d\u001a\u00020\f*\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003Jg\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006."}, d2 = {"Lkntr/app/upcomingEpisode/list/utils/DraggableSheetNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lkntr/app/upcomingEpisode/list/utils/DraggableSheetNode;", "isEnabled", "", "currentHeightPx", "", "minHeightPx", "maxHeightPx", "thresholdPx", "onHeightChange", "Lkotlin/Function1;", "", "onCalendarTypeChange", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "<init>", "(ZFFFFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "()Z", "getCurrentHeightPx", "()F", "getMinHeightPx", "getMaxHeightPx", "getThresholdPx", "getOnHeightChange", "()Lkotlin/jvm/functions/Function1;", "getOnCalendarTypeChange", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DraggableSheetNodeElement extends ModifierNodeElement<DraggableSheetNode> {
    public static final int $stable = 0;
    private final float currentHeightPx;
    private final boolean isEnabled;
    private final float maxHeightPx;
    private final float minHeightPx;
    private final Function1<CalendarType, Unit> onCalendarTypeChange;
    private final Function1<Float, Unit> onHeightChange;
    private final float thresholdPx;

    public static /* synthetic */ DraggableSheetNodeElement copy$default(DraggableSheetNodeElement draggableSheetNodeElement, boolean z, float f, float f2, float f3, float f4, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            z = draggableSheetNodeElement.isEnabled;
        }
        if ((i & 2) != 0) {
            f = draggableSheetNodeElement.currentHeightPx;
        }
        float f5 = f;
        if ((i & 4) != 0) {
            f2 = draggableSheetNodeElement.minHeightPx;
        }
        float f6 = f2;
        if ((i & 8) != 0) {
            f3 = draggableSheetNodeElement.maxHeightPx;
        }
        float f7 = f3;
        if ((i & 16) != 0) {
            f4 = draggableSheetNodeElement.thresholdPx;
        }
        float f8 = f4;
        Function1<Float, Unit> function13 = function1;
        if ((i & 32) != 0) {
            function13 = draggableSheetNodeElement.onHeightChange;
        }
        Function1 function14 = function13;
        Function1<CalendarType, Unit> function15 = function12;
        if ((i & 64) != 0) {
            function15 = draggableSheetNodeElement.onCalendarTypeChange;
        }
        return draggableSheetNodeElement.copy(z, f5, f6, f7, f8, function14, function15);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    public final float component2() {
        return this.currentHeightPx;
    }

    public final float component3() {
        return this.minHeightPx;
    }

    public final float component4() {
        return this.maxHeightPx;
    }

    public final float component5() {
        return this.thresholdPx;
    }

    public final Function1<Float, Unit> component6() {
        return this.onHeightChange;
    }

    public final Function1<CalendarType, Unit> component7() {
        return this.onCalendarTypeChange;
    }

    public final DraggableSheetNodeElement copy(boolean z, float f, float f2, float f3, float f4, Function1<? super Float, Unit> function1, Function1<? super CalendarType, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onHeightChange");
        Intrinsics.checkNotNullParameter(function12, "onCalendarTypeChange");
        return new DraggableSheetNodeElement(z, f, f2, f3, f4, function1, function12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DraggableSheetNodeElement) {
            DraggableSheetNodeElement draggableSheetNodeElement = (DraggableSheetNodeElement) obj;
            return this.isEnabled == draggableSheetNodeElement.isEnabled && Float.compare(this.currentHeightPx, draggableSheetNodeElement.currentHeightPx) == 0 && Float.compare(this.minHeightPx, draggableSheetNodeElement.minHeightPx) == 0 && Float.compare(this.maxHeightPx, draggableSheetNodeElement.maxHeightPx) == 0 && Float.compare(this.thresholdPx, draggableSheetNodeElement.thresholdPx) == 0 && Intrinsics.areEqual(this.onHeightChange, draggableSheetNodeElement.onHeightChange) && Intrinsics.areEqual(this.onCalendarTypeChange, draggableSheetNodeElement.onCalendarTypeChange);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isEnabled) * 31) + Float.floatToIntBits(this.currentHeightPx)) * 31) + Float.floatToIntBits(this.minHeightPx)) * 31) + Float.floatToIntBits(this.maxHeightPx)) * 31) + Float.floatToIntBits(this.thresholdPx)) * 31) + this.onHeightChange.hashCode()) * 31) + this.onCalendarTypeChange.hashCode();
    }

    public String toString() {
        boolean z = this.isEnabled;
        float f = this.currentHeightPx;
        float f2 = this.minHeightPx;
        float f3 = this.maxHeightPx;
        float f4 = this.thresholdPx;
        Function1<Float, Unit> function1 = this.onHeightChange;
        return "DraggableSheetNodeElement(isEnabled=" + z + ", currentHeightPx=" + f + ", minHeightPx=" + f2 + ", maxHeightPx=" + f3 + ", thresholdPx=" + f4 + ", onHeightChange=" + function1 + ", onCalendarTypeChange=" + this.onCalendarTypeChange + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DraggableSheetNodeElement(boolean isEnabled, float currentHeightPx, float minHeightPx, float maxHeightPx, float thresholdPx, Function1<? super Float, Unit> function1, Function1<? super CalendarType, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onHeightChange");
        Intrinsics.checkNotNullParameter(function12, "onCalendarTypeChange");
        this.isEnabled = isEnabled;
        this.currentHeightPx = currentHeightPx;
        this.minHeightPx = minHeightPx;
        this.maxHeightPx = maxHeightPx;
        this.thresholdPx = thresholdPx;
        this.onHeightChange = function1;
        this.onCalendarTypeChange = function12;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final float getCurrentHeightPx() {
        return this.currentHeightPx;
    }

    public final float getMinHeightPx() {
        return this.minHeightPx;
    }

    public final float getMaxHeightPx() {
        return this.maxHeightPx;
    }

    public final float getThresholdPx() {
        return this.thresholdPx;
    }

    public final Function1<Float, Unit> getOnHeightChange() {
        return this.onHeightChange;
    }

    public final Function1<CalendarType, Unit> getOnCalendarTypeChange() {
        return this.onCalendarTypeChange;
    }

    public DraggableSheetNode create() {
        return new DraggableSheetNode(this.isEnabled, this.currentHeightPx, this.minHeightPx, this.maxHeightPx, this.thresholdPx, this.onHeightChange, this.onCalendarTypeChange);
    }

    public void update(DraggableSheetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.update(this.isEnabled, this.currentHeightPx, this.minHeightPx, this.maxHeightPx, this.thresholdPx, this.onHeightChange, this.onCalendarTypeChange);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("draggableSheet");
        $this$inspectableProperties.getProperties().set("isEnabled", Boolean.valueOf(this.isEnabled));
        $this$inspectableProperties.getProperties().set("currentHeightPx", Float.valueOf(this.currentHeightPx));
        $this$inspectableProperties.getProperties().set("minHeightPx", Float.valueOf(this.minHeightPx));
        $this$inspectableProperties.getProperties().set("maxHeightPx", Float.valueOf(this.maxHeightPx));
        $this$inspectableProperties.getProperties().set("thresholdPx", Float.valueOf(this.thresholdPx));
    }
}