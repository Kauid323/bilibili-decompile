package kntr.app.game.base.event;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GameEventFlowWrapper.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"gameEventFlowWrapper", "Lkntr/app/game/base/event/GameEventFlowWrapper;", "getGameEventFlowWrapper", "()Lkntr/app/game/base/event/GameEventFlowWrapper;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameEventFlowWrapper_androidKt {
    private static final GameEventFlowWrapper gameEventFlowWrapper = new GameEventFlowWrapper() { // from class: kntr.app.game.base.event.GameEventFlowWrapper_androidKt$gameEventFlowWrapper$1
        private final Flow<KntrGameStatusEvent> eventFlow = GameEventFlowWrapperKt.buildGameEventFlow();

        @Override // kntr.app.game.base.event.GameEventFlowWrapper
        public Flow<KntrGameStatusEvent> getEventFlow() {
            return this.eventFlow;
        }
    };

    public static final GameEventFlowWrapper getGameEventFlowWrapper() {
        return gameEventFlowWrapper;
    }
}