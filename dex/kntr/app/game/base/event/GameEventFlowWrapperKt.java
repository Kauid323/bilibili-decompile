package kntr.app.game.base.event;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: GameEventFlowWrapper.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"buildGameEventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameEventFlowWrapperKt {
    public static final Flow<KntrGameStatusEvent> buildGameEventFlow() {
        return SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
    }
}