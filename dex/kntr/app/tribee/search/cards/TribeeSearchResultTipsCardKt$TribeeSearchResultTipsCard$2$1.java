package kntr.app.tribee.search.cards;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchTips;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchResultTipsCard.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1 implements MeasurePolicy {
    final /* synthetic */ KTribeeSearchTips $card;
    final /* synthetic */ TextMeasurer $textMeasurer;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1(TextMeasurer textMeasurer, KTribeeSearchTips kTribeeSearchTips, TextStyle textStyle) {
        this.$textMeasurer = textMeasurer;
        this.$card = kTribeeSearchTips;
        this.$textStyle = textStyle;
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
    public final MeasureResult m1067measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long j) {
        int i;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (list.size() == 1) {
            final Placeable placeable = list.get(0).measure-BRTryo0(j);
            return MeasureScope.-CC.layout$default($this$Layout, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit measure_3p2s80s$lambda$0;
                    measure_3p2s80s$lambda$0 = TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1.measure_3p2s80s$lambda$0(placeable, (Placeable.PlacementScope) obj);
                    return measure_3p2s80s$lambda$0;
                }
            }, 4, (Object) null);
        }
        final int spacing = $this$Layout.roundToPx-0680j_4(Dp.constructor-impl(4));
        final Placeable linkPlaceable = list.get(1).measure-BRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null));
        TextLayoutResult textLayoutResult = TextMeasurer.measure-wNUYSr0$default(this.$textMeasurer, this.$card.getTips(), this.$textStyle, 0, false, 0, j, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 988, (Object) null);
        int lastLineIndex = textLayoutResult.getLineCount() - 1;
        if (lastLineIndex >= 0) {
            i = (int) textLayoutResult.getLineRight(lastLineIndex);
        } else {
            i = 0;
        }
        final int lastLineWidth = i;
        boolean canFitOnLastLine = (lastLineWidth + spacing) + linkPlaceable.getWidth() <= Constraints.getMaxWidth-impl(j);
        final Placeable tipsPlaceable = list.get(0).measure-BRTryo0(j);
        if (canFitOnLastLine && textLayoutResult.getLineCount() > 0) {
            int totalWidth = Math.max(tipsPlaceable.getWidth(), lastLineWidth + spacing + linkPlaceable.getWidth());
            int totalHeight = tipsPlaceable.getHeight();
            int lastLineTop = (int) textLayoutResult.getLineTop(lastLineIndex);
            int lastLineBottom = (int) textLayoutResult.getLineBottom(lastLineIndex);
            final int linkY = lastLineTop + (((lastLineBottom - lastLineTop) - linkPlaceable.getHeight()) / 2);
            return MeasureScope.-CC.layout$default($this$Layout, totalWidth, totalHeight, (Map) null, new Function1() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit measure_3p2s80s$lambda$1;
                    measure_3p2s80s$lambda$1 = TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1.measure_3p2s80s$lambda$1(tipsPlaceable, linkPlaceable, lastLineWidth, spacing, linkY, (Placeable.PlacementScope) obj);
                    return measure_3p2s80s$lambda$1;
                }
            }, 4, (Object) null);
        }
        int totalWidth2 = Math.max(tipsPlaceable.getWidth(), linkPlaceable.getWidth());
        int totalHeight2 = tipsPlaceable.getHeight() + spacing + linkPlaceable.getHeight();
        return MeasureScope.-CC.layout$default($this$Layout, totalWidth2, totalHeight2, (Map) null, new Function1() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$2;
                measure_3p2s80s$lambda$2 = TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1.measure_3p2s80s$lambda$2(tipsPlaceable, linkPlaceable, spacing, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$2;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable $placeable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable $tipsPlaceable, Placeable $linkPlaceable, int $lastLineWidth, int $spacing, int $linkY, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $tipsPlaceable, 0, 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.place$default($this$layout, $linkPlaceable, $lastLineWidth + $spacing, $linkY, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(Placeable $tipsPlaceable, Placeable $linkPlaceable, int $spacing, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $tipsPlaceable, 0, 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.place$default($this$layout, $linkPlaceable, 0, $tipsPlaceable.getHeight() + $spacing, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }
}