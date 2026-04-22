package kntr.app.im.chat.ui.module.pushAdditionalMsg;

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
import kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushAdditionalMsgModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1 implements MeasurePolicy {
    public static final PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1 INSTANCE = new PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1();

    PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1() {
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
    public final MeasureResult m1826measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j2) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        final Placeable placeable = ((Measurable) CollectionsKt.first(list)).measure-BRTryo0(j2);
        int width = placeable.getWidth();
        int height = placeable.getHeight();
        Map $this$measure_3p2s80s_u24lambda_u240 = MapsKt.createMapBuilder();
        int first = placeable.get(AlignmentLineKt.getFirstBaseline());
        int last = placeable.get(AlignmentLineKt.getLastBaseline());
        int lineBottom = placeable.get(ExpandableTextParagraphKt.getFirstLineBottom());
        if (first != Integer.MIN_VALUE) {
            $this$measure_3p2s80s_u24lambda_u240.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(first));
        }
        if (last != Integer.MIN_VALUE) {
            $this$measure_3p2s80s_u24lambda_u240.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(last));
        }
        if (lineBottom != Integer.MIN_VALUE) {
            $this$measure_3p2s80s_u24lambda_u240.put(ExpandableTextParagraphKt.getFirstLineBottom(), Integer.valueOf(lineBottom));
        }
        Unit unit = Unit.INSTANCE;
        return $this$Layout.layout(width, height, MapsKt.build($this$measure_3p2s80s_u24lambda_u240), new Function1() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1.measure_3p2s80s$lambda$1(placeable, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable $placeable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }
}