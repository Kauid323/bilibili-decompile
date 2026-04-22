package kntr.app.upcomingEpisode.list.utils;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.PointerInputModifierNode;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DraggableSheet.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\fH\u0016J\u0012\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00105\u001a\u00020\fH\u0002JV\u00106\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lkntr/app/upcomingEpisode/list/utils/DraggableSheetNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "isEnabled", "", "currentHeightPx", "", "minHeightPx", "maxHeightPx", "thresholdPx", "onHeightChange", "Lkotlin/Function1;", "", "onCalendarTypeChange", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "<init>", "(ZFFFFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "()Z", "setEnabled", "(Z)V", "getCurrentHeightPx", "()F", "setCurrentHeightPx", "(F)V", "getMinHeightPx", "setMinHeightPx", "getMaxHeightPx", "setMaxHeightPx", "getThresholdPx", "setThresholdPx", "getOnHeightChange", "()Lkotlin/jvm/functions/Function1;", "setOnHeightChange", "(Lkotlin/jvm/functions/Function1;)V", "getOnCalendarTypeChange", "setOnCalendarTypeChange", "dragOffset", "dragStartHeightPx", "isDragging", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "handlePress", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "handleMove", "handleRelease", "update", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DraggableSheetNode extends Modifier.Node implements PointerInputModifierNode {
    public static final int $stable = 8;
    private float currentHeightPx;
    private float dragOffset;
    private float dragStartHeightPx;
    private boolean isDragging;
    private boolean isEnabled;
    private float maxHeightPx;
    private float minHeightPx;
    private Function1<? super CalendarType, Unit> onCalendarTypeChange;
    private Function1<? super Float, Unit> onHeightChange;
    private float thresholdPx;

    public DraggableSheetNode(boolean isEnabled, float currentHeightPx, float minHeightPx, float maxHeightPx, float thresholdPx, Function1<? super Float, Unit> function1, Function1<? super CalendarType, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onHeightChange");
        Intrinsics.checkNotNullParameter(function12, "onCalendarTypeChange");
        this.isEnabled = isEnabled;
        this.currentHeightPx = currentHeightPx;
        this.minHeightPx = minHeightPx;
        this.maxHeightPx = maxHeightPx;
        this.thresholdPx = thresholdPx;
        this.onHeightChange = function1;
        this.onCalendarTypeChange = function12;
        this.dragStartHeightPx = this.currentHeightPx;
    }

    /* renamed from: getTouchBoundsExpansion-RZrCHBk  reason: not valid java name */
    public /* bridge */ long m1307getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public /* bridge */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public /* bridge */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    public /* bridge */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public /* bridge */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final float getCurrentHeightPx() {
        return this.currentHeightPx;
    }

    public final void setCurrentHeightPx(float f) {
        this.currentHeightPx = f;
    }

    public final float getMinHeightPx() {
        return this.minHeightPx;
    }

    public final void setMinHeightPx(float f) {
        this.minHeightPx = f;
    }

    public final float getMaxHeightPx() {
        return this.maxHeightPx;
    }

    public final void setMaxHeightPx(float f) {
        this.maxHeightPx = f;
    }

    public final float getThresholdPx() {
        return this.thresholdPx;
    }

    public final void setThresholdPx(float f) {
        this.thresholdPx = f;
    }

    public final Function1<Float, Unit> getOnHeightChange() {
        return this.onHeightChange;
    }

    public final void setOnHeightChange(Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onHeightChange = function1;
    }

    public final Function1<CalendarType, Unit> getOnCalendarTypeChange() {
        return this.onCalendarTypeChange;
    }

    public final void setOnCalendarTypeChange(Function1<? super CalendarType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onCalendarTypeChange = function1;
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m1308onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        if (this.isEnabled && pass == PointerEventPass.Main) {
            int i = pointerEvent.getType-7fucELk();
            if (!PointerEventType.equals-impl0(i, PointerEventType.Companion.getPress-7fucELk())) {
                if (PointerEventType.equals-impl0(i, PointerEventType.Companion.getMove-7fucELk())) {
                    if (this.isDragging) {
                        handleMove((PointerInputChange) CollectionsKt.firstOrNull(pointerEvent.getChanges()));
                        return;
                    }
                    return;
                } else if (!PointerEventType.equals-impl0(i, PointerEventType.Companion.getRelease-7fucELk()) || !this.isDragging) {
                    return;
                } else {
                    handleRelease();
                    return;
                }
            }
            handlePress((PointerInputChange) CollectionsKt.firstOrNull(pointerEvent.getChanges()));
        }
    }

    public void onCancelPointerInput() {
        if (this.isDragging) {
            this.onHeightChange.invoke(Float.valueOf(this.dragStartHeightPx));
            KLog_androidKt.getKLog().i("DraggableSheetNode", "onCancelPointerInput, RESET to " + this.dragStartHeightPx);
            this.dragOffset = 0.0f;
            this.isDragging = false;
        }
    }

    private final void handlePress(PointerInputChange change) {
        if (change != null) {
            this.isDragging = true;
            this.dragOffset = 0.0f;
            this.dragStartHeightPx = this.currentHeightPx;
            KLog_androidKt.getKLog().i("DraggableSheetNode", "onDragStart, dragStartHeightPx: " + this.dragStartHeightPx);
            change.consume();
        }
    }

    private final void handleMove(PointerInputChange change) {
        if (this.isDragging && change != null) {
            PointerInputChange it = change.getPressed() ? change : null;
            if (it == null) {
                return;
            }
            int bits$iv$iv$iv = (int) (4294967295L & PointerEventKt.positionChange(it));
            float verticalChange = Float.intBitsToFloat(bits$iv$iv$iv);
            this.dragOffset += verticalChange;
            float newHeight = RangesKt.coerceIn(this.currentHeightPx - verticalChange, this.minHeightPx, this.maxHeightPx);
            this.onHeightChange.invoke(Float.valueOf(newHeight));
            KLog_androidKt.getKLog().i("DraggableSheetNode", "onDrag, newHeight: " + newHeight);
            it.consume();
        }
    }

    private final void handleRelease() {
        if (this.isDragging) {
            if (this.dragOffset > this.thresholdPx) {
                this.onCalendarTypeChange.invoke(CalendarType.MONTH);
                this.onHeightChange.invoke(Float.valueOf(this.minHeightPx));
                KLog_androidKt.getKLog().i("DraggableSheetNode", "onDragEnd MIN, minHeightPx: " + this.minHeightPx);
            } else if (this.dragOffset < (-this.thresholdPx)) {
                this.onCalendarTypeChange.invoke(CalendarType.WEEK);
                this.onHeightChange.invoke(Float.valueOf(this.maxHeightPx));
                KLog_androidKt.getKLog().i("DraggableSheetNode", "onDragEnd MAX, maxHeightPx: " + this.maxHeightPx);
            } else {
                this.onHeightChange.invoke(Float.valueOf(this.dragStartHeightPx));
                KLog_androidKt.getKLog().i("DraggableSheetNode", "onDragEnd RESET, dragStartHeightPx: " + this.dragStartHeightPx);
            }
            this.dragOffset = 0.0f;
            this.isDragging = false;
        }
    }

    public final void update(boolean isEnabled, float currentHeightPx, float minHeightPx, float maxHeightPx, float thresholdPx, Function1<? super Float, Unit> function1, Function1<? super CalendarType, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onHeightChange");
        Intrinsics.checkNotNullParameter(function12, "onCalendarTypeChange");
        this.isEnabled = isEnabled;
        this.currentHeightPx = currentHeightPx;
        this.minHeightPx = minHeightPx;
        this.maxHeightPx = maxHeightPx;
        this.thresholdPx = thresholdPx;
        this.onHeightChange = function1;
        this.onCalendarTypeChange = function12;
        float clampedHeight = RangesKt.coerceIn(currentHeightPx, minHeightPx, maxHeightPx);
        if (!(currentHeightPx == clampedHeight)) {
            function1.invoke(Float.valueOf(clampedHeight));
        }
    }
}