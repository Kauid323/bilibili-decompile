package kntr.compose.avatar.state;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
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
import kotlin.math.MathKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerState.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerState$Content$1$4$1 implements MeasurePolicy {
    final /* synthetic */ LayerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayerState$Content$1$4$1(LayerState layerState) {
        this.this$0 = layerState;
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
    public final MeasureResult m2564measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        List<? extends Measurable> $this$map$iv = list;
        LayerState layerState = this.this$0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Measurable it = (Measurable) item$iv$iv;
            Constraints.Companion companion = Constraints.Companion;
            Iterable $this$map$iv2 = $this$map$iv;
            int bits$iv$iv$iv = (int) (layerState.getDrawPosition().getSize-NH-jbRc() >> 32);
            int roundToInt = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv));
            int bits$iv$iv$iv2 = (int) (layerState.getDrawPosition().getSize-NH-jbRc() & 4294967295L);
            destination$iv$iv.add(it.measure-BRTryo0(companion.fixed-JhjzzOo(roundToInt, MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv2)))));
            layerState = layerState;
            $this$map$iv = $this$map$iv2;
        }
        final List placables = (List) destination$iv$iv;
        int bits$iv$iv$iv3 = (int) (this.this$0.getDrawPosition().getSize-NH-jbRc() >> 32);
        int roundToInt2 = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv3));
        int bits$iv$iv$iv4 = (int) (4294967295L & this.this$0.getDrawPosition().getSize-NH-jbRc());
        int roundToInt3 = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv4));
        final LayerState layerState2 = this.this$0;
        return MeasureScope.-CC.layout$default($this$Layout, roundToInt2, roundToInt3, (Map) null, new Function1() { // from class: kntr.compose.avatar.state.LayerState$Content$1$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = LayerState$Content$1$4$1.measure_3p2s80s$lambda$1(placables, layerState2, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(List $placables, LayerState this$0, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEach$iv = $placables;
        for (Object element$iv : $this$forEach$iv) {
            Placeable it = (Placeable) element$iv;
            Placeable.PlacementScope.place$default($this$layout, it, MathKt.roundToInt(this$0.getDrawPosition().getLeft()), MathKt.roundToInt(this$0.getDrawPosition().getTop()), 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}