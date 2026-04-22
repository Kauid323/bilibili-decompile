package kntr.app.game.gamebind;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: GameBindEventStore.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkntr/app/game/gamebind/GameBindEventStore;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/app/game/gamebind/GameBindEvent;", "bindEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getBindEvent$annotations", "getBindEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "post", RoomRecommendViewModel.EMPTY_CURSOR, "event", "(Lkntr/app/game/gamebind/GameBindEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameBindEventStore {
    public static final GameBindEventStore INSTANCE = new GameBindEventStore();
    private static final MutableSharedFlow<GameBindEvent> events = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 4, (Object) null);
    private static final SharedFlow<GameBindEvent> bindEvent = FlowKt.asSharedFlow(events);

    public static /* synthetic */ void getBindEvent$annotations() {
    }

    private GameBindEventStore() {
    }

    public final SharedFlow<GameBindEvent> getBindEvent() {
        return bindEvent;
    }

    public final Object post(GameBindEvent event, Continuation<? super Unit> continuation) {
        KLog_androidKt.getKLog().d("RolesListPage", "store.post: " + event);
        Object emit = events.emit(event, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}