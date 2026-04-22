package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatMediaSelectBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ChatMediaSelectBottomSheetKt$ChatMediaSelectBottomSheet$5$3$1 implements MeasurePolicy {
    final /* synthetic */ ChatMediaSelectBottomSheetState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatMediaSelectBottomSheetKt$ChatMediaSelectBottomSheet$5$3$1(ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState) {
        this.$state = chatMediaSelectBottomSheetState;
    }

    public /* bridge */ int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> list, int width) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, $this$maxIntrinsicHeight, list, width);
    }

    public /* bridge */ int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
        return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, $this$maxIntrinsicWidth, list, height);
    }

    public /* bridge */ int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> list, int width) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, $this$minIntrinsicHeight, list, width);
    }

    public /* bridge */ int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, $this$minIntrinsicWidth, list, height);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1928measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j2) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        final Placeable scrimPlaceable = list.get(0).measure-BRTryo0(j2);
        final int offsetPx = (int) this.$state.getAnchoredDraggableState$ui_debug().getOffset();
        long contentConstraints = Constraints.copy-Zbe2FdA$default(j2, 0, 0, 0, RangesKt.coerceAtLeast(Constraints.getMaxHeight-impl(j2) - offsetPx, 0), 7, (Object) null);
        final Placeable contentPlaceable = list.get(1).measure-BRTryo0(contentConstraints);
        return MeasureScope.-CC.layout$default($this$Layout, Constraints.getMaxWidth-impl(j2), Constraints.getMaxHeight-impl(j2), (Map) null, new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$ChatMediaSelectBottomSheet$5$3$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = ChatMediaSelectBottomSheetKt$ChatMediaSelectBottomSheet$5$3$1.measure_3p2s80s$lambda$0(scrimPlaceable, contentPlaceable, offsetPx, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable $scrimPlaceable, Placeable $contentPlaceable, int $offsetPx, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default($this$layout, $scrimPlaceable, 0, 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default($this$layout, $contentPlaceable, 0, $offsetPx, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }
}