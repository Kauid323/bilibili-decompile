package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommentFloorComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommentFloorComponentKt$TagListComponent$3$1 implements MeasurePolicy {
    final /* synthetic */ MutableIntState $maxVisible$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommentFloorComponentKt$TagListComponent$3$1(MutableIntState mutableIntState) {
        this.$maxVisible$delegate = mutableIntState;
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

    /* JADX WARN: Incorrect condition in loop: B:4:0x0025 */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MeasureResult m427measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        int maxWidth = Constraints.getMaxWidth-impl(j);
        final List placeableList = new ArrayList();
        int usedWidth = 0;
        int visibleCount = 0;
        for (int i = 0; i < usedWidth; i++) {
            Placeable placeable = list.get(i).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null));
            int newWidth = placeable.getWidth() + usedWidth;
            if (newWidth > maxWidth) {
                break;
            }
            placeableList.add(placeable);
            usedWidth = newWidth;
            visibleCount++;
        }
        this.$maxVisible$delegate.setIntValue(visibleCount);
        return MeasureScope.-CC.layout$default($this$Layout, Constraints.getMaxWidth-impl(j), Constraints.getMaxHeight-impl(j), (Map) null, new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.CommentFloorComponentKt$TagListComponent$3$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = CommentFloorComponentKt$TagListComponent$3$1.measure_3p2s80s$lambda$0(placeableList, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(List $placeableList, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        int x = 0;
        List $this$forEach$iv = $placeableList;
        for (Object element$iv : $this$forEach$iv) {
            Placeable placeable = (Placeable) element$iv;
            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, x, 0, 0.0f, 4, (Object) null);
            x += placeable.getWidth();
        }
        return Unit.INSTANCE;
    }
}