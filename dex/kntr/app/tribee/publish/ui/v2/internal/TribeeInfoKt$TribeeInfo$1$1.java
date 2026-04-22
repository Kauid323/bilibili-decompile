package kntr.app.tribee.publish.ui.v2.internal;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInfo.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInfoKt$TribeeInfo$1$1 implements MeasurePolicy {
    public static final TribeeInfoKt$TribeeInfo$1$1 INSTANCE = new TribeeInfoKt$TribeeInfo$1$1();

    TribeeInfoKt$TribeeInfo$1$1() {
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
    public final MeasureResult m974measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, final long j) {
        int syncToFollowingWidth;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measureables");
        final int maxWidth = Constraints.getMaxWidth-impl(j);
        Measurable measurable = (Measurable) CollectionsKt.getOrNull(list, 1);
        final Placeable syncToFollowingPlaceable = measurable != null ? measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null)) : null;
        if (syncToFollowingPlaceable != null) {
            int syncToFollowingWidth2 = syncToFollowingPlaceable.getWidth();
            int minSpacerWidth = $this$Layout.roundToPx-0680j_4(Dp.constructor-impl(12));
            syncToFollowingWidth = syncToFollowingWidth2 + minSpacerWidth;
        } else {
            syncToFollowingWidth = 0;
        }
        int syncToFollowingFixedWidth = syncToFollowingWidth;
        final Placeable tribeeInfoPlaceable = list.get(0).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, Math.max(maxWidth - syncToFollowingFixedWidth, 0), 0, 0, 8, (Object) null));
        return MeasureScope.-CC.layout$default($this$Layout, maxWidth, Constraints.getMaxHeight-impl(j), (Map) null, new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInfoKt$TribeeInfo$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = TribeeInfoKt$TribeeInfo$1$1.measure_3p2s80s$lambda$0(tribeeInfoPlaceable, j, syncToFollowingPlaceable, maxWidth, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable $tribeeInfoPlaceable, long j, Placeable $syncToFollowingPlaceable, int $maxWidth, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default($this$layout, $tribeeInfoPlaceable, 0, (Constraints.getMaxHeight-impl(j) - $tribeeInfoPlaceable.getHeight()) / 2, 0.0f, 4, (Object) null);
        if ($syncToFollowingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$layout, $syncToFollowingPlaceable, $maxWidth - $syncToFollowingPlaceable.getWidth(), (Constraints.getMaxHeight-impl(j) - $syncToFollowingPlaceable.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}