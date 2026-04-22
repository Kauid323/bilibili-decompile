package kntr.app.tribee.consume.widget;

import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlexibleScrollableTabRow.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\b\u001a\u00020\tJ*\u0010\u0013\u001a\u00020\t*\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/consume/widget/ScrollableTabData;", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;)V", "selectedTab", "", "Ljava/lang/Integer;", "onLaidOut", "", "density", "Landroidx/compose/ui/unit/Density;", "edgeOffset", "tabPositions", "", "Lkntr/app/tribee/consume/widget/TabPosition;", "calculateTabOffset", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ScrollableTabData {
    private final CoroutineScope coroutineScope;
    private final ScrollState scrollState;
    private Integer selectedTab;

    public ScrollableTabData(ScrollState scrollState, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.scrollState = scrollState;
        this.coroutineScope = coroutineScope;
    }

    public final void onLaidOut(Density density, int edgeOffset, List<TabPosition> list, int selectedTab) {
        int calculatedOffset;
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(list, "tabPositions");
        Integer num = this.selectedTab;
        if (num == null || num.intValue() != selectedTab) {
            this.selectedTab = Integer.valueOf(selectedTab);
            TabPosition it = (TabPosition) CollectionsKt.getOrNull(list, selectedTab);
            if (it != null && this.scrollState.getValue() != (calculatedOffset = calculateTabOffset(it, density, edgeOffset, list))) {
                BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ScrollableTabData$onLaidOut$1$1(this, calculatedOffset, null), 3, (Object) null);
            }
        }
    }

    private final int calculateTabOffset(TabPosition $this$calculateTabOffset, Density density, int edgeOffset, List<TabPosition> list) {
        int totalTabRowWidth = density.roundToPx-0680j_4(((TabPosition) CollectionsKt.last(list)).m787getRightD9Ej5fM()) + edgeOffset;
        int visibleWidth = totalTabRowWidth - this.scrollState.getMaxValue();
        int tabOffset = density.roundToPx-0680j_4($this$calculateTabOffset.m786getLeftD9Ej5fM());
        int scrollerCenter = visibleWidth / 2;
        int tabWidth = density.roundToPx-0680j_4($this$calculateTabOffset.m788getWidthD9Ej5fM());
        int centeredTabOffset = tabOffset - (scrollerCenter - (tabWidth / 2));
        int availableSpace = RangesKt.coerceAtLeast(totalTabRowWidth - visibleWidth, 0);
        return RangesKt.coerceIn(centeredTabOffset, 0, availableSpace);
    }
}