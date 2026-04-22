package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.im.chat.db.model.InlineContent;
import kntr.app.im.chat.db.model.InputBoxContent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichInputField.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class RichInputFieldKt$RichInputField$3$1$4$1$1$1$1 implements MeasurePolicy {
    final /* synthetic */ Density $density;
    final /* synthetic */ InputBoxContent $inputBoxContent;
    final /* synthetic */ TextLayoutResult $textLayoutResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RichInputFieldKt$RichInputField$3$1$4$1$1$1$1(InputBoxContent inputBoxContent, Density density, TextLayoutResult textLayoutResult) {
        this.$inputBoxContent = inputBoxContent;
        this.$density = density;
        this.$textLayoutResult = textLayoutResult;
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
    public final MeasureResult m1990measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j2) {
        Iterable $this$mapIndexed$iv;
        InputBoxContent inputBoxContent;
        Placeable placeable;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        List<? extends Measurable> $this$mapIndexed$iv2 = list;
        InputBoxContent inputBoxContent2 = this.$inputBoxContent;
        Density $this$measure_3p2s80s_u24lambda_u240_u240 = this.$density;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv2) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Measurable measurable = (Measurable) item$iv$iv;
            InlineContent inlineContent = (InlineContent) CollectionsKt.getOrNull(inputBoxContent2.getInlineContents(), index$iv$iv);
            if (inlineContent != null) {
                float $this$dp$iv = inlineContent.getSize().getWidth();
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                float f = Dp.constructor-impl($this$dp$iv);
                inputBoxContent = inputBoxContent2;
                int i = $this$measure_3p2s80s_u24lambda_u240_u240.roundToPx-0680j_4(f);
                float $this$dp$iv2 = inlineContent.getSize().getHeight();
                long constraint = ConstraintsKt.Constraints$default(0, i, 0, $this$measure_3p2s80s_u24lambda_u240_u240.roundToPx-0680j_4(Dp.constructor-impl($this$dp$iv2)), 5, (Object) null);
                placeable = measurable.measure-BRTryo0(constraint);
            } else {
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                inputBoxContent = inputBoxContent2;
                placeable = null;
            }
            destination$iv$iv.add(placeable);
            index$iv$iv = index$iv$iv2;
            inputBoxContent2 = inputBoxContent;
            $this$mapIndexed$iv2 = $this$mapIndexed$iv;
        }
        final List placeables = (List) destination$iv$iv;
        int i2 = Constraints.getMaxWidth-impl(j2);
        int i3 = Constraints.getMaxHeight-impl(j2);
        final InputBoxContent inputBoxContent3 = this.$inputBoxContent;
        final TextLayoutResult textLayoutResult = this.$textLayoutResult;
        return MeasureScope.-CC.layout$default($this$Layout, i2, i3, (Map) null, new Function1() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$RichInputField$3$1$4$1$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = RichInputFieldKt$RichInputField$3$1$4$1$1$1$1.measure_3p2s80s$lambda$1(placeables, inputBoxContent3, textLayoutResult, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(List $placeables, InputBoxContent $inputBoxContent, TextLayoutResult $textLayoutResult, Placeable.PlacementScope $this$layout) {
        TextLayoutResult textLayoutResult = $textLayoutResult;
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEachIndexed$iv = $placeables;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Placeable placeable = (Placeable) item$iv;
            int index = index$iv;
            try {
                InlineContent inlineContent = $inputBoxContent.getInlineContents().get(index);
                Rect it = textLayoutResult.getBoundingBox(inlineContent.getOffset());
                Pair box = TuplesKt.to(Offset.box-impl(it.getTopLeft-F1C5BW0()), Size.box-impl(it.getSize-NH-jbRc()));
                int lineNumber = textLayoutResult.getLineForOffset(inlineContent.getOffset());
                float lineBottom = textLayoutResult.getLineBottom(lineNumber);
                if (placeable != null) {
                    int bits$iv$iv$iv = (int) (((Offset) box.getFirst()).unbox-impl() >> 32);
                    try {
                        Placeable.PlacementScope.place$default($this$layout, placeable, MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv)), MathKt.roundToInt(lineBottom - placeable.getHeight()), 0.0f, 4, (Object) null);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
            textLayoutResult = $textLayoutResult;
            index$iv = index$iv2;
        }
        return Unit.INSTANCE;
    }
}