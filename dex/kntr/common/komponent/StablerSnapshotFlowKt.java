package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: StablerSnapshotFlow.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"stablerSnapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "calculation", "Lkotlin/Function0;", "komponent_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class StablerSnapshotFlowKt {
    public static final <T> Flow<T> stablerSnapshotFlow(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        return FlowKt.distinctUntilChanged(FlowKt.conflate(FlowKt.channelFlow(new StablerSnapshotFlowKt$stablerSnapshotFlow$1(function0, null))));
    }
}