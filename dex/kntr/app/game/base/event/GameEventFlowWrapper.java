package kntr.app.game.base.event;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GameEventFlowWrapper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/game/base/event/GameEventFlowWrapper;", RoomRecommendViewModel.EMPTY_CURSOR, "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "getEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GameEventFlowWrapper {
    Flow<KntrGameStatusEvent> getEventFlow();
}