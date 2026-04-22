package kntr.app.game.base.event;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: GameEventHub.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0007J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0016\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020\bH\u0086\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkntr/app/game/base/event/GameEventHub;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/app/game/base/event/Event;", "get_events$annotations", "get_events", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "_replayableEvents", "get_replayableEvents$annotations", "get_replayableEvents", "emit", RoomRecommendViewModel.EMPTY_CURSOR, "event", "(Lkntr/app/game/base/event/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", RoomRecommendViewModel.EMPTY_CURSOR, "subscribeEvents", "Lkotlinx/coroutines/flow/Flow;", "subscribe", "T", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameEventHub {
    private static final String TAG = "GameEventHub";
    public static final GameEventHub INSTANCE = new GameEventHub();
    private static final MutableSharedFlow<Event> _events = SharedFlowKt.MutableSharedFlow(0, 12, BufferOverflow.DROP_OLDEST);
    private static final MutableSharedFlow<Event> _replayableEvents = SharedFlowKt.MutableSharedFlow(1, 12, BufferOverflow.DROP_OLDEST);
    public static final int $stable = 8;

    public static /* synthetic */ void get_events$annotations() {
    }

    public static /* synthetic */ void get_replayableEvents$annotations() {
    }

    private GameEventHub() {
    }

    public final MutableSharedFlow<Event> get_events() {
        return _events;
    }

    public final MutableSharedFlow<Event> get_replayableEvents() {
        return _replayableEvents;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|8|14|15))|30|6|7|8|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
        kntr.base.log.KLog_androidKt.getKLog().e(kntr.app.game.base.event.GameEventHub.TAG, "Failed to emit event: " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8.getClass()).getSimpleName(), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Event event, Continuation<? super Unit> continuation) {
        GameEventHub$emit$1 gameEventHub$emit$1;
        if (continuation instanceof GameEventHub$emit$1) {
            gameEventHub$emit$1 = (GameEventHub$emit$1) continuation;
            if ((gameEventHub$emit$1.label & Integer.MIN_VALUE) != 0) {
                gameEventHub$emit$1.label -= Integer.MIN_VALUE;
                Object $result = gameEventHub$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gameEventHub$emit$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (event instanceof ReplayableEvent) {
                            MutableSharedFlow<Event> mutableSharedFlow = _replayableEvents;
                            gameEventHub$emit$1.L$0 = event;
                            gameEventHub$emit$1.label = 1;
                            if (mutableSharedFlow.emit(event, gameEventHub$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        } else {
                            MutableSharedFlow<Event> mutableSharedFlow2 = _events;
                            gameEventHub$emit$1.L$0 = event;
                            gameEventHub$emit$1.label = 2;
                            if (mutableSharedFlow2.emit(event, gameEventHub$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        Event event2 = (Event) gameEventHub$emit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        Event event3 = (Event) gameEventHub$emit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        gameEventHub$emit$1 = new GameEventHub$emit$1(this, continuation);
        Object $result2 = gameEventHub$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gameEventHub$emit$1.label) {
        }
        return Unit.INSTANCE;
    }

    public final boolean tryEmit(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ReplayableEvent) {
            return _replayableEvents.tryEmit(event);
        }
        return _events.tryEmit(event);
    }

    public final Flow<Event> subscribeEvents() {
        return FlowKt.merge(new Flow[]{_events, _replayableEvents});
    }

    public final /* synthetic */ <T extends Event> Flow<T> subscribe() {
        Flow $this$filter$iv = FlowKt.merge(new Flow[]{get_events(), get_replayableEvents()});
        Intrinsics.needClassReification();
        Flow $this$map$iv = new GameEventHub$subscribe$$inlined$filter$1($this$filter$iv);
        Intrinsics.needClassReification();
        return new GameEventHub$subscribe$$inlined$map$1($this$map$iv);
    }
}