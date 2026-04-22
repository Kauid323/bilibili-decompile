package kntr.common.share.common.ui.poster;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
import kotlin.jvm.internal.Ref;

/* compiled from: SharePosterView.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class SharePosterViewKt$DanmuSection$2$1 implements MeasurePolicy {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $firstRowStartMargin;
    final /* synthetic */ int $iconSpacing;
    final /* synthetic */ int $rowHeight;
    final /* synthetic */ int $secondRowStartMargin;
    final /* synthetic */ int $spacerWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharePosterViewKt$DanmuSection$2$1(int i, int i2, int i3, Density density, int i4, int i5) {
        this.$firstRowStartMargin = i;
        this.$iconSpacing = i2;
        this.$spacerWidth = i3;
        this.$density = density;
        this.$rowHeight = i4;
        this.$secondRowStartMargin = i5;
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
    public final MeasureResult m2406measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        List<? extends Measurable> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Measurable it = (Measurable) item$iv$iv;
            destination$iv$iv.add(it.measure-BRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null)));
        }
        List placeables = (List) destination$iv$iv;
        final Placeable iconPlaceable = (Placeable) placeables.get(0);
        final List textPlaceables = CollectionsKt.drop(placeables, 1);
        int firstRowWidth = this.$firstRowStartMargin + iconPlaceable.getWidth() + this.$iconSpacing;
        final Ref.IntRef firstRowTextEndIndex = new Ref.IntRef();
        int i = 0;
        int size = textPlaceables.size();
        int firstRowWidth2 = firstRowWidth;
        while (true) {
            if (i >= size) {
                break;
            }
            int nextWidth = firstRowWidth2 + ((Placeable) textPlaceables.get(i)).getWidth() + (i > 0 ? this.$spacerWidth : 0);
            if (nextWidth <= Constraints.getMaxWidth-impl(j)) {
                firstRowWidth2 = nextWidth;
                firstRowTextEndIndex.element = i + 1;
                i++;
            } else {
                firstRowTextEndIndex.element = i + 1;
                break;
            }
        }
        int nextWidth2 = Constraints.getMaxWidth-impl(j);
        Density $this$measure_3p2s80s_u24lambda_u241 = this.$density;
        int i2 = (int) $this$measure_3p2s80s_u24lambda_u241.toPx-0680j_4(Dp.constructor-impl(56));
        final int i3 = this.$firstRowStartMargin;
        final int i4 = this.$rowHeight;
        final int i5 = this.$iconSpacing;
        final int i6 = this.$spacerWidth;
        final int i7 = this.$secondRowStartMargin;
        return MeasureScope.-CC.layout$default($this$Layout, nextWidth2, i2, (Map) null, new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$DanmuSection$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$2;
                measure_3p2s80s$lambda$2 = SharePosterViewKt$DanmuSection$2$1.measure_3p2s80s$lambda$2(iconPlaceable, i3, i4, i5, firstRowTextEndIndex, textPlaceables, i6, i7, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$2;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(Placeable $iconPlaceable, int $firstRowStartMargin, int $rowHeight, int $iconSpacing, Ref.IntRef $firstRowTextEndIndex, List $textPlaceables, int $spacerWidth, int $secondRowStartMargin, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default($this$layout, $iconPlaceable, $firstRowStartMargin, ($rowHeight - $iconPlaceable.getHeight()) / 2, 0.0f, 4, (Object) null);
        int xPosition = $iconPlaceable.getWidth() + $firstRowStartMargin + $iconSpacing;
        int i = $firstRowTextEndIndex.element;
        for (int i2 = 0; i2 < i; i2++) {
            Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) $textPlaceables.get(i2), xPosition, ($rowHeight - ((Placeable) $textPlaceables.get(i2)).getHeight()) / 2, 0.0f, 4, (Object) null);
            xPosition += ((Placeable) $textPlaceables.get(i2)).getWidth() + $spacerWidth;
        }
        if ($firstRowTextEndIndex.element < $textPlaceables.size()) {
            int xPosition2 = $secondRowStartMargin;
            int i3 = $firstRowTextEndIndex.element;
            int size = $textPlaceables.size();
            for (int i4 = i3; i4 < size; i4++) {
                Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) $textPlaceables.get(i4), xPosition2, $rowHeight + (($rowHeight - ((Placeable) $textPlaceables.get(i4)).getHeight()) / 2), 0.0f, 4, (Object) null);
                xPosition2 += ((Placeable) $textPlaceables.get(i4)).getWidth() + $spacerWidth;
            }
        }
        return Unit.INSTANCE;
    }
}