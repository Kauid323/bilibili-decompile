package kntr.base.reachability;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IReachability.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/base/reachability/ReachabilityService;", "", "observe", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/reachability/NetWorkState;", "currentState", "reachability_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ReachabilityService {
    NetWorkState currentState();

    Flow<NetWorkState> observe();
}