package kntr.base.imageloader;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliImageKt$InnerImage$6$1 implements MeasurePolicy {
    final /* synthetic */ Function1<IntSize, Unit> $onSizeChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliImageKt$InnerImage$6$1(Function1<? super IntSize, Unit> function1) {
        this.$onSizeChange = function1;
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
    public final MeasureResult m1430measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "content");
        List<? extends Measurable> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Measurable it = (Measurable) item$iv$iv;
            destination$iv$iv.add(it.measure-BRTryo0(j));
        }
        final List placeable = (List) destination$iv$iv;
        if (Constraints.getHasBoundedWidth-impl(j) && Constraints.getHasBoundedHeight-impl(j)) {
            Function1<IntSize, Unit> function1 = this.$onSizeChange;
            int width$iv = Constraints.getMaxWidth-impl(j);
            int height$iv = Constraints.getMaxHeight-impl(j);
            function1.invoke(IntSize.box-impl(IntSize.constructor-impl((height$iv & 4294967295L) | (width$iv << 32))));
        }
        return MeasureScope.-CC.layout$default($this$Layout, Constraints.getMinWidth-impl(j), Constraints.getMinHeight-impl(j), (Map) null, new Function1() { // from class: kntr.base.imageloader.BiliImageKt$InnerImage$6$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = BiliImageKt$InnerImage$6$1.measure_3p2s80s$lambda$1(placeable, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(List $placeable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEach$iv = $placeable;
        for (Object element$iv : $this$forEach$iv) {
            Placeable it = (Placeable) element$iv;
            Placeable.PlacementScope.place$default($this$layout, it, 0, 0, 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}