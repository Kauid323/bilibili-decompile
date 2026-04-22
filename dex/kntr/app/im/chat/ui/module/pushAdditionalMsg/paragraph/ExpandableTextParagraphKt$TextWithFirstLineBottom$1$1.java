package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpandableTextParagraph.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ExpandableTextParagraphKt$TextWithFirstLineBottom$1$1 implements MeasurePolicy {
    final /* synthetic */ int $firstLineBottom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandableTextParagraphKt$TextWithFirstLineBottom$1$1(int i) {
        this.$firstLineBottom = i;
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
    public final MeasureResult m1839measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j2) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list);
        final Placeable placeable = measurable != null ? measurable.measure-BRTryo0(j2) : null;
        int width = placeable != null ? placeable.getWidth() : 0;
        int height = placeable != null ? placeable.getHeight() : 0;
        int i = this.$firstLineBottom;
        Map $this$measure_3p2s80s_u24lambda_u240 = MapsKt.createMapBuilder();
        if (placeable != null) {
            int first = placeable.get(AlignmentLineKt.getFirstBaseline());
            int last = placeable.get(AlignmentLineKt.getLastBaseline());
            if (first != Integer.MIN_VALUE) {
                $this$measure_3p2s80s_u24lambda_u240.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(first));
            }
            if (last != Integer.MIN_VALUE) {
                $this$measure_3p2s80s_u24lambda_u240.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(last));
            }
        }
        $this$measure_3p2s80s_u24lambda_u240.put(ExpandableTextParagraphKt.getFirstLineBottom(), Integer.valueOf(i));
        Unit unit = Unit.INSTANCE;
        return $this$Layout.layout(width, height, MapsKt.build($this$measure_3p2s80s_u24lambda_u240), new Function1() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphKt$TextWithFirstLineBottom$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = ExpandableTextParagraphKt$TextWithFirstLineBottom$1$1.measure_3p2s80s$lambda$1(placeable, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable $placeable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        if ($placeable != null) {
            Placeable.PlacementScope.place$default($this$layout, $placeable, 0, 0, 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}